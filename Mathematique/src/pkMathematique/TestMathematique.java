package pkMathematique;

public class TestMathematique {

	public static void main(String[] args) {
		Mathematique unMath=new Mathematique();
		unMath.iNbr1=-6;
		unMath.iNbr2=3;
		System.out.println("1-Valeur Absolue: "+unMath.valeurAbsolue(unMath.iNbr1));
		System.out.println("1-Valeur Max: "+ unMath.valeurMax());
		Mathematique deuxMath=new Mathematique();
		System.out.println("2-Puissance de deuxMath: "+deuxMath.pow());
		System.out.println("2-Racine carrée: "+deuxMath.sqrt(deuxMath.iNbr2));
		System.out.println("2-Somme: "+deuxMath.somme());
		System.out.println("2-Moyenne:"+deuxMath.moyenne());
		System.out.println("1-unMath: "+unMath.afficher());
		System.out.println("2-deuxMath: "+deuxMath.afficher());
	}

}
