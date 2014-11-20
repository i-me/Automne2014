package pkProgArray3;
import javax.swing.JOptionPane;
import java.text.*;
/**
 * Nom : ProgArray3
 * Description: Gestion des bureaux de vote des �lections municipales M�galoCity
 * Nom classes : JOptionPane, NumberFormat
 * Nom et version de l'IDE : Eclipe Luna 4.4.0, JRE 1.8.0-20
 * OS : Windows 7 professional
 * Auteur : Olivier Bois
 * Date cr�ation : Novembre 2014
 * 
 */
import java.text.*;
public class ProgArray3 {

	public static void main(String[] args) {
		final String EXIGENCE_PROF="\n* Nom : ProgArray3\n* Nom classes : JOptionPane, NumberFormat\n* Nom et version de l'IDE : Eclipe Luna 4.4.0, JRE 1.8.0-20\n* OS : Windows 7 professional\n* Auteur : Olivier Bois\n* Date cr�ation : Novembre 2014\n* ";
		JOptionPane.showMessageDialog(null, EXIGENCE_PROF, "Exigence Prof", JOptionPane.PLAIN_MESSAGE);
		
		NumberFormat prcnt=NumberFormat.getPercentInstance();
		/*
		 * prcnt -> formatage des pourcentages
		 */
		final int NBBUREAUVOTE=5;
		/*
		 * NBBUREAUVOTE -> Nombre de bureau de vote
		 */
		final String CANDIDATS[]={"Monique Lagac�", "Myriam Laposte", "Julien Lafreni�re", "Alex Beaubien", "Jules Lalibert�", "Diane Montplaisir"};
		/*
		 * CANDIDATS -> Nom des candidats � la mairie;
		 */
		int iVote[][], iTotalVote[], iTotal=0, iVoteMax=-1;
		/*
		 * iVote -> Nombre de vote par bureau de vote
		 * iTotalVote ->Nombre total de vote par bureau
		 * iTotal -> Nombre total de vote
		 * iVoteMax -> Contient le nombre de vote max. Initialis� � -1 pour facilit� traitement. 
		 */

		iVote=new int[CANDIDATS.length][NBBUREAUVOTE];													// On initialise le tableau � la bonne taille
		 
		iTotalVote=new int[CANDIDATS.length];
		String sSortie="", sSaisie="";																				
		/*
		 * sSortie -> Sert � la construction de la sortie affichable
		 * sSaisie -> Sert � v�rifier la saisie de l'utilisateur.
		 */
		boolean err=false;
		/*
		 * err -> Sert � d�tecter une erreur dans la boucle et afficher le message d'erreur en cons�quence
		 */
		for(int i=0;i<NBBUREAUVOTE;i++)																	//Lecture des bureaux de vote
		{
			for(int i2=0;i2<CANDIDATS.length;i2++)														//Lecture des candidats
			{
				sSaisie=JOptionPane.showInputDialog(null,"Concernant le bureau de scrutin num�ro "+(i+1)+"\nLe nombre de vote pour le candidat \""+CANDIDATS[i2]+"\" est: \nSAISIR UN ENTIER", "Saisie des votes");
				for(int i3=0;i3<sSaisie.length();i3++)													//V�rifier que c'est un entier saisie
				{
					if(!Character.isDigit(sSaisie.charAt(i3)))
						err=true;
				}
				if(!err)
				{						//	iVote[i2][i]=i2*2;//Pour les tests
					iVote[i2][i]+=Integer.parseInt(sSaisie);
					iTotalVote[i2]+=iVote[i2][i];
					iTotal+=iVote[i2][i];
					iVoteMax=((iVoteMax==-1)||(iVoteMax<iTotalVote[i2]))?iTotalVote[i2]:iVoteMax;
				}
				else
				{
					err=false;																			//Set l'erreur � false pour pouvoir refaire un autre test sans probl�mes
					i2--;																				//On diminue l'it�rateur pour recommencer le test
					JOptionPane.showMessageDialog(null, "Erreur, seul les nombres entiers sont accept�s", "Erreur de saisie du scrutateur", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Merci, vous avez termin� la saisie des votes. Calcul des r�sultats en cours", "M�galo City - Fin de saisie",JOptionPane.INFORMATION_MESSAGE);
		for(int i=0;i<CANDIDATS.length;i++)																//Affichage des candidats
		{
			if(iTotalVote[i]==iVoteMax)																	//Si c'est le gagnant on affichache **Gagnant** � c�t� de son nom
			{
				sSortie+="**CANDIDAT GAGNANT**";
			}
			sSortie+=CANDIDATS[i]+" ("+ iTotalVote[i]+"votes/"+iTotal+" SOIT "+prcnt.format((double)((double)(iTotalVote[i]*100)/iTotal)/100)+" des votes) \n";
			for(int i2=0;i2<NBBUREAUVOTE;i2++)
			{
				sSortie+="|| Bureau #"+(i2+1)+" -> "+ iVote[i][i2]+"\n";
			}
		}
		System.out.println(sSortie);
	}

}
