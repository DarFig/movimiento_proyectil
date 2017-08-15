package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;
/**
 * 
 * @author Dariel
 *
 */
public class AppPanel extends JPanel {
	Proyectil proyectil = new Proyectil(50, 300);
	
	
	public AppPanel(){
		setBackground(Color.LIGHT_GRAY);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		this.dibujar(g2d);
		this.update();
						
	}
	
	public void dibujar(Graphics2D g2d) {
		g2d.fill(proyectil.getProyectil());
	
		
	}
	
	public void update() {
		proyectil.mover();
	}
	
	public void setProyectil(Proyectil nProyectil){
		this.proyectil = nProyectil;
		repaint();
	}
	
	public boolean impacto(){
		return proyectil.impacto();
	}
}
