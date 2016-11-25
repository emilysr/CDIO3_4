package felter;

import java.awt.Color;

import desktop_resources.GUI;
import entity.Mui;
import entity.Spiller;
import sprog.Tekst; 

// Helle feltet, arver fra felter 
// retunere et given beløb når der landes på det
public class Helle extends Felter {

	private int gevinst;
	private Color farve = Color.GREEN;
	
// Konstruktøren
	public Helle(String feltType, int gevinst) {

		super(feltType);
		this.gevinst=gevinst;
	}
	
// getGevinst, retunere gevinsten
	public int getGevinst () {
		return gevinst;
	}
	
// Landpåfelt metoden, alt hvad der sker når en spiller lander på feltet

	public void landPaaFelt(Spiller spiller, Mui mui) {
		mui.midtBeskrivelse(Tekst.toString(78));
		mui.getEnKnap(Tekst.toString(75) + getGevinst(), Tekst.toString(79));
		spiller.aendreBalance(gevinst);
		GUI.setBalance(spiller.getNavn(), spiller.getBalance());
	}

// subtekst bruges til guien
	@Override
	public String subtekst() {
		String subtekst = "" + getGevinst();
		return subtekst;
	}

// getbeskrivelse bruges til guien
	@Override
	public String getbeskrivelse() {

		return Tekst.toString(70) + Tekst.toString(75) + getGevinst();
	}

// getColor retunere feltets farve og bruges i guien
	@Override
	public Color getColor() {
		return farve;
	}
	
	
}
