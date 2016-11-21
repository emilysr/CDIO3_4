package felter;

import entity.Spiller;

public abstract class Ejerskab extends Felter {

	private int pris;
	private Spiller ejer;
//	private Spiller 
	
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
		}
		
	}

