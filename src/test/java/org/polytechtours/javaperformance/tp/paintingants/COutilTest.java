package org.polytechtours.javaperformance.tp.paintingants;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class COutilTest {
	
	private static COutil outil;
	private static CFourmi fourmi;
	private static Color pCouleurBlanc;
	private static Color pCouleurNoir;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		outil = new COutil();
		fourmi = new CFourmi(new Color(255, 255, 255), new Color(0, 0, 0), 0.45f, 0.53f, 0.65f, 0.76f, (CPainting)null, 'd', 0, 0, 2,
				3, 40, (PaintingAnts)null);
		
		pCouleurBlanc = new Color(255, 255, 255); // blanc
		pCouleurNoir = new Color(0, 0, 0); // noir
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
	public void testTestCouleurEgaliteAvecCouleurSuivie() {
		assertEquals(true, outil.testCouleur(pCouleurBlanc, fourmi.getmLuminanceCouleurSuivie(), fourmi.getmSeuilLuminance()));
	}

	@Test
	public void testTestCouleurPasEgaliteAvecCouleurSuivie() {
		assertEquals(false, outil.testCouleur(pCouleurNoir, fourmi.getmLuminanceCouleurSuivie(), fourmi.getmSeuilLuminance()));
	}
	
	@Test
	public void testModulo() {
		assertEquals(3, outil.modulo(3, 5));
		assertEquals(2, outil.modulo(30, 7));
	}
	
	@Test
	public void testModuloNombreNegatif() {
		assertEquals(2, outil.modulo(-2, 4));
	}

}
