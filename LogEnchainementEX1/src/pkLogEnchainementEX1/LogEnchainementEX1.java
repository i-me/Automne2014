package pkLogEnchainementEX1;
import javax.swing.JOptionPane;
import java.text.NumberFormat;
public class LogEnchainementEX1 {

	public static void main(String[] args) 
	{
		double coutBase=0, coutBillet=0;
		NumberFormat argent=NumberFormat.getCurrencyInstance();
		coutBase=Double.parseDouble(JOptionPane.showInputDialog("Coût de base du billet"));
		coutBillet=coutBase+(coutBase*0.1);
		coutBillet+=(coutBase*0.02);
		coutBillet+=(coutBase*0.15);
		coutBillet+=2;
		coutBillet+=(coutBillet*0.05);
		coutBillet+=(coutBillet*0.095);
		System.out.println("Le coût du billet sera "+argent.format(coutBillet));
	}

}
