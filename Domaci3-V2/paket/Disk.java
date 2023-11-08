package paket;

import java.awt.Color;
import java.awt.Graphics;

public class Disk extends Figura {

	private static final double stepen = Math.PI / 4;
	
	private int tackeX[];
	private int tackeY[];
	
	public Disk(Vektor vPol, Vektor vPom, int r) {
		super(vPol, vPom, r);
		this.setBoja(Color.BLUE );
		
	}
	
	public Disk(Vektor vPol, Vektor vPom) {
		this(vPol, vPom, 20);
	}


	@Override
	public void crtaj(Graphics g) {
		tackeX = new int[8];
		tackeY = new int[8];
		double x0 = vektorPolozaja.getX();
		double y0 = vektorPolozaja.getY();
		for(int i = 1; i < 9; i++) {
			tackeX[i-1]=((int) (x0 + poluprecnik * Math.cos(stepen * i)));
			tackeY[i-1]=((int) (y0 + poluprecnik * Math.sin(stepen * i)));
		}
		g.setColor(this.getBoja());
		g.fillPolygon(tackeX, tackeY, 8); 
	}

}
