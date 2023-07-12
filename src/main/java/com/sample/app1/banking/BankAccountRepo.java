package com.sample.app1.banking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BankAccountRepo extends JpaRepository<BankAccount, Long> {

@Query(value="SELECT * FROM bank_account WHERE customer_id=?1",nativeQuery = true)
public BankAccount findByCustomerId(Long customerId);
}
