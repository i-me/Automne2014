package pkProgLab1EX1;
import javax.swing.JOptionPane;
import java.text.*;

public class ProgLab1EX1 {

	public static void main(String[] args) 
	{/*Il serait possible de créer une fonction pour calculer et afficher le prix de l'article. Mais je suis trop 
	vedge ce soir pour aller chercher sur internet comment faire. */
		double prixHabit, montantTVQ, montantTPS, total=0;
		final double ESCOMPTE=0.15, TPS=0.075, TVQ=0.07;
		DecimalFormat prix=new DecimalFormat("0.00$");
		NumberFormat pourcentage=NumberFormat.getPercentInstance();
		
		String message="", titre="Habit de monsieur l'Heureux";
		
		prixHabit=Double.parseDouble(JOptionPane.showInputDialog("Prix de l'habit pour M.L'Heureux"));
		message+="Avant escompte\n-------------\n";
		montantTPS=prixHabit*TPS;
		montantTVQ=(prixHabit+montantTPS)*TVQ;
		total=prixHabit+montantTVQ+montantTPS;
		message+="Prix de l'habit: "+prix.format(prixHabit)+"\n";
		message+="Montant de la TPS :"+prix.format(montantTPS)+"\n";
		message+="Montant de la TVQ :"+prix.format(montantTVQ)+"\n";
		message+="Montant Total de la facture:"+prix.format(total)+"\n----\n";
		message+="Avec escompte de "+ pourcentage.format(ESCOMPTE)+"\n";
		message+="----\n";
		prixHabit*=(1-(ESCOMPTE));
		montantTPS=prixHabit*TPS;
		montantTVQ=(prixHabit+montantTPS)*TVQ;
		total=prixHabit+montantTVQ+montantTPS;
		message+="Prix de l'habit: "+prix.format(prixHabit)+"\n";
		message+="Montant de la TPS :"+prix.format(montantTPS)+"\n";
		message+="Montant de la TVQ :"+prix.format(montantTVQ)+"\n";
		message+="Montant Total de la facture:"+prix.format(total)+"\n----\n";
		JOptionPane.showMessageDialog(null,message,titre, JOptionPane.INFORMATION_MESSAGE);
		
		
	}

}
