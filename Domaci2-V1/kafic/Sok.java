package kafic;

public class Sok extends Pice {

	public enum Vrsta{GAZIRAN, NEGAZIRAN};
	
	private Vrsta vrsta;
	
	public Sok(String n, float z, int c, Vrsta v) {
		super(n, z, c);
		vrsta = v;
	}

	@Override
	public char getOznaka() {
		return vrsta == Vrsta.GAZIRAN ? 'G' : 'N';
	}
	
	public Vrsta getVrsta() {
		return vrsta; 
	}

}
