package entity;

import felter.Arbejdslejr;
import felter.Felter;
import felter.Flaade;
import felter.Grund;
import felter.Helle;
import felter.Skat;
import felter.Start;
import sprog.Tekst;

public class Spilleplade {

	Felter plade [] = new Felter[22];
	
	public Felter[] getPlade() {
		return plade;
	}
	
	public Spilleplade  (){
		plade[0] = new Start(Tekst.toString(41)); 
		plade[1] = new Grund(Tekst.toString(42),1000, 100);
		plade[2] = new Grund(Tekst.toString(43),1500, 300);
		plade[3] = new Grund(Tekst.toString(44),2000, 500);
		plade[4] = new Grund(Tekst.toString(45),3000, 700);
		plade[5] = new Grund(Tekst.toString(46),4000, 1000);
		plade[6] = new Grund(Tekst.toString(47),4300, 1300);
		plade[7] = new Grund(Tekst.toString(48),4750, 1600);
		plade[8] = new Grund(Tekst.toString(49),5000, 2000);
		plade[9] = new Grund(Tekst.toString(50),5500, 2600);
		plade[10] = new Grund(Tekst.toString(51),6000, 3200);
		plade[11] = new Grund(Tekst.toString(52),8000, 4000);
		plade[12] = new Helle(Tekst.toString(53), 5000 );
		plade[13] = new Helle(Tekst.toString(54),500 );
		plade[14] = new Arbejdslejr (Tekst.toString(55),2500);
		plade[15] = new Arbejdslejr (Tekst.toString(56),2500);
		plade[16] = new Skat (Tekst.toString(57), 2000, false );
		plade[17] = new Skat (Tekst.toString(58), 4000, true );
		plade[18] = new Flaade (Tekst.toString(59),4000);
		plade[19] = new Flaade (Tekst.toString(60),4000);
		plade[20] = new Flaade (Tekst.toString(61),4000);
		plade[21] = new Flaade (Tekst.toString(62),4000);
		
	}
	
	public Felter getFelt(int i) {
		return plade [i];
	}
}
