package lab13;
import javax.swing.*;

public class Piece {
	//Variable d'instance
	private String titre;
	private String artiste;
	private int duree;
	
	//Variable statique
	private static double facteur = 1.0;
	private static int largeur = 80;
	private static char c = '*';
	
	//Constucteurs
	public Piece() {
		titre = JOptionPane.showInputDialog("Titre de la piece : ").trim();
		artiste = JOptionPane.showInputDialog("Artiste de la piece : ").trim();
		do{
			duree = Integer.parseInt(JOptionPane.showInputDialog("Duree en secondes : ").trim());
		}while(duree<1);
	}
	
	public Piece( String t, String a, int d) {
		titre = t;
		artiste = a;
		duree = ( d<0 ? -d : d);
		
	}
	//Methodes
	public String getTitre() {
		return titre;
	}
	public String getArtiste() {
		return artiste;
	}
	public int getDuree() {
		return duree;
	}
	//renvoie la duree sous la forme 05:12
	public String getSDuree() {
		return String.format("%1$02d:%2$02d", duree/60, duree%60);
	}
	
	public  static double getFacteur() {
		return facteur;
	}
	
	public static int getLargeur() {
		return largeur;
		
	}
	
	public static char getC() {
		return c;
	}
	
	public static void setFacteur(double facteur ) {
		if(facteur>0.0 && facteur<=1.0) Piece.facteur = facteur;
		
	}
	
	public static void setLargeur( int largeur ) {
		if(largeur>=20) Piece.largeur = largeur;
	}
	
	public String toString() {
		String s = "[";
		int lar = (largeur-11)/2;
		if(titre.length()>lar) {
			s += titre.substring(0,lar-3) + "...";
			
			
		}
		else {
			s += String.format("%1$-"+lar+"s", titre);
		}
		s += '|';
		if(artiste.length()>lar) {
			s += artiste.substring(0,lar-3) + "...";
			
			
		}
		else {
			s += String.format("%1$-"+lar+"s", artiste);
		}
		if(largeur%2==0) s += " ";
		s += "| " + getSDuree() +" ]";
		
		return s;
	}//Fin du toString

	public void jouer() {
		System.out.println(this);
		System.out.print("|");
		for (int i = 0; i < largeur-2; i++) System.out.print("-");
		System.out.println("|");
		int delai = (int)(facteur*duree*1000/largeur);
		for (int i = 0; i < largeur; i++) {
			System.out.print(c);
			try{
				Thread.sleep(delai);
			}
			catch(InterruptedException e) {
				
			}
		}
		System.out.println(" Termine");	
		
	}


}
