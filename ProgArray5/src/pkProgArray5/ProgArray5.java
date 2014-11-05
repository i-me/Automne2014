package pkProgArray5;
import javax.swing.JOptionPane;
import java.text.*;
public class ProgArray5 {

	public static void main(String[] args) {
		String sEleve[][]={{"123", "Alice", "123 rue Albert", "88", "86"}, {"456", "Benoit", "456 Bellevue", "65", "60"},{"789", "Claude", "789 Cloutier", "95", "90"},{"928", "Diane", "928 Duclos", "79", "78"},{"999","Emile", "894 Emilien", "89", "89"}};
		int iPositionTravail=0;
		int iPositionTravail2=0;
		int iPositionTravail3=0;
		int iCodeErreur=0;//Sert à gérer les erreurs
		double dMoyenne=0, dSomme=0;
		String sMenu[]={"1-Ajouter un étudiant", "2- Modifier l'adresse, la note de Logique, ou la note de programmation", "3- Supprimer un étudiant", "4- Visualiser les informations concernant un étudiant", "5- Visualiser le nom des étudiants", "6- Visualiser le nom ainsi que la note des étudiants ayant les notes aux extrêmes maximum et minimum LOGIQUE","7-Visualiser la moyenne du cours programmation structuréee", "8- visualiser la moyenne des deux cours ensemble", "9-Quittre"};
		String sSSMenu[];
		String sSaisie, sSortie="", sTitre="";//Interaction avec l'utilisateur I/O
		NumberFormat prcnt=NumberFormat.getPercentInstance();
		boolean err=false;
		
		while(true)
		{
			sSaisie=String.valueOf(((String)JOptionPane.showInputDialog(null, "Séclectionner l'action souhaité", "Résumé des notes", JOptionPane.QUESTION_MESSAGE, null, sMenu, sMenu[0])).charAt(0));
			switch(Integer.parseInt(sSaisie))
			{
			case 1://Ajouter un étudiant
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
						sSaisie=JOptionPane.showInputDialog("Numéro de matricule");
					}while(sSaisie.equals("999")||sSaisie.length()<1);//Si l'élève est inactif ou si la longueur de la chaine est de 0 
					
					sEleve[iPositionTravail][0]=sSaisie;
					
					do
					{
						err=false;
						sSaisie=JOptionPane.showInputDialog("Prénom de l'étudiant");
						for(int i=0;i<sSaisie.length();i++)//Vérifie si le nom est est composé de lettre
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
					}while(true);
					
					sEleve[iPositionTravail][1]=sSaisie;
					sEleve[iPositionTravail][2]=JOptionPane.showInputDialog("Adresse de l'étudiant");
					
					do
					{
						err=false;
						sSaisie=JOptionPane.showInputDialog("Note de logique");
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
					}while(true);
					
					sEleve[iPositionTravail][3]=sSaisie;
					
					do
					{
						err=false;
						sSaisie=JOptionPane.showInputDialog("Note de programmation");
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
					}while(true);

					sEleve[iPositionTravail][4]=sSaisie;
					
				}
				/*Réinitialisaiton des variables utilisées*/
				sSaisie="";
				iPositionTravail=0;
				break;
			case 2: //Modifier l'adresse, la note de logique ou la note de prog
				sSSMenu=new String[3];
				err=true;
				iCodeErreur=3;
				for(int i=0;i<sEleve.length;i++)//Parcours de tous les étudiants
				{
					if(sEleve[i][0]!="999")
						sSortie+="Matricule #"+sEleve[i][0]+", \nNom: "+sEleve[i][1]+"\nAdresse: "+sEleve[i][2]+"\nNote de Logique: "+ prcnt.format((Double.parseDouble(sEleve[i][3])/100))+"\nNote de Programmation: "+prcnt.format((Double.parseDouble(sEleve[i][4])/100))+"\n---\n\n";
				}
				sSaisie=JOptionPane.showInputDialog(sSortie+"\n\n----\nNuméro de matricule de l'étudiant à modifier");
				sSortie="";
				for(int i=0;i<sEleve.length;i++)//On vérifie si l'élève existe, sinon, on affiche le message d'erreur
				{
					if(sEleve[i][0].equals(sSaisie))//Est-ce que l'élève existe
					{
						iPositionTravail=i;
						err=false;
						iCodeErreur=0;
						break;
					}
				}
				if(!err)//# de matricule valide, on poursuit
				{
					sTitre="Modification de l'étudiant #"+sEleve[iPositionTravail][0];
					sSortie="Matricule #"+sEleve[iPositionTravail][0]+" "+sEleve[iPositionTravail][1]+"\n\n---\nSélectionnez ce que vous souhaitez modifier";
					sSSMenu[0]=sEleve[iPositionTravail][2];
					sSSMenu[1]=prcnt.format(Double.parseDouble(sEleve[iPositionTravail][3])/100);
					sSSMenu[2]=prcnt.format(Double.parseDouble(sEleve[iPositionTravail][4])/100);
					
					sSaisie=String.valueOf(JOptionPane.showOptionDialog(null, sSortie, sTitre, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, sSSMenu, sSSMenu[0]));
					
				
					switch(Integer.parseInt(sSaisie))
					{
					case 0://Modification de l'adresse
						iPositionTravail2=2;
						sEleve[iPositionTravail][iPositionTravail2]=JOptionPane.showInputDialog(null, "Nouvelle adresse de l'élève", sEleve[iPositionTravail][iPositionTravail2]);
						break;
					case 1://Modification de la note de logique
						iPositionTravail2=3;
						do
						{	
							err=false;
							sSaisie=JOptionPane.showInputDialog(null, "Nouvelle note de logique", prcnt.format(Double.parseDouble(sEleve[iPositionTravail][iPositionTravail2])/100) );
							for(int i=0;i<sSaisie.length();i++)
							{
								if(!(Character.isDigit(sSaisie.charAt(i))||sSaisie.charAt(i)=='.'))//On s'assure que le chiffre saisie est sous la forme 99.99
									err=true;
							}
							if(Double.parseDouble(sSaisie)>100||Double.parseDouble(sSaisie)<0)
								err=true;
							if(!err)
								break;
						}while(true);
						sEleve[iPositionTravail][iPositionTravail2]=sSaisie;
						break;
					case 2://Modification de la note de prog
						iPositionTravail2=4;
						do
						{
							err=false;
							sSaisie=JOptionPane.showInputDialog(null, "Note de Programmation", prcnt.format(Double.parseDouble(sEleve[iPositionTravail][iPositionTravail2])/100));
							for(int i=0;i<sSaisie.length();i++)
							{
								if(!(Character.isDigit(sSaisie.charAt(i))||sSaisie.charAt(i)=='.'))//On s'assure que le chiffre saisie est sous la forme 99.99
									err=true;
							}
							if(Double.parseDouble(sSaisie)>100||Double.parseDouble(sSaisie)<0)
								err=true;
							if(!err)
								break;
						}while(true);
						sEleve[iPositionTravail][iPositionTravail2]=sSaisie;
						break;
					default:
						JOptionPane.showMessageDialog(null, "Un choix non supporté a été soumis au programme");
					break;
					}
				}
				/*Réinitialisation des variables utilisées*/
				sSSMenu=new String[0];
				sSaisie="";
				sTitre="";
				sSortie="";
				iPositionTravail=0;
				iPositionTravail2=0;
				break;
			case 3: //Supprimer l'étudiant --> Setter l'ID à 999
				err=true;
				iCodeErreur=4;
				for(int i=0;i<sEleve.length;i++)//Parcours de tous les étudiants
				{
					if(sEleve[i][0]!="999")
						sSortie+="Matricule #"+sEleve[i][0]+", \nNom: "+sEleve[i][1]+"\nAdresse: "+sEleve[i][2]+"\nNote de Logique: "+ prcnt.format((Double.parseDouble(sEleve[i][3])/100))+"\nNote de Programmation: "+prcnt.format((Double.parseDouble(sEleve[i][4])/100))+"\n---\n\n";
				}
				sSaisie=JOptionPane.showInputDialog(sSortie+"\n\n----\nNuméro de matricule de l'étudiant à supprimer");
				sSortie="";
				for(int i=0;i<sEleve.length;i++)
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
					//On force l'utilisateur à faire une action au clavier pour évier les faux clics
					sSaisie=JOptionPane.showInputDialog("Êtes-vous sûr de vouloir supprimer l'étudiant matricule #"+iPositionTravail+"? Saisir O pour oui").toLowerCase();
					if(sSaisie.charAt(0)!='o')
						err=true;
					if(!err)
						sEleve[iPositionTravail][0]="999";
				}
				/*Réinitialisation des variables utilisées*/;
				iPositionTravail=0;
				sSortie="";
				sSaisie="";
				break;
			case 4://Visualiser l'information concernant l'étudiant
				sSaisie=JOptionPane.showInputDialog("Matricule de l'étudiant à consulter");
				for(int i=0;i<sEleve.length;i++)//On vérifie si l'étudiant existe
				{
					if(sSaisie.equals(sEleve[i][0]))//Si l'étudiant existe on le visualise
					{
						sSortie+="Matricule #"+sSaisie+", \nNom: "+sEleve[i][1]+"\nAdresse: "+sEleve[i][2]+"\nNote de Logique: "+ prcnt.format((Double.parseDouble(sEleve[i][3])/100))+"\nNote de Programmation: "+prcnt.format((Double.parseDouble(sEleve[i][4])/100))+"\n";
						break;
					}
					if(!sSaisie.equals(sEleve[i][0])&&i==(sEleve.length-1))//Si c'est la dernière position de la boucle et que ce n'est pas l'étudiant, on affiche un message d'erreur.
					{
						err=true;
						iCodeErreur=5;//Étudiant existe pas
					}
				}
				
