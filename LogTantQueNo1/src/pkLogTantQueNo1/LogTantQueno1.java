package pkLogTantQueNo1;
import javax.swing.JOptionPane;
import java.text.*;
public class LogTantQueno1 {

	public static void main(String[] args)
	{
		int iAge=-1, iTailleGroupe=-1, iCarte=-1;
		double dPrixTotBillet, dEscompte, dPrixBaseBillet, dTPS, dTVQ, dPrcntgEscompte;
		final float TPS=0.05f, TVQ=0.095f;
		boolean bAClient=true, bErreur=false;
		String sNom, sTailleGroupe, sAge, sDestination, sTitre="Imbuzz airlines - Reservations";
		NumberFormat argent=NumberFormat.getCurrencyInstance();
		
		while(bAClient)
		{
			/* S�quence de saisie et validation des informations re�ues */
			do
			{
				sNom=JOptionPane.showInputDialog(null,"Nom du passager", sTitre, JOptionPane.PLAIN_MESSAGE);
			}while(sNom.equals("")!=true);
			do
			{
				sDestination=JOptionPane.showInputDialog(null,"Destination du passager", sTitre, JOptionPane.PLAIN_MESSAGE);
			}while(sDestination.equals("")!=true);
			do
			{
				sTailleGroupe=JOptionPane.showInputDialog(null,"Nombre de passagers", sTitre, JOptionPane.PLAIN_MESSAGE);
				for(int i=0;i<sTailleGroupe.length();i++)
				{
					if(!Character.isDigit(sTailleGroupe.charAt(i)))
					{
						bErreur=true; 
						break;
					}
				}
				if(!bErreur)
					iTailleGroupe=Integer.parseInt(sTailleGroupe);

			}while(iTailleGroupe<=0);
			bErreur=false;
			do
			{
				sAge=JOptionPane.showInputDialog(null,"�ge du passager", sTitre, JOptionPane.PLAIN_MESSAGE);
				for(int i=0;i<sAge.length();i++)
				{
					if(!Character.isDigit(sAge.charAt(i)))
					{
						bErreur=true;
						break;
					}
				}
				if(!bErreur)
					iAge=Integer.parseInt(sAge);
			}while(iAge<0);
			
			/*Fin de la s�quence de validation*/
			bAClient=(JOptionPane.showConfirmDialog(null, "Autre client?", sTitre, JOptionPane.YES_NO_OPTION)==0)?true:false;
		}
		
		
	}

}
