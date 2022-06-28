package com.luv2code.aopdemo;

import org.springframework.stereotype.Component;

@Component
public class Account {

	private String name;
	
	@Override
	public String toString() {
		return "Account [name=" + name + ", level=" + level + "]";
	}

	private String level;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
}
