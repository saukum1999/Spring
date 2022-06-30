package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	
	public String getFortune() {
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Expect a delay due to heavy traffic";
	}

	public String getFortune(boolean tripwire) {
		
		if(tripwire) {
			throw new RuntimeException("Major accident! Highway is closed!");
		}
		// TODO Auto-generated method stub
		return getFortune();
	}

}
