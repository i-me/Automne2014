package pkAgePersonne;

public class AgePersonne {
	public String sPrenom;
	public String sNom;
	public int iAge;
	
	public AgePersonne()
	{
		sPrenom="Robert";
		sNom="Laneuville";
		iAge=46;
	}
	public int dans10Ans()
	{
		return(iAge+10);
	}
	public int anneeNaissance(int iAnnee)
	{
		return(iAnnee-iAge);
	}
	public String nomComplet()
	{
		return(sPrenom+" "+ sNom);
	}
	public String afficher()
	{
		return("Nom: "+sNom+", Prenom: "+sPrenom+", Age: "+iAge);
	}

}
