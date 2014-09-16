package pkProgLab1EX5;
import javax.swing.JOptionPane;

import java.text.DecimalFormat;
public class ProgLab1EX5 {

	public static void main(String[] args) 
	{
		double age;
		int nbJours;
		DecimalFormat formatAge=new DecimalFormat("0.0ans");
		nbJours=Integer.parseInt(JOptionPane.showInputDialog("Âge de Nathalie en jours"));
		age=(nbJours/365)+((nbJours%365)/365);
		System.out.println(formatAge.format(age));
	}

}
