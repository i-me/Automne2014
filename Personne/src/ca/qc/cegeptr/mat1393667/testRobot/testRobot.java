package ca.qc.cegeptr.mat1393667.testRobot;
import ca.qc.cegeptr.mat1393667.outils.*;
import javax.swing.JOptionPane;
public class testRobot {

	public static void main(String[] args) {
			Robot unRobot=new Robot();
			unRobot.setNom(JOptionPane.showInputDialog("Saisir le nom du robot"));
			Robot deuxRobot=new Robot();
			
			Personne alice = new Personne("Alice", 18, 100);
			Personne benoit = new Personne("Benoit", 17, 50);
			Personne mathieu=new Personne("Mathieu", 14, 100);
			Personne emile= new Personne("Emile", 20, 80);
			
			System.out.println(unRobot.verifierAgeMontant(alice));
			
			System.out.println(deuxRobot.verifierAgeMontant(benoit));
			
			System.out.println(unRobot.verifierAgeMontant(mathieu));
			
			System.out.println(deuxRobot.verifierAgeMontant(emile));
			emile.setMontantArgent(100);
			
			System.out.println(unRobot.verifierAgeMontant(emile));
			
			Personne olivier = new Personne("Olivier", 28, 100);
			
			Personne ami = new Personne(olivier);
			
			System.out.println(deuxRobot.verifierAgeMontant(ami));
			
			if(ami.equals(olivier))
			{
				System.out.println("Ces deux personnes sont les m�mes");
			}
			else
				System.out.println("Ces deux personnes sont diff�rentes");
			
			if(benoit.equals(olivier))
			{
				System.out.println("Ces deux personnes sont les m�mes");
			}
			else
				System.out.println("Ces deux personnes sont diff�rentes");
		
			deuxRobot.perDebut.setMois(6);
			deuxRobot.perFin.setMois(8);
			
			unRobot.perDebut.setMois(6);
			unRobot.perFin.setMois(12);
			System.out.println(unRobot.getNom()+" a travaill� " +(unRobot.perFin.getMois()-unRobot.perDebut.getMois())+" mois");
			
			
	}

}
/*

martini souhaite la bienvenue � Alice vous pouvez entrer et bonne soir�e
Tequila se voit d�soler pour Benoit, vous n'avez pas 18 ans.
martini se voit d�soler pour Mathieu, vous n'avez pas 18 ans.
Tequila se voit d�sol� pour Emile vous n'avez pas le montant requis
martini souhaite la bienvenue � Emile vous pouvez entrer et bonne soir�e
Tequila souhaite la bienvenue � Olivier vous pouvez entrer et bonne soir�e
Ces deux personnes sont les m�mes
Ces deux personnes sont diff�rentes
martini a travaill� 6 mois
*/