package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import core.Project;
import core.Task;
import data.DataHandler;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.border.LineBorder;
/**
 *@author Dardi 
 **/
public class MainWindow extends Window {

	private static final long serialVersionUID = -5624410836303646449L;

	private int projectId = 0;
	private int taskId = 0;
	private JMenuBar menubar = new JMenuBar();

	private JMenu menuMenu = new JMenu("Menu");
	private JMenu usersMenu = new JMenu("Perdorues");
	private JMenu projectsMenu = new JMenu("Projekte");
	private JMenu helpMenu = new JMenu("Ndihme");

	private JMenuItem addNewUserMenuItem = new JMenuItem("Shto");
	private JMenuItem listUsersMenuItem = new JMenuItem("Listo");
	private JMenuItem changePasswordMenuItem = new JMenuItem("Ndrysho fjalekalimin");
	private JMenuItem logOutMenuItem = new JMenuItem("Dil nga llogaria");
	private JMenuItem exitMenuItem = new JMenuItem("Mbylle programin");

	private JMenuItem addNewProjectMenuItem = new JMenuItem("Shto");
	private JMenuItem listProjectsMenuItem = new JMenuItem("Listo");

	private JMenuItem howToUseMenuItem = new JMenuItem("Si perdoret");
	private JMenuItem contactMenuItem = new JMenuItem("Kontakto");

