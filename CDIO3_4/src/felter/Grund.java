package felter;

import java.awt.Color;
import controller.Spil;
import desktop_resources.GUI;
import entity.Mui;
import entity.Spiller;
import sprog.Tekst;

public class Grund extends Ejerskab {

	private int leje;
	private int pris;
	private Color farve;
	
	public Grund(String felttype, int pris, int leje) {
		super(felttype, pris);
		this.leje = leje;
		this.pris = pris;
		this.farve = Color.BLUE;
		
	}
	
	public int getPris() {
		return pris;
	}

	@Override
	public int getLeje() {
		return leje;
	}

	@Override
	public void landPaaFelt(Spiller spiller, Mui mui) {
			mui.midtBeskrivelse(Tekst.toString(36));
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


	@Override
	public String subtekst() {
		String substekst = "" + getPris();
		return substekst.toString();
	}

	@Override
	public Color getColor()
	{
		return farve;
	}


	@Override
	public String getbeskrivelse() {
		// TODO Auto-generated method stub
		return Tekst.toString(66) + Tekst.toString(67) + getLeje() + Tekst.toString(68) + getPris();
	}

	
}
