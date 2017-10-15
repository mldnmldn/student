package cn.mldn.eusplatform.service.back;

import java.util.List;
import java.util.Map;

import cn.mldn.eusplatform.vo.Emp;
import cn.mldn.eusplatform.vo.Item;
import cn.mldn.eusplatform.vo.Schedule;
import cn.mldn.eusplatform.vo.ScheduleEmp;

public interface IIScheduleServiceBack {

	/**
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean add(Schedule vo) throws Exception; 
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Item> findAllItem() throws Exception;
	
	/**
	 * 增加调度信息
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public boolean addScheduleEmp(ScheduleEmp vo) throws Exception;
	
	
	
	public Map<String, Object> findScheduleEmp(String eid) throws Exception;
}
