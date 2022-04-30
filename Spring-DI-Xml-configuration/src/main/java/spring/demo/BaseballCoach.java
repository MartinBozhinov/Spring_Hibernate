package spring.demo;

import spring.service.FortuneService;

public class BaseballCoach implements Coach,Trainer {

	private final FortuneService fortuneService;

	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

    @Override
    public String getFortune() {
        return fortuneService.getFortune();
    }

    @Override
	public String train() {
		return "Everyday train running.";
	}
}








