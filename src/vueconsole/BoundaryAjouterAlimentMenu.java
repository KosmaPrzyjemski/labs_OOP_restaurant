package vueconsole;

import controleur.ControlAjouterAlimentMenu;
import modele.AlimentMenu;
import modele.ProfilUtilisateur;

public class BoundaryAjouterAlimentMenu {
	private ControlAjouterAlimentMenu aliment;

	public BoundaryAjouterAlimentMenu(ControlAjouterAlimentMenu controlAjouterAlimentMenu) {
		aliment = controlAjouterAlimentMenu;
	}

	public void ajouterAlimentMenu(int numProfil) {
		boolean identificationOK;
		identificationOK = aliment.verifierIdentification(ProfilUtilisateur.GERANT, numProfil);
		if (identificationOK) {
			System.out.println("Entrer le numero du type d'aliment que vous souhaitez ajouter");
			int choix;
			do {
				System.out.println("1 ajouter un hamburger");
				System.out.println("2 ajouter un accompagnement");
				System.out.println("3 ajouter un boisson");
				choix = Clavier.entrerClavierInt();
				if (!(choix == 1 || choix == 2 || choix == 3)) {
					System.out.println("Veuillez entrer 1, 2 ou 3");
				}
			} while (!(choix == 1 || choix == 2 || choix == 3));

			System.out.println("Veuillez entrer le nom de l'aliment");
			String nomAliment = Clavier.entrerClavierString();

			switch (choix) {
			case 1:
				aliment.ajouterAliment(AlimentMenu.HAMBURGER, nomAliment);
				break;
			case 2:
				aliment.ajouterAliment(AlimentMenu.ACCOMPAGNEMENT, nomAliment);
				break;
			case 3:
				aliment.ajouterAliment(AlimentMenu.BOISSON, nomAliment);
				break;
			default:
				System.out.println("Erreur choix");
				break;
			}
		}

	}
}
