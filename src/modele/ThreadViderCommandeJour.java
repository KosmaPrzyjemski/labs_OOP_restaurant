package modele;

import java.util.Calendar;

public class ThreadViderCommandeJour extends Thread {
	public boolean condition = true;
	public int jourReference;
	private BDCommande bdcommande = BDCommande.getInstance();
	
	public ThreadViderCommandeJour() {
		Calendar calendar = Calendar.getInstance();
		jourReference = calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	public void arret() {
		this.condition = false;
	}
	
	public void run() {
		do {
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			/* En reel
			 * Calendar.calendar = Calendar.getInstance();
			 * int date = calendar.get(Calendar.DAY_OF_MONTH;
			 * if (date != jourReference) {
			 * 	jour Reference = date;
			 *  System.out.println("Vider les commandes");
			 * }
			 * */
			Calendar calendar = Calendar.getInstance();
			int minute = calendar.get(Calendar.MINUTE);
			if (minute == 33) {
				bdcommande.viderCommandeJour();
			}
		} while (condition);
	}
}
