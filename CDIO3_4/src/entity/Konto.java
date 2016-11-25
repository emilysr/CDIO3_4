package entity;

public class Konto {

	private int balance;
	
	// Sætter spillerens startkonto til at være på 30000
	public Konto () {
		balance = 30000;
	}
	
	public void setBalance (int balance) {
		this.balance = balance;
	}
	
	public void setBalanceNul(){
		balance = 0;
	}
	
	public void aendreBalance (int værdi) {
		this.balance = this.balance + værdi;
	}
	
	public int getBalance () {
		return balance;
	}
	
	public String toString () {
		return ("" + getBalance());
	}
	
	// Tester for bankerot ved at se om spillerens balance er under 0
	public boolean tjekBankerot () {
		if (balance < 0)
			return true;
		else
			return false; 
	}
	
	// Tjekker om spilleren har penge nok til at købe feltet, ved at se om balancen er større end prisen på feltet
	public boolean pengeNok(int pris){
		if (balance >= pris)
			return true;
		else return false;
	}
}
