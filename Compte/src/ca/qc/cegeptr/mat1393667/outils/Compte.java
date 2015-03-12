package ca.qc.cegeptr.mat1393667.outils;
import javax.swing.JOptionPane;

import ca.qc.cegeptr.mat1393667.outils.ClDate;
public class Compte {
	private double dSolde;
	private int iNumeroCompte;
	private String sNom;
	private ClDate dateOuverture;
	static private double dTxInteret=0.15;
	static private double dFraisMens=10;
	static private int iProchainsCompte=0;
	public Compte()
	{
		dSolde=0;
		iNumeroCompte=0;
		sNom="Martin VOID";
		dateOuverture=new ClDate(12,12,2012);//12 Décembre 2012
	}
	public Compte(String _sNom,ClDate _dateOuverture, double dTxInteret, double dFraisMens)
	{
		setiNumeroCompte();
		setsNom(_sNom);
		dateOuverture=_dateOuverture;//Comme _dateOuverture du type ClDate, vérification validité date effectuée au moment de l'init
		setdTxInteret(dTxInteret);
		setdFraisMens(dFraisMens);
	}
	public void setiNumeroCompte()
	{
		iNumeroCompte=iProchainsCompte++;
	}
	public int getiNumeroCompte()
	{
		return(iNumeroCompte);
	}
	public void setsNom(String _sNom)
	{
		boolean err=false;
		for(int i=0;i<_sNom.length();i++)
		{
			if(!(!(Character.isDigit(_sNom.charAt(i)))||(_sNom.charAt(i)=='-'||_sNom.charAt(i)==' ')))
			{
				err=true;
				break;
			}
		}
		if(err)
		{
			setsNom(JOptionPane.showInputDialog("Saisir un nom valide"));
		}
	}
	public String getsNom()
	{
		return(sNom);
	}
	public double getdSolde()
	{
		return(dSolde);	
	}
	public String getdateOuverture()
	{
		return(dateOuverture.retourChaine());
	}
	public static void setdTxInteret(double dTx)
	{
		if(dTx<1&&dTx>0)
			dTxInteret=dTx;
		else
			dTxInteret=0.15;
	}
	public static double getdTxInteret()
	{
		return(dTxInteret);
	}
	public static void setdFraisMens(double dFraisMens)
	{
		if(dFraisMens>0)
		Compte.dFraisMens=dFraisMens;
	}
	public static double getdFraisMens()
	{
		return(dFraisMens);
	}
	public static int getiProchainsCompte()
	{
		return(iProchainsCompte);
	}
	/*Fin de set/get*/
	/*Début des méthodes relatives à la classe*/
	public boolean retrait(double dMontant)
	{
		if(dSolde>dMontant&&dSolde>0&&dMontant>0)
		{
			dSolde-=dMontant;
			return(true);
		}
		else return(false);
	}
	public boolean depot(double dMontant)
	{
		if(dMontant>0)
		{
			dSolde+=dMontant;
			return(true);
		}
		else return(false);
	}
	public double interet()
	{
		double dMontantInteret=dSolde*dTxInteret;
		dSolde+=dMontantInteret;
		return(dMontantInteret);
	}
	public double frais()
	{
		if(retrait(dFraisMens))
			return(dFraisMens);
		else{
			System.out.println("Le compte est vide, impossible de charger les frais d'intérêts");
			return(0);}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(dSolde);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((dateOuverture == null) ? 0 : dateOuverture.hashCode());
		result = prime * result + iNumeroCompte;
		result = prime * result + ((sNom == null) ? 0 : sNom.hashCode());
		return result;
	}
	public boolean equals(Compte unCompte) {
		boolean err=true;
		if(dSolde==unCompte.getdSolde())
			if(iNumeroCompte==unCompte.getiNumeroCompte())
				if(sNom==unCompte.getsNom())
					if(dateOuverture.equals(unCompte.dateOuverture))
						err=false;
		return(err);
					
	}
	@Override
	public String toString() {
		return "Compte [dSolde=" + dSolde + ", iNumeroCompte=" + iNumeroCompte
				+ ", sNom=" + sNom + ", dateOuverture=" + dateOuverture + "]";
	}
	
}
