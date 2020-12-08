package com.sfofana.bank.bank;

import com.sfofana.bank.bank.model.AccountHolder;
import com.sfofana.bank.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankApplication implements CommandLineRunner {

	@Autowired
	UserService service;

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		AccountHolder master = new AccountHolder();
		master.setAddress("1234 Street Rd");
		master.setDob("12/15/1999");
		master.setEmail("master@gmail.com");
		master.setFirstname("Master");
		master.setLastname("Account");
		master.setPassword("demo");
		master.setSsn(123456789);
		service.register(master);

		AccountHolder admin = new AccountHolder();
		admin.setAddress("1234 Elm St");
		admin.setDob("05/15/1999");
		admin.setEmail("admin@gmail.com");
		admin.setFirstname("Admin");
		admin.setLastname("Account");
		admin.setPassword("admin");
		admin.setSsn(987654321);
		service.register(admin);
	}
}
