package fakultet;

import java.util.Vector;

public class Predmet {

	private String Naziv;
	private String Sifra;
	private boolean imaNastavnika = false;
	
	private Vector<Osoba> osobe;
	private int popunjenost = 0;
	
	public Predmet(String N, String S) {
		Naziv = N; Sifra = S;
		osobe = new Vector<Osoba>();
	}
	
	public String getNaziv() {
		return Naziv;
	}
	public String getSifra() {
		return Sifra;
	} 
	
	public void dodajOsobu(Osoba o) throws GViseNastavnika {
		if(o instanceof Nastavnik && !imaNastavnika) {
			imaNastavnika = true;
			osobe.add(popunjenost++, o);
		}
		else if(o instanceof Nastavnik && imaNastavnika) {
			throw new GViseNastavnika();
		}
		else {
			osobe.add(popunjenost++, o);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Naziv).append(" (").append(Sifra).append(")");
		for(int i = 0; i < popunjenost; i++) {
			sb.append("\n").append(osobe.get(i));
		}
		return sb.toString();
	}
	
	
	
	
}
