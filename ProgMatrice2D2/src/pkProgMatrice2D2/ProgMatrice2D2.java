package pkProgMatrice2D2;
import javax.swing.JOptionPane;
public class ProgMatrice2D2 {

	public static void main(String[] args) {
		int iNbColoneMatrice=3, iNbLigneMatrice=3;
		int iVecteur[]={10,20,30,40,50,60,70,80,90};
		int iMatrice[][]=new int[iNbLigneMatrice][iNbColoneMatrice];
		int iColoneTravailMatrice=0, iLigneTravailMatrice=0;
		String sSortieVecteur="", sSortieMatrice="";
		for (int i=0;i<iVecteur.length;i++)
		{
			sSortieVecteur+=iVecteur[i]+"-";
			sSortieMatrice+=iVecteur[i]+"-";
			iMatrice[iLigneTravailMatrice][iColoneTravailMatrice]=iVecteur[i];
			iColoneTravailMatrice++;
			if(iColoneTravailMatrice==iNbColoneMatrice)
			{
				iColoneTravailMatrice=0;
				iLigneTravailMatrice++;
				sSortieMatrice+="\n";
			}
		}
		System.out.println(sSortieVecteur);
		System.out.println(sSortieMatrice);
	}

}
