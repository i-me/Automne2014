package pkProgLab1EX12;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class ProgLab1EX12 {

	public static void main(String[] args) 
	{
		double soldePrecedent, soldeToPay, montantInteret, montantMin;
		String mois="", nomClient="INDEF.", sortie="Facture VIDE";
		final double TXINT=0.1, TXPMENTMIN=0.05;
		DecimalFormat argent=new DecimalFormat("0.00$");
		soldePrecedent=Double.parseDouble(JOptionPane.showInputDialog("Solde du mois précédent"));
		mois=JOptionPane.showInputDialog("Mois courant");
		nomClient=JOptionPane.showInputDialog("Nom du client");
		
		/*Début des calculs*/
		montantInteret=soldePrecedent*TXINT;
		soldeToPay=montantInteret+soldePrecedent;
		montantMin=soldeToPay*TXPMENTMIN;
		
		sortie="*****\n"+nomClient+"\n*****\n";
		sortie+="Facture du mois de "+mois+"\n";
		sortie+="*****\n";
		sortie+="Solde courant du compte :"+argent.format(soldeToPay)+"\n";
		sortie+="Montant minimal du paiement :"+argent.format(montantMin)+"\n";
		JOptionPane.showMessageDialog(null, sortie, "--Facture du mois de "+mois, JOptionPane.INFORMATION_MESSAGE);
		
	}

}
