package skijanje;

public class Teska extends Deonica {

	private static final double g = 9.81;
	public Teska(double d, double n) {
		super(d, n);
	}

	@Override
	public char oznaka() {
		return 'T'; 
	}

	@Override
	public double ubrzanje() {
		return g * Math.abs( Math.sin(Math.toRadians(nagib))); 
	}
	

}
