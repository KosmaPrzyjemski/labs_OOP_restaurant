package modele;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class BDPersonnel {
	private int numeroPersonnel = 0;
	private Map<Integer, Personnel> listePersonnel = new HashMap<>();

	private BDPersonnel() {
	}

	private static class BDPersonnelHolder {
		private final static BDPersonnel instance = new BDPersonnel();
	}

	public static BDPersonnel getInstance() {
		return BDPersonnelHolder.instance;
	}

	public void ajouterPersonnel(Personnel personnel) {
		listePersonnel.put(numeroPersonnel, personnel);
		numeroPersonnel++;
	}

	public int connexionPersonnel(String login, String mdp) {
		int numPers = 0;
		boolean profilExistant;

		Set<Map.Entry<Integer, Personnel>> vue = listePersonnel.entrySet();

		for (Entry<Integer, Personnel> entry : vue) {
			Personnel perso = entry.getValue();
			profilExistant = perso.verifierCorrespondanceProfil(login, mdp);
			if (profilExistant) {
				perso.connexionProfil();
			}
			numPers = entry.getKey();
		}
		return numPers;
		// personnel.connexionProfil();
	}

	public Personnel trouverPersonnel(int numeroProfil) {
		return listePersonnel.get(numeroProfil);
	}

	@Override
	public String toString() {
		return "BDPersonnel [listePersonnel=" + listePersonnel + "]";
	}

}
