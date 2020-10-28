package presentation;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import logic.ControllerLogic;

public class Screen extends JFrame {

	private static ControllerLogic controller;
	private static boolean isUserLoggedIn = true;

	private JPanel contentPane;
	private JPanel master__panel;
	private CardLayout master__cardLayout;
	private CardLayout userType__cardLayout;
	private JTextField nameLogin__textField;
	private JTextField passwordLogin__textField;
	private JTextField ciCreateStudent__textField;
	private JTextField nameCreateStudent__textField;
	private JTextField lastNameCreateStudent__textField;
	private JTextField mailCreateStudent__textField;
	private JTextField passwordCreateStudent__textField;
	private JTextField dateCreateStudent__textField;
	private JTextField ciCreateTeacher__textField;
	private JTextField nameCreateTeacher__textField;
	private JTextField lastNameCreateTeacher__textField;
	private JTextField mailCreateTeacher__textField;
	private JTextField passwordCreateTeacher__textField;
	private JTextField dateCreateTeacher__textField;
	private JTextField ciCreateFunctioanry__textField;
	private JTextField nameCreateFunctionary__textField;
	private JTextField lastNameCreateFunctionary__textField;
	private JTextField mailCreateFunctioanry__textField;
	private JTextField passwordCreateFunctionary__textField;
	private JTextField dateCreateFunctionary__textField;
	private JComboBox generationCreateStudent__comboBox;
	private JComboBox orientationCreateStudent__comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					controller = new ControllerLogic();
					Screen frame = new Screen();
					frame.setVisible(true);
					frame.setTitle("Final Project Prog-DB");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Screen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 570);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		master__panel = new JPanel();
		master__panel.setBounds(50, 61, 486, 431);
		contentPane.add(master__panel);
		master__panel.setLayout(new CardLayout(0, 0));
		master__cardLayout = (CardLayout) master__panel.getLayout();

		JPanel login__panel = new JPanel();
		master__panel.add(login__panel, "LOGIN_PANEL");
		login__panel.setLayout(null);

		JLabel titleLogin__label = new JLabel("LOGIN");
		titleLogin__label.setBounds(247, 162, 61, 16);
		login__panel.add(titleLogin__label);

		JLabel nameLogin__label = new JLabel("Name:");
		nameLogin__label.setBounds(198, 210, 61, 16);
		login__panel.add(nameLogin__label);

		JLabel passwordLogin__label = new JLabel("Password:");
		passwordLogin__label.setBounds(198, 253, 69, 16);
		login__panel.add(passwordLogin__label);

		JButton submitLogin__button = new JButton("SUBMIT");
		submitLogin__button.setBounds(235, 301, 117, 29);
		login__panel.add(submitLogin__button);

		nameLogin__textField = new JTextField();
		nameLogin__textField.setBounds(294, 248, 130, 26);
		login__panel.add(nameLogin__textField);
		nameLogin__textField.setColumns(10);

		passwordLogin__textField = new JTextField();
		passwordLogin__textField.setColumns(10);
		passwordLogin__textField.setBounds(294, 205, 130, 26);
		login__panel.add(passwordLogin__textField);

		master__cardLayout.show(master__panel, "LOGIN_PANEL");

		JPanel welcome__panel = new JPanel();
		master__panel.add(welcome__panel, "WELCOME_PANEL");
		Menu wlecome__menu = new Menu(welcome__panel, master__panel, master__cardLayout);
		welcome__panel.setLayout(null);
		
		JLabel welcomeProject__Label = new JLabel("Welcome to the Project\n\n");
		welcomeProject__Label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		welcomeProject__Label.setForeground(new Color(0, 0, 0));
		welcomeProject__Label.setBounds(175, 90, 190, 47);
		welcome__panel.add(welcomeProject__Label);
		
		JLabel DescriptionWelcome__Label = new JLabel("Choose the optiones above to start\n");
		DescriptionWelcome__Label.setBounds(154, 181, 242, 16);
		welcome__panel.add(DescriptionWelcome__Label);

		JPanel C__panel = new JPanel();
		master__panel.add(C__panel, "CREATE_USER_PANEL");
		Menu createUser__menu = new Menu(C__panel, master__panel, master__cardLayout);
		C__panel.setLayout(null);
		
		
		JLabel titleCreateUser__label = new JLabel("Create a new User");
		titleCreateUser__label.setBounds(239, 33, 124, 16);
		C__panel.add(titleCreateUser__label);

		JRadioButton createStudent__radioButton = new JRadioButton("Student");
		createStudent__radioButton.setBounds(46, 78, 141, 23);
		createStudent__radioButton.setSelected(true);
		C__panel.add(createStudent__radioButton);

		JRadioButton createFunctioanry__radioButton = new JRadioButton("Functioanry");
		createFunctioanry__radioButton.setBounds(219, 78, 141, 23);
		C__panel.add(createFunctioanry__radioButton);

		JRadioButton createTeacher__radioButton = new JRadioButton("Teacher");
		createTeacher__radioButton.setBounds(397, 78, 141, 23);
		C__panel.add(createTeacher__radioButton);

		ButtonGroup userTypeCreateUser__buttonGroup = new ButtonGroup();
		userTypeCreateUser__buttonGroup.add(createStudent__radioButton);
		userTypeCreateUser__buttonGroup.add(createFunctioanry__radioButton);
		userTypeCreateUser__buttonGroup.add(createTeacher__radioButton);

		JLabel descriptionCreateUser__label = new JLabel("Select the type of user that you want to create.");
		descriptionCreateUser__label.setBounds(139, 55, 293, 16);
		C__panel.add(descriptionCreateUser__label);

		JPanel userType__panel = new JPanel();
		userType__panel.setBounds(46, 113, 462, 384);
		C__panel.add(userType__panel);
		userType__panel.setLayout(new CardLayout(0, 0));
		userType__cardLayout = (CardLayout) userType__panel.getLayout();

		JPanel createStudent__panel = new JPanel();
		createStudent__panel.setBounds(80, 120, 400, 380);
		userType__panel.add(createStudent__panel, "CREATE_STUDENT_PANEL");
		createStudent__panel.setLayout(null);

		userType__cardLayout.show(userType__panel, "CREATE_STUDENT_PANEL");

		JLabel nameCreateStudent__label = new JLabel("Name:");
		nameCreateStudent__label.setBounds(139, 54, 61, 16);
		createStudent__panel.add(nameCreateStudent__label);

		JLabel ciCreateStudent__label = new JLabel("CI:");
		ciCreateStudent__label.setBounds(139, 24, 61, 16);
		createStudent__panel.add(ciCreateStudent__label);

		JLabel passwordCreateStudent__label = new JLabel("Password:");
		passwordCreateStudent__label.setBounds(139, 154, 91, 16);
		createStudent__panel.add(passwordCreateStudent__label);

		JLabel lastNameCreateStudent__label = new JLabel("Last name:");
		lastNameCreateStudent__label.setBounds(138, 87, 108, 16);
		createStudent__panel.add(lastNameCreateStudent__label);

		JLabel dateCreateStudent__label = new JLabel("Birth date:");
		dateCreateStudent__label.setBounds(139, 218, 91, 16);
		createStudent__panel.add(dateCreateStudent__label);

		JLabel generationCreateStudent__label = new JLabel("Generation:");
		generationCreateStudent__label.setBounds(139, 186, 91, 16);
		createStudent__panel.add(generationCreateStudent__label);

		JLabel orientationCreateStudent__label = new JLabel("Orientation:");
		orientationCreateStudent__label.setBounds(139, 246, 91, 16);
		createStudent__panel.add(orientationCreateStudent__label);

		JLabel mailCreateStudent__label = new JLabel("Mail:");
		mailCreateStudent__label.setBounds(139, 120, 61, 16);
		createStudent__panel.add(mailCreateStudent__label);

		JButton submitCreateStudent__button = new JButton("SUBMIT");
		submitCreateStudent__button.setBounds(195, 276, 117, 29);
		createStudent__panel.add(submitCreateStudent__button);

		String generations[] = { "GEN18", "GEN19", "GEN20" };
		generationCreateStudent__comboBox = new JComboBox(generations);
		generationCreateStudent__comboBox.setBounds(218, 182, 130, 27);
		createStudent__panel.add(generationCreateStudent__comboBox);

		String orientations[] = { "ADM", "TIC" };
		orientationCreateStudent__comboBox = new JComboBox(orientations);
		orientationCreateStudent__comboBox.setBounds(218, 242, 142, 27);
		createStudent__panel.add(orientationCreateStudent__comboBox);

		ciCreateStudent__textField = new JTextField();
		ciCreateStudent__textField.setBounds(195, 19, 130, 26);
		createStudent__panel.add(ciCreateStudent__textField);
		ciCreateStudent__textField.setColumns(10);

		nameCreateStudent__textField = new JTextField();
		nameCreateStudent__textField.setBounds(195, 49, 130, 26);
		createStudent__panel.add(nameCreateStudent__textField);
		nameCreateStudent__textField.setColumns(10);

		lastNameCreateStudent__textField = new JTextField();
		lastNameCreateStudent__textField.setBounds(218, 82, 130, 26);
		createStudent__panel.add(lastNameCreateStudent__textField);
		lastNameCreateStudent__textField.setColumns(10);

		mailCreateStudent__textField = new JTextField();
		mailCreateStudent__textField.setBounds(176, 115, 184, 26);
		createStudent__panel.add(mailCreateStudent__textField);
		mailCreateStudent__textField.setColumns(10);

		passwordCreateStudent__textField = new JTextField();
		passwordCreateStudent__textField.setBounds(208, 149, 130, 26);
		createStudent__panel.add(passwordCreateStudent__textField);
		passwordCreateStudent__textField.setColumns(10);

		dateCreateStudent__textField = new JTextField();
		dateCreateStudent__textField.setBounds(208, 213, 130, 26);
		createStudent__panel.add(dateCreateStudent__textField);
		dateCreateStudent__textField.setColumns(10);

		submitCreateStudent__button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ciStudent = ciCreateStudent__textField.getText();
				String nameStudent = nameCreateStudent__textField.getText();
				String lastNameStudent = lastNameCreateStudent__textField.getText();
				String mailCreateStudent = mailCreateStudent__textField.getText();
				String passwordStudent = passwordCreateStudent__textField.getText();
				String generationStudent = orientationCreateStudent__comboBox.getSelectedItem().toString();
				String orientationStudnet = generationCreateStudent__comboBox.getSelectedItem().toString();
			}
		});

		JPanel createFunctionary__panel = new JPanel();
		userType__panel.add(createFunctionary__panel, "CREATE_FUNCTIONARY_PANEL");
		createFunctionary__panel.setLayout(null);

		JLabel nameCreateFunctionary__label = new JLabel("Name:");
		nameCreateFunctionary__label.setBounds(139, 61, 61, 16);
		createFunctionary__panel.add(nameCreateFunctionary__label);

		JLabel ciCreateFunctioanry__label = new JLabel("CI:");
		ciCreateFunctioanry__label.setBounds(139, 28, 61, 16);
		createFunctionary__panel.add(ciCreateFunctioanry__label);

		JLabel passwordCreateFunctioanry__label = new JLabel("Password:");
		passwordCreateFunctioanry__label.setBounds(139, 156, 91, 16);
		createFunctionary__panel.add(passwordCreateFunctioanry__label);

		JLabel lastNameCreateFunctionary__label = new JLabel("Last name:");
		lastNameCreateFunctionary__label.setBounds(139, 94, 108, 16);
		createFunctionary__panel.add(lastNameCreateFunctionary__label);

		JLabel dateCreateFunctionary__label = new JLabel("Birth date:");
		dateCreateFunctionary__label.setBounds(139, 194, 91, 16);
		createFunctionary__panel.add(dateCreateFunctionary__label);

		JLabel mailCreateFunctionary__label = new JLabel("Mail:");
		mailCreateFunctionary__label.setBounds(139, 122, 117, 29);
		createFunctionary__panel.add(mailCreateFunctionary__label);

		ciCreateFunctioanry__textField = new JTextField();
		ciCreateFunctioanry__textField.setBounds(195, 23, 130, 26);
		createFunctionary__panel.add(ciCreateFunctioanry__textField);
		ciCreateFunctioanry__textField.setColumns(10);

		nameCreateFunctionary__textField = new JTextField();
		nameCreateFunctionary__textField.setBounds(195, 56, 130, 26);
		createFunctionary__panel.add(nameCreateFunctionary__textField);
		nameCreateFunctionary__textField.setColumns(10);

		lastNameCreateFunctionary__textField = new JTextField();
		lastNameCreateFunctionary__textField.setBounds(219, 89, 130, 26);
		createFunctionary__panel.add(lastNameCreateFunctionary__textField);
		lastNameCreateFunctionary__textField.setColumns(10);

		mailCreateFunctioanry__textField = new JTextField();
		mailCreateFunctioanry__textField.setBounds(208, 122, 184, 26);
		createFunctionary__panel.add(mailCreateFunctioanry__textField);
		mailCreateFunctioanry__textField.setColumns(10);

		passwordCreateFunctionary__textField = new JTextField();
		passwordCreateFunctionary__textField.setBounds(208, 151, 130, 26);
		createFunctionary__panel.add(passwordCreateFunctionary__textField);
		passwordCreateFunctionary__textField.setColumns(10);

		dateCreateFunctionary__textField = new JTextField();
		dateCreateFunctionary__textField.setBounds(208, 189, 130, 26);
		createFunctionary__panel.add(dateCreateFunctionary__textField);
		dateCreateFunctionary__textField.setColumns(10);

		JButton submitCreateFunctionary__button = new JButton("SUBMIT");
		submitCreateFunctionary__button.setBounds(200, 220, 117, 29);
		createFunctionary__panel.add(submitCreateFunctionary__button);

		submitCreateFunctionary__button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JPanel createTeacher__panel = new JPanel();
		userType__panel.add(createTeacher__panel, "CREATE_TEACHER_PANEL");
		createTeacher__panel.setLayout(null);

		JLabel nameCreateTeacher__label = new JLabel("Name:");
		nameCreateTeacher__label.setBounds(139, 61, 61, 16);
		createTeacher__panel.add(nameCreateTeacher__label);

		JLabel ciCreateTeacher__label = new JLabel("CI:");
		ciCreateTeacher__label.setBounds(139, 28, 61, 16);
		createTeacher__panel.add(ciCreateTeacher__label);

		JLabel passwordCreateTeacher__label = new JLabel("Password:");
		passwordCreateTeacher__label.setBounds(139, 156, 91, 16);
		createTeacher__panel.add(passwordCreateTeacher__label);

		JLabel lastNameCreateTeacher__label = new JLabel("Last name:");
		lastNameCreateTeacher__label.setBounds(139, 94, 108, 16);
		createTeacher__panel.add(lastNameCreateTeacher__label);

		JLabel dateCreateTeacher__label = new JLabel("Birth date:");
		dateCreateTeacher__label.setBounds(139, 194, 91, 16);
		createTeacher__panel.add(dateCreateTeacher__label);

		JLabel mailCreateTeacher__label = new JLabel("Mail:");
		mailCreateTeacher__label.setBounds(139, 122, 117, 29);
		createTeacher__panel.add(mailCreateTeacher__label);

		ciCreateTeacher__textField = new JTextField();
		ciCreateTeacher__textField.setBounds(195, 23, 130, 26);
		createTeacher__panel.add(ciCreateTeacher__textField);
		ciCreateTeacher__textField.setColumns(10);

		nameCreateTeacher__textField = new JTextField();
		nameCreateTeacher__textField.setBounds(195, 56, 130, 26);
		createTeacher__panel.add(nameCreateTeacher__textField);
		nameCreateTeacher__textField.setColumns(10);

		lastNameCreateTeacher__textField = new JTextField();
		lastNameCreateTeacher__textField.setBounds(219, 89, 130, 26);
		createTeacher__panel.add(lastNameCreateTeacher__textField);
		lastNameCreateTeacher__textField.setColumns(10);

		mailCreateTeacher__textField = new JTextField();
		mailCreateTeacher__textField.setBounds(208, 122, 184, 26);
		createTeacher__panel.add(mailCreateTeacher__textField);
		mailCreateTeacher__textField.setColumns(10);

		passwordCreateTeacher__textField = new JTextField();
		passwordCreateTeacher__textField.setBounds(208, 151, 130, 26);
		createTeacher__panel.add(passwordCreateTeacher__textField);
		passwordCreateTeacher__textField.setColumns(10);

		dateCreateTeacher__textField = new JTextField();
		dateCreateTeacher__textField.setBounds(208, 189, 130, 26);
		createTeacher__panel.add(dateCreateTeacher__textField);
		dateCreateTeacher__textField.setColumns(10);

		JButton submitCreateTeacher__button = new JButton("SUBMIT");
		submitCreateTeacher__button.setBounds(200, 220, 117, 29);
		createTeacher__panel.add(submitCreateTeacher__button);
		
		JPanel createSubj__panel = new JPanel();
		master__panel.add(createSubj__panel, "name_6070420451057");

		submitCreateTeacher__button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		createStudent__radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				userType__cardLayout.show(userType__panel, "CREATE_STUDENT_PANEL");

			}
		});

		createFunctioanry__radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				userType__cardLayout.show(userType__panel, "CREATE_FUNCTIONARY_PANEL");

			}
		});

		createTeacher__radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				userType__cardLayout.show(userType__panel, "CREATE_TEACHER_PANEL");

			}
		});

		submitLogin__button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isUserLoggedIn) {
					master__cardLayout.show(master__panel, "WELCOME_PANEL");
				}
			}
		});
	}
}
