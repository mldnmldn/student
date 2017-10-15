<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/pages/plugins/back/back_header.jsp"/>
<%!
	public static final String AUDIT_SCHEDULE_LIST_URL = "pages/back/admin/audit/audit_schedule_list.jsp" ;
	public static final String AUDIT_SCHEDULE_APPLY_URL = "pages/back/admin/audit/audit_schedule_apply.jsp" ;
%>
<script type="text/javascript" src="js/pages/back/admin/travel/travel_list_audit.js"></script>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- 导入头部标题栏内容 --> 
		<jsp:include page="/pages/plugins/back/include_title_head.jsp" />
		<!-- 导入左边菜单项 -->
		<jsp:include page="/pages/plugins/back/include_menu_item.jsp">
			<jsp:param name="mi" value="4"/>
			<jsp:param name="msi" value="42"/>
		</jsp:include>
		<div class="content-wrapper text-left">
			<div class="panel panel-success">
				<div class="panel-heading">
					<strong><span class="glyphicon glyphicon-list"></span>&nbsp;调度审核列表</strong>
				</div>
				<div class="panel-body">
					<div>
						<jsp:include page="/pages/plugins/split_plugin_search_bar.jsp"/>
					</div>
					<table class="table table-condensed">
						<thead>
							<tr>
								<th class="text-center"><strong>状态</strong></th>
								<th class="text-center"><strong>申请标题</strong></th>
								<th class="text-center"><strong>申请日期</strong></th>
								<th class="text-center"><strong>任务日期</strong></th>
								<th class="text-center"><strong>调度人数</strong></th>
								<th class="text-center"><strong>操作</strong></th>
							</tr>
						</thead>
						<tbody>
							<tr id="travel-1">
								<td class="text-center"><span class="text-danger"><span class="glyphicon glyphicon-flag"></span>&nbsp;已完成</span></td>
								<td class="text-center">
									<a id="showBtn-1" onmouseover="this.style.cursor='hand'" href="<%=AUDIT_SCHEDULE_APPLY_URL%>">XX公司CRM项目</a>
								</td>
								<td class="text-center">2018-10-10</td>
								<td class="text-center">2018-10-10</td>
								<td class="text-center">20人</td>
								<td class="text-center">
									<a type="button" class="btn btn-primary btn-xs" href="<%=AUDIT_SCHEDULE_APPLY_URL%>">
										<span class="glyphicon glyphicon-cloud-upload"></span>&nbsp;处理申请</a>
								</td>
							</tr> 
							<tr id="travel-2">
								<td class="text-center"><span class="text-warning"><span class="glyphicon glyphicon-flag"></span>&nbsp;进行中</span></td>
								<td class="text-center">
									<a id="showBtn-2" onmouseover="this.style.cursor='hand'" href="<%=AUDIT_SCHEDULE_APPLY_URL%>">XX公司CRM项目</a>
								</td>
								<td class="text-center">2018-10-10</td>
								<td class="text-center">2018-10-10</td>
								<td class="text-center">20人</td>
								<td class="text-center">
									<a type="button" class="btn btn-primary btn-xs" href="<%=AUDIT_SCHEDULE_APPLY_URL%>">
										<span class="glyphicon glyphicon-cloud-upload"></span>&nbsp;处理申请</a>
								</td>
							</tr> 
							<tr id="travel-3">
								<td class="text-center"><span class="text-primary"><span class="glyphicon glyphicon-flag"></span>&nbsp;待提交</span></td>
								<td class="text-center">
									<a id="showBtn-3" onmouseover="this.style.cursor='hand'" href="<%=AUDIT_SCHEDULE_APPLY_URL%>">XX公司CRM项目</a>
								</td>
								<td class="text-center">2018-10-10</td>
								<td class="text-center">2018-10-10</td>
								<td class="text-center">20人</td>
								<td class="text-center">
									<a type="button" class="btn btn-primary btn-xs" href="<%=AUDIT_SCHEDULE_APPLY_URL%>">
										<span class="glyphicon glyphicon-cloud-upload"></span>&nbsp;处理申请</a>
								</td>
							</tr> 
						</tbody>
					</table>
					<div id="splitBarDiv" style="float:right">
						<jsp:include page="/pages/plugins/split_plugin_page_bar.jsp"/> 
					</div>
				</div>
				<div class="panel-footer">
					<jsp:include page="/pages/plugins/include_alert.jsp"/>
				</div>
			</div>
		</div>
		<!-- 导入公司尾部认证信息 -->
		<jsp:include page="/pages/plugins/back/include_title_foot.jsp" />
		<!-- 导入右边工具设置栏 -->
		<jsp:include page="/pages/plugins/back/include_menu_sidebar.jsp" />
		<div class="control-sidebar-bg"></div>
	</div>
	<jsp:include page="/pages/plugins/back/include_javascript_foot.jsp" />
<jsp:include page="/pages/plugins/back/back_footer.jsp"/>
