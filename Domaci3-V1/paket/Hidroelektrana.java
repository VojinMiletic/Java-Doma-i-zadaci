package paket;

import java.awt.Color;

public class Hidroelektrana extends Proizvodjac {

	private int brVodenihPovrsina = 0;
	
	public Hidroelektrana(Baterija bat) {
		super('H', Color.BLUE, 1500, bat);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int jedinicaEnergije() {
		
		return brVodenihPovrsina * 1;
	}

	@Override
	protected boolean uspesnaProizvodnja() {
		
		return brVodenihPovrsina >= 1;
	}

	public void postaviVodenePovrsine(int n) {
		brVodenihPovrsina = n;
	}
	
}



/*
package paket;

import java.awt.Color;

public class Mlin extends Potrosac {

	public Mlin(Baterija bat) {
		super('M', Color.ORANGE, bat);
		vremeCekanja = 8000 - brTravnatihPovrsina * 1000;
	}

	void setVremeCekanja(){
		vremeCekanja = 8000 - getTravnatePovrsine() * 1000;
	}
	
}
*/
 