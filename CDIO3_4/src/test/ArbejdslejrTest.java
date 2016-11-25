package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entity.*;
import felter.*;

public class ArbejdslejrTest {

	private Arbejdslejr arbejdslejr, arbejdslejr2;
	private Spiller spiller;
	private Spiller spiller2;
	ArrayList <Spiller> spillere = new ArrayList <Spiller> ();
	Konto konto = new Konto();
	Terning terning = new Terning();

	@Before
	public void setUp () throws Exception {
		spillere.add(new Spiller ());
		spillere.get(0).setNavn("Kurt");
		this.spiller = spillere.get(0); 
		spillere.add(new Spiller ());
		spillere.get(1).setNavn("Anders");
		this.spiller2 = spillere.get(1); 
		this.arbejdslejr = new Arbejdslejr("Lejr", 2500);
		this.arbejdslejr2 = new Arbejdslejr("Sommercamp", 2500);
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
		Assert.assertNotNull(this.spiller2);

		Assert.assertNotNull(this.arbejdslejr);
		Assert.assertNotNull(this.arbejdslejr2);

		Assert.assertTrue(this.arbejdslejr instanceof Arbejdslejr);
		Assert.assertTrue(this.arbejdslejr2 instanceof Arbejdslejr);
	}

	@Test
	public void KoebOgEjerEnLejrTest() {
		int Sp1Expected = 30000, Sp2Expected = 30000; 
		int Sp1Reel = this.spiller.getBalance();
		int Sp2Reel = this.spiller2.getBalance();
		Assert.assertEquals(Sp1Expected, Sp1Reel);
		Assert.assertEquals(Sp2Expected, Sp2Reel);

		this.arbejdslejr.koebFelt(spiller);
		Sp1Expected -= this.arbejdslejr.getPris();
		Sp1Reel = this.spiller.getBalance();
		Assert.assertEquals(Sp1Expected, Sp1Reel);

		this.arbejdslejr.landPaaFelt(spiller2);
		Sp2Expected -= this.arbejdslejr.getLeje();
		Sp2Reel = this.spiller2.getBalance();
		Assert.assertEquals(Sp2Expected, Sp2Reel);

	}

	@Test
	public void KoebOgEjerToLejreTest() {
		int Sp1Expected = 30000, Sp2Expected = 30000; 
		int Sp1Reel = this.spiller.getBalance();
		int Sp2Reel = this.spiller2.getBalance();
		Assert.assertEquals(Sp1Expected, Sp1Reel);
		Assert.assertEquals(Sp2Expected, Sp2Reel);

		this.arbejdslejr.koebFelt(spiller);
		Sp1Expected -= this.arbejdslejr.getPris();
		Sp1Reel = this.spiller.getBalance();
		Assert.assertEquals(Sp1Expected, Sp1Reel);

		this.arbejdslejr2.koebFelt(spiller);
		Sp1Expected -= this.arbejdslejr2.getPris();
		Sp1Reel = this.spiller.getBalance();
		Assert.assertEquals(Sp1Expected, Sp1Reel);

		this.arbejdslejr2.landPaaFelt(spiller2);
		Sp2Expected -= this.arbejdslejr.getLeje();
		Sp2Reel = this.spiller2.getBalance();
		Assert.assertEquals(Sp2Expected, Sp2Reel);

	}

}
