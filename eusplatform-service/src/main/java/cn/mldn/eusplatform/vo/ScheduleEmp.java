package cn.mldn.eusplatform.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ScheduleEmp implements Serializable {
	private String seid ;
	private Long sid ;
	private String eid ;
	public Long getSid() {
		return sid;
	}
	public void setSid(Long sid) {
		this.sid = sid;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getSeid() {
		return seid;
	}
	public void setSeid(String seid) {
		this.seid = seid;
	}
	@Override
	public String toString() {
		return "ScheduleEmp [seid=" + seid + ", sid=" + sid + ", eid=" + eid + "]";
	}
	
}
