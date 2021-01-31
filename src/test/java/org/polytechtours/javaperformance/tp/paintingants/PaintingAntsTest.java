package org.polytechtours.javaperformance.tp.paintingants;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.atomic.AtomicLong;

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
		assertEquals(new AtomicLong(0).get(), pApplis.getmCompteur().get());

		pApplis.compteur();

		assertEquals(new AtomicLong(1).get(), pApplis.getmCompteur().get());
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
		assertEquals(new AtomicLong(0L).get(), pApplis.getFpsCounter().get());

		pApplis.IncrementFpsCounter();

		assertEquals(new AtomicLong(1L).get(), pApplis.getFpsCounter().get());
	}

	@Test
	void testPause() {
		assertEquals(false, pApplis.ismPause());

		pApplis.pause();

		assertEquals(true, pApplis.ismPause());
	}

	@Test
	void testUpdateFPSLastFps() {		
		pApplis.setLastFps(new AtomicLong(4L));
		pApplis.setFpsCounter(new AtomicLong(6L));
		
		assertEquals(new AtomicLong(4L).get(), pApplis.getLastFps().get());
		
		
		pApplis.updateFPS();
		
		assertEquals(new AtomicLong(6L).get(), pApplis.getLastFps().get());
	}
	
	@Test
	void testUpdateFPSFpsCounter() {
		pApplis.setLastFps(new AtomicLong(4L));
		pApplis.setFpsCounter(new AtomicLong(6L));
		
		assertEquals(new AtomicLong(6L).get(), pApplis.getFpsCounter().get());
		
		pApplis.updateFPS();
		
		assertEquals(new AtomicLong(0L).get(), pApplis.getFpsCounter().get());

	}
}
