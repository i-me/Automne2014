package pkMathematique;
public class Mathematique {

	public int iNbr1;
	public int iNbr2;
	
	public Mathematique()
	{
		iNbr1=6;
		iNbr2=2;
	}
	public int valeurAbsolue(int nombre)
	{
		return(Math.abs(nombre));
	}
	public int valeurMax()
	{
		int vMax;
		vMax=(iNbr1>iNbr2)?iNbr1:iNbr2;
		return(vMax);
	}
	public int valeurMin()
	{
		int vMin;
		vMin=(iNbr1<iNbr2)?iNbr1:iNbr2;
		return(vMin);
	}
	public int pow()
	{
		return((int)Math.pow((double)iNbr1, (double)iNbr2));
	}
	public double sqrt(int nombre)
	{
		return(Math.sqrt((double)nombre));
	}
	public int somme()
	{
		return(iNbr1+iNbr2);
	}
	public double moyenne()
	{
		return(somme()/2);
	}
	public String afficher()
	{
		return("Le nombre 1 est "+iNbr1+", le nombre 2 est "+iNbr2);
	}
	
	
}
