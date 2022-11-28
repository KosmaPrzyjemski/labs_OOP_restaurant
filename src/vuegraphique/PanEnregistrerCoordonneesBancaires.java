package vuegraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleur.ControlEnregistrerCoordonneesBancaires;

public class PanEnregistrerCoordonneesBancaires extends JPanel {
	// controleurs du cas + panel des cas inclus ou etendus en lien avec un acteur
	private ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires;
	private IUseEnregistrerCoordonneesBancaires panAppelant;
	// les attributs metiers (ex : numClient)
	private int numClient;
	// Les elements graphiques :
	// Declaration et creation des polices d'ecritures
	private Font policeTitre = new Font("Calibri", Font.BOLD, 24);
	private Font policeParagraphe = new Font("Calibri", Font.HANGING_BASELINE, 16);
	private Font policeAremplacer = new Font("Arial", Font.ITALIC, 12);
	private Font policeChoixUtilisateur = new Font("Arial", Font.TRUETYPE_FONT, 12);
	// Declaration et creation des ComboBox
	// Declaration et creation des Button
	JButton validationCoordonneeBancaire = new JButton();
	// Declaration et creation des TextArea
	private TextArea textAreaNumeroCarte = new TextArea();
	private TextArea textAreaDateExpiration = new TextArea();
	// Declaration et creation des Labels

	// Mise en page : les Box
	private Box boxMiseEnPageCoordonneesBancaires = Box.createVerticalBox();
	private Box boxNumeroCarte = Box.createHorizontalBox();
	private Box boxValiditeCarte = Box.createHorizontalBox();
	private Box boxValiderCarte = Box.createHorizontalBox();

	public PanEnregistrerCoordonneesBancaires (ControlEnregistrerCoordonneesBancaires controlEnregistrerCoordonneesBancaires
			// parametres pour l'initialisation des attributs metiers 
			// parametres correspondants au controleur du cas + panels 
			// des cas inclus ou etendus en lien avec un acteur
		) {
		// initialisation des attributs metiers 
		// initilaisation du controleur du cas + panels 
		this.controlEnregistrerCoordonneesBancaires = controlEnregistrerCoordonneesBancaires;
		// des cas inclus ou etendus en lien avec un acteur
	}

	//Methode d'initialisation du panel
	public void initialisation() {
		// mise en forme du panel (couleur, ...)
		setBackground(Color.yellow);
		// creation des differents elements graphiques (JLabel, Combobox, Button, TextAera ...)
		JLabel texteCoordonnerBancaire = new JLabel("Entrer vos coordonnees bancaires");
		texteCoordonnerBancaire.setFont(policeTitre);
		boxMiseEnPageCoordonneesBancaires.add(texteCoordonnerBancaire);
		
		JLabel texteNumeroCarteBacaire = new JLabel("Entrer le numero de votre carte bancaire");
		texteNumeroCarteBacaire.setFont(policeParagraphe);
		boxNumeroCarte.add(texteNumeroCarteBacaire);
		
		JLabel texteValiditeCarte = new JLabel("Entrer la date d'expiration de votre carte bancaire");
		texteValiditeCarte.setFont(policeParagraphe);
		boxValiditeCarte.add(texteValiditeCarte);
		
		validationCoordonneeBancaire.setText("Valider");
		validationCoordonneeBancaire.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					int numeroCarte = Integer.valueOf(textAreaNumeroCarte.getText());
					int dateCarte = Integer.valueOf(textAreaDateExpiration.getText());
					traitementCoordonneeBancaire(numeroCarte, dateCarte);
			}
		});
		textAreaNumeroCarte.setMaximumSize(new Dimension(120, 20));
		textAreaDateExpiration.setForeground(Color.gray);
		textAreaDateExpiration.setMaximumSize(new Dimension(60, 20));
		textAreaDateExpiration.setFont(policeAremplacer);
		textAreaDateExpiration.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseClicked(MouseEvent arg0) {
				textAreaDateExpiration.setText(null);
				textAreaDateExpiration.setFont(policeChoixUtilisateur);
				textAreaDateExpiration.setForeground(Color.black);
			}
		});
		
		// mise en page : placements des differents elements graphiques dans des Box
		boxMiseEnPageCoordonneesBancaires.add(texteCoordonnerBancaire);
		boxNumeroCarte.add(texteNumeroCarteBacaire);
		boxValiditeCarte.add(texteValiditeCarte);
		boxValiderCarte.add(validationCoordonneeBancaire);
		boxMiseEnPageCoordonneesBancaires.add(Box.createRigidArea(new Dimension(0, 30)));
		boxNumeroCarte.add(Box.createRigidArea(new Dimension(0, 30)));
		boxValiditeCarte.add(Box.createRigidArea(new Dimension(0, 30)));
		boxValiderCarte.add(Box.createRigidArea(new Dimension(0, 30)));
		
		boxNumeroCarte.add(textAreaNumeroCarte);
		boxValiditeCarte.add(textAreaDateExpiration);
		
		// mise en page : placements des differentes box dans une box principale
		boxMiseEnPageCoordonneesBancaires.add(boxNumeroCarte);
		boxMiseEnPageCoordonneesBancaires.add(boxValiditeCarte);
		boxMiseEnPageCoordonneesBancaires.add(boxValiderCarte);
		
		// mise en page : ajout de la box principale dans le panel
		this.add(boxMiseEnPageCoordonneesBancaires);
		boxMiseEnPageCoordonneesBancaires.setVisible(true);
		this.setVisible(false);
	}

	// Methode correspondante au nom du cas
	public void enregistrerCoordonneesBancairesas(int numClient, IUseEnregistrerCoordonneesBancaires panAppelant /*parametres metiers*/ ) {
		this.numClient=numClient;
		this.panAppelant = panAppelant;
		textAreaNumeroCarte.setText("");
		textAreaDateExpiration.setText("MMAA");
		this.setVisible(true);
		this.repaint();
	}

	// Methodes privees pour le bon deroulement du cas
	private void traitementCoordonneeBancaire(int numeroCarte, int dateCarte) {
		boolean carteValide = controlEnregistrerCoordonneesBancaires.enregistrerCoordonneesBancaires(numClient, numeroCarte, dateCarte);
		panAppelant.retourEnregistrerCoordonneesBancaire(carteValide);
	}
	
}