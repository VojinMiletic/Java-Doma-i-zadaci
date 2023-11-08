package paket;

import java.awt.Color;
import java.awt.Graphics;

public class Tocak extends Figura {

	static int id = 0;
	private int identifikator = id++;
	public Tocak(Vektor vPol, Vektor vPom, int r) {
		super(vPol, vPom, r);
		this.setBoja(Color.YELLOW); 
	}
	
	public int getId() {
		return identifikator; 
	}


	@Override
	public void crtaj(Graphics g) {
		g.setColor(getBoja());
		int X[] = new int[1000];
		int Y[] = new int[1000];
		for(int i = 0; i < 1000; i++) {
			X[i] = ((int) (getVektorPolozaja().getX() + poluprecnik * Math.cos(Math.PI/500 * i)));
			Y[i] = ((int) (getVektorPolozaja().getY() + poluprecnik * Math.sin(Math.PI/500 * i)));
		}
		g.fillPolygon(X, Y, 1000);
		
	}

}
