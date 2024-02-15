package csi_2999_package;

public class WorkoutForRoutine {

	private String date;
	private String time;
	private Workout workout;

	public WorkoutForRoutine(String date, String time, Workout workout) {
		this.date = date;
		this.time = time;
		this.workout = workout;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}

}