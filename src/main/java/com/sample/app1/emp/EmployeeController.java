package com.sample.app1.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emps")
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
	
	@Autowired
	private EmployeeService eservice;
	
	@PostMapping
	public Employee save(@RequestBody Employee e) {
		System.out.println("empid = " + e.getEmpid());
		System.out.println("empname = " + e.getEmpname());
		System.out.println("empdob = " + e.getEmpDob());
		System.out.println("phone = "+ e.getPhone());
		return eservice.addEmployee(e);
	}
	
	@GetMapping("/years")
	public long getDiff() {
		return eservice.yearsDiff();
	}

}
