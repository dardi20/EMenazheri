package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import data.DataHandler;

public class CreateUserWindow extends Window {
	private static final long serialVersionUID = 1959557355173087811L ;
	
	CreateUserWindow() {
		JPanel dataJPanel = new JPanel();

		dataJPanel.setBackground(Color.WHITE);

		dataJPanel.setLayout(new GridLayout(0, 2, 10, 10));

		JLabel usernameLabel = new JLabel("PERDORUESI", SwingConstants.LEFT),
				passwordLabel = new JLabel("FJALKALIMI", SwingConstants.LEFT);

		JTextField usernameTextField = new JTextField();
		JPasswordField passwordField = new JPasswordField();

		dataJPanel.add(usernameLabel);
		dataJPanel.add(usernameTextField);
		dataJPanel.add(passwordLabel);
		dataJPanel.add(passwordField);

		dataJPanel.setBorder(new LineBorder(Color.WHITE, 20));

		dataJPanel.add(new JLabel());

		JButton createUserButton = new JButton("Krijo Perdorues");

		createUserButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameTextField.getText();
				String password = Util.charArrayToString(passwordField.getPassword());
				try {

					if (DataHandler.CreateUser(username, password)) {
						JOptionPane.showMessageDialog(null, "Perdoruesi u krijua!", "Sukses",
								JOptionPane.INFORMATION_MESSAGE);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "Te dhena te gabuara! Provoni serish!", "Gabim",
								JOptionPane.WARNING_MESSAGE);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Dicka shkoi keq ketu");
				}
			}

		});

		dataJPanel.add(createUserButton);
		dataJPanel.add(createUserButton);

		add(dataJPanel);

		setMinimumSize(new Dimension(300, 25));
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		revalidate();
		setVisible(true);

	}

	public static void main(String[] args) {

		new CreateUserWindow();
	}

}
