package objects;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Dariel, DarFig
 *
 */

public class AppWindows extends JFrame{
	//-----
	private final int WIDTH = 1024, HIGH = 768;
	private AppPanel panel;
	private JPanel panelNorte;
	private PrincipalThread thread;
	private Proyectil miProyectil;
	
	private Container content;
	private final String[] listString = {"Movimiento Uniforme", "Tiro Parabólico","Uniformemente acelerado", "..." };
	
	//campos y botones
	protected JTextField vix, viy, gravedad, ix, iy, ax, ay;
	protected JButton iniciar;
	protected JComboBox listado;
	
	
	//-----
	public AppWindows() {
		
		setTitle("Simulador de Movimientos");
		setSize(this.WIDTH, this.HIGH);
		setLocationRelativeTo(null);//ajustar al centro de la pantalla
		setResizable(false);//no se puede modificar tamanyo
		
		content = getContentPane();
		content.setLayout(new BorderLayout());
		
		//Paneles
		this.panelNorte = crearPanelNorteUniforme();
		content.add(panelNorte, BorderLayout.NORTH);
		
		this.panel = new AppPanel();
		content.add(panel, BorderLayout.CENTER);//anyadir el panel 
					
	}
	
	public int getAncho(){
		
		return WIDTH;	
		
	}
	
	private JPanel crearPanelNorteUniforme() {
		
		JPanel pNor = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		pNor.add(new JLabel(" v0 en x: "));
		this.vix = new JTextField(4);
		pNor.add(this.vix);
		
		pNor.add(new JLabel(" v0 en y: "));
		this.viy = new JTextField(4);
		pNor.add(this.viy);

		pNor.add(new JLabel(" posición en x(0-1024): "));
		this.ix = new JTextField(4);
		pNor.add(this.ix);
		
		pNor.add(new JLabel(" posición en y(0-768): "));
		this.iy = new JTextField(4);
		pNor.add(this.iy);
		
		
		this.iniciar = new JButton("start");
		this.iniciar.addActionListener(new CapturaBoton());
		pNor.add(this.iniciar);
		
		this.listado = new JComboBox(listString );
		this.listado.setSelectedItem(listString[0]);
		this.listado.addActionListener(new CapturaLista());
		pNor.add(this.listado);
		
		
		return pNor;
	}
	private JPanel crearPanelNorteParabolico() {
	
		JPanel pNor = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		pNor.add(new JLabel(" v0 en x: "));
		this.vix = new JTextField(4);
		pNor.add(this.vix);
		
		pNor.add(new JLabel(" v0 en y: "));
		this.viy = new JTextField(4);
		pNor.add(this.viy);

		pNor.add(new JLabel(" posición en x(0-1024): "));
		this.ix = new JTextField(4);
		pNor.add(this.ix);
		
		pNor.add(new JLabel(" posición en y(0-768): "));
		this.iy = new JTextField(4);
		pNor.add(this.iy);
		
		pNor.add(new JLabel(" v gravedad: "));
		this.gravedad = new JTextField(4);
		pNor.add(this.gravedad);
		
		this.iniciar = new JButton("start");
		this.iniciar.addActionListener(new CapturaBoton());
		pNor.add(this.iniciar);
		
		this.listado = new JComboBox(listString );
		this.listado.setSelectedItem(listString[1]);
		this.listado.addActionListener(new CapturaLista());
		pNor.add(this.listado);
		
		
		return pNor;
	}
	private JPanel crearPanelNorteUniforAcelerado() {
		JPanel pNor = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		pNor.add(new JLabel(" v0 en x: "));
		this.vix = new JTextField(4);
		pNor.add(this.vix);
		
		pNor.add(new JLabel(" v0 en y: "));
		this.viy = new JTextField(4);
		pNor.add(this.viy);

		pNor.add(new JLabel(" posición en x(0-1024): "));
		this.ix = new JTextField(4);
		pNor.add(this.ix);
		
		pNor.add(new JLabel(" posición en y(0-768): "));
		this.iy = new JTextField(4);
		pNor.add(this.iy);
		
		pNor.add(new JLabel("aceleración en x: "));
		this.ax = new JTextField(4);
		pNor.add(this.ax);
		
		pNor.add(new JLabel("aceleración en y: "));
		this.ay = new JTextField(4);
		pNor.add(this.ay);
		
		this.iniciar = new JButton("start");
		this.iniciar.addActionListener(new CapturaBoton());
		pNor.add(this.iniciar);
		
		this.listado = new JComboBox(listString );
		this.listado.setSelectedItem(listString[2]);
		this.listado.addActionListener(new CapturaLista());
		pNor.add(this.listado);
		
		
		return pNor;
	}
	
