package com.sample.app1.banking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.app1.sec.IUserService;
import com.sample.app1.sec.Role;
import com.sample.app1.sec.User;

@Service
public class BankAccountService {

	@Autowired
	private BankAccountRepo repo;
	@Autowired
	private IUserService userService;

	public BankAccount save(BankAccount bankAccount) {
		
		 
		System.out.println("***date before save***");
		System.out.println(bankAccount.getActCreationDate() instanceof java.sql.Date);
		System.out.println(bankAccount.getActCreationDate().getTime());
		System.out.println(new java.util.Date().getTime());
		System.out.println(System.currentTimeMillis());
		System.out.println("**************************************************");
		  
		 
		//Add A NEW RECORD INTO BANKACCOUNT AND CUSTOMER TABLE
		BankAccount temp = repo.save(bankAccount);
		
		// CREATE  A ROLE and
		
		  Role userRole= new Role();
		  
		  userRole.setRoleName("ROLE_USER");
		  userRole.setRoleDescription("NON ADMIN USER");
		  
		  // CREATE A ROLE SET AND ADD ABOVE ROLE INTO LIST Set<Role> roleSet = new
		  Set<Role> roleSet = new HashSet<Role>(); roleSet.add(userRole); 
		  // CREATE A  USER and add role User 
		  User user = new User();
		  user.setUsername(temp.getCustomer().getFirstname());
		  user.setPassword(temp.getCustomer().getFirstname()+"@1234");
		  user.setCustomerId(temp.getCustomer().getCustomerId());
		  user.setRole(roleSet);
		  
		  // ADD THE user record INTO THE User table User addUser =
		  userService.saveUser(user);
		  return temp;
	}
	
	
	public List<BankAccount> findAll(){
		return repo.findAll();
	}
	
	
	public BankAccount findByCustomerId(Long customerId) {
		return repo.findByCustomerId(customerId);
	}
}
