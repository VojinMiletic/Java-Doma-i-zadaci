package skijanje;

import java.util.Vector;

public class Staza {

	private String naziv;
	private int popunjenost = 0;
	private Vector<Deonica> deonice;
	
	public Staza(String n) {
		naziv = n;
		deonice = new Vector<Deonica>();
	}
	
	public void dodaj(Deonica d) {
		deonice.add(popunjenost++, d);
	}
	public int broj() {
		return popunjenost;
	}
	
	public double duzina() {
		double suma = 0.0;
		for(int i = 0; i < popunjenost; i++) {
			suma+= deonice.get(i).duzina();
		}
		return suma; 
	}
	public double nagib() {
		double maksNagib = 0.0;
		for(int i = 0; i < popunjenost; i++) {
			if(deonice.get(i).nagib > maksNagib)
				maksNagib = deonice.get(i).nagib;
		}
		return maksNagib; 
	}
	// Resenje u kvadratnoj slozenosti
	/*public char oznaka() throws GOznaka {
		if(popunjenost == 0) throw new GOznaka();
		
		char oznakaNajcesce = deonice.get(0).oznaka();
		int pojavljivanje = 1;
		
		for(int i = 0; i < popunjenost; i++) {
			char trenutnaOznaka = deonice.get(i).oznaka();
			int trenutnaPojavljivanja = 1;
			for(int j = i+1; j < popunjenost; j++) {
				if(deonice.get(i).oznaka() == deonice.get(j).oznaka()) {
					trenutnaPojavljivanja++;
				}
			}
			if(trenutnaPojavljivanja > pojavljivanje) {
				pojavljivanje = trenutnaPojavljivanja;
				oznakaNajcesce = trenutnaOznaka;
			}
		}
		return oznakaNajcesce; 
	}*/
	
	// Resenje u linearnoj slozenosti
	private boolean prvi(char prvi, char drugi) {
		for(int i = 0; i < popunjenost; i++) {
			if(deonice.get(i).oznaka() == prvi)
				return true;
			if(deonice.get(i).oznaka() == drugi)
				return false;
		}
		return false; 
	}
	
	public char oznaka() throws GOznaka {
		if(popunjenost == 0) throw new GOznaka();
		
		int mapa[] = new int[25]; // Imamo 25 velikih slova u engleskom alfabetu
		// A je u ski tabeli 65, a mi ocemo da ga mapiramo u indeks 0 u nizu mapa
		// Zato od svakog chara oduzimamo 65 kad gledamo koji je indeks niza
		
		for(int i = 0; i < popunjenost; i++) {
			mapa[deonice.get(i).oznaka() - 65]++;
		}
		int indeks = 0;
		for(int i = 0; i < 25; i++) {
			if(mapa[i] > mapa[indeks])
				indeks = i;
			else if(mapa[i] == mapa[indeks] && prvi((char)(i + 65), (char)(indeks + 65)))
				indeks = i;
		}
		
		return (char)(indeks + 65); 
	}
	
	public double brzina(double pocetna) {
		if(popunjenost == 0) return .0; 
		double suma = 0.0;
		double brzina = pocetna;
		for(int i = 0; i < popunjenost; i++) {
			suma = deonice.get(i).brzina(brzina);
			brzina = suma;
		}
		return suma; 
	}
	
	public double vreme(double pocetna) {
		if(popunjenost == 0) return .0; 
		double suma = 0.0;
		double brzina = pocetna;
		for(int i = 0; i < popunjenost; i++) {
			suma += deonice.get(i).vreme(brzina);
			brzina = deonice.get(i).brzina(brzina);
		}
		return suma;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(naziv).append("|").append(popunjenost)
		.append("|").append(duzina()).append("|")
		.append(nagib()).append("\n").append("[");
		
		boolean flag = false;
		for(int i = 0; i < popunjenost; i++) {
			if(flag) {
				sb.append(" ,");
			}
			sb.append(deonice.get(i));
			flag = true;
		}
		sb.append("]");
		return sb.toString();
	}
}
