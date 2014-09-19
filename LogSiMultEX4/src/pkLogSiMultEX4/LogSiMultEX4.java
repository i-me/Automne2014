package pkLogSiMultEX4;
import javax.swing.JOptionPane;
import java.text.*;

public class LogSiMultEX4 {

	public static void main(String[] args) {
		String sBroche, sTroue, sMembre, sDelai;
		boolean bBroche, bTroue, bMembre, bDelai;
		double dTarif=0, dCoutTotal=0;
		int iNbCopie=0;
		final String choix="(O)ui/(N)on";
		NumberFormat argent=NumberFormat.getCurrencyInstance();
		
		iNbCopie=Integer.parseInt(JOptionPane.showInputDialog("Combien de copies sont à faires"));
		if(iNbCopie>=0)
		{
			dTarif=0.05;
			if(iNbCopie>=500&&iNbCopie<1000)
			{
				dTarif=0.04;
			}
			else if(iNbCopie>=1000)
			{
				dTarif=0.03;
			}
			else
			{
				dTarif=0;
			}
		}
		sBroche=JOptionPane.showInputDialog("Voulez-Vous brocher les copies"+choix).toLowerCase();
		dTarif=(sBroche.charAt(0)=='o')?dTarif+=0.02:dTarif;
		
		sTroue=JOptionPane.showInputDialog("Voulez-vous trouer les copies?"+choix).toLowerCase();
		dTarif=(sTroue.charAt(0)=='o')?dTarif+=0.03:dTarif;
		
		sMembre=JOptionPane.showInputDialog("Êtes vous membre?"+choix).toLowerCase();
		dCoutTotal=(sMembre.charAt(0)=='o')?dCoutTotal-5:dCoutTotal;
		
		sDelai=JOptionPane.showInputDialog("Désirez-vous la livraison?"+choix).toLowerCase();
		dCoutTotal=(sDelai.charAt(0)=='o')?dCoutTotal+10:dCoutTotal;
		
		dCoutTotal+=(dTarif*iNbCopie);
		System.out.println("Total de la facture "+argent.format(dCoutTotal));
		
	}

}
