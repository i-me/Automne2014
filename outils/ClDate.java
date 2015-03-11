package ca.qc.cegeptr.mat1393667.outils;
import javax.swing.JOptionPane.*;
/**
 * *Nom:ClDate
 * *Nom des classes: ClDate, JOptionPane
 * *Description: Contrôle de la date
 * *Nom et version de l'IDE: Eclipse Luna 4.4.0, JRE 1.8.0-20 
 * *OS: Windows 7 
 * *Auteur: Olivier Bois
 * *Date création: Mars 2015
 * 
 */
public class ClDate {

	private int iJour; 
	private int iMois; 
	private int iAnnee;
	public ClDate() {
		iJour=01;
		iMois=01;
		iAnnee=2000;
	}
	public ClDate(int iJour, int iMois, int iAnnee) {
		setiJour(iJour);
		setiMois(iMois);
		setiAnnee(iAnnee);
	}
	/*Généré automatiquement*/
	public int getiJour() {
		return iJour;
	}
	public void setiJour(int iJour) {
		if(isDateOK(iJour, iMois, iAnnee))
			this.iJour=iJour;
		else
			this.iJour=01;
	}
	public int getiMois() {
		return iMois;
	}
	public void setiMois(int iMois) {
		if(iMois>0&&iMois<=12)
			this.iMois=iMois;
		else
			this.iMois=01;
	}
	public int getiAnnee() {
		return iAnnee;
	}
	public void setiAnnee(int iAnnee) {
		this.iAnnee = iAnnee;
	}
	/*Fin généré automatiquement*/
	/*Opérations requises*/
	public String retourChaine()//Retourne sous la forme aaaa/mm/jj
	{
		return(iAnnee+"/"+iMois+"/"+iJour);
	}
	private boolean isDateOK(int iJour, int iMois, int iAnnee)
	{
		int tRelMois[][]={{1,31},{2,28},{3,31},{4,30},{5,31},{6,30},{7,31},{8,31},{9,30},{10,31},{11,30},{12,31}};
		if(iAnnee>0)
		{
			tRelMois[1][1]=(isAnneeBis(iAnnee))?29:28;
			System.out.println(tRelMois[1][1]);
			if(iMois>0&&iMois<=12)
			{System.out.println(1);
				if(iJour<=tRelMois[iMois-1][1]&&iJour>0)//Donc c'est valide
				{
					System.out.println(2);
					return(true);
				}
				else return(false);
			}
			else return(false);
		}
		else
			return(false);
				
		
	}
	private boolean isAnneeBis(int iAnnee)
	{
		if(iAnnee>0&&(((iAnnee%4==0)&&(iAnnee%100!=0))||iAnnee%400==0))//Yirk. C'est pas beau tu suite ça. 
			return(true);
		else
			return(false);
	}
	/*Fin opération requises*/
	/*Généré automatiquement*/
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + iAnnee;
		result = prime * result + iJour;
		result = prime * result + iMois;
		return result;
	}
	/*Généré automatiquement mais modifié pour Canonique orthodoxe*/
	public boolean equals(ClDate obj) {
		return(
				this.iJour==obj.getiJour()
				&&
				this.iMois==obj.getiMois()
				&&
				this.iAnnee==obj.getiAnnee()
				);
	}
	public String toString() {
		return "ClDate [iJour=" + iJour + ", iMois=" + iMois + ", iAnnee="
				+ iAnnee + "]";
	}
	/*Fin généré automatiquement et modifié pour canonique orthodoxe*/
	/*Fin généré automatiquement*/
	
	
}
