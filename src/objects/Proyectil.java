package objects;

import java.awt.geom.Rectangle2D;

/**
 * 
 * @author Dariel
 *
 */
public class Proyectil {
	private int x, y;
	
	private final int incrementoX = 1, incrmentoY = 1;
	/*en este caso no hay cambio en el incremento, pero en caso de aceleraci'on estas variables no pueden ser final */
	
	private final int ALTO = 10, ANCHO = 10;
	
	public Proyectil(int xPosition, int yPosition) {
		this.x = xPosition;
		this.y = yPosition;
	}
	
	public Rectangle2D getProyectil() {
		return new Rectangle2D.Double(this.x, this.y, ANCHO, ALTO);
	}
	
	public void mover() {
		this.x += incrementoX;
		this.y -= incrmentoY;
	}
}
