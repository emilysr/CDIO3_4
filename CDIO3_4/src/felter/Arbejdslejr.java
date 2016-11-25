package felter;

import java.awt.Color;

import desktop_resources.GUI;
import entity.Mui;
import entity.Spiller;
import entity.Terning;
import sprog.Tekst;

public class Arbejdslejr extends Ejerskab {
	
	private int standardLeje;
	private int pris;
	public Color farve = Color.PINK;
	public Terning terning= new Terning();
	
	public Arbejdslejr(String feltType, int pris) {
		super(feltType, pris);
		this.standardLeje = 100;
		this.pris = pris;
	}
	
	public int getLeje(Mui mui){
		terning.roll();
		int leje = standardLeje * terning.getFaceValue() * ejer.getAntalArbejdslejre();
		mui.setTerninger(terning.getDice1(), terning.getDice2());
		return leje; 
	
		
	}
	
	public void koebFelt (Spiller spiller) {
		super.koebFelt(spiller);
		spiller.setAntalArbejdslejr();
	}



	@Override
	public String subtekst() {
		
		return "???";
	}

	@Override
	public String getbeskrivelse() {
		
		return Tekst.toString(63);
	}

	@Override
	public int getLeje() {
		return 0;
	}
	
	@Override
	public Color getColor() {
		return farve;
	}

	public void landPaaFelt(Spiller spiller, Mui mui) {
		mui.midtBeskrivelse(Tekst.toString(38));
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
				mui.midtBeskrivelse(Tekst.toString(32));
				mui.getEnKnap(Tekst.toString(22), Tekst.toString(7));
				mui.midtBeskrivelse(Tekst.toString(33));
				mui.getEnKnap(Tekst.toString(81), Tekst.toString(82));
				int beløb = getLeje(mui);
		mui.midtBeskrivelse(Tekst.toString(68) + beløb);
		spiller.aendreBalance(-beløb);
		this.ejer.aendreBalance(beløb);
		GUI.setBalance(spiller.getNavn(), spiller.getBalance());
		GUI.setBalance(ejer.getNavn(), ejer.getBalance());
		mui.midtBeskrivelse(Tekst.toString(63) + beløb);
			}}}
	
}
