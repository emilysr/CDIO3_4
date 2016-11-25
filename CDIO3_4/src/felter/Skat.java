package felter;

import java.awt.Color;
import java.util.Scanner;

import desktop_resources.GUI;
import entity.Mui;
import entity.Spiller;
import sprog.Tekst;

// Skatte feltet har to felter hvor det ene felt giver muligheden for indten at betale 4000 eller 10 % af ens balance
// og det andet felt kræver en betaling på 2000
public class Skat extends Felter {

	Scanner scan = new Scanner(System.in);
	int skat;
	final int skatprocenten = 10;
	boolean skatprocent;
	
	public Color farve = Color.YELLOW;

// Kontruktør for Skat feltet, arver fra Felter
	public Skat(String feltNavn,int skat, boolean skatprocent){
		super(feltNavn);
		this.skatprocent = skatprocent;
		this.skat = skat;
	}
// Landpåfelt metoden er metoden der angiver alt der sker når en spiller lander på feltet
// Er ikke lavet efter GRASP på grund af tidspress

	public void landPaaFelt(Spiller spiller, Mui mui){
		mui.midtBeskrivelse(Tekst.toString(71));
		
		if (skatprocent == true){
				mui.midtBeskrivelse(Tekst.toString(28) + Tekst.toString(29) + Tekst.toString(30));
			if (mui.getToKnap(Tekst.toString(64), "10 %", "4000") == true){
				mui.midtBeskrivelse(Tekst.toString(30) + getProcent(spiller));
				BetalTilProcent(spiller);
				GUI.setBalance(spiller.getNavn(), spiller.getBalance());
			}
			else{
				mui.midtBeskrivelse(Tekst.toString(28));
				betalFeltPris(spiller);
				GUI.setBalance(spiller.getNavn(), spiller.getBalance());
			}
		}
		else{
			mui.midtBeskrivelse(Tekst.toString(80));
			betalFeltPris(spiller);
			GUI.setBalance(spiller.getNavn(), spiller.getBalance()); 
		}



	}

// Metode der trækker 10 % af en spillers balance fra hans balance
	public void BetalTilProcent(Spiller spiller){
		spiller.aendreBalance(-(spiller.getBalance()/skatprocenten));
	}
// Metode der retunere beløbet som svare til 10 % af spillerens balance
	public int getProcent (Spiller spiller){
		int getProcent = spiller.getBalance()/skatprocenten;
		return getProcent;
	}

// Metode der trækker 'skat' variablen fra spillers balance
	public void betalFeltPris (Spiller spiller){
		spiller.aendreBalance(-skat);
	}
	
// Metode der retunere skat
	public int getPris(){
		return skat;
	}
	
// Subteksten bruges til guien
	@Override
	public String subtekst() {
		
		String subtekst;
		
		if (skatprocent == true)
			subtekst = Tekst.toString(64);
		else{
			subtekst = Tekst.toString(65);
		}
		
		return subtekst;
	}

// getbeskrivelse bruges også til guien
	@Override
	public String getbeskrivelse() {
		
		String skat;
		
		if (skatprocent == true)
			skat = Tekst.toString(64);
		else{
			skat = Tekst.toString(65);
		}
		
		return Tekst.toString(71) + Tekst.toString(74) + skat;
	}
	
// getColor metode der retunere farven på feltet
	@Override
	public Color getColor() {
		return farve;
	}
	
}


