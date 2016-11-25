package felter;

import java.awt.Color;
import controller.Spil;
import desktop_resources.GUI;
import entity.Mui;
import entity.Spiller;
import sprog.Tekst;

// Grund feltet, arver fra ejerskab
public class Grund extends Ejerskab {

	private int leje;
	private int pris;
	private Color farve;
	
// Konstruktør
	public Grund(String felttype, int pris, int leje) {
		super(felttype, pris);
		this.leje = leje;
		this.pris = pris;
		this.farve = Color.BLUE;
		
	}
	
// Metode der retunere prisen
	public int getPris() {
		return pris;
	}

// metode der retunere lejen
	@Override
	public int getLeje() {
		return leje;
	}

// Landpåfelt metoden, gør alt hvad der sker når en spiller lander på feltet
// Ser hvorvidt om feltet ejes, hvis ikke ser om spilleren har råd, hvis ja giver muligheden for at købe feltet
// Hvis feltet ejes ser metoden om det er spilleren selv der ejer feltet eller en anden spiller.
// hvis det er en anden trækkes lejen fra spillerens konto og samme beløb lægges ind på ejerens konto
// Er ikke laver efter GRASP på grund af tidspress
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


// anvendes i gui
	@Override
	public String subtekst() {
		String substekst = "" + getPris();
		return substekst.toString();
	}
// anvendes i gui
	@Override
	public Color getColor()
	{
		return farve;
	}

// anvendes i gui
	@Override
	public String getbeskrivelse() {
		// TODO Auto-generated method stub
		return Tekst.toString(66) + Tekst.toString(67) + getLeje() + Tekst.toString(68) + getPris();
	}

	
}
