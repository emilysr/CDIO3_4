package test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import entity.*;
import felter.*;

public class FlaadeTest {

	private Flaade flaade, flaade2;
	private Spiller spiller, spiller2;
   	ArrayList <Spiller> spillere = new ArrayList <Spiller> ();
   	Konto konto = new Konto();
	
	@Before
	public void setUp() throws Exception {
		spillere.add(new Spiller ());
		spillere.get(0).setNavn("Kurt");
		this.spiller = spillere.get(0);
		spillere.add(new Spiller ());
		spillere.get(1).setNavn("Anders And");
		this.spiller2 = spillere.get(1);
		this.flaade = new Flaade("Scandlines", 4000);
		this.flaade2 = new Flaade("Mols-linien", 4000);
	}
	
	@After
	public void tearDown() throws Exception {
		spillere.add(new Spiller ());
		spillere.get(0).setNavn("Kurt");
		this.spiller = spillere.get(0);
		spillere.add(new Spiller ());
		spillere.get(1).setNavn("Anders And");
		this.spiller2 = spillere.get(1);
	}
	
	@Test
	public void notNulltest() {
		Assert.assertNotNull(this.spiller);
		Assert.assertNotNull(this.spiller2);
      	
      	Assert.assertNotNull(this.flaade);
      	Assert.assertNotNull(this.flaade2);

      	Assert.assertTrue(this.flaade instanceof Flaade);    	
      	Assert.assertTrue(this.flaade2 instanceof Flaade);
	}
	
	@Test
	public void testLandPaaFeltEjerAfEn() {
		int Sp1Expected = 30000, Sp2Expected = 30000;
		int Sp1Reel = this.spiller.getBalance();
		int Sp2Reel = this.spiller2.getBalance();
		Assert.assertEquals(Sp1Expected, Sp1Reel);
		Assert.assertEquals(Sp2Expected, Sp2Reel);
		
		this.flaade.koebFelt(spiller);
		Sp1Expected -= this.flaade.getPris();
		Assert.assertEquals(Sp1Expected, Sp1Reel);
		
		this.flaade.landPaaFelt(spiller2);
		Sp2Expected -= this.flaade.getLeje();
		Assert.assertEquals(Sp2Expected, Sp2Reel);
	}

	@Test
	public void testLandPaaFeltEjerAfto() {
		int Sp1Expected = 30000, Sp2Expected = 30000;
		int Sp1Reel = this.spiller.getBalance();
		int Sp2Reel = this.spiller2.getBalance();
		Assert.assertEquals(Sp1Expected, Sp1Reel);
		Assert.assertEquals(Sp2Expected, Sp2Reel);
		
		this.flaade.koebFelt(spiller);
		Sp1Expected -= this.flaade.getPris();
		Assert.assertEquals(Sp1Expected, Sp1Reel);
		
		this.flaade2.koebFelt(spiller);
		Sp1Expected -= this.flaade.getPris();
		Assert.assertEquals(Sp1Expected, Sp1Reel);		
		
		this.flaade.landPaaFelt(spiller2);
		Sp2Expected -= this.flaade.getLeje();
		Assert.assertEquals(Sp2Expected, Sp2Reel);
	}

}
