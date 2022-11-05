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

/**
 * @author Dardi
 **/
public class LogInWindow extends Window {

	private static final long serialVersionUID = -8578532639776864028L;

	public LogInWindow() {

		JPanel logoJPanel = new JPanel(), dataJPanel = new JPanel();

		logoJPanel.setBackground(new Color(200, 0, 50));
		dataJPanel.setBackground(Color.WHITE);

		logoJPanel.setLayout(new BorderLayout());
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

		JButton logInButton = new JButton("HYR");

		logInButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = usernameTextField.getText();
				String password = Util.charArrayToString(passwordField.getPassword());
				try {
					// User user = DBHandler.db.getUser(username, password);
//						FileHandler.loggedInUser = FileHandler.getValidUser(username, password);									

					if (DataHandler.authUser(username, password)) {
						new MainWindow();
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

		dataJPanel.add(logInButton);
		dataJPanel.add(logInButton);

		JLabel logoLabel = new JLabel(new ImageIcon("image/logo.png"));
		logoJPanel.add(logoLabel);

		add(logoJPanel);
		add(dataJPanel, BorderLayout.SOUTH);

		setMinimumSize(new Dimension(300, 400));
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

	}

	public static void main(String[] args) {
		new LogInWindow();
	}

}
