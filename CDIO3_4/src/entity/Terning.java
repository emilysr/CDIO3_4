package entity;

public class Terning {
	
	/*
	 * Den maksimale værdi terningen kan slå, lavet som final int
	 * En variabel med den nuværende øjen værdi
	 */
	private final int MAX = 6; 	
	private int faceValue; 
	private int dice1, dice2;

	/* Vores konstruktør */
	public Terning() {
		faceValue = 0;
	}
	
	/* Kaster terninger og returner øjenværdi */
	public int roll() {
		dice1 = (int)(Math.random() * MAX) + 1;
		dice2 = (int)(Math.random() * MAX) + 1;
		faceValue= dice1 + dice2;
		return faceValue;
	}

	public int getDice2() {
		return dice2;
	}
	
	public int getDice1() {
		return dice1;
	}
	
	/* Henter øjen-værdien */
	public int getFaceValue() {
		return faceValue;
	}
	
	
}