package objects;
/**
 * 
 * @author Dariel
 * Describe un movimiento de tiro parabólico
 */
public class ProyectilParabolico extends Proyectil{

	public ProyectilParabolico(float xPosition, float yPosition) {
		super(xPosition, yPosition);
		
	}
	public ProyectilParabolico(float xPosition, float yPosition, float vix, float viy) {
		super(xPosition, yPosition, vix, viy);
	}
	public ProyectilParabolico(float xPosition, float yPosition, float vix, float viy, float gravedad) {
		super(xPosition, yPosition, vix, viy, gravedad);
	}
	
	@Override
	public void mover() {
		//movimiento parabólico
		
		//Actualizar posicion
		if(this.y < 700 && this.x < 1030) {
			this.x += (this.vx * tiempo);
			
			/* se decrementa la posicion en y porque el eje esta invertido al dibujar en pantalla*/
			this.y = this.y - (-0.5f * g *(tiempo * tiempo) + vy*tiempo);
		}else{
			this.impacto = true;
		}
		
		//Actualizar velocidad y tiempo
		this.tiempo += 0.01f;//los 10ms ddel thread 
		this.velocidadParabolica();
		
	}
	
	private void velocidadParabolica() {
		//implica una desaceleracion vertical
		this.vy = this.vy - g * 0.01f; // 0.098m cada 10ms
	}
}
