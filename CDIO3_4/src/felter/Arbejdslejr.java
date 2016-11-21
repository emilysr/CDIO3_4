package felter;

import entity.Spiller;

public class Arbejdslejr extends Ejerskab {
	
	private int standardLeje;
	private int terningSum;
	
//	public Arbejdslejr(){
//		super();
//	}
	
	public Arbejdslejr(String feltType, int pris) {
		super(feltType, pris);
		this.standardLeje = 100;
	}
	
	public int getLeje(int terningSum){
		int antalArbejdslejr = super.getEjer().getAntalArbejdslejre();
		int leje = standardLeje * terningSum * antalArbejdslejr;
		return leje; 
	
		
	}
	
	public void koebFelt (Spiller spiller) {
		super.koebFelt(spiller);
		spiller.setAntalArbejdslejr();
	}


	@Override
	public int getLeje() {
		return 0;
	}

	@Override
	public void landPaaFelt(Spiller spiller) {
		
	}
}
