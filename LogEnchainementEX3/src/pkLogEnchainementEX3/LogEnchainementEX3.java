package pkLogEnchainementEX3;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class LogEnchainementEX3 {
	

		public static void main(String[] args) 
		{
			double dXam1, dXam2, dXam3, dXam4, dXam5, dXam6, dXam7;
			String sNom;
			final double POND1=0.2, POND2=0.1;
			double dNoteFinale;
			sNom=JOptionPane.showInputDialog("Nom de l'élève");
			
			dXam1=Double.parseDouble(JOptionPane.showInputDialog("Note de l'examen #1"))*POND1;
			dXam2=Double.parseDouble(JOptionPane.showInputDialog("Note de l'examen #2"))*POND1;
			dXam3=Double.parseDouble(JOptionPane.showInputDialog("Note de l'examen #3"))*POND1;
			dXam4=Double.parseDouble(JOptionPane.showInputDialog("Note de l'examen #4"))*POND2;
			dXam5=Double.parseDouble(JOptionPane.showInputDialog("Note de l'Examen #5"))*POND2;
			dXam6=Double.parseDouble(JOptionPane.showInputDialog("Note de l'Exmane #6"))*POND2;
			dXam7=Double.parseDouble(JOptionPane.showInputDialog("Note de l'examen #7"))*POND2;
			
			dNoteFinale=dXam1+dXam2+dXam3+dXam4+dXam5+dXam6+dXam7;
			System.out.println(sNom);
			System.out.println("La note obtenue pour le cours est : "+dNoteFinale);
			
		}
}