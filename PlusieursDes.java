package ca.qc.cegeptr.mat1393667.outils;

public class PlusieursDes{
	private int iValeurDe1, iValeurDe2, iValeurDe3;
	public PlusieursDes()
	{
		iValeurDe1=lancer();
		iValeurDe2=lancer();
		iValeurDe3=lancer();
	}
	public PlusieursDes(int iValeur1, int iValeur2, int iValeur3)
	{
		iValeurDe1=(valeurOK(iValeur1))?iValeur1:lancer();
		iValeurDe2=(valeurOK(iValeur2))?iValeur2:lancer();
		iValeurDe3=(valeurOK(iValeur3))?iValeur3:lancer();
	}
	private boolean valeurOK(int iValeur)
	{
		boolean err=(iValeur>0&&iValeur<7)?false:true;
		return(err);
	}
	private int lancer()
	{
		int iValeurGeneree=1+(int)(Math.random()*6);	
		return iValeurGeneree;
	}
}