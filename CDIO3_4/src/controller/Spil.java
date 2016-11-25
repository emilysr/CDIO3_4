package controller;

import java.util.ArrayList;
import java.util.Scanner;

import desktop_codebehind.Player;
import entity.*;
import felter.Ejerskab;
import felter.Felter;
import sprog.Tekst;

public class Spil {
	
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
		
		System.out.println("Vælg sprog/Choose language");
		System.out.println("Dansk/English");
		
		Tekst.vaelgsprog(scan.next());
				
		setSpillerAntal();
		
		Spilleplade braet = new Spilleplade();
		mui.lavbraet(braet);
		
		
		for(int i = 0 ; i < antalSp ; i++){
			mui.addSpiller(spiller.get(i));
			mui.setPaaStart(spiller.get(i));
		}

		while (findVinder(antalSp) == false){

			skiftTur();
		}
		
		mui.midtBeskrivelse(Tekst.toString(83) + getVinder());
		
	}

	public void skiftTur() {
		
		for (int j = 0; j < getSpillerAntal(); j++) {
			if(spiller.get(j).getBankerot() == false){
			spilTur(spiller.get(j));
			}
		
		
		}

	}
	
	public  void spilTur(Spiller spiller) {

		mui.getEnKnap(Tekst.toString(22), Tekst.toString(7));
		
		terning.roll();
		
		int slag = terning.getFaceValue();                             // Får terningværdi
		
		int nytfelt = (spiller.getPosition()+slag)%plade.getPlade().length;  // Spilleren rykker rundt på pladen
		
		spiller.setPosition(nytfelt);             							// Spilleren lander på felt
		
		mui.spilTur(spiller, nytfelt, terning.getDice1(), terning.getDice2());
		
		Felter felt = plade.getPlade() [nytfelt];
		
		felt.landPaaFelt(spiller,mui);
		
		spiller.bankerot(spiller.getBalance());
		
		fjernEjer(spiller.getBankerot(), spiller);
		
		
	}
		
		
	
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
	
	public String getVinder(){
			String vinder = "";
				for(int j = 0 ; j < antalSp ; j++){
					if(spiller.get(j).getBankerot() == false){
						vinder = spiller.get(j).getNavn();
					}
				}
		return vinder;
	}
	
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
