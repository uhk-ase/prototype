package model;

import java.util.LinkedList;
import java.util.List;

import app.Main;

public class PracovniVlakno implements Runnable{
	List<Agent> seznamAgentu;
	public Thread thread;
	
	public PracovniVlakno(List<Agent> seznamAgentu) {
		this.seznamAgentu = seznamAgentu;
		thread = new Thread(this);
		Main.PRACOVNI_VLAKNA.add(this);
	}
	
	public void start(){
		thread.start();
	}
	
	@Override
	public void run() {
		while(true){
			for(Agent abstarctAgent : seznamAgentu){
				abstarctAgent.Do();
			}
			try {
				thread.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
}
