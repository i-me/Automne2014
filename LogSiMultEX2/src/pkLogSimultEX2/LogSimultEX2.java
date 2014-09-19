package pkLogSimultEX2;
import javax.swing.JOptionPane;
import java.text.NumberFormat;

public class LogSimultEX2 {

	public static void main(String[] args) 
	{
		Double dSalAnnu, dMontantPrime;
		int iNivPerf;
		String sMessage="", sNom="";
		NumberFormat argent=NumberFormat.getCurrencyInstance();
		
		sNom=JOptionPane.showInputDialog("Nom de l'employé");
		sMessage="Nom de l'employé: "+sNom;
		
		dSalAnnu=Double.parseDouble(JOptionPane.showInputDialog("Salaire annuel"));
		sMessage+="\nSalaire: "+argent.format(dSalAnnu);
		
		iNivPerf=Integer.parseInt(JOptionPane.showInputDialog("Niveau de performance(1 @ 4)"));
		sMessage+="\nNotation: "+iNivPerf;
		
		switch(iNivPerf)
		{
			case 1:
				dMontantPrime=dSalAnnu*0.06;
				break;
			case 2:
				dMontantPrime=dSalAnnu*0.04;
				break;
			case 3:
				dMontantPrime=dSalAnnu*0.02;
				break;
			case 4:
				dMontantPrime=0.0;
				break;
			default:
				dMontantPrime=0.0;
				sMessage+="\nUNE ERREUR EST SURVENUE, NIVEAU DE PERFORMANCE INCORRECT";
				break;
				
		}
		sMessage+="\nBonus: "+ argent.format(dMontantPrime);
		System.out.println(sMessage);
		
	}

}