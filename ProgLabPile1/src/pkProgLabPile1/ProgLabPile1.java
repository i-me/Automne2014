package pkProgLabPile1;
import javax.swing.JOptionPane;
public class ProgLabPile1 {

	public static void main(String[] args) {
	int iTAILLEFILE=3;
	int iQueue=-1, iTete=-1, iChoix=-1;
	String sFile[]=new String[iTAILLEFILE], sElement="", sTitre="", sSortie="";
	
	String sMenu[]={"Ajouter un élément dans une file", "Supprimer un élément dans une file", "Connaître l nombre d'éléments de l afile", "Visualiser tous les éléments de la file", "Réinitialisé la file", "Quitter"};

	boolean err=false;
	int iCodeErreur=0;
	while(true)
	{
		iChoix=JOptionPane.showOptionDialog(null, "Choisir parmis les options suivantes", "Menu principal", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, sMenu, sMenu[0]);
		switch(iChoix)
		{
		case 0://Ajouter;
			if(iQueue<(iTAILLEFILE-1))
			{
				sElement=JOptionPane.showInputDialog("Saisir l'entrée");
				iQueue+=1;
				if(iTete==-1)
					iTete++;
				sFile[iQueue]=sElement;
				JOptionPane.showMessageDialog(null, "L'élément "+ sElement+" a été ajouté");
			}
			else
			{
				err=true;
				iCodeErreur=2;
			}
			break;
		case 1://Supprimer un élément
			if(iTete==-1)//La file est vide
			{
				err=true;
				iCodeErreur=3;
			}
			else
			{
				sElement=sFile[iTete];
				iTete++;
				if(iTete>iQueue)
				{
					iTete=-1;
					iQueue=-1;
				}
				JOptionPane.showMessageDialog(null, "Élément "+sElement+" supprimé");
			}
			break;
		case 2: //Connaître le nombre d'éléments de la file
			if(iQueue==-1)
			{
				err=true;
				iCodeErreur=3;
			}
			else
			{
				if(iTete==iQueue)
				{
					JOptionPane.showMessageDialog(null, "Il n'y a qu'un élément dans la liste");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Il y a "+((iQueue-iTete)+1)+" éléments dans la liste");
				}
			}
			break;
		case 3://Visualiser toues les éléments de file
			if(iQueue>=0)
			{
				sSortie="Voici tous les éléments de la file: \n";
				for(int i=iTete;i<=iQueue;i++)
				{
					sSortie+=sFile[i]+", ";
				}
				JOptionPane.showMessageDialog(null, sSortie);
			}
			else
			{
				err=true;
				iCodeErreur=3;
			}
			break;
		case 4://Réintialiser la file;
			iQueue=-1;
			iTete=-1;
			JOptionPane.showMessageDialog(null, "La file a été réinitialisé correctement");
			break;
		case 5://Quitter;
			err=true;
			iCodeErreur=1;
			break;
		}
		if(err)
		{
			switch(iCodeErreur)
			{
			case 1://Quitter
				sTitre="Quitter";
				sSortie="Aurevoir";
				JOptionPane.showMessageDialog(null, sSortie, sTitre, JOptionPane.INFORMATION_MESSAGE);
				System.exit(1);
				break;
			case 2://La file est pleine
				sTitre="File pleine";
				sSortie="Impossible d'effectuer l'action sur la file, la file est pleine!";
				break;
			case 3://La file est vide
				sTitre="File vide";
				sSortie="Impossible de d'effectuer l'action sur les éléments, la file est vide!";
				break;
			default:
				sTitre="Erreur non gérée";
				sSortie="Une erreur non gérée s'est produite lors de l'exécution du programme";
				break;
			}
			JOptionPane.showMessageDialog(null,sSortie, sTitre, JOptionPane.ERROR_MESSAGE);
			sTitre="";
			sSortie="";
			err=false;
			iCodeErreur=0;
		}
	}
	
	}

}
