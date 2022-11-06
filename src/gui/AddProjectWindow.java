package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import core.Project;
import data.DataHandler;

public class AddProjectWindow extends Window {
	/**
	 * @author Dardi
	 **/
	private static final long serialVersionUID = -1271486286898845673L;

	public AddProjectWindow() {

		JPanel dataPanel = new JPanel();
		JPanel buttonPanel = new JPanel();

		JLabel idLabel = new JLabel("     Id");
		JTextField idTextField = new JTextField();
		JLabel titleLabel = new JLabel("     Title");
		JTextField titleTextField = new JTextField();
		JLabel descLabel = new JLabel("     Description");
		JTextField descTextField = new JTextField();
		JLabel startDateLabel = new JLabel("     Start date");
		JTextField startDateTextField = new JTextField();
		JLabel endDateLabel = new JLabel("     End date");
		JTextField endDateTextField = new JTextField();
		JLabel tasksLabel = new JLabel("     Task Desc");
		JTextField taskTextField = new JTextField();
		JLabel assignmentLabel = new JLabel("     Task Assignment");
		JTextField assignmentField = new JTextField();
		JLabel statusLabel = new JLabel("     Task Status");
		JTextField statusField = new JTextField();
		setMinimumSize(new Dimension(400, 400));
		pack();
		setLocationRelativeTo(null);

		dataPanel.setLayout(new GridLayout(7, 2));
		add(dataPanel, BorderLayout.CENTER);
//		dataPanel.add(idLabel);
//		dataPanel.add(idTextField);
		dataPanel.add(titleLabel);
		dataPanel.add(titleTextField);
		dataPanel.add(descLabel);
		dataPanel.add(descTextField);
		dataPanel.add(startDateLabel);
		dataPanel.add(startDateTextField);
		dataPanel.add(endDateLabel);
		dataPanel.add(endDateTextField);
		dataPanel.add(tasksLabel);
		dataPanel.add(taskTextField);
		dataPanel.add(statusLabel);
		dataPanel.add(statusField);
		dataPanel.add(assignmentLabel);
		dataPanel.add(assignmentField);

//		dataPanel.setBackground(Color.WHITE);
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

				String title = titleTextField.getText();
				String description = descTextField.getText();
				String startDate = startDateTextField.getText();
				String endDate = endDateTextField.getText();
				String tasksDesc = taskTextField.getText();
				String taskAssignment = assignmentField.getText();
				String taskStatus = statusField.getText();
				try {
					DataHandler.addProject(title, description, startDate, endDate, tasksDesc, taskAssignment,
							taskStatus);
					JOptionPane.showMessageDialog(null, "Projekti u shtua!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
					setVisible(false);

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Projekti nuk mund te shtohet!", "Gabim",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

	}

	public static void main(String[] args) {
		new AddProjectWindow();
	}

}
