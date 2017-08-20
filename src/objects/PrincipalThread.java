package objects;


/**
 * 
 * @author Dariel, DarFig
 *
 */
public class PrincipalThread extends Thread{
	private AppPanel panel;
	
	
	public PrincipalThread(AppPanel jpanel){
		this.panel = jpanel;
	}
	
	@Override
	public void run(){
		try {
			Thread.sleep(500);
		
		while (!panel.impacto()) {
		
			Thread.sleep(10);
			
			this.panel.repaint();
			
		}
		} catch (InterruptedException e1) {
			
			e1.printStackTrace();
		}
	}
	
	
}
