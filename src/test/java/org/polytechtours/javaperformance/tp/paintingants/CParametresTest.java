package org.polytechtours.javaperformance.tp.paintingants;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CParametresTest {
	
	private static CPainting mPainting;
	private static PaintingAnts pApplis;
	private static CParametres parametres;
	private static String param1;
	private static String param2; 
	private static String param3;
	private static String param4;
	private static String param5;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		pApplis = new PaintingAnts();
		mPainting = new CPainting(new Dimension(), pApplis);
		parametres = new CParametres(mPainting, pApplis);
		
		param1 = "3";
		param2 = "3:1";
		param3 = "3:-4";
		param4 = "3:7.8";
		param5 = "3:7";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testReadFloatParameterAvecUnSeulChiffre() {
		assertEquals(3, parametres.readFloatParameter(param1));
	}
	
	@Test
	void testReadFloatParameterIntervalleAvecDeuxièmeChiffreInferieurAuPremier() {
		assertEquals(3, parametres.readFloatParameter(param2));
	}
	
	@Test
	void testReadFloatParameterIntervalleAvecDeuxièmeChiffreNegatifInferieurAuPremier() {
		assertEquals(3, parametres.readFloatParameter(param3));
	}
	
	@Test
	void testReadFloatParameterIntervalAvecDeuxièmeChiffreSuperieurAuPremier() {
		assertThat(parametres.readFloatParameter(param4), anyOf(is(3.0f), is(7.8f), is(allOf(greaterThan(3.0f), lessThan(7.8f)))));
	}

	@Test
	void testReadIntParameterAvecUnSeulChiffre() {		
		assertEquals(3, parametres.readIntParameter(param1));
	}
	
	@Test
	void testReadIntParameterIntervalleAvecDeuxièmeChiffreInferieurAuPremier() {
		assertEquals(3, parametres.readIntParameter(param2));
	}
	
	@Test
	void testReadIntParameterIntervalleAvecDeuxièmeChiffreNegatifInferieurAuPremier() {
		assertEquals(3, parametres.readIntParameter(param3));
	}
	
	@Test
	void testReadIntParameterIntervalAvecDeuxièmeChiffreSuperieurAuPremier() {
		assertThat(parametres.readIntParameter(param5), anyOf(is(3), is(7), is(allOf(greaterThan(3), lessThan(7)))));
	}

}
