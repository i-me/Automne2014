package pkComposition;

public class Personne {
private String nom;
private String prenom;
private int age;
private ClDate uneDate;
public Personne() {
	nom="Aucun";
	prenom="aucun";
	age= 0;
	uneDate=new ClDate();//Constructeur par défaut de la date
}
public Personne(String nom, String prenom, int age, ClDate uneDate) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.age = age;
	this.uneDate = uneDate;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public ClDate getUneDate() {
	return uneDate;
}
public void setUneDate(ClDate uneDate) {
	this.uneDate = uneDate;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + age;
	result = prime * result + ((nom == null) ? 0 : nom.hashCode());
	result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
	result = prime * result + ((uneDate == null) ? 0 : uneDate.hashCode());
	return result;
}
@Override
public boolean equals(Personne obj) {

return(nom.equals(obj.getNom())&&prenom.equals(obj.getPrenom())&&age==obj.getAge()&&undeDate.equals(obj.getUneDate()));
}

}

