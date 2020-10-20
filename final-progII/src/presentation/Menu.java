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

		JMenu menu = new JMenu("Menu");
		menuBar.add(menu);

		JMenuItem createUser__menuItem = new JMenuItem("Create New User");
		menu.add(createUser__menuItem);

		createUser__menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				master__cardLayout.show(master__panel, "CREATE_USER_PANEL");
			}
		});
	}
}