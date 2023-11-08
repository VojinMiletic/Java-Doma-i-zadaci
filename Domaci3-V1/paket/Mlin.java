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
