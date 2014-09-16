package pkProgLab1EX9;
import javax.swing.JOptionPane;
import java.text.*;
public class ProgLab1EX9 {

	public static void main(String[] args)
	{
		DecimalFormat argent=new DecimalFormat("0.00$");
		double montantImpot, montantDeduct, salaire, nbHeure;
		final double IMPOT=0.1, DEDUCT=0.05, TAUX=10;
		nbHeure=Double.parseDouble(JOptionPane.showInputDialog("Nombre d'heures travaillées"));
		salaire=nbHeure*TAUX;
		montantDeduct=DEDUCT*salaire;
		montantImpot=IMPOT*salaire;
		salaire-=(montantDeduct+montantImpot);
		System.out.println("Nombre d'heures travaillées "+nbHeure);
		System.out.println("Montant Déductions "+argent.format(montantDeduct));
		System.out.println("Montant Impot "+argent.format(montantImpot));
		System.out.println("Salaire final "+argent.format(salaire));
		
		
	}

}
