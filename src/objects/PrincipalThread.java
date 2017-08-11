package objects;

public class PrincipalThread extends Thread{
	private AppPanel panel;
	
	
	public PrincipalThread(AppPanel jpanel){
		this.panel = jpanel;
	}
	
	@Override
	public void run(){
		while (true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.panel.repaint();
			
		}
	}
	
	
}
