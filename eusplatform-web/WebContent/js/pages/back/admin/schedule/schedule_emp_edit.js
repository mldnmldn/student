$(function(){
	$("button[id^=remove-]").each(function(){
		eid = this.id.substring(this.id.indexOf("-") + 1,this.id.lastIndexOf("-")) ;
		tid = this.id.substring(this.id.lastIndexOf("-") + 1) ;
		$(this).on("click",function(){
			deleteEmpFun(eid,tid) ;
		})
	}) ;
	$("#did").on("change",function(){
		did = $(this).val() ;
		loadEmpSchedule(did);
	}) ;
	$(addBtn).on("click",function(){
		 $("#did option").remove();
		 $("#empSchedule").find("tr").remove();
		 $.post("EmpBackAction!loadDept.action",{ },function(data){
			 $("#did").append("<option value=>====== 请选择雇员所在部门 ======</option>");
			 for(var x=0 ;x<data.length;x++){
				 $("#did").append("<option value='"+data[x].did+"'>" + data[x].dname + "</option>") ;
			  }
		 },"json");
		$("#userInfo").modal("toggle") ;	// 显示模态窗口
	}) ;
})
function loadEmpSchedule(did){
	  $("#empSchedule").find("tr").remove();
	  $.post("EmpBackAction!loadSchedule.action",{"did":did},function(data){
		  $("#empSchedule").find("tr").remove();
		  for(var x=0 ;x<data.length;x++){
			var str = "<tr id='travel-"+data[x].eid+"'>" +
					"<td class='text-center'><img src='upload/emp/"+data[x].photo+"' style='width:20px';/></td>" +
					"<td class='text-center'>"+data[x].eid+"</td>" +
					"<td class='text-center'>"+data[x].ename+"</td>" +
					"<td class='text-center'>"+data[x].levelTitle+"</td>" +
					"<td class='text-center'>"+data[x].deptTitle+"</td>" +
					"<td class='text-center'>" +
					"<button class='btn btn-danger btn-xs' id='remove-"+data[x].eid+"'>" +
					"<span id='spanDiv-"+data[x].eid+"' class='glyphicon glyphicon-plus-sign'></span>&nbsp;增加" +
					
					"</button>" +
					"</td>" +
					"</tr>";
			$("#empSchedule").append($(str));
			$("button[id^=remove-"+data[x].eid+"]").each(function(){
				var eid = this.id.split("-")[1];
				var sid = 1 ;
				$(this).on("click",function(){
					$.post("pages/back/admin/schedule/ScheduleAction!addScheduleEmp.action",{"eid":eid,"sid":sid},function(data){
						var flag = data.trim()=="true" ;
						operateAlert(flag,"人员派遣成功！","人员派遣失败！") ;
						if(flag){
							deleteSchedule(eid);
							//loadSchudelEmp(eid);
			    	    }
			       },"text");
				})
			}) ;
		  }
	    },"json") ;
	 
}

function deleteSchedule(eid) {
	$("tr[id='travel-"+eid+"']").remove() ;
}
function loadSchudelEmp(eid){
	$.post("pages/back/admin/schedule/ScheduleAction!loadScheduleEmp.action",{"eid":eid},function(data){
	     for(var x=0; x<data.length; x++){
	    	 str = "<tr id='travel-"+eid+"'>" +
	    	 		"<td class='text-center'><img src='upload/emp/"+data[x].photo+"' style='width:20px;'/></td>" +
	    	 		"<td class='text-center'>"+data[x].empno+"</td>" +
	    	 		"<td class='text-center'>"+data[x].ename+"</td>" +
	    	 		"<td class='text-center'>"+data[x].levelTitle+"</td>" +
	    	 		"<td class='text-center'>"+data[x].deptTitle+"</td>" +
	    	 		"<td class='text-center'>" +
	    	 		"<button class='btn btn-danger btn-xs' id='remove-"+data[x].enpno+"'>" +
	    	 		"<span class='glyphicon glyphicon-remove'></span>&nbsp;移除</button>" +
	    	 		"</td>" +
	    	 		"</tr>";
	    	 $("#splitSchedule").append($(str));
	     }
   },"json")
}

