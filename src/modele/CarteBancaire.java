package modele;

public class CarteBancaire {
	private int numeroCarte;
	private int dateCarte;
	
	public CarteBancaire(int cardNumber, int expirationDate) {
		numeroCarte = cardNumber;
		dateCarte = expirationDate;
	}
	/*
	public int getNumeroCarte() {
		return numeroCarte;
	}

	public int getDateCarte() {
		return dateCarte;
	}
	*/

	@Override
	public String toString() {
		return "CarteBancaire [numeroCarte=" + numeroCarte + ", dateCarte=" + dateCarte + "]";
	}
}
