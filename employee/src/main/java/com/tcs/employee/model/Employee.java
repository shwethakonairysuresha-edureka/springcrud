package com.tcs.employee.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	private int id;
	private int organizationId;
	private int departmentId;
	private String name;
	private int age;
	private String position;
}
