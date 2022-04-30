package spring.demo;

public class BaseballCoach implements Coach,Trainer {
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practice";
	}

	@Override
	public String train() {
		return "Everyday train running.";
	}
}








