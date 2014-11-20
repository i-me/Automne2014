package pkProgMatrice2D5;

public class ProgMatrice2D5 {

	public static void main(String[] args) {
		int iVecteur[]={5,2,4,3,2}, iMatrice[][]={{10,15,20},{30,20,10},{10,15,20},{30,20,20},{10,20,10}}, iMatriceResult[][]=new int[5][3];
		String sSortieVecteur="", sSortieMatrice="", sSortieMatriceResult="";
		for(int i=0;i<iMatrice.length;i++)//On va parcourir toutes les lignes du array
		{
			for(int i2=0;i2<iMatrice[i].length;i2++)//On va parcourir toutes les colonnes du array
			{
				iMatriceResult[i][i2]=iMatrice[i][i2]*iVecteur[i];
				sSortieMatrice+=iMatrice[i][i2]+"-";
				sSortieMatriceResult+=iMatriceResult[i][i2]+"-";
			}
			sSortieMatrice+="\n";
			sSortieMatriceResult+="\n";
			sSortieVecteur+=iVecteur[i]+"\n";
		}
		System.out.println("Vecteur: \n"+sSortieVecteur);
		System.out.println("Matrice: \n"+sSortieMatrice);
		System.out.println("Matrice resultante: \n"+sSortieMatriceResult);
	}

}
