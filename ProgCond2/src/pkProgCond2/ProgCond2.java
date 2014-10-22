package pkProgCond2;
import javax.swing.JOptionPane;
import java.text.*;
public class ProgCond2 {

	public static void main(String[] args) {
		String sNom="";
		double dRevenu, dImpot, dTxImpot=0.1;
		int iNbPerCharge;
		sNom=JOptionPane.showInputDialog("Nom du contribluable");
		dRevenu=Double.parseDouble(JOptionPane.showInputDialog("Revenu annuel du contribuable"));
		iNbPerCharge=Integer.parseInt(JOptionPane.showInputDialog("Nombre de personnes à charges"));
		if(dRevenu<=65000)
			dTxImpot=0.15;
		dImpot=(dRevenu*dTxImpot)-(iNbPerCharge*500);
		JOptionPane.showMessageDialog(null, "Le contribuable "+sNom+" paiera "+dImpot+" d'impots cette année");
	}

}
