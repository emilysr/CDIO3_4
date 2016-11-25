package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controller.Spil;
import entity.*;
import felter.*;

public class HoldScoreTest {	
	
	private Spiller spiller;
	private Skat skat;
	ArrayList <Spiller> spillere = new ArrayList <Spiller> ();
	Konto konto = new Konto();
	Spil spil = new Spil (); 
	
	@Before
	public void setUp () {
		spillere.add(new Spiller ());
		spillere.get(0).setNavn("Kurt");
		this.spiller = spillere.get(0);
		this.skat = new Skat("Test", 5000, false);
	}
	
	@After
	public void tearDown () {
		spillere.add(new Spiller ());
		spillere.get(0).setNavn("Kurt");
		this.spiller = spillere.get(0);
	}
	
	@Test
	public void HoldScoreNegTest() {
		int expected = 30000; 
		int reel = this.spiller.getBalance();
		Assert.assertEquals(expected, reel);
		
		for (int i = 1; i < 100; i++) {
			this.skat.landPaaFelt(spiller);
			spil.fjernEjer(true, this.spiller);
			expected = 0;
			reel = this.spiller.getBalance();
			Assert.assertEquals(expected, reel);
		}
		
	}

}
