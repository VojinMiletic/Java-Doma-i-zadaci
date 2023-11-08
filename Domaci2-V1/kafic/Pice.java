package kafic;

import java.util.Locale;

public abstract class Pice {

	private String naziv;
	private float zapremina;
	private int cenaPoLitru;
	
	public Pice(String n, float z, int c) {
		naziv = n; zapremina = z; cenaPoLitru = c;
	}
	
	public String getNaziv() {
		return naziv;
	}
	public float getZapremina() {
		return zapremina; 
	}
	public float getCena() {
		return (float)cenaPoLitru * zapremina; 
	}
	
	public abstract char getOznaka();
	
	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true; 
		if(!(obj instanceof Pice))
			return false; 
		else {
			Pice pic = (Pice) obj;
			return naziv.equals(pic.naziv)&& pic.zapremina == zapremina; 
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(naziv).append(" (").append(String.format(Locale.US,"%.2f", zapremina))
		.append(" L): ").append(String.format(Locale.US,"%.2f", this.getCena())).append(" RSD");
		
		return sb.toString();
	}
	
	
}
