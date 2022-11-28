package modele;

//import java.util.ArrayList;

public class Client extends Profil {

	private CarteBancaire carte; // = null; ???
	//private ArrayList<Integer> historiqueCommandes;

	public Client(String nomm, String prenomm, String mdpp) {
		super(nomm, prenomm, mdpp);
		carte = null;
	}

	public void enregistrerCoordonnesBancaires(int numeroCarte, int dateCarte) {
		carte = new CarteBancaire(numeroCarte, dateCarte);
	}

	public boolean verifierExistanceCarteBancaire() {
		if (carte == null) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + "carte=" + carte+"]";
	}
	
	/*
	public void ajouterCommandeAHistorique(int numeroCommande) {
		historiqueCommandes.add(numeroCommande);
	}
	*/
	/*
	 * public CarteBancaire getCarte() { return carte; }
	 */
}
