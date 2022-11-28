package vuegraphique;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.ControlCommander;

public class PanCommander extends JPanel implements IUseEnregistrerCoordonneesBancaires {
	// controleurs du cas + panel des cas inclus ou etendus en lien avec un acteur
	private ControlCommander controlCommander;
	private PanEnregistrerCoordonneesBancaires panEnreistrerCoordonneesBancaires;
	// les attributs metiers (ex : numClient)
	private int numClient;
	private int numeroHamburger = 0;
	private int numeroAccompagnement = 0;
	private int numeroBoisson = 0;
	
	// Les elements graphiques :
	// Declaration et creation des polices d'ecritures
	private Font policeTitre = new Font("Calibri", Font.BOLD, 24);
	private Font policeParagraphe = new Font("Calibri", Font.HANGING_BASELINE, 16);
	// Declaration et creation des ComboBox
	private JComboBox<String> comboBoxHamburger = new JComboBox<>(); 
	private JComboBox<String> comboBoxAccompagnement = new JComboBox<>(); 
	private JComboBox<String> comboBoxBoisson = new JComboBox<>(); 
	// Declaration et creation des Button
	private JButton validerCommande = new JButton();
	// Declaration et creation des TextArea
	// Declaration et creation des Labels
	private JLabel numeroCommande = new JLabel();

	// Mise en page : les Box
	Box boxMiseEnPageCommade = Box.createVerticalBox();
	Box boxChoixHamburger = Box.createHorizontalBox();
	Box boxChoixAccompagnement = Box.createHorizontalBox();
	Box boxChoixBoisson = Box.createHorizontalBox();
	Box boxValiderChoix =  Box.createHorizontalBox();
	private Box boxMiseEnPageNumeroCommande =Box.createVerticalBox();

	public PanCommander (
			// parametres pour l'initialisation des attributs metiers 
			
			// parametres correspondants au controleur du cas + panels 
			// des cas inclus ou etendus en lien avec un acteur
			ControlCommander controlCommander, PanEnregistrerCoordonneesBancaires panEnreistrerCoordonneesBancaires
		) {
		// initialisation des attributs metiers 
		// initilaisation du controleur du cas + panels 
		// des cas inclus ou etendus en lien avec un acteur
		this.controlCommander = controlCommander;
		this.panEnreistrerCoordonneesBancaires = panEnreistrerCoordonneesBancaires;
	}

