package model;
import java.util.LinkedList;
import java.util.List;

import app.Starter;

public class Fronta {
	List<Zprava> fronta = new LinkedList<Zprava>();

	public synchronized Zprava vyjmout() { 
		if(fronta.size() > 0)
		{
			try {
				return fronta.remove(0); 
			} catch (IndexOutOfBoundsException e) {
				//todo
			}
		}
		return null; 
	}

	public synchronized void vlozit(Zprava zprava) {
		fronta.add(zprava);
	}
}