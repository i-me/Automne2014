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
 * *Date création: Novembre 2014
 * 
 */



public class ProgArray4 {

	public static void main(String[] args) {

		final String EXIGENCE_PROF="*Nom:ProgArray4\n*Nom des classes: JOptionPane, Arrays\n *Description: Gestion d'un tableau de nombre\n*Nom et version de l'IDE: Eclipse Luna 4.4.0, JRE 1.8.0-20 \n*OS: Windows 7 \n*Auteur: Olivier Bois\n*Date création: Novembre 2014";
				JOptionPane.showMessageDialog(null, EXIGENCE_PROF, "Exigence prof", JOptionPane.PLAIN_MESSAGE);
		int iSaisie=0, iPositionTravail, iTab[]=new int[0], iSomme=0, iCodeErreur=0;
		/*
		 * iSaisie->Contient le ssaisies de format numériques (EX choix de formulaire, chiffre à ajouter, etc)
		 * iPositionTravail ->Position de travail du tableau. C'est un marqueur de position
		 * iTab -> Tableau de sNombres
		 * iSomme -> Sert à l'option 5, quand on aditionne un nombre à toutes les entrées du tableau
		 * iCodeErreur -> Sert à la gestion et l'affichage des erreurs. C'est la valeur du case dans le switch.
		 */
		String sMenuPrincipal[]={"1-Ajouter un nombre au début, à la fin, ou à un endroit spécifique du tableau", "2- Modifier un nombre à un endroit spécifique dans le tableau", "3- Supprimer un nombre au début, à la fin ou à un endroit spécifique", "4- Afficher tous les nombres du tableau", "5- Additionner un nombre quelconque (saisie par l'utilisateur à toutes le spositions du tableau)", "6- Initialiser toutes les positions du tableau par une même valeur (saisie par l'utilisateur)", "7- Triez le tableau", "8- Quitter l'application"};
		/*
		 * sMenuPrincipal -> C'est le menu principal
		 */
		String sSSMenu[], sConstructMenu, sSortie="",   sSaisie;
		/*
		 * sSSMenu --> Construction des sous menu style endroits spécifiques dans le tableau à modifier, début/fin, 
		 * sSaisie --> tous les retours des menus. Variable dame de joie. Lors de l'exécution du programme. Parfois certaines opérations requiert de stocker une partie d'information pendant le traitement. 
		 * Ces actions étant des sous-produits de la valeur de sSaisie, je les stocks dans sSaisie temporairement. 
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
		iSaisie=0;																							//On remet à zéro. Le test est fini
		while(true)																							//Boucle du programme
		{
			sSaisie=((String)JOptionPane.showInputDialog(null, "Sélectionnez votre choix parmi les options suivantes:", "Menu principal", JOptionPane.QUESTION_MESSAGE, null, sMenuPrincipal, sMenuPrincipal[0])).toLowerCase();
			sSaisie=String.valueOf(sSaisie.charAt(0));
			switch(sSaisie)																					//Traitement des choix du menu
			{
			case "1": case "2": case "3":/*1-Ajouter un nombre au début, à la fin ou à un endroit spécifique du tableau
								  2-Modifier un nombre au tableau*/
					sSSMenu=new String[iTaille];															//Création d'un tableau de sous choix avec toutes les positions 
					for (int i=0;i<sSSMenu.length;i++)														//Construction du menu
					{
						if(i==0)
							sSSMenu[i]="Début";
						else if(i==(sSSMenu.length-1))
							sSSMenu[i]="Fin";
						else
							sSSMenu[i]=String.valueOf(i+1);
					}
					iPositionTravail=JOptionPane.showOptionDialog(null, "Choisir la position du nombre", "Sous-Menu #"+sSaisie, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, sSSMenu, sSSMenu[0]);
					while(iSaisie<1&&!err) 																	//Tant que la saisie n'est pas un nombre ou qu'il n'y a pas une erreur avec le nombre. Le nombre est la positioné
					{
						if(Integer.parseInt(sSaisie)==1)
						{																					//Ajout
							if(iTab[iPositionTravail]!=0)													//La position n'est pas libre
							{
								err=true;
								iCodeErreur=1;
							}
							for(int i=0;i<iTab.length;i++)													//Vérifie si le tableau est pleins
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
								iSaisie=Integer.parseInt(JOptionPane.showInputDialog("Nombre à ajouter"));
								sSortie="ajouté";
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
								iSaisie=Integer.parseInt(JOptionPane.showInputDialog(null, "Nombre à modifier", iTab[iPositionTravail]));
								sSortie="modifié";
							}
						}
						if(Integer.parseInt(sSaisie)==3)													//Supression
						{
							if(iTab[iPositionTravail]==0)													//Il n'y a pas de nombre à cette position
							{
								err=true;
								iCodeErreur=3;
							}
							if(!err)
							{
								iSaisie=iTab[iPositionTravail];
								sSortie="supprimé";
							}
							break;
						}
							
					}
					if(!err)
						{
						JOptionPane.showMessageDialog(null, "Le nombre "+iSaisie+" vient d'être "+sSortie+" à la position "+(iPositionTravail+1));
						if(sSortie.equals("supprimé"))
							iSaisie=0;
						iTab[iPositionTravail]=iSaisie;
						}
					else
					{
						switch(iCodeErreur)
						{
						case 1:
							JOptionPane.showMessageDialog(null, "Ajouter un nombre à une position où un nombre est déjà présent", "Erreur", JOptionPane.ERROR_MESSAGE);
							break;
						case 2:
							JOptionPane.showMessageDialog(null, "Ajouter un nombre lorsque le tableau est plein", "Erreur", JOptionPane.ERROR_MESSAGE);
							break;
						case 3:
							JOptionPane.showMessageDialog(null, "Supprimer un nombre à une position où il n'y a aucun nombre entré", "Erreur", JOptionPane.ERROR_MESSAGE);
							break;
						case 4:
							JOptionPane.showMessageDialog(null, "Modifier un nombre à une position oû il n'y a aucun nombre entré", "Erreur", JOptionPane.ERROR_MESSAGE);
							break;
						default:
							JOptionPane.showMessageDialog(null, "Une erreur non géré s'est produit", "Erreur", JOptionPane.ERROR_MESSAGE);
							break;
						}
					}
					/*Réinitialisation des variables utilisées*/
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
					/*Réinitialisation des variables utilisées*/
					sSortie="";
				break;
			case "5":																				//Additionner un nombre quelconque (saisie par l'utlisateur à toutes les positions du tableau.
					while(iSaisie<1)
						{
						iSaisie=Integer.parseInt(JOptionPane.showInputDialog("Saisir le nombre à ajouter à la somme du tableau"));
						}
					for(int i=0;i<iTab.length;i++)
					{
						iSomme+=iTab[i];
					}
					iSomme+=iSaisie;
					JOptionPane.showMessageDialog(null, "Le total du nombre saisie et de tous les éléments du tableau est de "+iSomme);
					/*Réinitisalisation des variables utilisées*/
					iSomme=0;
				break;
			case "6":																				//Initialiser toutes le spositions du tableau par une même valeur (saisie par l'utilisateur)
					while(iSaisie==0)
					{
						iSaisie=Integer.parseInt(JOptionPane.showInputDialog("À quelle valeur souhaitez-vous initalisé le tableau?"));
					}
					for(int i=0;i<iTab.length;i++)
					{
						iTab[i]=iSaisie;
					}
					/*Réinitialisation des variables utilisées*/
					iSaisie=0;
				break;
			case "7":																				//Trier le tableau.
					Arrays.sort(iTab);
					JOptionPane.showMessageDialog(null, "Le tableau a été trié en ordre croissant");
				break;
			case "8":																				//quitter
				JOptionPane.showMessageDialog(null, "Aurevoir!");
				System.exit(1);
			default:
				JOptionPane.showMessageDialog(null, sSaisie +" une erreur non gérée s'est produite réessayé");
				break;
			}
		}
			
			
	}

}
