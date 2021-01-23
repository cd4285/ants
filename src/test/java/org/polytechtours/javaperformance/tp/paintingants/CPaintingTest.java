package org.polytechtours.javaperformance.tp.paintingants;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CPaintingTest {

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
	public void testCPainting() {
		PaintingAnts pApplis = new PaintingAnts();
		CPainting painting = new CPainting(new Dimension(400, 500), pApplis);
		
		assertEquals(new Rectangle(0, 0, 400, 500), painting.getBounds());
	
		// test couleur de fond
		for (int i = 0; i != painting.getDimension().width; i++) {
			for (int j = 0; j != painting.getDimension().height; j++) {
					assertEquals(new Color(255, 255, 255), painting.getmCouleurs()[i][j]);
			}
		}
	}
	
	@Test
	public void testSuspendre() {
		PaintingAnts pApplis = new PaintingAnts();
		CPainting painting = new CPainting(new Dimension(400, 500), pApplis);
		
		assertEquals(false, painting.ismSuspendu());
		
		painting.suspendre();
		
		assertEquals(true, painting.ismSuspendu());
	}

}