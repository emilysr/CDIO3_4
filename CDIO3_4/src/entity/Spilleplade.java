package entity;

import felter.Arbejdslejr;
import felter.Felter;
import felter.Flaade;
import felter.Grund;
import felter.Helle;
import felter.Skat;

public class Spilleplade {

	private Felter plade [] = new Felter[22];
	
	public Felter[] getPlade() {
		return plade;
	}

	public Spilleplade  (){
		plade[0] = new Helle ("Start", 0);
		plade[1] = new Grund("Stammelejr",100, 1000);
		plade[2] = new Grund("Krater",300, 1500);
		plade[3] = new Grund("Bjerg",500, 2000 );
		plade[4] = new Grund("Kold ørken",700, 3000 );
		plade[5] = new Grund("Sort grotte",1000, 4000 );
		plade[6] = new Grund("Varulvemuren",1300, 4300 );
		plade[7] = new Grund("Bjerg landsbyen",1600, 4750 );
		plade[8] = new Grund("Sydlige citadel",2000, 5000 );
		plade[9] = new Grund("Palads porte",2600, 5500 );
		plade[10] = new Grund("Tårn",3200, 6000 );
		plade[11] = new Grund("Slot",4000, 8000 );
		plade[12] = new Helle("Indhegnede by", 5000 );
		plade[13] = new Helle("Kloster",500 );
		plade[14] = new Arbejdslejr ("Hytter i bjergene", 2500);
		plade[15] = new Arbejdslejr ("Pitten",2500 );
		plade[16] = new Skat ("Guldmine", false );
		plade[17] = new Skat ("Karavane",true );
		plade[18] = new Flaade ("Anden Sejl",4000 );
		plade[19] = new Flaade ("Havets Grover",4000 );
		plade[20] = new Flaade ("de Buccaneers",4000 );
		plade[21] = new Flaade ("Privateer armade",4000 );
		
	
		
	}
}
