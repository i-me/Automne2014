package pkProgArray2;
import javax.swing.JOptionPane;
import java.text.*;
/****
 * Nom : ProgArray2 
 * Nom des classes : JOptionPane, NumberFormat
 * Objectif du programme: Histogramme des notes d'examens. Notes sur 72. 
 * Nom et version de l'IDE: Eclipse Luna 4.4.0, JRE 1.8.0-20
 * OS : Windows 7 Professional
 * Auteur: Olivier Bois
 * Date création : Octobre 2014
 */
public class ProgArray2 {

	public static void main(String[] args) 
	{
		final String EXIGENCE_PROF="/***** Nom : ProgArray2 \n* Nom des classes : JOptionPane\n* Objectif du programme: Histogramme des notes d'examens. Notes sur 72. \n* Nom et version de l'IDE: Eclipse Luna 4.4.0, JRE 1.8.0-20\n* OS : Windows 7 Professional\n* Auteur: Olivier Bois\n* Date création : Octobre 2014\n*/";
		JOptionPane.showMessageDialog(null, EXIGENCE_PROF, "Exigence prof", JOptionPane.PLAIN_MESSAGE);
		NumberFormat prcnt=NumberFormat.getPercentInstance();
		
		final int iNBNOTE=20, iNBTRANCHE=10;
		/*
		 * iNBNOTE -> Nombre de note à saisie
		 * iNBTRANCHE -> Nombre de tranche de note à faire
		 */
		int iClass[]=new int[iNBTRANCHE], iChoixMenu=-1;
		/*
		 * iClass -> Contient 10 entrées pour les paliers. Ces entrées seront initialisées au case 2 et -1
		 * iChoixMenu -> Valeur par défaut du menu. Pourrait être 2. Mais pour des fins de débug, j'ai mis à -1 lorsque j'initialise et 2 lorsque l'user fait le choix
		 * iFrequenceMax -> Le plus grand des iClass. Servira pour faire l'histogramme case 1
		 */
		double  dSaisie, dMoyenne, dNoteMax=-1, dNoteMin=-1, dEtendu=0, dTotalNote=0;
		/*Variables double
		 * dNote100->Tableau des 20 notes sur 100.  Est initialisé au moment où l'user fait le choix de l'option case 2 et -1... yeeeeah I know. ce n'est pas la façons "standart" mais bon. Tant qu'à faire une while de réinitilisation =) 
		 * dSaisie -> la valeur double de sSaisie
		 * dMoyenne -> La moyenne de notes  sera utilisé par le case 0
		 * dnoteMax -> La note maximum (useful pour faire l'étendu) Valeur de -1 pour l'opérateur ternaire
		 * dNoteMin -> La note minimum (useful pour faire l'étendu) Valeur de -1 pour l'opérateur ternaire
		 * dEtendu -> Contient l'étendu. Sera utilisé par le case 0
		 * dTotalNote -> Total des notes pour faire la moyenne
		 */
		String sChoixMenu[]={"Moyenne/Étendu", "Tableau fréquence des notes", "Recommencer", "Quitter"}, sSaisie="", sSortie="";
		/*
		 * sChoixMenu-> choix du menu
		 * sSaisie-> sert à la saisie des notes de l'user, 
		 * sSortie-> chaine vide pour construire une sortie
		 */
		char cCase1[]={'|','*','*','*','*','*','*','*','*','*','*','|'}, cCase2[]={'|','*','*','*','*','*','*','*','*','*','*','|'};
		/*
		 * cCase 1, cCase2->Template des cases du premier histogramme
		 */
		
		String sMiniChaine="";
		/* sMiniChaine ->Chaine nécessaire à la construction du tableau des valeurs*/
		boolean err=false;
		/*err -> Sert à détecter les erreurs, entre autre pour les sorties de boucles*/
		do																								//Boucle main du programme. execution en continue jusqu'à break du programme. (choix 3)
		{
			switch(iChoixMenu)
			{
			case 0:																						//Moyenne/étendu
			
				if(dNoteMin<=-1)																		//on est assuré que si -1, c'est qu'il n'y a pas eu de saisies
						err=true;
				if(!err)
				{
					dMoyenne=dTotalNote/iNBNOTE;
					dEtendu=dNoteMax-dNoteMin;
					JOptionPane.showMessageDialog(null, "La moyenne des 20 notes est de "+prcnt.format(dMoyenne/100)+", l'étendu des notes est de "+prcnt.format(dEtendu/100));
				}
				else
					JOptionPane.showMessageDialog(null, "Une erreur s'est produite! Vous n'avez pas saisie de donnée pour le moment");
				
				break;
			case 1:																						//Tableau de fréquence des notes
				for(int i=0;i<100;i+=iNBTRANCHE)
				{
					/*On construit le premier tableau de fréquences (f*cking alignement des cases. I give up)*/
					/*Constructeur de la première ligne*/
						sMiniChaine=i+"-"+(i+10);
						sMiniChaine.getChars(0,sMiniChaine.length(),cCase1, 3);
						sMiniChaine="";		
					
						for(int i2=0;i2<cCase1.length;i2++)
						{
							sSortie+=cCase1[i2];
						}
					/*Fin de constructeur de la première ligne du tableau*/
				}
				sSortie+="\n";
				for(int i=0, i2=sSortie.length();i<i2;i++)												//On trace une ligne simili séparatrice
				{
					sSortie+="-";
				}
				sSortie+="\n";
				for(int i=0;i<100;i+=iNBTRANCHE)
				{
					/*Constructeur de la deuxième ligne(f*cking alignement des cases. I give up)*/
					sMiniChaine=iClass[((int)i/iNBTRANCHE)]+"";
						sMiniChaine.getChars(0,sMiniChaine.length(), cCase2, 4);
						for(int i2=0;i2<cCase2.length;i2++)
						{
							sSortie+=cCase2[i2];
						}
						
					/* fin constructeur de la deuxième ligne*/
				}
					/*Fin de construction du premie rtableau de fréquences*/
				
				/*Construction du deuxième tableau AVEC HISTOGRAMME*/
				sSortie +="\nIndice   Fréquence    Symboles\n";
				for(int i=0;i<iNBTRANCHE;i++)																// il y a 10 tranches
				{	sSortie+="\n";
					sSortie+=i;
					sSortie+="            ";
					sSortie+=iClass[i];
					sSortie+="            #";
					for(int i2=0;i2<iNBNOTE;i2++)														//Il y a 20 notes
					{
						if(iClass[i]<=i2)
						{
							sSortie+="-";															//Pas une donnée. On fait du "vide" tiret pour alignement
						}
						else
							sSortie+="@";															//C'est une donnée, on fait @
					}
				}
				
				/*fin de construction du deuxième tableau*/

				JOptionPane.showMessageDialog(null, sSortie);
				sSortie="";
				break;
			case 2: case -1:																		//On recommence la saisie des notes
				dMoyenne=0;
				dEtendu=0;
				iClass=new int[iNBTRANCHE];																	//Il y a 10 pallier de notes;
				for(int i=0;i<iNBNOTE;i++)																//On a besoin de 20 entrées 
				{
					dSaisie=-1;
					sSaisie=JOptionPane.showInputDialog("Saisie #"+(i+1)+"\nNote sur 72. Saisir décimales avec un '.' (99.99)");
					for(int i2=0;i2<sSaisie.length();i2++)											//Vérifie si la saisie est un nombre
					{
						if(!(Character.isDigit(sSaisie.charAt(i2))||sSaisie.charAt(i2)=='.'))		//Saisie non valide
							err=true;																//il faut 20 entrées valides. Donc, on retourne l'itérateur à sa valeur précédent la saisie;
							
					}
					if(!err)																		//Si la saisie est OK, on transforme en double la saisie, on la met en % au passage
						dSaisie=(Double.parseDouble(sSaisie)*100)/72;
					else
						err=false;																	//On réinialise le bool pour le prochains tour de boucle
					if(dSaisie>-1&&dSaisie<=100)													//La note est comprise en 0 et 100. 
					{
						dNoteMax=(dNoteMax<dSaisie||dNoteMax<0)?dNoteMax=dSaisie:dNoteMax; 			//Cette ligne et prochaine ligne, on recherche val max et min des notes 
						dNoteMin=(dNoteMin>dSaisie||dNoteMin<0)?dNoteMin=dSaisie:dNoteMin;
						dTotalNote+=dSaisie;
						if(dSaisie==100)															//Pour pas faire d'erreur de traitement 100%=99% (en tout cas, pour la tranche de note)
							dSaisie-=1;
						iClass[((int)dSaisie/iNBTRANCHE)]++;												//On enregistre la saisie dans la bonne entrée du tableau;
						//System.out.println(((int)dSaisie/10)+"-"+dSaisie); //Débug
					}
					else
						i--;
					
				}
				//System.out.println(iClass[9]);//Débug
				break;
			default:

				JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de l'execution du programme");
				break;
				
				
				
			}
			iChoixMenu=JOptionPane.showOptionDialog(null, "Visualisation des données", "Notes aux examens", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, sChoixMenu, sChoixMenu[0]);
		}while(iChoixMenu!=3);
		JOptionPane.showMessageDialog(null, "Aurevoir!");
		
	}

}
