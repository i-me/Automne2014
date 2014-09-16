package pkProgLab1EX11;
import javax.swing.JOptionPane;
public class ProgLab1EX11 {

	public static void main(String[] args) 
	{
		int cents, cinq, dix, trente, looney, deux;
		double montantEconomies=0;
		cents=Integer.parseInt(JOptionPane.showInputDialog("0.01$"));
		cinq=Integer.parseInt(JOptionPane.showInputDialog("0.05$"));
		dix=Integer.parseInt(JOptionPane.showInputDialog("0.10$"));
		trente=Integer.parseInt(JOptionPane.showInputDialog("0.25$"));
		looney=Integer.parseInt(JOptionPane.showInputDialog("1$"));
		deux=Integer.parseInt(JOptionPane.showInputDialog("2$"));
		montantEconomies+=cents*0.01;
		montantEconomies+=cinq*0.05;
		montantEconomies+=dix*0.1;
		montantEconomies+=trente*0.25;
		montantEconomies+=looney*1;
		montantEconomies+=deux*2;
		System.out.println("Montant des économies de Marie-Ève:"+montantEconomies);
		
	}

}
