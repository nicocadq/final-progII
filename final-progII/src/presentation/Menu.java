package presentation;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import logic.ControllerLogic;
import logic.User;

public class Menu {
	public Menu(JPanel panel, JPanel master__panel, CardLayout master__cardLayout) {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 7000, 22);
		panel.add(menuBar, BorderLayout.NORTH);

		JMenu menu_User = new JMenu("Users");
		JMenu menu_Subject = new JMenu("Subject");
		JMenu menu_Absence = new JMenu("Absence");
		JMenu menu_Exam = new JMenu("Exam");
		JMenu menu_Exit = new JMenu("Exit");

		menuBar.add(menu_User);
		menuBar.add(menu_Subject);
		menuBar.add(menu_Absence);
		menuBar.add(menu_Exam);
		menuBar.add(menu_Exit);

		JMenuItem exit__menuItem = new JMenuItem("Menu");
		menu_Exit.add(exit__menuItem);

		/* Sub Menu of the JMenu Users */
		JMenuItem createUser__menuItem = new JMenuItem("Create New User");
		menu_User.add(createUser__menuItem);

		JMenuItem consultUsers_menuItem = new JMenuItem("Consult Users");
		menu_User.add(consultUsers_menuItem);

		JMenuItem listUsers_menuItem = new JMenuItem("List Users");
		menu_User.add(listUsers_menuItem);
		
		JMenuItem listPendings_menuItem =  new JMenuItem("List Students with Pendings");
		menu_User.add(listPendings_menuItem);
		

		/* Sub Menu of the JMenu Subject */

		JMenuItem createSubject_menuItem = new JMenuItem("Create Subject");
		menu_Subject.add(createSubject_menuItem);
		JMenuItem consultSubject__menuItem = new JMenuItem("Consult Subjects");
		menu_Subject.add(consultSubject__menuItem);

		JMenuItem listSubject_menuItem = new JMenuItem("List Subjects");
		menu_Subject.add(listSubject_menuItem);

		/* Sub Menu of the JMenu Exams */
		JMenuItem createExan_menuItem = new JMenuItem("Create Exam");
		menu_Exam.add(createExan_menuItem);

		/* Sub Menu of the JMenu Absences */
		JMenuItem createAbsence_menuItem = new JMenuItem("Create Absences");
		menu_Absence.add(createAbsence_menuItem);

		JMenuItem consultAbsence_menuItem = new JMenuItem("Consult Absences");
		menu_Absence.add(consultAbsence_menuItem);

		JMenuItem listAbsence_menuItem = new JMenuItem("List Absences");
		menu_Absence.add(listAbsence_menuItem);
		
		JMenuItem stadisticsReport_menuItem = new JMenuItem("Stadistics Report");
		menu_Absence.add(stadisticsReport_menuItem);

		ControllerLogic c = new ControllerLogic();

		exit__menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				master__cardLayout.show(master__panel, "WELCOME_PANEL");
			}

		});

		createUser__menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				master__cardLayout.show(master__panel, "CREATE_USER_PANEL");
			}
		});

		consultUsers_menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				master__cardLayout.show(master__panel, "name_6070420451057");

			}
		});
		listUsers_menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				master__cardLayout.show(master__panel, "name_110770879092900");

			}
		});

		listUsers_menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				master__cardLayout.show(master__panel, "name_110770879092900");

			}
		});
		createSubject_menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				master__cardLayout.show(master__panel, "name_113009623994000");

			}
		});
		consultSubject__menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				master__cardLayout.show(master__panel, "name_114186707320200");

			}
		});
		listSubject_menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				master__cardLayout.show(master__panel, "name_115076285776000");

			}
		});
		createAbsence_menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				master__cardLayout.show(master__panel, "name_115660093197000");

			}
		});
		consultAbsence_menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				master__cardLayout.show(master__panel, "name_117345618880400");

			}
		});
		listAbsence_menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				master__cardLayout.show(master__panel, "name_118124424073500");

			}
		});

		createExan_menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				master__cardLayout.show(master__panel, "name_120052289757000");
			}
		});
		
		listPendings_menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				master__cardLayout.show(master__panel, "LIST_STUDENTS_PENDINGS");
			}
		});
		
		stadisticsReport_menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				master__cardLayout.show(master__panel, "STADISTICS_REPORT_PANEL");
			}
		});
	}
}