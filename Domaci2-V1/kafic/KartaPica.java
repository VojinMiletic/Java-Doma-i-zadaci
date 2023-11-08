package kafic;

import java.util.Vector;

public class KartaPica {
	private int popunjenost;
	private Vector<Pice> pica;
	
	public KartaPica() {
		popunjenost = 0;
		pica = new Vector<Pice>();
	}
	
	public void dodajPice(Pice p) throws GPostoji {
		for(int i = 0; i < popunjenost; i++) {
			if(pica.get(i) == p)
				throw new GPostoji();
		}
		pica.add(popunjenost++, p);
	}
	
	public int getBrojPica() {
		return popunjenost; 
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("GAZIRANI SOKOVI");
		for(int i = 0; i < popunjenost; i++) {
			if(pica.get(i).getOznaka() == 'G')
				sb.append("\n").append(pica.get(i));
			else
				continue;
		}
		sb.append("\n").append("NEGAZIRANI SOKOVI");
		for(int i = 0; i < popunjenost; i++) {
			if(pica.get(i).getOznaka() == 'N')
				sb.append("\n").append(pica.get(i));
			else
				continue;
		}
		
		return sb.toString();
	}

}
