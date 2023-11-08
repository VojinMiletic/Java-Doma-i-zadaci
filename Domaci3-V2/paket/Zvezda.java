package paket;

import java.awt.Color;
import java.awt.Graphics;

public class Zvezda extends Figura {

	private static final int ugao = 36;
	private int brojSudara = 0; 
	
	private Color boje[] = {Color.RED, Color.PINK, Color.GREEN};
	protected int stigaoSamDoBoje = 0;
	
	public Zvezda(Vektor vPol, Vektor vPom) {
		super(vPol, vPom);
		poluprecnik = 30;
	}

	public int getBrojSudara() {
		return brojSudara;
	}
	public void setBrojSudara(int br) {
		brojSudara = br;
	}
	

	@Override
	public void crtaj(Graphics g) {
		int X[] = new int[10];
		int Y[] = new int[10];
		
		for(int i = 0; i < 10; i++) {
			X[i] =(int) (this.getVektorPolozaja().getX() + 
					(1+ (i%2)) * getPoluprecnik()/2 * Math.cos((i+1) * Math.toRadians(ugao)));
			Y[i] =(int) (this.getVektorPolozaja().getY() + 
					(1+ (i%2)) * getPoluprecnik()/2 * Math.sin((i+1) * Math.toRadians(ugao)));
		}
		this.setBoja(boje[stigaoSamDoBoje]);
		g.setColor(this.getBoja());
		g.fillPolygon(X, Y, 10);
	}
	
	

}
