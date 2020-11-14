package com.tcs.employee;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.tcs.employee.model.Department;
import com.tcs.employee.model.Employee;
import com.tcs.employee.service.DepartmentService;
import com.tcs.employee.service.DepartmentServiceImpl;
import com.tcs.employee.service.EmployeeService;
import com.tcs.employee.service.EmployeeServiceImpl;

public class MainDepartment {

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
				Department department = new Department(2, 02, "Chemistry", null);
				DepartmentService departmentService = DepartmentServiceImpl.getInstance();
				String result = departmentService.addDepartment(department);
				
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
				System.out.println("Update Department");
				Department department = new Department(1, 01, "Biology", null);
				DepartmentService departmentService = DepartmentServiceImpl.getInstance();
				String result = departmentService.updateDepartment(department);
				
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
				System.out.println("Delete Department");
				DepartmentService departmentService = DepartmentServiceImpl.getInstance();
				String result = departmentService.deleteDepartment(2);
				
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
				DepartmentService departmentService = DepartmentServiceImpl.getInstance();
				Optional<Department> optional = departmentService.findById(1);
				
				if(optional.isPresent())
				{
					Department department = optional.get();
					System.out.println(department);
				}
				else
				{
					System.out.println("Department is not available");
				}
			}
			else if(choice == options[4])
			{
				System.out.println("Get Departments");
				DepartmentService departmentService = DepartmentServiceImpl.getInstance();
				Optional<List<Department>> result = departmentService.getDepartments();
				
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
				DepartmentService departmentService = DepartmentServiceImpl.getInstance();
				Optional<List<Department>> optional = departmentService.findByOrganizationId(01);
				
				if(optional.isPresent())
				{
					List<Department> employee = optional.get();
					System.out.println(employee);
				}
				else
				{
					System.out.println("Department is not available");
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
