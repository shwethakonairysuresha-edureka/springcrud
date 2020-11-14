package com.tcs.employee;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.tcs.employee.dao.EmployeeDAO;
import com.tcs.employee.dao.EmployeeDAOImpl;
import com.tcs.employee.model.Employee;
import com.tcs.employee.service.EmployeeService;
import com.tcs.employee.service.EmployeeServiceImpl;

public class MainEmployee {

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
				Employee employee = new Employee(3, 03, 003, "Sakura", 22, "Associate");
				EmployeeService employeeService = EmployeeServiceImpl.getInstance();
				String result = employeeService.addEmployee(employee);
				
				if("success".equals(result))
				{
					System.out.println("record added successfully");
				}
				else
				{
					System.out.println("Failed");
				}
			}
			else if(choice == options[1])
			{
				System.out.println("Update Emlopyee");
				Employee employee = new Employee(3, 03, 003, "Sasuke", 24, "Contract");
				EmployeeService employeeService = EmployeeServiceImpl.getInstance();
				String result = employeeService.updateEmployee(employee);
				
				if("success".equals(result))
				{
					System.out.println("record updated successfully");
				}
				else
				{
					System.out.println("Failed");
				}
			}
			else if(choice == options[2])
			{
				System.out.println("Delete Emlopyee");
				EmployeeService employeeService = EmployeeServiceImpl.getInstance();
				String result = employeeService.deleteEmployee(3);
				
				if("success".equals(result))
				{
					System.out.println("record deleted successfully");
				}
				else
				{
					System.out.println("Failed");
				}
			}
			else if(choice == options[3])
			{
				System.out.println("Find By Id");
				EmployeeService employeeService = EmployeeServiceImpl.getInstance();
				Optional<Employee> optional = employeeService.findById(1);
				
				if(optional.isPresent())
				{
					Employee employee = optional.get();
					System.out.println(employee);
				}
				else
				{
					System.out.println("Employee is not available");
				}
			}
			else if(choice == options[4])
			{
				System.out.println("Get Employees");
				EmployeeService employeeService = EmployeeServiceImpl.getInstance();
				Optional<List<Employee>> result = employeeService.getEmployees();
				
				if("success".equals(result))
				{
					System.out.println("records retrieved successfully");
				}
				else
				{
					System.out.println("Failed");
				}
			}
			else if(choice == options[5])
			{
				System.out.println("Find By OrganizationId");
				EmployeeService employeeService = EmployeeServiceImpl.getInstance();
				Optional<List<Employee>> optional = employeeService.findByOrganizationId(01);
				
				if(optional.isPresent())
				{
					List<Employee> employee = optional.get();
					System.out.println(employee);
				}
				else
				{
					System.out.println("Employee is not available");
				}
			}
			
			//Display Menu
			displayMenu(options, menuItems);
			
			//Get choice from user
			choice = in.nextInt();
		}
		System.out.println("GoodBye!");
	}

}
