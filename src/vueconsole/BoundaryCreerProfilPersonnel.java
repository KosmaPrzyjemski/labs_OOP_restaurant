package vueconsole;

import controleur.ControlCreerProfil;
import modele.ProfilUtilisateur;

public class BoundaryCreerProfilPersonnel {
	private ControlCreerProfil profil;

	public BoundaryCreerProfilPersonnel(ControlCreerProfil controlCreerProfil) {
		profil = controlCreerProfil;
	}

	public void creerProfilPersonnel() {

		System.out.println("Veuillez entrer le nom du nouvel employÈ");
		String nom = Clavier.entrerClavierString();
		System.out.println("Veuillez entrer le prÈnom du nouvel employÈ");
		String prenom = Clavier.entrerClavierString();
		System.out.println("Le mot de passe est mdp ‡ modifier ‡ la premiËre connexion");

		profil.creerProfil(ProfilUtilisateur.PERSONNEL, nom, prenom, "mdp");
	}
}