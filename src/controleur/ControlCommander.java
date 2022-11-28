package controleur;

import java.util.ArrayList;

import modele.Accompagnement;
import modele.BDClient;
import modele.BDCommande;
import modele.Boisson;
import modele.Client;
import modele.Hamburger;
import modele.Menu;
import modele.ProfilUtilisateur;

public class ControlCommander {
	private ControlVerifierIdentification controlVerifierIdentification;
	private BDClient bdClient = BDClient.getInstance();
	private Menu menu = Menu.getInstance();
	private BDCommande bdCommande = BDCommande.getInstance();
	
	public ControlCommander(ControlVerifierIdentification controlVerifierIdentification2) {
		controlVerifierIdentification = controlVerifierIdentification2;
	}

	public boolean verifierIdentification(int numeroClient) {
		return controlVerifierIdentification.verifierIdentification(ProfilUtilisateur.CLIENT, numeroClient);
	}
	
	public ArrayList<String> donnerListeHamburger() {
		ArrayList<Hamburger> listeHamburgers = menu.getListHamburger();
		ArrayList<String> listeHamburgersString = new ArrayList<>();
		for (Hamburger hamburger : listeHamburgers){
			listeHamburgersString.add(hamburger.getNom());
		}
		return listeHamburgersString;
	}
	
	public ArrayList<String> donnerListeAccompagnement() {
		ArrayList<Accompagnement> listeAccompagnements = menu.getListAccompagnement();
		ArrayList<String> listeAccompagnementsString = new ArrayList<>();
		for (Accompagnement accompagnement : listeAccompagnements){
			listeAccompagnementsString.add(accompagnement.getNom());
		}
		return listeAccompagnementsString;
	}
	
	public ArrayList<String> donnerListeBoisson() {
		ArrayList<Boisson> listeBoissons = menu.getListBoisson();
		ArrayList<String> listeBoissonsString = new ArrayList<>();
		for (Boisson boisson : listeBoissons){
			listeBoissonsString.add(boisson.getNom());
		}
		return listeBoissonsString;
	}
	
	public boolean verifierExistanceCarteBancaire(int numClient) {
		Client client = bdClient.trouverClient(numClient);
		return client.verifierExistanceCarteBancaire();
	}
	
	public int enregistrerCommande(int clientNumber, int burgerNumber, int sidedishNumber, int drinkNumber) {
		Hamburger burger= menu.choixHamburger(burgerNumber);
		Accompagnement sidedish = menu.choixAccompagnement(sidedishNumber);
		Boisson drink = menu.choixBoisson(drinkNumber);
		return bdCommande.enregistrerCommande(clientNumber, burger, sidedish, drink);
	}
}
	
