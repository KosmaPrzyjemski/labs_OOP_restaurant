package vueconsole;

import controleur.ControlEnregistrerCoordonneesBancaires;

public class BoundaryEnregistrerCoordonneesBancaires {
	private ControlEnregistrerCoordonneesBancaires bank;
	
	public BoundaryEnregistrerCoordonneesBancaires(
			ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires) {
		bank = controlEnregistrerCoordonneesBancaires;
		
	}

	public boolean enregistrerCoordonneesBancaires(int numClient) {
		System.out.println("Veuillez saisir votre numero de carte bancaire");
		int numCarte = Clavier.entrerClavierInt();
		System.out.println("Veuillez saisir la date d'expiration de votre carte bancaire (MMAA)");
		int dateCarte = Clavier.entrerClavierInt();
		
		boolean carteValid = bank.enregistrerCoordonneesBancaires(numClient, numCarte, dateCarte);
		if (!carteValid) {
			System.out.println("Votre carte n'est pas valide, votre commande ne peut aboutir");
		}
		return carteValid;
	}

}
