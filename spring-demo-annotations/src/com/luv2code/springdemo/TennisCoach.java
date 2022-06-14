package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {

//	@Override
//	public String toString() {
//		return "TennisCoach []";
//	}
	

	@Autowired
	@Qualifier("randomFortuneService")
	private FortuneService fortuneService;

//	@Autowired
	public TennisCoach() {
		System.out.println("TennisCoach: Inside default constructor");
	}
//	@Autowired
//	public TennisCoach(FortuneService theFortuneService) {
//		fortuneService = theFortuneService;
//	}

//	@Autowired
//	public void setFortuneService (FortuneService theFortuneService) {
//		System.out.println("TennisCoach: Inside setter injection constructor");
//		fortuneService = theFortuneService;
//	}
	@PostConstruct
	public void startupStuff() {
		System.out.println("TennisCoach: startup stuff");
	}
	
	@PreDestroy
	public void cleanupStuff() {
		System.out.println("TennisCoach: cleanup stuff");
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice daily backhand";
	}

	@Override
	public String getDailyFortuneService() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
