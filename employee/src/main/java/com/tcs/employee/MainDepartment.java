package com.tcs.employee;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.employee.config.DBConfig;
import com.tcs.employee.model.Department;
import com.tcs.employee.model.Organization;
import com.tcs.employee.repository.OrganizationRepository;
import com.tcs.employee.service.DepartmentService;

public class MainDepartment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		
		OrganizationRepository organizationRepository = context.getBean(OrganizationRepository.class);
		DepartmentService service = context.getBean(DepartmentService.class);
		Set<Organization> organizations = new HashSet<>();
		Organization organization = new Organization();
		organization.setName("XYZ");
		organization.setAddress("123 Main Road");
		
		Organization organization2 = new Organization();
		organization.setName("ABC");
		organization.setAddress("456 Main St");
		
		organizationRepository.save(organization);
		organizationRepository.save(organization2);
		
		organizations.add(organization);
		organizations.add(organization2);
		
		Department department = new Department(1, 01, "Biology", null, organizations);
		
		String result = service.registerDepartment(department);
		System.out.println(result);
		context.close();
	}

}
