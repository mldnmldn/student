package cn.mldn.eusplatform.service;

import cn.mldn.eusplatform.dao.IScheduleDAO;
import cn.mldn.eusplatform.service.back.ISchedulleServiceBack;
import cn.mldn.util.factory.Factory;

public class Test {
	public static void main(String[] args) {
//		IScheduleDAO is = Factory.getDAOInstance("schedule.dao");
		ISchedulleServiceBack is = Factory.getServiceInstance("schedule.service.back");
		try {
			System.out.println(is.list("", "", 1L, 2));
//			System.out.println(is.findAll(1L, 2).size());
//			System.out.println(is.getAllCount());
//			System.out.println(is.getSplitCount("", ""));
//			System.out.println(is.findSplit("", "", 1L, 2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
