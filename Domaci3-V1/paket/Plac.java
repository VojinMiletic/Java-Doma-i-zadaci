package paket;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;

public class Plac extends Panel {

	int redovi, kolone;
	private Parcela selektovanaParcela = null;
	private ArrayList<Parcela> parcele = new ArrayList<>();
	private ArrayList<Proizvodjac> proizvodjaci = new ArrayList<>();
	
	// Modifikacije
	//private ArrayList<Potrosac> potrosaci = new ArrayList<>();
	
	
	public Plac(int r, int k) {
		super(new GridLayout(r, k, 5, 5));
		redovi = r;
		kolone = k;
		for(int i = 0; i < redovi * kolone; i++) {
			Parcela par = Math.random() <= 0.7 ? new TravnataPovrs() : new VodenaPovrs();
			parcele.add(par);
			add(par);
		}
	}

	private void promeniFont(Parcela par, float vel) {
		Font stari = par.getFont();
		Font novi = stari.deriveFont(vel);
		par.setFont(novi);
	}
	
	public void oznaciSelektovanu(Parcela parcela) {
		if(!parcele.contains(parcela))
			return;
		if(selektovanaParcela != null)
			promeniFont(selektovanaParcela, 14);
		
		selektovanaParcela = parcela; 
		promeniFont(selektovanaParcela, 20);
	}
	
	public void dodajProizvodjaca(Proizvodjac pro) {
		if(selektovanaParcela == null) {
			pro.zavrsi();
			return; 
		}
		
		if(selektovanaParcela instanceof Proizvodjac) {
			((Proizvodjac)selektovanaParcela).zavrsi();
			proizvodjaci.remove((Proizvodjac)selektovanaParcela);
		}
		
		/*
		//Modifikacija
		if(selektovanaParcela instanceof Potrosac) {
			((Potrosac)selektovanaParcela).zavrsi();
			potrosaci.remove((Potrosac)selektovanaParcela);
		}
		*/
		
		int indeks = parcele.indexOf(selektovanaParcela);
		parcele.set(indeks, pro);
		
		proizvodjaci.add(pro);
		
		this.remove(indeks);
		this.add(pro, indeks);
		this.revalidate();
		
		oznaciSelektovanu(pro);
		
		azurirajVodenePovrsine();
		//Modifikacija
		//azurirajTravnatePovrsine();
	}
	
	/*
	//Modifikacije
	public void dodajPotrosaca(Potrosac pot) {
		if(selektovanaParcela == null) {
			pot.zavrsi();
			return; 
		}
		
		if(selektovanaParcela instanceof Proizvodjac) {
			((Proizvodjac)selektovanaParcela).zavrsi();
			proizvodjaci.remove((Proizvodjac)selektovanaParcela);
		}
		
		if(selektovanaParcela instanceof Potrosac) {
			((Potrosac)selektovanaParcela).zavrsi();
			potrosaci.remove((Potrosac)selektovanaParcela);
		}
		
		int indeks = parcele.indexOf(selektovanaParcela);
		parcele.set(indeks, pot);
		
		potrosaci.add(pot);
		
		this.remove(indeks);
		this.add(pot, indeks);
		this.revalidate();
		
		oznaciSelektovanu(pot);
		
		azurirajVodenePovrsine();
		azurirajTravnatePovrsine();
	}
	*/
	
	private int okruzujuceVodenePorvsine(Hidroelektrana hidro) {
		int br = 0;
		int indeks = parcele.indexOf(hidro);
		
		int red = indeks / kolone;
		int kolona = indeks % redovi;
		
		for(int i = red - 1; i < red + 2; i++) {
			for(int j = kolona - 1; j < kolona + 2; j++) {
				if(i < 0 || i >= redovi || j < 0 || j >= kolone)
					continue;
				
				if(parcele.get(i * kolone + j) instanceof VodenaPovrs)
					br++;
			}
		}
		
		return br;
	}
	
	/*

	// Modifikacija
	private int okruzujuceTravnatePorvsine(Mlin mlin) {
		int br = 0;
		int indeks = parcele.indexOf(mlin);
		
		int red = indeks / kolone;
		int kolona = indeks % redovi;
		
		for(int i = red - 1; i < red + 2; i++) {
			for(int j = kolona - 1; j < kolona + 2; j++) {
				if(i < 0 || i >= redovi || j < 0 || j >= kolone)
					continue;
				
				if(parcele.get(i * kolone + j) instanceof TravnataPovrs)
					br++;
			}
		}
		
		return br;
	}
	*/
	
	private void azurirajVodenePovrsine() {
		for(int i = 0; i < proizvodjaci.size(); i++) {
			if(proizvodjaci.get(i) instanceof Hidroelektrana) {
				((Hidroelektrana)proizvodjaci.get(i)).
				postaviVodenePovrsine(okruzujuceVodenePorvsine((Hidroelektrana)proizvodjaci.get(i)));
			}
		}
		
	}
	
	/*
	// Modifikacija
	private void azurirajTravnatePovrsine() {
		for(int i = 0; i < potrosaci.size(); i++) {
			if(potrosaci.get(i) instanceof Mlin) {
				((Mlin)potrosaci.get(i)).
				postaviTravnatePovrsine(okruzujuceTravnatePorvsine((Mlin)potrosaci.get(i)));
				((Mlin)potrosaci.get(i)).setVremeCekanja(); 
			}
		}
		
	}
	*/
	
	public void zaustaviProizvodjace() {
		for(int i = 0; i < proizvodjaci.size(); i++) {
			proizvodjaci.get(i).zavrsi();
		}
	}
	
	/*
	// Modifikacija
	public void zaustaviPotrosace() {
		for(int i = 0; i < potrosaci.size(); i++) {
			potrosaci.get(i).zavrsi();
		}
	}
	*/
}
