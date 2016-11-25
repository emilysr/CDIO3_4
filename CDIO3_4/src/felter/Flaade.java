
package felter;

import java.awt.Color;

import desktop_resources.GUI;
import entity.Mui;
import entity.Spiller;
import sprog.Tekst;

public class Flaade extends Ejerskab{

	final private int leje1 = 500;
	final private int leje2 = 1000;
	final private int leje3 = 2000;
	final private int leje4 = 4000;
	
	int pris;
	
	public Color farve = Color.GRAY;

	public Flaade(String feltType, int pris){
		super(feltType, pris);
		this.pris = pris;

	}
	public int getLeje(){
		
		int leje = 0;
		
		if(super.getEjer() != null){
			
		int antalFlaade = super.getEjer().getAntalFlaade();

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
		}}
		
		return leje;

	}


	@Override
	public void landPaaFelt(Spiller spiller, Mui mui) {
		mui.midtBeskrivelse(Tekst.toString(39));
	if(this.ejer == null){
		if(spiller.getKonto().pengeNok(getPris())){
			if(mui.getToKnap(Tekst.toString(14), Tekst.toString(19), Tekst.toString(20)) == true){
				mui.midtBeskrivelse(Tekst.toString(76) + getPris());	
				koebFelt(spiller);
				GUI.setBalance(spiller.getNavn(), spiller.getBalance());
			}	
		else{
				mui.midtBeskrivelse(Tekst.toString(77));
				}}
		else{
				mui.midtBeskrivelse(Tekst.toString(21));
			
		}}
	else{	
			if(this.ejer == spiller){
				mui.midtBeskrivelse(Tekst.toString(16));
			}
			else{
		mui.midtBeskrivelse(Tekst.toString(17));
		mui.getEnKnap(Tekst.toString(22), Tekst.toString(7));
		mui.midtBeskrivelse(Tekst.toString(68) + getLeje());
		spiller.aendreBalance(-getLeje());
		this.ejer.aendreBalance(getLeje());
		GUI.setBalance(spiller.getNavn(), spiller.getBalance());
		GUI.setBalance(ejer.getNavn(), ejer.getBalance());
			}}}

	public void koebFelt (Spiller spiller) {
		super.koebFelt(spiller);
		spiller.setAntalFlaade();
	}
	@Override
	public String subtekst() {
		String subtekst = "500, 1000, 2000, 4000";
		return subtekst;
	}
	@Override
	public String getbeskrivelse() {

		return Tekst.toString(69) + Tekst.toString(67) + 4000 + Tekst.toString(73);
	}

	@Override
	public Color getColor() {
		return farve;
	}
	

}
