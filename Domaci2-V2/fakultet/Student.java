package fakultet;

public class Student extends Osoba {

	private static int id = 0;
	private int godinaUpisa;
	private int brojIndeksa;
	
	
	public Student(String i, String p, int gu) {
		super(i, p);
		godinaUpisa = gu;
		brojIndeksa = id++;
	}

	@Override
	public char getOznaka() {
		return 'S'; 
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(godinaUpisa).append("/");
		sb.append(String.format("%04d", brojIndeksa));
		sb.append(" - ").append(super.toString());
		return sb.toString();
	}
}
