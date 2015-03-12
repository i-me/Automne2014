package ca.qc.cegeptr.mat1393667.outils;
import javax.swing.JOptionPane;

/**
 * *Nom:ClDate AVEC TRY CATCH
 * *Nom des classes: ClDate, JOptionPane
 * *Description: Contr�le de la date
 * *Nom et version de l'IDE: Eclipse Luna 4.4.0, JRE 1.8.0-20 
 * *OS: Windows 7 
 * *Auteur: Olivier Bois
 * *Date cr�ation: Mars 2015
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
		setiAnnee(iAnnee);
		setiMois(iMois);
		setiJour(iJour);
	}
	public ClDate(ClDate _date)
	{
		setiAnnee(_date.getiAnnee());
		setiMois(_date.getiMois());
		setiJour(_date.getiJour());
	}
	/*G�n�r� automatiquement*/
	public int getiJour() {
		return iJour;
	}
	public void setiJour()
	{
		String striJour=JOptionPane.showInputDialog("Saisir le jour");
		
		try
		{
			int iJourT=Integer.parseInt(striJour);
		if(isDateOK(iJourT, iMois, iAnnee))
			this.iJour=iJourT;
		else
			this.iJour=01;
		}
		catch(NumberFormatException exc)
		{
			this.iJour=01;
			System.out.println("Le jour fournis n'�tait pas num�rique, une valeur par d�faut a �t� assign�e");
			
		}
		catch(IllegalArgumentException err)
		{
			System.out.println("Nombre ill�gal fournis "+err.getMessage());
		}
		finally
		{
			System.out.println("Jour OK");
		}
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
	public void setiMois()
	{
		String striMois=JOptionPane.showInputDialog("Saisir un mois");
		try
		{
		int iMoisT=Integer.parseInt(striMois);
		if(iMoisT>0&&iMoisT<=12)
			this.iMois=iMoisT;
		else
			this.iMois=01;
		}
		catch(ArithmeticException exc)
		{
			this.iMois=01;
			System.out.println("Le mois fournis n'�tait pas num�rique, une valeur par d�faut a �t� assign�e");
		}
		catch(IndexOutOfBoundsException err)
		{
			this.iMois=01;
			System.out.println("Le mois fournis �tait invalide. Une valeur par d�faut a �t� assign�e");
		}
		finally
		{
			System.out.println("iMois OK");
			
		}
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
	/*Fin g�n�r� automatiquement*/
	/*Op�rations requises*/
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
			if(iMois>0&&iMois<=12)
				if(iJour<=tRelMois[iMois-1][1]&&iJour>0)//Donc c'est valide
					return(true);
				else return(false);
			else return(false);
		}
		else return(false);
				
		
	}
	private boolean isAnneeBis(int iAnnee)
	{
		if(iAnnee>0&&(((iAnnee%4==0)&&(iAnnee%100!=0))||iAnnee%400==0))//Yirk. C'est pas beau tu suite �a. 
			return(true);
		else
			return(false);
	}
	/*Fin op�ration requises*/
	/*G�n�r� automatiquement*/
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + iAnnee;
		result = prime * result + iJour;
		result = prime * result + iMois;
		return result;
	}
	/*G�n�r� automatiquement mais modifi� pour Canonique orthodoxe*/
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
	/*Fin g�n�r� automatiquement et modifi� pour canonique orthodoxe*/
	/*Fin g�n�r� automatiquement*/
	
	
}
