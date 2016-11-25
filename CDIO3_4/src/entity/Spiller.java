package entity;

public class Spiller {

	private int position;
	private int antalFlaade; 
	private int antalArbejdslejre;
	private String navn = ""; 
	private Konto konto;
	private boolean bankerot = false;
	
	
	
	public Konto getKonto() {
		return konto;
	}

	public void setKonto(Konto konto) {
		this.konto = konto;
	}

	public Spiller () {
		
		this.konto = new Konto();
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
	
	public void aendreBalance (int vaerdi){
		konto.aendreBalance(vaerdi);
	}
	
	public int getBalance() {
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
	
	public boolean getBankerot(){
		return bankerot;
	}
	
	public void bankerot(int balance){
		if(balance < 0){
			this.bankerot = true;
		}
	}
}
