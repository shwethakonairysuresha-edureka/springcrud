package com.tcs.employee.service;

import java.util.List;
import java.util.Optional;

import com.tcs.employee.dao.EmployeeDAO;
import com.tcs.employee.dao.EmployeeDAOImpl;
import com.tcs.employee.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeServiceImpl()
	{
	}
	
	private static EmployeeService dao;
	
	public static EmployeeService getInstance()
	{
		if(dao == null)
		{
			dao = new EmployeeServiceImpl();
			return dao;
		}
		return dao;
	}
	
	EmployeeDAO employeeDao = EmployeeDAOImpl.getInstance();
	
	@Override
	public String addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.addEmployee(employee);
	}

	@Override
	public String updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.updateEmployee(employee);
	}

	@Override
	public String deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return employeeDao.deleteEmployee(id);
	}

	@Override
	public Optional<Employee> findById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.findById(id);
	}

	@Override
	public Optional<List<Employee>> getEmployees() {
		// TODO Auto-generated method stub
		return employeeDao.getEmployees();
	}

	@Override
	public Optional<List<Employee>> findByOrganizationId(int id) {
		// TODO Auto-generated method stub
		return employeeDao.findByOrganizationId(id);
	}

}
