package pkLogSiMultEX3;
import javax.swing.JOptionPane;
import java.text.*;
public class LogSiMultEX3 {

	public static void main(String[] args) 
	{
		int iNumeroVendeur=0, iAnciennete=0;
		double dVentes=0, dBonus=0;
		String message="";
		double prcntBns=0.05;
		NumberFormat argent=NumberFormat.getCurrencyInstance();
		
		iNumeroVendeur=Integer.parseInt(JOptionPane.showInputDialog("Num�ro du vendeur"));
		dVentes=Double.parseDouble(JOptionPane.showInputDialog("Montant des ventes"));
		iAnciennete=Integer.parseInt(JOptionPane.showInputDialog("Ann�es d'anciennet�"));
		
		if(dVentes>=5000)
		{
			prcntBns+=0.05;
			if(iAnciennete>=5)
			{
				prcntBns+=0.04;
			}
		}
		dBonus=dVentes*prcntBns;
		message+="No. Vendeur "+iNumeroVendeur;
		message+="\nMontant du bonus"+argent.format(dBonus);
		System.out.println(message);
	}

}
