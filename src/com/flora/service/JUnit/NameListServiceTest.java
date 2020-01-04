/**
 * 
 */
package com.flora.service.JUnit;

import org.junit.jupiter.api.Test;

import com.flora.domain.Employee;
import com.flora.service.NameListService;
import com.flora.service.TeamException;

/**@description test class NameListService
 * @author aiquanquanderen
 * @date2020年1月3日
 */
public class NameListServiceTest {
	@Test
public void testGetAllEmployees() {
		NameListService service = new NameListService();
		Employee[] employees = service.getAllEmployees();
		for(int i = 0;i<employees.length;i++) {
			System.out.println(employees[i]);
		}
}
	@Test
	public void testGetEmployee() {
		NameListService service = new NameListService();
		int id = 1;
		id = 101;
	try {
		Employee employee=	service.getEmployee(id);
		System.out.println(employee);
	} catch (TeamException e) {
		
		System.out.println(e.getMessage());
	}
	}
}
