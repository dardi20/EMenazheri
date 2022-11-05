package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import core.IssueStatus;
import core.Task;
import data.DataHandler;

public class AddTaskWindow extends Window {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1926933241089134434L;

	public AddTaskWindow(int id) throws HeadlessException {

		JPanel dataPanel = new JPanel();
		JPanel buttonPanel = new JPanel();

		JLabel descLabel = new JLabel("     Description");
		JTextField descTextArea = new JTextField();
		JLabel startDateLabel = new JLabel("     Start date");
		JTextField startDateTextField = new JTextField();
		JLabel endDateLabel = new JLabel("     End date");
		JTextField endDateTextField = new JTextField();
		JLabel assignmentLabel = new JLabel("     Task Assignment");
		JTextField assignmentField = new JTextField();
		JLabel statusLabel = new JLabel("     Task Status");
		JTextField statusField = new JTextField();
		
		setMinimumSize(new Dimension(300, 200));
		pack();
		setLocationRelativeTo(null);

		dataPanel.setLayout(new GridLayout(5, 2));
		add(dataPanel, BorderLayout.CENTER);
		dataPanel.add(descLabel);
		dataPanel.add(descTextArea);
		dataPanel.add(statusLabel);
		dataPanel.add(statusField);
		dataPanel.add(assignmentLabel);
		dataPanel.add(assignmentField);

		buttonPanel.setBackground(Color.GRAY);
		JButton saveButton = new JButton("RUAJ");
		buttonPanel.add(saveButton);
		JButton cancelButton = new JButton("ANULLO");
		buttonPanel.add(cancelButton);
		add(buttonPanel, BorderLayout.SOUTH);

		setVisible(true);

		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String description = descTextArea.getText();
				String statusAsString = statusField.getText();
				String assignment = assignmentField.getText();
				IssueStatus status = DataHandler.generateStatus(statusAsString);
				ArrayList<String> employees = new ArrayList<String>();
				employees.add(assignment);
				Task task = new Task(description, status, assignment);
				DataHandler.addTask(task, id);
			}
		});

	}

	public static void main(String[] args) {
		int id = 0;
		new AddTaskWindow(id);
	}

}
