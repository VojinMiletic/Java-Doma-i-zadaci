package paket;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

@SuppressWarnings("serial")
public class Simulacija extends Frame {

	/*private String oblik = "Disk"; // Modifikacija
	
	void setOblik(String s){
		oblik = s;
	}*/
	
	private Scena scena;
	public Simulacija() {
		scena = new Scena(this);
		
		this.setBounds(400, 200, 500, 500);
		this.add(scena);
		
		this.setTitle("Simulacija");
		
		scena.setFocusable(true);
		scena.pokreni();
		
		/*
		//Modifikacija
		Choice izaberiOblik = new Choice();
		izaberiOblik.add("Disk");
		izaberiOblik.add("Zvezda");
		izaberiOblik.add("Tocak");
		
		izaberiOblik.addItemListener((il)->{
			String izbor = izaberiOblik.getSelectedItem();
			setOblik(izbor);
		});
		
		
		scena.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				double x = e.getX();
				double y = e.getY();
				
				switch(oblik) {
				case("Disk"):
					scena.dodajFiguru(new Disk(new Vektor(x,y), new Vektor()));
					break;
				case("Zvezda"):
					scena.dodajFiguru(new Zvezda(new Vektor(x,y), new Vektor()));
					break;
				case("Tocak"):
					scena.dodajFiguru(new Tocak(new Vektor(x,y), new Vektor(), (int)(Math.random() * (30-10) + 10))); // Generisemo 
					break;															//tockove izmedju 10 i 30
				}
				
			}
		});
		
		this.add(izaberiOblik, BorderLayout.SOUTH);
		
		*/
		scena.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(e.getButton() == e.BUTTON3) { // Desni kliks
				double x = e.getX();
				double y = e.getY();
				scena.dodajFiguru(new Disk(new Vektor(x,y), new Vektor())); }
			}
		});
		
		scena.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case KeyEvent.VK_SPACE:
					scena.pauza(); 
					break;
				case KeyEvent.VK_ESCAPE:
					scena.zavrsi();
					dispose();
					break;
				}
			}
		});
		
		/*
		// Modifikacija
		
		MenuItem zatvori = new MenuItem("Zatvori");
		zatvori.setShortcut(new MenuShortcut(KeyEvent.VK_Q));
		zatvori.addActionListener((al)->{
			scena.zavrsi();
			dispose();
		});
		Menu meni = new Menu("Akcija");
		meni.add(zatvori);
		MenuBar traka = new MenuBar();
		traka.add(meni);
		this.setMenuBar(traka);
		*/
		this.setResizable(false);
		this.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		
		new Simulacija();

	}

}
