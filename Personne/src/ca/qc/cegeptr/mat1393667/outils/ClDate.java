package ca.qc.cegeptr.mat1393667.outils;

public class ClDate {
	
	private int annee;
	private int mois;
	private int jour;

	public ClDate()
	{
		annee=1;
		mois=1;
		jour=1;
		
	}
	public ClDate(int annee, int mois, int jour) {
		
		this.annee = annee;
		this.mois = mois;
		this.jour = jour;
	}


	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + annee;
		result = prime * result + jour;
		result = prime * result + mois;
		return result;
	}


	public boolean equals(ClDate obj) 
	{
		return ( annee == obj.getAnnee()
				&&
				mois == obj.getMois()
				&&
				jour == obj.getJour() );
		
	}


	public int getAnnee() {
		return annee;
	}


	public void setAnnee(int annee) {
		this.annee = annee;
	}


	public int getMois() {
		return mois;
	}


	public void setMois(int mois) {
		this.mois = mois;
	}


	public int getJour() {
		return jour;
	}


	public void setJour(int jour) {
		this.jour = jour;
	}
	
	

}
