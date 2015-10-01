package app;

import java.util.LinkedList;
import java.util.List;

import javax.swing.SwingUtilities;

import model.Agent;
import model.Agent;
import model.PracovniVlakno;
import GUI.hlavniGUI;

public class Main {
	static hlavniGUI gui = new hlavniGUI();
	public static List<PracovniVlakno> PRACOVNI_VLAKNA = new LinkedList<PracovniVlakno>();

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				Starter st = new Starter(gui);
				gui.setSt(st);				
			}
		});
	}

}
