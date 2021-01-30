package org.polytechtours.javaperformance.tp.paintingants;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * classe qui gère les actions de la souris
 * 
 *
 */
public class CSouris implements MouseListener {
	
	private PaintingAnts mApplis;
	private CPainting painting;
	
	/******************************************************************************
	 * Titre : public CSouris() Description : Constructeur de la classe
	 ******************************************************************************/
	public CSouris(CPainting cpainting, PaintingAnts pApplis) {
		painting = cpainting;
		mApplis = pApplis;
	}
	
	/****************************************************************************/
	public void mouseClicked(MouseEvent pMouseEvent) {
		pMouseEvent.consume();
		if (pMouseEvent.getButton() == MouseEvent.BUTTON1) {
			// double clic sur le bouton gauche = effacer et recommencer
			if (pMouseEvent.getClickCount() == 2) {
				painting.init();
			}
			// simple clic = suspendre les calculs et l'affichage
			mApplis.pause();
		} else {
			// bouton du milieu (roulette) = suspendre l'affichage mais
			// continuer les calculs
			if (pMouseEvent.getButton() == MouseEvent.BUTTON2) {
				painting.suspendre();
			} else {
				// clic bouton droit = effacer et recommencer
				// case pMouseEvent.BUTTON3:
				painting.init();
			}
		}
	}

	/****************************************************************************/
	public void mouseEntered(MouseEvent pMouseEvent) {
	}

	/****************************************************************************/
	public void mouseExited(MouseEvent pMouseEvent) {
	}

	/****************************************************************************/
	public void mousePressed(MouseEvent pMouseEvent) {

	}

	/****************************************************************************/
	public void mouseReleased(MouseEvent pMouseEvent) {
	}
}
