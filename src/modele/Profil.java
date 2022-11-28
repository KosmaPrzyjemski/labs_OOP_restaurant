package modele;

public abstract class Profil {
	private String nom;
	private String prenom;
	private String login;
	private String mdp;
	private boolean connecte = false;
	
	public Profil(String nomm, String prenomm, String mdpp) {
		nom = nomm;
		prenom = prenomm;
		login = prenomm + "." + nomm;
		mdp = mdpp;
	}
	
	@Override
	public String toString() {
		return "Profil [nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", mdp=" + mdp + ", connecte="
				+ connecte ; //+ "]"
	}

	public boolean verifierCorrespondanceProfil(String loginn, String mdpp) {
		return login.equals(loginn) && mdp.equals(mdpp);
	}
	
	public void connexionProfil() {
		connecte = true;
	}
	
	public boolean isConnecte() {
		return connecte;
	}
	
	/*
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	*/
}
