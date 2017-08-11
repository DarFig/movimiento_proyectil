package objects;


import java.awt.geom.Ellipse2D;
/**
 * 
 * @author Dariel
 *
 */
public class Proyectil {
	private int x, y;
	private float vx, vy, tiempo; 
	
	private final int incrementoX = 1, incrmentoY = 1;
	/*en este caso no hay cambio en el incremento, pero en caso de aceleraci'on estas variables no pueden ser final */
	
	private final int ALTO = 10, ANCHO = 10;
	
	public Proyectil(int xPosition, int yPosition) {
		this.x = xPosition;
		this.y = yPosition;
		this.tiempo = 0;
		this.vx = 10.0f;
		this.vy = 10.0f;
	}
	
	public Ellipse2D getProyectil() {
		return new Ellipse2D.Double(this.x, this.y, ANCHO, ALTO);
	
	}
	
	public void mover() {
		//this.x += incrementoX;
		//this.y -= incrmentoY;
		
		
		//Actualizar posicion
		if(this.y < 700) {
			this.x += (int) (this.vx * tiempo);
			
			/* se decrementa la posicion en y porque el eje esta invertido al dibujar en pantalla*/
			this.y = this.y - (int) (-0.5f * 9.8f *(tiempo * tiempo) + vy*tiempo);
		}
		
		//Actualizar velocidad y tiempo
		this.tiempo += 0.01f;//los 10ms ddel thread 
		this.velocidadParabolica();
		
	}
	private void velocidadParabolica() {
		//implica una desaceleracion vertical
		this.vy = this.vy - 9.8f * 0.01f; // 0.098m cada 10ms
	}
	
}
