package app;

import javax.swing.JFrame;

import objects.AppWindows;

/**
 * 
 * @author Dariel
 *
 */
public class App {
	public static void main(String[] args) {
		AppWindows principal = new AppWindows();
		principal.setVisible(true);
		principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
