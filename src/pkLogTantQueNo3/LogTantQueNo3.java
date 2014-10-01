package pkLogTantQueNo3;
import javax.swing.JOptionPane;
import java.text.*;
public class LogTantQueNo3 {
public static boolean montantOK(String sMontantTransact)
{
	boolean bRetour=true;
	sMontantTransact=sMontantTransact.length()==0?"-1":sMontantTransact;
	for(int i=0;i<sMontantTransact.length();i++)
	{
		if(!Character.isDigit(sMontantTransact.charAt(i)))
		{
			bRetour=false;
			break;
		}
	}
	return(bRetour);
}
	public static void main(String[] args) 
	{
		String sReponse="", sAffichage="", sMontantTransact="";
		double dSolde=0, dMontantTransact=0;
		NumberFormat argent=NumberFormat.getCurrencyInstance();
		
		while(true)
		{
			sAffichage+="**BANQUE CACHE-CASH**";
			sAffichage+="\nD - Dépôt";
			sAffichage+="\nR - Retrait";
			sAffichage+="\nF - Facture";
			sAffichage+="\nS - Solde";
			sAffichage+="\nT - Terminer";
			sReponse=JOptionPane.showInputDialog(null, sAffichage).toLowerCase();
			sReponse=sReponse.length()==0?"J":sReponse;
			switch(sReponse.charAt(0))
			{
				case 'd':
				{
					sAffichage="**Dépôt - BANQUE CACHE-CASH**";
					sAffichage+="\nSolde actuel "+ argent.format(dSolde);
					sAffichage+="\nMontant du dépot";
					if(montantOK(sMontantTransact=JOptionPane.showInputDialog(sAffichage)))
					{
						dMontantTransact=Double.parseDouble(sMontantTransact);
						if(dMontantTransact>0)
						{
							dSolde+=dMontantTransact;
							sAffichage="**Affichage du solde**";
							sAffichage+="\nNouveau solde "+argent.format(dSolde)+"\n";
						}
						else
							sAffichage="**Montant du retrait invalide**\n";
					}
					
					else
						sAffichage="**Montant du dépôt invalide**\n";
				break;
				}
				case 'r':
				{
					sAffichage="**Retrait - BANQUE CACHE-CASH**";
					sAffichage+="\nSolde actuel "+ argent.format(dSolde);
					if(montantOK(sMontantTransact=JOptionPane.showInputDialog(sAffichage)))
					{
						dMontantTransact=Double.parseDouble(sMontantTransact);
						if(dMontantTransact<=dSolde)
						{
							dSolde-=dMontantTransact;
							sAffichage="**Affichage du solde**";
							sAffichage+="\nNouveau solde "+argent.format(dSolde)+"\n";
						}
						else
							sAffichage="**Montant du retrait invalide**\n";
					}
					else
						sAffichage="**Montant du retrait invalide**\n";
				break;
				}
				case 'f':
				{
					sAffichage="**Paiement de facture - BANQUE CACHE-CASH**";
					sAffichage+="\nSolde actuel "+ argent.format(dSolde);
					if(montantOK(sMontantTransact=JOptionPane.showInputDialog(sAffichage)))
					{
						dMontantTransact=Double.parseDouble(sMontantTransact);
						if(dMontantTransact<=dSolde)
						{
							dSolde-=dMontantTransact;
							sAffichage="**Affichage du solde**";
							sAffichage+="\nNouveau solde "+argent.format(dSolde)+"\n";
						}
						else
							sAffichage="**Montant du paiement plus élevé que le solde**\n";
					}
					else
						sAffichage="**Montant du retrait invalide**\n";
				break;
				}
				case 's':
				{
					sAffichage="**Affichage du solde - BANQUE CACHE-CASH**";
					sAffichage+="\nSolde actuel "+argent.format(dSolde);
					JOptionPane.showMessageDialog(null, sAffichage, "Solde - BANQUE CACHE-CASH", JOptionPane.PLAIN_MESSAGE);
				break;
				}
				case 't':
				{
					System.exit(0);
					break;
				}
				default:
					sAffichage="**Sélection invalide**\n";
			}
		}
	}
}


