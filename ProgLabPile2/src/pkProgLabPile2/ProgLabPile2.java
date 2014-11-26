package pkProgLabPile2;
import javax.swing.JOptionPane;
public class ProgLabPile2 {

	public static void main(String[] args) {
		final int iTAILLETABLEAU=10;
		int iSommet=-1, iSommet2=-1, iPositionRetrait=-1;;
		String sSaisie="";
		String sPile[]=new String[iTAILLETABLEAU]/*sPile[]={"A","B","C","D","E","F","G","H","I","J"}*/, sPileTransfert[]=new String[iTAILLETABLEAU];
		String sMenu[]=new String[iTAILLETABLEAU+1];
		boolean err=false;
		for(int i=0;i<iTAILLETABLEAU;i++)
		{
			sMenu[i]=String.valueOf(i);
		}
		sMenu[iTAILLETABLEAU]="Quitter";
		while(true)
		{
			iSommet++;
			sSaisie=JOptionPane.showInputDialog("Veuillez saisir la donnée à ajouter à la pile. ("+(iSommet+1)+"/"+iTAILLETABLEAU+")");
			sPile[iSommet]=sSaisie;
			if((iSommet+1)==sPile.length)
			{
				break;
			}
		}
		
		do
		{
			sSaisie=String.valueOf(JOptionPane.showInputDialog("Choisir la position à supprimer entre 0 et "+iTAILLETABLEAU+")\n Saisir une lettre pour quitter"));
			for(int i=0;i<sSaisie.length();i++)
			{
				if(!Character.isDigit(sSaisie.charAt(i)))
				{
					JOptionPane.showMessageDialog(null,"Aurevoir");
					err=true;
					System.exit(1);
				}
			}
			iPositionRetrait=Integer.parseInt(sSaisie)-1;
			sPile[iPositionRetrait]="";
			for(int i=(iPositionRetrait+1);i<sPile.length;i++)
			{
				iSommet2++;
				sPileTransfert[iSommet2]=sPile[i];
				sPile[i]="";
			}
			for(int i=0;i<iSommet2;i++)
			{
				sPile[iPositionRetrait]=sPileTransfert[i];
				iPositionRetrait++;
			}
			iSommet--;
			for(int i=0;i<iSommet;i++)
			{
				System.out.println(sPile[i]);
			}
		}
		while(true);
	}
		

}
