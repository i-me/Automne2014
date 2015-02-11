package ca.qc.cegeptr.mat1393667.test;
import ca.qc.cegeptr.mat1393667.outils.*;
public class testPlusieursDes {

	public static void main(String[] args) {
		PlusieursDes unDe=new PlusieursDes();
		int iValeurs[]={2,3};
		PlusieursDes deuxDe=new PlusieursDes(iValeurs);
		System.out.println("PREMIER JEU : ");
		int iValeursDe[]=unDe.getValeurDes();
		String sValeur="";
		for(int i=0;i<iValeursDe.length;i++)
		{/*À Noter que ceci ne sert qu'à représenter l'usage de la methode getValeurdes() qui retourne l'array des valeurs*/
			sValeur+=iValeursDe[i]+"-";
		}
		System.out.println("Les valeurs sont: "+sValeur);
		System.out.println("Deux valeurs identiques?"+unDe.DeuxValeurIdentique());
		System.out.println("Lançons le premier jeu à nouveau");
		unDe.setPlusieursLancer();
		//on met  valeurs impossible pour que le
		//script catch l'error et lance les dés ( >0 &&<7)
		unDe.setValeurOk(66,1);
		System.out.println(unDe.getValeurDesFormat());
		System.out.println("DEUXIEME JEU VALEURS SOUMISES (2, 3, random):");
		sValeur="";
		System.out.println("Les valeurs sont: "+deuxDe.getValeurDesFormat());
		System.out.println(deuxDe.toString(1));
	}

}
/*
PREMIER JEU : 
Les valeurs sont: 5-2-2-
Deux valeurs identiques?true
Lançons le premier jeu à nouveau
413
DEUXIEME JEU VALEURS SOUMISES (2, 3, random):
Les valeurs sont: 233
La valeur de la face du dé 1, est 3
*/