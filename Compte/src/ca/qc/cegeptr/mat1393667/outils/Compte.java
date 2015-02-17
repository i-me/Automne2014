package ca.qc.cegeptr.mat1393667.outils;
import javax.swing.JOptionPane;
public class Compte {
	private double dSolde;
	private int iNumeroCompte;
	private String sNom;
	private ClDate dateOuverture;
	static private double TXINTERET=0.15;
	static private double FRAISMENS=10;
	
	public Compte()
	{
		dSolde=0;
		iNumeroCompte=0;
		sNom="Martin VOID";
		dateOuverture=new ClDate(12,12,2012);//12 Décembre 2012
	}
	public Compte(int _iNumeroCompte, String _sNom,ClDate _dateOuverture )
	{
		setNumeroCompte(_iNumeroCompte);
		setNom(_sNom);
		setDateOuverture(_dateOuverture);
	}
	public void setNumeroCompte(int _iNumeroCompte)
	{
		if(_iNumeroCompte>0)//Je m'assure que le numéro du compte soit au dessus de 0 :) 
		{
			iNumeroCompte=_iNumeroCompte;
		}
		else
		{
			setNumeroCompte(Integer.parseInt(JOptionPane.showInputDialog("Saisir un numéro de compte valide.")));//On fait quoi? À VOIR JOPTION PANE MAYBE
		}
	}
	public void setNom(String _sNom)
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
			setNom(JOptionPane.showInputDialog("Saisir un nom valide"));
		}
	}
}
