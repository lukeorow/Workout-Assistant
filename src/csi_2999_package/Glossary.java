package csi_2999_package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Glossary {

    Exercise barbellBentOverRows = new Exercise("Barbell bent over rows", "☐ Stand with feet shoulder-width apart, holding a barbell with an overhand grip.\n\n☐ Bend at your hips, keeping your back straight.\n\n☐ Pull the barbell towards your lower chest, squeezing your shoulder blades together.\n", true, false, false, false, false);
    Exercise reverseFlysMachine= new Exercise("Reverse flys machine", "☐ Sit at the machine with chest against the pad.\n\n☐ Grasp the handles with arms extended.\n\n☐ Pull the handles outward, squeezing your shoulder blades together.\n", true, false, false, false, false);
    Exercise pullUps= new Exercise("Pull ups", "☐ Hang from a pull-up bar with palms facing away.\n\n☐ Pull your body up until your chin is above the bar.\n\n☐ Lower yourself back down with control.\n", true, false, false, false, false);
    Exercise latPullDown= new Exercise("Lat pulldown", "☐ Sit at the lat pulldown machine.\n\n☐ Grab the bar with a wide grip, and pull it down to your chest.\n\n☐ Keep your back straight and shoulders down.\n", true, false, false, false, false);
    Exercise barbellCurls = new Exercise("Barbell Curls", "☐ Stand with a barbell in front, palms facing forward.\n\n☐ Curl the barbell towards your shoulders, keeping your elbows close to your body.", false, true, false, false, false);
    Exercise hammerCurls = new Exercise("Hammer Curls", "☐ Hold dumbbells at your sides with palms facing in.\n\n☐ Curl the weights towards your shoulders, keeping your palms facing each other.", false, true, false, false, false);
    Exercise cableTwistingCurl = new Exercise("Cable Twisting Curl", "☐ Use a cable machine, grip the handle, and curl the cable while twisting your wrist.", false, true, false, false, false);
    Exercise skullcrusher = new Exercise("Skullcrusher", "☐ Lie on a bench with a barbell, arms extended.\n\n☐ Lower the barbell towards your forehead, then extend your arms back up.", false, true, false, false, false);
    Exercise tricepExtensions = new Exercise("Tricep Extensions", "☐ Stand or sit, holding a dumbbell with both hands overhead.\n\n☐ Lower the dumbbell behind your head, then extend your arms.", false, true, false, false, false);
    Exercise tricepPushdowns = new Exercise("Tricep Pushdowns ", "☐ Use a cable machine with a straight bar, push the bar down, extending your arms.", false, true, false, false, false);
    Exercise wristCurl = new Exercise("Wrist Curl", "☐ Sit with your forearm resting on a bench, wrist hanging off the edge.\n\n☐ Hold a weight and curl your wrist upwards.", false, true, false, false, false);
    Exercise cableWristExtension = new Exercise("Cable Wrist Extension ", "☐ Use a cable machine, grip the handle with your palm facing down, and extend your wrist.", false, true, false, false, false);
    Exercise shoulderPress = new Exercise("Shoulder Press", "☐ Sit or stand, press dumbbells or a barbell overhead.", false, false, true, false, false);
    Exercise shrugs = new Exercise("Shrugs", "☐ Hold dumbbells at your sides, and lift your shoulders towards your ears.", false, false, true, false, false);
    Exercise facePulls = new Exercise("Face Pulls", "☐ Use a cable machine, pull the rope attachment towards your face, focusing on the rear delts.", true, false, true, false, false);
    Exercise frontalRaises = new Exercise("Frontal Raises", "☐ Hold dumbbells in front of your thighs, and lift your arms straight in front of you.", false, false, true, false, false);
    Exercise lateralRaises = new Exercise("Lateral Raises", "☐ Hold dumbbells at your sides, and lift your arms straight out to the sides.", false, false, true, false, false);
    Exercise pushUp = new Exercise("Push Up", "☐ Start in a plank position, lower your body to the ground, and push back up.", false, true, true, true, false);
    Exercise inclinePress = new Exercise("Incline Press", "☐ Lie on an incline bench, press dumbbells or a barbell upward.", false, true, true, true, false);
    Exercise benchPress = new Exercise("Bench Press", "☐ Lie on a flat bench, press dumbbells or a barbell upward.", false, true, true, true, false);
    Exercise chestPress = new Exercise("Chest Press", "☐  Use a chest press machine, push the handles forward.", false, true, true, true, false);
    Exercise chestFlys = new Exercise("Chest Flys", "☐  Lie on a bench, arms extended, and bring the weights out to the sides.", false, true, true, true, false);
    Exercise legExtensions = new Exercise("Leg Extensions", "☐ Sit on a leg extension machine, extend your legs against resistance.", false, false, false, false, true);
    Exercise legCurls = new Exercise("Leg Curls", "☐  Lie face down on a leg curl machine, curl your legs towards your buttocks.", false, false, false, false, true);
    Exercise gobletSquats = new Exercise("Goblet Squats", "☐  Hold a dumbbell at your chest, squat down, and stand back up.", false, false, false, false, true);
    Exercise squat = new Exercise("Squat", "☐  Place a barbell on your shoulders, squat down, and stand back up.", false, false, false, false, true);
    Exercise legPress = new Exercise("Leg Press", "☐  Sit on a leg press machine, press the platform away from you.", false, false, false, false, true);
    Exercise goodMorning = new Exercise("Good Morning", "☐  With a barbell on your shoulders, bend forward at your hips, then stand back up.", false, false, false, false, true);
    Exercise deadlift = new Exercise("Deadlift", "☐  Stand with a barbell in front, bend at your hips and knees, then stand back up.", false, false, false, false, true);
    Exercise calvesRaises = new Exercise("Calves Raises", "☐  Stand on a raised surface, like a step, and lift your heels up and down.", false, false, false, false, true);

    List<Exercise> listOfExercises =new ArrayList<>((
    Arrays.asList(benchPress, barbellBentOverRows, barbellCurls, cableTwistingCurl, cableWristExtension, calvesRaises,
    		chestFlys, chestPress, deadlift, facePulls, frontalRaises, goodMorning, hammerCurls, inclinePress, latPullDown,
    		lateralRaises, legCurls, legExtensions, legPress, pullUps, pushUp, reverseFlysMachine, skullcrusher, shoulderPress,
    		shrugs, squat, tricepExtensions, tricepPushdowns, wristCurl)));

    public Exercise getExercise(String name) {
    	for (Exercise element : listOfExercises) {
    		if (element.getName().equals(name)) {
    			return element;
    		}
    	}
    	return null;
    }

    public Exercise getExercise(int location) {
    	return listOfExercises.get(location);
    }

    public void removeExercise(Exercise exercise) {
    	for (int i = 0; i < listOfExercises.size(); i++) {
    		if (listOfExercises.get(i) == exercise) {
    			System.out.println("Removing: " + listOfExercises.get(i).getName());
    			listOfExercises.remove(listOfExercises.get(i));
    			System.out.println("Removed: " + listOfExercises.get(i).getName());
    		}
    	}
    }

    ExerciseForWorkout sampleBackExercise1 = new ExerciseForWorkout(barbellBentOverRows, 10, 30);
    ExerciseForWorkout sampleBackExercise2 = new ExerciseForWorkout(reverseFlysMachine, 60.0, 60);
    ExerciseForWorkout sampleBackExercise3 = new ExerciseForWorkout(pullUps, 20, 30);
    ExerciseForWorkout sampleBackExercise4 = new ExerciseForWorkout(latPullDown, 30.0, 30);
    ExerciseForWorkout[] arrayEx1 = {sampleBackExercise1, sampleBackExercise2, sampleBackExercise3, sampleBackExercise4};

    ExerciseForWorkout sampleBackExercise5 = new ExerciseForWorkout(pullUps, 20, 30);
    ExerciseForWorkout sampleBackExercise6 = new ExerciseForWorkout(latPullDown, 30.0, 30);
    ExerciseForWorkout[] arrayEx2 = {sampleBackExercise5, sampleBackExercise6, sampleBackExercise5, sampleBackExercise6, sampleBackExercise5, sampleBackExercise6, sampleBackExercise5, sampleBackExercise6, sampleBackExercise5, sampleBackExercise6};

    ExerciseForWorkout sampleBackExercise7 = new ExerciseForWorkout(reverseFlysMachine, 60.0, 60);
    ExerciseForWorkout sampleBackExercise8 = new ExerciseForWorkout(pullUps, 20, 30);
    ExerciseForWorkout sampleBackExercise9 = new ExerciseForWorkout(latPullDown, 30.0, 30);
    ExerciseForWorkout sampleBackExercise10 = new ExerciseForWorkout(reverseFlysMachine, 60.0, 60);
    ExerciseForWorkout sampleBackExercise11 = new ExerciseForWorkout(pullUps, 20, 30);
    ExerciseForWorkout sampleBackExercise12 = new ExerciseForWorkout(pullUps, 20, 30);
    ExerciseForWorkout sampleBackExercise13 = new ExerciseForWorkout(pullUps, 20, 30);
    ExerciseForWorkout sampleBackExercise14 = new ExerciseForWorkout(pullUps, 20, 30);
    ExerciseForWorkout[] arrayEx3 = {sampleBackExercise7, sampleBackExercise8, sampleBackExercise9, sampleBackExercise10, sampleBackExercise11, sampleBackExercise12, sampleBackExercise13, sampleBackExercise14, sampleBackExercise7};

    Workout sampleWorkout1 = new Workout("Sample Workout 1", 4, arrayEx1, 1);
    Workout sampleWorkout2 = new Workout("Sample Workout 2", 10, arrayEx2, 1);
    Workout sampleWorkout3 = new Workout("Sample Workout 3", 9, arrayEx3, 1);
    Workout sampleWorkout4 = new Workout("Sample Workout 4", 9, arrayEx3, 1);
    Workout sampleWorkout5 = new Workout("Sample Workout 5", 9, arrayEx3, 1);
    Workout sampleWorkout6 = new Workout("Sample Workout 6", 9, arrayEx3, 1);
    Workout sampleWorkout7 = new Workout("Sample Workout 7", 9, arrayEx3, 1);

    List<Workout> listOfWorkouts =new ArrayList<>((
    	    Arrays.asList(sampleWorkout1, sampleWorkout2, sampleWorkout3, sampleWorkout4, sampleWorkout5, sampleWorkout6, sampleWorkout7)));

    public Workout getWorkout(String name) {
    	for (Workout listOfWorkout : listOfWorkouts) {
    		if (listOfWorkout.getName().equals(name)) {
    			return listOfWorkout;
    		}
    	}
    	return null;
    }

    public Workout getWorkout(int location) {
    	return listOfWorkouts.get(location);
    }

    public void removeWorkout(Workout workout) {
    	for (int i = 0; i < listOfWorkouts.size(); i++) {
    		if (listOfWorkouts.get(i).getName().equals(workout.getName())) {
    			listOfWorkouts.remove(i);
    		}
    	}
    }

    public boolean workoutsContaining(Workout workout, Exercise exercise) {
    		for (int j = 0; j < workout.getArray().length; j++) {
    			if (workout.getArray()[j].getExercise().getName().equals(exercise.getName())) {
    				return true;
    			}
    		}

    	return false;
    }

    WorkoutForRoutine workout1 = new WorkoutForRoutine("MONDAY", "12:00", listOfWorkouts.get(0));
    WorkoutForRoutine workout2 = new WorkoutForRoutine("TUESDAY", "19:00", listOfWorkouts.get(1));
    WorkoutForRoutine workout3 = new WorkoutForRoutine("WEDNESDAY", "12:00", listOfWorkouts.get(0));
    WorkoutForRoutine workout4 = new WorkoutForRoutine("THURSDAY", "19:00", listOfWorkouts.get(1));
    WorkoutForRoutine workout5 = new WorkoutForRoutine("FRIDAY", "12:00", listOfWorkouts.get(0));
    WorkoutForRoutine workout6 = new WorkoutForRoutine("SATURDAY", "13:00", listOfWorkouts.get(2));
    WorkoutForRoutine workout7 = new WorkoutForRoutine("SUNDAY", "13:00", listOfWorkouts.get(2));

    WorkoutForRoutine[] workOutForRoutineExample1 = {workout1, workout2, workout3, workout4, workout5, workout6, workout7};
    WorkoutForRoutine[] workOutForRoutineExample2 = {workout1, workout3, workout5};

    Routine smptRt = new Routine ("Sample 4 Week Routine", new Routine (workOutForRoutineExample1), new Routine (workOutForRoutineExample2), new Routine (workOutForRoutineExample1), new Routine (workOutForRoutineExample2));

    List<Routine> listOfRoutines =new ArrayList<>((
    		Arrays.asList(smptRt, new Routine ("Sample Routine 1", workOutForRoutineExample1), new Routine ("Sample Routine 2", workOutForRoutineExample2), new Routine ("Sample Routine 3", workOutForRoutineExample2), new Routine ("Sample Routine 4", workOutForRoutineExample2),
    				new Routine ("Sample Routine 5", workOutForRoutineExample2), new Routine ("Sample Routine 6", workOutForRoutineExample2), new Routine ("Sample Routine 7", workOutForRoutineExample2))));

    public Routine getRoutine(String name) {
    	for (Routine listOfRoutine : listOfRoutines) {
    		if (listOfRoutine.getName().equals(name)) {
    			return listOfRoutine;
    		}
    	}
    	return null;
    }

    public void removeRoutine(Routine routine) {
    	for (int i = 0; i < listOfRoutines.size(); i++) {
    		if (listOfRoutines.get(i).getName().equals(routine.getName())) {
    			listOfRoutines.remove(i);
    		}
    	}
    }

    public List<Routine> routinesContainingWorkout(List<Workout> workoutList) {
    	List<Routine> routinesList = new ArrayList<>();

    	for (int i = 0; i < workoutList.size(); i++) {
    		for (int j = 0; j < listOfRoutines.size(); j++) {
    			for (int k = 0; k < listOfRoutines.get(i).getWorkoutForRoutine().length; k++) {
            		if (listOfRoutines.get(j).getWorkoutForRoutine()[k].getWorkout().getName().equals(workoutList.get(i).getName())) {
            			routinesList.add(listOfRoutines.get(j));
            		}
            	}
        	}
    	}

    	/*
    	for (int i = 0; i < listOfRoutines.size(); i++) {
    		for (int j = 0; j < listOfRoutines.get(i).getWorkoutForRoutine().length - 1; j++) {
        		if (listOfRoutines.get(i).getWorkoutForRoutine()[j].getWorkout().getName().equals(workout.getName())) {
        			routinesList.add(listOfRoutines.get(i));
        		}
        	}
    	}
    	*/
    	/*
    	for (int j = 0; j < routine.getWorkoutForRoutine().length - 1; j++) {
    		if (routine.getWorkoutForRoutine()[j].getWorkout().getName().equals(workout.getName())) {
    			return true;
    		}
    	}
    	return false;
    	*/
    	return routinesList;
    }

	public List<Workout> checkFavoriteRoutines(String day) {
    	List<Workout> workoutsList = new ArrayList<>();

    	for (int i = 0; i < listOfRoutines.size(); i++) {
    		if (listOfRoutines.get(i).isFavorite()) {
	    		for (int j = 0; j < listOfRoutines.get(i).getWorkoutForRoutine().length; j++) {
	    			if ((listOfRoutines.get(i).getWorkoutForRoutine()[j].getDate()).equalsIgnoreCase(day)) {
	    				workoutsList.add(listOfRoutines.get(i).getWorkoutForRoutine()[j].getWorkout());
	    			}
	    		}
    		}
    	}

    	return workoutsList;
    }

}