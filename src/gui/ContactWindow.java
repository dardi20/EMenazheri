package gui;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class ContactWindow extends Window{
	
	private static final long serialVersionUID = 1L;

	public ContactWindow() {
	JPanel dataJPanel = new JPanel(); 
	dataJPanel.setBackground(Color.WHITE);
	dataJPanel.setLayout(new GridLayout(0, 2, 10, 10));
	}
	
}
