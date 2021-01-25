package org.polytechtours.javaperformance.tp.paintingants;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class PaintingAntsTest {
	private static PaintingAnts pApplis;
	private static String[][] lInfo;
	private static String[][] l1;
	private static String param1;
	private static String param2; 
	private static String param3;
	private static String param4;
	private static String param5;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		pApplis = new PaintingAnts();
		
		lInfo = pApplis.getParameterInfo();

		l1 = new String[][] { { "SeuilLuminance", "string", "Seuil de luminance" },
				{ "Img", "string", "Image" }, { "NbFourmis", "string", "Nombre de fourmis" }, { "Fourmis", "string",
						"Paramètres des fourmis (RGB_déposée)(RGB_suivie)(x,y,direction,taille)(TypeDeplacement,ProbaG,ProbaTD,ProbaD,ProbaSuivre);...;" } };
	
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
	void testCompteur() {
		assertEquals(0, pApplis.getmCompteur());

		pApplis.compteur();

		assertEquals(1, pApplis.getmCompteur());
	}

	@Test
	void testGetParameterInfo() {
		for (int i = 0; i < lInfo.length; ++i) {
			for (int j = 0; j < lInfo[i].length; ++j) {
				assertEquals(l1[i][j], lInfo[i][j]);
			}
		}
	}

	@Test
	void testIncrementFpsCounter() {
		assertEquals(0L, pApplis.getFpsCounter());

		pApplis.IncrementFpsCounter();

		assertEquals(1L, pApplis.getFpsCounter());
	}

	@Test
	void testPause() {
		assertEquals(false, pApplis.ismPause());

		pApplis.pause();

		assertEquals(true, pApplis.ismPause());
	}

	@Test
	void testReadFloatParameterAvecUnSeulChiffre() {
		assertEquals(3, pApplis.readFloatParameter(param1));
	}
	
	@Test
	void testReadFloatParameterIntervalleAvecDeuxièmeChiffreInferieurAuPremier() {
		assertEquals(3, pApplis.readFloatParameter(param2));
	}
	
	@Test
	void testReadFloatParameterIntervalleAvecDeuxièmeChiffreNegatifInferieurAuPremier() {
		assertEquals(3, pApplis.readFloatParameter(param3));
	}
	
	@Test
	void testReadFloatParameterIntervalAvecDeuxièmeChiffreSuperieurAuPremier() {
		assertThat(pApplis.readFloatParameter(param4), anyOf(is(3.0f), is(7.8f), is(allOf(greaterThan(3.0f), lessThan(7.8f)))));
	}

	@Test
	void testReadIntParameterAvecUnSeulChiffre() {		
		assertEquals(3, pApplis.readIntParameter(param1));
	}
	
	@Test
	void testReadIntParameterIntervalleAvecDeuxièmeChiffreInferieurAuPremier() {
		assertEquals(3, pApplis.readIntParameter(param2));
	}
	
	@Test
	void testReadIntParameterIntervalleAvecDeuxièmeChiffreNegatifInferieurAuPremier() {
		assertEquals(3, pApplis.readIntParameter(param3));
	}
	
	@Test
	void testReadIntParameterIntervalAvecDeuxièmeChiffreSuperieurAuPremier() {
		assertThat(pApplis.readIntParameter(param5), anyOf(is(3), is(7), is(allOf(greaterThan(3), lessThan(7)))));
	}

	@Test
	void testUpdateFPSLastFps() {		
		pApplis.setLastFps(4L);
		pApplis.setFpsCounter(6L);
		
		assertEquals(4L, pApplis.getLastFps());
		
		
		pApplis.updateFPS();
		
		assertEquals(6L, pApplis.getLastFps());
	}
	
	@Test
	void testUpdateFPSFpsCounter() {
		pApplis.setLastFps(4L);
		pApplis.setFpsCounter(6L);
		
		assertEquals(6L, pApplis.getFpsCounter());
		
		pApplis.updateFPS();
		
		assertEquals(0L, pApplis.getFpsCounter());

	}
}
