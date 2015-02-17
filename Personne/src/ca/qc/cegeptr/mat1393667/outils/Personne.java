package ca.qc.cegeptr.mat1393667.outils;

public class Personne {
	
	private String nom;
	private int age;
	
	private int montantArgent;
	
	public Personne()
	{
		nom = "aucun";
		age = 0;
		montantArgent=0;
	}

	public Personne(Personne unIndividu)
	{
		this.nom=unIndividu.getNom();
		this.age=unIndividu.getAge();
		this.montantArgent=unIndividu.getMontantArgent();
	}
	
	

	public Personne(String nom, int age, int montantArgent) {
		super();
		this.nom = nom;
		this.age = age;
		this.montantArgent=montantArgent;
	}

	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	
	public boolean equals(Personne obj) 
	{
		return( nom == obj.getNom()
				&&
				age == obj.getAge()

				&&
				montantArgent==obj.getMontantArgent()
				);
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setMontantArgent(int montantArgent)
	{
		this.montantArgent=montantArgent;
	}
	
	public int getMontantArgent(){
		return montantArgent;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public String toString() {
		return "Personne [nom=" + nom + ", age=" + age +", Montant d'argent="+montantArgent;

}}
