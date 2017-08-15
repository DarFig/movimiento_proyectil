package objects;


import java.awt.geom.Ellipse2D;
/**
 * 
 * @author Dariel
 * Clase base se mueve a velocidad constante, movimiento uniforme
 */
public class Proyectil {
	protected float x, y;
	protected float vx, vy, g, tiempo; 
	protected boolean impacto;
	
	
	
	
	protected final int ALTO = 12, ANCHO = 12;
	
	public Proyectil(float xPosition, float yPosition) {
		this.x = xPosition;
		this.y = yPosition;
		this.tiempo = 0;
		this.vx = 10.0f;
		this.vy = 10.0f;
		this.g = 9.8f;
		
		this.impacto = false;
	}
	public Proyectil(float xPosition, float yPosition, float vix, float viy) {
		this.x = xPosition;
		this.y = yPosition;
		this.tiempo = 0;
		this.vx = vix;
		this.vy = viy;
		this.g = 9.8f;
		
		this.impacto = false;
	}
	public Proyectil(float xPosition, float yPosition, float vix, float viy, float gravedad) {
		this.x = xPosition;
		this.y = yPosition;
		this.tiempo = 0;
		this.vx = vix;
		this.vy = viy;
		this.g = gravedad;
		
		this.impacto = false;
	}
	
	public Ellipse2D getProyectil() {
		return new Ellipse2D.Double(this.x, this.y, ANCHO, ALTO);
	
	}
	
	public void mover() {
		
		
		
		//Actualizar posicion
		if(this.y < 700 && this.x < 1000) {
			this.x += this.vx;
			this.y -= this.vy;
		}else{
			this.impacto = true;
		}
		
		//Actualizar velocidad y tiempo
		this.tiempo += 0.01f;//los 10ms ddel thread 
		
	}
	public boolean impacto(){
		return impacto;
	}
	
	
	
}
