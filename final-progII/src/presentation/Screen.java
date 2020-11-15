package presentation;

import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import persistence.ControllerDB;

import logic.ControllerLogic;
import logic.Functionary;
import logic.Generation;
import logic.Orientation;
import logic.Status;
import persistence.Conn;
import logic.Student;
import logic.Subject;
import logic.Teacher;
import logic.User;
import javax.swing.table.DefaultTableModel;

public class Screen extends JFrame {

	protected static final JComboBox orientationConsultUserSubject__comboBox = null;
	protected static final JComboBox generationConsultUserSubject__comboBox = null;
	private static ControllerLogic controller;

	private JPanel contentPane;
	private JPanel master__panel;
	private CardLayout master__cardLayout;
	private CardLayout userType__cardLayout;
	private JTextField ciLogin__textField;
	private JTextField passwordLogin__textField;
	private JTextField ciCreateStudent__textField;
	private JTextField nameCreateStudent__textField;
	private JTextField lastNameCreateStudent__textField;
	private JTextField mailCreateStudent__textField;
	private JTextField passwordCreateStudent__textField;
	private JTextField yearStudent__textField;
	private JTextField ciCreateTeacher__textField;
	private JTextField nameCreateTeacher__textField;
	private JTextField lastNameCreateTeacher__textField;
	private JTextField mailCreateTeacher__textField;
	private JTextField passwordCreateTeacher__textField;
	private JTextField dateYearCreateTeacher__textField;
	private JTextField ciCreateFunctionary__textField;
	private JTextField nameCreateFunctionary__textField;
	private JTextField lastNameCreateFunctionary__textField;
	private JTextField mailCreateFunctionary__textField;
	private JTextField passwordCreateFunctionary__textField;
	private JTextField dateYearCreateFunctionary__textField;
	private JComboBox generationCreateStudent__comboBox;
	private JComboBox orientationCreateStudent__comboBox;
	private JTextField searchCiConsultUser__textField;
	private JTextField nameConsultUser__textField;
	private JTextField lastNameConsultUser__textField;
	private JTextField emailConsultUser__textField;
	private JTextField passwordConsultUser__textField;
	private JTextField ciConsultUser__textField__textField;
	private JTextField dateYearConsultUser__textField;
	private JTable StudentList__table;
	private JTable listTeacher__table;
	private JTable functionaryList__table;
	private JTextField codeCreateSubject__textField;
	private JTextField nameCreateSubject__textField;
	private JTextField orientationCreateSubject__textField;
	private JTextField generationCreateSubject__textField;
	private JTextField teacherCreateSubject__textField;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTable table_3;
	private JTextField textField_17;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_18;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTable table_4;
	private JTable table_5;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField dateMonthCreateFunctionary__textField;
	private JTextField dateDayCreateFunctionary__textField;
	private JTextField dateMonthCreateTeacher__textField;
	private JTextField dateDayCreateTeacher__textField;
	private JTextField nameConsultUserSubject__textField;
	private JTextField markConsultUserSubject__textField;
	private JTextField dateMonthConsultUser__textField;
	private JTextField dateDayConsultUser__textField;
	private JTextField monthStudent__textField;
	private JTextField dayStudent__textField;

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
	@SuppressWarnings("deprecation")
	public Screen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 859, 570);
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

		JLabel ciLogin__label = new JLabel("CI:");
		ciLogin__label.setBounds(198, 210, 61, 16);
		login__panel.add(ciLogin__label);

		JLabel passwordLogin__label = new JLabel("Password:");
		passwordLogin__label.setBounds(198, 253, 69, 16);
		login__panel.add(passwordLogin__label);

		JButton submitLogin__button = new JButton("SUBMIT");
		submitLogin__button.setBounds(235, 301, 117, 29);
		login__panel.add(submitLogin__button);

		passwordLogin__textField = new JTextField();
		passwordLogin__textField.setBounds(294, 248, 130, 26);
		login__panel.add(passwordLogin__textField);
		passwordLogin__textField.setColumns(10);

		ciLogin__textField = new JTextField();
		ciLogin__textField.setColumns(10);
		ciLogin__textField.setBounds(294, 205, 130, 26);
		login__panel.add(ciLogin__textField);

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
		DescriptionWelcome__Label.setBounds(168, 176, 177, 16);
		welcome__panel.add(DescriptionWelcome__Label);

		JPanel createUser__panel = new JPanel();
		master__panel.add(createUser__panel, "CREATE_USER_PANEL");
		Menu createUser__menu = new Menu(createUser__panel, master__panel, master__cardLayout);
		createUser__panel.setLayout(null);

		JLabel titleCreateUser__label = new JLabel("Create a new User");
		titleCreateUser__label.setBounds(239, 33, 124, 16);
		createUser__panel.add(titleCreateUser__label);

		JRadioButton createStudent__radioButton = new JRadioButton("Student");
		createStudent__radioButton.setBounds(46, 78, 141, 23);
		createStudent__radioButton.setSelected(true);
		createUser__panel.add(createStudent__radioButton);

		JRadioButton createFunctioanry__radioButton = new JRadioButton("Functioanry");
		createFunctioanry__radioButton.setBounds(219, 78, 141, 23);
		createUser__panel.add(createFunctioanry__radioButton);

		JRadioButton createTeacher__radioButton = new JRadioButton("Teacher");
		createTeacher__radioButton.setBounds(397, 78, 141, 23);
		createUser__panel.add(createTeacher__radioButton);

		ButtonGroup userTypeCreateUser__buttonGroup = new ButtonGroup();
		userTypeCreateUser__buttonGroup.add(createStudent__radioButton);
		userTypeCreateUser__buttonGroup.add(createFunctioanry__radioButton);
		userTypeCreateUser__buttonGroup.add(createTeacher__radioButton);

		JLabel descriptionCreateUser__label = new JLabel("Select the type of user that you want to create.");
		descriptionCreateUser__label.setBounds(139, 55, 293, 16);
		createUser__panel.add(descriptionCreateUser__label);

		JPanel userType__panel = new JPanel();
		userType__panel.setBounds(46, 113, 462, 384);
		createUser__panel.add(userType__panel);
		userType__panel.setLayout(new CardLayout(0, 0));
		userType__cardLayout = (CardLayout) userType__panel.getLayout();

		JPanel createStudent__panel = new JPanel();
		createStudent__panel.setBounds(80, 120, 400, 380);
		userType__panel.add(createStudent__panel, "CREATE_STUDENT_PANEL");
		createStudent__panel.setLayout(null);

		userType__cardLayout.show(userType__panel, "CREATE_STUDENT_PANEL");

		JLabel nameCreateStudent__label = new JLabel("Name:");
		nameCreateStudent__label.setBounds(111, 49, 61, 16);
		createStudent__panel.add(nameCreateStudent__label);

		JLabel ciCreateStudent__label = new JLabel("CI:");
		ciCreateStudent__label.setBounds(111, 19, 61, 16);
		createStudent__panel.add(ciCreateStudent__label);

		JLabel passwordCreateStudent__label = new JLabel("Password:");
		passwordCreateStudent__label.setBounds(111, 149, 91, 16);
		createStudent__panel.add(passwordCreateStudent__label);

		JLabel lastNameCreateStudent__label = new JLabel("Last name:");
		lastNameCreateStudent__label.setBounds(110, 82, 62, 16);
		createStudent__panel.add(lastNameCreateStudent__label);

		JLabel dateCreateStudent__label = new JLabel("Birth date:");
		dateCreateStudent__label.setBounds(111, 213, 61, 16);
		createStudent__panel.add(dateCreateStudent__label);

		JLabel generationCreateStudent__label = new JLabel("Generation:");
		generationCreateStudent__label.setBounds(111, 181, 91, 16);
		createStudent__panel.add(generationCreateStudent__label);

		JLabel orientationCreateStudent__label = new JLabel("Orientation:");
		orientationCreateStudent__label.setBounds(111, 241, 91, 16);
		createStudent__panel.add(orientationCreateStudent__label);

		JLabel mailCreateStudent__label = new JLabel("Mail:");
		mailCreateStudent__label.setBounds(111, 115, 61, 16);
		createStudent__panel.add(mailCreateStudent__label);

		JButton submitCreateStudent__button = new JButton("SUBMIT");
		submitCreateStudent__button.setBounds(183, 285, 117, 29);
		createStudent__panel.add(submitCreateStudent__button);

		String generations[] = { "GEN18", "GEN19", "GEN20" };
		generationCreateStudent__comboBox = new JComboBox(generations);
		generationCreateStudent__comboBox
				.setModel(new DefaultComboBoxModel(new String[] { "FIRST", "SECOND", "THIRD" }));
		generationCreateStudent__comboBox.setBounds(195, 180, 130, 27);
		createStudent__panel.add(generationCreateStudent__comboBox);

		String orientations[] = { "ADM", "TIC" };
		orientationCreateStudent__comboBox = new JComboBox(orientations);
		orientationCreateStudent__comboBox.setBounds(183, 247, 142, 27);
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
		lastNameCreateStudent__textField.setBounds(195, 81, 130, 26);
		createStudent__panel.add(lastNameCreateStudent__textField);
		lastNameCreateStudent__textField.setColumns(10);

		mailCreateStudent__textField = new JTextField();
		mailCreateStudent__textField.setBounds(195, 115, 130, 26);
		createStudent__panel.add(mailCreateStudent__textField);
		mailCreateStudent__textField.setColumns(10);

		passwordCreateStudent__textField = new JTextField();
		passwordCreateStudent__textField.setBounds(195, 149, 130, 26);
		createStudent__panel.add(passwordCreateStudent__textField);
		passwordCreateStudent__textField.setColumns(10);

		yearStudent__textField = new JTextField();
		yearStudent__textField.setBounds(195, 213, 38, 26);
		createStudent__panel.add(yearStudent__textField);
		yearStudent__textField.setColumns(10);

		monthStudent__textField = new JTextField();
		monthStudent__textField.setColumns(10);
		monthStudent__textField.setBounds(243, 213, 38, 26);
		createStudent__panel.add(monthStudent__textField);

		dayStudent__textField = new JTextField();
		dayStudent__textField.setColumns(10);
		dayStudent__textField.setBounds(291, 213, 38, 26);
		createStudent__panel.add(dayStudent__textField);

		JPanel createFunctionary__panel = new JPanel();
		userType__panel.add(createFunctionary__panel, "CREATE_FUNCTIONARY_PANEL");
		createFunctionary__panel.setLayout(null);

		JLabel nameCreateFunctionary__label = new JLabel("Name:");
		nameCreateFunctionary__label.setBounds(118, 56, 61, 16);
		createFunctionary__panel.add(nameCreateFunctionary__label);

		JLabel ciCreateFunctioanry__label = new JLabel("CI:");
		ciCreateFunctioanry__label.setBounds(118, 23, 61, 16);
		createFunctionary__panel.add(ciCreateFunctioanry__label);

		JLabel passwordCreateFunctioanry__label = new JLabel("Password:");
		passwordCreateFunctioanry__label.setBounds(118, 151, 91, 16);
		createFunctionary__panel.add(passwordCreateFunctioanry__label);

		JLabel lastNameCreateFunctionary__label = new JLabel("Last name:");
		lastNameCreateFunctionary__label.setBounds(118, 89, 108, 16);
		createFunctionary__panel.add(lastNameCreateFunctionary__label);

		JLabel dateCreateFunctionary__label = new JLabel("Birth date:");
		dateCreateFunctionary__label.setBounds(118, 189, 91, 16);
		createFunctionary__panel.add(dateCreateFunctionary__label);

		JLabel mailCreateFunctionary__label = new JLabel("Mail:");
		mailCreateFunctionary__label.setBounds(118, 117, 39, 29);
		createFunctionary__panel.add(mailCreateFunctionary__label);

		ciCreateFunctionary__textField = new JTextField();
		ciCreateFunctionary__textField.setBounds(195, 23, 130, 26);
		createFunctionary__panel.add(ciCreateFunctionary__textField);
		ciCreateFunctionary__textField.setColumns(10);

		nameCreateFunctionary__textField = new JTextField();
		nameCreateFunctionary__textField.setBounds(195, 56, 130, 26);
		createFunctionary__panel.add(nameCreateFunctionary__textField);
		nameCreateFunctionary__textField.setColumns(10);

		lastNameCreateFunctionary__textField = new JTextField();
		lastNameCreateFunctionary__textField.setBounds(195, 89, 130, 26);
		createFunctionary__panel.add(lastNameCreateFunctionary__textField);
		lastNameCreateFunctionary__textField.setColumns(10);

		mailCreateFunctionary__textField = new JTextField();
		mailCreateFunctionary__textField.setBounds(195, 120, 130, 26);
		createFunctionary__panel.add(mailCreateFunctionary__textField);
		mailCreateFunctionary__textField.setColumns(10);

		passwordCreateFunctionary__textField = new JTextField();
		passwordCreateFunctionary__textField.setBounds(195, 152, 130, 26);
		createFunctionary__panel.add(passwordCreateFunctionary__textField);
		passwordCreateFunctionary__textField.setColumns(10);

		dateYearCreateFunctionary__textField = new JTextField();
		dateYearCreateFunctionary__textField.setBounds(195, 184, 39, 26);
		createFunctionary__panel.add(dateYearCreateFunctionary__textField);
		dateYearCreateFunctionary__textField.setColumns(10);

		JButton submitCreateFunctionary__button = new JButton("SUBMIT");
		submitCreateFunctionary__button.setBounds(178, 226, 117, 29);
		createFunctionary__panel.add(submitCreateFunctionary__button);

		dateMonthCreateFunctionary__textField = new JTextField();
		dateMonthCreateFunctionary__textField.setBounds(241, 184, 39, 27);
		createFunctionary__panel.add(dateMonthCreateFunctionary__textField);
		dateMonthCreateFunctionary__textField.setColumns(10);

		dateDayCreateFunctionary__textField = new JTextField();
		dateDayCreateFunctionary__textField.setBounds(287, 184, 39, 27);
		createFunctionary__panel.add(dateDayCreateFunctionary__textField);
		dateDayCreateFunctionary__textField.setColumns(10);

		submitCreateFunctionary__button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int ciFunctionary = Integer.parseInt(ciCreateFunctionary__textField.getText());
				String nameFunctionary = nameCreateFunctionary__textField.getText();
				String lastNameFunctionary = lastNameCreateFunctionary__textField.getText();
				String mailFunctionary = mailCreateFunctionary__textField.getText();
				String psswdFunctionary = passwordCreateFunctionary__textField.getText();
				int yearDateFunctionary = Integer.parseInt(dateYearCreateFunctionary__textField.getText());
				int monthDateFunctionary = Integer.parseInt(dateMonthCreateFunctionary__textField.getText());
				int dayDateFunctionary = Integer.parseInt(dateMonthCreateFunctionary__textField.getText());

				Functionary functionary = new Functionary(ciFunctionary, nameFunctionary, lastNameFunctionary,
						mailFunctionary, psswdFunctionary,
						LocalDate.of(yearDateFunctionary, monthDateFunctionary, dayDateFunctionary));

				try {
					controller.createUser(functionary);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JPanel createTeacher__panel = new JPanel();
		userType__panel.add(createTeacher__panel, "CREATE_TEACHER_PANEL");
		createTeacher__panel.setLayout(null);

		JLabel nameCreateTeacher__label = new JLabel("Name:");
		nameCreateTeacher__label.setBounds(120, 66, 61, 16);
		createTeacher__panel.add(nameCreateTeacher__label);

		JLabel ciCreateTeacher__label = new JLabel("CI:");
		ciCreateTeacher__label.setBounds(120, 33, 61, 16);
		createTeacher__panel.add(ciCreateTeacher__label);

		JLabel passwordCreateTeacher__label = new JLabel("Password:");
		passwordCreateTeacher__label.setBounds(120, 161, 91, 16);
		createTeacher__panel.add(passwordCreateTeacher__label);

		JLabel lastNameCreateTeacher__label = new JLabel("Last name:");
		lastNameCreateTeacher__label.setBounds(120, 99, 108, 16);
		createTeacher__panel.add(lastNameCreateTeacher__label);

		JLabel dateCreateTeacher__label = new JLabel("Birth date:");
		dateCreateTeacher__label.setBounds(120, 199, 91, 16);
		createTeacher__panel.add(dateCreateTeacher__label);

		JLabel mailCreateTeacher__label = new JLabel("Mail:");
		mailCreateTeacher__label.setBounds(120, 127, 39, 29);
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
		lastNameCreateTeacher__textField.setBounds(195, 89, 130, 26);
		createTeacher__panel.add(lastNameCreateTeacher__textField);
		lastNameCreateTeacher__textField.setColumns(10);

		mailCreateTeacher__textField = new JTextField();
		mailCreateTeacher__textField.setBounds(195, 124, 130, 26);
		createTeacher__panel.add(mailCreateTeacher__textField);
		mailCreateTeacher__textField.setColumns(10);

		passwordCreateTeacher__textField = new JTextField();
		passwordCreateTeacher__textField.setBounds(195, 156, 130, 26);
		createTeacher__panel.add(passwordCreateTeacher__textField);
		passwordCreateTeacher__textField.setColumns(10);

		dateYearCreateTeacher__textField = new JTextField();
		dateYearCreateTeacher__textField.setBounds(195, 194, 39, 26);
		createTeacher__panel.add(dateYearCreateTeacher__textField);
		dateYearCreateTeacher__textField.setColumns(10);

		JButton submitCreateTeacher__button = new JButton("SUBMIT");
		submitCreateTeacher__button.setBounds(189, 238, 117, 29);
		createTeacher__panel.add(submitCreateTeacher__button);

		dateMonthCreateTeacher__textField = new JTextField();
		dateMonthCreateTeacher__textField.setBounds(238, 194, 39, 27);
		createTeacher__panel.add(dateMonthCreateTeacher__textField);
		dateMonthCreateTeacher__textField.setColumns(10);

		dateDayCreateTeacher__textField = new JTextField();
		dateDayCreateTeacher__textField.setBounds(287, 194, 39, 27);
		createTeacher__panel.add(dateDayCreateTeacher__textField);
		dateDayCreateTeacher__textField.setColumns(10);

		JPanel consultUser__panel = new JPanel();
		master__panel.add(consultUser__panel, "name_6070420451057");
		Menu consultUserr__panel = new Menu(consultUser__panel, master__panel, master__cardLayout);
		consultUser__panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Consult a user from the Database");
		lblNewLabel.setBounds(165, 67, 217, 16);
		consultUser__panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("C.I");
		lblNewLabel_1.setBounds(122, 112, 28, 16);
		consultUser__panel.add(lblNewLabel_1);

		searchCiConsultUser__textField = new JTextField();
		searchCiConsultUser__textField.setBounds(165, 107, 161, 26);
		consultUser__panel.add(searchCiConsultUser__textField);
		searchCiConsultUser__textField.setColumns(10);

		JButton searchConsultUser__btnNewButton = new JButton("Search");
		searchConsultUser__btnNewButton.setBounds(334, 106, 117, 29);
		consultUser__panel.add(searchConsultUser__btnNewButton);

		JPanel editConsult__panel = new JPanel();
		editConsult__panel.setBounds(52, 139, 470, 371);
		consultUser__panel.add(editConsult__panel);
		editConsult__panel.setLayout(null);
		editConsult__panel.show(false);

		JPanel infoUser__panel = new JPanel();
		infoUser__panel.setBounds(47, 11, 391, 181);
		editConsult__panel.add(infoUser__panel);
		infoUser__panel.setLayout(null);
		infoUser__panel.show(false);

		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setBounds(10, 14, 67, 14);
		infoUser__panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Lastname");
		lblNewLabel_3.setBounds(10, 45, 67, 14);
		infoUser__panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(10, 73, 67, 14);
		infoUser__panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setBounds(10, 98, 67, 14);
		infoUser__panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("C.I");
		lblNewLabel_6.setBounds(10, 123, 42, 14);
		infoUser__panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Date Birth");
		lblNewLabel_7.setBounds(10, 152, 57, 14);
		infoUser__panel.add(lblNewLabel_7);

		nameConsultUser__textField = new JTextField();
		nameConsultUser__textField.setBounds(87, 11, 86, 20);
		infoUser__panel.add(nameConsultUser__textField);
		nameConsultUser__textField.setColumns(10);

		lastNameConsultUser__textField = new JTextField();
		lastNameConsultUser__textField.setBounds(87, 42, 86, 20);
		infoUser__panel.add(lastNameConsultUser__textField);
		lastNameConsultUser__textField.setColumns(10);

		emailConsultUser__textField = new JTextField();
		emailConsultUser__textField.setBounds(87, 70, 86, 20);
		infoUser__panel.add(emailConsultUser__textField);
		emailConsultUser__textField.setColumns(10);

		passwordConsultUser__textField = new JTextField();
		passwordConsultUser__textField.setBounds(87, 95, 86, 20);
		infoUser__panel.add(passwordConsultUser__textField);
		passwordConsultUser__textField.setColumns(10);

		ciConsultUser__textField__textField = new JTextField();
		ciConsultUser__textField__textField.setBounds(87, 120, 86, 20);
		infoUser__panel.add(ciConsultUser__textField__textField);
		ciConsultUser__textField__textField.setColumns(10);

		dateYearConsultUser__textField = new JTextField();
		dateYearConsultUser__textField.setBounds(87, 149, 33, 20);
		infoUser__panel.add(dateYearConsultUser__textField);
		dateYearConsultUser__textField.setColumns(10);

		dateMonthConsultUser__textField = new JTextField();
		dateMonthConsultUser__textField.setColumns(10);
		dateMonthConsultUser__textField.setBounds(125, 149, 33, 20);
		infoUser__panel.add(dateMonthConsultUser__textField);

		dateDayConsultUser__textField = new JTextField();
		dateDayConsultUser__textField.setColumns(10);
		dateDayConsultUser__textField.setBounds(168, 149, 42, 20);
		infoUser__panel.add(dateDayConsultUser__textField);

		JButton updateConsult__btnNewButton = new JButton("Update");
		updateConsult__btnNewButton.setBounds(254, 10, 89, 23);
		infoUser__panel.add(updateConsult__btnNewButton);

		JPanel modifySubjectsOfTeacher__panel = new JPanel();
		modifySubjectsOfTeacher__panel.setBounds(463, 80, 243, 165);
		infoUser__panel.add(modifySubjectsOfTeacher__panel);
		modifySubjectsOfTeacher__panel.setLayout(null);

		JPanel addSubjectStudent__panel = new JPanel();
		addSubjectStudent__panel.setBounds(10, 203, 450, 157);
		editConsult__panel.add(addSubjectStudent__panel);
		addSubjectStudent__panel.setLayout(null);
		addSubjectStudent__panel.show(false);

		JButton addSubjectConsultUser__btnNewButton = new JButton("Add subject");
		addSubjectConsultUser__btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String nameConsultSubjectdAdd = nameConsultUserSubject__textField.getText();
				String orientationConsultSubjectAdd = orientationConsultUserSubject__comboBox.getSelectedItem()
						.toString();
				String generationConsultSubjectAdd = generationConsultUserSubject__comboBox.getSelectedItem()
						.toString();
				String markConsultSubjectAdd = markConsultUserSubject__textField.getText();

				try {

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		addSubjectConsultUser__btnNewButton.setBounds(351, 123, 89, 23);
		addSubjectStudent__panel.add(addSubjectConsultUser__btnNewButton);
		addSubjectConsultUser__btnNewButton.show(false);

		nameConsultUserSubject__textField = new JTextField();
		nameConsultUserSubject__textField.setBounds(174, 11, 86, 20);
		addSubjectStudent__panel.add(nameConsultUserSubject__textField);
		nameConsultUserSubject__textField.setColumns(10);

		markConsultUserSubject__textField = new JTextField();
		markConsultUserSubject__textField.setBounds(174, 105, 86, 20);
		addSubjectStudent__panel.add(markConsultUserSubject__textField);
		markConsultUserSubject__textField.setColumns(10);

		JLabel lblNewLabel_60 = new JLabel("Name");
		lblNewLabel_60.setBounds(85, 11, 46, 14);
		addSubjectStudent__panel.add(lblNewLabel_60);

		JLabel lblNewLabel_61 = new JLabel("Orientation");
		lblNewLabel_61.setBounds(85, 45, 79, 14);
		addSubjectStudent__panel.add(lblNewLabel_61);

		JLabel lblNewLabel_62 = new JLabel("Generation");
		lblNewLabel_62.setBounds(85, 77, 79, 14);
		addSubjectStudent__panel.add(lblNewLabel_62);

		JLabel lblNewLabel_63 = new JLabel("Mark");
		lblNewLabel_63.setBounds(85, 108, 46, 14);
		addSubjectStudent__panel.add(lblNewLabel_63);

		JComboBox orientationConsultUserSubject__comboBox = new JComboBox();
		orientationConsultUserSubject__comboBox.setModel(new DefaultComboBoxModel(new String[] { "ADM", "TIC" }));
		orientationConsultUserSubject__comboBox.setBounds(174, 41, 89, 22);
		addSubjectStudent__panel.add(orientationConsultUserSubject__comboBox);

		JComboBox generationConsultUserSubject__comboBox = new JComboBox();
		generationConsultUserSubject__comboBox
				.setModel(new DefaultComboBoxModel(new String[] { "FIRST", "SECOND", "THIRD" }));
		generationConsultUserSubject__comboBox.setBounds(174, 72, 89, 22);
		addSubjectStudent__panel.add(generationConsultUserSubject__comboBox);

		JPanel listUsers__panel = new JPanel();
		master__panel.add(listUsers__panel, "name_110770879092900");
		Menu listUserss__panel = new Menu(listUsers__panel, master__panel, master__cardLayout);
		listUsers__panel.setLayout(null);

		JPanel listOfFunctionary__panel = new JPanel();
		listOfFunctionary__panel.setLayout(null);
		listOfFunctionary__panel.setBounds(82, 205, 393, 225);
		listUsers__panel.add(listOfFunctionary__panel);
		listOfFunctionary__panel.show(false);

		functionaryList__table = new JTable();
		functionaryList__table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column", "New column" }));
		functionaryList__table.setBounds(10, 24, 373, 190);
		listOfFunctionary__panel.add(functionaryList__table);

		JLabel lblNewLabel_10_2 = new JLabel("CI");
		lblNewLabel_10_2.setBounds(30, 6, 46, 14);
		listOfFunctionary__panel.add(lblNewLabel_10_2);

		JLabel lblNewLabel_11_2 = new JLabel("NAME");
		lblNewLabel_11_2.setBounds(88, 0, 72, 27);
		listOfFunctionary__panel.add(lblNewLabel_11_2);

		JLabel lblNewLabel_12_2 = new JLabel("LASTNAME");
		lblNewLabel_12_2.setBounds(160, 6, 65, 14);
		listOfFunctionary__panel.add(lblNewLabel_12_2);

		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(66, 108, 46, 14);
		listOfFunctionary__panel.add(label_3);

		JLabel label_1_2 = new JLabel("New label");
		label_1_2.setBounds(10, 119, 46, 14);
		listOfFunctionary__panel.add(label_1_2);

		JLabel lblNewLabel_12_2_1 = new JLabel("MAIL");
		lblNewLabel_12_2_1.setBounds(235, 6, 65, 14);
		listOfFunctionary__panel.add(lblNewLabel_12_2_1);

		JLabel lblNewLabel_12_2_1_1 = new JLabel("PASSWORD");
		lblNewLabel_12_2_1_1.setBounds(310, 6, 65, 14);
		listOfFunctionary__panel.add(lblNewLabel_12_2_1_1);

		JLabel lblNewLabel_8 = new JLabel("Liste Users");
		lblNewLabel_8.setBounds(214, 86, 149, 14);
		listUsers__panel.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Select the type of User to List");
		lblNewLabel_9.setBounds(175, 125, 171, 14);
		listUsers__panel.add(lblNewLabel_9);

		JRadioButton listStudent__rdbtnNewRadioButton = new JRadioButton("Student");
		listStudent__rdbtnNewRadioButton.setBounds(83, 165, 109, 23);
		listUsers__panel.add(listStudent__rdbtnNewRadioButton);

		JRadioButton listTeacher__rdbtnNewRadioButton_1 = new JRadioButton("Teacher");
		listTeacher__rdbtnNewRadioButton_1.setBounds(223, 165, 109, 23);
		listUsers__panel.add(listTeacher__rdbtnNewRadioButton_1);

		JRadioButton listFunctionary__rdbtnNewRadioButton_2 = new JRadioButton("Functionary");
		listFunctionary__rdbtnNewRadioButton_2.setBounds(366, 165, 109, 23);
		listUsers__panel.add(listFunctionary__rdbtnNewRadioButton_2);

		JPanel listOfStudent__panel = new JPanel();
		listOfStudent__panel.setBounds(82, 205, 393, 225);
		listUsers__panel.add(listOfStudent__panel);
		listOfStudent__panel.setLayout(null);
		listOfStudent__panel.show(false);

		StudentList__table = new JTable();
		StudentList__table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "New column", "New column", "New column", "New column", "New column" }));
		StudentList__table.setBounds(10, 24, 373, 190);
		listOfStudent__panel.add(StudentList__table);

		JLabel lblNewLabel_10 = new JLabel("CI");
		lblNewLabel_10.setBounds(10, 6, 46, 14);
		listOfStudent__panel.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("NAME");
		lblNewLabel_11.setBounds(83, 0, 72, 27);
		listOfStudent__panel.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("LASTNAME");
		lblNewLabel_12.setBounds(152, 6, 65, 14);
		listOfStudent__panel.add(lblNewLabel_12);

		JLabel label = new JLabel("New label");
		label.setBounds(66, 108, 46, 14);
		listOfStudent__panel.add(label);

		JLabel lblNewLabel_13 = new JLabel("ORIENTATION");
		lblNewLabel_13.setBounds(219, 6, 86, 14);
		listOfStudent__panel.add(lblNewLabel_13);

		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(10, 119, 46, 14);
		listOfStudent__panel.add(label_1);

		JLabel lblNewLabel_14 = new JLabel("GENERATION");
		lblNewLabel_14.setBounds(303, 6, 78, 14);
		listOfStudent__panel.add(lblNewLabel_14);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(366, 24, 17, 48);
		listOfStudent__panel.add(scrollBar);

		JPanel listOfTeacher__panel = new JPanel();
		listOfTeacher__panel.setLayout(null);
		listOfTeacher__panel.setBounds(82, 205, 393, 225);
		listUsers__panel.add(listOfTeacher__panel);
		listOfTeacher__panel.show(false);

		listTeacher__table = new JTable();
		listTeacher__table.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column", "New column" }));
		listTeacher__table.setBounds(10, 24, 373, 190);
		listOfTeacher__panel.add(listTeacher__table);

		JLabel lblNewLabel_10_1 = new JLabel("CI");
		lblNewLabel_10_1.setBounds(33, 6, 46, 14);
		listOfTeacher__panel.add(lblNewLabel_10_1);

		JLabel lblNewLabel_11_1 = new JLabel("NAME");
		lblNewLabel_11_1.setBounds(89, 0, 72, 27);
		listOfTeacher__panel.add(lblNewLabel_11_1);

		JLabel lblNewLabel_12_1 = new JLabel("MAIL");
		lblNewLabel_12_1.setBounds(233, 6, 65, 14);
		listOfTeacher__panel.add(lblNewLabel_12_1);

		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(66, 108, 46, 14);
		listOfTeacher__panel.add(label_2);

		JLabel label_1_1 = new JLabel("New label");
		label_1_1.setBounds(10, 119, 46, 14);
		listOfTeacher__panel.add(label_1_1);

		JLabel lblNewLabel_11_1_1 = new JLabel("LASTNAME");
		lblNewLabel_11_1_1.setBounds(163, 0, 72, 27);
		listOfTeacher__panel.add(lblNewLabel_11_1_1);

		JLabel lblNewLabel_12_1_1 = new JLabel("PASSWORD");
		lblNewLabel_12_1_1.setBounds(308, 6, 65, 14);
		listOfTeacher__panel.add(lblNewLabel_12_1_1);

		JPanel createSubject_panel = new JPanel();
		master__panel.add(createSubject_panel, "name_113009623994000");
		createSubject_panel.setLayout(null);
		Menu createSubjectT_panel = new Menu(createSubject_panel, master__panel, master__cardLayout);

		JLabel lblNewLabel_15 = new JLabel("Create Subject");
		lblNewLabel_15.setBounds(228, 67, 86, 14);
		createSubject_panel.add(lblNewLabel_15);

		codeCreateSubject__textField = new JTextField();
		codeCreateSubject__textField.setBounds(260, 115, 86, 20);
		createSubject_panel.add(codeCreateSubject__textField);
		codeCreateSubject__textField.setColumns(10);

		nameCreateSubject__textField = new JTextField();
		nameCreateSubject__textField.setBounds(260, 146, 86, 20);
		createSubject_panel.add(nameCreateSubject__textField);
		nameCreateSubject__textField.setColumns(10);

		orientationCreateSubject__textField = new JTextField();
		orientationCreateSubject__textField.setBounds(260, 177, 86, 20);
		createSubject_panel.add(orientationCreateSubject__textField);
		orientationCreateSubject__textField.setColumns(10);

		generationCreateSubject__textField = new JTextField();
		generationCreateSubject__textField.setBounds(260, 208, 86, 20);
		createSubject_panel.add(generationCreateSubject__textField);
		generationCreateSubject__textField.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("Code");
		lblNewLabel_16.setBounds(168, 118, 46, 14);
		createSubject_panel.add(lblNewLabel_16);

		JLabel lblNewLabel_17 = new JLabel("Name");
		lblNewLabel_17.setBounds(168, 149, 46, 14);
		createSubject_panel.add(lblNewLabel_17);

		JLabel lblNewLabel_18 = new JLabel("Orientation");
		lblNewLabel_18.setBounds(168, 180, 67, 14);
		createSubject_panel.add(lblNewLabel_18);

		JLabel lblNewLabel_19 = new JLabel("Generation");
		lblNewLabel_19.setBounds(168, 211, 67, 14);
		createSubject_panel.add(lblNewLabel_19);

		JButton submitCreateSubject__button = new JButton("Create");
		submitCreateSubject__button.setBounds(322, 286, 89, 23);
		createSubject_panel.add(submitCreateSubject__button);

		teacherCreateSubject__textField = new JTextField();
		teacherCreateSubject__textField.setText("");
		teacherCreateSubject__textField.setBounds(260, 239, 86, 20);
		createSubject_panel.add(teacherCreateSubject__textField);
		teacherCreateSubject__textField.setColumns(10);

		JLabel lblNewLabel_20 = new JLabel("Teacher CI");
		lblNewLabel_20.setBounds(168, 236, 67, 14);
		createSubject_panel.add(lblNewLabel_20);

		JPanel consultSubject__panel = new JPanel();
		master__panel.add(consultSubject__panel, "name_114186707320200");
		consultSubject__panel.setLayout(null);
		Menu consultSubjectt__panel = new Menu(consultSubject__panel, master__panel, master__cardLayout);

		JLabel lblNewLabel_21 = new JLabel("Consult Subject");
		lblNewLabel_21.setBounds(235, 68, 103, 14);
		consultSubject__panel.add(lblNewLabel_21);

		JLabel lblNewLabel_22 = new JLabel("ID");
		lblNewLabel_22.setBounds(153, 116, 46, 14);
		consultSubject__panel.add(lblNewLabel_22);

		JPanel infoConsultSubject__panel = new JPanel();
		infoConsultSubject__panel.setBounds(153, 167, 223, 257);
		consultSubject__panel.add(infoConsultSubject__panel);
		infoConsultSubject__panel.setLayout(null);
		infoConsultSubject__panel.show(false);

		JLabel lblNewLabel_23 = new JLabel("ID");
		lblNewLabel_23.setBounds(29, 26, 46, 14);
		infoConsultSubject__panel.add(lblNewLabel_23);

		JLabel lblNewLabel_24 = new JLabel("Name");
		lblNewLabel_24.setBounds(29, 58, 46, 14);
		infoConsultSubject__panel.add(lblNewLabel_24);

		JLabel lblNewLabel_25 = new JLabel("Orientation");
		lblNewLabel_25.setBounds(29, 93, 70, 14);
		infoConsultSubject__panel.add(lblNewLabel_25);

		JLabel lblNewLabel_26 = new JLabel("Generation");
		lblNewLabel_26.setBounds(29, 126, 70, 14);
		infoConsultSubject__panel.add(lblNewLabel_26);

		JLabel lblNewLabel_27 = new JLabel("Enrolled");
		lblNewLabel_27.setBounds(29, 158, 46, 14);
		infoConsultSubject__panel.add(lblNewLabel_27);

		textField_12 = new JTextField();
		textField_12.setBounds(109, 23, 86, 20);
		infoConsultSubject__panel.add(textField_12);
		textField_12.setColumns(10);

		textField_13 = new JTextField();
		textField_13.setBounds(109, 55, 86, 20);
		infoConsultSubject__panel.add(textField_13);
		textField_13.setColumns(10);

		textField_14 = new JTextField();
		textField_14.setBounds(109, 90, 86, 20);
		infoConsultSubject__panel.add(textField_14);
		textField_14.setColumns(10);

		textField_15 = new JTextField();
		textField_15.setBounds(109, 123, 86, 20);
		infoConsultSubject__panel.add(textField_15);
		textField_15.setColumns(10);

		textField_16 = new JTextField();
		textField_16.setBounds(109, 155, 86, 20);
		infoConsultSubject__panel.add(textField_16);
		textField_16.setColumns(10);

		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.setBounds(54, 197, 89, 23);
		infoConsultSubject__panel.add(btnNewButton_1);

		textField_11 = new JTextField();
		textField_11.setBounds(200, 113, 94, 20);
		consultSubject__panel.add(textField_11);
		textField_11.setColumns(10);

		JButton consultSearchSubject__button = new JButton("Search");
		consultSearchSubject__button.setBounds(304, 112, 89, 23);
		consultSubject__panel.add(consultSearchSubject__button);

		JPanel listSubject__panel = new JPanel();
		master__panel.add(listSubject__panel, "name_115076285776000");
		listSubject__panel.setLayout(null);
		Menu listSubjectT__panel = new Menu(listSubject__panel, master__panel, master__cardLayout);

		JLabel lblNewLabel_28 = new JLabel("List the Subjects");
		lblNewLabel_28.setBounds(220, 74, 110, 14);
		listSubject__panel.add(lblNewLabel_28);

		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null }, },
				new String[] { "ID", "NAME", "ORIENTATION", "GENERATION" }));
		table_3.setBounds(78, 150, 382, 174);
		listSubject__panel.add(table_3);

		JLabel lblNewLabel_29 = new JLabel("ID");
		lblNewLabel_29.setBounds(86, 125, 46, 14);
		listSubject__panel.add(lblNewLabel_29);

		JLabel lblNewLabel_30 = new JLabel("NAME");
		lblNewLabel_30.setBounds(204, 125, 46, 14);
		listSubject__panel.add(lblNewLabel_30);

		JLabel lblNewLabel_31 = new JLabel("ORIENTATION");
		lblNewLabel_31.setBounds(280, 125, 70, 14);
		listSubject__panel.add(lblNewLabel_31);

		JLabel lblNewLabel_32 = new JLabel("GENERATION");
		lblNewLabel_32.setBounds(378, 125, 65, 14);
		listSubject__panel.add(lblNewLabel_32);

		JPanel createAbsences__panel = new JPanel();
		master__panel.add(createAbsences__panel, "name_115660093197000");
		createAbsences__panel.setLayout(null);
		Menu createAbsencesS__panel = new Menu(createAbsences__panel, master__panel, master__cardLayout);

		JLabel lblNewLabel_33 = new JLabel("Create a Absence");
		lblNewLabel_33.setBounds(223, 70, 102, 14);
		createAbsences__panel.add(lblNewLabel_33);

		JLabel lblNewLabel_34 = new JLabel("Date");
		lblNewLabel_34.setBounds(134, 119, 46, 14);
		createAbsences__panel.add(lblNewLabel_34);

		JLabel lblNewLabel_35 = new JLabel("Type");
		lblNewLabel_35.setBounds(134, 150, 46, 14);
		createAbsences__panel.add(lblNewLabel_35);

		JLabel lblNewLabel_36 = new JLabel("Amount Hours");
		lblNewLabel_36.setBounds(134, 175, 84, 14);
		createAbsences__panel.add(lblNewLabel_36);

		JLabel lblNewLabel_37 = new JLabel("Student Ci");
		lblNewLabel_37.setBounds(134, 205, 64, 14);
		createAbsences__panel.add(lblNewLabel_37);

		JLabel lblNewLabel_38 = new JLabel("Subject ID");
		lblNewLabel_38.setBounds(134, 236, 64, 14);
		createAbsences__panel.add(lblNewLabel_38);

		textField_17 = new JTextField();
		textField_17.setBounds(239, 116, 28, 20);
		createAbsences__panel.add(textField_17);
		textField_17.setColumns(10);

		textField_19 = new JTextField();
		textField_19.setBounds(239, 172, 86, 20);
		createAbsences__panel.add(textField_19);
		textField_19.setColumns(10);

		textField_20 = new JTextField();
		textField_20.setBounds(239, 202, 86, 20);
		createAbsences__panel.add(textField_20);
		textField_20.setColumns(10);

		textField_21 = new JTextField();
		textField_21.setBounds(239, 233, 86, 20);
		createAbsences__panel.add(textField_21);
		textField_21.setColumns(10);

		JButton btnNewButton_2 = new JButton("Create");
		btnNewButton_2.setBounds(308, 279, 89, 23);
		createAbsences__panel.add(btnNewButton_2);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "JUSTIFY", "UNJUSTIFY", "LATER" }));
		comboBox.setBounds(239, 146, 86, 22);
		createAbsences__panel.add(comboBox);

		textField_18 = new JTextField();
		textField_18.setBounds(277, 116, 46, 20);
		createAbsences__panel.add(textField_18);
		textField_18.setColumns(10);

		textField_22 = new JTextField();
		textField_22.setBounds(333, 116, 64, 20);
		createAbsences__panel.add(textField_22);
		textField_22.setColumns(10);

		JPanel consultAbsences__panel = new JPanel();
		master__panel.add(consultAbsences__panel, "name_117345618880400");
		consultAbsences__panel.setLayout(null);
		Menu consultAbsencess__panel = new Menu(consultAbsences__panel, master__panel, master__cardLayout);

		JLabel lblNewLabel_39 = new JLabel("Consult Absences");
		lblNewLabel_39.setBounds(208, 62, 100, 14);
		consultAbsences__panel.add(lblNewLabel_39);

		JLabel lblNewLabel_40 = new JLabel("Fecha inicio");
		lblNewLabel_40.setBounds(115, 106, 62, 14);
		consultAbsences__panel.add(lblNewLabel_40);

		textField_23 = new JTextField();
		textField_23.setBounds(197, 103, 53, 20);
		consultAbsences__panel.add(textField_23);
		textField_23.setColumns(10);

		JButton btnNewButton_3 = new JButton("Consult");
		btnNewButton_3.setBounds(389, 156, 89, 23);
		consultAbsences__panel.add(btnNewButton_3);

		JLabel lblNewLabel_41 = new JLabel("Fecha fin");
		lblNewLabel_41.setBounds(115, 139, 46, 14);
		consultAbsences__panel.add(lblNewLabel_41);

		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(260, 103, 53, 20);
		consultAbsences__panel.add(textField_24);

		textField_25 = new JTextField();
		textField_25.setColumns(10);
		textField_25.setBounds(323, 103, 62, 20);
		consultAbsences__panel.add(textField_25);

		textField_26 = new JTextField();
		textField_26.setColumns(10);
		textField_26.setBounds(197, 136, 53, 20);
		consultAbsences__panel.add(textField_26);

		textField_27 = new JTextField();
		textField_27.setColumns(10);
		textField_27.setBounds(270, 136, 43, 20);
		consultAbsences__panel.add(textField_27);

		textField_28 = new JTextField();
		textField_28.setColumns(10);
		textField_28.setBounds(323, 136, 62, 20);
		consultAbsences__panel.add(textField_28);

		JPanel infoConsultAbsences__panel = new JPanel();
		infoConsultAbsences__panel.setBounds(70, 181, 427, 257);
		consultAbsences__panel.add(infoConsultAbsences__panel);
		infoConsultAbsences__panel.setLayout(null);
		infoConsultAbsences__panel.show(false);

		table_4 = new JTable();
		table_4.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "SUBJECT", "NAME", "DATE", "TYPE", "HOURS" }));
		table_4.setBounds(10, 43, 407, 203);
		infoConsultAbsences__panel.add(table_4);

		JLabel lblNewLabel_42 = new JLabel("MATERIA");
		lblNewLabel_42.setBounds(10, 28, 46, 14);
		infoConsultAbsences__panel.add(lblNewLabel_42);

		JLabel lblNewLabel_43 = new JLabel("NAME");
		lblNewLabel_43.setBounds(95, 28, 46, 14);
		infoConsultAbsences__panel.add(lblNewLabel_43);

		JLabel lblNewLabel_44 = new JLabel("DATE");
		lblNewLabel_44.setBounds(177, 28, 46, 14);
		infoConsultAbsences__panel.add(lblNewLabel_44);

		JLabel lblNewLabel_45 = new JLabel("TYPE");
		lblNewLabel_45.setBounds(255, 28, 46, 14);
		infoConsultAbsences__panel.add(lblNewLabel_45);

		JLabel lblNewLabel_46 = new JLabel("HOURS");
		lblNewLabel_46.setBounds(337, 28, 46, 14);
		infoConsultAbsences__panel.add(lblNewLabel_46);

		JPanel listAbsences__panel = new JPanel();
		master__panel.add(listAbsences__panel, "name_118124424073500");
		listAbsences__panel.setLayout(null);
		Menu listAbsencess__panel = new Menu(listAbsences__panel, master__panel, master__cardLayout);

		JLabel lblNewLabel_47 = new JLabel("List Absences");
		lblNewLabel_47.setBounds(219, 51, 154, 14);
		listAbsences__panel.add(lblNewLabel_47);

		JLabel lblNewLabel_48 = new JLabel("Orientation");
		lblNewLabel_48.setBounds(130, 96, 75, 14);
		listAbsences__panel.add(lblNewLabel_48);

		JLabel lblNewLabel_49 = new JLabel("Generation");
		lblNewLabel_49.setBounds(130, 132, 75, 14);
		listAbsences__panel.add(lblNewLabel_49);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "ADM", "TIC" }));
		comboBox_1.setBounds(215, 92, 85, 22);
		listAbsences__panel.add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "FIRST", "SECOND", "THIRD" }));
		comboBox_2.setBounds(215, 132, 85, 22);
		listAbsences__panel.add(comboBox_2);

		JButton btnNewButton_4 = new JButton("List");
		btnNewButton_4.setBounds(321, 111, 89, 23);
		listAbsences__panel.add(btnNewButton_4);

		JPanel infoListAbsences__panel = new JPanel();
		infoListAbsences__panel.setBounds(66, 169, 412, 241);
		listAbsences__panel.add(infoListAbsences__panel);
		infoListAbsences__panel.setLayout(null);
		infoListAbsences__panel.show(false);

		table_5 = new JTable();
		table_5.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "IDABSENCE", "ID STUDENT", "ID SUBJECT", "GENERATION", "ORIENTATION" }));
		table_5.setBounds(10, 58, 392, 172);
		infoListAbsences__panel.add(table_5);

		JLabel lblNewLabel_50 = new JLabel("ID ABSENCE");
		lblNewLabel_50.setBounds(22, 33, 59, 14);
		infoListAbsences__panel.add(lblNewLabel_50);

		JLabel lblNewLabel_51 = new JLabel("CI STUDENT");
		lblNewLabel_51.setBounds(91, 33, 70, 14);
		infoListAbsences__panel.add(lblNewLabel_51);

		JLabel lblNewLabel_52 = new JLabel("ID SUBJECT");
		lblNewLabel_52.setBounds(171, 33, 74, 14);
		infoListAbsences__panel.add(lblNewLabel_52);

		JLabel lblNewLabel_53 = new JLabel("GENERATION");
		lblNewLabel_53.setBounds(242, 33, 86, 14);
		infoListAbsences__panel.add(lblNewLabel_53);

		JLabel lblNewLabel_54 = new JLabel("ORIENTATION");
		lblNewLabel_54.setBounds(325, 33, 77, 14);
		infoListAbsences__panel.add(lblNewLabel_54);

		JPanel createExam__panel = new JPanel();
		master__panel.add(createExam__panel, "name_120052289757000");
		createExam__panel.setLayout(null);
		Menu createExamm__panel = new Menu(createExam__panel, master__panel, master__cardLayout);

		JLabel lblNewLabel_55 = new JLabel("Create Exam");
		lblNewLabel_55.setBounds(215, 61, 110, 14);
		createExam__panel.add(lblNewLabel_55);

		JLabel lblNewLabel_56 = new JLabel("Ci Student");
		lblNewLabel_56.setBounds(153, 113, 46, 14);
		createExam__panel.add(lblNewLabel_56);

		JLabel lblNewLabel_57 = new JLabel("Date");
		lblNewLabel_57.setBounds(153, 150, 46, 14);
		createExam__panel.add(lblNewLabel_57);

		JLabel lblNewLabel_58 = new JLabel("Note");
		lblNewLabel_58.setBounds(153, 193, 46, 14);
		createExam__panel.add(lblNewLabel_58);

		JLabel lblNewLabel_59 = new JLabel("Subject");
		lblNewLabel_59.setBounds(153, 230, 46, 14);
		createExam__panel.add(lblNewLabel_59);

		textField_29 = new JTextField();
		textField_29.setBounds(235, 227, 86, 20);
		createExam__panel.add(textField_29);
		textField_29.setColumns(10);

		textField_30 = new JTextField();
		textField_30.setBounds(235, 190, 86, 20);
		createExam__panel.add(textField_30);
		textField_30.setColumns(10);

		textField_31 = new JTextField();
		textField_31.setBounds(235, 147, 38, 20);
		createExam__panel.add(textField_31);
		textField_31.setColumns(10);

		textField_32 = new JTextField();
		textField_32.setBounds(235, 110, 86, 20);
		createExam__panel.add(textField_32);
		textField_32.setColumns(10);

		textField_33 = new JTextField();
		textField_33.setColumns(10);
		textField_33.setBounds(283, 147, 52, 20);
		createExam__panel.add(textField_33);

		textField_34 = new JTextField();
		textField_34.setColumns(10);
		textField_34.setBounds(345, 147, 52, 20);
		createExam__panel.add(textField_34);

		submitCreateStudent__button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ciStudent = Integer.parseInt(ciCreateStudent__textField.getText());
				String nameStudent = nameCreateStudent__textField.getText();
				String lastNameStudent = lastNameCreateStudent__textField.getText();
				String mailCreateStudent = mailCreateStudent__textField.getText();
				String passwordStudent = passwordCreateStudent__textField.getText();
				String generationStudent = generationCreateStudent__comboBox.getSelectedItem().toString();
				String orientationStudent = orientationCreateStudent__comboBox.getSelectedItem().toString();
				int day = Integer.parseInt(dayStudent__textField.getText());
				int month = Integer.parseInt(monthStudent__textField.getText());
				int year = Integer.parseInt(yearStudent__textField.getText());

				Student student = new Student(ciStudent, nameStudent, lastNameStudent,
						Orientation.valueOf(orientationStudent), Status.ACTIVE, Generation.valueOf(generationStudent),
						mailCreateStudent, passwordStudent, LocalDate.of(year, month, day));

				try {
					controller.createUser(student);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton btnNewButton_5 = new JButton("Create");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_5.setBounds(321, 275, 89, 23);
		createExam__panel.add(btnNewButton_5);

		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				infoListAbsences__panel.show(true);
			}
		});

		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				infoConsultAbsences__panel.show(true);
			}
		});

		consultSearchSubject__button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				infoConsultSubject__panel.show(true);
			}
		});

		listFunctionary__rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listStudent__rdbtnNewRadioButton.setSelected(false);
				listTeacher__rdbtnNewRadioButton_1.setSelected(false);

				listOfFunctionary__panel.show(true);
				listOfStudent__panel.show(false);
				listOfTeacher__panel.show(false);

				String[] infoListFunctionary = { "CI", "NAME", "LASTNAME", "PASSWORD", "MAIL" };
				try {
					List<Functionary> functionary = controller.functionariesList();

					String[][] functionaryTemp = new String[functionary.size()][5];
					for (int i = 0; i < functionary.size(); i++) {
						functionaryTemp[i][0] = functionary.get(i).getCi() + "";
						functionaryTemp[i][1] = functionary.get(i).getName();
						functionaryTemp[i][2] = functionary.get(i).getLastName();
						functionaryTemp[i][3] = functionary.get(i).getMail();
						functionaryTemp[i][4] = functionary.get(i).getPassword();

					}
					functionaryList__table.setModel(new DefaultTableModel(functionaryTemp, infoListFunctionary));

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		listTeacher__rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listFunctionary__rdbtnNewRadioButton_2.setSelected(false);
				listStudent__rdbtnNewRadioButton.setSelected(false);

				listOfTeacher__panel.show(true);
				listOfFunctionary__panel.show(false);
				listOfStudent__panel.show(false);

				String[] infoListTeacher = { "CI", "NAME", "LASTNAME", "MAIL", "PASSWORD" };

				try {
					List<Teacher> teachers = controller.teachersList();
					String[][] teacherTemp = new String[teachers.size()][5];

					for (int i = 0; i < teachers.size(); i++) {
						teacherTemp[i][0] = teachers.get(i).getCi() + "";
						teacherTemp[i][1] = teachers.get(i).getName();
						teacherTemp[i][2] = teachers.get(i).getLastName();
						teacherTemp[i][3] = teachers.get(i).getMail();
						teacherTemp[i][4] = teachers.get(i).getPassword();

					}
					listTeacher__table.setModel(new DefaultTableModel(teacherTemp, infoListTeacher));

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		listStudent__rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listFunctionary__rdbtnNewRadioButton_2.setSelected(false);
				listTeacher__rdbtnNewRadioButton_1.setSelected(false);
				listOfStudent__panel.show(true);
				listOfTeacher__panel.show(false);
				listOfFunctionary__panel.show(false);

				String[] infoList = { "CI", "NAME", "LASTNAME", "ORIENTATION", "GENERATION" };
				try {

					List<Student> students = controller.studentsList();
					String[][] studentsTemp = new String[students.size()][5];
					for (int i = 0; i < students.size(); i++) {
						studentsTemp[i][0] = students.get(i).getCi() + "";
						studentsTemp[i][1] = students.get(i).getName();
						studentsTemp[i][2] = students.get(i).getLastName();
						studentsTemp[i][3] = students.get(i).getOrientation() + "";
						studentsTemp[i][4] = students.get(i).getGeneration() + "";
					}
					StudentList__table.setModel(new DefaultTableModel(studentsTemp, infoList));
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

		submitCreateTeacher__button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int ciTeacher = Integer.parseInt(ciCreateTeacher__textField.getText());
				String nameTeacher = nameCreateTeacher__textField.getText();
				String lastNameTeacher = lastNameCreateTeacher__textField.getText();
				String mailTeacher = mailCreateTeacher__textField.getText();
				String psswrdTeacher = passwordCreateTeacher__textField.getText();
				int yearDateTeacher = Integer.parseInt(dateYearCreateTeacher__textField.getText());
				int monthDateTeacher = Integer.parseInt(dateMonthCreateTeacher__textField.getText());
				int dayDateTeacher = Integer.parseInt(dateDayCreateTeacher__textField.getText());

				Teacher teacher = new Teacher(ciTeacher, nameTeacher, lastNameTeacher, mailTeacher, psswrdTeacher,
						LocalDate.of(yearDateTeacher, monthDateTeacher, monthDateTeacher));

				try {
					controller.createUser(teacher);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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

				try {

					int ci = Integer.parseInt(ciLogin__textField.getText());
					String password = passwordLogin__textField.getText();

					try {

						controller.login(ci, password);

					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, " The User is not found as a Functionary, Try Again ! ");

					}

					if (controller.getUserLoggedIn() != null) {
						master__cardLayout.show(master__panel, "WELCOME_PANEL");
					}

				} catch (NumberFormatException exc) {
					JOptionPane.showMessageDialog(null, " You may writed somethign wrong, Check it ! ");

				}

			}
		});

		submitCreateSubject__button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String code = codeCreateSubject__textField.getText();
				String name = nameCreateSubject__textField.getText();
				String orientation = orientationCreateSubject__textField.getText();
				String generation = generationCreateSubject__textField.getText();
				int teacherCI = Integer.valueOf(teacherCreateSubject__textField.getText());

				try {

					Subject subject = new Subject(code, name, Orientation.valueOf(orientation),
							Generation.valueOf(generation), new Teacher(teacherCI));

					controller.createSubject(subject);

				} catch (Exception ex) {

					JOptionPane.showMessageDialog(null, ex.getMessage());

				}

			}
		});

		searchConsultUser__btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int ciConsult = Integer.parseInt(searchCiConsultUser__textField.getText());

				try {
					try {
						User userConsult = controller.consultUsers(ciConsult);

						if (userConsult != null) {
							editConsult__panel.show(true);
							infoUser__panel.show(true);
							nameConsultUser__textField.setText(userConsult.getName());
							lastNameConsultUser__textField.setText(userConsult.getLastName());
							emailConsultUser__textField.setText(userConsult.getMail());
							passwordConsultUser__textField.setText(userConsult.getPassword());
							ciConsultUser__textField__textField.setText(userConsult.getCi() + "");
							dateYearConsultUser__textField.setText(userConsult.getDateBirth().getYear() + "");
							dateMonthConsultUser__textField.setText(userConsult.getDateBirth().getMonthValue() + "");
							dateDayConsultUser__textField.setText(userConsult.getDateBirth().getDayOfMonth() + "");
						} else if (userConsult == null) {
							JOptionPane.showMessageDialog(null, "The USER doesnt exit !");
						}
						if (userConsult instanceof Student) {

							addSubjectStudent__panel.show(true);

						}
					} catch (NumberFormatException e) {
						// add a JoptionPane that says "You write someting wrong, Try Again !"
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Something went Wrong!");

				}
			}

			/*
			 * try { User user = db.recoverUser(ciConsult);
			 * 
			 * if (user instanceof Student) { addSubjectStudent__panel.show(true);
			 * addSubjectConsultUser__btnNewButton.show(true); } else { if (user instanceof
			 * Teacher) {
			 * 
			 * } else { JOptionPane.showMessageDialog(null,
			 * "Something went Wrong !, try again.");
			 * 
			 * } } } catch (Exception e) { e.printStackTrace(); }
			 */

		});

		updateConsult__btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int ciConsult = Integer.parseInt(searchCiConsultUser__textField.getText());

				String name = nameConsultUser__textField.getText();
				String lastName = lastNameConsultUser__textField.getText();
				String email = emailConsultUser__textField.getText();
				String psswrd = passwordConsultUser__textField.getText();
				int ci = Integer.parseInt(ciConsultUser__textField__textField.getText());
				int year = Integer.parseInt(dateYearConsultUser__textField.getText());
				int month = Integer.parseInt(dateMonthConsultUser__textField.getText());
				int day = Integer.parseInt(dateDayConsultUser__textField.getText());

				try {

					User user = controller.consultUsers(ciConsult);

					if (user instanceof Student) {

						Student student = new Student(ci, name, lastName, ((Student) user).getOrientation(),
								((Student) user).getStatus(), ((Student) user).getGeneration(), email, psswrd,
								LocalDate.of(year, month, day));

						controller.userUpdate(ciConsult, student);

					} else if (user instanceof Teacher) {

						Teacher teacher = new Teacher(ci, name, lastName, email, psswrd,
								LocalDate.of(year, month, day));

						controller.userUpdate(ciConsult, teacher);
					} else if (user instanceof Functionary) {

						Functionary functionary = new Functionary(ci, name, lastName, email, psswrd,
								LocalDate.of(year, month, day));

						controller.userUpdate(ciConsult, functionary);
					} else {
						throw new Exception();
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}
}
