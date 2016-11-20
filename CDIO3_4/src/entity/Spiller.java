package Entity;

public class Spiller {

	private int position;
	private int antalFlaade; 
	private int antalArbejdslejre;
	private String navn = ""; 
	
	public Spiller () {
		
		Konto konto = new Konto();
		position = 0;
		antalFlaade = 0; 
		antalArbejdslejre = 0; 
	}
	
	public void setNavn (String navn) {
		this.navn = navn;
	}
	
	public String getNavn () {
		return navn;
	}
	
	public void setPosition (int nyPosition) {
		this.position = nyPosition;
	}
	
	public int getPosition () {
		return position;
	}
	
	public void aendreBalance (int værdi){
		konto.aendreBalance(værdi);
	}
	
	public int getBalance () {
		return konto.getBalance();
	}
	
	public void setAntalFlaade () {
		antalFlaade = antalFlaade + 1;
	}
	
	public int getAntalFlaade () {
		return antalFlaade; 
	}
	
	public void setAntalArbejdslejr () {
		antalArbejdslejre = antalArbejdslejre + 1;
	}
	
	public int getAntalArbejdslejre () {
		return antalArbejdslejre;
	}
}
