package pkProgLab1EX4;
import javax.swing.JOptionPane;
import java.text.*;
public class ProgLab1EX4 {

	public static void main(String[] args)
	{
	double gDents, gGOrteil, gNez, hOreille;
	DecimalFormat grandeur=new DecimalFormat("0.00CM");
	gGOrteil=Double.parseDouble(JOptionPane.showInputDialog("Grandeur du gros orteil"));
	gDents=gGOrteil/3;
	gNez=gDents*3;
	hOreille=2*gNez;
	System.out.println("Grandeur Dents:"+grandeur.format(gDents));
	System.out.println("Grandeur nez:"+grandeur.format(gNez));
	System.out.println("Hauteur Oreille:"+grandeur.format(hOreille));
	
	}

}
