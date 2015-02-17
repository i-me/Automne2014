package ca.qc.cegeptr.mat1393667.outils;

public class Robot {
	
	private String nom;
	public ClDate perDebut=new ClDate();
	public ClDate perFin=new ClDate();
	public Robot()
	{
		nom="Tequila";
	}
	public Robot(String nom)
	{
		this.nom=nom;
	}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}
	public boolean equals(Robot obj) {
		if(nom==obj.getNom()
				&&
				perDebut.getMois()==obj.perDebut.getMois()
				&&
				perFin.getMois()==obj.perFin.getMois())
			return(true);
		else
			return(false);
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public ClDate getPerDebut() {
		return perDebut;
	}
	public void setPerDebut(ClDate perDebut) {
		this.perDebut = perDebut;
	}
	public ClDate getPerFin() {
		return perFin;
	}
	public void setPerFin(ClDate perFin) {
		this.perFin = perFin;
	}
	public String verifierAgeMontant(Personne unePersonne)
	{
		String retour=nom;
		if(unePersonne.getAge()>=18)
		{
			if(unePersonne.getMontantArgent()>=100)
				retour+=" souhaite la bienvenue à "+unePersonne.getNom()+" vous pouvez entrer et bonne soirée";
			else 
				retour+=" se voit désolé pour "+ unePersonne.getNom() +" vous n'avez pas le montant requis";
		}
		else
			retour+=" se voit désoler pour "+unePersonne.getNom()+", vous n'avez pas 18 ans.";
		return(retour);
		
	}
	public String toString() {
		return "Robot [nom=" + nom + ", perDebut=" + perDebut + ", perFin="
				+ perFin + "]";
	}
	
	
}
