package paket;

import java.awt.Color;

import java.util.Random;

public abstract class Proizvodjac extends Parcela implements Runnable {

	private int osnovnoVreme;
	private Baterija baterija;
	//private boolean radi = true;
	private Thread nit;
	
	public Proizvodjac(char o, Color b,int vreme, Baterija bat ) {
		super(o, b);
		osnovnoVreme = vreme;
		baterija = bat;
		nit = new Thread(this);
		nit.start();
	}
	
	public int ukupnoVreme() {
		return osnovnoVreme + new Random().nextInt(300); 
	}
	
	protected abstract int jedinicaEnergije();
	
	protected abstract boolean uspesnaProizvodnja();
	
	private int proizvediEnergiju() {
		if(uspesnaProizvodnja()) {
			return jedinicaEnergije();
		} else
			return 0; 
	}
	
	@Override
	public void run() {
		Color boja = getForeground();
		try {
			while(!Thread.interrupted()) {
				Thread.sleep(ukupnoVreme());
				
				int energija = proizvediEnergiju();
				if(energija != 0) {
					baterija.dodajEnergiju(energija);
					setForeground(Color.RED);
				}
				
				Thread.sleep(300);
				
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


/*
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
		baterija.dodajPotrosaca(this);
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

 */