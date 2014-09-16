package pkLogEnchainementEX2;
import javax.swing.JOptionPane;
import java.text.NumberFormat;

public class LogEnchainementEX2 {

	public static void main(String[] args) 
	{
		double dCAmois, dSalaire;
		int iOrVendu, iMois;
		NumberFormat argent=NumberFormat.getCurrencyInstance();
		String sVendeur="NULL";
		String[] mois={"Janvier","Février","Mars","Avril","Mai","Juin","Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};
		
		iMois=Integer.parseInt(JOptionPane.showInputDialog("Mois (MM)"));
		sVendeur=JOptionPane.showInputDialog("Nom du vendeur");
		iOrVendu=Integer.parseInt(JOptionPane.showInputDialog("Nombre d'ordi vendus"));
		dCAmois=Double.parseDouble(JOptionPane.showInputDialog("Ventes du mois"));
		
		dSalaire=900;
		dSalaire+=(50*iOrVendu);
		dSalaire+=(0.2*dCAmois);
		System.out.println("Mois: "+mois[iMois-1]);
		System.out.println("Nom du vendeur: "+sVendeur);
		System.out.println("Salaire du vendeur: "+argent.format(dSalaire));
		
		
		
		
	}

}
