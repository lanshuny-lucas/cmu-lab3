package lab3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestFraction {

	@Test
	public void test1_Constructors() {
		Fraction f1 = new Fraction();
		assertEquals(1, f1.getNumerator());
		assertEquals(1, f1.getDenominator());
		Fraction f2 = new Fraction(3, 4);
		assertEquals(3, f2.getNumerator());
		assertEquals(4, f2.getDenominator());
	}
	
	@Test
	public void test2_FractionsHeldInLowestTerms() {
		Fraction f1 = new Fraction (2, 4);
		assertEquals(1, f1.getNumerator());
		assertEquals(2, f1.getDenominator());
		Fraction f2 = new Fraction (4, 2);
		assertEquals(2, f2.getNumerator());
		assertEquals(1, f2.getDenominator());
	}

	@Test
	public void test3_GCDWithDivisor() {
		assertEquals("Testing 12/4 ", 4, Fraction.findGCD(12,4));
	}
	
	@Test
	public void test4_GCDWithSmallerNumerator() {
		assertEquals("Testing 5/15 ", 5, Fraction.findGCD(5, 15));
	}
	@Test
	public void test5_GCDWithDenominatorZero() {
		assertEquals("Testing 1/0 ", 1, Fraction.findGCD(1,0));
	}
	
	@Test
	public void test6_GCDWithNumeratorZero() {
		assertEquals("Testing 0/1 ", 1, Fraction.findGCD(0,1));
	}
	
	@Test
	public void test7_GCDWithoutDivisor() {
		assertEquals("Testing 13/7 ", 1, Fraction.findGCD(13,7));
	}
	
	@Test
	public void test8_ToString() {
		Fraction f = new Fraction(13, 7);
		assertEquals("Testing toString", "13/7", f.toString());
	}
	
	@Test
	public void test9_Add() {
		Fraction f1 = new Fraction (1, 2);
		Fraction f2 = new Fraction (3, 4);
		Fraction f3 = f1.add(f2);
		assertEquals(5, f3.getNumerator());
		assertEquals(4, f3.getDenominator());
	}

	@Test
	public void test10_ToDecimal() {
		Fraction f = new Fraction (1, 2);
		assertEquals(0.5, f.toDecimal(), 0D);		
	}

	@Test
	public void test11_MixedFraction_NonDefaultConstructor() {
		MixedFraction mf = new MixedFraction(3, 1, 2);
		assertEquals(3, mf.getNaturalNumber());
		assertEquals(1, mf.getNumerator());
		assertEquals(2, mf.getDenominator());
	}
	
	@Test
	public void test12_MixedFraction_toString() {
		MixedFraction mf = new MixedFraction(3, 1, 2);
		assertEquals("3 1/2", mf.toString());
	}
	
	@Test
	public void test13_MixedFraction_toDecimal() {
		MixedFraction mf = new MixedFraction(3, 1, 2);
		assertEquals(3.5, mf.toDecimal(), 0);
	}
	
	@Test
	public void test14_AddMixedFraction() {
		MixedFraction mf1 = new MixedFraction(1, 1, 2);
		MixedFraction mf2 = new MixedFraction(1, 1, 3);
		Fraction f = mf1.add(mf2);
		assertEquals(17, f.getNumerator());
		assertEquals(6, f.getDenominator());
	}
	

}
