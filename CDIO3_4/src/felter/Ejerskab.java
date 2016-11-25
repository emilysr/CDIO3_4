package felter;

import desktop_resources.GUI;
import entity.Spiller;

public abstract class Ejerskab extends Felter {

	private int pris;
	protected Spiller ejer;
	
	public Ejerskab(String feltType, int pris) {
		super(feltType);
		this.pris = pris;
		this.ejer = null;
	}
	
	public abstract int getLeje();
	
	public boolean alleredeEjet() {
		if (ejer == null)
			return false;
		return true;
	}
	
	public Spiller getEjer () {
		return ejer;
	}
	
	public int getPris(){
		return pris;
	}

	public void koebFelt (Spiller spiller) {
		ejer = spiller;
		ejer.aendreBalance(-pris);
		GUI.setHouses(spiller.getPosition()+1, 1);
		GUI.setOwner(spiller.getPosition()+1, spiller.getNavn());
		}
	
	public void nulstilEjerskab () {
			ejer = null; 
		}
	
	}

