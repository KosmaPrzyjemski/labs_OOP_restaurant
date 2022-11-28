package vueconsole;

import java.util.ArrayList;

import controleur.ControlCommander;

public class BoundaryCommander {
	private ControlCommander controlCommander;
	private BoundaryEnregistrerCoordonneesBancaires boundaryEnregistrerCoordonneesBancaires;

	public BoundaryCommander(ControlCommander controlCommander2,
			BoundaryEnregistrerCoordonneesBancaires boundaryEnregistrerCoordonneesBancaires2) {
		controlCommander = controlCommander2;
		boundaryEnregistrerCoordonneesBancaires = boundaryEnregistrerCoordonneesBancaires2;
	}

	public void commander(int numeroClient) {
		if (controlCommander.verifierIdentification(numeroClient)) {
			int numeroCommande = -1;
			int numeroHamburger = selectionnerBurger();
			int numeroAccompagnement = selectionnerAccompagnement();
			int numeroBoisson = selectionnerBoisson();
			boolean carteRenseignee = controlCommander.verifierExistanceCarteBancaire(numeroClient);
			if (!carteRenseignee) {
				carteRenseignee = boundaryEnregistrerCoordonneesBancaires.enregistrerCoordonneesBancaires(numeroClient);
			} 
			if (carteRenseignee) {
				numeroCommande = controlCommander.enregistrerCommande(numeroClient, numeroHamburger, numeroAccompagnement, numeroBoisson);
			}
			System.out.println("Votre numero de commande est le : " + numeroCommande);
		}
	}

	private int selectionnerBurger() {
		System.out.println("Veuillez selectionner le numero de votre hamburger");
		int numeroHamburger;
		ArrayList<String> listeHamburgers = controlCommander.donnerListeHamburger();
		for (int i = 0; i < listeHamburgers.size(); i++) {
			System.out.print("\n" + (i+1) + " : " + listeHamburgers.get(i));
		}
		do {
			numeroHamburger = Clavier.entrerClavierInt();
		} while (numeroHamburger < 0);
		return numeroHamburger;
	}

	private int selectionnerAccompagnement() {
		System.out.println("Veuillez selectionner le numero de votre accompagnement");
		int numeroAccompagnement;
		ArrayList<String> listeAccompagnement = controlCommander.donnerListeAccompagnement();
		for (int i = 0; i < listeAccompagnement.size(); i++) {
			System.out.print("\n" + (i+1) + " : " + listeAccompagnement.get(i));
		}
		do {
			numeroAccompagnement = Clavier.entrerClavierInt();
		} while (numeroAccompagnement < 0);
		return numeroAccompagnement;
	}

	private int selectionnerBoisson() {
		System.out.println("Veuillez selectionner le numero de votre boisson");
		int numeroBoisson;
		ArrayList<String> listeBoisson = controlCommander.donnerListeBoisson();
		for (int i = 0; i < listeBoisson.size(); i++) {
			System.out.print("\n" + (i+1) + " : " + listeBoisson.get(i));
		}
		do {
			numeroBoisson = Clavier.entrerClavierInt();
		} while (numeroBoisson < 0);
		return numeroBoisson;
	}

}
