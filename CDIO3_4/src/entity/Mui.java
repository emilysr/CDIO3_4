package entity;

import java.awt.Color;

import desktop_codebehind.Car;
import desktop_fields.Field;
import desktop_fields.Start;
import desktop_fields.Street;
import desktop_resources.GUI;

public class Mui {

	public void lavbraet(Spilleplade spillet){
		
		Field[] felter = new Field [22];
		
		felter[0] = new Start.Builder().
				setTitle("Start").
				setBgColor(Color.RED).
				setDescription("").
				setSubText("").
				build();
		
		for(int i = 1 ; i < spillet.plade.length; i++){
			felter[i] = new Street.Builder().
					setTitle(spillet.plade[i].getType().toString()).
					setSubText(spillet.plade[i].subtekst().toString()).
					setDescription(spillet.plade[i].getbeskrivelse().toString()).
					setBgColor(spillet.plade[i].getColor()).
					setRent(null).
					build();
		}
		GUI.create(felter);
				
				
	}
	public void test(String msg)
	{
		GUI.getUserString(msg);
		
	}
	
	public void spilTur(Spiller spiller, int feltnummer,int terning1, int terning2){
		fjernBiler(spiller);
		int nytfelt = feltnummer;
		rykBil(spiller, nytfelt);
		setTerninger(terning1, terning2);
		
	}
	
//	Tilføjer en spiller og en bil til spillet
	public void addSpiller(Spiller spiller)
	{
		Car car = new Car.Builder().build();
		GUI.addPlayer(spiller.getNavn(), spiller.getBalance() , car);
	}

	
//	Sætter en spiller på start feltet
	public void setPaaStart(Spiller spiller){
		GUI.setCar(1, spiller.getNavn());
	}
	
//	Printer en spillers balance
	public void getBalance(Spiller spiller){
		GUI.setBalance(spiller.getNavn(), spiller.getBalance());
	}
	
	// Fjerner alle biler for den spiller
	public void fjernBiler(Spiller spiller){
		GUI.removeAllCars(spiller.getNavn());
	}
	
//	En knap retunere ikke noget
	public void getEnKnap(String besked, String knap ){
		GUI.getUserButtonPressed(besked, knap);
	}
	
//	To knapper - retunere enten true eller false
	public boolean getToKnap(String besked, String KnapTrue, String KnapFalse){
		return GUI.getUserLeftButtonPressed(besked, KnapTrue, KnapFalse);
	}
	
//	Printer tekst i midten
	public void midtBeskrivelse(String tekst){
		GUI.displayChanceCard(tekst);
	}
	
//	Rykker en bil til det valgte felt
	public void rykBil(Spiller spiller, int felt){	
		GUI.setCar(felt + 1, spiller.getNavn());
	}

	public void setTerninger(int terning1, int terning2){
		GUI.setDice(terning1, terning2);
	}
	
	public void fjernSpiller(Spiller spiller){
		GUI.setBalance(spiller.getNavn(), 0);
		fjernBiler(spiller);		
		
	}
	
	public void fjernEjer(int i){
		GUI.setHouses(i+1, 0);
		GUI.setOwner (i+1, "");
		}
	}


