package org.polytechtours.javaperformance.tp.paintingants;


import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CFourmiTest {

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
	public void testTestCouleur() {
		CFourmi fourmi = new CFourmi(new Color(255, 255, 255), new Color(0, 0, 0), 0, 0, 0, 0, (CPainting) null, 'd', 0,
				0, 0, 0, 40, (PaintingAnts) null);
		/*
		 * float lLuminance; float mLuminanceCouleurSuivie; float mSeuilLuminance;
		 */

		Color pCouleurBlanc = new Color(255, 255, 255); // blanc
		Color pCouleurNoir = new Color(0, 0, 0); // noir
		Color pCouleurBleuFonce = new Color(0, 0, 255); // bleu foncé
		Color pCouleurGris = new Color(128, 128, 128); // gris
		Color pCouleurVert = new Color(0, 255, 0); // vert
		Color pCouleurRouge = new Color(255, 0, 0); // rouge
		Color pCouleurJaune = new Color(255, 255, 0); // jaune

		/*
		 * lLuminance = 0.2426f * pCouleurBlanc.getRed() + 0.7152f *
		 * pCouleurBlanc.getGreen() + 0.0722f * pCouleurBlanc.getBlue(); mSeuilLuminance
		 * = 40; lLuminance = 56;
		 */

		assertEquals(false, fourmi.testCouleur(pCouleurNoir));
		assertEquals(true, fourmi.testCouleur(pCouleurBlanc));

		// fail("Not yet implemented");
	}

	@Test
	public void testModulo() {
		CFourmi fourmi = new CFourmi(new Color(255, 255, 255), new Color(0, 0, 0), 0, 0, 0, 0, (CPainting) null, 'd', 0,
				0, 0, 0, 40, (PaintingAnts) null);

		assertEquals(2, fourmi.modulo(-2, 4));
		assertEquals(3, fourmi.modulo(3, 5));
		assertEquals(2, fourmi.modulo(30, 7));
	}

	@Test
	public void testDeplacer() {
		PaintingAnts pApplis = new PaintingAnts();
		CPainting mPainting = new CPainting(new Dimension(400, 500), pApplis);
		
		Graphics gMock = Mockito.mock(Graphics.class);
		mPainting.setmGraphics(gMock);
		
		CFourmi fourmi = new CFourmi(new Color(255, 255, 255), new Color(0, 0, 0), 0.45f, 0.53f, 0.65f, 0.76f, mPainting, 'd', 0, 0, 2,
				3, 40, pApplis);

		assertEquals(0, fourmi.getNbDeplacements()); // test nombre de déplacement
		assertEquals(0, fourmi.getX()); // test coordonnees fourmi
		assertEquals(0, fourmi.getY()); // test coordonnees fourmi
		
		int coordX = fourmi.getX();
		int coordY = fourmi.getY();
		
		fourmi.deplacer();

		assertEquals(1, fourmi.getNbDeplacements()); // test nombre de déplacement
		assertThat(fourmi.getX(), anyOf(is(coordX % 500), is((coordX + 1) % 500))); // test coordonnees fourmi
		assertThat(fourmi.getY(), anyOf(is(coordY % 500), is((coordY + 1) % 500))); // test coordonnees fourmi
	}

}
