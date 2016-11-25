package felter;

import java.awt.Color;
import java.util.Scanner;

import desktop_resources.GUI;
import entity.Mui;
import entity.Spiller;
import sprog.Tekst;

public class Skat extends Felter {

	Scanner scan = new Scanner(System.in);
	int skat;
	final int skatprocenten = 10;
	boolean skatprocent;
	
	public Color farve = Color.YELLOW;


	public Skat(String feltNavn,int skat, boolean skatprocent){
		super(feltNavn);
		this.skatprocent = skatprocent;
		this.skat = skat;
	}

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

	
	public void BetalTilProcent(Spiller spiller){
		spiller.aendreBalance(-(spiller.getBalance()/skatprocenten));
	}
	
	public int getProcent (Spiller spiller){
		int getProcent = spiller.getBalance()/skatprocenten;
		return getProcent;
	}
	
	public void betalFeltPris (Spiller spiller){
		spiller.aendreBalance(-skat);
	}
	public int getPris(){
		return skat;
	}
	
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
	
	@Override
	public Color getColor() {
		return farve;
	}
	
}


