import java.text.NumberFormat;

import javax.swing.JOptionPane;


public class ProgLab1EX8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double note, prcntgFinal, totalTest;
		NumberFormat prcntg= NumberFormat.getPercentInstance();
		note=Double.parseDouble(JOptionPane.showInputDialog("Note"));
		totalTest=Double.parseDouble(JOptionPane.showInputDialog("Note totale du test"));
		prcntgFinal=(note)/totalTest;
		System.out.println(prcntg.format(prcntgFinal));
	}

}
