package modele;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Map;

public class BDCommande {
	private Map<Integer, Commande> mapCommandes = new HashMap<>();
	private PropertyChangeSupport support = new PropertyChangeSupport(this);
	//private BDClient bdClient = BDClient.getInstance();

	private BDCommande() {
	}
	
	private static class BDCommandeHolder {
		private final static BDCommande instance = new BDCommande();
	}

	public static BDCommande getInstance() {
		return BDCommandeHolder.instance;
	}

	public int enregistrerCommande(int clientNumber, Hamburger burger, Accompagnement sidedish, Boisson drink) {
		Commande commande = new Commande(clientNumber, burger, sidedish, drink);
		int numeroCommande = commande.getNumeroCommandeAttribuee();
		mapCommandes.put(numeroCommande, commande);
		//Client client = bdClient.trouverClient(clientNumber);
		//client.ajouterCommandeAHistorique(numeroCommande);
		String[] labels = new String[4];
		labels[0] = String.valueOf(numeroCommande);
		labels[1] = burger.getNom();
		labels[2] = sidedish.getNom();
		labels[3] = drink.getNom();
		
		support.firePropertyChange(PropertyName.ENREGISTRER_COMMANDE.toString(), null, labels);
		
		return numeroCommande;
	}

	public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener) {
		support.addPropertyChangeListener(propertyName, listener);
	}
	
	public void viderCommandeJour() {
		mapCommandes.clear();
		Commande.initialiseNumeroCommande();
		support.firePropertyChange(PropertyName.VIDER_COMMANDE_JOUR.toString(), null, null);
	}
}
