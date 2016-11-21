package felter;

import entity.Spiller; 

public class Helle extends Felter {

	private int gevinst;

	public Helle(String feltType, int gevinst) {

		super(feltType);
		this.gevinst=gevinst;
	}
	
	public int getGevist () {
		return gevinst;
	}
	


	@Override
	public void landPaaFelt(Spiller spiller) {
		spiller.aendreBalance(gevinst);
	
		
	}
	
	
}
