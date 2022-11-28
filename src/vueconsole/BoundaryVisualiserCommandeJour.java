package vueconsole;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import controleur.ControlVerifierIdentification;
import controleur.ControlVisualiserCommandeJour;
import modele.ProfilUtilisateur;
import modele.PropertyName;

public class BoundaryVisualiserCommandeJour implements PropertyChangeListener {
	private ControlVisualiserCommandeJour controlVisualiserCommandeJour;
	
	public BoundaryVisualiserCommandeJour(ControlVisualiserCommandeJour controlVisualiserCommandeJour) {
		this.controlVisualiserCommandeJour = controlVisualiserCommandeJour;
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		String propertyName = evt.getPropertyName();
		PropertyName choix = PropertyName.valueOf(propertyName);
		switch (choix) {
		case ENREGISTRER_COMMANDE :
			Object object = evt.getNewValue();
			String[] labels = (String[]) object;
			String numeroCommande = labels[0];
			String hamburger = labels[1];
			String accompagnement = labels[2];
			String boisson = labels[3];
			Fichier.ecrire("Commande no " + numeroCommande + " : " + hamburger + ", " + accompagnement + ", " + boisson);
			break;
		case VIDER_COMMANDE_JOUR :
			System.out.println("Commandes sont vides !!!");
			Fichier.effacer();
			break;
		default :
			Fichier.ecrire("Probleme enregistrer commande!");
			break;
		}
	}
	
	public void visualiserCommandeJour(int numCuisinier) {
		if (controlVisualiserCommandeJour.verifierIdentification(numCuisinier, ProfilUtilisateur.PERSONNEL)) {
			this.controlVisualiserCommandeJour.setListener(PropertyName.ENREGISTRER_COMMANDE.toString(), this);
		}
		controlVisualiserCommandeJour.setListener(PropertyName.ENREGISTRER_COMMANDE.toString(), this);
	}
}
