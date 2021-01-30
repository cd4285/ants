package org.polytechtours.javaperformance.tp.paintingants;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * classe test PaintingAnts
 * 
 *
 */
class PaintingAntsTest {
	private static PaintingAnts pApplis;
	private static String[][] lInfo;
	private static String[][] l1;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		pApplis = new PaintingAnts();
		
		lInfo = pApplis.getParameterInfo();

		l1 = new String[][] { { "SeuilLuminance", "string", "Seuil de luminance" },
				{ "Img", "string", "Image" }, { "NbFourmis", "string", "Nombre de fourmis" }, { "Fourmis", "string",
						"Paramètres des fourmis (RGB_déposée)(RGB_suivie)(x,y,direction,taille)(TypeDeplacement,ProbaG,ProbaTD,ProbaD,ProbaSuivre);...;" } };
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
