package org.polytechtours.javaperformance.tp.paintingants;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CColonieTest {
	
	private static PaintingAnts pApplis;
	private static CPainting mPainting;
	private static CFourmi fourmi1;
	private static CFourmi fourmi2;
	private static Vector<CFourmi> vFourmis;
	private static CColonie colonie;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		pApplis = new PaintingAnts();
		mPainting = new CPainting(new Dimension(400, 500), pApplis);
		fourmi1 = new CFourmi(new Color(255, 255, 255), new Color(0, 0, 0), 0.45f, 0.53f, 0.65f, 0.76f, mPainting, 'd', 0, 0, 2,
				3, 40, pApplis);
		fourmi2 = new CFourmi(new Color(127, 127, 127), new Color(0, 0, 0), 0.39f, 0.65f, 0.43f, 0.53f, mPainting, 'o', 0, 0, 4,
				3, 40, pApplis);
		
		vFourmis = new Vector<CFourmi>();
		vFourmis.add(fourmi1);
		vFourmis.add(fourmi2);
		
		colonie = new CColonie(vFourmis, pApplis);

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
	void testPleaseStop() {			
		assertEquals(true, colonie.getmContinue());
		
		colonie.pleaseStop();
		
		assertEquals(false, colonie.getmContinue());
	}

	

}
