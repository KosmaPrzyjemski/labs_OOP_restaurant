package modele;

import java.util.ArrayList;

public class Menu {
	private Menu() {
	}

	ArrayList<Hamburger> listHamburger = new ArrayList<>();
	ArrayList<Accompagnement> listAccompagnement = new ArrayList<>();
	ArrayList<Boisson> listBoisson = new ArrayList<>();

	private static class MenuHolder {
		private final static Menu instance = new Menu();
	}

	public static Menu getInstance() {
		return MenuHolder.instance;
	}

	public void ajouterAliment(Hamburger hamburger) {
		listHamburger.add(hamburger);
	}

	public void ajouterAliment(Accompagnement accompagnement) {
		listAccompagnement.add(accompagnement);
	}

	public void ajouterAliment(Boisson boisson) {
		listBoisson.add(boisson);
	}

	public ArrayList<Hamburger> getListHamburger() {
		return listHamburger;
	}

	public ArrayList<Accompagnement> getListAccompagnement() {
		return listAccompagnement;
	}

	public ArrayList<Boisson> getListBoisson() {
		return listBoisson;
	}
	
	public Hamburger choixHamburger(int numeroHamburger) {
		return listHamburger.get(numeroHamburger-1);
	}
	
	public Accompagnement choixAccompagnement(int numeroAccompagnement) {
		return listAccompagnement.get(numeroAccompagnement-1);
	}

	public Boisson choixBoisson(int numeroBoisson) {
		return listBoisson.get(numeroBoisson-1);
	}

	@Override
	public String toString() {
		return "Menu [listHamburger=" + listHamburger + ", listAccompagnement=" + listAccompagnement + ", listBoisson="
				+ listBoisson + "]";
	}

}
