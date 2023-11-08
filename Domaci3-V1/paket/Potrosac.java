package paket;

import java.awt.Color;

public class Potrosac extends Parcela implements Runnable {
	
	protected int brTravnatihPovrsina;
	private Baterija baterija;
	protected int vremeCekanja;
	private boolean baterijaSpremna = false;
	private Thread nit = new Thread(this);
	
	public Potrosac(char o, Color b, Baterija bat) {
		super(o, b);
		baterija = bat;
		//baterija.dodajPotrosaca(this);
		nit.start();
	}
	
	protected int getTravnatePovrsine() {
		return brTravnatihPovrsina;  
	}
	
	protected synchronized void signalOdBaterije() {
		baterijaSpremna = true;
	}

	public void postaviTravnatePovrsine(int br) {
		brTravnatihPovrsina = br;
	}

	@Override
	public void run() {
		Color boja = getForeground();
		try {
			while(!Thread.interrupted()) {
				
				synchronized (baterija) {
					while(baterijaSpremna == false)
						baterija.wait();
				}
				
				
				baterija.isprazni();
				baterijaSpremna = false;
				setForeground(Color.MAGENTA);
				
				
				Thread.sleep(vremeCekanja); 
				
				setForeground(boja);
			}
			
		} catch(InterruptedException e) {}
	}
	
	public synchronized void zavrsi() {
		if(nit == null)
			return;
		
		nit.interrupt();
		try {
			nit.join();
			nit = null;
		} catch (InterruptedException e) {}
	}
}