	private JPanel crearPanelNorteLimpio(){
		
		JPanel pNor = new JPanel(new FlowLayout(FlowLayout.LEFT));

		this.iniciar = new JButton("start");
		this.iniciar.addActionListener(new CapturaBoton());
		pNor.add(this.iniciar);
		
		this.listado = new JComboBox(listString );
		this.listado.setSelectedItem(listString[3]);
		this.listado.addActionListener(new CapturaLista());
		pNor.add(this.listado);
		
		return pNor;
	}
	
	public void run(){
		
		panel.setProyectil(this.miProyectil);
		//Hilo
		this.thread = new PrincipalThread(this.panel);
		thread.start();
	}
	
	class CapturaBoton implements ActionListener {
		/*
		 * Escucha el botón y lee los datos de acuerdo a las diferentes opciones
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				if(listado.getSelectedItem().equals(listString[0])){
					
					float vx = Float.parseFloat(vix.getText());
					float vy = Float.parseFloat(viy.getText());
					float x = Float.parseFloat(ix.getText());
					float y = invertirEje(Float.parseFloat(iy.getText()));
					
					miProyectil = new Proyectil(x, y, vx, vy);
					
					run();
					
				}else if (listado.getSelectedItem().equals(listString[1])) {
					
					float vx = Float.parseFloat(vix.getText());
					float vy = Float.parseFloat(viy.getText());
					float x = Float.parseFloat(ix.getText());
					float y = invertirEje(Float.parseFloat(iy.getText()));
					float g = Float.parseFloat(gravedad.getText());
					
					miProyectil = new ProyectilParabolico(x, y, vx, vy, g);
					
					run();
				}else if (listado.getSelectedItem().equals(listString[2])) {
					
					float vx = Float.parseFloat(vix.getText());
					float vy = Float.parseFloat(viy.getText());
					float x = Integer.parseInt(ix.getText());
					float y = invertirEje(Integer.parseInt(iy.getText()));
					float acx = Float.parseFloat(ax.getText());
					float acy = Float.parseFloat(ay.getText());
					
					miProyectil = new ProyectilUnifAcelerado(x, y, vx, vy, acx, acy);
					
					run();
					
				}else{
					miProyectil = new Proyectil(20, 200, 2, 0);
					
					run();
				}
				
			} catch (Exception e2) {
				
				JOptionPane.showMessageDialog(AppWindows.this, "Error en los campos de entrada");
			}
			
		}
		private float invertirEje(float y) {
			return -1 * y + 768;
		}

	}
	class CapturaLista implements ActionListener {
		/*
		 * Respecto a la opción seleccionada de la lista genera los diferentes paneles
		 * que pueden ir en el panel norte
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println(listado.getSelectedItem());
			if(listado.getSelectedItem().equals(listString[0])){
				content.remove(panelNorte);
				content.setVisible(false);
				panelNorte = crearPanelNorteUniforme();
				content.add(panelNorte, BorderLayout.NORTH);
				content.setVisible(true);
			
			}else if (listado.getSelectedItem().equals(listString[1])) {
				
				content.remove(panelNorte);
				content.setVisible(false);
				panelNorte = crearPanelNorteParabolico();
				content.add(panelNorte, BorderLayout.NORTH);
				content.setVisible(true);
				
			}else if (listado.getSelectedItem().equals(listString[2])) {
				
				content.remove(panelNorte);
				content.setVisible(false);
				panelNorte = crearPanelNorteUniforAcelerado();
				content.add(panelNorte, BorderLayout.NORTH);
				content.setVisible(true);
				
			}else{
				content.remove(panelNorte);
				content.setVisible(false);
				panelNorte = crearPanelNorteLimpio();
				content.add(panelNorte, BorderLayout.NORTH);
				content.setVisible(true);
			}
			
		}
		

	}
	
	

}
