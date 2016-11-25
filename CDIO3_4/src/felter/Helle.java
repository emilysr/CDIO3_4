package felter;

import java.awt.Color;

import desktop_resources.GUI;
import entity.Mui;
import entity.Spiller;
import sprog.Tekst; 

public class Helle extends Felter {

	private int gevinst;
	private Color farve = Color.GREEN;
	
	public Helle(String feltType, int gevinst) {

		super(feltType);
		this.gevinst=gevinst;
	}
	
	public int getGevinst () {
		return gevinst;
	}
	
	public void landPaaFelt(Spiller spiller, Mui mui) {
		mui.midtBeskrivelse(Tekst.toString(78));
		mui.getEnKnap(Tekst.toString(75) + getGevinst(), Tekst.toString(79));
		spiller.aendreBalance(gevinst);
		GUI.setBalance(spiller.getNavn(), spiller.getBalance());
	}

	@Override
	public String subtekst() {
		String subtekst = "" + getGevinst();
		return subtekst;
	}

	@Override
	public String getbeskrivelse() {

		return Tekst.toString(70) + Tekst.toString(75) + getGevinst();
	}

	@Override
	public Color getColor() {
		return farve;
	}
	
	
}
