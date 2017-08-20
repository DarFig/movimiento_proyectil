package app;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.*;

import objects.AppWindows;

/**
 * 
 * @author Dariel, DarFig
 * 
 */
public class App {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new NimbusLookAndFeel());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		AppWindows principal = new AppWindows();
		principal.setVisible(true);
		principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
	}
}
