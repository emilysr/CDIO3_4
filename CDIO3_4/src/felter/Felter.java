package felter;

import entity.Spiller;

import java.awt.Color;

import entity.Konto;
import entity.Mui;
import entity.Terning;

public abstract class Felter {
	
	public Color farve;

	private String feltType;
	
	public Felter (String type) {
		this.feltType = type;
	}
	
	public String getType() {
		return feltType;
	}
	
	
	abstract public void landPaaFelt (Spiller spiller, Mui mui);
	
	abstract public String subtekst();
	
	abstract public String getbeskrivelse();
	
	abstract public Color getColor();

}