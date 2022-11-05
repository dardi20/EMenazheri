package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author Dardi
 *
 */
public class ListProjectWindow extends Window {

	private static final long serialVersionUID = -7956872961186884542L;

	JMenuBar menuBar = new JMenuBar();

	private JMenu menuMenu = new JMenu("Menu");
	private JMenu addProjectMenu = new JMenu("Shto Projekt");
	private JMenu listProjectMenu = new JMenu("Listo");
	private JMenuItem listProjectsMenuItem = new JMenuItem("Listo");

	public ListProjectWindow() {

		setJMenuBar(menuBar);

		menuBar.add(listProjectsMenuItem);

		listProjectsMenuItem.addActionListener((e) -> {
			System.out.println("test");
		});

		revalidate();
		setVisible(true);

	}

	public static void main(String[] args) {

		new ListProjectWindow();

	}

}
