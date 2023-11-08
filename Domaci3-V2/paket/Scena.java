package paket;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Frame;
import java.awt.Graphics;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Scena extends Canvas implements Runnable {

	private static final int faktor = 2;
	private boolean ocesDaPauziras = false;
	@SuppressWarnings("unused")
	private Frame prozor;
	private Thread nit = new Thread(this);
	private boolean radi = false;
	private ArrayList<Figura> figure = new ArrayList<>();

	public Scena(Frame prozor) {
		radi = true;
		this.prozor = prozor;
		this.setBackground(Color.GRAY);
		nit.start();
	}

	private void azurirajFiguru(Figura f) {
		double xNovo = f.getVektorPolozaja().getX() + f.getVektorPomeraja().odrediOrt().getX() * faktor;
		double yNovo = f.getVektorPolozaja().getY() + f.getVektorPomeraja().odrediOrt().getY() * faktor;
		f.getVektorPolozaja().setX(xNovo);
		f.getVektorPolozaja().setY(yNovo);
	}

	private void proveriSudaranje(Figura f) {
		double centarX = f.getVektorPolozaja().getX();
		double centarY = f.getVektorPolozaja().getY();
		Vektor ort = f.getVektorPomeraja().odrediOrt();
		double ortX = ort.getX();
		double ortY = ort.getY();
		
		// Provera kolizije izmedju figure i ivica
		
		if(centarX - f.getPoluprecnik() <= 0 ||
				centarX + f.getPoluprecnik() >= this.getWidth()) {
			f.getVektorPolozaja().setX(centarX - f.getPoluprecnik() <= 0 ? 1 + f.getPoluprecnik()  : this.getWidth() - 1 - f.getPoluprecnik()); // Dodao
			f.getVektorPomeraja().setX(-1 * ortX );
			
			/*
			// Modifikacija
			if(f instanceof Zvezda) {
				Zvezda z = (Zvezda)f;
				z.stigaoSamDoBoje = (z.stigaoSamDoBoje + 1) % 3;
				z.setBrojSudara(z.getBrojSudara() + 1);
				if(z.getBrojSudara() >= 3) {
					figure.remove(z);
					return;
				}
			}
			*/
		}
		if(centarY - f.getPoluprecnik() <= 0 ||
				centarY + f.getPoluprecnik() >= this.getHeight()) {
			f.getVektorPolozaja().setY(centarY - f.getPoluprecnik() <= 0 ? 1 + f.getPoluprecnik()  : this.getHeight() - 1 - f.getPoluprecnik()); // Dodao
			f.getVektorPomeraja().setY(-1 * ortY ); 
			
			/*
			// Modifikacija
			if(f instanceof Zvezda) {
				Zvezda z = (Zvezda)f;
				z.stigaoSamDoBoje = (z.stigaoSamDoBoje + 1) % 3;
				z.setBrojSudara(z.getBrojSudara() + 1);
				if(z.getBrojSudara() >= 3) {
					figure.remove(z);
					return;
				}
			}
			*/
		}
		// Treba proveriti koliziju za figure
		
		int indeks = figure.indexOf(f);
		
		for(int i = 0; i < figure.size(); i++) {
			
			if(indeks == i) continue;
			
			Figura fig = figure.get(i);
			if(f.poreklapanjeKruznica(fig) == true) {
				
				
				/*
				// Modifikacija
				
				if(f instanceof Zvezda) {
					
					Zvezda z = (Zvezda)f;
					fig.setBoja(z.getBoja());
					z.stigaoSamDoBoje = (z.stigaoSamDoBoje + 1) % 3;
					z.setBrojSudara(z.getBrojSudara() + 1);
					if(z.getBrojSudara() >= 3) {
						figure.remove(z);
						return;
					}
				}
				if(f instanceof Tocak && fig instanceof Tocak) {
					Tocak t1 = (Tocak) f;
					Tocak t2 = (Tocak) fig;
					if(t1.poluprecnik > t2.poluprecnik || (t1.poluprecnik == t2.poluprecnik && t1.getId() > t2.getId())){
						t2.setVektorPomeraja(new Vektor(t1.getVektorPomeraja().getX(), t1.getVektorPomeraja().getY()));
					}
					else {
						t1.setVektorPomeraja(new Vektor(t2.getVektorPomeraja().getX(), t2.getVektorPomeraja().getY()));
					}
					
				}
				*/
				//else {
					f.getVektorPomeraja().setX(f.getVektorPomeraja().getX() * (-1));
					f.getVektorPomeraja().setY(f.getVektorPomeraja().getY() * (-1));
				//}
				/*
				Vektor normala1 = new Vektor(
						f.getVektorPolozaja().getX() - fig.getVektorPolozaja().getX() ,
						f.getVektorPolozaja().getY() - fig.getVektorPolozaja().getY()  
						);
				
				f.setVektorPomeraja(normala1);
				
				Vektor normala2 = new Vektor(
						fig.getVektorPolozaja().getX() - f.getVektorPolozaja().getX() ,
						fig.getVektorPolozaja().getY() - f.getVektorPolozaja().getY()
						);
				fig.setVektorPomeraja(normala2);
				*/
				
			} 
		}	
	}
	@Override
	public void run() {

		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					while (!radi)
						wait();
				}
				for (int i = 0; i < figure.size(); i++) {
					azurirajFiguru(figure.get(i));
					proveriSudaranje(figure.get(i));
				}
				repaint();
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {}

	}

	@Override
	public synchronized void paint(Graphics g) {
		for (int i = 0; i < figure.size(); i++) {
			figure.get(i).crtaj(g);
		}
		if(ocesDaPauziras == true) {
			radi = false;
			g.setColor(Color.BLACK);
			g.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
			FontMetrics metrics2 = getFontMetrics(g.getFont());
			g.drawString("PAUZA", (this.getWidth() - metrics2.stringWidth("PAUZA"))/2, this.getHeight()/2);
		}
		else {
			nastavi();
		}
	}
	
	public void pauza() {
		if(ocesDaPauziras == true) {
			ocesDaPauziras = false;
		}
		else 
			ocesDaPauziras = true;
		repaint();
	}
	

	public synchronized void dodajFiguru(Figura f) {
		if(radi == true) return; 
		for (int i = 0; i < figure.size(); i++) {
			if (f.poreklapanjeKruznica(figure.get(i)))
				return;
		}

		if (f.getVektorPolozaja().getX() + f.getPoluprecnik() > getWidth() || f.getVektorPolozaja().getX() - f.getPoluprecnik() < 0
				|| f.getVektorPolozaja().getY() + f.getPoluprecnik() > getHeight()
				|| f.getVektorPolozaja().getY() - f.getPoluprecnik() < 0) 
			return;

		figure.add(f);
		repaint();
	}

	public synchronized void pokreni() {
		radi = true;
		notify();
	}	
	

	public synchronized void nastavi() {
		radi = true;
		notify();
	}

	public void zavrsi() {
		radi = false;
		nit.interrupt();
	}

}