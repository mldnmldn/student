package cn.mldn.eusplatform.service.back;

import java.sql.SQLException;
import java.util.Map;

import cn.mldn.eusplatform.vo.Schedule;


public interface ISchedulleServiceBack {
	/**
	 * 进行调度申请表的列表显示，带分页
	 * @return Map集合
	 * @throws SQLException
	 */
	public Map<String,Object> list(String column, String keyWord, Long currentPage, Integer lineSize) throws Exception;
	public boolean add(Schedule vo) throws SQLException;
}
