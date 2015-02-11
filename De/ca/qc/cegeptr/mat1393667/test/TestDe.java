package ca.qc.cegeptr.mat1393667.test;
import ca.qc.cegeptr.mat1393667.outils.*;
import javax.swing.JOptionPane;
import java.util.*;
public class TestDe {

	public static void main(String[] args) {

		String[] option = {"Lancer un d�", "Visualiser les deux d�s", "Additionner les deux d�s", "Affecter une valeur � un d�"};
		int choix = 1 , choixDe, iSaisie;
		De unDe= new De();
		De deuxDe= new De();
		
		//Variables n�cessaires � la gestion des erreurs
		int iCodeErreur=-1;
		boolean err=false;
		while(choix!=-1)
		{
			choix=JOptionPane.showOptionDialog(null, "S�lectionnez votre choix parmi les options usivantes:", "Menu principal --- Gestion du D�", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, option, option[0]);
			switch(choix)
			{
			case 0 : //Lancer les deux d�s
				choixDe=Integer.parseInt(JOptionPane.showInputDialog("Quel d� voulez-vous lancer? 1 ou 2"));
				if(choixDe==1||choixDe==2)
				{
					if(choixDe==1)
						unDe.setValeur(-1);
					else
						deuxDe.setValeur(-1);
				}
				else
				{
					err=true;
					iCodeErreur=2;
				}
				break;
			case 1://Visualiser les deux d�s
			{
				String sMessage=unDe.toString()+"\n"+deuxDe.toString();
				System.out.println(sMessage);
				break;
			}
			case 2://Additionner les deux d�s
			{
				System.out.println("La valeur des deux d�s additionn�s est de :"+(unDe.getValeurDe()+deuxDe.getValeurDe()));
				break;
			}
			case 3://Assigner une valeur personnalis�
			{	
				choixDe=Integer.parseInt(JOptionPane.showInputDialog("Quel d� voulez-vous assigner? 1 ou 2"));
				if(choixDe==1||choixDe==2)
				{
					iSaisie=Integer.parseInt(JOptionPane.showInputDialog("Quelle valeur souhaitez-vous assigner?"));
					if(choixDe==1)
						unDe.setValeur(iSaisie);
					else
						deuxDe.setValeur(iSaisie);
				}
				else
				{
					err=true;
					iCodeErreur=2;
				}
			}
			default:
				err=true;
				//iCodeErreur=1;
			}
			
			if(err)
			{
				switch(iCodeErreur)
				{
					case 1:
						JOptionPane.showMessageDialog(null, "Erreur, le choix est non valide", null, JOptionPane.ERROR_MESSAGE);
						break;
					case 2:
						JOptionPane.showMessageDialog(null, "Erreur, le d� n'existe pas", null, JOptionPane.ERROR_MESSAGE);
						break;
					default:
						break;
				}	
				
				//R�initialisation des codes d'erreur
				iCodeErreur=-1;
				err=false;
			}
			
		}
	}

}
