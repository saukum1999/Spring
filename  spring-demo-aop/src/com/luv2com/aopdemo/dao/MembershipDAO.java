package com.luv2com.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addMember() {
		System.out.println(getClass() + "  Adding Member......");
		
		return true;
	}
	
	public void goToSleep() {
		System.out.println(getClass() + "  Go to sleep....");
	}
}
