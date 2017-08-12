package objects;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
/**
 * 
 * @author Dariel
 *
 */
public class AppWindows extends JFrame{
	//-----
	private final int WIDTH = 1024, HIGH = 768;
	private AppPanel panel;
	private JPanel panelNorte;
	private PrincipalThread thread;
	
	//campos y botones
	private JTextField vix, viy, gravedad, ix, iy;
	private JButton iniciar;
	
	
	//-----
	public AppWindows() {
		setTitle("Simulador de Tiro");
		setSize(this.WIDTH, this.HIGH);
		setLocationRelativeTo(null);//ajustar al centro de la pantalla
		setResizable(false);//no se puede modificar tamanyo
		
		Container content = getContentPane();
		content.setLayout(new BorderLayout());
		
		//Paneles
		this.panelNorte = crearPanelNorte();
		content.add(panelNorte, BorderLayout.NORTH);
		
		this.panel = new AppPanel();
		content.add(panel, BorderLayout.CENTER);//anyadir el panel 
		
		//Hilo
		this.thread = new PrincipalThread(this.panel);
		this.thread.start();
	}
	public int getAncho(){
		return WIDTH;
		
	}
	private JPanel crearPanelNorte() {
		JPanel pNor = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		pNor.add(new JLabel(" v0 en x: "));
		this.vix = new JTextField(4);
		pNor.add(this.vix);
		
		pNor.add(new JLabel(" v0 en y: "));
		this.viy = new JTextField(4);
		pNor.add(this.viy);
		
		pNor.add(new JLabel(" v gravedad: "));
		this.gravedad = new JTextField(4);
		pNor.add(this.gravedad);
		
		this.iniciar = new JButton("start");
		pNor.add(this.iniciar);
		
		return pNor;
	}
	
}
