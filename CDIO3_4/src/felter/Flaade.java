package felter;

import entity.Spiller;

public class Flaade extends Ejerskab{

	final private int leje1 = 500;
	final private int leje2 = 1000;
	final private int leje3 = 2000;
	final private int leje4 = 4000;

	public Flaade(String feltType, int pris){
		super(feltType, pris);


	}
	public int getLeje(){
		int antalFlaade = super.getEjer().getAntalFlaade();
		int leje;

		switch(antalFlaade){
		case 1: 
			leje = leje1;
			break;
		case 2: 
			leje = leje2;
			break;
		case 3: 
			leje = leje3;
			break;
		case 4: 
			leje = leje4;
			break;
		default: leje = 0;
		}
		return leje;

	}


	@Override
	public void landPaaFelt(Spiller spiller) {
		// TODO Auto-generated method stub

	}



}
