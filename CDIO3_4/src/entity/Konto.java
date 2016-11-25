package entity;

public class Konto {

	private int balance;
	
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
	
	public boolean tjekBankerot () {
		if (balance < 0)
			return true;
		else
			return false; 
	}
	
	public boolean pengeNok(int pris){
		if (balance >= pris)
			return true;
		else return false;
	}
}
