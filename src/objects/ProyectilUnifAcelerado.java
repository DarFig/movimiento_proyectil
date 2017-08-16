package objects;

public class ProyectilUnifAcelerado extends Proyectil{
	private float ax, ay;
	public ProyectilUnifAcelerado(float xPosition, float yPosition) {
		super(xPosition, yPosition);
		
	}
	public ProyectilUnifAcelerado(float xPosition, float yPosition, float vix, float viy, float ax, float ay) {
		super(xPosition, yPosition, vix, viy);
		this.ax = ax;
		this.ay = ay;
	}
	
	@Override
	public void mover() {
		//movimiento uniformemente acelerado
		
		//Actualizar posicion
		if(this.y < 700 && this.x < 1030) {
			this.x += (this.vx * tiempo);
			
			/* se decrementa la posicion en y porque el eje esta invertido al dibujar en pantalla*/
			this.y = this.y - ( this.vy * tiempo);
		}else{
			this.impacto = true;
		}
		
		//Actualizar velocidad y tiempo
		this.tiempo += 0.01f;//los 10ms ddel thread 
		this.actualizaVelocidad();
		
	}
	
	private void actualizaVelocidad() {
		
		this.vx = this.vx + ax * 0.01f;
		this.vy = this.vy + ay * 0.01f; // a cada 10ms
	}
}
