package cn.mldn.eusplatform.service.back.impl;

import java.util.HashMap;
import java.util.Map;

import cn.mldn.eusplatform.dao.IActionDAO;
import cn.mldn.eusplatform.dao.IEmpDAO;
import cn.mldn.eusplatform.dao.IRoleDAO;
import cn.mldn.eusplatform.service.back.IEmpServiceBack;
import cn.mldn.eusplatform.vo.Emp;
import cn.mldn.util.factory.Factory;
import cn.mldn.util.service.abs.AbstractService;

public class EmpServiceBackImpl extends AbstractService implements IEmpServiceBack {

	@Override
	public Map<String, Object> login(Emp emp) throws Exception {
		Map<String, Object> result = new HashMap<String, Object>() ;
		IEmpDAO empDAO = Factory.getDAOInstance("emp.dao") ;
		Emp selectEmp = empDAO.findById(emp.getEid()) ;	// 根据雇员编号查询雇员信息
		result.put("emp", selectEmp) ;	// 设置查询出来的雇员信息
		if (selectEmp != null) {	// 雇员登录成功
			IRoleDAO roleDAO = Factory.getDAOInstance("role.dao") ;	// 获取角色信息
			IActionDAO actionDAO = Factory.getDAOInstance("action.dao") ;	// 获取权限信息
			result.put("allRoles", roleDAO.findAllByDept(selectEmp.getDid())) ;	// 根据部门编号查询角色信息
			result.put("allActions", actionDAO.findAllByDept(selectEmp.getDid())) ;
		}
		return result ;
	}

}
