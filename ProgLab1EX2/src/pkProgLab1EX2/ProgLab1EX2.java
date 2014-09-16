package pkProgLab1EX2;
import javax.swing.JOptionPane;
public class ProgLab1EX2 {

	public static void main(String[] args) 
	{
		int billeMEve, billeVinc, billeRaphael, billeJSimon;
		billeJSimon=100;
		billeMEve=Integer.parseInt(JOptionPane.showInputDialog("Billes de Marie-Ève"));
		billeJSimon+=billeMEve;
		billeVinc=Integer.parseInt(JOptionPane.showInputDialog("Bille de Vincent"));
		billeJSimon+=(billeVinc/2);
		billeRaphael=Integer.parseInt(JOptionPane.showInputDialog("Bille de Raphael"));
		billeJSimon+=(billeRaphael*0.75);
		JOptionPane.showMessageDialog(null,"Jean-Simon a maintenant"+billeJSimon+"billes");
		
		
	}

}
