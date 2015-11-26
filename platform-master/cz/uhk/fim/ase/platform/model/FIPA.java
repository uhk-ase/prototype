package cz.uhk.fim.ase.platform.model;

public class FIPA {
	public int FIPA(Zprava zprava) {
		switch (zprava.typ) {
		case "Accept_Proposal":
			//P�ij�m� p�edlo�en� n�vrh k proveden� akce.
			break;
			
		case "Agree":
			//Souhlas� s proveden�m n�jak� akce.
			break;
			
		case "Cancel":
			//Informuje o tom, �e ji� nehodl� prov�d�t d��ve po�adovanou akci.
			break;
			
		case "Call_for_Proposal":
			//Vyz�v� k p�edlo�en� n�vrh� na proveden� dan� akce.
			break;
			
		case "Failure":
			//Informuje agenta o tom, �e do�lo k pokusu o proveden� akce, av�ak pokus byl ne�sp�n�.
			break;
			
		case "Inform":
			//Zas�l� pozitivn� informativn� zpr�vu.
			break;
		
		case "Refuse":
			//Zam�t� proveden� dan� akce a pod�v� vysv�tlen�.
			break;
			
		case "Reject_Proposal":
			//Zam�t� n�vrh na proveden� n�jak� akce b�hem vyjedn�v�n�.
			break;
			
		case "Request":
			//Odes�l� po�adavek na proveden� dan� akce.
			break;
			
		default:
			break;
		}
		
		return (Integer) null;
	}
	
}
