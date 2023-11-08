package paket;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Panel;
import java.util.ArrayList;


public class Baterija {
	private int trenutnaEnergija;
	private int kapacitet;
	
	/*
	// Modifikacije
	
	private int stigaoSamDo = 0;
	private ArrayList<Potrosac> potrosaci = new ArrayList<>();
	
	protected void dodajPotrosaca(Potrosac p) {
		potrosaci.add(p);
	}
	
	Label napunjenost;
	//int brPodeoka;
	//private static final int  brY = 30;
	//private static final int  brX = 10;
	
	Label napunjenost; 
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		g.drawRect(brX,brY , 31, 200);
		for(int i = brPodeoka-1; i >= 0; i--) {
			g.setColor(Color.RED);
			g.drawRect(brX, brY + 1 + (9-i) * 20, 30, 20);
			g.setColor(Color.YELLOW);
			g.fillRect(brX + 1, brY + 2 + (9-i) * 20, 30, 19);
			
		}
	}
	
	*/
	
	public Baterija(int kap) {
		//napunjenost = new Label("Trenutno stanje baterije je: 0");
		//add(napunjenost);
		kapacitet  = kap;
		trenutnaEnergija = 0;
		//brPodeoka = trenutnaEnergija / 10;
		//repaint();
	}
	
	public synchronized void dodajEnergiju(int energ) {
		trenutnaEnergija += energ;
		trenutnaEnergija = trenutnaEnergija > kapacitet ? kapacitet : trenutnaEnergija;
		//napunjenost.setText(String.valueOf(trenutnaEnergija) + " / " + String.valueOf(kapacitet));
		//napunjenost.revalidate();
		//brPodeoka = trenutnaEnergija / 10;
		//repaint();
		
		/*
		// Modifikacija
		
		napunjenost.setText("Trenutno stanje baterije je: " + String.valueOf(trenutnaEnergija));
		napunjenost.revalidate();
		if(trenutnaEnergija == kapacitet) {
			notifyAll();
			potrosaci.get(stigaoSamDo).signalOdBaterije();
			stigaoSamDo = (stigaoSamDo + 1) % potrosaci.size();
		}
		*/
	}
	
	public synchronized void isprazni() {
		trenutnaEnergija = 0;
		//napunjenost.setText(String.valueOf(trenutnaEnergija) + " / " + String.valueOf(kapacitet));
		//napunjenost.revalidate();
		//brPodeoka = trenutnaEnergija / 10;
		//repaint();
		//napunjenost.setText("Trenutno stanje baterije je: 0");
		//napunjenost.revalidate();
	}
	
	public boolean puna() {
		return trenutnaEnergija == kapacitet; 
	}
}
