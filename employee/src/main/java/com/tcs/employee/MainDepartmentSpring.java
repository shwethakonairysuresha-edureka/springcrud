package com.tcs.employee;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.employee.config.DBConfig;
import com.tcs.employee.model.Department;
import com.tcs.employee.model.Employee;
import com.tcs.employee.service.DepartmentService;
import com.tcs.employee.service.EmployeeService;

public class MainDepartmentSpring {

	public static void displayMenu(int opts[], String items[])
	{
		//Display Menu
		System.out.println("MENU");
		System.out.println("------");
		for(int i = 0;i<opts.length;i++)
		{
			System.out.printf("%d. %s\n", opts[i], items[i]);
		}
		System.out.println("-------");
		System.out.println("Enter Choice: ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//User Choice
		int choice;
		int options[] = {1, 2, 3, 4, 5, 6, 7};
		String menuItems[] = {"Add Department", "Update Department", "Delete Department", "Find By Id", "Get Departments", "Find By OrganizationId", "EXIT"};
		int exit = options[options.length-1];
		
		//Display Menu
		displayMenu(options, menuItems);
		
		//Set up Scanner
		Scanner in = new Scanner(System.in);
		
		//Get choice from user
		choice = in.nextInt();
		
		//Check choice value
		while(choice != exit)
		{
			if(choice == options[0])
			{
				System.out.println("Add Department");
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
				DepartmentService departmentService = context.getBean(DepartmentService.class);
				Department department = new Department(3, 03, "Physics", null);
				String result = departmentService.addDepartment(department);
				System.out.println(result);
				context.close();
			}
			else if(choice == options[1])
			{
				System.out.println("Update Department");
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
				DepartmentService departmentService = context.getBean(DepartmentService.class);
				Department department = new Department(3, 03, "Maths", null);
				String result = departmentService.updateDepartment(department);
				System.out.println(result);
				context.close();
			}
			else if(choice == options[2])
			{
				System.out.println("Delete Department");
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
				DepartmentService departmentService = context.getBean(DepartmentService.class);
				String result = departmentService.deleteDepartment(3);
				System.out.println(result);
				context.close();
			}
			else if(choice == options[3])
			{
				System.out.println("Find By Id");
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
				DepartmentService departmentService = context.getBean(DepartmentService.class);
				Optional<Department> result = departmentService.findById(1);
				System.out.println(result);
				context.close();
			}
			else if(choice == options[4])
			{
				System.out.println("Get Departments");
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
				DepartmentService departmentService = context.getBean(DepartmentService.class);
				Optional<List<Department>> result = departmentService.getDepartments();
				System.out.println(result);
				context.close();
			}
			else if(choice == options[5])
			{
				System.out.println("Find By OrganizationId");
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
				DepartmentService departmentService = context.getBean(DepartmentService.class);
				Optional<List<Department>> result = departmentService.findByOrganizationId(1);
				System.out.println(result);
				context.close();
			}
			
			//Display Menu
			displayMenu(options, menuItems);
			
			//Get choice from user
			choice = in.nextInt();
		}
		System.out.println("GoodBye!");
	}	
}
