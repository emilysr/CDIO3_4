package felter;

import java.util.Scanner;

import entity.Spiller;

public class Skat extends Felter {

	Scanner scan = new Scanner(System.in);
	int skat1 = 2000;
	int skat2 = 4000;
	int skatprocenten = 10;
	boolean skatprocent;


	public Skat(String feltNavn, boolean skatprocent){
		super(feltNavn);
		this.skatprocent = skatprocent;
	}

	public void landPaaFelt(Spiller spiller){
		if (skatprocent == true){
			// Spørg om 4000 eller 10 %
			String svar = scan.next();
			if (svar == "ja")
				spiller.aendreBalance(-(spiller.getBalance()/10));
			else{
				spiller.aendreBalance(-skat2);
			}
		}
		else{
			spiller.aendreBalance(-skat1);
		}



	}
}


