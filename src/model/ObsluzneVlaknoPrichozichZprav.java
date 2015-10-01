package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import model.Zprava;
import app.Starter;

public class ObsluzneVlaknoPrichozichZprav implements Runnable{
	final int PORT = 5000;
	ObjectInputStream ois;
	ServerSocket serverSocket;
	Socket socket;
	Zprava zprava;
	private Thread thread;
	
	public ObsluzneVlaknoPrichozichZprav() {
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread = new Thread(this);
	}
	@Override
	public void run() {
		while (true) {
			try {
				socket = serverSocket.accept();
				try {
					ois = new ObjectInputStream(socket.getInputStream());
					zprava = (Zprava) ois.readObject();
					Agent.najdi(zprava.komu).fronata.vlozit(zprava);
					
				} catch (ClassNotFoundException | IOException e) {
					e.printStackTrace();
					//TODO výpis problém se streamem
				}
			} catch (IOException e) {
				e.printStackTrace();
				//TODO výpis nepodaøilo se navázat spojení s jiným nodem
			}
		}		
	}
	public void Start(){
		thread.start();
	}
}
