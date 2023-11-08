package fakultet;

public abstract class Osoba {
	private String ime;
	private String prezime;
	
	public Osoba(String i, String p) {
		ime = i; prezime = p;
	}
	
	public abstract char getOznaka();
	
	protected StringBuilder ispis() {
		StringBuilder sb = new StringBuilder();
		sb.append(ime).append(prezime);
		return sb; 
	}
	
	@Override
	public String toString() {
		
		return ispis().toString();
	}

}
