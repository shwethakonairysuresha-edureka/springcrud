package com.tcs.employee;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.employee.config.DBConfig;
import com.tcs.employee.model.Employee;
import com.tcs.employee.service.EmployeeService;
import com.tcs.employee.service.EmployeeServiceImpl;

public class MainEmployeeSpring {

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
		String menuItems[] = {"Add Emlopyee", "Update Emlopyee", "Delete Emlopyee", "Find By Id", "Get Employees", "Find By OrganizationId", "EXIT"};
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
				System.out.println("Add Emlopyee");
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
				EmployeeService employeeService = context.getBean(EmployeeService.class);
				Employee employee = new Employee(5, 05, 005, "Shinchan", 26, "Intern");
				String result = employeeService.addEmployee(employee);
				System.out.println(result);
				context.close();
			}
			else if(choice == options[1])
			{
				System.out.println("Update Emlopyee");
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
				EmployeeService employeeService = context.getBean(EmployeeService.class);
				Employee employee = new Employee(3, 03, 003, "Sasuke", 26, "Intern");
				String result = employeeService.updateEmployee(employee);
				System.out.println(result);
				context.close();
			}
			else if(choice == options[2])
			{
				System.out.println("Delete Emlopyee");
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
				EmployeeService employeeService = context.getBean(EmployeeService.class);
				String result = employeeService.deleteEmployee(5);
				System.out.println(result);
				context.close();	
			}
			else if(choice == options[3])
			{
				System.out.println("Find By Id");
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
				EmployeeService employeeService = context.getBean(EmployeeService.class);
				Optional<Employee> result = employeeService.findById(1);
				System.out.println(result);
				context.close();		
			}
			else if(choice == options[4])
			{
				System.out.println("Get Employees");
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
				EmployeeService employeeService = context.getBean(EmployeeService.class);
				Optional<List<Employee>> result = employeeService.getEmployees();
				System.out.println(result);
				context.close();	
			}
			else if(choice == options[5])
			{
				System.out.println("Find By OrganizationId");
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
				EmployeeService employeeService = context.getBean(EmployeeService.class);
				Optional<List<Employee>> result = employeeService.findByOrganizationId(1);
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
