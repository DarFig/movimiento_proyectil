package objects;

import javax.swing.JFrame;
/**
 * 
 * @author Dariel
 *
 */
public class AppWindows extends JFrame{
	//-----
	private final int WIDTH = 1024, HIGH = 768;
	private AppPanel panel; 
	private PrincipalThread thread;
	
	
	//-----
	public AppWindows() {
		setTitle("Simulador de Tiro");
		setSize(this.WIDTH, this.HIGH);
		setLocationRelativeTo(null);//ajustar al centro de la pantalla
		setResizable(false);//no se puede modificar tamanyo
		this.panel = new AppPanel();
		add(panel);//anyadir el panel al frame
		this.thread = new PrincipalThread(this.panel);
		this.thread.start();
	}
	
}
