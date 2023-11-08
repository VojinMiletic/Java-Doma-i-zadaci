package fakultet;

public class Nastavnik extends Osoba {

	


	public enum Zvanje{doc, prof};
	private Zvanje zvanje;
	
	public Nastavnik(String i, String p, Zvanje z) {
		super(i, p);
		zvanje = z;
	}
	
	@Override
	public char getOznaka() {
		return 'N';
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(zvanje).append(".").append(" ").append("dr ").append(super.toString());
		return sb.toString();
	}

}
