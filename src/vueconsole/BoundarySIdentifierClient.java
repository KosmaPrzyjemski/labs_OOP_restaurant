package vueconsole;

import controleur.ControlSIdentifier;
import modele.ProfilUtilisateur;

public class BoundarySIdentifierClient {
	private ControlSIdentifier identification;
	
	public BoundarySIdentifierClient(ControlSIdentifier identif) {
		identification = identif;
	}
	
	public int sIdentifierClient() {
		System.out.println("Veuillez entrer votre login");
		String login = Clavier.entrerClavierString();
		System.out.println("Veuillez entrer votre mot de passe");
		String mdp = Clavier.entrerClavierString();
		
		int numClient = identification.sIdentifier(ProfilUtilisateur.CLIENT, login, mdp);
		return numClient;
	}
	
}
