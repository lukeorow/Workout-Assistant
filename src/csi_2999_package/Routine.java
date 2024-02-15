package csi_2999_package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;

public class Routine {

	private JButton button;
	private int size;
	private int type;
	private String name = "";
	private WorkoutForRoutine[] workoutForRoutine;
	private boolean favorite;

	private Routine week1;
	private Routine week2;
	private Routine week3;
	private Routine week4;

	List<WorkoutForRoutine> fullRoutine = new ArrayList<>((Arrays.asList()));

	public Routine (WorkoutForRoutine[] workoutForRoutine) {
		this.workoutForRoutine = workoutForRoutine;
		button = null;
		type = 1;
		size = workoutForRoutine.length;
		favorite = false;

		this.workoutForRoutine = workoutForRoutine;

		for (int i = 0; i < size; i++) {
			fullRoutine.add(workoutForRoutine[i]);
		}

		week1 = new Routine(name, workoutForRoutine);
	}

	public Routine (String name, WorkoutForRoutine[] workoutForRoutine) {
		this.workoutForRoutine = workoutForRoutine;
		this.name = name;
		button = null;
		type = 1;
		size = workoutForRoutine.length;
		favorite = false;

		this.workoutForRoutine = workoutForRoutine;
	}

	public Routine (String name, Routine week1, Routine week2) {
		this.name = name;
		this.week1 = week1;
		this.week2 = week2;
		type = 2;
	}

	public Routine (String name, Routine week1, Routine week2, Routine week3) {
		this.name = name;
		this.week1 = week1;
		this.week2 = week2;
		this.week3 = week3;
		type = 3;
	}

	public Routine (String name, Routine week1, Routine week2, Routine week3, Routine week4) {
		this.name = name;
		this.week1 = week1;
		this.week2 = week2;
		this.week3 = week3;
		this.week4 = week4;
		type = 4;
	}

	public Routine getWeek(int i) {
		switch (i) {
			case 1: return week1;
			case 2: return week2;
			case 3: return week3;
			case 4: return week4;
			default: break;
		}
		return null;
	}

	public Routine getWeek1() {
		return week1;
	}

	public void setWeek1(Routine week1) {
		this.week1 = week1;
	}

	public Routine getWeek2() {
		return week2;
	}

	public void setWeek2(Routine week2) {
		this.week2 = week2;
	}

	public Routine getWeek3() {
		return week3;
	}

	public void setWeek3(Routine week3) {
		this.week3 = week3;
	}

	public Routine getWeek4() {
		return week4;
	}

	public void setWeek4(Routine week4) {
		this.week4 = week4;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public WorkoutForRoutine[] getWorkoutForRoutine() {
		return workoutForRoutine;
	}

	public void setWorkoutForRoutine(WorkoutForRoutine[] workoutForRoutine) {
		this.workoutForRoutine = workoutForRoutine;
	}

	public JButton getButton() {
		return button;
	}

	public int getSize() {
		return size;
	}

	public void setButton(JButton button) {
		this.button = button;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<WorkoutForRoutine> getFullRoutine() {
		return fullRoutine;
	}

	public void setFullRoutine(List<WorkoutForRoutine> fullRoutine) {
		this.fullRoutine = fullRoutine;
	}

}