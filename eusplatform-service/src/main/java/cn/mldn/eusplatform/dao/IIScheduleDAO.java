package cn.mldn.eusplatform.dao;

import java.sql.SQLException;
import java.util.List;

import cn.mldn.eusplatform.vo.Emp;
import cn.mldn.eusplatform.vo.Schedule;
import cn.mldn.eusplatform.vo.ScheduleEmp;
import cn.mldn.util.dao.IBaseDAO;

public interface IIScheduleDAO extends IBaseDAO<Long, Schedule> {

	public boolean doCreateScheduleEmp(ScheduleEmp vo) throws SQLException ;
	
	public List<Emp> findAllScheduleEmp(String eid) throws SQLException ;
}
