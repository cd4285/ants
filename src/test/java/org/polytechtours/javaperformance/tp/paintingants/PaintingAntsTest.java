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

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
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
		PaintingAnts pApplis = new PaintingAnts();

		assertEquals(0, pApplis.getmCompteur());

		pApplis.compteur();

		assertEquals(1, pApplis.getmCompteur());
	}

	@Test
	void testGetParameterInfo() {
		PaintingAnts pApplis = new PaintingAnts();

		String[][] lInfo = pApplis.getParameterInfo();

		String[][] l1 = new String[][] { { "SeuilLuminance", "string", "Seuil de luminance" },
				{ "Img", "string", "Image" }, { "NbFourmis", "string", "Nombre de fourmis" }, { "Fourmis", "string",
						"Paramètres des fourmis (RGB_déposée)(RGB_suivie)(x,y,direction,taille)(TypeDeplacement,ProbaG,ProbaTD,ProbaD,ProbaSuivre);...;" } };

		for (int i = 0; i < lInfo.length; ++i) {
			for (int j = 0; j < lInfo[i].length; ++j) {
				assertEquals(l1[i][j], lInfo[i][j]);
			}
		}
	}

	@Test
	void testIncrementFpsCounter() {
		PaintingAnts pApplis = new PaintingAnts();

		assertEquals(0L, pApplis.getFpsCounter());

		pApplis.IncrementFpsCounter();

		assertEquals(1L, pApplis.getFpsCounter());
	}

	@Test
	void testPause() {
		PaintingAnts pApplis = new PaintingAnts();

		assertEquals(false, pApplis.ismPause());

		pApplis.pause();

		assertEquals(true, pApplis.ismPause());
	}

	@Test
	void testReadFloatParameter() {
		PaintingAnts pApplis = new PaintingAnts();
		String param1 = "3";
		String param2 = "3:1";
		String param3 = "3:-4";
		String param4 = "3:7.8";

		assertEquals(3, pApplis.readFloatParameter(param1));
		
		assertEquals(3, pApplis.readFloatParameter(param2));
		
		assertEquals(3, pApplis.readFloatParameter(param3));
		
		assertThat(pApplis.readFloatParameter(param4), anyOf(is(3.0), is(7.8), is(allOf(greaterThan(3.0f), lessThan(7.8f)))));
		
	}

	@Test
	void testReadIntParameter() {
		PaintingAnts pApplis = new PaintingAnts();
		String param1 = "3";
		String param2 = "3:1";
		String param3 = "3:-4";
		String param4 = "3:7";

		assertEquals(3, pApplis.readIntParameter(param1));
		
		assertEquals(3, pApplis.readIntParameter(param2));
		
		assertEquals(3, pApplis.readIntParameter(param3));
		
		assertThat(pApplis.readIntParameter(param4), anyOf(is(3), is(7), is(allOf(greaterThan(3), lessThan(7)))));
	}

	@Test
	void testUpdateFPS() {
		PaintingAnts pApplis = new PaintingAnts();
		
		pApplis.setLastFps(4L);
		pApplis.setFpsCounter(6L);
		
		assertEquals(4L, pApplis.getLastFps());
		assertEquals(6L, pApplis.getFpsCounter());
		
		pApplis.updateFPS();
		
		assertEquals(6L, pApplis.getLastFps());
		assertEquals(0L, pApplis.getFpsCounter());
	}
}
