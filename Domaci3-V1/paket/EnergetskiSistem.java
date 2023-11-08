package paket;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EnergetskiSistem extends Frame {

	private Baterija baterija;
	private Plac plac;
	
	private void populateWindow() {
		Panel panelZaDugme = new Panel();
		Button dugmeZaDodavanje = new Button("Dodaj");
		
		/*
		//Modifikacije
		Panel donjiPanel = new Panel(new GridLayout());
		

		Panel panelZaIzborParcele = new Panel(new GridLayout(3,1));
		panelZaIzborParcele.setBackground(Color.BLUE);
		Label naslov = new Label("Vrsta parcele: ");
		panelZaIzborParcele.add(naslov);
		CheckboxGroup izborParcele = new CheckboxGroup();
		Checkbox hidroelektrana = new Checkbox("Hidroelektrana", true, izborParcele);
		Checkbox mlin = new Checkbox("Mlin", false, izborParcele);
		
		panelZaIzborParcele.add(hidroelektrana);
		panelZaIzborParcele.add(mlin);
		
		donjiPanel.add(panelZaIzborParcele);
		
		
		
		Panel zaIspisBaterije = new Panel();
		zaIspisBaterije.add(baterija.napunjenost);
		
		donjiPanel.add(zaIspisBaterije);//, FlowLayout.RIGHT);
		
		this.add(donjiPanel, BorderLayout.SOUTH);
		*/
		
		dugmeZaDodavanje.addActionListener((ae) ->{
			//String ime = izborParcele.getSelectedCheckbox().getLabel();
			//if(ime.equals("Hidroelektrana")) {
				Hidroelektrana hidro = new Hidroelektrana(baterija);
				plac.dodajProizvodjaca(hidro);
			//}
			//else if(ime.equals("Mlin")) {
			//	Mlin ml = new Mlin(baterija);
			//	plac.dodajPotrosaca(ml);
			//}
		});
		
		panelZaDugme.add(dugmeZaDodavanje);
		add(panelZaDugme, BorderLayout.NORTH);
		
		//baterija.setPreferredSize(new Dimension(60,100));
		//add(baterija, BorderLayout.EAST);
		add(plac, BorderLayout.CENTER);
		
		/*
		// Dodavanje menija 
		MenuItem akcija = new MenuItem("Ugasi");
		akcija.setShortcut(new MenuShortcut(KeyEvent.VK_Q));
		akcija.addActionListener((ae)->{
			plac.zaustaviProizvodjace();
			plac.zaustaviPotrosace();
			dispose();
		});
		Menu meni = new Menu("Akcija");
		meni.add(akcija);
		MenuBar traka = new MenuBar();
		traka.add(meni);
		this.setMenuBar(traka);
		*/
	}
	
	public EnergetskiSistem(int redovi, int kolone, int kapacitet) {
		baterija = new Baterija(kapacitet);
		plac = new Plac(redovi, kolone);
		
		setBounds(700,200,500,500);
		setResizable(false);
		
		populateWindow();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				plac.zaustaviProizvodjace();
				//plac.zaustaviPotrosace();
				dispose();
			}
		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new EnergetskiSistem(5, 5, 100);
	}
}
