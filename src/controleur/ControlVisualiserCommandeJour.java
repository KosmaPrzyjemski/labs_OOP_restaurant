package controleur;

import java.beans.PropertyChangeListener;
import modele.BDCommande;
import modele.ProfilUtilisateur;

public class ControlVisualiserCommandeJour {
	private BDCommande bdcommande = BDCommande.getInstance();
	private ControlVerifierIdentification controlVerifierIdentification;
	
	public ControlVisualiserCommandeJour(ControlVerifierIdentification controlVerifierIdentification) {
		this.controlVerifierIdentification = controlVerifierIdentification;
	}
	
	public void setListener(String propertyName, PropertyChangeListener listener) {
		bdcommande.addPropertyChangeListener(propertyName, listener);
	}
	
	public boolean verifierIdentification(int numCuisinier, ProfilUtilisateur profilUtilisateur) {
		return controlVerifierIdentification.verifierIdentification(profilUtilisateur, numCuisinier);
	}
}
