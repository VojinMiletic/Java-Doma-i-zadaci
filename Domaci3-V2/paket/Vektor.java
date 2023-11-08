package paket;

import java.util.Random;

public class Vektor {

	private double x, y;
	public Vektor(double xx, double yy) {
		x = xx; y = yy;
	}
	
	public Vektor() {
		Random rand = new Random();
		
		double donja = -1, gornja = 1;
		
		x = donja + (gornja - donja) * rand.nextDouble();
		y = donja + (gornja - donja) * rand.nextDouble();
		
		while( x == 0 && y == 0) {
			x = donja + (gornja - donja) * rand.nextDouble();
			y = donja + (gornja - donja) * rand.nextDouble();
		}
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	public Vektor odrediOrt() {
		double magnituda = Math.sqrt(x*x + y*y);
		double xOrt = x / magnituda;
		double yOrt = y / magnituda;
		return new Vektor(xOrt, yOrt); 
	}
}
