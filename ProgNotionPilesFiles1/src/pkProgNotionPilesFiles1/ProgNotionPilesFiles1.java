package pkProgNotionPilesFiles1;
import javax.swing.JOptionPane;
public class ProgNotionPilesFiles1 {

	public static void main(String[] args) {
		int iMAXPILE=5;
		int iPile[]=new int[iMAXPILE],iElement,iSommet=-1;
		String sSaisie="",sTitre="", sSortie="", sMenu[]={"Ajouter un �l�ment", "Supprimer un �l�ment","Conna�tre le nombre d'�l�ments", "Visualiser tous les �l�ments de la file", "R�intialis� la file", "Quitter"};
		boolean err=false;
		int iCodeErreur=0;
		while(true)
		{
			sSaisie=String.valueOf(JOptionPane.showOptionDialog(null, "S�lectionnez parmis les options suivantes :", "Menu principal", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,  null, sMenu, sMenu[0]));
			
			switch(Integer.parseInt(sSaisie))//Ouin............ pas envie de d�clarer une autre variable juste pour le menu. honte � moi. Fuck les ressources
			{
			case 0://Ajouter un �l�ment;
			{
				sSaisie=JOptionPane.showInputDialog("Saisir l'�l�ment � ajouter");
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
						JOptionPane.showMessageDialog(null, "L'�l�ment "+iElement+" a bien �t� ajout� � la pile");
					}
					else
					{
						err=true;
						iCodeErreur=2;
					}
				}
				break;
			}
			case 1://Supprimer un �l�lment dans la pile
				if(iSommet>=0)
				{
					iElement=iPile[iSommet];
					iSommet-=1;
					JOptionPane.showMessageDialog(null, "L'�l�ment "+iElement+" a bien �t� supprim� de la pile", "Suppression effectu�e",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					err=true;
					iCodeErreur=4;
				}
				break;
			case 2://Conna�tre le nombre d'�l�ments de la pile
				JOptionPane.showMessageDialog(null,"Il y a "+(iSommet+1)+" �l�ments", "Afficher le nombre d'�l�ments de la liste",JOptionPane.PLAIN_MESSAGE);
				break;
			case 3://Visualiser tous le s�l�ments de la pile
				sSortie="Voici les �l�ments de la pile: \n";
				for(int i=0;i<=iSommet;i++)
				{
					sSortie+=iPile[i]+"-";
				}
				JOptionPane.showMessageDialog(null, sSortie,"Affichage de la pile", JOptionPane.PLAIN_MESSAGE);
				break;
			case 4://R�intialisation de la pile
				iSommet=-1;
				JOptionPane.showMessageDialog(null, "Pile r�initialis�", "R�initialisation effectu�e", JOptionPane.INFORMATION_MESSAGE);
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
					sTitre="Erreur d'ex�cution";
					sSortie="Le nombre entr� n'�tait pas un entier. Merci";
					break;
				case 2:
					sTitre="Erreur d'ex�cution";
					sSortie="La pile est pleine!";
					break;
				case 3:
					sTitre="Erreur d'ex�cution";
					sSortie="Un choix non g�r� a �t� soumis au programme";
					break;
				case 4:
					sTitre="Erreur d'ex�cution";
					sSortie="Impossible de supprimer un �l�ment, la pile est vide!";
					break;
				case 8:
					sTitre="Aurevoir";
					sSortie="Aurevoir";
					JOptionPane.showMessageDialog(null, sSortie, sTitre, JOptionPane.INFORMATION_MESSAGE);
					System.exit(1);
					break;
				default:
					sTitre="Erreur non g�r�e";
					sSortie="Une ereur non g�r�e s'est produite lors de l'ex�ctuion";
					break;
				}
				JOptionPane.showMessageDialog(null, sSortie, sTitre, JOptionPane.ERROR_MESSAGE);
			}
			iCodeErreur=0;
			err=false;
		}
		
	}

}
