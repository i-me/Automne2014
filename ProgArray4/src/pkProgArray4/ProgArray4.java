package pkProgArray4;
import java.util.Arrays;
import javax.swing.JOptionPane;
/**
 * *Nom:ProgArray4
 * *Nom des classes: JOptionPane, Arrays
 * *Description: Gestion d'un tableau de nombre
 * *Nom et version de l'IDE: Eclipse Luna 4.4.0, JRE 1.8.0-20 
 * *OS: Windows 7 
 * *Auteur: Olivier Bois
 * *Date cr�ation: Novembre 2014
 * 
 */



public class ProgArray4 {

	public static void main(String[] args) {

		final String EXIGENCE_PROF="*Nom:ProgArray4\n*Nom des classes: JOptionPane, Arrays\n *Description: Gestion d'un tableau de nombre\n*Nom et version de l'IDE: Eclipse Luna 4.4.0, JRE 1.8.0-20 \n*OS: Windows 7 \n*Auteur: Olivier Bois\n*Date cr�ation: Novembre 2014";
				JOptionPane.showMessageDialog(null, EXIGENCE_PROF, "Exigence prof", JOptionPane.PLAIN_MESSAGE);
		int iSaisie=0, iPositionTravail, iTab[]=new int[0], iSomme=0, iCodeErreur=0;
		/*
		 * iSaisie->Contient le ssaisies de format num�riques (EX choix de formulaire, chiffre � ajouter, etc)
		 * iPositionTravail ->Position de travail du tableau. C'est un marqueur de position
		 * iTab -> Tableau de sNombres
		 * iSomme -> Sert � l'option 5, quand on aditionne un nombre � toutes les entr�es du tableau
		 * iCodeErreur -> Sert � la gestion et l'affichage des erreurs. C'est la valeur du case dans le switch.
		 */
		String sMenuPrincipal[]={"1-Ajouter un nombre au d�but, � la fin, ou � un endroit sp�cifique du tableau", "2- Modifier un nombre � un endroit sp�cifique dans le tableau", "3- Supprimer un nombre au d�but, � la fin ou � un endroit sp�cifique", "4- Afficher tous les nombres du tableau", "5- Additionner un nombre quelconque (saisie par l'utilisateur � toutes le spositions du tableau)", "6- Initialiser toutes les positions du tableau par une m�me valeur (saisie par l'utilisateur)", "7- Triez le tableau", "8- Quitter l'application"};
		/*
		 * sMenuPrincipal -> C'est le menu principal
		 */
		String sSSMenu[], sConstructMenu, sSortie="",   sSaisie;
		/*
		 * sSSMenu --> Construction des sous menu style endroits sp�cifiques dans le tableau � modifier, d�but/fin, 
		 * sSaisie --> tous les retours des menus. Variable dame de joie. Lors de l'ex�cution du programme. Parfois certaines op�rations requiert de stocker une partie d'information pendant le traitement. 
		 * Ces actions �tant des sous-produits de la valeur de sSaisie, je les stocks dans sSaisie temporairement. 
		 */
		boolean err=false;
		/*
		 * err -> Permet la sortie des boucles en cas d'erreur.
		 */
		while(iSaisie>10||iSaisie<=0)//Taille du tableau entre 1 et 10
		{
			sSaisie=JOptionPane.showInputDialog("Quelle taille aura le tableau? Entier entre 1 et 10");
			iSaisie=Integer.parseInt(sSaisie);
		}
		final int iTaille=iSaisie;																			//taille fixe
		iTab=new int[iTaille];																				//init du tableau
		iSaisie=0;																							//On remet � z�ro. Le test est fini
		while(true)																							//Boucle du programme
		{
			sSaisie=((String)JOptionPane.showInputDialog(null, "S�lectionnez votre choix parmi les options suivantes:", "Menu principal", JOptionPane.QUESTION_MESSAGE, null, sMenuPrincipal, sMenuPrincipal[0])).toLowerCase();
			sSaisie=String.valueOf(sSaisie.charAt(0));
			switch(sSaisie)																					//Traitement des choix du menu
			{
			case "1": case "2": case "3":/*1-Ajouter un nombre au d�but, � la fin ou � un endroit sp�cifique du tableau
								  2-Modifier un nombre au tableau*/
					sSSMenu=new String[iTaille];															//Cr�ation d'un tableau de sous choix avec toutes les positions 
					for (int i=0;i<sSSMenu.length;i++)														//Construction du menu
					{
						if(i==0)
							sSSMenu[i]="D�but";
						else if(i==(sSSMenu.length-1))
							sSSMenu[i]="Fin";
						else
							sSSMenu[i]=String.valueOf(i+1);
					}
					iPositionTravail=JOptionPane.showOptionDialog(null, "Choisir la position du nombre", "Sous-Menu #"+sSaisie, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, sSSMenu, sSSMenu[0]);
					while(iSaisie<1&&!err) 																	//Tant que la saisie n'est pas un nombre ou qu'il n'y a pas une erreur avec le nombre. Le nombre est la position�
					{
						if(Integer.parseInt(sSaisie)==1)
						{																					//Ajout
							if(iTab[iPositionTravail]!=0)													//La position n'est pas libre
							{
								err=true;
								iCodeErreur=1;
							}
							for(int i=0;i<iTab.length;i++)													//V�rifie si le tableau est pleins
							{
								if(i==(iTab.length-1)&&iTab[i]!=0)
								{
									err=true;
									iCodeErreur=2;
								}
								if(iTab[i]==0)																//Position vide Break pas d'erreur
								{
									break;
								}
							}
							if(!err)
							{
								iSaisie=Integer.parseInt(JOptionPane.showInputDialog("Nombre � ajouter"));
								sSortie="ajout�";
							}
						}
						if(Integer.parseInt(sSaisie)==2)
						{																					//Modification
							if(iTab[iPositionTravail]==0)
							{
								err=true;
								iCodeErreur=4;
							}
							if(!err)
							{
								iSaisie=Integer.parseInt(JOptionPane.showInputDialog(null, "Nombre � modifier", iTab[iPositionTravail]));
								sSortie="modifi�";
							}
						}
						if(Integer.parseInt(sSaisie)==3)													//Supression
						{
							if(iTab[iPositionTravail]==0)													//Il n'y a pas de nombre � cette position
							{
								err=true;
								iCodeErreur=3;
							}
							if(!err)
							{
								iSaisie=iTab[iPositionTravail];
								sSortie="supprim�";
							}
							break;
						}
							
					}
					if(!err)
						{
						JOptionPane.showMessageDialog(null, "Le nombre "+iSaisie+" vient d'�tre "+sSortie+" � la position "+(iPositionTravail+1));
						if(sSortie.equals("supprim�"))
							iSaisie=0;
						iTab[iPositionTravail]=iSaisie;
						}
					else
					{
						switch(iCodeErreur)
						{
						case 1:
							JOptionPane.showMessageDialog(null, "Ajouter un nombre � une position o� un nombre est d�j� pr�sent", "Erreur", JOptionPane.ERROR_MESSAGE);
							break;
						case 2:
							JOptionPane.showMessageDialog(null, "Ajouter un nombre lorsque le tableau est plein", "Erreur", JOptionPane.ERROR_MESSAGE);
							break;
						case 3:
							JOptionPane.showMessageDialog(null, "Supprimer un nombre � une position o� il n'y a aucun nombre entr�", "Erreur", JOptionPane.ERROR_MESSAGE);
							break;
						case 4:
							JOptionPane.showMessageDialog(null, "Modifier un nombre � une position o� il n'y a aucun nombre entr�", "Erreur", JOptionPane.ERROR_MESSAGE);
							break;
						default:
							JOptionPane.showMessageDialog(null, "Une erreur non g�r� s'est produit", "Erreur", JOptionPane.ERROR_MESSAGE);
							break;
						}
					}
					/*R�initialisation des variables utilis�es*/
					iSaisie=0;
					sSSMenu=new String[0];
					sSortie="";
					err=false;
					iCodeErreur=0;
				break;
			case "4":																				//Afficher tous les nombres du tableau;
					sSortie+="Affichage de tous les nombres du tableau\n";
					for (int i=0;i<iTab.length;i++)
					{
						sSortie+="Position "+(i+1)+" :"+ iTab[i]+"\n";
					}
					JOptionPane.showMessageDialog(null, sSortie);
					/*R�initialisation des variables utilis�es*/
					sSortie="";
				break;
			case "5":																				//Additionner un nombre quelconque (saisie par l'utlisateur � toutes les positions du tableau.
					while(iSaisie<1)
						{
						iSaisie=Integer.parseInt(JOptionPane.showInputDialog("Saisir le nombre � ajouter � la somme du tableau"));
						}
					for(int i=0;i<iTab.length;i++)
					{
						iSomme+=iTab[i];
					}
					iSomme+=iSaisie;
					JOptionPane.showMessageDialog(null, "Le total du nombre saisie et de tous les �l�ments du tableau est de "+iSomme);
					/*R�initisalisation des variables utilis�es*/
					iSomme=0;
				break;
			case "6":																				//Initialiser toutes le spositions du tableau par une m�me valeur (saisie par l'utilisateur)
					while(iSaisie==0)
					{
						iSaisie=Integer.parseInt(JOptionPane.showInputDialog("� quelle valeur souhaitez-vous initalis� le tableau?"));
					}
					for(int i=0;i<iTab.length;i++)
					{
						iTab[i]=iSaisie;
					}
					/*R�initialisation des variables utilis�es*/
					iSaisie=0;
				break;
			case "7":																				//Trier le tableau.
					Arrays.sort(iTab);
					JOptionPane.showMessageDialog(null, "Le tableau a �t� tri� en ordre croissant");
				break;
			case "8":																				//quitter
				JOptionPane.showMessageDialog(null, "Aurevoir!");
				System.exit(1);
			default:
				JOptionPane.showMessageDialog(null, sSaisie +" une erreur non g�r�e s'est produite r�essay�");
				break;
			}
		}
			
			
	}

}
