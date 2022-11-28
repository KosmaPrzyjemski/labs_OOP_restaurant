package vueconsole;

import controleur.ControlSIdentifier;
import modele.ProfilUtilisateur;

public class BoundarySIdentifierPersonnel {
	private ControlSIdentifier identification;

	public BoundarySIdentifierPersonnel(ControlSIdentifier identif) {
		identification = identif;
	}

	public int sIdentifierPersonnel() {
		System.out.println("Veuillez entrer votre login");
		String login = Clavier.entrerClavierString();
		System.out.println("Veuillez entrer votre mot de passe");
		String mdp = Clavier.entrerClavierString();
		int numPersonnel = identification.sIdentifier(ProfilUtilisateur.PERSONNEL, login, mdp);
		return numPersonnel;
	}

}
