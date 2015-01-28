package pkChaineDeCaractere;

public class ChaineDeCaracteres {
	public String sChaine;
	public ChaineDeCaracteres()
	{
		sChaine="Le chat est gris.";
	}
	public int longueur()
	{
		return(sChaine.length());
	}
	public String comparer(String sChaine2)
	{
		if(sChaine.equals(sChaine2))
		{
			return("Les chaînes sont identiques");
		}
		else
			return("Les chaînes sont différentes");
	}
	public void concat(String sChaine2)
	{
		sChaine+=sChaine2;
	}
	public int positionChar(char Char1)
	{
		int iPosition=-1;
		for(int i=0;i<longueur();i++)
		{
			if(sChaine.charAt(i)==Char1)
			{
				iPosition=i;
				break;
			}
		}
		return(iPosition);
	}
	public String ssChaine(int iPositionDeb, int iPositionFin)
	{
		String sResult="";
		if(iPositionDeb>=0&&iPositionDeb<longueur()&&iPositionFin>=0&&iPositionFin<longueur())
		{
			for(int i=iPositionDeb;i<=iPositionFin-1;i++)
			{
				sResult+=""+sChaine.charAt(i);
			}
			if(sResult.equals(""))
			{
				sResult="CHAINE VIDE";
			}
		}
		else
		{
			sResult="ERREUR. POSITIONS EN DEHORS DES LIMITES";
		}
		return(sResult);
		
	}
	public String aPare()
	{
		String sSortie="";
		for(int i=0;i<longueur();i++)
		{
			if(sChaine.charAt(i)=='a')
				sSortie+="e";
			else if(sChaine.charAt(i)=='A')
				sSortie+="E";
			else
				sSortie+=sChaine.charAt(i);
		}
		return(sSortie);
	}
	public String minuscule()
	{
		return(sChaine.toLowerCase());
		
	}
	public String majuscule()
	{
		return(sChaine.toUpperCase());
	}
	public String afficher()
	{
		return("Chaine: "+sChaine);
	}
}
