package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	private String[] fortunes = {
			"Today is your Lucky day",
			"Diligent work beats luck",
			"Consistency is the key to success"
	};
	
	Random ran = new Random();
	
	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		int a = ran.nextInt(fortunes.length);
		return fortunes[a];
	}

}
