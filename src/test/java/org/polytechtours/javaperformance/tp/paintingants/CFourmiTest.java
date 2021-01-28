package org.polytechtours.javaperformance.tp.paintingants;


import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CFourmiTest {
	
	private static PaintingAnts pApplis;
	private static CPainting mPainting;
	private static Graphics gMock;
	private static CFourmi fourmi;
	private static COutil outil;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		pApplis = new PaintingAnts();
		mPainting = new CPainting(new Dimension(400, 500), pApplis);
		
		gMock = Mockito.mock(Graphics.class);
		mPainting.setmGraphics(gMock);
		
		outil = new COutil();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		fourmi = new CFourmi(new Color(255, 255, 255), new Color(0, 0, 0), 0.45f, 0.53f, 0.65f, 0.76f, mPainting, 'd', 0, 0, 2,
				3, 40, pApplis);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	
	@Test
	public void testDeplacerNombreDeplacements() {
		assertEquals(0, fourmi.getNbDeplacements()); // test nombre de déplacement
		
		fourmi.deplacer();
		
		assertEquals(1, fourmi.getNbDeplacements()); // test nombre de déplacement

	}
	
	@Test
	public void testDeplacerCoordonneeX() {
		assertEquals(0, fourmi.getX()); // test coordonnees fourmi
		
		int coordX = fourmi.getX();

		fourmi.deplacer();
		
		assertThat(fourmi.getX(), anyOf(is(outil.modulo(coordX, 500)), is(outil.modulo(coordX + 1, 500)))); // test coordonnees fourmi
	}
	
	@Test
	public void testDeplacerCoordonneeY() {
		assertEquals(0, fourmi.getY()); // test coordonnees fourmi
		
		int coordY = fourmi.getY();

		fourmi.deplacer();

		assertThat(fourmi.getY(), anyOf(is(outil.modulo(coordY, 500)), is(outil.modulo(coordY + 1, 500)), is(outil.modulo(coordY - 1, 500)))); // test coordonnees fourmi
	}

	@Test
	public void testDeplacerDirection() {
		assertEquals(2, fourmi.getmDirection()); // test direction de la fourmi
		
		int direction = fourmi.getmDirection();
		
		fourmi.deplacer();

		assertThat(fourmi.getmDirection(), anyOf(is(direction - 2), is(direction), is(direction + 2))); //test direction de la fourmi
	}
}
