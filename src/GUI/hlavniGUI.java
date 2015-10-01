package GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import app.Starter;

public class hlavniGUI extends JFrame {
	Starter st;
	
	private JLabel l1 = new JLabel("Zadejte poèet nodù: ");
	private JTextField t1 = new JTextField(5);

	private JLabel l2 = new JLabel("Zadejte kolikátý v poøadí je tento nod: ");
	private JTextField t2 = new JTextField(5);
	
	private JButton b1 = new JButton("zahájit fázi 1");
	private JButton b2 = new JButton("zahájit fázi 2");
	private JTextArea ta = new JTextArea(25,55);
	private JScrollPane sp = new JScrollPane(ta);
	
	public hlavniGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(720, 500); 
		setVisible(true);
		b1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				b1.setEnabled(false);
				st.faze1(Integer.valueOf(t1.getText()), Integer.valueOf(t2.getText()));
				b2.setEnabled(true);
			}
		});
		b2.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				st.faze2();
				b2.setEnabled(false);
			}
		});
		b2.setEnabled(false);
		
		double k = Math.PI;
		
		//testing
		/*
		t1.setText("2");
		t2.setText("1");
		*/
		
		setLayout(new BorderLayout());
		Container c1 = new Container();
		c1.setLayout(new FlowLayout());
		c1.add(l1);
		c1.add(t1);
		c1.add(l2);
		c1.add(t2);
		c1.add(b1);
		c1.add(b2);
		Container c2 = new Container();
		c2.setLayout(new FlowLayout());
		c2.add(sp);
		add(c1,BorderLayout.NORTH);
		add(c2,BorderLayout.CENTER);		
	}
	public Starter getSt() {
		return st;
	}
	public void setSt(Starter st) {
		this.st = st;
	}
	public synchronized void vypisGUI(String text ){
		ta.append(text + "\n");
	}
}
