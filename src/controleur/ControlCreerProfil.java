package controleur;

import modele.BDClient;
import modele.BDPersonnel;
import modele.Client;
import modele.FabriqueProfil;
import modele.Personnel;
import modele.Profil;
import modele.ProfilUtilisateur;

public class ControlCreerProfil {
	private BDClient bdClient = BDClient.getInstance();
	private BDPersonnel bdPersonnel = BDPersonnel.getInstance();

	public ControlCreerProfil() {
	}

	public void creerProfil(ProfilUtilisateur profilUtilisateur, String nom, String prenom, String mdp) {

		Profil profil = FabriqueProfil.creerProfil(profilUtilisateur, nom, prenom, mdp);

		switch (profilUtilisateur) {
		case CLIENT:
			Client client = (Client) profil;
			bdClient.ajouterClient(client);
			break;
		default:
			Personnel personnel = (Personnel) profil;
			bdPersonnel.ajouterPersonnel(personnel);
			break;
		}
	}

	public String visualiserBDUtilisateur() {
		return "BDPersonnel [" + BDPersonnel.getInstance().toString() + "]\n" + "BDClient ["
				+ BDClient.getInstance().toString() + "]\n";
	}

}
