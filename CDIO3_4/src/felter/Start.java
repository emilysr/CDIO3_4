package felter;

import java.awt.Color;

import entity.Mui;
import entity.Spiller;

// Feltet er et start felt og derfor skal den ikke gøre noget
// Alle metoder er autogeneret
public class Start extends Felter{

	
	public Start(String feltType){
		super(feltType);
		
	}

	@Override
	public void landPaaFelt(Spiller spiller, Mui mui) {
		
	}

	@Override
	public String subtekst() {
		return null;
	}

	@Override
	public String getbeskrivelse() {
		return null;
	}

	@Override
	public Color getColor() {
		return null;
	}

}

