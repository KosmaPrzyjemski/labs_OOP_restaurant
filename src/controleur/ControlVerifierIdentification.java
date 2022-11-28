package controleur;

import modele.BDClient;
import modele.BDPersonnel;
import modele.Client;
import modele.Personnel;
import modele.ProfilUtilisateur;

public class ControlVerifierIdentification {
	private BDClient bdClient = BDClient.getInstance();
	private BDPersonnel bdPersonnel = BDPersonnel.getInstance();

	public ControlVerifierIdentification() {
	}

	public boolean verifierIdentification(ProfilUtilisateur profilUtilisateur, int numeroProfil) {
		boolean connexionOK = false;

		switch (profilUtilisateur) {
		case CLIENT:
			Client client = bdClient.trouverClient(numeroProfil);
			if (client != null) {
				connexionOK = client.isConnecte();
			}
			break;
		case PERSONNEL:
			Personnel personnel = bdPersonnel.trouverPersonnel(numeroProfil);
			if (personnel != null) {
				connexionOK = personnel.isConnecte();
			}
			break;
		default:
			personnel = bdPersonnel.trouverPersonnel(numeroProfil);
			if (personnel != null) {
				if (personnel.isGerant()) {
					connexionOK = personnel.isConnecte();
				}
			}
			break;
		}
		return connexionOK;
	}
	
	

}
