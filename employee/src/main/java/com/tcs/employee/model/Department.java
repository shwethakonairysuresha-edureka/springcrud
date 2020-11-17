package com.tcs.employee.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "department_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	@Id
	private int id;
	@Column(name = "organization_id")
	private int organizationId;
	@Column(name = "department_name")
	private String name;
    //private List<Employee> employees;
}
