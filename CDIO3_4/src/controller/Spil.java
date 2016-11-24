package controller;

import java.util.ArrayList;
import java.util.Scanner;

import entity.*;
import felter.Ejerskab;
import felter.Felter;

public class Spil {

	// Initialiseringer
	int antalSp; 
	int tur = 0;
	Konto konto = new Konto();
	Terning terning = new Terning (); 
	ArrayList <Spiller> spillere = new ArrayList <Spiller> ();
	Scanner scan = new Scanner(System.in);
	Spilleplade plade = new Spilleplade();


	// Spillerantal og navne
	public void setSpillerAntal () {
		do {
			antalSp = scan.nextInt();
			if (antalSp > 1 && antalSp < 7){ // Antal spillere mellem 2 og 6
				for (int i=0; i< antalSp; i++) { //Første spillers index er 0
					String navn = scan.next(); // Scanner for navn
					spillere.add(new Spiller ()); // Tilføjer spiller
					spillere.get(i).setNavn(navn); 
				
				}

			}
			// teskst 
		} while (antalSp < 2 || antalSp > 6);


	}

	// Henter spiller antal
	public int getSpillerAntal () {  
		return antalSp;
	}


	// Kører spil
	public void runSpil () {   
		setSpillerAntal();


		while (getSpillerAntal() != 1 ) {
			skiftTur();
		}
		// Hvilken spiller vandt?
		
	}

	public void skiftTur() {
		for (int j = 0; j < getSpillerAntal(); j++) {
			//spilTur(j);
		}


	}
	
	

	public void spilTur(Spiller i) {

		terning.roll();
		int slag = terning.getFaceValue();                             // Får terningværdi
		int nytfelt = (i.getPosition()+slag)%plade.getPlade().length;  // Spilleren rykker rundt på pladen
		i.setPosition(nytfelt);                                        // Spilleren lander på felt
		Felter felt = plade.getPlade() [nytfelt];
		if (felt instanceof Ejerskab) {                               // Hvis feltet er den del af ejerskab, skal dette udføres
			Ejerskab ejerFelt = (Ejerskab) felt;

		if(i.getKonto().pengeNok(ejerFelt.getPris()))
			//tekst Vil du købe feltet?
			if(!ejerFelt.alleredeEjet()){
				
				String svar = scan.next();
				if(svar.equalsIgnoreCase("n")) // GUIen erstater dette input
					return;
				else 
					ejerFelt.koebFelt(i); //misvisende men passer!
				
//
//			}else{
//				// spiller balance - feltafgift (eventuelt noget hvis der ejes flere felter) 
//				// Hvis der er en ejer, betal leje . 
//			}
		}

		//Tjek for om spilleren taber
		if(konto.tjekBankerot() == true)
			ejerFelt.nulstilEjerskab(); 	//smide ud og nulstil felter.
		



	//	if (konto.tjekBankerot == true) { // Tjek wincondition
			//Print du har vundet
		}
			System.exit(0);
		

	

	}
}
