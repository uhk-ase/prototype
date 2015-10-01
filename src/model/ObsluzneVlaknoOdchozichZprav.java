package model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import app.Starter;

public class ObsluzneVlaknoOdchozichZprav implements Runnable {

	
	private String ID;
	private Boolean running = false;
	private Thread thread;
	
	private final int PORT = 5000;
	
	public static Fronta queue;
	
	public ObsluzneVlaknoOdchozichZprav(){
		queue = new Fronta();
		thread = new Thread(this);
	} 
	
	public ObsluzneVlaknoOdchozichZprav(Fronta q){
		this.queue = q;
		thread = new Thread();
	}
	
	public void setQueue(Fronta q){
		this.queue = q;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			Zprava m = queue.vyjmout();
			if(m != null){
				String pom;
				pom = String.valueOf(((int)(m.komu / Starter.pocetAgentuNaNodu)) + 1);
				try(Socket s = new Socket("192.168.0." + pom , PORT)){
					try(ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream())){
						oos.writeObject((Object)m);
						oos.flush();
					}					
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				try {
					thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void start(){
		thread.start();
	}
	
	public void stop(){
		if(running){
			running = false;
			try {
				thread.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
