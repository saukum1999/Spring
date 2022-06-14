package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {

	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService theFortuneService) {

		fortuneService = theFortuneService;
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Swim 1000 meters as warm up";
	}

	@Override
	public String getDailyFortuneService() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
