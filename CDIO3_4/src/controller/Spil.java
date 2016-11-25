package controller;

import java.util.ArrayList;
import java.util.Scanner;

import desktop_codebehind.Player;
import entity.*;
import felter.Ejerskab;
import felter.Felter;
import sprog.Tekst;

public class Spil {
	
// Konstruere en ny Mui
	Mui mui = new Mui();

	int antalSp; 
	int tur = 0;
	Konto konto = new Konto();
	Terning terning = new Terning (); 
	ArrayList <Spiller> spiller = new ArrayList <Spiller> ();
	Scanner scan = new Scanner(System.in);
	Spilleplade plade = new Spilleplade();


	// Spillerantal og navne
	public void setSpillerAntal () {
			System.out.println(Tekst.toString(1));
			System.out.println(Tekst.toString(2));
			System.out.println(Tekst.toString(4));
		do {
			this.antalSp = scan.nextInt();
			if (antalSp < 2 | antalSp > 6) // Antal spillere mellem 2 og 6
				System.out.println(Tekst.toString(5));
			
			} while (antalSp < 2 || antalSp > 6);
			
			for (int i=0; i< antalSp; i++) { //Første spillers index er 0
					System.out.println(Tekst.toString(3) + (i+1));
					String navn = scan.next(); // Scanner for navn
					spiller.add(new Spiller ()); // Tilføjer spiller
					spiller.get(i).setNavn(navn); 
				
				}

	}

	// Henter spiller antal
	public int getSpillerAntal () {  
		return antalSp;
	}


	// Kører spil
	public void runSpil () {
		
		// Vælg sprog inden spillet kan begynde
		System.out.println("Vælg sprog/Choose language");
		System.out.println("Dansk/English");
		
		Tekst.vaelgsprog(scan.next());
				
		// Tilføjer alle spiller med navn
		setSpillerAntal();
		
		// printer gui brættet
		Spilleplade braet = new Spilleplade();
		mui.lavbraet(braet);
		
		// printer spillerne i guien
		for(int i = 0 ; i < antalSp ; i++){
			mui.addSpiller(spiller.get(i));
			mui.setPaaStart(spiller.get(i));
		}

		// spillet fortsætter så længe ingen har vundet
		while (findVinder(antalSp) == false){

			skiftTur();
		}
		
		// printer vinderen
		mui.midtBeskrivelse(Tekst.toString(83) + getVinder());
		
	}

	// skifter tur mellem alle spillere, men springer spillere over der er gået bankerot
	public void skiftTur() {
		
		for (int j = 0; j < getSpillerAntal(); j++) {
			if(spiller.get(j).getBankerot() == false){
			spilTur(spiller.get(j));
			}
		
		
		}

	}
	
	// Spiller en spillers tur
	public  void spilTur(Spiller spiller) {

		// angiver en spiller har fået en tur
		mui.getEnKnap(Tekst.toString(22), Tekst.toString(7));
		
		terning.roll();
		
		int slag = terning.getFaceValue();                             // Får terningværdi
		
		int nytfelt = (spiller.getPosition()+slag)%plade.getPlade().length;  // Spilleren rykker rundt på pladen
		
		spiller.setPosition(nytfelt);             			// Spilleren lander på felt
		
		mui.spilTur(spiller, nytfelt, terning.getDice1(), terning.getDice2()); // printer turen i guien
		
		Felter felt = plade.getPlade() [nytfelt];
		
		felt.landPaaFelt(spiller,mui);		// landpåfelt metoden kaldt for feltet
		
		spiller.bankerot(spiller.getBalance()); // er spilleren bankerot?
		
		fjernEjer(spiller.getBankerot(), spiller); // hvis bankerot - fjern spiller
		
		
	}
		
	// finder en vinder hvis der kun er en spiller som ikke er bankerot
	
	public boolean findVinder(int antalSp){
		int spillere = 0;
		boolean vinder = false;
		for(int i = 0 ; i < antalSp ; i++){
			if(spiller.get(i).getBankerot() == false){
				spillere++;
			}}
			if(spillere == 1){
				vinder = true;
		}
		return vinder;
		}
	
	// printer vinderen
	
	public String getVinder(){
			String vinder = "";
				for(int j = 0 ; j < antalSp ; j++){
					if(spiller.get(j).getBankerot() == false){
						vinder = spiller.get(j).getNavn();
					}
				}
		return vinder;
	}
	
	// fjerner en spiller i guien, og sætter balance til 0 og fjerner huse og grænse farver
	public void fjernEjer(boolean bankerot, Spiller spiller){
		if(bankerot == true){
			for( int i = 0 ; i < 22 ; i++){
			if ( plade.getFelt(i) instanceof Ejerskab){
				if(((Ejerskab) plade.getFelt(i)).getEjer() == spiller)
			((Ejerskab) plade.getFelt(i)).nulstilEjerskab(); 
				mui.fjernEjer(i);
			}
		}
			mui.fjernBiler(spiller);
			spiller.getKonto().setBalanceNul();
			mui.getBalance(spiller);
			
			
	}
}}
