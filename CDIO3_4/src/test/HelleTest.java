package test;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import entity.Spiller;
import felter.*;



public class HelleTest {
	
	private Spiller spiller;
   	private Felter helle200;
   	private Felter helle0;
   	private Felter helleNeg200;
   	ArrayList <Spiller> spillere = new ArrayList <Spiller> ();

	@Before
	public void setUp() throws Exception {
		spillere.add(new Spiller ());
		spillere.get(0).setNavn("Kurt");
		this.spiller = spillere.get(0);
      	this.helle200 = new Helle("Helle +200", 200);
      	this.helle0 = new Helle("Helle 0", 0);
      	this.helleNeg200 = new Helle("Helle -200", -200);

	}

	@After
	public void tearDown() throws Exception {
		spillere.add(new Spiller ());
		spillere.get(0).setNavn("Kurt");
		this.spiller = spillere.get(0);

	}

	@Test
	public void test() {
		Assert.assertNotNull(this.spiller);
      	
      	Assert.assertNotNull(this.helle200);
      	Assert.assertNotNull(this.helle0);
      	Assert.assertNotNull(this.helleNeg200);
      	
      	Assert.assertTrue(this.helle200 instanceof Helle);
      	Assert.assertTrue(this.helle0 instanceof Helle);
      	Assert.assertTrue(this.helleNeg200 instanceof Helle);

	}
	
	@Test
	public void testLandOnField200() {
		int expected = 30000;
		int actual = this.spiller.getBalance();
		Assert.assertEquals(expected, actual);
		this.helle200.landPaaFelt(this.spiller);
		expected = 30000 + 200;
		actual = this.spiller.getBalance();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLandOnField200Twice() {
		int expected = 30000;
		int actual = this.spiller.getBalance();
		Assert.assertEquals(expected, actual);
		this.helle200.landPaaFelt(this.spiller);
		this.helle200.landPaaFelt(this.spiller);
		expected = 30000 + 200 + 200;
		actual = this.spiller.getBalance();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLandOnField0() {
		int expected = 30000;
		int actual = this.spiller.getBalance();
		Assert.assertEquals(expected, actual);
		this.helle0.landPaaFelt(this.spiller);
		expected = 30000;
		actual = this.spiller.getBalance();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testLandOnField0Twice() {
		int expected = 30000;
		int actual = this.spiller.getBalance();
		Assert.assertEquals(expected, actual);
		this.helle0.landPaaFelt(this.spiller);
		this.helle0.landPaaFelt(this.spiller);
		expected = 30000;
		actual = this.spiller.getBalance();
		Assert.assertEquals(expected, actual);
	}

}
