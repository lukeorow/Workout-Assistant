package csi_2999_package;

import javax.swing.JButton;
import javax.swing.JCheckBox;

public class Workout {

	private JButton button;
	private JButton buttonInAssisstant;

	private JCheckBox check;

	private String name;
	private int exerciseAmount; //no more than ten
	private int rounds;
	private boolean favorite;
	private ExerciseForWorkout[] exArray;

	public Workout(String name, int exerciseAmount, ExerciseForWorkout[] exArray, int rounds) {
		this.name = name;
		this.exerciseAmount = exerciseAmount;
		this.rounds = rounds;
		this.exArray = exArray;

		favorite = false;
		button = null;
		buttonInAssisstant = null;
        check = null;
	}

    public JButton getButtonInAssisstant() {
		return buttonInAssisstant;
	}
    
    public int getWorkoutSize() {
    	return (rounds * exerciseAmount);
    }
    
    public ExerciseForWorkout getExerciseForWorkout(int location) {
    	return exArray[location];
    }

	public void setButtonInAssisstant(JButton buttonInAssisstant) {
		this.buttonInAssisstant = buttonInAssisstant;
	}

	public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public JCheckBox getCheck() {
        return check;
    }

    public void setCheck(JCheckBox check) {
        this.check = check;
    }

	public Exercise getExerciseName(Workout workout, int location) {
		return exArray[location].getExercise();
	}

	public int getExerciseDetailsReps(Workout workout, int location) {
		return exArray[location].getReps();
	}

	public double getExerciseDetailsTime(Workout workout, int location) {
		return exArray[location].getTime();
	}

	public double getExerciseBreakTime(Workout workout, int location) {
		return exArray[location].getBreakTime();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExerciseAmount() {
		return exerciseAmount;
	}

	public void setExerciseAmount(int exerciseAmount) {
		this.exerciseAmount = exerciseAmount;
	}

	public int getRounds() {
		return rounds;
	}

	public void setRounds(int rounds) {
		this.rounds = rounds;
	}

	public boolean getFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public ExerciseForWorkout[] getArray() {
		return exArray;
	}

	public void setExArray(ExerciseForWorkout[] exArray) {
		this.exArray = exArray;
	}

}