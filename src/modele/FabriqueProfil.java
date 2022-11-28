package modele;

public class FabriqueProfil {

	public static Profil creerProfil(ProfilUtilisateur profilUtilisateur, String nom, String prenom, String mdp) {
		Profil profil = null;
		switch (profilUtilisateur) {
		case GERANT:
			profil = new Personnel(nom, prenom, mdp);
			Personnel gerant = (Personnel) profil;
			gerant.definirGerant();
			break;
		case PERSONNEL:
			profil = new Personnel(nom, prenom, mdp);
			break;
		default:
			profil = new Client(nom, prenom, mdp);
			break;
		}
		return profil;
	}
}
