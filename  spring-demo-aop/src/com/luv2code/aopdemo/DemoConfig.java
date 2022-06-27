package com.luv2code.aopdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.luv2com.aopdemo.dao.AccountDAO;
import com.luv2com.aopdemo.dao.MembershipDAO;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.luv2code.aopdemo")
public class DemoConfig {

	@Bean
	public AccountDAO accountDAO() {
		return new AccountDAO();
	}
	
	@Bean
	public MembershipDAO membershipDAO() {
		return new MembershipDAO();
	}
}
