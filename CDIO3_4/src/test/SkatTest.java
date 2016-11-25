package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entity.*;
import felter.*;

public class SkatTest {

	private Skat skat, skat2;
	private Spiller spiller;
   	ArrayList <Spiller> spillere = new ArrayList <Spiller> ();
   	Konto konto = new Konto();
	
	
	@Before
	public void setUp () {
		spillere.add(new Spiller ());
		spillere.get(0).setNavn("Kurt");
		this.spiller = spillere.get(0); 
		this.skat = new Skat("Lille", 2000, false);
		this.skat2 = new Skat("Stor", 4000, true);
	}
	
	@After
	public void tearDown () {
		spillere.add(new Spiller ());
		spillere.get(0).setNavn("Kurt");
		this.spiller = spillere.get(0); 		
	}
	
	@Test
	public void notNulltest() {
		Assert.assertNotNull(this.spiller);
      	
      	Assert.assertNotNull(this.skat);
      	Assert.assertNotNull(this.skat2);
      	
      	Assert.assertTrue(this.skat instanceof Skat);
      	Assert.assertTrue(this.skat2 instanceof Skat);
	}
	
	@Test
	public void SkatteFeltEtTest() {
		int Sp1Expected = 30000; 
		int Sp1Reel = this.spiller.getBalance();
		Assert.assertEquals(Sp1Expected, Sp1Reel);
		
		this.skat.landPaaFelt(spiller);
		Sp1Expected -= this.skat.getPris();
		Sp1Reel = this.spiller.getBalance();
		Assert.assertEquals(Sp1Expected, Sp1Reel);
	}
	
	@Test
	public void SkatteFeltToTest() {
		int Sp1Expected = 30000; 
		int Sp1Reel = this.spiller.getBalance();
		Assert.assertEquals(Sp1Expected, Sp1Reel);
		
		Sp1Expected -= this.skat2.getProcent(spiller);
		this.skat2.landPaaFelt(spiller);
		Sp1Reel = this.spiller.getBalance();
		Assert.assertEquals(Sp1Expected, Sp1Reel);
	}
}
