package controleur;


import modele.BDClient;
import modele.Client;

public class ControlEnregistrerCoordonneesBancaires {
	private ControlVerifierCoordonneesBancaires controlVerifierCoordonneesBancaires;
	private BDClient bdClient = BDClient.getInstance();
	
	public ControlEnregistrerCoordonneesBancaires(
			ControlVerifierCoordonneesBancaires controlVerifierCoordonneesBancaires2) {
		controlVerifierCoordonneesBancaires = controlVerifierCoordonneesBancaires2;
	}

	public boolean enregistrerCoordonneesBancaires(int numeroClient, int numeroCarte, int dateCarte) {
		boolean carteValide = controlVerifierCoordonneesBancaires.verifierCoordonneesBancaires(numeroCarte, dateCarte);
		if (carteValide) {
			Client client = bdClient.trouverClient(numeroClient);
			client.enregistrerCoordonnesBancaires(numeroCarte, dateCarte);
		}
		return carteValide;
	}
}
