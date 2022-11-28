package vueconsole;

import controleur.ControlCreerProfil;
import modele.ProfilUtilisateur;

public class BoundaryCreerProfilGerant {
	private ControlCreerProfil profil;

	public BoundaryCreerProfilGerant(ControlCreerProfil controlCreerProfil) {
		profil = controlCreerProfil;
	}

	public void creerProfilGerant() {
		System.out.println("Veuillez entrer votre nom");
		String nom = Clavier.entrerClavierString();
		System.out.println("Veuillez entrer votre prenom");
		String prenom = Clavier.entrerClavierString();
		System.out.println("Veuillez entrer votre mot de passe");
		String mdp = Clavier.entrerClavierString();

		profil.creerProfil(ProfilUtilisateur.GERANT, nom, prenom, mdp);
	}
}
