package pkLogPourEX5;
import javax.swing.JOptionPane;
import java.text.NumberFormat;
public class LogPourEX5 {

	public static void main(String[] args) 
	{
		int iNoClient;
		double dMontantAchat, dMontantTotal=0, dMoyenneAchat;
		String sMessage="";
		NumberFormat argent=NumberFormat.getCurrencyInstance();
		
		for(int i=0;i<5;i++)
		{
			iNoClient=Integer.parseInt(JOptionPane.showInputDialog("No de client"));
			dMontantAchat=Double.parseDouble(JOptionPane.showInputDialog("Montant des achats du client"));
			dMontantTotal+=dMontantAchat;
		}
		
		dMoyenneAchat=dMontantTotal/5;
		sMessage="Montant total des achats : "+ argent.format(dMontantTotal) +", \n";
		sMessage+="Montant moyen des achats : "+ argent.format(dMoyenneAchat);
		System.out.println(sMessage);
		
	}

}
