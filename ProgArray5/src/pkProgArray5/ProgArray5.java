package pkProgArray5;
import javax.swing.JOptionPane;
import java.text.*;
/**
 * 
 * Nom : ProgArray5
 * Description: Gestion des �tudiants
 * Nom des classes utilis�es : JOptionPane, NumberFormat
 * Nom et version de l'IDE : Eclipse Luna 4.4.0, JRE 1.8.0-20
 * OS : Windows 7 Professionnal
 * Auteur : Olivier Bois
 * Date : Novembre 2014
 *
 */
public class ProgArray5 {

	public static void main(String[] args) {
		final String EXIGENCE_PROF=" * Nom : ProgArray5\n* Nom des classes utilis�es : JOptionPane, NumberFormat\n* Nom et version de l'IDE : Eclipse Luna 4.4.0, JRE 1.8.0-20\n* OS : Windows 7 Professionnal\n* Auteur : Olivier Bois\n* Date : Novembre 2014\n*";
		JOptionPane.showMessageDialog(null, EXIGENCE_PROF, "Exigence professeure", JOptionPane.PLAIN_MESSAGE);
		
		
		String sEleve[][]={{"123", "Alice", "123 rue Albert", "88", "86"}, {"456", "Benoit", "456 Bellevue", "65", "60"},{"789", "Claude", "789 Cloutier", "95", "90"},{"928", "Diane", "928 Duclos", "79", "78"},{"999","Emile", "894 Emilien", "89", "89"}};
		/*
		 * sEleve -> Tableau de Tableau des �tudiants
		 */
		int iPositionTravail=0;
		int iPositionTravail2=0;
		int iPositionTravail3=0;
		/*
		 * iPositionTravail&(2&3) -> Position de travail dans les tableau. Utilis� comme marqueur lors de l'�xecution du proramme.
		 */
		int iCodeErreur=0, iNbEleve=0;
		/*
		 * iCodeErreur -> Contient le code d'erreur s'il y a lieu
		 * iNbEleve -> Sert � compter le nombre d'�l�ves pour les moyennes 
		 */
		double dMoyenne=0, dSomme=0;
		/*
		 * dMoyenne -> Contient les moyennes requises selon le cas
		 * dSomme -> Contient les sommes requises selon le cas
		 */
		String sMenu[]={"1-Ajouter un �tudiant", "2- Modifier l'adresse, la note de Logique, ou la note de programmation", "3- Supprimer un �tudiant", "4- Visualiser les informations concernant un �tudiant", "5- Visualiser le nom des �tudiants", "6- Visualiser le nom ainsi que la note des �tudiants ayant les notes aux extr�mes maximum et minimum LOGIQUE","7-Visualiser la moyenne du cours programmation structur�ee", "8- Visualiser la moyenne des deux cours ensemble", "9-Quitter"};
		/*
		 * sMenu -> Menu principal
		 */
		String sSSMenu[];
		/*
		 * sSSMenu -> Contient les sous-menu n�cessaire � l'application
		 */
		String sSaisie, sSortie="", sTitre="";
		/*
		 * sSaisie, sSortie, sTitre -> Variables servant � l'E/Sortie avec l'utilisateur. 
		 */
		NumberFormat prcnt=NumberFormat.getPercentInstance();
		boolean err=false;
		/*
		 * err -> Sert � sortir des boucles, et d�tection d'erreur s'il y a lieu
		 */
		
		while(true)																			//Boucle principale du programme. Arr�t �venementiel
		{
			sSaisie=String.valueOf(((String)JOptionPane.showInputDialog(null, "S�lectionner l'action souhait�", "R�sum� des notes", JOptionPane.QUESTION_MESSAGE, null, sMenu, sMenu[0])).charAt(0));
			switch(Integer.parseInt(sSaisie))
			{
			case 1:																			//Ajouter un �tudiant
				err=true;
				iCodeErreur=1;
				for(int i=0;i<sEleve.length;i++)
				{
					if(sEleve[i][0]=="999")
					{
						err=false;
						iCodeErreur=0;
						iPositionTravail=i;
						break;
					}
				}
				if(!err)
				{
					do
					{
						sSaisie=JOptionPane.showInputDialog("Num�ro de matricule");			//****Impossible de d�finir le format d'entr� nomatricule. �nonc� "Type num�rique ou cha�ne de caract�res"****
					}while(sSaisie.equals("999")||sSaisie.length()<1);						//Tant que l'�l�ve est inactif ou si la longueur de la chaine est plus petit 1 
					
					sEleve[iPositionTravail][0]=sSaisie;
					
					do
					{
						err=false;
						sSaisie=JOptionPane.showInputDialog("Pr�nom de l'�tudiant");
						for(int i=0;i<sSaisie.length();i++)									//V�rifie si le nom n'est pas compos� de chiffres. 
						{
							if(Character.isDigit(sSaisie.charAt(i)))
							{
								err=true;
							}
						}
						if(!err)
						{
							break;
						}
					}while(true);															//Tant que le nom d'�tudiant n'est pas valide
					
					sEleve[iPositionTravail][1]=sSaisie;
					sEleve[iPositionTravail][2]=JOptionPane.showInputDialog("Adresse de l'�tudiant");
					
					do
					{
						err=false;
						sSaisie=JOptionPane.showInputDialog("Note de logique (Saisir sous forme 99.99)");
						for(int i=0;i<sSaisie.length();i++)
						{
							if(!(Character.isDigit(sSaisie.charAt(i))||sSaisie.charAt(i)=='.'))//Si ce n'est pas un nombre, on set une erreur, donc 
							{
								err=true;
							}
						}
						if(!(Double.parseDouble(sSaisie)>=0&&Double.parseDouble(sSaisie)<=100))
							err=true;
						if(!err)
							break;
					}while(true);																//Tant que la note n'est pas valide
					
					sEleve[iPositionTravail][3]=sSaisie;
					
					do
					{
						err=false;
						sSaisie=JOptionPane.showInputDialog("Note de programmation ( Saisie sous forme 99.99)");
						for(int i=0;i<sSaisie.length();i++)
						{
							if(!(Character.isDigit(sSaisie.charAt(i))||sSaisie.charAt(i)=='.'))//Si ce n'est pas un nombre, on set une erreur, donc 
							{
								err=true;
							}
						}
						if(!(Double.parseDouble(sSaisie)>=0&&Double.parseDouble(sSaisie)<=100))
							err=true;
						if(!err)
							break;
					}while(true);																//Tant que la saisie n'est pas valide

					sEleve[iPositionTravail][4]=sSaisie;
					
				}
				/*R�initialisaiton des variables utilis�es*/
				sSaisie="";
				iPositionTravail=0;
				break;
			case 2: 																			//Modifier l'adresse, la note de logique ou la note de prog
				sSSMenu=new String[3];
				err=true;
				iCodeErreur=3;
				for(int i=0;i<sEleve.length;i++)												//Parcours de tous les �tudiants
				{
					if(!sEleve[i][0].equals("999"))
						sSortie+="Matricule #"+sEleve[i][0]+", \nNom: "+sEleve[i][1]+"\nAdresse: "+sEleve[i][2]+"\nNote de Logique: "+ prcnt.format((Double.parseDouble(sEleve[i][3])/100))+"\nNote de Programmation: "+prcnt.format((Double.parseDouble(sEleve[i][4])/100))+"\n---\n\n";
				}
				sSaisie=JOptionPane.showInputDialog(sSortie+"\n\n----\nNum�ro de matricule de l'�tudiant � modifier");
				sSortie="";
				for(int i=0;i<sEleve.length;i++)												//On v�rifie si l'�l�ve existe, sinon, on affiche le message d'erreur
				{
					if(sEleve[i][0].equals(sSaisie))											//Est-ce que l'�l�ve existe? Oui? On indique le code d'erreur � z�ro, le marqueur d'erreur � false, indique la position que nous travaillerons et break la boucle
					{
						iPositionTravail=i;
						err=false;
						iCodeErreur=0;
						break;
					}
				}
				
				if(!err&&!sEleve[iPositionTravail][0].equals("999"))							//# de matricule valide, on poursuit l'execution
				{
					sTitre="Modification de l'�tudiant #"+sEleve[iPositionTravail][0];
					sSortie="Matricule #"+sEleve[iPositionTravail][0]+" "+sEleve[iPositionTravail][1]+"\n\n---\nS�lectionnez ce que vous souhaitez modifier";
					sSSMenu[0]=sEleve[iPositionTravail][2];
					sSSMenu[1]="Note de logique: "+prcnt.format(Double.parseDouble(sEleve[iPositionTravail][3])/100);
					sSSMenu[2]="Note de programmation: "+prcnt.format(Double.parseDouble(sEleve[iPositionTravail][4])/100);
					
					sSaisie=String.valueOf(JOptionPane.showOptionDialog(null, sSortie, sTitre, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, sSSMenu, sSSMenu[0]));
					
				
					switch(Integer.parseInt(sSaisie))
					{
					case 0:																		//Modification de l'adresse
						iPositionTravail2=2;
						sEleve[iPositionTravail][iPositionTravail2]=JOptionPane.showInputDialog(null, "Nouvelle adresse de l'�l�ve", sEleve[iPositionTravail][iPositionTravail2]);
						break;
					case 1:																		//Modification de la note de logique
						iPositionTravail2=3;
						do
						{	
							err=false;
							sSaisie=JOptionPane.showInputDialog(null, "Nouvelle note de logique(Sous la forme 99.99)", prcnt.format(Double.parseDouble(sEleve[iPositionTravail][iPositionTravail2])/100) );
							for(int i=0;i<sSaisie.length();i++)
							{
								if(!(Character.isDigit(sSaisie.charAt(i))||sSaisie.charAt(i)=='.'))//On s'assure que le chiffre saisie est sous la forme 99.99
									err=true;
							}
							if(Double.parseDouble(sSaisie)>100||Double.parseDouble(sSaisie)<0)
								err=true;
							if(!err)
								break;
						}while(true);															//Tant que la saisie ne respecte pas les conditions
						sEleve[iPositionTravail][iPositionTravail2]=sSaisie;
						break;
					case 2:																		//Modification de la note de prog
						iPositionTravail2=4;
						do
						{
							err=false;
							sSaisie=JOptionPane.showInputDialog(null, "Note de Programmation(Sous la forme 99.99)", prcnt.format(Double.parseDouble(sEleve[iPositionTravail][iPositionTravail2])/100));
							for(int i=0;i<sSaisie.length();i++)
							{
								if(!(Character.isDigit(sSaisie.charAt(i))||sSaisie.charAt(i)=='.'))//On s'assure que le chiffre saisie est sous la forme 99.99
									err=true;
							}
							if(Double.parseDouble(sSaisie)>100||Double.parseDouble(sSaisie)<0)
								err=true;
							if(!err)
								break;
						}while(true);															//Tant que le format de la note ne respecte pas les exigences
						sEleve[iPositionTravail][iPositionTravail2]=sSaisie;
						break;
					default:
						JOptionPane.showMessageDialog(null, "Un choix non support� a �t� soumis au programme");
					break;
					}
				}
				/*R�initialisation des variables utilis�es*/
				sSSMenu=new String[0];
				sSaisie="";
				sTitre="";
				sSortie="";
				iPositionTravail=0;
				iPositionTravail2=0;
				break;
			case 3: 																				//Supprimer l'�tudiant --> Setter l'ID � 999
				err=true;
				iCodeErreur=4;
				for(int i=0;i<sEleve.length;i++)													//Parcours de tous les �tudiants
				{
					if(!sEleve[i][0].equals("999"))
						sSortie+="Matricule #"+sEleve[i][0]+", \nNom: "+sEleve[i][1]+"\nAdresse: "+sEleve[i][2]+"\nNote de Logique: "+ prcnt.format((Double.parseDouble(sEleve[i][3])/100))+"\nNote de Programmation: "+prcnt.format((Double.parseDouble(sEleve[i][4])/100))+"\n---\n\n";
				}
				sSaisie=JOptionPane.showInputDialog(sSortie+"\n\n----\nNum�ro de matricule de l'�tudiant � supprimer");
				sSortie="";
				for(int i=0;i<sEleve.length;i++)													//Parcours de tous les �tudiants
				{
					if(sEleve[i][0].equals(sSaisie)&&sSaisie!="999")
					{
						iPositionTravail=i;
						err=false;
						iCodeErreur=0;
						break;
					}
				}
				if(!err)
				{
																									//On force l'utilisateur � faire une action au clavier pour �viter les faux clics
					sSaisie=JOptionPane.showInputDialog("�tes-vous s�r de vouloir supprimer l'�tudiant matricule #"+sEleve[iPositionTravail][0]+"? Saisir O pour oui").toLowerCase();
					if(sSaisie.charAt(0)=='o')
					{
						JOptionPane.showMessageDialog(null, "Vous avez supprim� avec succ�s l'�tudiant #"+sEleve[iPositionTravail][0], "Suppression effectu�e", JOptionPane.PLAIN_MESSAGE);
						sEleve[iPositionTravail][0]="999";
					}
					else
						JOptionPane.showMessageDialog(null,"Vous n'avez pas supprim� l'�tudiant #"+sEleve[iPositionTravail][0],"Suppression annul�e", JOptionPane.PLAIN_MESSAGE);
				}
				/*R�initialisation des variables utilis�es*/;
				iPositionTravail=0;
				sSortie="";
				sSaisie="";
				break;
			case 4:																					//Visualiser l'information concernant l'�tudiant
				sSaisie=JOptionPane.showInputDialog("Matricule de l'�tudiant � consulter");
				for(int i=0;i<sEleve.length;i++)													//Parcours de tous les �tudiants, On v�rifie si l'�tudiant existe
				{
					if(sSaisie.equals(sEleve[i][0]))												//Si l'�tudiant existe on le visualise
					{
						sSortie+="Matricule #"+sSaisie+", \nNom: "+sEleve[i][1]+"\nAdresse: "+sEleve[i][2]+"\nNote de Logique: "+ prcnt.format((Double.parseDouble(sEleve[i][3])/100))+"\nNote de Programmation: "+prcnt.format((Double.parseDouble(sEleve[i][4])/100))+"\n";
						break;
					}
					if(!sSaisie.equals(sEleve[i][0])&&i==(sEleve.length-1))							//Si c'est la derni�re position de la boucle et que ce n'est pas l'�tudiant, on affiche un message d'erreur.
					{
						err=true;
						iCodeErreur=5;//�tudiant existe pas
					}
				}
				
				if(!err)
					JOptionPane.showMessageDialog(null, sSortie, "Visualisaiton de l'�tudiant", JOptionPane.PLAIN_MESSAGE);
				/*R�initialisation des variables utilis�es*/
				sSortie="";
				break;
			case 5:																					//Visualise rle nom de tous les �tudiants
				for(int i=0;i<sEleve.length;i++)													//Parcours de tous les �tudiants
				{
					if(!sEleve[i][0].equals("999"))
					{
						sSortie+="Nom: "+sEleve[i][1]+"\n";
					}
				}
				sTitre="Affichage des noms des �tudiants";
				JOptionPane.showMessageDialog(null, sSortie, sTitre, JOptionPane.PLAIN_MESSAGE);
				/*R�initialisaiton des variables utilis�es*/
				sSortie="";
				sTitre="";
				break;
			case 6:																					//Visualiser le nom des �tudiants aux extr�mes maximum et minimum de logique 
				for (int i=0;i<sEleve.length;i++)
				{
				/*
				 * iPositionTravail2 est la position de celui ayant la note la plus basse.
				 *iPosisitionTravail3 est la position de celui ayant la note la plus haute.
				 */
					if(!sEleve[i][0].equals("999"))
					{
						if(Double.parseDouble(sEleve[iPositionTravail2][3])>Double.parseDouble(sEleve[i][3]))
							iPositionTravail2=i;
						if(Double.parseDouble(sEleve[iPositionTravail3][3])<Double.parseDouble(sEleve[i][3]))
							iPositionTravail3=i;
					}
				}
				sSortie+="Matricule #"+sEleve[iPositionTravail2][0]+" \nNom: "+sEleve[iPositionTravail2][1]+"\nNote de Logique: "+ prcnt.format((Double.parseDouble(sEleve[iPositionTravail2][3])/100))+"\n";
				sSortie+="\n-----\n\nMatricule #"+sEleve[iPositionTravail3][0]+" \nNom: "+sEleve[iPositionTravail3][1]+"\nNote de Logique: "+ prcnt.format((Double.parseDouble(sEleve[iPositionTravail3][3])/100))+"\n";
				sTitre="Affichage des �l�ves ayant eu la note maximum et ayant eu la note minimum";
				JOptionPane.showMessageDialog(null, sSortie, sTitre, JOptionPane.PLAIN_MESSAGE);
				/*R�initialisation des variables utilis�es*/
				sSortie="";
				sTitre="";
				iPositionTravail2=0;
				iPositionTravail3=0;
				break;
			case 7:																						//Visualiser la moyenne du cours de programmation structur�e
				for(int i=0;i<sEleve.length;i++)
				{
					if(!sEleve[i][0].equals("999"))
					{
					dSomme+=Double.parseDouble(sEleve[i][4]);
					iNbEleve++;
					}
				}
				dMoyenne=dSomme/iNbEleve;
				sSortie="La moyenne du cours de programmation est de  "+prcnt.format(dMoyenne/100);
				sTitre="Moyenne du cours de programmation";
				JOptionPane.showMessageDialog(null, sSortie, sTitre, JOptionPane.PLAIN_MESSAGE);
				/*R�initialisation des variables utilis�es*/
				sTitre="";
				sSortie="";
				iNbEleve=0;
				dSomme=0;
				break;
			case 8:																							//Visualiser la moyenne des deux cours ensembles
				for(int i=0;i<sEleve.length;i++)
				{
					if(!sEleve[i][0].equals("999"))
					{
						iNbEleve++;
						dSomme+=Double.parseDouble(sEleve[i][3]);											//Note de logique
						dSomme+=Double.parseDouble(sEleve[i][4]);											//Note de programmation
					}
				}
				dMoyenne=dSomme/(iNbEleve*2);															//Calcul de la moyenne group�e
				sSortie="La moyenne des cours de Logique et de Programmation ensemble est de "+prcnt.format(dMoyenne/100);
				sTitre="Moyenne des cours de Logique et de Programmation";
				JOptionPane.showMessageDialog(null, sSortie, sTitre, JOptionPane.PLAIN_MESSAGE);
				/*R�initialisation des variables utilis�es*/
				sTitre="";
				sSortie="";
				break;
			case 9:																							//Il nous quitte. *MUSIQUE* CEEE N'EST QU'UN AUREVOIREEEEE.....
				JOptionPane.showMessageDialog(null, "Aurevoir!", "Vous nous quittez d�j�!",JOptionPane.INFORMATION_MESSAGE);
				System.exit(1);
				break;
			default:
				err=true;
				iCodeErreur=6;
				break;
			
			}
			if(err)																							//Affichage des messages d'erreur en fin de parcours de la boucle
			{
				switch(iCodeErreur)																			//Wow. C'est magnifique. 
				{
				case 1:
					sSortie="Vous ne pouvez pas ajouter un �tudiant, il n'y a pas d'inactifs";
					sTitre="Message d'erreur #"+iCodeErreur;
					break;
				case 2:
					sSortie="Vous ne pouvez pas ajouter un �tudiant, le maximum est atteint";
					sTitre="Message d'erreur #"+iCodeErreur;
					break;
				case 3:
					sSortie="Impossible de modifier un �tudiant qui n'existe pas";
					sTitre="Message d'erreur #"+iCodeErreur;
					break;
				case 4:
					sSortie="Impossible de supprimer un �tudiant qui n'existe pas";
					sTitre="Message d'erreur #"+iCodeErreur;
					break;
				case 5:
					sSortie="Impossible de visualiser un �tudiant qui n'existe pas";
					sTitre="Message d'erreur #"+iCodeErreur;
					break;
				case 6:
					sSortie="Une s�lection non g�r�e a �t� soumise au programme. Merci de recommencer";
					sTitre="Message d'ereur #"+iCodeErreur;
					break;
				default:
					sSortie="Une erreur non g�r�e s'est produite";
					sTitre="Message d'erreur par d�faut";
					break;
				}
				JOptionPane.showMessageDialog(null, sSortie, sTitre, JOptionPane.ERROR_MESSAGE);
				/*R�initialisaiton des variables*/
				iCodeErreur=0;
				err=false;
				sSortie="";
				sTitre="";
			}
		}
		
	}

}
