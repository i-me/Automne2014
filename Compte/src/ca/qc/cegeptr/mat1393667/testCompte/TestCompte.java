package ca.qc.cegeptr.mat1393667.testCompte;
import ca.qc.cegeptr.mat1393667.outils.*;

public class TestCompte {

	public static void main(String[] args) {
		
		Compte unCompte = new Compte();
		Compte deuxCompte = new Compte("Olivier", new ClDate(2,12,23), 0.1,10);
		System.out.println("Un compte: "+unCompte.toString()+", deuxCompte: "+deuxCompte.toString());
		unCompte.setdTxInteret(0.25);
		System.out.println("Modification du taux interet à 0.25, Affichage du taux interet unCompte"+unCompte.getdTxInteret());
		unCompte.setdFraisMens(55);
		System.out.println("Modification des frais mensuel compte 1 à 55$, "+unCompte.getdFraisMens()+"");
		
	}

}
