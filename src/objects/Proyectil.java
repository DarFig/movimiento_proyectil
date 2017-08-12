package objects;


import java.awt.geom.Ellipse2D;
/**
 * 
 * @author Dariel
 *
 */
public class Proyectil {
	private int x, y;
	private float vx, vy, g, tiempo; 
	private boolean impacto;
	
	
	/*en este caso no hay cambio en el incremento, pero en caso de aceleraci'on estas variables no pueden ser final */
	
	private final int ALTO = 12, ANCHO = 12;
	
	public Proyectil(int xPosition, int yPosition) {
		this.x = xPosition;
		this.y = yPosition;
		this.tiempo = 0;
		this.vx = 10.0f;
		this.vy = 10.0f;
		this.g = 9.8f;
		
		this.impacto = false;
	}
	public Proyectil(int xPosition, int yPosition, float vix, float viy) {
		this.x = xPosition;
		this.y = yPosition;
		this.tiempo = 0;
		this.vx = vix;
		this.vy = viy;
		this.g = 9.8f;
		
		this.impacto = false;
	}
	public Proyectil(int xPosition, int yPosition, float vix, float viy, float gravedad) {
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
		//this.x += incrementoX;
		//this.y -= incrmentoY;
		
		
		//Actualizar posicion
		if(this.y < 700) {
			this.x += (int) (this.vx * tiempo);
			
			/* se decrementa la posicion en y porque el eje esta invertido al dibujar en pantalla*/
			this.y = this.y - (int) (-0.5f * g *(tiempo * tiempo) + vy*tiempo);
		}else{
			this.impacto = true;
		}
		
		//Actualizar velocidad y tiempo
		this.tiempo += 0.01f;//los 10ms ddel thread 
		this.velocidadParabolica();
		
	}
	public boolean impacto(){
		return impacto;
	}
	
	private void velocidadParabolica() {
		//implica una desaceleracion vertical
		this.vy = this.vy - g * 0.01f; // 0.098m cada 10ms
	}
	
}