				if(!err)
					JOptionPane.showMessageDialog(null, sSortie, "Visualisaiton de l'étudiant", JOptionPane.PLAIN_MESSAGE);
				/*Réinitialisation des variables utilisées*/
				sSortie="";
				break;
			case 5://Visualise rle nom de tous les étudiants
				for(int i=0;i<sEleve.length;i++)//Parcours de tous les étudiants
				{
					if(sEleve[i][0]!="999")
					{
						sSortie+="Nom: "+sEleve[i][1]+"\n";
					}
				}
				sTitre="Affichage des noms des étudiants";
				JOptionPane.showMessageDialog(null, sSortie, sTitre, JOptionPane.PLAIN_MESSAGE);
				/*Réinitialisaiton des variables utilisées*/
				sSortie="";
				sTitre="";
				break;
			case 6://Visualiser le nom des étudiants aux extrêmes maximum et minimum de logique 
				for (int i=0;i<sEleve.length;i++)
				{//iPositionTravail2 est la position de celui ayant la note la plus basse.
				//iPosisitionTravail3 est la positoin de celui ayant la note la plus haute.
					if(sEleve[i][0]!="999")
					{
						if(Double.parseDouble(sEleve[iPositionTravail2][3])>Double.parseDouble(sEleve[i][3]))
							iPositionTravail2=i;
						if(Double.parseDouble(sEleve[iPositionTravail3][3])<Double.parseDouble(sEleve[i][3]))
							iPositionTravail3=i;
					}
				}
				sSortie+="Matricule #"+sEleve[iPositionTravail2][0]+" \nNom: "+sEleve[iPositionTravail2][1]+"\nNote de Logique: "+ prcnt.format((Double.parseDouble(sEleve[iPositionTravail2][3])/100))+"\n";
				sSortie+="\n-----\n\nMatricule #"+sEleve[iPositionTravail3][0]+" \nNom: "+sEleve[iPositionTravail3][1]+"\nNote de Logique: "+ prcnt.format((Double.parseDouble(sEleve[iPositionTravail3][3])/100))+"\n";
				sTitre="Affichage des élèves ayant eu la note maximum et ayant eu la note minimum";
				JOptionPane.showMessageDialog(null, sSortie, sTitre, JOptionPane.PLAIN_MESSAGE);
				/*Réinitialisation des variables utilisées*/
				sSortie="";
				sTitre="";
				iPositionTravail2=0;
				iPositionTravail3=0;
				break;
			case 7://Visualiser la moyenne du cours de programmaiton structurée
				for(int i=0;i<sEleve.length;i++)
				{
					if(sEleve[i][0]!="999")
					{
					dSomme+=Double.parseDouble(sEleve[i][4]);
					}
				}
				dMoyenne=dSomme/sEleve.length;
				sSortie="La moyenne du cours de programmation est de  "+prcnt.format(dMoyenne/100);
				sTitre="Moyenne du cours de programmation";
				JOptionPane.showMessageDialog(null, sSortie, sTitre, JOptionPane.PLAIN_MESSAGE);
				/*Réinitialisation des variables utilisées*/
				sTitre="";
				sSortie="";
				break;
			case 8://Visualiser la moyenne de sdeux cours ensembles
				for(int i=0;i<sEleve.length;i++)
				{
					if(sEleve[i][0]!="999")
					{
						dSomme+=Double.parseDouble(sEleve[i][3]);//Note de logique
						dSomme+=Double.parseDouble(sEleve[i][4]);//Note de programmation
					}
				}
				dMoyenne=dSomme/(sEleve.length*2);//Calcul de la moyenne groupée
				sSortie="La moyenne des cours de Logique et de Programmation ensemble est de "+prcnt.format(dMoyenne/100);
				sTitre="Moyenne des cours de Logique et de Programmation";
				JOptionPane.showMessageDialog(null, sSortie, sTitre, JOptionPane.PLAIN_MESSAGE);
				/*Réinitialisation des variables utilisées*/
				sTitre="";
				sSortie="";
				break;
			case 9://Il nous quitte le chiens
				JOptionPane.showMessageDialog(null, "Aurevoir!", "Vous nous quittez déjà!",JOptionPane.INFORMATION_MESSAGE);
				System.exit(1);
				break;
			default:
				err=true;
				iCodeErreur=6;
				break;
			
			}
			if(err)//Affichage des messages d'erreur en fin de parcours de la boucle
			{
				switch(iCodeErreur)
				{
				case 1:
					sSortie="Vous ne pouvez pas ajouter un étudiant, il n'y a pas d'inactifs";
					sTitre="Message d'erreur #"+iCodeErreur;
					break;
				case 2:
					sSortie="Vous ne pouvez pas ajouter un étudiant, le maximum est atteint";
					sTitre="Message d'erreur #"+iCodeErreur;
					break;
				case 3:
					sSortie="Impossible de modifier un étudiant qui n'existe pas";
					sTitre="Message d'erreur #"+iCodeErreur;
					break;
				case 4:
					sSortie="Impossible de supprimer un étudiant qui n'existe pas";
					sTitre="Message d'erreur #"+iCodeErreur;
					break;
				case 5:
					sSortie="Impossible de visualiser un étudiant qui n'existe pas";
					sTitre="Message d'erreur #"+iCodeErreur;
					break;
				case 6:
					sSortie="Une sélection non gérée a été soumise au programme. Merci de recommencer";
					sTitre="Message d'ereur #"+iCodeErreur;
					break;
				default:
					sSortie="Une erreur non gérée s'est produite";
					sTitre="Message d'erreur par défaut";
					break;
				}
				JOptionPane.showMessageDialog(null, sSortie, sTitre, JOptionPane.ERROR_MESSAGE);
				/*Réinitialisaiton des variables*/
				iCodeErreur=0;
				err=false;
				sSortie="";
				sTitre="";
			}
		}
		
	}

}
