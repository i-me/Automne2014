package pkProgCond4;
import javax.swing.JOptionPane;
public class ProgCond4 {

	public static void main(String[] args) 
	{
		int iNumClient, iNbAccident;
		double dPrimeActu, dPrimeFutur, dPrcnt=0;
		iNumClient=Integer.parseInt(JOptionPane.showInputDialog("Numéro du client"));
		iNbAccident=Integer.parseInt(JOptionPane.showInputDialog("Nombre d'accidents"));
		dPrimeActu=Double.parseDouble(JOptionPane.showInputDialog("Prime actuelle duclient"));
		
		switch(iNbAccident)
		{
		case 0:
			dPrcnt=0;
			break;
		case 1:
			dPrcnt=0.05;
			break;
		case 2:
			dPrcnt=0.08;
			break;
		case 3:
			dPrcnt=0.15;
			break;
		default:
			dPrcnt=-1;
			break;
		}
		if(dPrcnt<0)//On  a retiré sa police d'assurance
			JOptionPane.showMessageDialog(null, "Vous n'êtes plus assuré par notre compagnie!");
		else
		{
			dPrimeFutur=(dPrimeActu*dPrcnt)+dPrimeActu;
			JOptionPane.showMessageDialog(null, "Vous êtes maintenant assuré avec une prime de "+dPrimeFutur);
		}
	}

}
