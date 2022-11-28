package controleur;

//import java.util.ArrayList;
//import modele.CarteBancaire;

public class ControlVerifierCoordonneesBancaires {
	//private ArrayList<CarteBancaire> listeCartes = new ArrayList<>();

	public ControlVerifierCoordonneesBancaires() {
	}

	public boolean verifierCoordonneesBancaires(int numeroCarte, int dateCarte) {
		int i = 0;
		if (i < 9) {
			i++;
			return true; // 90% de temps on return true (carteValide)
		} else {
			i = 0;
			return false; // 10% de temps on return false (!carteValide)
		}

	}
}
