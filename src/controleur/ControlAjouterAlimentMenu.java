package controleur;

import modele.Accompagnement;
import modele.Aliment;
import modele.AlimentMenu;
import modele.Boisson;
import modele.FabriqueAliment;
import modele.Hamburger;
import modele.Menu;
import modele.ProfilUtilisateur;

public class ControlAjouterAlimentMenu {
	private Menu menu = Menu.getInstance(); 
	private ControlVerifierIdentification indentification;
	
	public ControlAjouterAlimentMenu(ControlVerifierIdentification controlVerifierIdentification) {
		indentification = controlVerifierIdentification;
	}

	public boolean verifierIdentification(ProfilUtilisateur profilUtilisateur, int numeroProfil) {
		return indentification.verifierIdentification(profilUtilisateur, numeroProfil);
	}
	
	public void ajouterAliment(AlimentMenu typeAliment, String nom) {
		Aliment aliment = null;
		switch(typeAliment) {
		case HAMBURGER :
			aliment = FabriqueAliment.creerAliment(AlimentMenu.HAMBURGER, nom);
			menu.ajouterAliment((Hamburger)aliment);
			break;
		case ACCOMPAGNEMENT :
			aliment = FabriqueAliment.creerAliment(AlimentMenu.ACCOMPAGNEMENT, nom);
			menu.ajouterAliment((Accompagnement)aliment);
			break;
		case BOISSON : 
			aliment = FabriqueAliment.creerAliment(AlimentMenu.BOISSON, nom);
			menu.ajouterAliment((Boisson)aliment);
			break;
		default : 
			System.out.println("Mauvais aliment!");
			break;
		}
	}

	public String visualiserMenu() {
		return "Menu [menu=" + menu + "]";
	}

	@Override
	public String toString() {
		return "ControlAjouterAlimentMenu [menu=" + menu + ", indentification=" + indentification + "]";
	}
}
