package org.polytechtours.javaperformance.tp.paintingants;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * classe test CPainting
 * 
 *
 */
class CPaintingTest {
	private static PaintingAnts pApplis;
	private static CPainting painting;
	private static Graphics gMock;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		pApplis = new PaintingAnts();
		painting = new CPainting(new Dimension(400, 500), pApplis);
		
		gMock = Mockito.mock(Graphics.class);
		painting.setmGraphics(gMock);
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
	public void testCPaintingDimensions() {	
		assertEquals(new Rectangle(0, 0, 400, 500), painting.getBounds());
	}
	
	@Test
	public void testCPaintingCouleur() {
		// test couleur de fond
		for (int i = 0; i != painting.getDimension().width; i++) {
			for (int j = 0; j != painting.getDimension().height; j++) {
					assertEquals(new Color(255, 255, 255), painting.getmCouleurs()[i][j]);
			}
		}
	}
	
	@Test
	public void testSuspendre() {
		assertEquals(false, painting.ismSuspendu());
		
		painting.suspendre();
		
		assertEquals(true, painting.ismSuspendu());
	}
	
	@Test
	public void testSetCouleur() {
		assertEquals(new Color(255, 255, 255), painting.getmCouleurs()[0][0]);
		
		painting.setCouleur(0, 0, new Color(0, 0, 0), 0);
		
		assertEquals(new Color(0, 0, 0), painting.getmCouleurs()[0][0]);
	}

}
