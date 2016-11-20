package Felter;

import Entity.Spiller;

public class Grund extends Ejerskab {

	private int leje;
	
	public Grund(String felttype, int pris, int leje) {
		super(felttype, pris);
		this.leje = leje;
	}

	
}
