package paket;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Figura {
	protected Vektor vektorPolozaja;
	protected Vektor vektorPomeraja;
	
	protected int poluprecnik; 
	
	// Modifikacija
	protected Color boja;
	
	public Figura(Vektor vPol, Vektor vPom, int r) {
		vektorPolozaja = vPol;
		vektorPomeraja = vPom;
		poluprecnik = r;
	}

	public Figura(Vektor vPol, Vektor vPom) {
		this(vPol, vPom, 20);
	}
	public Vektor getVektorPolozaja() {
		return vektorPolozaja;
	}

	public Vektor getVektorPomeraja() {
		return vektorPomeraja;
	}

	public int getPoluprecnik() {
		return poluprecnik;
	}

	public void setVektorPolozaja(Vektor vektorPolozaja) {
		this.vektorPolozaja = vektorPolozaja;
	}

	public void setVektorPomeraja(Vektor vektorPomeraja) {
		this.vektorPomeraja = vektorPomeraja;
	}

	public void setPoluprecnik(int poluprecnik) {
		this.poluprecnik = poluprecnik;
	}
	
	public boolean proveriVektor() {
		return  Math.sqrt(Math.pow(vektorPolozaja.getX(),2) + 
				          Math.pow(vektorPolozaja.getX(),2)) <= poluprecnik;
	}
	
	public  boolean poreklapanjeKruznica(Figura f) {
		double razdaljina = Math.sqrt(
				Math.pow(vektorPolozaja.getX() - f.getVektorPolozaja().getX(), 2) +
				Math.pow(vektorPolozaja.getY() - f.getVektorPolozaja().getY(), 2));
		
		return razdaljina < poluprecnik + f.getPoluprecnik(); 
	}
	
	public  Color getBoja() { 
		return boja;
	}
	
	public void setBoja(Color b) {
		boja = b;
	}
	
	public abstract void crtaj(Graphics g);
}




/*
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

 */



/*
 * package paket;

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

 */
