package felter;

import entity.Spiller;

public abstract class Ejerskab extends Felter {

	private int pris;
	private Spiller ejer;
	
	public Ejerskab(String feltType, int pris) {
		super(feltType);
		this.pris = pris;
		this.ejer = null;
	}
	
	public abstract int getLeje();
	
	public boolean alleredeEjet() {
		if (ejer == null) // Hvis der ingen ejer er = false
			return false;
		return true; // Ejet = true
	}
	
	public Spiller getEjer () {
		return ejer;
	}
	
	public void nulstilEjerskab () {
		for (int i=1; i<22; i++) {  //for() Skal løbe alle felterne igennem og nulstille spillerens felter
			ejer = null; 
		}
		
	}
	
	public int getPris(){
		return pris;
	}

	public void koebFelt (Spiller spiller) {
		ejer = spiller;
		ejer.aendreBalance(-pris);
		}
		
	}

