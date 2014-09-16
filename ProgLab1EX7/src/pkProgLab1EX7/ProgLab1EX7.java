package pkProgLab1EX7;
import javax.swing.JOptionPane;
import java.text.*;
public class ProgLab1EX7 {

	public static void main(String[] args) 
	{
		double note, prcntgFinal;
		NumberFormat prcntg= NumberFormat.getPercentInstance();
		note=Double.parseDouble(JOptionPane.showInputDialog("Note (X/40)"));
		prcntgFinal=(note)/40;
		System.out.println(prcntg.format(prcntgFinal));
		
	}

}
