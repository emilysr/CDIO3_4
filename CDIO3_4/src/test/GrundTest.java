package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entity.*;
import felter.*;

public class GrundTest {

	private Grund grund;
	private Spiller spiller;
	private Spiller spiller2;
   	ArrayList <Spiller> spillere = new ArrayList <Spiller> ();
   	Konto konto = new Konto();
	
	
	@Before
	public void setUp () throws Exception {
		spillere.add(new Spiller ());
		spillere.get(0).setNavn("Kurt");
		this.spiller = spillere.get(0); 
		spillere.add(new Spiller ());
		spillere.get(1).setNavn("Anders");
		this.spiller2 = spillere.get(1); 
		this.grund = new Grund("Byggegrund", 5000, 1500);
	}
	
	@After
	public void tearDown () throws Exception {
		spillere.add(new Spiller ());
		spillere.get(0).setNavn("Kurt");
		this.spiller = spillere.get(0); 
		spillere.add(new Spiller ());
		spillere.get(1).setNavn("Anders");
		this.spiller2 = spillere.get(1);
	}
	
	@Test
	public void notNulltest() {
		Assert.assertNotNull(this.spiller);
      	
      	Assert.assertNotNull(this.grund);
      	
      	Assert.assertTrue(this.grund instanceof Grund);
	}
	
	
	@Test
	public void KoebAfGrundTest() {
		int Sp1Expected = 30000, Sp2Expected = 30000; 
		int Sp1Reel = this.spiller.getBalance();
		int Sp2Reel = this.spiller2.getBalance();
		Assert.assertEquals(Sp1Expected, Sp1Reel);
		Assert.assertEquals(Sp2Expected, Sp2Reel);
		
		this.grund.koebFelt(spiller);
		Sp1Expected -= this.grund.getPris();
		Sp1Reel = this.spiller.getBalance();
		Assert.assertEquals(Sp1Expected, Sp1Reel);
		
		this.grund.landPaaFelt(spiller2);
		Sp2Expected -= this.grund.getLeje();
		Sp2Reel = this.spiller2.getBalance();
		Assert.assertEquals(Sp2Expected, Sp2Reel);
	}
}