package test;

import org.junit.Assert;
import org.junit.Test;
import entity.Terning;

public class TerningTest {

	@Test
	public void test() {
		Terning test = new Terning();
		
		//Initialisere vores variable
		boolean end2 = false; int to = 0;
		boolean end3 = false; int tre = 0; 
		boolean end4 = false; int fire = 0; 
		boolean end5 = false; int fem = 0;
		boolean end6 = false; int seks = 0;
		boolean end7 = false; int syv = 0;
		boolean end8 = false; int otte = 0;
		boolean end9 = false; int ni = 0;
		boolean end10 = false; int ti = 0;
		boolean end11 = false; int elleve = 0;
		boolean end12 = false; int tolv = 0; 
		  
		int i = 0;
		
		// Løkke for vores terning, sat til at slå 100.000 gange
		while(i<100000)
		{
			switch (test.roll())
			{
			case 2 : to++;
			break;
			case 3 : tre++;
			break;
			case 4 : fire++;
			break;
			case 5 : fem++;
			break;
			case 6 : seks++;
			break;
			case 7 : syv++;
			break;
			case 8 : otte++;
			break;
			case 9 : ni++;
			break;
			case 10 : ti++;
			break;
			case 11 : elleve++;
			break;
			case 12 : tolv++;
			break;
			}
			i++;
			
		
		}
		
		/* Vores terning skulle have en statistik korrekt afvigelse indenfor 4%
		 * Der er udregnet en afvigelses værdi og sat som kommentar til hver terning værdi.
		 */
		if(to>2668 && to<2892) // 112
			end2 = true;
		else 
			end2 = false;
		
		if(tre>5348 && tre<5782) // 222
			end3 = true;
		else 
			end3 = false;
		
		if(fire>7997 && fire<8663) // 333
			end4 = true;
		else 
			end4 = false;
		
		if(fem>10776 && fem<11554) // 444
			end5 = true;
		else 
			end5 = false;
		
		if(seks>13344 && seks<14446) // 556
			end6 = true;
		else 
			end6 = false;
		
		if (syv>16003 && syv<17337) // 667
			end7 = true;
		else 
			end7 = false;
		
		if (otte>13344 && otte<14446) // 556
			end8 = true;
		else 
			end8 = false;
		
		if (ni>10776 && ni<11554) // 444
			end9 = true;
		else
			end9 = false;
		
		if (ti>7997 && ti<8663) // 333
			end10 = true;
		else 
			end10 = false;
		
		if (elleve>5348 && elleve<5782) // 222
			end11 = true;
		else
			end11 = false; 
		
		if (tolv>2668 && tolv<2892) // 112
			end12 = true; 
		else 
			end12 = false; 
		

			System.out.println("to = " + to);
			Assert.assertTrue(end2);
			System.out.println("tre = " + tre);
			Assert.assertTrue(end3);
			System.out.println("fire = " + fire);
			Assert.assertTrue(end4);
			System.out.println("fem = " + fem);
			Assert.assertTrue(end5);
			System.out.println("seks = " + seks);
			Assert.assertTrue(end6);
			System.out.println("syv = " + syv);
			Assert.assertTrue(end7);
			System.out.println("otte = " + otte);
			Assert.assertTrue(end8);
			System.out.println("ni = " + ni);
			Assert.assertTrue(end9);
			System.out.println("ti = " + ti);
			Assert.assertTrue(end10);
			System.out.println("elleve = " + elleve);
			Assert.assertTrue(end11);
			System.out.println("tolv = " + tolv);
			Assert.assertTrue(end12);

	}

}
