package pkLogEnchainementEX6;
import javax.swing.JOptionPane;
import java.text.*;
public class LogEnchainementEX6 {

	public static void main(String[] args) {
		int iNbJourLocation;
		double dNbKilo, dPrixEss, dCoutLoca, dMontantVerse, dMontantDu;
		String message="";
		NumberFormat argent=NumberFormat.getCurrencyInstance();
		iNbJourLocation=Integer.parseInt(JOptionPane.showInputDialog("Nombre de jours de location"));
		dNbKilo=Double.parseDouble(JOptionPane.showInputDialog("Nombre de kilomètres parcourus"));
		dPrixEss=Double.parseDouble(JOptionPane.showInputDialog("Prix de l'essence"));
		dCoutLoca=iNbJourLocation*55;
		message="Cout location: "+argent.format(dCoutLoca);
		dCoutLoca+=(dPrixEss/15)*dNbKilo;
		message+="\nMontant essence: "+argent.format(dCoutLoca-(iNbJourLocation*55));
		message+="\nMontant total de la facture: "+argent.format(dCoutLoca);
		message+="\n*****************\nMontant versé par le client";
		dMontantVerse=Double.parseDouble(JOptionPane.showInputDialog(message));
		dMontantDu=dMontantVerse-dCoutLoca;
		JOptionPane.showMessageDialog(null, "Remettre au client "+argent.format(dMontantDu));
		
		
		
		
		

	}

}
