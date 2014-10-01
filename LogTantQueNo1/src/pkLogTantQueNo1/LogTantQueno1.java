package pkLogTantQueNo1;
import javax.swing.JOptionPane;
import java.text.*;
public class LogTantQueno1 {
	public static boolean isBetween(int iAge, int iNb1, int iNb2)
	{
		if(iAge>=iNb1 && iAge<=iNb2)
		{
			return(true);
		}
		else
			return(false);
		
	}
	public static void main(String[] args)
	{
		
		int iAge=-1, iTailleGroupe=-1, iCarte=-1;
		double dPrixTotBillet, dEscompte=0, dPrixBaseBillet=0, dPrixBillet=0,dTPS, dTVQ, dPrcntgEscompte=0, dEscompteMagic=0, dEscompteGroupe=0;
		final float TPS=0.05f, TVQ=0.095f;
		boolean bAClient=true, bErreur=false;
		
		/*Variables pour statistiques de fin de jour */
		int iNbClients=0, iTrancheAge1=0, iTrancheAge2=0, iTrancheAge3=0, iTrancheAge4=0;
		double dTotalPrixBaseBillet=0, dTotalEscompteGroupe=0, dTotalEscompteOr=0, dTotalEscompteArgent=0, dTotalTPS=0, dTotalTVQ=0, dTotalArgentJour=0;
		/*Fin variables pour statistiques de fin de jours*/
		String sNom, sTailleGroupe, sAge, sDestination, sCarte, sTitre="Imbuzz airlines - Reservations";
		NumberFormat argent=NumberFormat.getCurrencyInstance();
		
		while(bAClient)
		{
			iNbClients++;//Statistiques
			/* Séquence de saisie et validation des informations reçues */
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
				sAge=JOptionPane.showInputDialog(null,"Âge du passager", sTitre, JOptionPane.PLAIN_MESSAGE);
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
			/*Fin de la séquence de validation*/
			if(isBetween(iAge, 0,5))
			{
				dPrixBaseBillet=200;
				iTrancheAge1++;//Pour Statistiques
			}
			else if (isBetween(iAge, 6, 17))
			{
				dPrixBaseBillet=250;
				iTrancheAge2++;//Pour Statistiques
			}
			else if (isBetween(iAge, 18, 64))
			{
				dPrixBaseBillet=350;
				iTrancheAge3++;//Pour Statistiques
			}
			else if (iAge>64)
			{
				dPrixBaseBillet=275;
				iTrancheAge4++;//Pour Statistiques
				sCarte=JOptionPane.showInputDialog("Est-ce que le client a la carte Club Magic? (O)ui (N)on").toLowerCase();
				if(sCarte.charAt(0)=='o')
				{
					sCarte=JOptionPane.showInputDialog("Type de la carte : 0-OR, 1-Argent");
					if(sCarte.charAt(0)==0||sCarte.charAt(0)==1)
						iCarte=Integer.parseInt(sCarte);
					else
						iCarte=-1;
					switch(iCarte)
					{
						case 0://Carte OR
							dEscompteMagic+=25;
							dTotalEscompteOr++;//Pour Statistiques
							break;
						case 1://Carte Argent
							dEscompteMagic+=20;
							dTotalEscompteArgent++;//Pour statistiques
							break;
						default:
							dEscompteMagic+=0;
							
					}
					
				}
			}
			dTotalPrixBaseBillet+=dPrixBaseBillet;//Pour statistiques
			/*Escompte de groupe*/
				if(iTailleGroupe>=4&&iTailleGroupe<=9)
				{
					dPrcntgEscompte=0.10;
				}
				else if(iTailleGroupe>9)
				{
					dPrcntgEscompte=0.2;
				}
				dEscompteGroupe=dPrixBaseBillet*dPrcntgEscompte;
				dTotalEscompteGroupe+=dEscompteGroupe;//Pour Statistiques
			/*Fin escompte de groupe*/
			/*Calcul des sommes différentes taxes et des tarifs finaux */
				//Les taxes seront appliquées après escompte
				dEscompte=dEscompteGroupe+dEscompteMagic;
				dPrixBillet=dPrixBaseBillet-dEscompte;
				dTPS=dPrixBillet*TPS;
				dTotalTPS+=dTPS;//Pour Statistiques;
				dTVQ=dPrixBillet*TVQ;
				dTotalTVQ+=dTVQ;//Pour Statistiques;
				dPrixBillet+=dTPS+dTVQ;
				dTotalArgentJour+=dPrixBillet;//Pour statistiques
			/*Fin de calcul des sommes*/
			bAClient=(JOptionPane.showConfirmDialog(null, "Autre client?", sTitre, JOptionPane.YES_NO_OPTION)==0)?true:false;
		}
		
		
	}

}