	public MainWindow() {

		getContentPane().setLayout(new GridLayout(2, 1, 0, 0));

		JPanel projectListPanel = new JPanel(new BorderLayout(50, 50));
		projectListPanel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.LIGHT_GRAY));
		JPanel detailPanel = new JPanel(new GridLayout(1, 2));
		detailPanel.setBorder(UIManager.getBorder("ScrollPane.border"));

		JPanel projectDetailPanel = new JPanel(new GridLayout(6, 2));
		projectDetailPanel.setBorder(new MatteBorder(1, 1, 3, 1, (Color) new Color(128, 128, 128)));

		JPanel taskDetailPanel = new JPanel(new BorderLayout());
		taskDetailPanel.setBorder(new MatteBorder(1, 1, 3, 1, (Color) new Color(128, 128, 128)));
		JPanel taskDetailListPanel = new JPanel();
		JPanel taskDetailButtonPanel = new JPanel();

		JLabel projectDescriptionLabel = new JLabel("Project Details");
		projectDescriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		projectDescriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel projectTitleLabel = new JLabel("Titulli");
		projectTitleLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		projectTitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel taskDescriptionLabel = new JLabel("Task Description");
		taskDescriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		taskDescriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel taskStatusLabel = new JLabel("Status");
		taskStatusLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		taskStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel taskAssignmentLabel = new JLabel("Task Owner");
		taskAssignmentLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		taskAssignmentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		JTextField projectTitleField = new JTextField();
		JTextField taskDescriptionField = new JTextField();
		JTextField taskStatusField = new JTextField();
		JTextField taskAssignmentField = new JTextField();
		JButton editProjectButton = new JButton("Edit");
		JButton deleteProjectButton = new JButton("Delete");

		JButton addTaskButton = new JButton("Add Task");
		JButton deleteTaskButton = new JButton("Delete Task");

		DefaultListModel<Project> projectListString = new DefaultListModel<Project>();
		JList<Project> projectList = new JList<Project>(projectListString);
		projectListPanel.add(projectList);
		JScrollPane projectScrollPane = new JScrollPane(projectList);
		projectScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		projectListPanel.add(projectScrollPane);

		DefaultListModel<Task> taskListString = new DefaultListModel<Task>();
		taskDetailListPanel.setLayout(new BorderLayout(0, 0));
		JList<Task> taskList = new JList<Task>(taskListString);
		taskDetailListPanel.add(taskList, BorderLayout.CENTER);
		JScrollPane taskScrollPane = new JScrollPane(taskList);
		taskScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		taskDetailListPanel.add(taskScrollPane);
		taskDetailButtonPanel.setLayout(new GridLayout(1, 2, 0, 0));

		taskDetailButtonPanel.add(addTaskButton);
		taskDetailButtonPanel.add(deleteTaskButton);

		taskDetailPanel.add(taskDetailListPanel, BorderLayout.CENTER);
		taskDetailPanel.add(taskDetailButtonPanel, BorderLayout.SOUTH);

		detailPanel.add(projectDetailPanel);
		detailPanel.add(taskDetailPanel);

		detailPanel.setVisible(true);
		projectList.setVisible(true);
		projectListPanel.setVisible(true);

		projectDetailPanel.add(projectDescriptionLabel);
		projectDetailPanel.add(new JLabel());
		projectDetailPanel.add(projectTitleLabel);
		projectDetailPanel.add(projectTitleField);
		projectDetailPanel.add(taskDescriptionLabel);
		projectDetailPanel.add(taskDescriptionField);
		projectDetailPanel.add(taskStatusLabel);
		projectDetailPanel.add(taskStatusField);
		projectDetailPanel.add(taskAssignmentLabel);
		projectDetailPanel.add(taskAssignmentField);
		projectDetailPanel.add(editProjectButton);
		projectDetailPanel.add(deleteProjectButton);

		getContentPane().add(projectListPanel);
		getContentPane().add(detailPanel);

		setJMenuBar(menubar);

		menubar.add(menuMenu);
		menubar.add(projectsMenu);
		menubar.add(helpMenu);

		menuMenu.add(usersMenu);

		usersMenu.add(addNewUserMenuItem);
		usersMenu.add(listUsersMenuItem);

		menuMenu.add(changePasswordMenuItem);
		menuMenu.add(logOutMenuItem);
		menuMenu.add(exitMenuItem);

		projectsMenu.add(addNewProjectMenuItem);
		projectsMenu.add(listProjectsMenuItem);

		helpMenu.add(howToUseMenuItem);
		helpMenu.add(contactMenuItem);

		pack();
		revalidate();
		setVisible(true);
		setDefaultCloseOperation(Window.EXIT_ON_CLOSE);

		addNewUserMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateUserWindow();

			}
		});

		changePasswordMenuItem.addActionListener((e) -> {
			new ChangePasswordWindow();
			// String code = Util.generatedCode();
			// sendEmail();
		});
		contactMenuItem.addActionListener((e) -> {
			JOptionPane.showMessageDialog(null, "Kontaktoni ne emailin dardi259@gmail.com", "Informacion",
					JOptionPane.INFORMATION_MESSAGE);
		});

		addNewProjectMenuItem.addActionListener((e) -> {
			new AddProjectWindow();
		});

		listProjectsMenuItem.addActionListener((e) -> {
			ArrayList<Project> projectListData = DataHandler.listProject();
			if (projectListData.size() != projectListString.size()) {
				projectListString.clear();
				for (Project project : projectListData) {
					projectListString.addElement(project);

				}
			}

		});
		logOutMenuItem.addActionListener((e) -> {
			new LogInWindow();
			setVisible(false);
		});
		exitMenuItem.addActionListener((e) -> {
			System.exit(1);
		});
		howToUseMenuItem.addActionListener((e) -> {
			JOptionPane.showMessageDialog(null, "Ky funskionalitet nuk eshte akoma gati", "Informacion",
					JOptionPane.INFORMATION_MESSAGE);
		});
		projectList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {

				JList list = (JList) evt.getSource();
				Project selectedProject = (Project) list.getSelectedValue();
				if (selectedProject != null) {
					projectId = selectedProject.getId();
					projectTitleField.setText(selectedProject.getTitle());

					selectedProject.setTasks(DataHandler.getSelectedTasks(projectId));
					if (selectedProject.getTasks().get(0) != null) {
						Task defaultTask = selectedProject.getTasks().get(0);
						taskAssignmentField.setText(defaultTask.getAssignedEmployees());
						taskDescriptionField.setText(defaultTask.getDescription());
						taskStatusField.setText(defaultTask.getStatus().toString());
					}
					taskListString.clear();
					/*
					 * per te mare listen e task nga databaza per projektin e klikuar. ArrayList
					 * <Task> taskList = DataHandler.getTasks(id);
					 */

					for (Task task : selectedProject.getTasks()) {
						taskListString.addElement(task);
					}
					revalidate();
				}
			}
		});

		taskList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {

				JList list = (JList) evt.getSource();
				Task selectedTask = (Task) list.getSelectedValue();
				if (selectedTask != null) {
					taskId = selectedTask.getId();
					taskAssignmentField.setText(selectedTask.getAssignedEmployees());
					taskDescriptionField.setText(selectedTask.getDescription());
					taskStatusField.setText(selectedTask.getStatus().toString());
				}
			}
		});

		addTaskButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AddTaskWindow(projectId);
			}
		});
		deleteTaskButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DataHandler.deleteTask(taskId);
			}
		});

		deleteProjectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				 DataHandler.deleteProject(id);
			}
		});

	}

	public static void main(String[] args) {
		new MainWindow();
	}

}
