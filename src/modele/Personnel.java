package modele;

public class Personnel extends Profil {
	private boolean gerant = false;
	
	public Personnel(String nomm, String prenomm, String mdpp) {
		super(nomm, prenomm, mdpp);
	}
	
	public void definirGerant() {
		gerant = true;
	}

	public boolean isGerant() {
		return gerant;
	}
	
	@Override
	public String toString() {
		return super.toString() + "gerant=" + gerant +  "]";
	}
	/*
	public String toString() {
		return "Profil [nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", mdp=" + mdp + ", connecte="
				+ connecte ; //+ "]"
	}
	*/
}
