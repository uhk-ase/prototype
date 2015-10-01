package model;

import java.io.Serializable;

public class AbstractZprava implements Serializable {
	String ipOdesilatele;
	String ipPrijemce;
	String obsah;
	String typ;
	
	public AbstractZprava(String ipOdesilatele, String ipPrijemce, String obsah, String typ) {
		super();
		this.ipOdesilatele = ipOdesilatele;
		this.ipPrijemce = ipPrijemce;
		this.obsah = obsah;
		this.typ = typ;
	}
}
