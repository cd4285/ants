package org.polytechtours.javaperformance.tp.paintingants;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		
		String[][] l1 = new String[][]{{"SeuilLuminance", "string", "Seuil de luminance"}, {"Img", "string", "Image"}, {"NbFourmis", "string", "Nombre de fourmis"}, {"Fourmis", "string",
			"Paramètres des fourmis (RGB_déposée)(RGB_suivie)(x,y,direction,taille)(TypeDeplacement,ProbaG,ProbaTD,ProbaD,ProbaSuivre);...;"}};
		
		for(int i = 0; i < lInfo.length; ++i)
		{
			for(int j = 0; j < lInfo[i].length; ++j)
			{
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
	void testInit() {
		
	}
	
	@Test
	void testPaint() {
		
	}
	
	@Test
	void testPause() {
		
	}
	
	@Test
	void testReadFloatParameter() {
		
	}
	
	@Test
	void testReadIntParameter() {
		
	}
	
	@Test
	void testReadParameterFourmis() {
		
	}
	
	@Test
	void testRun() {
		
	}
	
	@Test
	void testStart() {
		
	}
	
	@Test
	void testStop() {
		
	}
	
	@Test
	void testUpdateFPS() {
		
	}
}
