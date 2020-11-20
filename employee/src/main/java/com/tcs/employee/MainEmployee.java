package com.tcs.employee;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.employee.config.DBConfig;
import com.tcs.employee.model.Department;
import com.tcs.employee.model.Employee;
import com.tcs.employee.repository.DepartmentRepository;
import com.tcs.employee.repository.EmployeeRepository;

public class MainEmployee {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		
		EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
		DepartmentRepository departmentRepository = context.getBean(DepartmentRepository.class);
		
		Employee employee = new Employee(1, 01, 001, "Naruto", 24, "Associate", null);
		employeeRepository.save(employee);
		
		departmentRepository.save(new Department(2, 02, "Naruto", employee, null));
		departmentRepository.save(new Department(3, 03, "Sasuke", employee, null));
		departmentRepository.save(new Department(4, 04, "Sakura", employee, null));
		context.close();
	}

}
