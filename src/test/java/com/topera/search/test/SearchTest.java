package com.topera.search.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.topera.epoch.service.EmployeeManager;
import com.topera.epoch.service.ToperaService;
import com.topera.epoch.vo.SearchInput;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "./test-context.xml" })
public class SearchTest {
	@Autowired
	EmployeeManager manager;
	
	@Autowired
	ToperaService toperaService;
	
	
	
//	@Test
	public void teqstTopera(){
		
		SearchInput input = new SearchInput();
		input.setHospital("TO");
		
		System.out.println("SearchTest.teqstTopera()"+toperaService.searchMetadata(toperaService.getToperaSearchEntity(input)));
	    
	}
	
//	@Test
//	public void testEmployee(){
//		
//		EmployeeEntity employeeVO = new EmployeeEntity();
//		employeeVO.setId(1);
//		employeeVO.setFirstName("arup11");
//		employeeVO.setLastName("banerjee");
//		employeeVO.setEmail("arupkumar.banerjee@gmail.com");
//		DepartmentEntity department = new DepartmentEntity();
//		department.setId(2);
//		
//		employeeVO.setDepartment(department);
//		
//		manager.addEmployee(employeeVO);
//	}
//	
//	@Test
//	public void testGetEmployee(){
//		
//		List<DepartmentEntity> departments =  manager.getAllDepartments();
//		for (DepartmentEntity departmentEntity : departments) {
//			System.out.println("SearchTest.testGetEmployee()"+departmentEntity.toString());
//		}
//		
//	}
}
