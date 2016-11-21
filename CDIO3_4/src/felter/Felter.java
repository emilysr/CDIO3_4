package felter;

import entity.Spiller;
import entity.Konto;
import entity.Terning;

public abstract class Felter {

	private String feltType;
	
	public Felter (String type) {
		this.feltType = type;
	}
	
	public String getType() {
		return feltType;
	}
	
	
	abstract public void landPaaFelt (Spiller spiller);
}
