package com.tcs.employee;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.tcs.employee.model.Department;
import com.tcs.employee.model.Organization;
import com.tcs.employee.service.DepartmentService;
import com.tcs.employee.service.DepartmentServiceImpl;
import com.tcs.employee.service.OrganizationService;
import com.tcs.employee.service.OrganizationServiceImpl;

public class MainOrganization {
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
		String menuItems[] = {"Add Organization", "Update Organization", "Delete Organization", "Find By Id", "Get Organizations", "Find By OrganizationId", "EXIT"};
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
				System.out.println("Add Organization");
				Organization organization = new Organization(2, "XYZ", "123 Main St", null, null);
				OrganizationService organizationService = OrganizationServiceImpl.getInstance();
				String result = organizationService.addOrganization(organization);
				
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
				System.out.println("Update Organization");
				Organization organization = new Organization(2, "ABC", "123 Second St", null, null);
				OrganizationService organizationService = OrganizationServiceImpl.getInstance();
				String result = organizationService.updateOrganization(organization);
				
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
				System.out.println("Delete Organization");
				OrganizationService organizationService = OrganizationServiceImpl.getInstance();
				String result = organizationService.deleteOrganization(2);
				
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
				OrganizationService organizationService = OrganizationServiceImpl.getInstance();
				Optional<Organization> optional = organizationService.findById(1);
				
				if(optional.isPresent())
				{
					Organization organization = optional.get();
					System.out.println(organization);
				}
				else
				{
					System.out.println("Organization is not available");
				}
			}
			else if(choice == options[4])
			{
				System.out.println("Get Organizations");
				OrganizationService organizationService = OrganizationServiceImpl.getInstance();
				Optional<List<Organization>> result = organizationService.getOrganization();
				
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
				OrganizationService organizationService = OrganizationServiceImpl.getInstance();
				Optional<List<Organization>> optional = organizationService.findByOrganizationId(01);
				
				if(optional.isPresent())
				{
					List<Organization> organization = optional.get();
					System.out.println(organization);
				}
				else
				{
					System.out.println("Organization is not available");
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

