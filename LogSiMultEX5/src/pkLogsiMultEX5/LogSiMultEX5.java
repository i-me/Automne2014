package pkLogsiMultEX5;
import javax.swing.JOptionPane;
import java.text.NumberFormat;

public class LogSiMultEX5 {

	public static void main(String[] args) 
	{
		String sMois, sMessage;
		int iJourPaiement=0, iNoClient=0;
		double dPrcntgAppli=0, dPaiement=0, dSoldeCourant=0, dSoldePrcntg=0, dSoldeProchain=0;
		NumberFormat argent=NumberFormat.getCurrencyInstance();
		
		iNoClient=Integer.parseInt(JOptionPane.showInputDialog("No de client"));
		dSoldeCourant=Double.parseDouble(JOptionPane.showInputDialog("Solde courant"));
		iJourPaiement=Integer.parseInt(JOptionPane.showInputDialog("Jour du paiement"));
		sMois=JOptionPane.showInputDialog("Mois du paiement");
		dPaiement=Double.parseDouble(JOptionPane.showInputDialog("Montant du paiement effectué"));
		
		if(iJourPaiement>0)
		{
			if (iJourPaiement<5)
			{
				dPrcntgAppli=-0.1;
			}
			else if(iJourPaiement<=10)
			{
				dPrcntgAppli=-0.05;
			}
			else if(iJourPaiement>19)
			{
				dPrcntgAppli=0.1;
			}
		}
		dSoldePrcntg=dSoldeCourant*dPrcntgAppli;
		dSoldeProchain=(dSoldeCourant+dSoldePrcntg)-dPaiement;//Si il y a une escompte, dSoldePrcntg sera negatif
		sMessage="Le client numéro "+iNoClient+" doit payer "+argent.format(dSoldeCourant)+" pour le mois de "+sMois+".";
		sMessage+="\nLe paiement est effecuté le "+iJourPaiement+" "+sMois+" au montant de "+argent.format(dPaiement);
		
		if(dSoldeProchain>0)
		{
			dPrcntgAppli=0.2;
			dSoldePrcntg=dPrcntgAppli*dSoldeProchain;//
			sMessage+="\nUne pénalité de "+ argent.format(dSoldePrcntg)+" sera ajouté au solde";
			sMessage+="\nIl lui reste donc "+ argent.format(dSoldePrcntg+dSoldeProchain)+" à payer pour le mois prochains";
			
		}
		System.out.println(sMessage);
		
	}

}
