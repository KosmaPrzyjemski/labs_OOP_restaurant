package modele;

public class Commande {
    private static int numeroCommande = 0;
    private int numClient;
    private int numeroCommandeAttribuee;
    private Hamburger hamburger;
    private Boisson boisson;
    private Accompagnement accompagnement;

    public Commande(int numClient, Hamburger hamburger, Accompagnement accompagnement, Boisson boisson) {
        this.numClient = numClient;
        this.hamburger = hamburger;
        this.boisson = boisson;
        this.accompagnement = accompagnement;
        numeroCommande++;
        this.numeroCommandeAttribuee = numeroCommande;
    }

    public int getNumClient() {
        return numClient;
    }
    
    public Hamburger getHamburger() {
        return hamburger;
    }

    public Accompagnement getAccompagnement() {
        return accompagnement;
    }

    public Boisson getBoisson() {
        return boisson;
    }

    public int getNumeroCommandeAttribuee() {
        return numeroCommandeAttribuee;
    }
    
    public static void initialiseNumeroCommande(){
    	numeroCommande = 0;
    }

}