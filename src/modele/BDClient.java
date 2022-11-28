package modele;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class BDClient {
	private int numeroClient = 1;
	private Map<Integer, Client> baseDeClient = new HashMap<>(); // baseDeClient;
	
	private BDClient() { // this.baseDeClient = new HashMap<>();
	}

	private static class BDClientHolder {
		private final static BDClient instance = new BDClient();
	}

	public static BDClient getInstance() {
		return BDClientHolder.instance;
	}

	public void ajouterClient(Client client) {
		baseDeClient.put(numeroClient, client);
		numeroClient++;
	}

	public int connexionClient(String login, String mdp) {
		int numClient = 0;
		boolean profilExistant;

		Set<Map.Entry<Integer, Client>> vue = baseDeClient.entrySet();

		for (Entry<Integer, Client> entry : vue) {
			Client perso = entry.getValue();
			profilExistant = perso.verifierCorrespondanceProfil(login, mdp);
			if (profilExistant) {
				perso.connexionProfil();
			}
			numClient = entry.getKey();
		}
		return numClient;
	}

	public Client trouverClient(int numeroProfil) {
		return baseDeClient.get(numeroProfil);
	}

	@Override
	public String toString() {
		return "BDClient [listeClient=" + baseDeClient + "]";
	}

}
