package lab13;

import javax.swing.JOptionPane;

public class ListeDeLecture {
	//Variable d'instance
	private String categorie;
	private String titre;
	private Piece[] p;
	//Variables statique
	//construteurs
	public ListeDeLecture() {
		categorie = JOptionPane.showInputDialog("Categorie : ", "Rock").trim();
		titre = JOptionPane.showInputDialog("titre : ","Tmartn here").trim();
		int n;
		do{
			 n = Integer.parseInt(JOptionPane.showInputDialog("Nombre de piece : ",3).trim());
		}while(n<1);
		p = new Piece[n];
		//On initialise les pieces du tableau
		for (int i = 0; i < n; i++) {
			p[i] = new Piece();
			
		}
	}
	//Methodes
	public void jouer() {
		for (int i = 0; i < p.length; i++) {
			p[i].jouer();
		}
	}
	
}
