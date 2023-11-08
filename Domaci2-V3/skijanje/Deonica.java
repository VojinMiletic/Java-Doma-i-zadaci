package skijanje;

public abstract class Deonica {

	protected double duzina;
	protected double nagib;
	
	public Deonica(double d, double n) {
		duzina = d; nagib = n;
	}
	
	public double duzina() {
		return this.duzina;
	}
	public double nagib() {
		return this.nagib;
	}
	
	public abstract char oznaka();
	public abstract double ubrzanje();
	
	public double brzina(double pocetna) {
		return Math.sqrt(2 * this.ubrzanje() * duzina
				+ pocetna*pocetna); 
	}
	
	public double vreme(double pocetna) {
		return (this.brzina(pocetna) - pocetna) / this.ubrzanje(); 
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.oznaka()).append("(")
		.append(duzina).append(",").append(nagib)
		.append(")");
		return sb.toString();
	}
}
