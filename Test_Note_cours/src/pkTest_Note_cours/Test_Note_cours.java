package pkTest_Note_cours;

public class Test_Note_cours {

	public static void main(String[] args) {
		String chaine1, chaine2, chaine3;
		chaine1="B";
		chaine2="b";
		chaine3="B";
		System.out.println(chaine1.compareTo(chaine2));
		System.out.println(chaine2.compareTo(chaine1));
		System.out.println(chaine1.compareTo(chaine3));
		char tChaine[]=new char[10];
		tChaine[0]='1';
		System.out.println(tChaine[3]+"--"+tChaine.length+" ");
	}

}
