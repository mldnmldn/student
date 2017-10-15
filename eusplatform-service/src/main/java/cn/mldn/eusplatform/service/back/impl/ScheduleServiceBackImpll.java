package cn.mldn.eusplatform.service.back.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.mldn.eusplatform.dao.IDeptDAO;
import cn.mldn.eusplatform.dao.IEmpDAO;
import cn.mldn.eusplatform.dao.IIScheduleDAO;
import cn.mldn.eusplatform.dao.IItemDAO;
import cn.mldn.eusplatform.dao.ILevelDAO;
import cn.mldn.eusplatform.service.back.IIScheduleServiceBack;
import cn.mldn.eusplatform.vo.Item;
import cn.mldn.eusplatform.vo.Schedule;
import cn.mldn.eusplatform.vo.ScheduleEmp;
import cn.mldn.util.factory.Factory;
import cn.mldn.util.web.ServletObjectUtil;

public class ScheduleServiceBackImpll implements IIScheduleServiceBack {
	@Override
	public boolean add(Schedule vo) throws Exception {
		// TODO Auto-generated method stub
		IIScheduleDAO scheduleDAO = Factory.getDAOInstance("schedulee.dao");
		String seid = (String) ServletObjectUtil.getRequest().getSession().getAttribute("eid");//申请人id
		vo.setSeid(seid);
		vo.setSubdate(new Date());//申请日期
		vo.setAudit(0);
		vo.setEcount(1);//第一次申请员工的人数
		return scheduleDAO.doCreate(vo);
	}

	@Override
	public List<Item> findAllItem() throws Exception {
		IItemDAO itemDAO = Factory.getDAOInstance("item.dao");
		return itemDAO.findAll();
	}

	@Override
	public boolean addScheduleEmp(ScheduleEmp vo) throws Exception {
		// TODO Auto-generated method stub
		String seid = (String) ServletObjectUtil.getRequest().getSession().getAttribute("eid");
		vo.setSeid(seid);
		IIScheduleDAO scheduleDAO = Factory.getDAOInstance("schedulee.dao");
		return scheduleDAO.doCreateScheduleEmp(vo);
	}

	@Override
	public Map<String, Object> findScheduleEmp(String eid) throws Exception {
		
		Map<String,Object> map = new HashMap<String,Object>();
		IDeptDAO deptDAO = Factory.getDAOInstance("dept.dao") ;
		ILevelDAO levelDAO = Factory.getDAOInstance("level.dao") ;
		IEmpDAO empDAO = Factory.getDAOInstance("emp.dao") ;
		IIScheduleDAO scheduleDAO = Factory.getDAOInstance("schedulee.dao");
		map.put("allDeptMap", deptDAO.findAllMap());
		map.put("allLevelMap", levelDAO.findAllLevel());
		map.put("allScheduleEmps", scheduleDAO.findAllScheduleEmp(eid));
		map.put("emp", empDAO.findById(eid));
		return map;
	}

}
