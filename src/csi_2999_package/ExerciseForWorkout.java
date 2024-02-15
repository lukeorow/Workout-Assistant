package csi_2999_package;

public class ExerciseForWorkout {

	Exercise exercise;
	int reps;
	double time;
	double breakTime;

	public ExerciseForWorkout() {
		exercise = null;
		reps = 0;
		time = 0;
		breakTime = 0;
	}

	public ExerciseForWorkout(Exercise exercise, int reps, double breakTime) {
		this.exercise = exercise;
		this.reps = reps;
		time = 0;
		this.breakTime = breakTime;
	}

	public ExerciseForWorkout(Exercise exercise, double value, double breakTime, String check) {
		this.exercise = exercise;

		if (check.equalsIgnoreCase("R")) {
			reps = (int) value;
			time = 0;
		}

		if (check.equalsIgnoreCase("T")) {
			reps = 0;
			time = value;
		}

		this.breakTime = breakTime;
	}

	public ExerciseForWorkout(Exercise exercise, double time, double breakTime) {
		this.exercise = exercise;
		reps = 0;
		this.time = time;
		this.breakTime = breakTime;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	public int getReps() {
		return reps;
	}

	public void setReps(int reps) {
		this.reps = reps;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public double getBreakTime() {
		return breakTime;
	}

	public void setBreakTime(float breakTime) {
		this.breakTime = breakTime;
	}

}