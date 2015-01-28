package pkChaineDeCaractere;

public class TestChaineDeCaractere {

	public static void main(String[] args) {
		ChaineDeCaracteres uneChaine = new ChaineDeCaracteres();
		uneChaine.sChaine="C1-"+uneChaine.sChaine;
		System.out.println("longueur une Chaine: "+uneChaine.longueur());
		System.out.println("Comparaison entre uneChaine ("+uneChaine.afficher()+") et elle même: "+ uneChaine.comparer(uneChaine.sChaine));
		ChaineDeCaracteres deuxChaine= new ChaineDeCaracteres();
		deuxChaine.sChaine="C2-Bonjour je suis un abricot";
		System.out.println("Comparer de "+uneChaine.afficher()+" et "+deuxChaine.afficher()+": "+uneChaine.comparer(deuxChaine.sChaine));
		uneChaine.concat(deuxChaine.sChaine);//Concatenation
		System.out.println("uneChaine concatene avec deuxChaine: "+uneChaine.afficher());
		System.out.println("Position du char i dans uneChaine( à partir de 0): "+ uneChaine.positionChar('i'));
		System.out.println("position [0 à 4[ dans deux Chaine: "+ deuxChaine.ssChaine(0, 4));
		System.out.println("Remplacer A par E: "+uneChaine.aPare());
		System.out.println("deuxChaine en minuscule: "+ deuxChaine.minuscule());
		System.out.println("deuxChaine en majuscule: "+ deuxChaine.majuscule());
		
	}

}
