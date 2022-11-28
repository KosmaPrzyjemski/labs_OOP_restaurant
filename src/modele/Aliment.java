package modele;

public abstract class Aliment {
	private String nom;
	
	public Aliment(String name) {
		nom = name;
	}
	
	public String getNom() {
		return nom;
	}

	@Override
	public String toString() {
		return "Aliment [nom=" + nom + "]";
	}
}
