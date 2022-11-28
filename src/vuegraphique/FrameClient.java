package vuegraphique;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.ControlCommander;
import controleur.ControlEnregistrerCoordonneesBancaires;


public class FrameClient extends JFrame {
	// Les attributs metiers (ex : numClient)
	private int numClient;
	
	// Declaration et creation des elements graphiques (JLabel)
	// Declaration et creation de la barre de menu (MenuBar) 
	private MenuBar barreMenu = new MenuBar();
	
	// Declaration et creation des differents panels
	private JPanel panContents = new JPanel();
	private PanCommander panCommander; 
	private PanModifierProfil panModifierProfil= new PanModifierProfil();
	private PanHistorique panHistorique = new PanHistorique();
	private JPanel panAccueil = new JPanel();
	
	// Declaration et creation du gestionnaire des cartes (CardLayout)
	private CardLayout cartes = new CardLayout();

	// Le constructeur
	public FrameClient (
			// parametres pour l'initialisation des attributs metiers 
			int numeroClient,
			// parametres correspondants aux controleurs des cas utiliser par 
			// l'acteur en relation avec cette frame
			ControlCommander controlCommander, ControlEnregistrerCoordonneesBancaires ControlEnregistrerCoordonneesBancaires
	) {
		// initialisation des attributs metiers
		numClient= numeroClient;
		// mise en forme de la frame (titre, dimension, ...)
		setTitle("BurgerResto");
		setSize(900,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// initialisation des differents panels : appel a leur methode d'initialisation
		PanEnregistrerCoordonneesBancaires panEnreistrerCoordonneesBancaires = new PanEnregistrerCoordonneesBancaires(ControlEnregistrerCoordonneesBancaires);
		panCommander = new PanCommander(controlCommander, panEnreistrerCoordonneesBancaires);
		panCommander.initialisation();
		panModifierProfil.initialisation();
		panHistorique.initialisation();		
		panEnreistrerCoordonneesBancaires.initialisation();
		// ajout des pannels dans le ContentPane de la Frame
		panContents.setLayout(cartes);
		panContents.add(panCommander, "COMMANDER");
		panCommander.add(panEnreistrerCoordonneesBancaires, "ENREGISTRER_COORDONNEES_BANCAIRE");
		panContents.add(panModifierProfil, "MODIFIERPROFIL");
		panContents.add(panHistorique, "HISTORIQUE");
		getContentPane().add(panContents);
		// mise en page : mises en place des cartes
		initialisationAcceuil();
		// mise en place du menu 
		initialisationMenu();
		setMenuBar(barreMenu);
		// appel a la methode d'initialisation du menu
		// appel a la methode d'initialisation de la page d'accueil (optionnel)

		this.setVisible(true);
	}


	private void initialisationMenu() {
		MenuItem commander = new MenuItem("Commander");
		commander.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent event) { 
				panCommander.commander(numClient);
				cartes.show(panContents, "COMMANDER");       
				}     
			});
		MenuItem modifierProfil = new MenuItem("ModifierProfil");
		modifierProfil.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent event) { 
				cartes.show(panContents, "MODIFIERPROFIL");       
				}     
			});
		MenuItem historique = new MenuItem("Historique");
		historique.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent event) { 
				cartes.show(panContents, "HISTORIQUE");       
				}     
			});
		Menu menuMonCompte = new Menu("Mon compte");
		menuMonCompte.add(commander);
		menuMonCompte.add(modifierProfil);
		menuMonCompte.add(historique);
		Menu menuDeconnexion = new Menu("Deconnexion");
		barreMenu.add(menuMonCompte);
		barreMenu.add(menuDeconnexion);
		
	}

	private void initialisationAcceuil(){
		panAccueil.setBackground(Color.ORANGE);
		JLabel texteAccueil = new JLabel("Bienvenu a Burger Resto");
		texteAccueil.setFont(new Font("Calibri", Font.BOLD, 24));
		panAccueil.add(texteAccueil); 
		panAccueil.setVisible(true);
		panContents.add(panAccueil, "ECRAN_ACCUEIL");
		cartes.show(panContents, "ECRAN_ACCUEIL");
	}
}