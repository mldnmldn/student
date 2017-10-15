package cn.mldn.eusplatform.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import cn.mldn.eusplatform.dao.IIScheduleDAO;
import cn.mldn.eusplatform.vo.Emp;
import cn.mldn.eusplatform.vo.Schedule;
import cn.mldn.eusplatform.vo.ScheduleEmp;
import cn.mldn.util.dao.abs.AbstractDAO;

public class ScheduleDAOImpll extends AbstractDAO implements IIScheduleDAO {

	@Override
	public boolean doCreate(Schedule vo) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO schedule (seid,aeid,iid,title,sdate,subdate,audit,note,ecount) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, vo.getSeid());
		super.pstmt.setString(2, vo.getAeid());
		super.pstmt.setLong(3, vo.getIid());
		super.pstmt.setString(4, vo.getTitle());
		if(vo.getSdate() == null) {
			super.pstmt.setDate(5 , null);
		}else {
			super.pstmt.setDate(5 , new java.sql.Date(vo.getSdate().getTime()));
		}
		super.pstmt.setDate(6, new java.sql.Date(vo.getSubdate().getTime()));
		super.pstmt.setInt(7, vo.getAudit());
		super.pstmt.setString(8, vo.getNote());
		super.pstmt.setInt(9, vo.getEcount());
		return super.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doEdit(Schedule vo) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<Long> ids) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Schedule findById(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Schedule> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Schedule> findAll(Long currentPage, Integer lineSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Schedule> findSplit(String column, String keyWord, Long currentPage, Integer lineSize)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getSplitCount(String column, String keyWord) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean doCreateScheduleEmp(ScheduleEmp vo) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO schedule_emp (sid,eid) VALUES (?,?)";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setLong(1, vo.getSid());
		super.pstmt.setString(2, vo.getEid());
		return super.pstmt.executeUpdate()>0;
	}

	@Override
	public List<Emp> findAllScheduleEmp(String eid) throws SQLException {
		// TODO Auto-generated method stub
		List<Emp> all = new ArrayList<>();
		String sql = "SELECT e.eid,e.lid,e.did,e.ename,e.photo FROM emp e right join schedule_emp s on e.eid=s.eid WHERE s.eid=?";
		super.pstmt = super.conn.prepareStatement(sql);
		super.pstmt.setString(1, eid);
		ResultSet rs = super.pstmt.executeQuery();
		while(rs.next()) {
			Emp vo = new Emp();
			vo.setEid(rs.getString(1));
			vo.setLid(rs.getLong(2));
			vo.setDid(rs.getLong(3));
			vo.setEname(rs.getString(4));
			vo.setPhoto(rs.getString(5));
			all.add(vo);
		}
		return all;
	}

}
