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
		String sLimites, sFelicitation="Félicitations, vous avez trouvé le nombre généré", sErreurInf="Le nombre généré est plus petit que ", sErreurSup="Le nombre génér est plus grand que ";
		String sMenu[]={"Prédéfini", "Personnalisé", "Supérieur", "Meilleur Score", "Quitter"};
		String sMenuDescript="Prédéfini : Le nombre généré est compris entre 1 et 10 inclusivement.\n";
		sMenuDescript+="Personnalisé : Les limites inférieure et supérieure du nombre généré sont cohisies par l'utilisateur. \n";
		sMenuDescript+="Supérieur : Trois niveaux de difficulté sont présentés. \n";
		sMenuDescript+="Meilleur Score : Le meilleur score par catégorie, ainsi que le meilleur score de toutes les parties jouées";
		while(true)
		{
			iNiveauFini = iNbEssaie = iNbNiveau = iLimiteInf = iLimiteSup = iChoix =0;
			iChoix=JOptionPane.showOptionDialog(null, sMenuDescript, "Menu du jeu", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE ,  null,  sMenu, sMenu[0]);
			switch (iChoix)
			{
				case 0://Prédéféini
				{
					iLimiteInf = 1;iLimiteSup=10;
					iNiveauFini=0;iNbNiveau=1;
					iNbPartie++;
					break;
				}
				case 1://Perso
				{
					sLimiteInf=JOptionPane.showInputDialog("Limite Inférieure :");
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
				case 2://Supérieur
				{
					iLimiteInf=1;
					iLimiteSup=10;
					iNiveauFini=0;iNbNiveau=3;
					iNbPartie++;
				}
				case 3://Meilleur score
				{
					iNiveauFini=1; iNbNiveau=0;//On empêche la boucle du jeu de démarrer
				//On va faire afficher le meilleur score
				}
				case 4://quitter
				{
					System.exit(1);
				}
			}
			while(iNiveauFini<iNbNiveau)
			{
				iNbGen=genNombre(iLimiteInf, iLimiteSup);//Cette fonction reste à créer
			}
		}
	}

}
