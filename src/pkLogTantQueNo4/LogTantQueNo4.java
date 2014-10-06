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
		int iMeilleurScore, iMeilleurScorePredef, iMeilleurScorePerso, iMeilleurScoreSup[]={-1,-1,-1};
		int iNbSaisie;
		
		iNbPartie = 0;
		iMeilleurScore = -1;
		iMeilleurScorePredef = iMeilleurScorePerso  = -1;
		String sLimiteInf ,sLimiteSup, sNbSaisie, sMessage="", sPartMessage;
		String sLimites, sFelicitation="Félicitations, vous avez trouvé le nombre généré", sErreurInf="Le nombre généré est plus petit que ", sErreurSup="Le nombre généré est plus grand que ";
		String sMenu[]={"Prédéfini", "Personnalisé", "Supérieur", "Meilleur Score", "Quitter"};
		String sMenuDescript="Prédéfini : Le nombre généré est compris entre 1 et 10 inclusivement.\n";
		sMenuDescript+="Personnalisé : Les limites inférieure et supérieure du nombre généré sont cohisies par l'utilisateur. \n";
		sMenuDescript+="Supérieur : Trois niveaux de difficulté sont présentés. \n";
		sMenuDescript+="Meilleur Score : Le meilleur score par catégorie, ainsi que le meilleur score de toutes les parties jouées";
		while(true)
		{
			sPartMessage="";
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
					sPartMessage=": soit entre "+iLimiteInf+" et "+iLimiteSup;
					iNiveauFini=0;iNbNiveau=3;
					iNbPartie++;
					break;
				}
				case 3://Meilleur score
				{
					iNiveauFini=1; iNbNiveau=0;//On empêche la boucle du jeu de démarrer
					sMessage="Meilleur Score Global : "+iMeilleurScore;
					sMessage+="\nMeilleur Score Prédéfini : " +iMeilleurScorePredef;
					sMessage+="\nMeilleur Score Personnalisé : "+iMeilleurScorePerso;
					sMessage+="\nMeilleur Score Supérieur Niveau 1 :"+iMeilleurScoreSup[0]+", Niveau 2 :"+iMeilleurScoreSup[1]+", Niveau 3 :"+iMeilleurScoreSup[2];
					JOptionPane.showMessageDialog(null, sMessage, "Meilleur Score", JOptionPane.NO_OPTION);
					break;
				//On va faire afficher le meilleur score
				}
				case 4://quitter
				{
					System.exit(1);
				}
			}
			iNbGen=genNombre(iLimiteInf, iLimiteSup);
			while(iNiveauFini<iNbNiveau)
			{	
				sMessage+="\nTrouvez le nombre qui a été généré entre "+iLimiteInf+" et "+iLimiteSup;
				sNbSaisie=JOptionPane.showInputDialog(null,sMessage+"\n\nVotre essaie: ","Essaie #"+iNbEssaie, JOptionPane.NO_OPTION);
				iNbSaisie=(chiffreOK(sNbSaisie))?Integer.parseInt(sNbSaisie):-1;

				if(iNbSaisie>iNbGen)
				{
					sMessage=sErreurInf+sPartMessage;
					iNbEssaie++;
				}
				else if (iNbSaisie==-1)
				{
					sMessage="La saisie est invalide";
					iNbEssaie++;
				}
				else if (iNbSaisie<iNbGen)
				{
					sMessage=sErreurInf+sPartMessage;
					iNbEssaie++;
				}
				else if(iNbSaisie==iNbGen)
				{
					iNbEssaie++;
					sMessage=sFelicitation+" en "+iNbEssaie+" essaies";
					iLimiteSup+=10;
					/*Partie seulement pour le niveau supérieur*/
					
						if(iNiveauFini==2)
							iLimiteSup+=10;
						if(iNbNiveau==3)
						{
							iMeilleurScoreSup[iNiveauFini]=(iMeilleurScoreSup[iNiveauFini]>iNbEssaie||iMeilleurScoreSup[iNiveauFini]==-1)?iNbEssaie:iMeilleurScoreSup[iNiveauFini];
							iNbGen=genNombre(iLimiteInf, iLimiteSup);
						}
					/*Fin partie pour le niveau supérieur*/
					/*Partie seulement pour le niveau perso*/
						else if(sPartMessage!="")
						{
							iMeilleurScorePerso=(iMeilleurScorePerso>iNbEssaie||iMeilleurScorePerso==-1)?iNbEssaie:iMeilleurScorePerso;
						}
					/*Fin partie pour seulement le niveua perso*/
						else // c'est predef
						{
							iMeilleurScorePredef=(iMeilleurScorePredef>iNbEssaie||iMeilleurScorePredef==-1)?iNbEssaie:iMeilleurScorePredef;
						}
						iMeilleurScore=(iMeilleurScore>iNbEssaie||iMeilleurScore==-1)?iNbEssaie:iMeilleurScore;
					JOptionPane.showMessageDialog(null, sMessage);
					iNbEssaie=0;
					iNiveauFini++;
					
					
				}
				else
				{
					sMessage="Le nombre saisie est invalide";
					iNbEssaie++;
				}

			}
			/*Partie pour les statistiques de fin de jeu*/
			iMeilleurScore=(iMeilleurScore>iNbEssaie)?iNbEssaie:iMeilleurScore;
		/*Fin partie pour les statistiques de fin de jeu*/
		}
	}

}
