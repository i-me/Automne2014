package ca.qc.cegeptr.mat1393667.outils;

public class De {
	private int iValeurDe;//Ne pas oublier de remettre private
	public De()//Constructeur
	{
		lancer();
	}
	public De(int iValeurDe)
	{
		lancer();
	}
	public void setValeur(int iValeurDe)
	{
		this.iValeurDe=(iValeurDe>0&&iValeurDe<7)?iValeurDe:-1;
		if(getValeurDe()<0)
			lancer();
	}
	
	public int getValeurDe()
	{
		return(iValeurDe);
	}
	private void lancer()
	{
		int iValeurGeneree=1+(int)(Math.random()*6);	
		setValeur(iValeurGeneree);
	}
	public String toString()
	{
		return("La valeur du Dé est "+getValeurDe());
	}
	

}
