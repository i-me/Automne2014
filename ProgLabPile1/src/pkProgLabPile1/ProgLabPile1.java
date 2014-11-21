package pkProgLabPile1;
import javax.swing.JOptionPane;
public class ProgLabPile1 {

	public static void main(String[] args) {
	int iTAILLEFILE=3;
	int iQueue=-1, iTete=-1, iChoix=-1;
	String sFile[]=new String[iTAILLEFILE], sElement="", sTitre="", sSortie="";
	
	String sMenu[]={"Ajouter un �l�ment dans une file", "Supprimer un �l�ment dans une file", "Conna�tre l nombre d'�l�ments de l afile", "Visualiser tous les �l�ments de la file", "R�initialis� la file", "Quitter"};

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
				sElement=JOptionPane.showInputDialog("Saisir l'entr�e");
				iQueue+=1;
				if(iTete==-1)
					iTete++;
				sFile[iQueue]=sElement;
				JOptionPane.showMessageDialog(null, "L'�l�ment "+ sElement+" a �t� ajout�");
			}
			else
			{
				err=true;
				iCodeErreur=2;
			}
			break;
		case 1://Supprimer un �l�ment
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
				JOptionPane.showMessageDialog(null, "�l�ment "+sElement+" supprim�");
			}
			break;
		case 2: //Conna�tre le nombre d'�l�ments de la file
			if(iQueue==-1)
			{
				err=true;
				iCodeErreur=3;
			}
			else
			{
				if(iTete==iQueue)
				{
					JOptionPane.showMessageDialog(null, "Il n'y a qu'un �l�ment dans la liste");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Il y a "+((iQueue-iTete)+1)+" �l�ments dans la liste");
				}
			}
			break;
		case 3://Visualiser toues les �l�ments de file
			if(iQueue>=0)
			{
				sSortie="Voici tous les �l�ments de la file: \n";
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
		case 4://R�intialiser la file;
			iQueue=-1;
			iTete=-1;
			JOptionPane.showMessageDialog(null, "La file a �t� r�initialis� correctement");
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
				sSortie="Impossible de d'effectuer l'action sur les �l�ments, la file est vide!";
				break;
			default:
				sTitre="Erreur non g�r�e";
				sSortie="Une erreur non g�r�e s'est produite lors de l'ex�cution du programme";
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
