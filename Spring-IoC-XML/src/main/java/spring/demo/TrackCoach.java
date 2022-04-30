package spring.demo;

public class TrackCoach implements Coach,Trainer{

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String train() {

	return 	"Train everyday for 40 minutes with no rest between!";

	}
}










