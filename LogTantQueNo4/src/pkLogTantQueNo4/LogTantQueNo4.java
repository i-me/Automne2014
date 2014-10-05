package pkLogTantQueNo4;
import javax.swing.JOptionPane;
public class LogTantQueNo4 {

	public static boolean  chiffreOK(String sNombre)
	{
		for(int i=0;i<sNombre.length();i++)
		{
			if(!Character.isDigit(sNombre.charAt(i))||(int)sNombre.charAt(i)<0)
			{
				
				return(false);
			}
		}
		return(true);
	}
	public static int genNombre(int iLimiteInf, int iLimiteSup)
	{
		return(1);
	}
	public static void main(String[] args) {
		int iNbEssaie, iNbPartie, iNiveauFini, iNbNiveau, iLimiteInf, iLimiteSup, iChoix, iNbGen;
		int iMeilleurScore, iMeilleurScorePredef, iMeilleurScorePerso, iMeilleurScoreSup;
		iNbPartie = 0;
		iMeilleurScore = iMeilleurScorePredef = iMeilleurScorePerso = iMeilleurScoreSup = 0;
		String sLimiteInf ,sLimiteSup;
		String sLimites, sFelicitation="F�licitations, vous avez trouv� le nombre g�n�r�", sErreurInf="Le nombre g�n�r� est plus petit que ", sErreurSup="Le nombre g�n�r est plus grand que ";
		String sMenu[]={"Pr�d�fini", "Personnalis�", "Sup�rieur", "Meilleur Score", "Quitter"};
		String sMenuDescript="Pr�d�fini : Le nombre g�n�r� est compris entre 1 et 10 inclusivement.\n";
		sMenuDescript+="Personnalis� : Les limites inf�rieure et sup�rieure du nombre g�n�r� sont cohisies par l'utilisateur. \n";
		sMenuDescript+="Sup�rieur : Trois niveaux de difficult� sont pr�sent�s. \n";
		sMenuDescript+="Meilleur Score : Le meilleur score par cat�gorie, ainsi que le meilleur score de toutes les parties jou�es";
		while(true)
		{
			iNiveauFini = iNbEssaie = iNbNiveau = iLimiteInf = iLimiteSup = iChoix =0;
			iChoix=JOptionPane.showOptionDialog(null, sMenuDescript, "Menu du jeu", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE ,  null,  sMenu, sMenu[0]);
			switch (iChoix)
			{
				case 0://Pr�d�f�ini
				{
					iLimiteInf = 1;iLimiteSup=10;
					iNiveauFini=0;iNbNiveau=1;
					iNbPartie++;
					break;
				}
				case 1://Perso
				{
					sLimiteInf=JOptionPane.showInputDialog("Limite Inf�rieure :");
					sLimiteSup=JOptionPane.showInputDialog("Limite Sup :");
					iLimiteInf=(chiffreOK(sLimiteInf))?Integer.parseInt(sLimiteInf):-1;
					iLimiteSup=(chiffreOK(sLimiteSup))?Integer.parseInt(sLimiteSup):-1;
					if((iLimiteInf<iLimiteSup)&&iLimiteInf>=0&&iLimiteSup>=0)
					{
						iNiveauFini=0;iNbNiveau=1;
						iNbPartie++;
					}
					else
						JOptionPane.showMessageDialog(null,"Nombres saisis invalides.", "Erreur", JOptionPane.OK_OPTION);
					break;
				}
				case 2://Sup�rieur
				{
					iLimiteInf=1;
					iLimiteSup=10;
					iNiveauFini=0;iNbNiveau=3;
					iNbPartie++;
				}
				case 3://Meilleur score
				{
					iNiveauFini=1; iNbNiveau=0;//On emp�che la boucle du jeu de d�marrer
				//On va faire afficher le meilleur score
				}
				case 4://quitter
				{
					System.exit(1);
				}
			}
			while(iNiveauFini<iNbNiveau)
			{
				iNbGen=genNombre(iLimiteInf, iLimiteSup);//Cette fonction reste � cr�er
			}
		}
	}

}
