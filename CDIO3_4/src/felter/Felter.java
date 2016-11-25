package felter;

import entity.Spiller;

import java.awt.Color;

import entity.Konto;
import entity.Mui;
import entity.Terning;

// abstract felt, alle felter arver fra Felter
public abstract class Felter {
	
	public Color farve;

	private String feltType;
	
// Konstruktør
	public Felter (String type) {
		this.feltType = type;
	}
	
// getType retunere felttypen
	public String getType() {
		return feltType;
	}
	
// abstracte metoder der anvendes i alle ikke abstracte felter
	abstract public void landPaaFelt (Spiller spiller, Mui mui);
	
	abstract public String subtekst();
	
	abstract public String getbeskrivelse();
	
	abstract public Color getColor();

}