	//Methode d'initialisation du panel
	public void initialisation() {
		// mise en forme du panel (couleur, ...)
		setBackground(Color.yellow);
		// creation des differents elements graphiques (JLabel, Combobox, Button, TextAera ...)
		JLabel texteCommander = new JLabel("Votre menu");
		texteCommander.setFont(policeTitre);
		JLabel texteHamburger = new JLabel("Choisissez votre hamburger");
		texteHamburger.setFont(policeParagraphe);
		JLabel texteAccompagnement = new JLabel("Choisissez votre accompagnement");
		texteAccompagnement.setFont(policeParagraphe);
		JLabel texteBoisson = new JLabel("Choisissez votre boisson");
		texteBoisson.setFont(policeParagraphe);
		
		comboBoxHamburger.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				numeroHamburger = comboBoxHamburger.getSelectedIndex();
			}
		});
		comboBoxAccompagnement.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				numeroAccompagnement = comboBoxAccompagnement.getSelectedIndex();
			}
		});
		comboBoxBoisson.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				numeroBoisson = comboBoxBoisson.getSelectedIndex();
			}
		});
		validerCommande.setText("Valider");
		validerCommande.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (numeroHamburger!=0 && numeroAccompagnement!=0 && numeroBoisson!=0) {
					validationCartePayement();
				}
			}
		});
		JLabel texteNumeroCommandeTitre = new JLabel("Votre commande");
		texteNumeroCommandeTitre.setFont(policeParagraphe);
		boxMiseEnPageNumeroCommande.add(numeroCommande);
		boxMiseEnPageNumeroCommande.add(texteNumeroCommandeTitre);
		boxMiseEnPageNumeroCommande.add(Box.createRigidArea(new Dimension(0, 30)));
		numeroCommande.setFont(policeParagraphe);
		boxMiseEnPageNumeroCommande.add(numeroCommande);
		this.add(boxMiseEnPageNumeroCommande);
		
		// mise en page : placements des differents elements graphiques dans des Box
		boxMiseEnPageCommade.add(texteCommander);
		boxChoixHamburger.add(texteHamburger);
		boxChoixAccompagnement.add(texteAccompagnement);
		boxChoixBoisson.add(texteBoisson);
		boxMiseEnPageCommade.add(Box.createRigidArea(new Dimension(0, 30)));
		boxChoixHamburger.add(Box.createRigidArea(new Dimension(0, 30)));
		boxChoixAccompagnement.add(Box.createRigidArea(new Dimension(0, 30)));
		boxChoixBoisson.add(Box.createRigidArea(new Dimension(0, 30)));
		// mise en page : placements des differentes box dans une box principale
		boxChoixHamburger.add(comboBoxHamburger);
		boxChoixAccompagnement.add(comboBoxAccompagnement);
		boxChoixBoisson.add(comboBoxBoisson);
		boxValiderChoix.add(validerCommande);
		// mise en page : ajout de la box principale dans le panel
		boxMiseEnPageCommade.add(boxChoixHamburger);
		boxMiseEnPageCommade.add(boxChoixAccompagnement);
		boxMiseEnPageCommade.add(boxChoixBoisson);
		boxMiseEnPageCommade.add(boxValiderChoix);
		this.add(boxMiseEnPageCommade);
	}

	// Methode correspondante au nom du cas
	public void commander( /*parametres metiers*/ int numClient) {
		boxMiseEnPageCommade.setVisible(true);
		boxMiseEnPageNumeroCommande.setVisible(false);
		// autres boxes a ajouter ????
		this.numClient=numClient;
		if (controlCommander.verifierIdentification(numClient)) {
			affichageMenu();
		}
		
	}

	// Methodes privees pour le bon deroulement du cas
	private void affichageMenu() {
		List<String> listeHamburger = controlCommander.donnerListeHamburger();
		List<String> listeAccompagnement = controlCommander.donnerListeAccompagnement();
		List<String> listeBoisson = controlCommander.donnerListeBoisson();
		comboBoxHamburger.removeAllItems();
		comboBoxHamburger.addItem("");
		for (String hamburger : listeHamburger) {
			comboBoxHamburger.addItem(hamburger);
		}
		boxChoixHamburger.add(Box.createRigidArea(new Dimension(10, 0)));
		comboBoxAccompagnement.removeAllItems();
		comboBoxAccompagnement.addItem("");
		for (String accompagnement : listeAccompagnement) {
			comboBoxAccompagnement.addItem(accompagnement);
		}
		boxChoixAccompagnement.add(Box.createRigidArea(new Dimension(10, 0)));
		comboBoxBoisson.removeAllItems();
		comboBoxBoisson.addItem("");
		for (String boisson : listeBoisson) {
			comboBoxBoisson.addItem(boisson);
		}
		boxChoixBoisson.add(Box.createRigidArea(new Dimension(10, 0)));
	}
	
	@Override
	public void retourEnregistrerCoordonneesBancaire(boolean carteValide) {
		this.panEnreistrerCoordonneesBancaires.setVisible(false);
		if (carteValide) {
			this.enregistrerCommande(carteValide);
		}
	}
	
	private void validationCartePayement() {
		boolean carteRenseignee = controlCommander.verifierExistanceCarteBancaire(numClient);
		if(!carteRenseignee) {
			boxMiseEnPageCommade.setVisible(false);
			panEnreistrerCoordonneesBancaires.setVisible(true);
			this.repaint();
			panEnreistrerCoordonneesBancaires.enregistrerCoordonneesBancairesas(numClient, this);
		} else {
			this.enregistrerCommande(carteRenseignee);
		}
	}
	
	private void enregistrerCommande(boolean carteRenseignee) {
		if (carteRenseignee) {
			int numCommande = controlCommander.enregistrerCommande(numClient, numeroHamburger, numeroAccompagnement, numeroBoisson);
			numeroCommande.setText("Votre numero est : " + numCommande);
		}
		this.setVisible(true);
		boxMiseEnPageCommade.setVisible(false);
		boxMiseEnPageNumeroCommande.setVisible(true);
		this.repaint();
	}
}