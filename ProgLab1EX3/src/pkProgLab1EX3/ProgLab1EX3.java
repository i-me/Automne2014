package pkProgLab1EX3;
import javax.swing.JOptionPane;
import java.text.*;
public class ProgLab1EX3 {
	public static void main(String[] args) 
	{
		int nbCirculaire, nbHeure, salaire;
		final int taux=8, extra=4;
		DecimalFormat dollar=new DecimalFormat("0.00$");
		
		/*4$ par 100 nb circulaire, 8$ par nbHeure*/
		nbCirculaire=Integer.parseInt(JOptionPane.showInputDialog("Nombre de circulaires distribu�s"));
		nbHeure=Integer.parseInt(JOptionPane.showInputDialog("Nombre d'heures travaill�es"));
		nbCirculaire=(nbCirculaire-(nbCirculaire%100))/100;//On round �a pour faire un beau chiffre rond*4$
		salaire=nbHeure*taux;
		JOptionPane.showMessageDialog(null, "Salaire de base "+dollar.format(salaire)+"\nExtra "+dollar.format(nbCirculaire*extra)+"\n Salaire total "+dollar.format((nbCirculaire*extra)+salaire));
	}

}
