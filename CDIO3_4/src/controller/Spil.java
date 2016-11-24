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
	Terning terning = new Terning (); 
	ArrayList <Spiller> spillere = new ArrayList <Spiller> ();
	Scanner scan = new Scanner(System.in);
	Spilleplade plade = new Spilleplade();


	public void setSpillerAntal () {
		do {
			antalSp = scan.nextInt();
			if (antalSp > 1 && antalSp < 7){ // Antal spillere mellem 2 og 6
				for (int i=0; i< antalSp; i++) { //Første spillers index er 0
					String navn = scan.next(); // Scanner for navn
					spillere.add(new Spiller ()); // Tilføjer spiller
					spillere.get(i).setNavn(navn); 
				
				}

			};
			// teskst 
		} while (antalSp < 2 || antalSp > 6);


	}


	public int getSpillerAntal () {  	// Henter spiller antal
		return antalSp;
	}


	public void runSpil () {    // Sætter spillet igang
		setSpillerAntal();
		System.out.println(plade.toString());



		//spilTur();


		while (true) {
			skiftTur();
		}
	}

	public void skiftTur() {



	}

	public void spilTur(Spiller i) {

		terning.roll();
		int slag = terning.getFaceValue();                             // Får terningværdi
		int nytfelt = (i.getPosition()+slag)%plade.getPlade().length;  // Spilleren rykker rundt på pladen
		i.setPosition(nytfelt);                                        // Spilleren lander på felt
		Felter felt = plade.getPlade() [nytfelt];
		if (felt instanceof Ejerskab) {                               // Hvis feltet er den del af ejerskab, skal dette udføres
			Ejerskab ejerFelt = (Ejerskab) felt;

			if(!ejerFelt.alleredeEjet()){
				// Mulighed for at købe 

				if (i.getKonto().pengeNok(ejerFelt.getPris())){
					// Vil du købe feltet?
				}

			}else{
				// spiller balance - feltafgift (eventuelt noget hvis der ejes flere felter) 
				// Hvis der er en ejer, betal leje . Eller få af banken hvis Helle
			}
		}

		//Tjek for om spilleren taber




		//	public void skiftTur () {
		//			do {
		//				tur = (tur + 1) % spiller.length
		//			}
		//	}

	//	if (konto.tjekBankerot == true) { // Tjek wincondition
			//Print du har vundet

			System.exit(0);
		}

	

	}
}
