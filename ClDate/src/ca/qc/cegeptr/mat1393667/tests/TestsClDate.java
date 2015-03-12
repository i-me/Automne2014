package ca.qc.cegeptr.mat1393667.tests;
import ca.qc.cegeptr.mat1393667.outils.*;

/**
 * *Nom:ClDate
 * *Nom des classes: ClDate
 * *Description: Contrôle de la date
 * *Nom et version de l'IDE: Eclipse Luna 4.4.0, JRE 1.8.0-20 
 * *OS: Windows 7 
 * *Auteur: Olivier Bois
 * *Date création: Février 2015
 * *Date de modification: Mars 2015
 * 
 */
public class TestsClDate {

	public static void main(String[] args) {

	ClDate unDate=new ClDate(4,2,2002);
	unDate.setiJour();
	ClDate deuxDate=new ClDate(55,2,2002);//Date valide
	ClDate troisDate=new ClDate(4,18,2002);//Date invalide
	System.out.println("Affichons les dates, unDate(Constructeur par défaut):"+unDate.retourChaine()+", deuxdate:"+deuxDate.retourChaine()+", troisDate(initialisé 21/02/2012, date invalide):"+troisDate.retourChaine());
	troisDate.setiJour(28);
	System.out.println("Corrigeons la date de troisDate ( Testons au passage setiJour)"+troisDate.retourChaine());
	troisDate.setiAnnee(2016);
	troisDate.setiJour(29);
	System.out.println("Changeons l'année de troisDate pour en faire une annéee bissextile et adaptons le nombre de jours pour tester(Testons au passage setiAnnee)"+troisDate.retourChaine());
	deuxDate.setiMois();
	System.out.println("Tentons d'assigner deux Date le mois 13 (test des limites setiMois):"+deuxDate.getiMois());
	deuxDate.setiMois(12);
	System.out.println("Assignation du mois 12 pour deuxdate"+deuxDate.getiMois());
	System.out.println("À noter que iAnnee n'a aucun dispositif de limitation. Annéee négative = A.V, Année positive \"infini\"");
	unDate=new ClDate(deuxDate.getiJour(), deuxDate.getiMois(), deuxDate.getiAnnee());
	System.out.println("Test equals deuxDate et troisDate: "+deuxDate.equals(troisDate));
	System.out.println("Valeurs de unDate changées pour les valeurs de deuxDate. Comparation entre deuxDate et unDate: "+deuxDate.equals(unDate));
	System.out.println("unDate:"+unDate.toString()+"\ndeuxDate:"+deuxDate.toString());
	
	}

}
/*Affichons les dates, unDate(Constructeur par défaut):2000/1/1, deuxdate:2004/10/1, troisDate(initialisé 21/02/2012, date invalide):2012/2/1
29
1
2
Corrigeons la date de troisDate ( Testons au passage setiJour)2012/2/28
29
1
2
Changeons l'année de troisDate pour en faire une annéee bissextile et adaptons le nombre de jours pour tester(Testons au passage setiAnnee)2016/2/29
Tentons d'assigner deux Date le mois 13 (test des limites setiMois):1
Assignation du mois 12 pour deuxdate12
À noter que iAnnee n'a aucun dispositif de limitation. Annéee négative = A.V, Année positive "infini"
Test equals deuxDate et troisDate: false
Valeurs de unDate changées pour les valeurs de deuxDate. Comparation entre deuxDate et unDate: true
unDate:ClDate [iJour=1, iMois=12, iAnnee=2004]
deuxDate:ClDate [iJour=1, iMois=12, iAnnee=2004]
*/