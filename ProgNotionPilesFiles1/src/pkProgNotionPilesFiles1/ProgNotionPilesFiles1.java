package pkProgNotionPilesFiles1;
import javax.swing.JOptionPane;
public class ProgNotionPilesFiles1 {

	public static void main(String[] args) {
		int iMAXPILE=5;
		int iPile[]=new int[iMAXPILE],iElement,iSommet=-1;
		String sSaisie="",sTitre="", sSortie="", sMenu[]={"Ajouter un élément", "Supprimer un élément","Connaître le nombre d'éléments", "Visualiser tous les éléments de la file", "Réintialisé la file", "Quitter"};
		boolean err=false;
		int iCodeErreur=0;
		while(true)
		{
			sSaisie=String.valueOf(JOptionPane.showOptionDialog(null, "Sélectionnez parmis les options suivantes :", "Menu principal", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,  null, sMenu, sMenu[0]));
			
			switch(Integer.parseInt(sSaisie))//Ouin............ pas envie de déclarer une autre variable juste pour le menu. honte à moi. Fuck les ressources
			{
			case 0://Ajouter un élément;
			{
				sSaisie=JOptionPane.showInputDialog("Saisir l'élément à ajouter");
				for(int i=0;i<sSaisie.length();i++)
				{
					if(!(Character.isDigit(sSaisie.charAt(i))))
					{
						err=true;
						iCodeErreur=1;
						break;
					}
				}
				if(!err)//Pas d'erreur, on poursuit
				{
					iElement=Integer.parseInt(sSaisie);
					if(iSommet<iMAXPILE)
					{
						iSommet+=1;
						iPile[iSommet]=iElement;
						JOptionPane.showMessageDialog(null, "L'élément "+iElement+" a bien été ajouté à la pile");
					}
					else
					{
						err=true;
						iCodeErreur=2;
					}
				}
				break;
			}
			case 1://Supprimer un élélment dans la pile
				if(iSommet>=0)
				{
					iElement=iPile[iSommet];
					iSommet-=1;
					JOptionPane.showMessageDialog(null, "L'élément "+iElement+" a bien été supprimé de la pile", "Suppression effectuée",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					err=true;
					iCodeErreur=4;
				}
				break;
			case 2://Connaître le nombre d'éléments de la pile
				JOptionPane.showMessageDialog(null,"Il y a "+(iSommet+1)+" éléments", "Afficher le nombre d'éléments de la liste",JOptionPane.PLAIN_MESSAGE);
				break;
			case 3://Visualiser tous le séléments de la pile
				sSortie="Voici les éléments de la pile: \n";
				for(int i=0;i<=iSommet;i++)
				{
					sSortie+=iPile[i]+"-";
				}
				JOptionPane.showMessageDialog(null, sSortie,"Affichage de la pile", JOptionPane.PLAIN_MESSAGE);
				break;
			case 4://Réintialisation de la pile
				iSommet=-1;
				JOptionPane.showMessageDialog(null, "Pile réinitialisé", "Réinitialisation effectuée", JOptionPane.INFORMATION_MESSAGE);
				break;
			case 5://Quitter
				err=true;
				iCodeErreur=8;
				break;
			default:
				err=true;
				iCodeErreur=3;
				break;
			}
			if(err)
			{
				switch(iCodeErreur)
				{
				case 1:
					sTitre="Erreur d'exécution";
					sSortie="Le nombre entré n'était pas un entier. Merci";
					break;
				case 2:
					sTitre="Erreur d'exécution";
					sSortie="La pile est pleine!";
					break;
				case 3:
					sTitre="Erreur d'exécution";
					sSortie="Un choix non géré a été soumis au programme";
					break;
				case 4:
					sTitre="Erreur d'exécution";
					sSortie="Impossible de supprimer un élément, la pile est vide!";
					break;
				case 8:
					sTitre="Aurevoir";
					sSortie="Aurevoir";
					JOptionPane.showMessageDialog(null, sSortie, sTitre, JOptionPane.INFORMATION_MESSAGE);
					System.exit(1);
					break;
				default:
					sTitre="Erreur non gérée";
					sSortie="Une ereur non gérée s'est produite lors de l'exéctuion";
					break;
				}
				JOptionPane.showMessageDialog(null, sSortie, sTitre, JOptionPane.ERROR_MESSAGE);
			}
			iCodeErreur=0;
			err=false;
		}
		
	}

}
