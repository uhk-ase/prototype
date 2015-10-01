package app;

import java.util.LinkedList;
import java.util.List;

import GUI.hlavniGUI;
import model.Agent;
import model.Fronta;
import model.ObsluzneVlaknoOdchozichZprav;
import model.ObsluzneVlaknoPrichozichZprav;
import model.PracovniVlakno;

public class Starter {
	public static int pocetAgentuNaNodu =  100000;
	public static int pocetAgentuNaVlakno = 10000;

	String IP = "192.168.0.";
	int pocetNodu;
	int kolikaty;
	ObsluzneVlaknoPrichozichZprav ovpz;
	ObsluzneVlaknoOdchozichZprav ovoz;
	static hlavniGUI gui;
	
	public Starter(hlavniGUI gui) {
		this.gui = gui;		
	}

	public void faze1(int pN, int k) {
		pocetNodu = pN;
		kolikaty = k;

		List<Agent> list = new LinkedList<Agent>();
		for (int i = (k-1)*pocetAgentuNaNodu; i < (k-1)*pocetAgentuNaNodu + pocetAgentuNaNodu; i++) {
			list.add(new Agent(i, "test", "test", "test", new LinkedList<Agent>(), new LinkedList<String>(), new Fronta()));
		}
		
		for(int i = 0; i < 3;i++){
			new PracovniVlakno(list.subList(i*pocetAgentuNaVlakno, i*pocetAgentuNaVlakno + pocetAgentuNaVlakno-1));			
		}
		ovoz = new ObsluzneVlaknoOdchozichZprav();
		ovpz = new ObsluzneVlaknoPrichozichZprav();
	}

	public void faze2() {		
		ovpz.Start();
		ovoz.start();	
		
		for (PracovniVlakno p : Main.PRACOVNI_VLAKNA) {
			System.out.println(p.thread.getState().toString());
			//p.start();
		}
	}
    static public void vypisMain(String text){
    	gui.vypisGUI(text);    	
    }
}
