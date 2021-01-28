package org.polytechtours.javaperformance.tp.paintingants;

import java.awt.Color;

public class COutil {
	
	
	/*************************************************************************************************
	 * Titre : modulo Description : Fcontion de modulo permettant au fourmi de
	 * reapparaitre de l autre coté du Canvas lorsque qu'elle sorte de ce dernier
	 *
	 * @param x valeur
	 *
	 * @return int
	 */
	/* private */public int modulo(int x, int m) {
		return (x + m) % m;
	}

	/*************************************************************************************************
	 * Titre : boolean testCouleur() Description : fonction testant l'égalité d'une
	 * couleur avec la couleur suivie
	 *
	 */
	/* private */public boolean testCouleur(Color pCouleur, float mLuminanceCouleurSuivie, float mSeuilLuminance) {
		boolean lReponse = false;
		float lLuminance;

		/* on calcule la luminance */
		lLuminance = 0.2426f * pCouleur.getRed() + 0.7152f * pCouleur.getGreen() + 0.0722f * pCouleur.getBlue();

		/* test */
		if (Math.abs(mLuminanceCouleurSuivie - lLuminance) < mSeuilLuminance) {
			lReponse = true;
			// System.out.print(x);
		}

		return lReponse;
	}

}
