package com.sample.app1;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sample.app1.sec.IUserService;
import com.sample.app1.sec.Role;
import com.sample.app1.sec.User;

@SpringBootApplication
public class SampleApp1Application {

	@Autowired
	private IUserService userService;
	public static void main(String[] args) {
		SpringApplication.run(SampleApp1Application.class, args);
		System.out.println("App started...");
	}

	@Bean
	public CommandLineRunner clrBean1() {
		return (args)->{
			// CREATE  A ROLE and
			  Role adminRole= new Role();
			  
			  adminRole.setRoleName("ROLE_ADMIN");
			  adminRole.setRoleDescription("ADMIN OPERATIONS");
			  
			  Role userRole= new Role();
			  
			  userRole.setRoleName("ROLE_USER");
			  userRole.setRoleDescription("NON ADMIN OPERATIONS");
			  	// CREATE A ROLE SET AND ADD ABOVE ROLE INTO LIST		  
			  Set<Role> roleSet1 = new HashSet<Role>();
			  roleSet1.add(adminRole);
			  roleSet1.add(userRole);
			  // CREATE A USER and add role
			  User user1 = new User();
			  user1.setUsername("admin");
			  user1.setPassword("admin@1234");
			  user1.setCustomerId(0L);
			  user1.setRole(roleSet1);
			  
			  // ADD THE user record INTO THE User table
			  User firstUser = userService.saveUser(user1);
			  
			  //ADDING SECOND USER

				// CREATE  A ROLE and
			  Role customerRole= new Role();
			  
			  customerRole.setRoleName("ROLE_CUSTOMER");
			  customerRole.setRoleDescription("CUSTOMER OPERATIONS");
		  	// CREATE A ROLE SET AND ADD ABOVE ROLE INTO LIST		  
			  Set<Role> roleSet2 = new HashSet<Role>();
			  roleSet2.add(customerRole);
			  // CREATE A USER and add role
			  User user2 = new User();
			  user2.setUsername("guest");
			  user2.setPassword("guest@1234");
			  user2.setCustomerId(1L);
			  user2.setRole(roleSet2);
			  
			  // ADD THE user record INTO THE User table
			  User secondUser = userService.saveUser(user2);

			  System.out.println("Customer created..");
		};
	}
}
