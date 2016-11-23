package controller;

import java.util.ArrayList;
import java.util.Scanner;

import entity.*;
import felter.Ejerskab;

public class Spil {
	
	int antalSp; 
	int tur = 0;
	Terning terning = new Terning (); 
	ArrayList <Spiller> spillere = new ArrayList <Spiller> ();
	Scanner scan = new Scanner(System.in);
	Spilleplade plade = new Spilleplade();
	
	

	
	// Kast terninger
	
	// Noget med mulighed for at købe 
	
	// Set position
	
	
	// Tjek win condition
	
	
	
	
	
	public void setSpillerAntal () {
		do {
			antalSp = scan.nextInt();
			if (antalSp > 1 && antalSp < 7){
				for (int i=0; i< antalSp; i++) { //Første spillers index er 0
				String navn = scan.next();
				spillere.add(new Spiller ());
				spillere.get(i).setNavn(navn);
				// DELETE
				System.out.println(spillere.toString());
				}
				
			};
// teskst 
		} while (antalSp < 2 || antalSp > 6);
		

	}
	
	public int getSpillerAntal () {
		return antalSp;
	}
	
	
	public void runSpil () {
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
		int slag = terning.getFaceValue();
		int nytfelt = (i.getPosition()+slag)%plade.getPlade().length;
		i.setPosition(nytfelt);
		
		
		
		//if (i.getPosition().alleredeEjet() == false) {
			//Mulighed for at købe
			
	//	else 
			
		//	;
			//Betale leje
		
			//Få/betal banken.
			
		}		
		//Tjek for om spilleren taber
	
	
	
	
//	public void skiftTur () {
//			do {
//				tur = (tur + 1) % spiller.length
//			}
//	}
}
