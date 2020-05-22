/**
 * 
 */
package com.ecw.empaddbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

import com.ecw.empaddbook.entity.Employee;
import com.ecw.empaddbook.service.CsvReadWriteOperation;

/**
 * @author Ashish
 * Modified Date : May 15, 2020
 */

@Controller
public class EmployeeController {
	@Autowired
	private CsvReadWriteOperation csvr;
	
	@RequestMapping("/")
	public ModelAndView firstPage() {
//		List<Employee> empList = csvr.getAllEmployee();
//		for(Employee e:empList) {
//			System.out.println("EMpId : " + e.getId() + " Emp first Name : " + e.getFirstName());
//		}
		
		Employee e = new Employee();
		e.setId("101327");
		e.setFirstName("mendhak");
		e.setLastName("Upaddhyay");
		e.setEmail("mu@gmail.com");
		e.setAddress("gajiyabad");
		csvr.addNewEmployee(e);
		return new ModelAndView("frontPage");
	}

}
