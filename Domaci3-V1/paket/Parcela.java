package paket;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Parcela extends Label {

	private char oznaka;
	private Color boja;
	private static final Font font = new Font("Serif", Font.BOLD, 14);
	
	public Parcela(char o, Color b) {
		super(String.valueOf(o));
		oznaka = o;
		boja = b;
		this.setAlignment(Label.CENTER);
		this.setFont(font);
		this.setForeground(Color.WHITE);
		this.setBackground(boja);
		
		this.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				Component izvor = (Component) e.getSource();
				Plac roditelj = (Plac)izvor.getParent();
				roditelj.oznaciSelektovanu(Parcela.this);
			}
		});
	}
	
	
	public void promeniPoju(Color c) {
		this.boja = c;
	}
	
	
}
