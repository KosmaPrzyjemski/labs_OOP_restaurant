package controleur;

import modele.BDClient;
import modele.BDPersonnel;
import modele.ProfilUtilisateur;

public class ControlSIdentifier {
	private BDClient bdClient = BDClient.getInstance();
	private BDPersonnel bdPersonnel = BDPersonnel.getInstance();

	public ControlSIdentifier() {
	}

	public int sIdentifier(ProfilUtilisateur typeUtilisateur, String login, String mdp) {
		if (typeUtilisateur == ProfilUtilisateur.CLIENT) {
			return bdClient.connexionClient(login, mdp);
		} else {
			return bdPersonnel.connexionPersonnel(login, mdp);
		}
	}

	public String visualiserBDUtilisateur() {
		return "BDPersonnel [" + BDPersonnel.getInstance().toString() + "]\n" + "BDClient ["
				+ BDClient.getInstance().toString() + "]\n";
	}

}
