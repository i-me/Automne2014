package pkProgMatrice2D3;
import javax.swing.JOptionPane;

public class ProgMatrice2D3 {

	public static void main(String[] args) {
		final int iNBLIGNE=3, iNBCOLONNE=5;
		int iMatriceA[][]=new int[iNBLIGNE][iNBCOLONNE];
		int iTotLigne[]=new int[iNBLIGNE], iTotColonne[]=new int[iNBCOLONNE];
		
		int iLigneTravail=0, iColonneTravail=0;
		String sSaisie="", sSortieMatriceA="", sSortieTotColonne="", sSortieTotLigne="";
		
		boolean err=false;
		int iCodeErreur=0;
		for(int i=0;i<iNBLIGNE;i++)
		{
			for(int i2=0;i2<iNBCOLONNE;i2++)
			{
				sSaisie=JOptionPane.showInputDialog("Saisir l'entier désiré matrice Ligne: "+(iLigneTravail+1)+", Colonne: "+(iColonneTravail+1));
				for(int i3=0;i3<sSaisie.length();i3++)
				{
					if(!(Character.isDigit(sSaisie.charAt(i3))))
						err=true;
				}
				if(!err)
				{
					iMatriceA[iLigneTravail][iColonneTravail]=Integer.parseInt(sSaisie);
					iTotColonne[iColonneTravail]+=iMatriceA[iLigneTravail][iColonneTravail];
					iTotLigne[iLigneTravail]+=iMatriceA[iLigneTravail][iColonneTravail];
					sSortieMatriceA+=iMatriceA[iLigneTravail][iColonneTravail]+"-";
					
					iColonneTravail++;
					if(iColonneTravail==iNBCOLONNE)
					{
						sSortieTotLigne+=iTotLigne[iLigneTravail]+"-\n";
						sSortieMatriceA+="\n";
						iColonneTravail=0;
						iLigneTravail++;
					}
				}
				if(err)
				{
					JOptionPane.showMessageDialog(null, "La saisie n'est pas un nombre entier. Merci de retenter", "Erreur d'exécution", JOptionPane.ERROR_MESSAGE);
					i2--;
					err=false;
				}
			}
			
		}
		for(int i=0;i<iNBCOLONNE;i++)
		{
			sSortieTotColonne+=iTotColonne[i]+"-";
		}
		System.out.println("La matrice :\n"+sSortieMatriceA);
		System.out.println("Total des colonnes: \n"+sSortieTotColonne);
		System.out.println("Total des lignes: \n"+sSortieTotLigne);
	}

}
