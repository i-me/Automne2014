package pkProgArray2;
import javax.swing.JOptionPane;
import java.text.*;
public class ProgArray2 {

	public static void main(String[] args) 
	{
		NumberFormat prcnt=NumberFormat.getPercentInstance();
		
		int iClass[]=new int[10], iChoixMenu=-1, iFrequenceMax=0;
		/*
		 * iClass -> Contient 10 entr�es pour les paliers. Ces entr�es seront initialis�es au case 2 et -1
		 * iChoixMenu -> Valeur par d�faut du menu. Pourrait �tre 2. Mais pour des fins de d�bug, j'ai mis � -1 lorsque j'initialise et 2 lorsque l'user fait le choix
		 * iFrequenceMax -> Le plus grand des iClass. Servira pour faire l'histogramme case 1
		 */
		double dNote100[], dSaisie, dMoyenne, dNoteMax=-1, dNoteMin=-1, dEtendu=0, dTotalNote=0;
		/*Variables double
		 * dNote100->Tableau des 20 notes sur 100.  Est initialis� au moment o� l'user fait le choix de l'option case 2 et -1... yeeeeah I know. ce n'est pas la fa�ons "standart" mais bon. Tant qu'� faire une while de r�initilisation =) 
		 * dSaisie -> la valeur double de sSaisie
		 * dMoyenne -> La moyenne de notes  sera utilis� par le case 0
		 * dnoteMax -> La note maximum (useful pour faire l'�tendu) Valeur de -1 pour l'op�rateur ternaire
		 * dNoteMin -> La note minimum (useful pour faire l'�tendu) Valeur de -1 pour l'op�rateur ternaire
		 * dEtendu -> Contient l'�tendu. Sera utilis� par le case 0
		 * dTotalNote -> Total des notes pour faire la moyenne
		 */
		String sChoixMenu[]={"Moyenne/�tendu", "Tableau fr�quence des notes", "Recommencer", "Quitter"}, sSaisie="", sSortie="";//sChoixMenu... choix du menu, sSaisie, sert � la saisie des notes de l'user, sSortie, chaine vide pour construire une sortie
		char cCase1[]={'|','*','*','*','*','*','*','*','*','*','*','|'}, cCase2[]={'|','*','*','*','*','*','*','*','*','*','*','|'};
		String sCase3[]={"*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*","*"};
		String sMiniChaine="";//Ce sont des variables necessaires � la construction du tableau des valeurs
		boolean err=false;//Va �tre utile dans les boucles. 
		do
		{
			switch(iChoixMenu)
			{
			case 0://Moyenne/�tendu
			
				if(dNoteMin<=-1)//on est assur� que si -1, c'est qu'il n'y a pas eu de saisies
						err=true;
				if(!err)
				{
					dMoyenne=dTotalNote/20;
					dEtendu=dNoteMax-dNoteMin;
					JOptionPane.showMessageDialog(null, "La moyenne des 20 notes est de "+prcnt.format(dMoyenne/100)+", l'�tendu des notes est de "+prcnt.format(dEtendu/100));
				}
				else
					JOptionPane.showMessageDialog(null, "Une erreur s'est produite! Vous n'avez pas saisie de donn�e pour le moment");
				
				break;
			case 1://Tableau de fr�quence des notes
				for(int i=0;i<100;i+=10)
				{/*On construit le tableau de fr�quences (f*cking alignement des cases. I give up)*/
					/*Constructeur de la premi�re ligne*/
						sMiniChaine=i+"-"+(i+10);
						sMiniChaine.getChars(0,sMiniChaine.length(),cCase1, 3);
						sMiniChaine="";		
					
						for(int i2=0;i2<cCase1.length;i2++)
						{
							sSortie+=cCase1[i2];
						}
					/*Fin de constructeur de la premi�re ligne du tableau*/
				}
				sSortie+="\n";
				for(int i=0, i2=sSortie.length();i<i2;i++)//On trace une ligne simili s�paratrice
				{
					sSortie+="-";
				}
				sSortie+="\n";
				for(int i=0;i<100;i+=10)
				{/*Constructeur de la deuxi�me ligne(f*cking alignement des cases. I give up)*/
					sMiniChaine=iClass[((int)i/10)]+"";
						sMiniChaine.getChars(0,sMiniChaine.length(), cCase2, 4);
						for(int i2=0;i2<cCase2.length;i2++)
						{
							sSortie+=cCase2[i2];
						}
						
				/* fin constructeur de la deuxi�me ligne*/
				}
				/*Fin de construction du premie rtableau de fr�quences*/
				
				/*construction du deuxi�me tableau AVEC HISTOGRAMME*/
				sSortie +="\nIndice   Fr�quence    Symboles\n";
				for(int i=0;i<10;i++)
				{	sSortie+="\n";
					sSortie+=i;
					sSortie+="            ";
					sSortie+=iClass[i];
					sSortie+="            #";
					for(int i2=0;i2<20;i2++)
					{
						if(iClass[i]<=i2)
						{
							sSortie+="-";
						}
						else
							sSortie+="@";
					}
				}
				
				/*fin de construction du deuxi�me tableau*/

				JOptionPane.showMessageDialog(null, sSortie);
				sSortie="";
				break;
			case 2: case -1://On recommence la saisie des notes
				dMoyenne=0;
				dEtendu=0;
				iClass=new int[10];//Il y a 10 pallier de notes;
				dNote100=new double[20];//Il y a 20 notes saisies; Contient les notes de dSaisie sur 72 -> transform�s sur 100;	
				for(int i=0;i<20;i++)//On a besoin de 20 entr�es 
				{
					dSaisie=-1;
					sSaisie=JOptionPane.showInputDialog("Saisie #"+(i+1)+"\nNote sur 72");
					for(int i2=0;i2<sSaisie.length();i2++)//V�rifie si la saisie est un nombre
					{
						if(!(Character.isDigit(sSaisie.charAt(i2))||sSaisie.charAt(i2)=='.'))
							err=true;//il faut 20 entr�es valides. Donc, on retourne l'it�rateur � sa valeur pr�c�dent la saisie;
							
					}
					if(!err)//Si la saisie est OK, on transforme en double la saisie, on la met en % au passage
						dSaisie=(Double.parseDouble(sSaisie)*100)/72;
					else
						err=false;//On r�inialise le bool pour le prochains tour de boucle
					if(dSaisie>-1&&dSaisie<=100)//La note est comprise en 0 et 100. 
					{
						dNoteMax=(dNoteMax<dSaisie||dNoteMax<0)?dNoteMax=dSaisie:dNoteMax; // Si �a marche. Voir avec examen pour prof. 
						dNoteMin=(dNoteMin>dSaisie||dNoteMin<0)?dNoteMin=dSaisie:dNoteMin;
						dTotalNote+=dSaisie;
						if(dSaisie==100)//Pour pas faire d'erreur de traitement
							dSaisie-=1;
						iClass[((int)dSaisie/10)]++;//On enregistre la saisie dans la bonne entr�e du tableau;
						System.out.println(((int)dSaisie/10)+"-"+dSaisie);
					}
					else
						i--;
					
				}
				System.out.println(iClass[9]);
				break;
			default:

				JOptionPane.showMessageDialog(null, "Une erreur s'est produite lors de l'execution du programme");
				break;
				
				
				
			}
			iChoixMenu=JOptionPane.showOptionDialog(null, "Visualisation des donn�es", "Notes aux examens", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, sChoixMenu, sChoixMenu[0]);
		}while(iChoixMenu!=3);
		JOptionPane.showMessageDialog(null, "Aurevoir!");
		
	}

}
