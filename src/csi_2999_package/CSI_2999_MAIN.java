package csi_2999_package;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public
class CSI_2999_MAIN extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane, menuPanel, startUpPanel, glossaryPanel, calendarPanel, settingsPanel, assistantPanel, exerciseListPanel,
	exercisesPanel, workoutsPanel, routineListPanel, workoutListPanel, routineFavoritesListPanel, workoutDetailsListPanel, routinesPanel,
	suggestedWorkoutListPanel, allWorkoutListPanel, listOfExercisesForWorkout;
	private ButtonGroup groupList;
	private JLabel weekdayLabel, dateLabel, timeLabel;
	
	private String location = "";
	private Font normalFont = new Font("Courier New", Font.PLAIN, 30);
	
	private Color backgroundColor = new Color(238, 238, 238);
	private Color textColor = Color.BLACK;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override public void run() {
				try {
					CSI_2999_MAIN frame = new CSI_2999_MAIN();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CSI_2999_MAIN() { showStartingScreen(); }

	public void closePanel(String location) {
		switch (location) {
		case "HOME":
			startUpPanel.setVisible(false);
			break;
		case "ASSISTANT":
			assistantPanel.setVisible(false);
			break;
		case "GLOSSARY":
			glossaryPanel.setVisible(false);
			break;
		case "CALENDAR":
			calendarPanel.setVisible(false);
			break;
		case "SETTINGS":
			settingsPanel.setVisible(false);
			break;
		default:
			break;
		}
	}

	public void createListPanels() {

		Glossary glossary = new Glossary();

		routineFavoritesListPanel = new JPanel();
		routineFavoritesListPanel.setLayout(new GridLayout(0, 1, 0, 0));

		routineListPanel = new JPanel();
		routineListPanel.setLayout(new GridLayout(0, 1, 0, 0));

		for (Routine element : glossary.listOfRoutines) {
			routineListPanel.add(createRoutineButton(element));
		}

		workoutListPanel = new JPanel();
		workoutListPanel.setLayout(new GridLayout(0, 1, 0, 0));

		for (Workout workout : glossary.listOfWorkouts) {
			workoutListPanel.add(createWorkoutButton(workout, 0));
		}

		allWorkoutListPanel = new JPanel();
		allWorkoutListPanel.setLayout(new GridLayout(0, 1, 0, 0));

		for (Workout workout : glossary.listOfWorkouts) {
			allWorkoutListPanel.add(createWorkoutButtonAssisstant(workout));
		}

		listOfExercisesForWorkout = new JPanel();
		listOfExercisesForWorkout.setLayout(new GridLayout(0, 1, 0, 0));

		groupList = new ButtonGroup();

		for (Exercise element : glossary.listOfExercises) {
			element.setCheckButton(createCheckButton(element));
			listOfExercisesForWorkout.add(element.getCheckButton());
			groupList.add(element.getCheckButton());
		}

		exerciseListPanel = new JPanel();
		exerciseListPanel.setLayout(new GridLayout(0, 1, 0, 0));

		for (Exercise exercise : glossary.listOfExercises) {
			exerciseListPanel.add(createButton(exercise, 0));
		}
		
		CountdownTimer timer = new CountdownTimer();
		
		weekdayLabel = new JLabel("");
		timer.startWeekDayClock(weekdayLabel);
		weekdayLabel.setFont(new Font("Courier New", Font.PLAIN, 20));
		weekdayLabel.setForeground(textColor);
		weekdayLabel.setBounds(18, 11, 90, 35);
		
		dateLabel = new JLabel("");
		timer.startDateClock(dateLabel);
		dateLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		dateLabel.setFont(new Font("Courier New", Font.PLAIN, 20));
		dateLabel.setForeground(textColor);
		dateLabel.setBounds(209, 11, 124, 35);
		
		timeLabel = new JLabel("");
		timer.startClock(timeLabel);
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setFont(new Font("Courier New", Font.PLAIN, 20));
		timeLabel.setForeground(textColor);
		timeLabel.setBounds(109, 11, 90, 35);
	}

	public void showStartingScreen() {
		createListPanels();
		
		location = "HOME";
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		menuPanel = new JPanel();
		menuPanel.setBackground(SystemColor.activeCaption);
		menuPanel.setBounds(0, 0, 1284, 761);
		contentPane.add(menuPanel);
		menuPanel.setLayout(null);

		JPanel mainMenuPanel = new JPanel();
		mainMenuPanel.setBounds(10, 11, 343, 671);
		menuPanel.add(mainMenuPanel);
		mainMenuPanel.setLayout(null);

		JButton startWorkoutButton = new JButton("Workout\r\n Assistant");
		startWorkoutButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				closePanel(location);
				showWorkoutAssistantPanel();
			}
		});
		startWorkoutButton.setBackground(backgroundColor);
		startWorkoutButton.setFocusable(false);
		startWorkoutButton.setFont(new Font("Courier New", Font.PLAIN, 20));
		startWorkoutButton.setForeground(textColor);
		startWorkoutButton.setBounds(25, 198, 289, 70);
		mainMenuPanel.add(startWorkoutButton);

		JButton glossaryButton = new JButton("Glossary");
		glossaryButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				closePanel(location);
				showGlossaryPanel();
			}
		});
		glossaryButton.setBackground(backgroundColor);
		glossaryButton.setFont(new Font("Courier New", Font.PLAIN, 20));
		glossaryButton.setForeground(textColor);
		glossaryButton.setFocusable(false);
		glossaryButton.setBounds(25, 315, 289, 70);
		mainMenuPanel.add(glossaryButton);

		JButton calendarButton = new JButton("Calendar");
		calendarButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				closePanel(location);
			}
		});
		calendarButton.setBackground(backgroundColor);
		calendarButton.setFont(new Font("Courier New", Font.PLAIN, 20));
		calendarButton.setForeground(textColor);
		calendarButton.setFocusable(false);
		calendarButton.setBounds(25, 432, 289, 70);
		mainMenuPanel.add(calendarButton);

		JButton settingsButton = new JButton("Settings");
		settingsButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				closePanel(location);
				showSettingsPanel();
			}
		});
		settingsButton.setBackground(backgroundColor);
		settingsButton.setFocusable(false);
		settingsButton.setFont(new Font("Courier New", Font.PLAIN, 20));
		settingsButton.setForeground(textColor);
		settingsButton.setBounds(25, 549, 289, 70);
		mainMenuPanel.add(settingsButton);

		JLabel lblNewLabel = new JLabel("TITLE HERE");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 40));
		lblNewLabel.setForeground(textColor);
		lblNewLabel.setBounds(25, 47, 290, 104);
		mainMenuPanel.add(lblNewLabel);

		JPanel bottomPanel = new JPanel();
		bottomPanel.setBounds(10, 693, 343, 57);
		menuPanel.add(bottomPanel);
		bottomPanel.setLayout(null);

		bottomPanel.add(weekdayLabel);
		
		bottomPanel.add(dateLabel);
		
		bottomPanel.add(timeLabel);

		startUpPanel = new JPanel();
		startUpPanel.setBounds(363, 11, 911, 739);
		menuPanel.add(startUpPanel);
		startUpPanel.setLayout(null);

		JTextArea txtrClickOnThe = new JTextArea();
		txtrClickOnThe.setText("Click on the Workout Assistant to start a Workout");
		txtrClickOnThe.setWrapStyleWord(true);
		txtrClickOnThe.setLineWrap(true);
		txtrClickOnThe.setFont(new Font("Courier New", Font.PLAIN, 30));
		txtrClickOnThe.setForeground(textColor);
		txtrClickOnThe.setEditable(false);
		txtrClickOnThe.setBackground(backgroundColor);
		txtrClickOnThe.setBounds(53, 198, 704, 72);
		startUpPanel.add(txtrClickOnThe);

		JTextArea txtrClickOnThe_1 = new JTextArea();
		txtrClickOnThe_1.setWrapStyleWord(true);
		txtrClickOnThe_1.setText("Click on the Glossary to view and edit Routines, Workouts, and Exercises");
		txtrClickOnThe_1.setLineWrap(true);
		txtrClickOnThe_1.setEditable(false);
		txtrClickOnThe_1.setFont(new Font("Courier New", Font.PLAIN, 30));
		txtrClickOnThe_1.setForeground(textColor);
		txtrClickOnThe_1.setBackground(backgroundColor);
		txtrClickOnThe_1.setBounds(53, 315, 704, 72);
		startUpPanel.add(txtrClickOnThe_1);

		JTextArea txtrClickOnThe_2_1 = new JTextArea();
		txtrClickOnThe_2_1.setWrapStyleWord(true);
		txtrClickOnThe_2_1.setText("Click on the Calendar to view your schedule and to view progress");
		txtrClickOnThe_2_1.setLineWrap(true);
		txtrClickOnThe_2_1.setEditable(false);
		txtrClickOnThe_2_1.setFont(new Font("Courier New", Font.PLAIN, 30));
		txtrClickOnThe_2_1.setForeground(textColor);
		txtrClickOnThe_2_1.setBackground(backgroundColor);
		txtrClickOnThe_2_1.setBounds(53, 432, 704, 72);
		startUpPanel.add(txtrClickOnThe_2_1);

		JTextArea txtrClickOnThe_2_1_1 = new JTextArea();
		txtrClickOnThe_2_1_1.setWrapStyleWord(true);
		txtrClickOnThe_2_1_1.setText("Click on the Settings to change the default settings or for help\r\n");
		txtrClickOnThe_2_1_1.setLineWrap(true);
		txtrClickOnThe_2_1_1.setEditable(false);
		txtrClickOnThe_2_1_1.setFont(new Font("Courier New", Font.PLAIN, 30));
		txtrClickOnThe_2_1_1.setForeground(textColor);
		txtrClickOnThe_2_1_1.setBackground(backgroundColor);
		txtrClickOnThe_2_1_1.setBounds(53, 549, 704, 72);
		startUpPanel.add(txtrClickOnThe_2_1_1);

		JLabel lblButtonExplanations = new JLabel("Want to Get Started..?");
		lblButtonExplanations.setHorizontalAlignment(SwingConstants.CENTER);
		lblButtonExplanations.setFont(new Font("Courier New", Font.PLAIN, 40));
		lblButtonExplanations.setForeground(textColor);
		lblButtonExplanations.setBounds(63, 47, 785, 104);
		startUpPanel.add(lblButtonExplanations);
	}

	/*
	 *
	 * creating UI for workoutAssistant
	 *
	 */

	public void showWorkoutAssistantPanel() {
		location = "ASSISTANT";
		assistantPanel = new JPanel();
		assistantPanel.setBounds(363, 11, 911, 739);
		menuPanel.add(assistantPanel);
		assistantPanel.setLayout(null);

		JPanel assistantPanelmainPanel = new JPanel();
		assistantPanelmainPanel.setBounds(0, 0, 911, 739);
		assistantPanel.add(assistantPanelmainPanel);
		assistantPanelmainPanel.setLayout(null);

		JTextArea suggestedWorkoutsLabel = new JTextArea();
		suggestedWorkoutsLabel.setWrapStyleWord(true);
		suggestedWorkoutsLabel.setText("Suggested Workouts from your favorited Routines");
		suggestedWorkoutsLabel.setLineWrap(true);
		suggestedWorkoutsLabel.setEditable(false);
		suggestedWorkoutsLabel.setFont(new Font("Courier New", Font.PLAIN, 22));
		suggestedWorkoutsLabel.setForeground(textColor);
		suggestedWorkoutsLabel.setBackground(backgroundColor);
		suggestedWorkoutsLabel.setBounds(10, 52, 891, 35);
		assistantPanelmainPanel.add(suggestedWorkoutsLabel);

		JLabel directionsLabel = new JLabel("Select a Workout to start the Workout Assistant");
		directionsLabel.setFont(new Font("Courier New", Font.PLAIN, 30));
		directionsLabel.setForeground(textColor);
		directionsLabel.setHorizontalAlignment(SwingConstants.LEADING);
		directionsLabel.setBounds(10, 11, 891, 35);
		assistantPanelmainPanel.add(directionsLabel);

		JScrollPane favoritedRoutinesScrollPane = new JScrollPane();
		favoritedRoutinesScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		favoritedRoutinesScrollPane.setBounds(10, 93, 891, 92);
		assistantPanelmainPanel.add(favoritedRoutinesScrollPane);

		suggestedWorkoutListPanel = new JPanel();
		favoritedRoutinesScrollPane.setViewportView(suggestedWorkoutListPanel);
		suggestedWorkoutListPanel.setLayout(new GridLayout(0, 1, 0, 0));

		JTextArea txtrAllWorkoutsLabel = new JTextArea();
		txtrAllWorkoutsLabel.setWrapStyleWord(true);
		txtrAllWorkoutsLabel.setText("All Workouts");
		txtrAllWorkoutsLabel.setLineWrap(true);
		txtrAllWorkoutsLabel.setEditable(false);
		txtrAllWorkoutsLabel.setFont(new Font("Courier New", Font.PLAIN, 22));
		txtrAllWorkoutsLabel.setForeground(textColor);
		txtrAllWorkoutsLabel.setBackground(backgroundColor);
		txtrAllWorkoutsLabel.setBounds(10, 196, 891, 35);
		assistantPanelmainPanel.add(txtrAllWorkoutsLabel);

		JScrollPane allWorkOutsScrollPane = new JScrollPane();
		allWorkOutsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		allWorkOutsScrollPane.setBounds(10, 237, 891, 493);
		assistantPanelmainPanel.add(allWorkOutsScrollPane);

		allWorkOutsScrollPane.setViewportView(allWorkoutListPanel);
	}

	public void assistantStartUp(Workout workout) {
		CountdownTimer timer = new CountdownTimer();
		timer.assisstantStartUp(workout);
	}

	/*
	 *
	 * creating UI for glossary
	 *
	 */

	public void showGlossaryPanel() {
		location = "GLOSSARY";
		glossaryPanel = new JPanel();
		glossaryPanel.setBounds(363, 11, 911, 739);
		menuPanel.add(glossaryPanel);
		glossaryPanel.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBounds(0, 0, 911, 739);
		glossaryPanel.add(tabbedPane);

		routinesPanel = new JPanel();
		tabbedPane.addTab("Routines", null, routinesPanel, null);
		routinesPanel.setLayout(null);
		createTabRoutines();

		workoutsPanel = new JPanel();
		tabbedPane.addTab("Workouts", null, workoutsPanel, null);
		workoutsPanel.setLayout(null);
		createTabWorkouts();

		exercisesPanel = new JPanel();
		tabbedPane.addTab("Exercises", null, exercisesPanel, null);
		exercisesPanel.setLayout(null);
		createTabExercises();
	}

	/*
	 *
	 * creating UI for glossary routines
	 *
	 */

	public void createTabRoutines() {
		JTextArea routinePanelExplaination = new JTextArea();
		routinePanelExplaination.setBackground(backgroundColor);
		routinePanelExplaination.setFont(new Font("Courier New", Font.PLAIN, 22));
		routinePanelExplaination.setForeground(textColor);
		routinePanelExplaination.setLineWrap(true);
		routinePanelExplaination.setWrapStyleWord(true);
		routinePanelExplaination.setEditable(false);
		routinePanelExplaination.setText("This is a list of all your currently saved Routines. Click on an Routine to view it's details.");
		routinePanelExplaination.setBounds(10, 11, 869, 70);
		routinesPanel.add(routinePanelExplaination);

		JScrollPane routineListPanelScroll = new JScrollPane();
		routineListPanelScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		routineListPanelScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		routineListPanelScroll.setBounds(10, 327, 886, 373);
		routinesPanel.add(routineListPanelScroll);

		routineListPanelScroll.setViewportView(routineListPanel);

		JButton routineQuiz = new JButton("Routine Suggestion Quiz");
		routineQuiz.setBackground(backgroundColor);
		routineQuiz.setFont(new Font("Courier New", Font.PLAIN, 22));
		routineQuiz.setForeground(textColor);
		routineQuiz.setFocusPainted(false);
		routineQuiz.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				Quiz quiz = new Quiz("Test", new String[]{"test"});
				quiz.quizWindow();
			}
		});
		routineQuiz.setBounds(460, 90, 440, 45);
		routinesPanel.add(routineQuiz);

		JButton addNewRoutineButton = new JButton("Add A New Routine");
		addNewRoutineButton.setFont(new Font("Courier New", Font.PLAIN, 22));
		addNewRoutineButton.setForeground(textColor);
		addNewRoutineButton.setFocusPainted(false);
		addNewRoutineButton.setBackground(backgroundColor);
		addNewRoutineButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
			}
		});
		addNewRoutineButton.setBounds(10, 90, 440, 45);
		routinesPanel.add(addNewRoutineButton);

		JScrollPane favoriteRoutinesScrollPane = new JScrollPane();
		favoriteRoutinesScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		favoriteRoutinesScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		favoriteRoutinesScrollPane.setBounds(10, 169, 886, 118);
		routinesPanel.add(favoriteRoutinesScrollPane);

		favoriteRoutinesScrollPane.setViewportView(routineFavoritesListPanel);

		JLabel favoriteRoutinesLabel = new JLabel("Favorite Routines");
		favoriteRoutinesLabel.setFont(new Font("Courier New", Font.PLAIN, 17));
		favoriteRoutinesLabel.setForeground(textColor);
		favoriteRoutinesLabel.setBounds(10, 146, 190, 12);
		routinesPanel.add(favoriteRoutinesLabel);

		JLabel allRoutinesLabel = new JLabel("All Routines");
		allRoutinesLabel.setFont(new Font("Courier New", Font.PLAIN, 17));
		allRoutinesLabel.setForeground(textColor);
		allRoutinesLabel.setBounds(10, 298, 190, 18);
		routinesPanel.add(allRoutinesLabel);
	}

	public JButton createRoutineButton(Routine routine) {
		JButton button = new JButton(routine.getName());
		button.setBackground(backgroundColor);
		button.setFont(normalFont);
		button.setFocusPainted(false);
		button.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				createRoutineWindow(routine);
			}
		});
		routine.setButton(button);
		return button;
	}

	public void createRoutineWindow(Routine routine) {
		JFrame window = new JFrame();
		window.setTitle(routine.getName());
		window.setResizable(false);
		window.setBounds(100, 100, 800, 649);

		window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		JPanel routineDetails = new JPanel();
		routineDetails.setBorder(new EmptyBorder(5, 5, 5, 5));

		window.setContentPane(routineDetails);
		routineDetails.setLayout(null);

		JButton deleteRoutine = new JButton("Delete Routine?");
		deleteRoutine.setFont(new Font("Courier New", Font.PLAIN, 15));
		deleteRoutine.setForeground(textColor);
		deleteRoutine.setFocusPainted(false);
		deleteRoutine.setBackground(backgroundColor);
		deleteRoutine.setBounds(11, 576, 200, 23);
		deleteRoutine.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				JFrame windowDelete = new JFrame();
				windowDelete.setResizable(false);
				windowDelete.setBounds(100, 100, 697, 232);

				windowDelete.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
				JPanel deleteExerciseWarning = new JPanel();
				deleteExerciseWarning.setBorder(new EmptyBorder(5, 5, 5, 5));

				windowDelete.setContentPane(deleteExerciseWarning);
				deleteExerciseWarning.setLayout(null);

				JLabel lblNewLabel = new JLabel("Are you sure you would like to delete this routine:");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 20));
				lblNewLabel.setForeground(textColor);
				lblNewLabel.setBounds(10, 47, 661, 14);
				deleteExerciseWarning.add(lblNewLabel);

				JButton yesButton = new JButton("YES");
				yesButton.setFont(new Font("Courier New", Font.PLAIN, 15));
				yesButton.setForeground(textColor);
				yesButton.setBounds(167, 141, 89, 23);
				yesButton.setBackground(backgroundColor);
				yesButton.setFocusPainted(false);
				yesButton.addActionListener(new ActionListener() {
					@Override public void actionPerformed(ActionEvent e) {
						Glossary glossary = new Glossary();
						removeRoutine(glossary, routine);
						repaint();
						windowDelete.dispose();
						window.dispose();
					}
				});
				deleteExerciseWarning.add(yesButton);

				JButton noButton = new JButton("NO");
				noButton.setFont(new Font("Courier New", Font.PLAIN, 15));
				noButton.setForeground(textColor);
				noButton.setBounds(423, 141, 89, 23);
				noButton.setBackground(backgroundColor);
				noButton.setFocusPainted(false);
				noButton.addActionListener(new ActionListener() {
					@Override public void actionPerformed(ActionEvent e) {
						windowDelete.dispose();
					}
				});
				deleteExerciseWarning.add(noButton);

				JLabel lblNewLabel_1 = new JLabel(routine.getName());
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setFont(new Font("Courier New", Font.PLAIN, 20));
				lblNewLabel_1.setForeground(textColor);
				lblNewLabel_1.setBounds(10, 92, 661, 14);
				deleteExerciseWarning.add(lblNewLabel_1);

				windowDelete.setVisible(true);
			}
		});
		routineDetails.add(deleteRoutine);

		JLabel workoutTitleLabel = new JLabel(routine.getName());
		workoutTitleLabel.setBounds(112, 0, 559, 65);
		routineDetails.add(workoutTitleLabel);
		workoutTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		workoutTitleLabel.setFont(new Font("Courier New", Font.PLAIN, 40));
		workoutTitleLabel.setForeground(textColor);

		JScrollPane routineDetailsScrollPane = new JScrollPane();
		routineDetailsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		routineDetailsScrollPane.setBounds(12, 65, 762, 500);
		routineDetails.add(routineDetailsScrollPane);

		JButton btnFavoriteRoutine = new JButton("Favorite");


		if (routine.isFavorite()) {
			btnFavoriteRoutine.setText("Unfavorite");
		}

		btnFavoriteRoutine.setFont(new Font("Courier New", Font.PLAIN, 15));
		btnFavoriteRoutine.setForeground(textColor);
		btnFavoriteRoutine.setFocusPainted(false);
		btnFavoriteRoutine.setBackground(backgroundColor);
		btnFavoriteRoutine.setBounds(574, 576, 200, 23);
		btnFavoriteRoutine.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				if (routine.isFavorite()) {
					routine.setFavorite(false);
					routineFavoritesListPanel.remove(routine.getButton());
					routineListPanel.add(routine.getButton());
					btnFavoriteRoutine.setText("Favorite");
					window.repaint();
					glossaryPanel.repaint();
				} else {
					routine.setFavorite(true);
					routineFavoritesListPanel.add(routine.getButton());
					routineListPanel.remove(routine.getButton());
					btnFavoriteRoutine.setText("Unfavorite");
					window.repaint();
					glossaryPanel.repaint();
				}
			}
		});

		routineDetails.add(btnFavoriteRoutine);

		JPanel weekDayPanels = new JPanel();
		routineDetailsScrollPane.setViewportView(weekDayPanels);
		weekDayPanels.setLayout(new GridLayout(0, 1, 0, 0));


		for (int i = 1; i < routine.getType() + 1; i++) {

			if (1 < routine.getType()) {
				JPanel weekPanel = new JPanel();
				weekDayPanels.add(weekPanel);
				weekPanel.setLayout(new GridLayout(0, 3, 0, 0));

				JLabel weekLabel = new JLabel("──────────────────");
				weekLabel.setHorizontalAlignment(SwingConstants.CENTER);
				weekLabel.setFont(new Font("Courier New", Font.BOLD, 18));
				weekLabel.setForeground(textColor);
				weekPanel.add(weekLabel);

				JLabel weekLabel2 = new JLabel("WEEK " + i);
				weekLabel2.setHorizontalAlignment(SwingConstants.CENTER);
				weekLabel2.setFont(new Font("Courier New", Font.BOLD, 18));
				weekLabel2.setForeground(textColor);
				weekPanel.add(weekLabel2);

				JLabel weekLabel3 = new JLabel("──────────────────");
				weekLabel3.setHorizontalAlignment(SwingConstants.CENTER);
				weekLabel3.setFont(new Font("Courier New", Font.BOLD, 18));
				weekLabel3.setForeground(textColor);
				weekPanel.add(weekLabel3);

				createWorkoutListForRoutineTab(routine.getWeek(i), weekDayPanels, routineDetailsScrollPane);
			} else {
				createWorkoutListForRoutineTab(routine, weekDayPanels, routineDetailsScrollPane);
			}
		}

		window.setVisible(true);
	}

	public void removeRoutine(Glossary glossary, Routine routine) {
		//done in an excessive manner to ensure safe removal
		if (routine.isFavorite()) {
			for( int i = 0; i < routineFavoritesListPanel.getComponentCount(); i++ ) {
				if(routineFavoritesListPanel.getComponent(i) instanceof JButton) {
					JButton routineButton = (JButton) routineFavoritesListPanel.getComponent(i);
					if (routineButton.getText().equals(routine.getName())) {
						routineFavoritesListPanel.remove(routineButton);
					}
				}
			}
		} else {
			for( int i = 0; i < routineListPanel.getComponentCount(); i++ ) {
				if(routineListPanel.getComponent(i) instanceof JButton) {
					JButton routineButton = (JButton) routineListPanel.getComponent(i);
					if (routineButton.getText().equals(routine.getName())) {
						routineListPanel.remove(routineButton);
					}
				}
			}
		}
		glossary.removeRoutine(routine);
	}

	public void createWorkoutListForRoutineTab(Routine routine, JPanel weekDayPanels, JScrollPane routineDetailsScrollPane) {

		JPanel mondayPanel = new JPanel();
		weekDayPanels.add(mondayPanel);
		mondayPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel mondayLabel = new JLabel("MONDAY");
		mondayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mondayLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
		mondayLabel.setForeground(textColor);
		mondayPanel.add(mondayLabel);

		JLabel mondayTime = new JLabel("BREAK");
		mondayTime.setHorizontalAlignment(SwingConstants.CENTER);
		mondayTime.setFont(new Font("Courier New", Font.PLAIN, 15));
		mondayTime.setForeground(textColor);
		mondayPanel.add(mondayTime);

		JPanel tuesdayPanel = new JPanel();
		weekDayPanels.add(tuesdayPanel);
		tuesdayPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel tuesdayLabel = new JLabel("TUESDAY");
		tuesdayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tuesdayLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
		tuesdayLabel.setForeground(textColor);
		tuesdayPanel.add(tuesdayLabel);

		JLabel tuesdayTime = new JLabel("BREAK");
		tuesdayTime.setHorizontalAlignment(SwingConstants.CENTER);
		tuesdayTime.setFont(new Font("Courier New", Font.PLAIN, 15));
		tuesdayTime.setForeground(textColor);
		tuesdayPanel.add(tuesdayTime);

		JPanel wednesdayPanel = new JPanel();
		weekDayPanels.add(wednesdayPanel);
		wednesdayPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel wednesdayLabel = new JLabel("WEDNESDAY");
		wednesdayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wednesdayLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
		wednesdayLabel.setForeground(textColor);
		wednesdayPanel.add(wednesdayLabel);

		JLabel wednesdayTime = new JLabel("BREAK");
		wednesdayTime.setHorizontalAlignment(SwingConstants.CENTER);
		wednesdayTime.setFont(new Font("Courier New", Font.PLAIN, 15));
		wednesdayTime.setForeground(textColor);
		wednesdayPanel.add(wednesdayTime);

		JPanel thursdayPanel = new JPanel();
		weekDayPanels.add(thursdayPanel);
		thursdayPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel thursdayLabel = new JLabel("THURSDAY");
		thursdayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		thursdayLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
		thursdayLabel.setForeground(textColor);
		thursdayPanel.add(thursdayLabel);

		JLabel thursdayTime = new JLabel("BREAK");
		thursdayTime.setHorizontalAlignment(SwingConstants.CENTER);
		thursdayTime.setFont(new Font("Courier New", Font.PLAIN, 15));
		thursdayTime.setForeground(textColor);
		thursdayPanel.add(thursdayTime);

		JPanel fridayPanel = new JPanel();
		weekDayPanels.add(fridayPanel);
		fridayPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel fridayLabel = new JLabel("FRIDAY");
		fridayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fridayLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
		fridayLabel.setForeground(textColor);
		fridayPanel.add(fridayLabel);

		JLabel fridayTime = new JLabel("BREAK");
		fridayTime.setHorizontalAlignment(SwingConstants.CENTER);
		fridayTime.setFont(new Font("Courier New", Font.PLAIN, 15));
		fridayTime.setForeground(textColor);
		fridayPanel.add(fridayTime);

		JPanel saturdayPanel = new JPanel();
		weekDayPanels.add(saturdayPanel);
		saturdayPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel saturdayLabel = new JLabel("SATURDAY");
		saturdayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		saturdayLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
		saturdayLabel.setForeground(textColor);
		saturdayPanel.add(saturdayLabel);

		JLabel saturdayTime = new JLabel("BREAK");
		saturdayTime.setHorizontalAlignment(SwingConstants.CENTER);
		saturdayTime.setFont(new Font("Courier New", Font.PLAIN, 15));
		saturdayTime.setForeground(textColor);
		saturdayPanel.add(saturdayTime);

		JPanel sundayPanel = new JPanel();
		weekDayPanels.add(sundayPanel);
		sundayPanel.setLayout(new GridLayout(0, 3, 0, 0));

		JLabel sundayLabel = new JLabel("SUNDAY");
		sundayLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sundayLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
		sundayLabel.setForeground(textColor);
		sundayPanel.add(sundayLabel);

		JLabel sundayTime = new JLabel("BREAK");
		sundayTime.setHorizontalAlignment(SwingConstants.CENTER);
		sundayTime.setFont(new Font("Courier New", Font.PLAIN, 15));
		sundayTime.setForeground(textColor);
		sundayPanel.add(sundayTime);

		for (int j = 0; j < routine.getSize(); j++) {

			WorkoutForRoutine workoutForRoutine = routine.getWorkoutForRoutine()[j];

			switch (workoutForRoutine.getDate()) {

			case "MONDAY" :
				mondayTime.setText(workoutForRoutine.getTime());
				JButton monButton = createWorkoutButton(workoutForRoutine.getWorkout(), 1);
				monButton.setFont(new Font("Courier New", Font.PLAIN, 15));
				monButton.setForeground(textColor);
				mondayPanel.add(monButton);
				break;
			case "TUESDAY" :
				tuesdayTime.setText(workoutForRoutine.getTime());
				JButton tuesButton = createWorkoutButton(workoutForRoutine.getWorkout(), 1);
				tuesButton.setFont(new Font("Courier New", Font.PLAIN, 15));
				tuesButton.setForeground(textColor);
				tuesdayPanel.add(tuesButton);
				break;
			case "WEDNESDAY" :
				wednesdayTime.setText(workoutForRoutine.getTime());
				JButton wedButton = createWorkoutButton(workoutForRoutine.getWorkout(), 1);
				wedButton.setFont(new Font("Courier New", Font.PLAIN, 15));
				wedButton.setForeground(textColor);
				wednesdayPanel.add(wedButton);
				break;
			case "THURSDAY" :
				thursdayTime.setText(workoutForRoutine.getTime());
				JButton thuButton = createWorkoutButton(workoutForRoutine.getWorkout(), 1);
				thuButton.setFont(new Font("Courier New", Font.PLAIN, 15));
				thuButton.setForeground(textColor);
				thursdayPanel.add(thuButton);
				break;
			case "FRIDAY" :
				fridayTime.setText(workoutForRoutine.getTime());
				JButton friButton = createWorkoutButton(workoutForRoutine.getWorkout(), 1);
				friButton.setFont(new Font("Courier New", Font.PLAIN, 15));
				friButton.setForeground(textColor);
				fridayPanel.add(friButton);
				break;
			case "SATURDAY" :
				saturdayTime.setText(workoutForRoutine.getTime());
				JButton satButton = createWorkoutButton(workoutForRoutine.getWorkout(), 1);
				satButton.setFont(new Font("Courier New", Font.PLAIN, 15));
				satButton.setForeground(textColor);
				saturdayPanel.add(satButton);
				break;
			case "SUNDAY" :
				sundayTime.setText(workoutForRoutine.getTime());
				JButton sunButton = createWorkoutButton(workoutForRoutine.getWorkout(), 1);
				sunButton.setFont(new Font("Courier New", Font.PLAIN, 15));
				sunButton.setForeground(textColor);
				sundayPanel.add(sunButton);
				break;
			default :
				break;
			}

		}
	}

	/*
	 *
	 * creating UI for glossary workouts
	 *
	 */

	public void createTabWorkouts() {
		JTextArea workoutPanelExplaination = new JTextArea();
		workoutPanelExplaination.setBackground(backgroundColor);
		workoutPanelExplaination.setFont(new Font("Courier New", Font.PLAIN, 22));
		workoutPanelExplaination.setForeground(textColor);
		workoutPanelExplaination.setLineWrap(true);
		workoutPanelExplaination.setWrapStyleWord(true);
		workoutPanelExplaination.setEditable(false);
		workoutPanelExplaination.setText("This is a list of all your currently saved Workouts. Click on an Workout to view it's details.");
		workoutPanelExplaination.setBounds(10, 11, 869, 70);
		workoutsPanel.add(workoutPanelExplaination);

		JScrollPane workoutListPanelScroll = new JScrollPane();
		workoutListPanelScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		workoutListPanelScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		workoutListPanelScroll.setBounds(10, 150, 886, 550);
		workoutsPanel.add(workoutListPanelScroll);

		workoutListPanelScroll.setViewportView(workoutListPanel);

		JButton addNewWorkoutButton = new JButton("Add A New Workout");
		addNewWorkoutButton.setBackground(backgroundColor);
		addNewWorkoutButton.setFont(new Font("Courier New", Font.PLAIN, 22));
		addNewWorkoutButton.setForeground(textColor);
		addNewWorkoutButton.setFocusPainted(false);
		addNewWorkoutButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				addNewWorkout();
			}
		});
		addNewWorkoutButton.setBounds(10, 90, 440, 45);
		workoutsPanel.add(addNewWorkoutButton);
	}

	public JButton createWorkoutButton(Workout workout, int i) {
		JButton button = new JButton(workout.getName());
		button.setBackground(backgroundColor);
		button.setFont(normalFont);
		button.setFocusPainted(false);
		button.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				createWorkoutWindow(workout, i);
			}
		});
		workout.setButton(button);
		return button;
	}

	public JButton createWorkoutButtonAssisstant(Workout workout) {
		JButton button = new JButton(workout.getName());
		button.setBackground(backgroundColor);
		button.setFont(normalFont);
		button.setFocusPainted(false);
		button.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				assistantStartUp(workout);
			}
		});
		workout.setButtonInAssisstant(button);
		return button;
	}

	public void createWorkoutWindow(Workout workout, int flag) {
		JFrame window = new JFrame();
		window.setTitle(workout.getName());
		window.setResizable(false);
		window.setBounds(100, 100, 600, 649);

		window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		JPanel workoutDetails = new JPanel();
		workoutDetails.setBorder(new EmptyBorder(5, 5, 5, 5));

		window.setContentPane(workoutDetails);
		workoutDetails.setLayout(null);

		if (flag != 1) {
			JButton deleteWorkout = new JButton("Delete Workout?");
			deleteWorkout.setFont(new Font("Courier New", Font.PLAIN, 15));
			deleteWorkout.setForeground(textColor);
			deleteWorkout.setFocusPainted(false);
			deleteWorkout.setBackground(backgroundColor);
			deleteWorkout.setBounds(11, 576, 200, 23);
			deleteWorkout.addActionListener(new ActionListener() {
				@Override public void actionPerformed(ActionEvent e) {
					JFrame windowDelete = new JFrame();
					windowDelete.setResizable(false);
					windowDelete.setBounds(100, 100, 697, 232);

					windowDelete.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					JPanel deleteExerciseWarning = new JPanel();
					deleteExerciseWarning.setBorder(new EmptyBorder(5, 5, 5, 5));

					windowDelete.setContentPane(deleteExerciseWarning);
					deleteExerciseWarning.setLayout(null);

					JLabel lblNewLabel = new JLabel("Are you sure you would like to delete this workout:");
					lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 20));
					lblNewLabel.setForeground(textColor);
					lblNewLabel.setBounds(10, 47, 661, 14);
					deleteExerciseWarning.add(lblNewLabel);

					JButton yesButton = new JButton("YES");
					yesButton.setFont(new Font("Courier New", Font.PLAIN, 15));
					yesButton.setForeground(textColor);
					yesButton.setBounds(167, 141, 89, 23);
					yesButton.setBackground(backgroundColor);
					yesButton.setFocusPainted(false);
					yesButton.addActionListener(new ActionListener() {
						@Override public void actionPerformed(ActionEvent e) {
							Glossary glossary = new Glossary();
							removeWorkout(glossary, workout);
							glossaryPanel.repaint();
							repaint();
							windowDelete.dispose();
							window.dispose();
						}
					});
					deleteExerciseWarning.add(yesButton);

					JButton noButton = new JButton("NO");
					noButton.setFont(new Font("Courier New", Font.PLAIN, 15));
					noButton.setForeground(textColor);
					noButton.setBounds(423, 141, 89, 23);
					noButton.setBackground(backgroundColor);
					noButton.setFocusPainted(false);
					noButton.addActionListener(new ActionListener() {
						@Override public void actionPerformed(ActionEvent e) {
							windowDelete.dispose();
						}
					});
					deleteExerciseWarning.add(noButton);

					JLabel lblNewLabel_1 = new JLabel(workout.getName());
					lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
					lblNewLabel_1.setFont(new Font("Courier New", Font.PLAIN, 20));
					lblNewLabel_1.setForeground(textColor);
					lblNewLabel_1.setBounds(10, 92, 661, 14);
					deleteExerciseWarning.add(lblNewLabel_1);

					windowDelete.setVisible(true);
				}
			});
			workoutDetails.add(deleteWorkout);
		}

		JLabel workoutTitleLabel = new JLabel(workout.getName());
		workoutTitleLabel.setBounds(11, 0, 559, 65);
		workoutDetails.add(workoutTitleLabel);
		workoutTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		workoutTitleLabel.setFont(new Font("Courier New", Font.PLAIN, 40));
		workoutTitleLabel.setForeground(textColor);

		JScrollPane workoutDetailsScrollPane = new JScrollPane();
		workoutDetailsScrollPane.setBounds(12, 65, 559, 500);
		workoutDetails.add(workoutDetailsScrollPane);

		workoutDetailsListPanel = new JPanel();
		workoutDetailsScrollPane.setViewportView(workoutDetailsListPanel);
		workoutDetailsListPanel.setLayout(new GridLayout(0, 1, 0, 0));

		for (int j = 0; j < workout.getRounds(); j++) {
			for (int i = 0; i < workout.getExerciseAmount(); i++) {
				JPanel specificWorkoutPanel = new JPanel();
				workoutDetailsListPanel.add(specificWorkoutPanel);
				specificWorkoutPanel.setLayout(new GridLayout(0, 1, 0, 0));
	
				JPanel nameAndSecondsReps = new JPanel();
				specificWorkoutPanel.add(nameAndSecondsReps);
				nameAndSecondsReps.setLayout(new GridLayout(1, 0, 0, 0));
	
				JPanel namePanel = new JPanel();
				nameAndSecondsReps.add(namePanel);
				namePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
				namePanel.add(createButton(workout.getExerciseName(workout, i), 1));
	
				JPanel secondsOrReps = new JPanel();
				nameAndSecondsReps.add(secondsOrReps);
				secondsOrReps.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
				String secondOrRep = "";
	
				if (workout.getExerciseDetailsReps(workout, i) == 0) {
					secondOrRep = "Seconds: " + workout.getExerciseDetailsTime(workout, i);
				} else {
					secondOrRep = "Reps: " + workout.getExerciseDetailsReps(workout, i);
				}
	
				JLabel secondsOrRepsLabel = new JLabel(secondOrRep);
				secondsOrRepsLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
				secondsOrRepsLabel.setForeground(textColor);
				secondsOrReps.add(secondsOrRepsLabel);
	
				JPanel breakAndSeperator = new JPanel();
				specificWorkoutPanel.add(breakAndSeperator);
				breakAndSeperator.setLayout(new GridLayout(0, 1, 0, 0));
	
				JPanel breakTime = new JPanel();
				breakAndSeperator.add(breakTime);
	
				JLabel seperatorLabel = new JLabel("───────────────────────────────────────────────────────────");
				breakTime.add(seperatorLabel);
				seperatorLabel.setForeground(textColor);
				seperatorLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
	
				JPanel seperatorPanel = new JPanel();
				breakAndSeperator.add(seperatorPanel);
	
				JLabel breakLabel = new JLabel("Break " + workout.getExerciseBreakTime(workout, i) + " Seconds");
				seperatorPanel.add(breakLabel);
				breakLabel.setForeground(textColor);
				breakLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
	
				JPanel seperatorPanel_1 = new JPanel();
				breakAndSeperator.add(seperatorPanel_1);
	
				JLabel seperatorLabel_1 = new JLabel("───────────────────────────────────────────────────────────");
				seperatorLabel_1.setFont(new Font("Courier New", Font.PLAIN, 15));
				seperatorLabel_1.setForeground(textColor);
				seperatorPanel_1.add(seperatorLabel_1);
			}
		}

		window.setVisible(true);
	}

	public void removeWorkout(Glossary glossary, Workout workout) {
		//done in an excessive manner to ensure safe removal
		for( int i = 0; i < workoutListPanel.getComponentCount(); i++ ) {
			if(workoutListPanel.getComponent(i) instanceof JButton) {
				JButton workoutFromAssistantPanel = (JButton) workoutListPanel.getComponent(i);
				if (workoutFromAssistantPanel.getText().equals(workout.getName())) {
					workoutListPanel.remove(workoutFromAssistantPanel);
				}
			}
		}

		for( int i = 0; i < allWorkoutListPanel.getComponentCount(); i++ ) {
			if(allWorkoutListPanel.getComponent(i) instanceof JButton) {
				JButton workoutFromAssistantPanel = (JButton) allWorkoutListPanel.getComponent(i);
				if (workoutFromAssistantPanel.getText().equals(workout.getName())) {
					allWorkoutListPanel.remove(workoutFromAssistantPanel);
				}
			}
		}

		glossary.removeWorkout(workout);
	}

	public void addNewWorkout() {
		JFrame window = new JFrame();
		window.setTitle("Workout Creator");
		window.setResizable(false);
		window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		window.setBounds(100, 100, 463, 681);
		JPanel addingWorkout = new JPanel();
		addingWorkout.setBorder(new EmptyBorder(5, 5, 5, 5));

		window.setContentPane(addingWorkout);
		addingWorkout.setLayout(null);

		JTextArea nameQuestion = new JTextArea();
		nameQuestion.setBackground(backgroundColor);
		nameQuestion.setFont(new Font("Courier New", Font.PLAIN, 18));
		nameQuestion.setForeground(textColor);
		nameQuestion.setText("What is the name of the workout?");
		nameQuestion.setBounds(10, 27, 408, 23);
		nameQuestion.setEditable(false);
		addingWorkout.add(nameQuestion);

		JTextField nameResponse = new JTextField();
		nameResponse.setFont(new Font("Courier New", Font.PLAIN, 11));
		nameResponse.setForeground(textColor);
		nameResponse.setBounds(10, 77, 408, 33);
		addingWorkout.add(nameResponse);
		nameResponse.setColumns(10);

		JTextArea roundsQuestion = new JTextArea();
		roundsQuestion.setWrapStyleWord(true);
		roundsQuestion.setLineWrap(true);
		roundsQuestion.setText("How many rounds does this workout have?");
		roundsQuestion.setFont(new Font("Courier New", Font.PLAIN, 18));
		roundsQuestion.setForeground(textColor);
		roundsQuestion.setBackground(backgroundColor);
		roundsQuestion.setBounds(10, 137, 408, 46);
		roundsQuestion.setEditable(false);
		addingWorkout.add(roundsQuestion);
		window.setVisible(true);

		JTextArea howManyExercisesExplanation = new JTextArea();
		howManyExercisesExplanation.setWrapStyleWord(true);
		howManyExercisesExplanation.setText("How many exercises are included in this workout. Ignore the round count.\r\n\r\nA workout that is push ups and then set ups for three rounds has two exercises not six.\r\n\r\nIf the workout was push ups, sit ups, and then push ups again, that would be three exercises, even though two are the same.");
		howManyExercisesExplanation.setLineWrap(true);
		howManyExercisesExplanation.setFont(new Font("Courier New", Font.PLAIN, 18));
		howManyExercisesExplanation.setForeground(textColor);
		howManyExercisesExplanation.setEditable(false);
		howManyExercisesExplanation.setBackground(backgroundColor);
		howManyExercisesExplanation.setBounds(10, 270, 408, 235);
		addingWorkout.add(howManyExercisesExplanation);

		JSpinner roundsResponse = new JSpinner();
		roundsResponse.setModel(new SpinnerNumberModel(1, 1, 3599, 1));
		roundsResponse.setFont(new Font("Courier New", Font.PLAIN, 15));
		howManyExercisesExplanation.setForeground(textColor);
		roundsResponse.setBounds(10, 213, 41, 33);
		addingWorkout.add(roundsResponse);

		JSpinner exerciseAmountResponse = new JSpinner();
		exerciseAmountResponse.setModel(new SpinnerNumberModel(1, 1, 3599, 1));
		exerciseAmountResponse.setFont(new Font("Courier New", Font.PLAIN, 15));
		exerciseAmountResponse.setBounds(10, 516, 41, 33);
		addingWorkout.add(exerciseAmountResponse);

		JButton nextButton = new JButton("Next");
		nextButton.setBackground(backgroundColor);
		nextButton.setFocusPainted(false);
		nextButton.setFont(new Font("Courier New", Font.PLAIN, 15));
		nextButton.setForeground(textColor);
		nextButton.setBounds(289, 608, 148, 23);
		nextButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				if (nameResponse.getText().length() != 0) {

					for (int i = 0; i < (int)exerciseAmountResponse.getValue(); i++) {
						ExerciseForWorkout userExercise = null;
						//addNewWorkoutSecondWindow(nameResponse.getText(), (int)roundsResponse.getValue(), (int)exerciseAmountResponse.getValue(), userExercise);
					}

					window.dispose();
				}
			}
		});
		addingWorkout.add(nextButton);

		window.setVisible(true);
	}

	public ExerciseForWorkout addNewWorkoutSecondWindow(String name, int rounds, int amount, ExerciseForWorkout userExercise) {
		JFrame window = new JFrame();
		window.setTitle("Workout Creator");
		window.setResizable(false);
		window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		window.setBounds(100, 100, 463, 681);
		JPanel addingWorkout = new JPanel();
		addingWorkout.setBorder(new EmptyBorder(5, 5, 5, 5));

		window.setContentPane(addingWorkout);
		addingWorkout.setLayout(null);
		window.setVisible(true);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 427, 589);
		addingWorkout.add(scrollPane_1);

		JPanel workoutCreatorPanel = new JPanel();
		scrollPane_1.setViewportView(workoutCreatorPanel);
		workoutCreatorPanel.setLayout(null);

		JTextArea exerciseQuestion = new JTextArea();
		exerciseQuestion.setBounds(10, 25, 408, 23);
		workoutCreatorPanel.add(exerciseQuestion);
		exerciseQuestion.setBackground(backgroundColor);
		exerciseQuestion.setFont(new Font("Courier New", Font.PLAIN, 18));
		exerciseQuestion.setForeground(textColor);
		exerciseQuestion.setText("Select the first Exercise");
		exerciseQuestion.setEditable(false);

		JScrollPane listOfExercisesScrollPane = new JScrollPane();
		listOfExercisesScrollPane.setBounds(10, 73, 408, 115);
		workoutCreatorPanel.add(listOfExercisesScrollPane);
		listOfExercisesScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		listOfExercisesScrollPane.setViewportView(listOfExercisesForWorkout);

		JTextArea secondsOrRepsExplaination = new JTextArea();
		secondsOrRepsExplaination.setBounds(10, 323, 408, 46);
		workoutCreatorPanel.add(secondsOrRepsExplaination);
		secondsOrRepsExplaination.setWrapStyleWord(true);
		secondsOrRepsExplaination.setLineWrap(true);
		secondsOrRepsExplaination.setText("For how many reps or seconds is this Exercise done?");
		secondsOrRepsExplaination.setFont(new Font("Courier New", Font.PLAIN, 18));
		secondsOrRepsExplaination.setForeground(textColor);
		secondsOrRepsExplaination.setEditable(false);
		secondsOrRepsExplaination.setBackground(backgroundColor);

		JSpinner repOrSecondsResponse = new JSpinner();
		repOrSecondsResponse.setBounds(10, 394, 75, 33);
		workoutCreatorPanel.add(repOrSecondsResponse);
		repOrSecondsResponse.setModel(new SpinnerNumberModel(1, 1, 300, 1));
		repOrSecondsResponse.setFont(new Font("Courier New", Font.PLAIN, 15));
		repOrSecondsResponse.setForeground(textColor);

		JTextArea breakQuestionExplaination = new JTextArea();
		breakQuestionExplaination.setBounds(10, 452, 408, 46);
		workoutCreatorPanel.add(breakQuestionExplaination);
		breakQuestionExplaination.setWrapStyleWord(true);
		breakQuestionExplaination.setText("How long is the break after this Exercise?");
		breakQuestionExplaination.setLineWrap(true);
		breakQuestionExplaination.setFont(new Font("Courier New", Font.PLAIN, 18));
		breakQuestionExplaination.setForeground(textColor);
		breakQuestionExplaination.setEditable(false);
		breakQuestionExplaination.setBackground(backgroundColor);

		JSpinner breakTimeResponse = new JSpinner();
		breakTimeResponse.setBounds(10, 523, 75, 33);
		workoutCreatorPanel.add(breakTimeResponse);
		breakTimeResponse.setModel(new SpinnerNumberModel(1, 1, 300, 1));
		breakTimeResponse.setFont(new Font("Courier New", Font.PLAIN, 15));
		breakTimeResponse.setForeground(textColor);

		JTextArea repOrSecondsExplaination = new JTextArea();
		repOrSecondsExplaination.setWrapStyleWord(true);
		repOrSecondsExplaination.setText("Would you like to do this Exercise for a timed amount or a rep amount?\r\n");
		repOrSecondsExplaination.setLineWrap(true);
		repOrSecondsExplaination.setFont(new Font("Courier New", Font.PLAIN, 18));
		repOrSecondsExplaination.setForeground(textColor);
		repOrSecondsExplaination.setEditable(false);
		repOrSecondsExplaination.setBackground(backgroundColor);
		repOrSecondsExplaination.setBounds(10, 199, 408, 46);
		workoutCreatorPanel.add(repOrSecondsExplaination);

		JRadioButton repAmountRadioButton = new JRadioButton("Rep Amount");
		repAmountRadioButton.setSelected(true);
		repAmountRadioButton.setFont(new Font("Courier New", Font.PLAIN, 15));
		repAmountRadioButton.setForeground(textColor);
		repAmountRadioButton.setBounds(59, 269, 115, 23);
		repAmountRadioButton.setFocusable(false);
		workoutCreatorPanel.add(repAmountRadioButton);

		JRadioButton timerAmountRadioButton = new JRadioButton("Timer Amount");
		timerAmountRadioButton.setFont(new Font("Courier New", Font.PLAIN, 15));
		timerAmountRadioButton.setForeground(textColor);
		timerAmountRadioButton.setFocusable(false);
		timerAmountRadioButton.setBounds(233, 269, 133, 23);
		workoutCreatorPanel.add(timerAmountRadioButton);

		ButtonGroup group = new ButtonGroup();
		Glossary glossary = new Glossary();

		group.add(repAmountRadioButton);
		group.add(timerAmountRadioButton);

		JButton nextButton = new JButton("Next");
		nextButton.setBackground(backgroundColor);
		nextButton.setFocusPainted(false);
		nextButton.setFont(new Font("Courier New", Font.PLAIN, 15));
		nextButton.setForeground(textColor);
		nextButton.setBounds(289, 608, 148, 23);

		boolean check = false;

		nextButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				if (groupList.getSelection() != null) {
					//check = true;
					/*
					if (repAmountRadioButton.isSelected()) {
						userExercise = new ExerciseForWorkout(glossary.getExercise(groupList.getSelection().getActionCommand()), (Integer) repOrSecondsResponse.getValue(), (Integer) breakTimeResponse.getValue(), "R");
					}

					if (timerAmountRadioButton.isSelected()) {
						userExercise = new ExerciseForWorkout(glossary.getExercise(groupList.getSelection().getActionCommand()), (Integer) repOrSecondsResponse.getValue(), (Integer) breakTimeResponse.getValue(), "S");
					}
					 */
				}
			}
		});

		addingWorkout.add(nextButton);

		window.setVisible(true);
		return userExercise;
	}

	/*
	 *
	 * creating UI for glossary exercises
	 *
	 */

	public void createTabExercises() {
		JTextArea panelExplaination = new JTextArea();
		panelExplaination.setBackground(backgroundColor);
		panelExplaination.setFont(new Font("Courier New", Font.PLAIN, 22));
		panelExplaination.setForeground(textColor);
		panelExplaination.setLineWrap(true);
		panelExplaination.setWrapStyleWord(true);
		panelExplaination.setEditable(false);
		panelExplaination.setText("This is a list of all your currently saved Exercises. Click on an Exercise to view it's details.");
		panelExplaination.setBounds(10, 11, 869, 70);
		exercisesPanel.add(panelExplaination);

		JScrollPane exerciseListPanelScroll = new JScrollPane();
		exerciseListPanelScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		exerciseListPanelScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		exerciseListPanelScroll.setBounds(10, 150, 886, 550);
		exercisesPanel.add(exerciseListPanelScroll);

		exerciseListPanelScroll.setViewportView(exerciseListPanel);

		JButton addNewExercise = new JButton("Add A New Exercise");
		addNewExercise.setBackground(backgroundColor);
		addNewExercise.setFont(new Font("Courier New", Font.PLAIN, 22));
		addNewExercise.setForeground(textColor);
		addNewExercise.setFocusPainted(false);
		addNewExercise.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				addNewExercise();
			}
		});
		addNewExercise.setBounds(10, 90, 440, 45);
		exercisesPanel.add(addNewExercise);
	}

	public JCheckBox createCheckButton(Exercise exercise) {
		JCheckBox button = new JCheckBox(exercise.getName());
		button.setFont(new Font("Courier New", Font.PLAIN, 15));
		button.setForeground(textColor);
		button.setFocusable(false);
		button.setActionCommand(exercise.getName());
		return button;
	}

	public JButton createButton(Exercise exercise, int i) {
		JButton button = new JButton(exercise.getName());
		button.setBackground(backgroundColor);
		button.setFocusPainted(false);
		if (i == 1) {
			button.setFont(new Font("Courier New", Font.PLAIN, 15));
		} else {
			button.setFont(normalFont);
		}
		button.setForeground(textColor);
		button.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				createExerciseWindow(exercise, i);
			}
		});
		exercise.setButton(button);
		return button;
	}

	public void addNewExercise() {
		JFrame window = new JFrame();
		window.setTitle("Exercise Creator");
		window.setResizable(false);
		window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		window.setBounds(100, 100, 448, 681);
		JPanel addingExercise = new JPanel();
		addingExercise.setBorder(new EmptyBorder(5, 5, 5, 5));

		window.setContentPane(addingExercise);
		addingExercise.setLayout(null);

		JTextArea nameQuestion = new JTextArea();
		nameQuestion.setBackground(backgroundColor);
		nameQuestion.setFont(new Font("Courier New", Font.PLAIN, 18));
		nameQuestion.setForeground(textColor);
		nameQuestion.setText("What is the name of the exercise?");
		nameQuestion.setBounds(10, 11, 408, 23);
		nameQuestion.setEditable(false);
		addingExercise.add(nameQuestion);

		JTextField nameResponse = new JTextField();
		nameResponse.setFont(new Font("Courier New", Font.PLAIN, 11));
		nameResponse.setForeground(textColor);
		nameResponse.setBounds(10, 39, 408, 33);
		addingExercise.add(nameResponse);
		nameResponse.setColumns(10);

		JCheckBox backResponse = new JCheckBox("Back");
		backResponse.setFont(new Font("Courier New", Font.PLAIN, 15));
		backResponse.setForeground(textColor);
		backResponse.setBounds(10, 136, 125, 23);
		addingExercise.add(backResponse);

		JTextArea typeQuestion = new JTextArea();
		typeQuestion.setText("What muscle(s) are being worked out?");
		typeQuestion.setFont(new Font("Courier New", Font.PLAIN, 18));
		typeQuestion.setForeground(textColor);
		typeQuestion.setBackground(backgroundColor);
		typeQuestion.setBounds(10, 102, 408, 33);
		typeQuestion.setEditable(false);
		addingExercise.add(typeQuestion);

		JCheckBox armsResponse = new JCheckBox("Arms");
		armsResponse.setFont(new Font("Courier New", Font.PLAIN, 15));
		armsResponse.setForeground(textColor);
		armsResponse.setBounds(10, 170, 125, 23);
		addingExercise.add(armsResponse);

		JCheckBox shouldersResponse = new JCheckBox("Shoulders");
		shouldersResponse.setFont(new Font("Courier New", Font.PLAIN, 15));
		shouldersResponse.setForeground(textColor);
		shouldersResponse.setBounds(10, 208, 148, 23);
		addingExercise.add(shouldersResponse);

		JTextArea stepsQuestion = new JTextArea();
		stepsQuestion.setText("What are the steps?");
		stepsQuestion.setFont(new Font("Courier New", Font.PLAIN, 18));
		stepsQuestion.setBackground(backgroundColor);
		stepsQuestion.setForeground(textColor);
		stepsQuestion.setBounds(10, 262, 408, 23);
		stepsQuestion.setEditable(false);
		addingExercise.add(stepsQuestion);

		JTextArea stepsResponse = new JTextArea();
		stepsResponse.setWrapStyleWord(true);
		stepsResponse.setFont(new Font("Courier New", Font.PLAIN, 11));
		stepsResponse.setForeground(textColor);
		stepsResponse.setLineWrap(true);
		stepsResponse.setBounds(10, 291, 408, 306);
		addingExercise.add(stepsResponse);

		JCheckBox legsResponse = new JCheckBox("Legs");
		legsResponse.setFont(new Font("Courier New", Font.PLAIN, 15));
		legsResponse.setForeground(textColor);
		legsResponse.setBounds(171, 170, 125, 23);
		addingExercise.add(legsResponse);

		JCheckBox chestResponse = new JCheckBox("Chest");
		chestResponse.setFont(new Font("Courier New", Font.PLAIN, 15));
		chestResponse.setForeground(textColor);
		chestResponse.setBounds(171, 136, 125, 23);
		addingExercise.add(chestResponse);
		window.setVisible(true);

		JButton finishButton = new JButton("Finished");
		finishButton.setBackground(backgroundColor);
		finishButton.setFocusPainted(false);
		finishButton.setFont(new Font("Courier New", Font.PLAIN, 15));
		finishButton.setForeground(textColor);
		finishButton.setBounds(270, 608, 148, 23);
		finishButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				if (nameResponse.getText().length() != 0 && stepsResponse.getText().length() != 0) {
					Exercise userExercise = new Exercise("", "", false, false, false, false, false);
					userExercise.setName(nameResponse.getText());
					userExercise.setSteps(stepsResponse.getText());

					if (backResponse.isSelected()) {
						userExercise.setBack(true);
					}

					if (armsResponse.isSelected()) {
						userExercise.setArms(true);
					}

					if (shouldersResponse.isSelected()) {
						userExercise.setShoulders(true);
					}

					if (chestResponse.isSelected()) {
						userExercise.setChest(true);
					}

					if (legsResponse.isSelected()) {
						userExercise.setLegs(true);
					}

					Glossary gloss = new Glossary();
					JButton button = createButton(userExercise, 0);

					userExercise.setButton(button);
					gloss.listOfExercises.add(userExercise);
					listOfExercisesForWorkout.add(createCheckButton(userExercise));
					groupList.remove(userExercise.getCheckButton());
					exerciseListPanel.add(button);
					repaint();

					window.dispose();
				}
			}
		});
		addingExercise.add(finishButton);
	}

	public void createExerciseWindow(Exercise exercise, int i) {
		JFrame window = new JFrame();
		window.setTitle(exercise.getName());
		window.setResizable(false);
		window.setBounds(100, 100, 1152, 671);

		window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		JPanel exerciseDetails = new JPanel();
		exerciseDetails.setBorder(new EmptyBorder(5, 5, 5, 5));

		window.setContentPane(exerciseDetails);
		exerciseDetails.setLayout(null);

		JScrollPane exerciseDetailsScrollPane = new JScrollPane();
		exerciseDetailsScrollPane.setBounds(0, 0, 1136, 632);
		exerciseDetails.add(exerciseDetailsScrollPane);

		JPanel exerciseDetailsPanel = new JPanel();
		exerciseDetailsScrollPane.setViewportView(exerciseDetailsPanel);
		exerciseDetailsPanel.setLayout(null);

		JScrollPane exerciseDetailsStepsScrollPane = new JScrollPane();
		exerciseDetailsStepsScrollPane.setBounds(10, 150, 564, 436);
		exerciseDetailsPanel.add(exerciseDetailsStepsScrollPane);

		JPanel exerciseDetailsStepsPanel = new JPanel();
		exerciseDetailsStepsScrollPane.setViewportView(exerciseDetailsStepsPanel);
		exerciseDetailsStepsPanel.setLayout(null);

		JTextPane exerciseDetailsTextPane = new JTextPane();
		exerciseDetailsTextPane.setText(exercise.getSteps());
		exerciseDetailsTextPane.setFont(new Font("Courier New", Font.PLAIN, 20));
		exerciseDetailsTextPane.setForeground(textColor);
		exerciseDetailsTextPane.setEditable(false);
		exerciseDetailsTextPane.setBackground(backgroundColor);
		exerciseDetailsTextPane.setBounds(0, 0, 562, 434);
		exerciseDetailsStepsPanel.add(exerciseDetailsTextPane);

		JLabel lblNewLabel = new JLabel(exercise.getName());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 60));
		lblNewLabel.setForeground(textColor);
		lblNewLabel.setBounds(10, 11, 1114, 65);
		exerciseDetailsPanel.add(lblNewLabel);

		JCheckBox Back = new JCheckBox("Back");
		Back.setFont(new Font("Courier New", Font.PLAIN, 15));
		Back.setForeground(textColor);
		Back.setSelected(exercise.getBack());
		Back.setEnabled(false);
		Back.setBounds(88, 100, 97, 23);
		exerciseDetailsPanel.add(Back);

		JCheckBox Arms = new JCheckBox("Arms");
		Arms.setFont(new Font("Courier New", Font.PLAIN, 15));
		Arms.setForeground(textColor);
		Arms.setSelected(exercise.getArms());
		Arms.setEnabled(false);
		Arms.setBounds(273, 100, 97, 23);
		exerciseDetailsPanel.add(Arms);

		JCheckBox Shoulders = new JCheckBox("Shoulders");
		Shoulders.setFont(new Font("Courier New", Font.PLAIN, 15));
		Shoulders.setForeground(textColor);
		Shoulders.setSelected(exercise.getShoulders());
		Shoulders.setEnabled(false);
		Shoulders.setBounds(458, 100, 137, 23);
		exerciseDetailsPanel.add(Shoulders);

		JCheckBox Chest = new JCheckBox("Chest");
		Chest.setSelected(exercise.getChest());
		Chest.setForeground(textColor);
		Chest.setFont(new Font("Courier New", Font.PLAIN, 15));
		Chest.setEnabled(false);
		Chest.setBounds(683, 100, 137, 23);
		exerciseDetailsPanel.add(Chest);

		JCheckBox Legs = new JCheckBox("Legs");
		Legs.setSelected(exercise.getLegs());
		Legs.setFont(new Font("Courier New", Font.PLAIN, 15));
		Legs.setForeground(textColor);
		Legs.setEnabled(false);
		Legs.setBounds(908, 100, 137, 23);
		exerciseDetailsPanel.add(Legs);

		JPanel imagePanel = new JPanel();
		imagePanel.setBounds(584, 150, 540, 469);
		exerciseDetailsPanel.add(imagePanel);

		if (i != 1) {
			JButton deleteExercise = new JButton("Delete Exercise?");
			deleteExercise.setFont(new Font("Courier New", Font.PLAIN, 15));
			deleteExercise.setForeground(textColor);
			deleteExercise.setBounds(10, 597, 200, 23);
			deleteExercise.setBackground(backgroundColor);
			deleteExercise.setFocusPainted(false);
			deleteExercise.addActionListener(new ActionListener() {
				@Override public void actionPerformed(ActionEvent e) {
					JFrame windowDelete = new JFrame();
					windowDelete.setType(Type.POPUP);
					windowDelete.setFont(new Font("Courier New", Font.BOLD, 12));
					windowDelete.setForeground(textColor);
					windowDelete.setTitle("Delete Exercise Warning");
					windowDelete.setResizable(false);
					windowDelete.setAlwaysOnTop(true);
					windowDelete.setBounds(100, 100, 697, 555);

					windowDelete.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					JPanel deleteExerciseWarning = new JPanel();
					deleteExerciseWarning.setBorder(new EmptyBorder(5, 5, 5, 5));

					windowDelete.setContentPane(deleteExerciseWarning);
					deleteExerciseWarning.setLayout(null);

					JLabel warningLabelExercise = new JLabel("Are you sure you would like to delete this Exercise:");
					warningLabelExercise.setFont(new Font("Courier New", Font.PLAIN, 20));
					warningLabelExercise.setForeground(textColor);
					warningLabelExercise.setBounds(10, 38, 661, 23);
					deleteExerciseWarning.add(warningLabelExercise);

					JLabel exerciseNameLabel = new JLabel(exercise.getName());
					exerciseNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
					exerciseNameLabel.setFont(new Font("Courier New", Font.PLAIN, 20));
					exerciseNameLabel.setForeground(textColor);
					exerciseNameLabel.setBounds(10, 83, 661, 23);
					deleteExerciseWarning.add(exerciseNameLabel);

					JTextArea warningLabelWorkouts = new JTextArea();
					warningLabelWorkouts.setBackground(backgroundColor);
					warningLabelWorkouts.setFont(new Font("Courier New", Font.PLAIN, 15));
					warningLabelWorkouts.setForeground(textColor);
					warningLabelWorkouts.setWrapStyleWord(true);
					warningLabelWorkouts.setLineWrap(true);
					warningLabelWorkouts.setEditable(false);
					warningLabelWorkouts.setText("Deleting this Exercise will also delete the Workouts that include this Exercise. The following Workouts will be removed:");
					warningLabelWorkouts.setBounds(10, 134, 661, 40);
					deleteExerciseWarning.add(warningLabelWorkouts);

					JScrollPane listOfWorkouts = new JScrollPane();
					listOfWorkouts.setBounds(10, 185, 661, 98);
					deleteExerciseWarning.add(listOfWorkouts);

					Glossary glossary = new Glossary();

					List<Workout> workoutsList = new ArrayList<>();

					for( int i = 0; i < workoutListPanel.getComponentCount(); i++ ) {
						if(workoutListPanel.getComponent(i) instanceof JButton) {
							JButton workoutFromPanel = (JButton) workoutListPanel.getComponent(i);
							if (glossary.workoutsContaining(glossary.getWorkout(workoutFromPanel.getText()), exercise)) {
								workoutsList.add(glossary.getWorkout(workoutFromPanel.getText()));
								//System.out.println(glossary.getWorkout(workoutFromPanel.getText()).getName());
							}
						}
					}

					JTextArea listOfWorkoutsTextArea = new JTextArea();
					listOfWorkoutsTextArea.setEditable(false);
					listOfWorkoutsTextArea.setWrapStyleWord(true);
					listOfWorkoutsTextArea.setLineWrap(true);
					listOfWorkoutsTextArea.setFont(new Font("Courier New", Font.PLAIN, 15));
					listOfWorkoutsTextArea.setForeground(textColor);
					listOfWorkoutsTextArea.setBackground(backgroundColor);
					listOfWorkouts.setViewportView(listOfWorkoutsTextArea);

					String textAreaText = "";

					for (int i = 0; i < workoutsList.size(); i++) {
						textAreaText += workoutsList.get(i).getName();
						if (i < (workoutsList.size() - 1)) {
							textAreaText += ", ";
						}
						if (i == (workoutsList.size() - 2)) {
							textAreaText += "and ";
						}
					}

					listOfWorkoutsTextArea.setText(textAreaText);

					if (textAreaText.length() < 1) {
						listOfWorkoutsTextArea.setText("No Workouts include this Exercise.");
					}

					JButton yesButton = new JButton("YES");
					yesButton.setFont(new Font("Courier New", Font.PLAIN, 15));
					yesButton.setForeground(textColor);
					yesButton.setBounds(167, 470, 89, 23);
					yesButton.setBackground(backgroundColor);
					yesButton.setFocusPainted(false);
					yesButton.addActionListener(new ActionListener() {
						@Override public void actionPerformed(ActionEvent e) {

							for (Workout element : workoutsList) {
								removeWorkout(glossary, element);
							}

							/*
							for (int i = 0; i < routinesList.size(); i++) {
								removeRoutine(glossary, routinesList.get(i));
							}
							 */

							removeExercise(glossary, exercise);
							repaint();
							windowDelete.dispose();
							window.dispose();
						}
					});
					deleteExerciseWarning.add(yesButton);

					JButton noButton = new JButton("NO");
					noButton.setFont(new Font("Courier New", Font.PLAIN, 15));
					noButton.setForeground(textColor);
					noButton.setBounds(423, 470, 89, 23);
					noButton.setBackground(backgroundColor);
					noButton.setFocusPainted(false);
					noButton.addActionListener(new ActionListener() {
						@Override public void actionPerformed(ActionEvent e) {
							windowDelete.dispose();
						}
					});
					deleteExerciseWarning.add(noButton);

					windowDelete.setVisible(true);
				}
			});
			exerciseDetailsPanel.add(deleteExercise);
		}

		window.setVisible(true);
	}

	public void removeExercise(Glossary glossary, Exercise exercise) {
		groupList.remove(exercise.getCheckButton());

		//done in an excessive manner to ensure safe removal
		for( int i = 0; i < exerciseListPanel.getComponentCount(); i++ ) {
			if(exerciseListPanel.getComponent(i) instanceof JButton) {
				JButton exerciseButton = (JButton) exerciseListPanel.getComponent(i);
				if (exerciseButton.getText().equals(exercise.getName())) {
					exerciseListPanel.remove(exerciseButton);
				}
			}
		}

		for( int i = 0; i < listOfExercisesForWorkout.getComponentCount(); i++ ) {
			if(listOfExercisesForWorkout.getComponent(i) instanceof JButton) {
				JButton exerciseButton = (JButton) listOfExercisesForWorkout.getComponent(i);
				if (exerciseButton.getText().equals(exercise.getName())) {
					listOfExercisesForWorkout.remove(exerciseButton);
				}
			}
		}

		glossary.removeExercise(exercise);
	}

	/*
	 *
	 * creating UI for calendar
	 *
	 */

	public void showCalendarPanel() {
		location = "CALENDAR";
		calendarPanel = new JPanel();
		calendarPanel.setBounds(363, 11, 911, 671);
		calendarPanel.setBackground(SystemColor.activeCaption);
		menuPanel.add(calendarPanel);
		calendarPanel.setLayout(null);
	}

	/*
	 *
	 * creating UI for settings
	 *
	 */

	public void showSettingsPanel() {
		location = "SETTINGS";
		settingsPanel = new JPanel();
		settingsPanel.setBounds(363, 11, 911, 739);
		settingsPanel.setBackground(backgroundColor);
		menuPanel.add(settingsPanel);
		settingsPanel.setLayout(null);
		
		JLabel pageTitleLabel = new JLabel("SETTINGS / HELP");
		pageTitleLabel.setFont(new Font("Courier New", Font.PLAIN, 40));
		pageTitleLabel.setForeground(textColor);
		pageTitleLabel.setBounds(10, 11, 891, 34);
		settingsPanel.add(pageTitleLabel);
		
		JTextArea autoAdvanceExplaination = new JTextArea();
		autoAdvanceExplaination.setBackground(backgroundColor);
		autoAdvanceExplaination.setWrapStyleWord(true);
		autoAdvanceExplaination.setEditable(false);
		autoAdvanceExplaination.setLineWrap(true);
		autoAdvanceExplaination.setText("While using the Workout Assistant, would you like to Automatically Advance to the next break / exercise rather than have to press the \"NEXT\" button?");
		autoAdvanceExplaination.setFont(new Font("Courier New", Font.PLAIN, 20));
		autoAdvanceExplaination.setForeground(textColor);
		autoAdvanceExplaination.setBounds(10, 78, 891, 56);
		settingsPanel.add(autoAdvanceExplaination);
		
		JToggleButton autoAdvanceToggle = new JToggleButton("Auto Advance On");
		autoAdvanceToggle.setBackground(backgroundColor);
		autoAdvanceToggle.setFont(new Font("Courier New", Font.PLAIN, 20));
		autoAdvanceToggle.setForeground(textColor);
		autoAdvanceToggle.setFocusable(false);
		autoAdvanceToggle.setBounds(10, 144, 234, 34);
		autoAdvanceToggle.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				CountdownTimer timer = new CountdownTimer();
				if (autoAdvanceToggle.isSelected()) {
					timer.setAutoAdvance(true);
					autoAdvanceToggle.setText("Auto Advance Off");
				} else {
					timer.setAutoAdvance(false);
					autoAdvanceToggle.setText("Auto Advance On");
				}
			}
		});
		settingsPanel.add(autoAdvanceToggle);
	}

}