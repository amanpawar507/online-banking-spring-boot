package com.sample.app1.emp;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmpRepo repo;
	public Employee addEmployee(Employee e) {
		
		return this.repo.save(e);
	}
	
	public long yearsDiff() {
		Employee e1 = repo.findById(101).get();
		Employee e2 = repo.findById(102).get();
		long e1Dob = e1.getEmpDob().getTime();
		long e2Dob = e2.getEmpDob().getTime();
		long diff = e2Dob-e1Dob;
		long years = (diff
                / (1000l * 60 * 60 * 24 * 365));
		
		return years;
	}

}
