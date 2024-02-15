package csi_2999_package;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class CountdownTimer {
	private JFrame window;
	private JButton buttonSkip;
	private Timer timer;
	private int second, minute, stoppedTime;

	private boolean pause = false;
	private boolean autoAdvance = false;
	
	private String ddSecond;
	private String ddMinute;
	private DecimalFormat dFormat = new DecimalFormat("00");

	private ExerciseForWorkout currentExercise;
	private int marker, stop;

	public CountdownTimer() {

	}

	public void assisstantStartUp(Workout workout) {
		window = new JFrame();
		window.setFont(new Font("Courier New", Font.BOLD, 18));
		window.setAlwaysOnTop(true);
		window.setTitle("Workout Assisstant");
		window.setResizable(false);
		window.setSize(800, 600);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		window.getContentPane().setLayout(null);

		window.setVisible(true);

		marker = 0;
		stop = workout.getWorkoutSize() - 1;
		createWorkoutPanel(workout, workout.getExerciseForWorkout(marker));
	}

	public void createWorkoutPanel(Workout workout, ExerciseForWorkout exerciseForWorkout) {
		currentExercise = exerciseForWorkout;
		JPanel workoutAssistantPanelExercise = new JPanel();
		workoutAssistantPanelExercise.setBounds(0, 0, 784, 561);
		window.getContentPane().add(workoutAssistantPanelExercise);
		workoutAssistantPanelExercise.setLayout(null);

		if (exerciseForWorkout.getReps() == 0) {
			JLabel counterLabel = new JLabel();
			counterLabel.setBounds(26, 292, 354, 162);
			counterLabel.setHorizontalAlignment(SwingConstants.CENTER);
			counterLabel.setFont(new Font("Courier New", Font.PLAIN, 75));
			countdownSetUp(counterLabel, (int) exerciseForWorkout.getTime());
			workoutAssistantPanelExercise.add(counterLabel);

			JTextArea timerOrReps = new JTextArea();
			timerOrReps.setWrapStyleWord(true);
			timerOrReps.setText("TIMER:");
			timerOrReps.setLineWrap(true);
			timerOrReps.setFont(new Font("Courier New", Font.PLAIN, 30));
			timerOrReps.setEditable(false);
			timerOrReps.setBackground(SystemColor.menu);
			timerOrReps.setBounds(26, 235, 354, 42);
			workoutAssistantPanelExercise.add(timerOrReps);

			JButton buttonPause = new JButton("PAUSE");
			buttonPause.setFont(new Font("Courier New", Font.PLAIN, 22));
			buttonPause.setFocusPainted(false);
			buttonPause.setBackground(SystemColor.menu);
			buttonPause.addActionListener(new ActionListener() {
				@Override public void actionPerformed(ActionEvent e) {
					if (pause) {
						pause = false;
						buttonPause.setText("PAUSE");
						countdownSetUp(counterLabel, stoppedTime);
					} else {
						pause = true;
						timer.stop();
						buttonPause.setText("UNPAUSE");
						stoppedTime = second + (minute * 60);
					}
				}
			});
			buttonPause.setBounds(27, 519, 125, 31);
			workoutAssistantPanelExercise.add(buttonPause);

			buttonSkip = new JButton("SKIP");
			buttonSkip.setFont(new Font("Courier New", Font.PLAIN, 22));
			buttonSkip.setFocusPainted(false);
			buttonSkip.setBackground(SystemColor.menu);
			buttonSkip.addActionListener(new ActionListener() {
				@Override public void actionPerformed(ActionEvent e) {
					timer.stop();
					workoutAssistantPanelExercise.setVisible(false);
					createBreakPanel(workout, exerciseForWorkout);
				}
			});
			buttonSkip.setBounds(623, 519, 125, 31);
			workoutAssistantPanelExercise.add(buttonSkip);

		} else {

			JLabel repLabel = new JLabel();
			repLabel.setBounds(26, 292, 354, 162);
			repLabel.setHorizontalAlignment(SwingConstants.CENTER);
			repLabel.setFont(new Font("Courier New", Font.PLAIN, 75));
			repLabel.setText("" + exerciseForWorkout.getReps());
			workoutAssistantPanelExercise.add(repLabel);

			JTextArea timerOrReps = new JTextArea();
			timerOrReps.setWrapStyleWord(true);
			timerOrReps.setText("REPS:");
			timerOrReps.setLineWrap(true);
			timerOrReps.setFont(new Font("Courier New", Font.PLAIN, 30));
			timerOrReps.setEditable(false);
			timerOrReps.setBackground(SystemColor.menu);
			timerOrReps.setBounds(26, 235, 354, 42);
			workoutAssistantPanelExercise.add(timerOrReps);

			buttonSkip = new JButton("NEXT");
			buttonSkip.setFont(new Font("Courier New", Font.PLAIN, 22));
			buttonSkip.setFocusPainted(false);
			buttonSkip.setBackground(SystemColor.menu);
			buttonSkip.addActionListener(new ActionListener() {
				@Override public void actionPerformed(ActionEvent e) {
					workoutAssistantPanelExercise.setVisible(false);
					createBreakPanel(workout, exerciseForWorkout);
				}
			});
			buttonSkip.setBounds(623, 519, 125, 31);
			workoutAssistantPanelExercise.add(buttonSkip);

		}

		JScrollPane scrollPaneSteps = new JScrollPane();
		scrollPaneSteps.setViewportBorder(null);
		scrollPaneSteps.setBounds(390, 200, 356, 254);
		scrollPaneSteps.setBorder(new EmptyBorder(0, 0, 0, 0));
		workoutAssistantPanelExercise.add(scrollPaneSteps);

		JPanel exerciseStepsPanel = new JPanel();
		scrollPaneSteps.setViewportView(exerciseStepsPanel);
		exerciseStepsPanel.setLayout(null);

		JTextArea exerciseSteps = new JTextArea();
		exerciseSteps.setFont(new Font("Courier New", Font.PLAIN, 20));
		exerciseSteps.setLineWrap(true);
		exerciseSteps.setText(exerciseForWorkout.getExercise().getSteps());
		exerciseSteps.setWrapStyleWord(true);
		exerciseSteps.setEditable(false);
		exerciseSteps.setBackground(SystemColor.menu);
		exerciseSteps.setBounds(0, 0, 354, 252);
		exerciseStepsPanel.add(exerciseSteps);

		JTextArea exerciseName = new JTextArea();
		exerciseName.setText(exerciseForWorkout.getExercise().getName().toUpperCase());
		exerciseName.setWrapStyleWord(true);
		exerciseName.setLineWrap(true);
		exerciseName.setFont(new Font("Courier New", Font.PLAIN, 60));
		exerciseName.setEditable(false);
		exerciseName.setBackground(SystemColor.menu);
		exerciseName.setBounds(26, 11, 354, 213);
		workoutAssistantPanelExercise.add(exerciseName);

	}

	public void createBreakPanel(Workout workout, ExerciseForWorkout exerciseForWorkout) {
		JPanel workoutAssistantPanelExercise = new JPanel();
		workoutAssistantPanelExercise.setBounds(0, 0, 784, 561);
		window.getContentPane().add(workoutAssistantPanelExercise);
		workoutAssistantPanelExercise.setLayout(null);

		JTextArea exerciseName = new JTextArea();
		exerciseName.setText("ENJOY YOUR BREAK");
		exerciseName.setWrapStyleWord(true);
		exerciseName.setLineWrap(true);
		exerciseName.setFont(new Font("Courier New", Font.PLAIN, 60));
		exerciseName.setEditable(false);
		exerciseName.setBackground(SystemColor.menu);
		exerciseName.setBounds(26, 11, 354, 213);
		workoutAssistantPanelExercise.add(exerciseName);

		JLabel counterLabel = new JLabel();
		counterLabel.setBounds(26, 292, 354, 162);
		counterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		counterLabel.setFont(new Font("Courier New", Font.PLAIN, 75));
		countdownSetUp(counterLabel, (int) exerciseForWorkout.getBreakTime());
		workoutAssistantPanelExercise.add(counterLabel);

		JTextArea timerOrReps = new JTextArea();
		timerOrReps.setWrapStyleWord(true);
		timerOrReps.setText("TIMER:");
		timerOrReps.setLineWrap(true);
		timerOrReps.setFont(new Font("Courier New", Font.PLAIN, 30));
		timerOrReps.setEditable(false);
		timerOrReps.setBackground(SystemColor.menu);
		timerOrReps.setBounds(26, 235, 354, 42);
		workoutAssistantPanelExercise.add(timerOrReps);

		JScrollPane scrollPaneSteps = new JScrollPane();
		scrollPaneSteps.setViewportBorder(null);
		scrollPaneSteps.setBounds(390, 200, 356, 254);
		scrollPaneSteps.setBorder(new EmptyBorder(0, 0, 0, 0));
		workoutAssistantPanelExercise.add(scrollPaneSteps);

		JPanel exerciseStepsPanel = new JPanel();
		scrollPaneSteps.setViewportView(exerciseStepsPanel);
		exerciseStepsPanel.setLayout(null);

		JTextArea exerciseSteps = new JTextArea();
		exerciseSteps.setFont(new Font("Courier New", Font.PLAIN, 20));
		exerciseSteps.setLineWrap(true);
		exerciseSteps.setText("include suggestions / flavor text during breaks here");
		exerciseSteps.setWrapStyleWord(true);
		exerciseSteps.setEditable(false);
		exerciseSteps.setBackground(SystemColor.menu);
		exerciseSteps.setBounds(0, 0, 354, 252);
		exerciseStepsPanel.add(exerciseSteps);

		JButton buttonPause = new JButton("PAUSE");
		buttonPause.setFont(new Font("Courier New", Font.PLAIN, 22));
		buttonPause.setFocusPainted(false);
		buttonPause.setBackground(SystemColor.menu);
		buttonPause.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				if (pause) {
					pause = false;
					buttonPause.setText("PAUSE");
					countdownSetUp(counterLabel, stoppedTime);
				} else {
					pause = true;
					timer.stop();
					buttonPause.setText("UNPAUSE");
					stoppedTime = second + (minute * 60);
				}
			}
		});
		buttonPause.setBounds(27, 519, 125, 31);
		workoutAssistantPanelExercise.add(buttonPause);

		buttonSkip = new JButton("SKIP");
		buttonSkip.setFont(new Font("Courier New", Font.PLAIN, 22));
		buttonSkip.setFocusPainted(false);
		buttonSkip.setBackground(SystemColor.menu);
		buttonSkip.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				timer.stop();
				workoutAssistantPanelExercise.setVisible(false);
				marker++;
				if (marker != stop + 1) {
					createWorkoutPanel(workout, workout.getExerciseForWorkout(marker));
				} else {
					createFinishPanel(workout);
				}
			}
		});
		buttonSkip.setBounds(623, 519, 125, 31);
		workoutAssistantPanelExercise.add(buttonSkip);
	}
	
	public void createFinishPanel(Workout workout) {
		JPanel workoutAssistantPanelExercise = new JPanel();
		workoutAssistantPanelExercise.setBounds(0, 0, 784, 561);
		window.getContentPane().add(workoutAssistantPanelExercise);
		workoutAssistantPanelExercise.setLayout(null);

		JTextArea exerciseName = new JTextArea();
		exerciseName.setText("CONGRATULATIONS YOU HAVE FINISHED " + workout.getName().toUpperCase());
		exerciseName.setWrapStyleWord(true);
		exerciseName.setLineWrap(true);
		exerciseName.setFont(new Font("Courier New", Font.PLAIN, 60));
		exerciseName.setEditable(false);
		exerciseName.setBackground(SystemColor.menu);
		exerciseName.setBounds(26, 11, 720, 335);
		workoutAssistantPanelExercise.add(exerciseName);

		JScrollPane scrollPaneSteps = new JScrollPane();
		scrollPaneSteps.setViewportBorder(null);
		scrollPaneSteps.setBounds(26, 357, 720, 128);
		scrollPaneSteps.setBorder(new EmptyBorder(0, 0, 0, 0));
		workoutAssistantPanelExercise.add(scrollPaneSteps);

		JPanel exerciseStepsPanel = new JPanel();
		scrollPaneSteps.setViewportView(exerciseStepsPanel);
		exerciseStepsPanel.setLayout(null);

		JTextArea exerciseSteps = new JTextArea();
		exerciseSteps.setFont(new Font("Courier New", Font.PLAIN, 20));
		exerciseSteps.setLineWrap(true);
		exerciseSteps.setText("include suggestions / flavor text for wrapping up");
		exerciseSteps.setWrapStyleWord(true);
		exerciseSteps.setEditable(false);
		exerciseSteps.setBackground(SystemColor.menu);
		exerciseSteps.setBounds(0, 0, 720, 252);
		exerciseStepsPanel.add(exerciseSteps);

		buttonSkip = new JButton("FINISH");
		buttonSkip.setFont(new Font("Courier New", Font.PLAIN, 22));
		buttonSkip.setFocusPainted(false);
		buttonSkip.setBackground(SystemColor.menu);
		buttonSkip.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				window.dispose();
			}
		});
		buttonSkip.setBounds(623, 519, 125, 31);
		workoutAssistantPanelExercise.add(buttonSkip);
	}

	public void startWeekDayClock(JLabel label) {
		weekDayClock(label);
		timer.start();
	}

	public void weekDayClock(JLabel label) {
		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String CURRENT_WEEK_DATE = LocalDate.now().getDayOfWeek().name();
				label.setText(CURRENT_WEEK_DATE);
			}

		});

	}

	public void startClock(JLabel label) {
		clock(label);
		timer.start();
	}

	public void clock(JLabel label) {
		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LocalDateTime now = LocalDateTime.now();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
				String formattedDateTime = now.format(formatter);
				label.setText(formattedDateTime);
			}

		});

	}

	public void startDateClock(JLabel label) {
		dateClock(label);
		timer.start();
	}

	public void dateClock(JLabel label) {
		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/dd/uuuu");
				LocalDate CURRENT_DATE = LocalDate.now();
				String date = CURRENT_DATE.format(formatters);
				label.setText(date);
			}

		});

	}

	public void countdownSetUp(JLabel label, int timeInSeconds) {
		minute = ((timeInSeconds % 86400) % 3600) / 60;
		second = ((timeInSeconds % 86400) % 3600) % 60;

		ddMinute = dFormat.format(minute);
		ddSecond = dFormat.format(second);

		label.setText(ddMinute + ":" + ddSecond);

		countdownTimer(label);
		timer.start();
	}

	public void countdownTimer(JLabel label) {
		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				second--;
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);
				label.setText(ddMinute + ":" + ddSecond);

				if (second == -1) {
					second = 59;
					minute--;
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);
					label.setText(ddMinute + ":" + ddSecond);
				}

				if (minute == 0 && second == 0) {
					timer.stop();
					if (autoAdvance) {
						
					} else {
						buttonSkip.setText("NEXT");
					}
				}

			}
		});
	}

	public void setAutoAdvance(boolean autoAdvance) {
		this.autoAdvance = autoAdvance;
		System.out.println(autoAdvance);
	}
}