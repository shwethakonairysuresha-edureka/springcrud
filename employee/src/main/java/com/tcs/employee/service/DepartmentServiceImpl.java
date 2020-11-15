package com.tcs.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.employee.dao.DepartmentDAO;
import com.tcs.employee.dao.DepartmentDAOImpl;
import com.tcs.employee.model.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
//	private DepartmentServiceImpl()
//	{
//	}
//	
//	private static DepartmentService dao;
//	
//	public static DepartmentService getInstance()
//	{
//		if(dao == null)
//		{
//			dao = new DepartmentServiceImpl();
//			return dao;
//		}
//		return dao;
//	}
	
	@Autowired
	private DepartmentDAO departmentDao;

	@Override
	public String addDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentDao.addDepartment(department);
	}

	@Override
	public String updateDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentDao.updateDepartment(department);
	}

	@Override
	public String deleteDepartment(int id) {
		// TODO Auto-generated method stub
		return departmentDao.deleteDepartment(id);
	}

	@Override
	public Optional<Department> findById(int id) {
		// TODO Auto-generated method stub
		return departmentDao.findById(id);
	}

	@Override
	public Optional<List<Department>> getDepartments() {
		// TODO Auto-generated method stub
		return departmentDao.getDepartments();
	}

	@Override
	public Optional<List<Department>> findByOrganizationId(int id) {
		// TODO Auto-generated method stub
		return departmentDao.findByOrganizationId(id);
	}

}
