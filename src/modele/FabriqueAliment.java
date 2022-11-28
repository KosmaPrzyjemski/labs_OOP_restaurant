package modele;

public class FabriqueAliment {

	
	public static Aliment creerAliment(AlimentMenu typeAliment, String nom) {
		//Aliment aliment = null;
		switch(typeAliment) {
		case HAMBURGER :
			//aliment = new Hamburger(nom);
			//break;
			return new Hamburger(nom);
		case ACCOMPAGNEMENT :
			//aliment = new Accompagnement(nom);
			return new Accompagnement(nom);
			//break;
		case BOISSON : 
			//aliment = new Boisson(nom);
			//break;
			return new Boisson(nom);
		default : 
			System.out.println("Something went wrong!");
			break;
		}
		return null;
	}
	
}
