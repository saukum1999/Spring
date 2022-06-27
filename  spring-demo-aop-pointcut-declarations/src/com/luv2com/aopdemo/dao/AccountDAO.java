package com.luv2com.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account, boolean vip) {
		System.out.println(getClass() + "  Doing my DB work.");
	}

	public void doWork() {
		System.out.println(getClass() + "  doWork():  Doing my DB work.");
	}
}
