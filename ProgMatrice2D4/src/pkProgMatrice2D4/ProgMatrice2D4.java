package pkProgMatrice2D4;

public class ProgMatrice2D4 {

	public static void main(String[] args) {
		int iMatA[][]={{1,1,1,1},{2,2,2,2},{3,3,3,3}}, iMatB[][]={{1,2,3},{1,2,3},{1,2,3},{1,2,3}}, iMatAB[]=new int[3], iSomme=0;
		String sSortieMatriceA="", sSortieMatriceB="", sSortieMatriceAB="";
		for(int i=0;i<iMatAB.length;i++)
		{
			for(int i2=0;i2<iMatA[i].length;i2++)
			{
				for(int i3=0;i3<iMatB.length;i3++)
				{
					iSomme+=iMatB[i3][i];
				}
				sSortieMatriceA+=iMatA[i][i2]+"-";
				iMatAB[i]+=iMatA[i][i2]*iSomme;
				iSomme=0;
			}
			sSortieMatriceAB+=iMatAB[i]+"-";
			sSortieMatriceA+="\n";
		}
		for(int i=0; i<iMatB.length;i++)
		{
			for(int i2=0;i2<iMatB[i].length;i2++)
			{
				sSortieMatriceB+=iMatB[i][i2]+"-";
			}
			sSortieMatriceB+="\n";
		}
		System.out.println("Matrice AB: \n"+sSortieMatriceAB);
		System.out.println("Matrice A: \n"+sSortieMatriceA);
		System.out.println("MatriceB: \n"+sSortieMatriceB);
			
	}

}
