package presentation;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Menu {
	public Menu(JPanel panel, JPanel master__panel, CardLayout master__cardLayout) {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 230, 22);
		panel.add(menuBar, BorderLayout.NORTH);

		JMenu menu_User = new JMenu("Users");
		JMenu menu_Subject = new JMenu("Subject");
		JMenu menu_Absence = new JMenu("Absence");
		JMenu menu_Exam = new JMenu("Exam");
		JMenu menu_Exit = new JMenu("Exit");
		JMenu menu_Space = new JMenu("                                                                               ");
		JMenu menu_LogOut = new JMenu("Log Out");

		menuBar.add(menu_User);
		menuBar.add(menu_Subject);
		menuBar.add(menu_Absence);
		menuBar.add(menu_Exam);
		menuBar.add(menu_Exit);
		menuBar.add(menu_Space);
		menuBar.add(menu_LogOut);

		/*Sub Menu of the JMenu Users*/
		JMenuItem createUser__menuItem = new JMenuItem("Create New User");
		menu_User.add(createUser__menuItem);
		
		JMenuItem consultUsers_menuItem = new JMenuItem("Consult Users");
		menu_User.add(consultUsers_menuItem);
		
		JMenuItem listUsers_menuItem = new JMenuItem("List Users");
		menu_User.add(listUsers_menuItem);
		
		/*Sub Menu of the JMenu Subject*/
		JMenuItem consultSubject__menuItem = new JMenuItem("Consult Subjects");
		menu_Subject.add(consultSubject__menuItem);
		
		JMenuItem consultSubject_menuItem = new JMenuItem("List Subjects");
		menu_Subject.add(consultSubject_menuItem);
		
		JMenuItem deleteSubject_menuItem = new JMenuItem("Create Subject");
		menu_Subject.add(deleteSubject_menuItem);

		
		
		createUser__menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				master__cardLayout.show(master__panel, "CREATE_USER_PANEL");
				
			}
		});
	}
}