package pkProgChaine1;
import javax.swing.JOptionPane;

public class ProgChaine1 {

	public static void main(String[] args) {
	
	String sAssSocial, sAssSocial2;//Contient 9 caracteres, positions 0@8, + des espaces.
	String tAssSocial;
	String tSerie1;//Serie pour validation des positions 1,3,5,7
	String tSerie2;//Serie pour validaiton des positions 0,2,4,6,8
	boolean err;//Retourne une erreur si il y a
	int iProduitSerie2, iSommeSerie2, iSommeSerie1, iSomme;
	
	//IMPORTANT � NOTER : Je voulais utiliser des tableaux, mais j'ai d�cid� d'utiliser un autre m�thode. Trop vedge pour tous changer les noms de variables tSerie -> sSerie

	while(true)
	{
		/*R�initialisation des variables utilis�es lors de la pr�c�dente boucle OU Initialisaiton si c'est premier passage*/
		err=false;
		tAssSocial=""; sAssSocial2=""; tSerie1=""; tSerie2=""; iProduitSerie2=0;iSommeSerie2=0;iSommeSerie1=0;iSomme=0;
		/*Fin r�initialisation de variables*/
		sAssSocial=JOptionPane.showInputDialog("Saisissez le num�ro d'assurance social. Pour quitter (Q)").toLowerCase();
		if(sAssSocial.charAt(0)=='q')
		{
			break;
		}
		else
		{
			
			for (int i=0;i<sAssSocial.length();i++)
			{
				if(Character.isDigit(sAssSocial.charAt(i)))
					sAssSocial2+=sAssSocial.charAt(i);
			}
			sAssSocial=sAssSocial2;
			for(int i=0;i<sAssSocial.length();i++)
			{		
				if(Character.isDigit(sAssSocial.charAt(i)))//Avec cette condition, si le NAS est OK, on va avoir serie 1 de 4 char, et Serie2 de 5 char
				{
					if(i%2==0)
						tSerie1+=sAssSocial.charAt(i);
					else
						tSerie2+=sAssSocial.charAt(i);
				
				}
			}
			if(tSerie2.length()==4&&tSerie1.length()==5)//On passe � la partie de validation. ITS SERIOUS SHIT HERE. WATCH OUT.
			{		
				/*Traitons la s�rie 2 d'abord. Puisque c'est celle qui requiert le plus de conditions, il y a plus de risque de false.
				 * Donc plus false arrive t�t dans le programme, moins d'usage de l'UC
				 */
			
				iProduitSerie2=2*Integer.parseInt(tSerie2);
				tSerie2=String.valueOf(iProduitSerie2);//R�utilisation de la variable tSerie2, �conomie de m�moire. 
				while(tSerie2.length()<5)//On ajoute des 00 pour obtenir 5 caracteres � la multiplication
				{
					tSerie2="0"+tSerie2;
				}
				
				for(int i=0;i<tSerie2.length();i++)//On aditionne les caracteres. �a doit Valoir 13
				{
					iSommeSerie2+=Integer.parseInt(""+tSerie2.charAt(i));
				}
				
				/*Traitons maintenant la s�rie 1*/
				for(int i=0;i<tSerie1.length();i++)
				{
					iSommeSerie1+=(int)tSerie1.charAt(i);
				}
				iSomme=iSommeSerie1+iSommeSerie2;
				tSerie2=String.valueOf(iSomme);//D�finitivement, cette variable est tr�s utile pour m'�viter de d�clarer 10 000 espaces m�moires
				
				if(tSerie2.charAt(tSerie2.length()-1)=='0')
				{
					JOptionPane.showMessageDialog(null, "Le num�ro d'assurance sociale est valide");
				}
				else
					JOptionPane.showMessageDialog(null, "Le num�ro d'assurance sociale n'est pas valide.");
				;
				}
			else
			{
				err=true;
				break;
			}
				
		}
		if(err)
			JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors du traitement du NAS. Merci de recommencer");
		
	}
	
	}
	}

