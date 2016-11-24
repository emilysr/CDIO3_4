package felter;

import entity.Spiller;

public class Grund extends Ejerskab {

	private int leje;
	
	public Grund(String felttype, int pris, int leje) {
		super(felttype, pris);
		this.leje = leje;
	}

	@Override
	public int getLeje() {
		return leje;
	}

	@Override
	public void landPaaFelt(Spiller spiller) {
		
	}

	
}
