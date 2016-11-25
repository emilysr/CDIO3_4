package felter;

import desktop_resources.GUI;
import entity.Spiller;

// Ejerskab feltet, arver fra Felter og arves til Grund, Flåde og arbejdeslejr
public abstract class Ejerskab extends Felter {

	private int pris;
	protected Spiller ejer;
	
// Kontruktør
	public Ejerskab(String feltType, int pris) {
		super(feltType);
		this.pris = pris;
		this.ejer = null;
	}
	
	public abstract int getLeje();
	
// boolean metode der retunere false så længe feltet ikke ejes af en spiller
	public boolean alleredeEjet() {
		if (ejer == null)
			return false;
		return true;
	}

// getEjer retunere ejeren
	public Spiller getEjer () {
		return ejer;
	}
	
// getPris retunere prisen
	public int getPris(){
		return pris;
	}

// købfelt, angiver ejeren og ændren spillerens balance med prisen på feltet
// printer et hus på guien og farver kanten med spillerens farve
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

