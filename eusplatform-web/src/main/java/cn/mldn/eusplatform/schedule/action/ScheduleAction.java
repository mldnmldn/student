package cn.mldn.eusplatform.schedule.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import cn.mldn.eusplatform.service.back.IIScheduleServiceBack;
import cn.mldn.eusplatform.vo.Emp;
import cn.mldn.eusplatform.vo.Item;
import cn.mldn.eusplatform.vo.Schedule;
import cn.mldn.eusplatform.vo.ScheduleEmp;
import cn.mldn.eusplatform.vo.ScheduleEmpEmp;
import cn.mldn.util.JsonUtil;
import cn.mldn.util.action.ActionResourceUtil;
import cn.mldn.util.action.abs.AbstractAction;
import cn.mldn.util.factory.Factory;
import cn.mldn.util.web.ModelAndView;
import cn.mldn.util.web.ServletObjectUtil;

public class ScheduleAction extends AbstractAction {

	private static final String ACTION_TITLE = "调度";
	
	public ModelAndView add(Schedule vo) throws Exception {
		ModelAndView mav = new ModelAndView(ActionResourceUtil.getPage("forward.page"));
		IIScheduleServiceBack scheduleService = Factory.getServiceInstance("schedule.service");
		if(scheduleService.add(vo)) {
			super.setUrlAndMsg(mav, "schedule.add.action", "vo.add.success",ACTION_TITLE );
		}else {
			super.setUrlAndMsg(mav, "schedule.add.action", "vo.add.failure",ACTION_TITLE );
		}
		return mav;
	}
	
	public void loadItem() throws Exception {
		IIScheduleServiceBack scheduleService = Factory.getServiceInstance("schedule.service");
		List<Item> allItem = scheduleService.findAllItem();
		List<String> allJSON = new ArrayList<String>();
		Iterator<Item> iter=allItem.iterator();
		while(iter.hasNext()) {
			allJSON.add(JsonUtil.toJson(iter.next()));
		}
		super.print(allJSON);
	}
	
	public void addScheduleEmp(ScheduleEmp vo) throws Exception{
		IIScheduleServiceBack scheduleService = Factory.getServiceInstance("schedule.service");
		System.out.println(vo.toString());
		super.print(scheduleService.addScheduleEmp(vo));
	}
	
	@SuppressWarnings("unchecked")
	public void loadScheduleEmp(String eid) throws Exception {
		IIScheduleServiceBack scheduleService = Factory.getServiceInstance("schedule.service");
		try {
			Map<String,Object> map = scheduleService.findScheduleEmp(eid);
			List<Emp> allEmp = (List<Emp>) map.get("allScheduleEmps");
			Map<Long, String> allDeptMap = (Map<Long, String>) map.get("allDeptMap");
			Map<Long, String> allLevelMap = (Map<Long, String>) map.get("allLevelMap");
			List<String> allJSON = new ArrayList<String>();
			Iterator<Emp> iter=allEmp.iterator();
			while(iter.hasNext()) {
				Emp vo = iter.next();
				ScheduleEmpEmp empvo = new ScheduleEmpEmp();
				empvo.setEmpno(vo.getEid());
				empvo.setEname(vo.getEname());
				empvo.setPhoto(vo.getPhoto());
				empvo.setDeptTitle(allDeptMap.get(vo.getDid()));
				empvo.setLevelTitle(allLevelMap.get(vo.getLid()));
				allJSON.add(JsonUtil.toJson(empvo));
			}
			ServletObjectUtil.getResponse().setCharacterEncoding("UTF-8");
			ServletObjectUtil.getResponse().setContentType("application/json");
			ServletObjectUtil.getResponse().getWriter().print(allJSON);
			System.out.println(allJSON.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ModelAndView loadScheduleEmpEmp(String eid) throws Exception {
		ModelAndView mav = new ModelAndView(ActionResourceUtil.getPage("emp.scheduleEmp.page"));
		IIScheduleServiceBack scheduleService = Factory.getServiceInstance("schedule.service");
		try {
			Map<String,Object> map = scheduleService.findScheduleEmp(eid);
			mav.addObjectMap(map);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
}
