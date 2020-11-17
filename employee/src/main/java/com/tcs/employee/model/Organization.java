package com.tcs.employee.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "organization_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
	@Id
	private int id;
	@Column(name = "organization_name")
	private String name;
	private String address;
	//private List<Department> departments = new ArrayList<>();
	//private List<Employee> employees = new ArrayList<>();
}
