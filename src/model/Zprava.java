package model;

import java.io.Serializable;

public class Zprava  implements Serializable   {
	static int POCET_ZPRAV = 0;
	static int DEJ_MI_ID(){
		return ++POCET_ZPRAV;
		/*Implementovat FIPA standart*/
	}
	
	int ID;
	String obsah;
	int komu;
	int od;
	String typ;
	
	public Zprava(String obsah, int komu, int od, String typ ) {
		this.obsah = obsah;
		this.ID = DEJ_MI_ID();
		this.komu = komu;
		this.od = od;
		this.typ = typ;
	}
	public String getObsah() {
		return obsah;
	}	
	@Override
	public String toString() {
		return obsah;
	}	
}
