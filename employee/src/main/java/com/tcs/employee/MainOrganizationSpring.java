package com.tcs.employee;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.employee.config.DBConfig;
import com.tcs.employee.model.Department;
import com.tcs.employee.model.Organization;
import com.tcs.employee.service.DepartmentService;
import com.tcs.employee.service.OrganizationService;

public class MainOrganizationSpring {

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
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
				OrganizationService organizationService = context.getBean(OrganizationService.class);
				Organization organization = new Organization(3, "FOX", "123 Main St");
				String result = organizationService.addOrganization(organization);
				System.out.println(result);
				context.close();
			}
			else if(choice == options[1])
			{
				System.out.println("Update Organization");
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
				OrganizationService organizationService = context.getBean(OrganizationService.class);
				Organization organization = new Organization(3, "CNN", "456 Main St");
				String result = organizationService.updateOrganization(organization);
				System.out.println(result);
				context.close();
			}
			else if(choice == options[2])
			{
				System.out.println("Delete Department");
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
				OrganizationService organizationService = context.getBean(OrganizationService.class);
				String result = organizationService.deleteOrganization(3);
				System.out.println(result);
				context.close();
			}
			else if(choice == options[3])
			{
				System.out.println("Find By Id");
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
				OrganizationService organizationService = context.getBean(OrganizationService.class);
				Optional<Organization> result = organizationService.findById(1);
				System.out.println(result);
				context.close();
			}
			else if(choice == options[4])
			{
				System.out.println("Get Departments");
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
				OrganizationService organizationService = context.getBean(OrganizationService.class);
				Optional<List<Organization>> result = organizationService.getOrganization();
				System.out.println(result);
				context.close();
			}
			else if(choice == options[5])
			{
				System.out.println("Find By OrganizationId");
				AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
				OrganizationService organizationService = context.getBean(OrganizationService.class);
				Optional<List<Organization>> result = organizationService.findByOrganizationId(1);
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
