package com.topera.epoch.service;

import java.util.List;

import com.topera.epoch.model.DepartmentEntity;
import com.topera.epoch.model.EmployeeEntity;

public interface EmployeeManager 
{
	public List<EmployeeEntity> getAllEmployees();
	public List<DepartmentEntity> getAllDepartments();
	public void addEmployee(EmployeeEntity employee);
}
