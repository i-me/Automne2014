package ca.qc.cegeptr.mat1393667.outils;

public class PlusieursDes{
	private int iValeurDe[]=new int[3];
	public PlusieursDes()
	{
		for(int i=0;i<iValeurDe.length;i++)
		{
			lancer(i);
		}
		
	}
	public PlusieursDes(int iValeurSoumise[])
	{
		int iLongueurValeur=iValeurSoumise.length;//Ainsi, si moins de valeur soumises, on fait juste lancer les dés restants
		for(int i=0;i<iValeurDe.length;i++)
		{
			if(i<iLongueurValeur)//Ici est le test pour savoir si on a moins de valeurs que de dés
				setValeurOk(iValeurSoumise[i], i);
			else//Si il y a moins de valeurs entrées que de dés, on lance simplement le dé. Si il y a plus de valeur, Just too bad.
				lancer(i);
		}
	}

	public void setPlusieursLancer()
	{
		for(int i=0;i<iValeurDe.length;i++)
		{
			lancer(i);
		}
	}
	public void setValeurOk(int iValeur, int iNumeroDe)//Vérifie que la valeur est OK, sinon relance le dé.
	{
		int iValeurRetour;
		iValeurRetour=(iValeur>0&&iValeur<7)?iValeur:-1;
		if(iValeurRetour<0)
			lancer(iNumeroDe);
		else
			iValeurDe[iNumeroDe]=iValeurRetour;	
	}
	public int[] getValeurDes()
	{
		return(iValeurDe);
	}
	public String getValeurDesFormat()
	{
		int iValeurDes[]=getValeurDes();
		String sRetour="";
		for(int i=0;i<iValeurDes.length;i++)
		{
			sRetour+=iValeurDes[i];
		}
		return(sRetour);
	}

	private void lancer(int iNumeroDe)//Génére une valeur puis la passe dans setValeurOk. Evidemment la valeur généré va être OK, mais pour être logique.
	{
		/*Lancer(#de dé)*/
		int iValeurGeneree=1+(int)(Math.random()*6);
		setValeurOk(iValeurGeneree, iNumeroDe);
		
	}
	public boolean DeuxValeurIdentique()
	{
		int iDe[]=getValeurDes();
		boolean bDeuxNbOk=false;
		for(int i=0;i<iDe.length;i++)
		{
			for (int i2=0;i2<iDe.length;i2++)
			{
				if(iDe[i]==iDe[i2])
				{
					bDeuxNbOk=true;
					break;
				}
				
			}
			if(bDeuxNbOk)
				break;
		}
		return(bDeuxNbOk);
	}
	public String toString(int iNumeroDe)
	{
		int iDe[]=getValeurDes();
		return("La valeur de la face du dé "+iNumeroDe+", est "+iDe[iNumeroDe]);
	}
}