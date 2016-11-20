package Felter;

import Entity.Spiller;
import Entity.Konto;
import Entity.Terning;

public abstract class Felter {

	private String feltType;
	
	public Felter (String type) {
		this.feltType = type;
	}
	
	public String getType() {
		return feltType;
	}
	
	public abstract int getleje();
	
	abstract public void landPaaFelt (Spiller spiller);
}
