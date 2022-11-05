	package gui;
	 
	import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
	import javax.swing.JFrame;
	import javax.swing.UIManager;

	public class Window extends JFrame {

		private static final long 
			serialVersionUID = 7446192599263749847L;
		
		public Window() {
			super("e-Menazheri");
			
			try {
				UIManager.setLookAndFeel(UIManager.
						getSystemLookAndFeelClassName());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			setIconImage(new ImageIcon("image/logo.png").getImage()); 
			setSize(960, 600);
			setMinimumSize(new Dimension(960, 600));
      			setLocation((int)Toolkit.getDefaultToolkit().
				getScreenSize().getWidth() - 960, 0);
			setLocationRelativeTo(null);
			
		}
		
		public static void main(String[] args) {
			new Window(); 
		}
		
	}


