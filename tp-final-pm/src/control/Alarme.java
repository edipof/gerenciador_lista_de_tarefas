package control;

public class Alarme implements Runnable{
	
	public Alarme(){
		Thread a = new Thread(new Alarme());
		a.run();
	}
	@Override
	public void run(){
		
	}

	
}
