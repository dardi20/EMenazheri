package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import data.DataHandler;

public class ChangePasswordWindow extends Window {

	private static final long serialVersionUID = 1959557355173887811L;

	public ChangePasswordWindow() { 

		setTitle(getTitle() + " - Ndrysho fjalekalimin");

		JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
		mainPanel.setBackground(Color.WHITE);
		mainPanel.setBorder(new LineBorder(Color.WHITE, 10));

		JPanel centerPanel = new JPanel(new GridLayout(5, 2, 10, 10));
		centerPanel.setBackground(Color.WHITE);

		JPanel eastPanel = new JPanel(new GridLayout(5, 1, 10, 10));
		eastPanel.setBackground(Color.WHITE);

		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(eastPanel, BorderLayout.EAST);

		add(mainPanel);

		centerPanel.add(new JLabel("Vendosni Username"));
		JTextField codeTextField = new JTextField();
		centerPanel.add(codeTextField);

//		JButton confirmUserName = new JButton("OK");
//		eastPanel.add(confirmUserName);

		centerPanel.add(new JLabel("Fjalekalimi ekzistues"));
		JTextField passwordTextField = new JTextField();
		centerPanel.add(passwordTextField);

		eastPanel.add(new JLabel());

		centerPanel.add(new JLabel("Fjalekalimi i ri"));
		JTextField newPasswordTextField = new JTextField();
		centerPanel.add(newPasswordTextField);

//		JButton showNewPassword = new JButton("~");
//		eastPanel.add(showNewPassword);

		centerPanel.add(new JLabel("Perserit fjalekalimin e ri"));
		JTextField repeatNewPasswordTextField = new JTextField();
		centerPanel.add(repeatNewPasswordTextField);

//		JButton showReapeatNewPassword = new JButton("~");
//		eastPanel.add(showReapeatNewPassword);

		JButton confirm = new JButton("Konfirmo");
		JButton cancel = new JButton("Anullo");

		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userName = codeTextField.getText();
				String password = passwordTextField.getText();
				String newPassword = newPasswordTextField.getText();
				String confirmNewPassword = repeatNewPasswordTextField.getText();
				try {
					if (DataHandler.authUser(userName, password)) {

						if (newPassword.equals(confirmNewPassword)) {
							DataHandler.updatePassword(userName, newPassword);
							JOptionPane.showConfirmDialog(null, "Passwordi u nderua me sukses!");
							setVisible(false);
						}
//						new MainWindow();
//						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "Ky username nuk ekziston! Provoni serish!", "Gabim",
								JOptionPane.WARNING_MESSAGE);

					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
//			JOptionPane.showMessageDialog(null,
//						"Kodi i gabuar! Provoni serish!Nje email i ri ka ardhur ne posten tuaj", "Gabim",
//						JOptionPane.WARNING_MESSAGE);
			}
		});

		centerPanel.add(confirm);
		centerPanel.add(cancel);

		confirm.setEnabled(true);
		
//		showNewPassword.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if(newPasswordTextField.isEnabled()) {
//					newPasswordTextField.setEnabled(false);
//				}
//				else {
//					newPasswordTextField.setEnabled(true);;
//				}
//				
//			}
//		});
//		
//		showNewPassword.setEnabled(false);
//		showReapeatNewPassword.setEnabled(false);
//		newPasswordTextField.setEnabled(false);
//		repeatNewPasswordTextField.setEnabled(false);
//		passwordTextField.setEnabled(false);

//		confirmUserName.addActionListener((e) -> {
//			confirm.setEnabled(true);
//			showNewPassword.setEnabled(true);
//			showReapeatNewPassword.setEnabled(true);
//			newPasswordTextField.setEnabled(true);
//			repeatNewPasswordTextField.setEnabled(true);
//			passwordTextField.setEnabled(true);
//			confirmUserName.setEnabled(false);
//			codeTextField.setEnabled(false);
//		});

		eastPanel.add(new JLabel());

		setMinimumSize(new Dimension(400, 200));
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		revalidate();
		setVisible(true);

	}

	public static void main(String[] args) {
		new ChangePasswordWindow();
	}

}
