package spring.demo;

import spring.service.FortuneService;

public class TrackCoach implements Coach,Trainer{

	private final FortuneService fortuneService;

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}

	@Override
	public String train() {

	return 	"Train everyday for 40 minutes with no rest between!";

	}


}










