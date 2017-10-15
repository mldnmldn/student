package cn.mldn.eusplatform.service.back.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import cn.mldn.eusplatform.dao.IScheduleDAO;
import cn.mldn.eusplatform.service.back.ISchedulleServiceBack;
import cn.mldn.eusplatform.vo.Schedule;
import cn.mldn.util.factory.Factory;
import cn.mldn.util.service.abs.AbstractService;
import cn.mldn.util.web.ServletObjectUtil;

public class SchedulleServiceBackimpl extends AbstractService implements ISchedulleServiceBack {

	@Override
	public Map<String, Object> list(String column, String keyWord, Long currentPage, Integer lineSize) throws Exception{
		Map<String, Object> map = new HashMap<>();
		IScheduleDAO is = Factory.getDAOInstance("schedule.dao");
		
		if(!(super.isLikeSearch(keyWord) && super.isLikeSearch(column))){
			map.put("allSchedule", is.findAll(currentPage, lineSize));
			map.put("allRecorders", is.getAllCount());
		}else{
			map.put("allSchedule", is.findSplit(column, keyWord, currentPage, lineSize));
			map.put("allRecorders", is.getSplitCount(column, keyWord));
		}
		return map;
	}

	@Override
	public boolean add(Schedule vo) throws SQLException {
		String seid = (String)ServletObjectUtil.getRequest().getSession().getAttribute("eid");
		vo.setSeid(seid);
		vo.setAudit(0);
		IScheduleDAO is = Factory.getDAOInstance("schedule.dao");
		System.out.println(is);
		boolean flag = is.doCreate(vo);
		System.out.println(flag);
		return flag;
	}

}
