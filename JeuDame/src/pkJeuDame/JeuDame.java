package pkJeuDame;
import javax.swing.JOptionPane;
public class JeuDame {
	public static String dessinerDamier(int tYActu[], int tXActu[], int iTailleDamier, String ID[])
	{
		/** Cette fonction re�ois les informations pour positionner le damier correctement. Elle ne fait aucun traitement. Si deux pions sur le m�me emlacement, c'est celui ayant la derni�re 
		 * position dans tYActu( ou ID, les positions sont respect�es), qui sera affich�, l'autre sera �cras� */
		
		boolean err=false;
		int iCodeErreur=0;
		String sRetour="";
		String sValueTemp="";
		for(int i=0;i<iTailleDamier;i++)//Dessine les lignes
		{
			sRetour+="\n|";
			for(int i2=0;i2<iTailleDamier;i2++)//Dessine les colones
			{	
				if(!((tYActu.length+tXActu.length)==(ID.length*2)))
				{
					iCodeErreur=1;
					err=true;
				}
				if(!err)
				{
					for(int i3=0;i3<tYActu.length;i3++)//On parcours les 2 tableaux, 
					{
						if(tYActu[i3]>iTailleDamier||tXActu[i3]>iTailleDamier)
						{
							iCodeErreur=2;
							err=true;
						}
						if(tYActu[i3]<0||tXActu[i3]<0)//C'est un pion � ne pas afficher
							err=true;//On saute par dessus l'affichge du pion mort
						if(!err)
						{
							if(tYActu[i3]==i&&tXActu[i3]==i2)//Donc que la position d'une des pi�ces es tcelle de la case qu'on affiche
							{
								sValueTemp=ID[i3];
								System.out.println(tYActu[0]+"-"+tYActu[1]);
								System.out.println(tXActu[0]+"-"+tYActu[1]);
								break;
							}
							else
								sValueTemp="O";
						}
						if(err&&iCodeErreur==0)//c'�tait un pion mort � ne pas afficher donc pas une erreur
							err=false;
					}
					sRetour+=sValueTemp;
					sRetour+="|";
				}
				
			}
			//sRetour+="\n";
			
			for(int i2=0;i2<iTailleDamier;i2++)//La ligne inf�rieure
			{
				//sRetour+="_";
			}
			
			
		}
		if(err)
		{
			switch(iCodeErreur)
			{
			case 1://Si il y a plus de pions ou de position que de pions
				sRetour="Une erreur d'ex�cution s'est produite. Il y a plus de positions annonc�es par le programme que de pions";
				break;
			case 2://Si en dehors du damier
				sRetour="Une erreur d'ex�cution s'est produite. La position donn�e par le programme est plus grande que le damier";
				break;
			default:
				sRetour="Une erreur d'ex�cution non g�r�e s'est produite";
				break;
			}
		}
		return(sRetour);
	}
	public static void main(String[] args) {
		int tYActu[], tXActu[], iPoint[];
	    final int iNOMBREPION=2;
		final int iTAILLEDAMIER=4;
		int iPionDeplX=0, iPionDeplY=0, iPionMvmnt=-1;//iPionDepl X & Y -> Taille du d�placement, iPionMvmnt -> Num�ro du pion en mvmnt (pour r�f�rence � tYActu
		
		tYActu=new int[iNOMBREPION];
		tYActu[0]=0;
		tYActu[1]=iTAILLEDAMIER-1;
		tXActu=new int[iNOMBREPION];//position
		tXActu[0]=0;
		tXActu[1]=iTAILLEDAMIER-1;
		iPoint=new int[iNOMBREPION];
		
		String ID[]={"X","Y"};//Caract�re � afficher pour les pions TAILLE DOIT �TRE = � iNOMBREPION
		String sMenuDepl[]={""+(char)0x2196,""+(char)0x2197,""+(char)0x2199,""+(char)0x2198, "Quitter"};
		String sSortie="",sTitre="";
		int iSaisie=-1;
		
		//variables Gestion erreur
		boolean err=false;
		int iCodeErreur=0;
		while (true)
		{
			iPionMvmnt++;
			if(iPionMvmnt>iNOMBREPION-1)//On s'assure que le num�ro de joueur est OK compar�  � la taille de nos tableaux
				iPionMvmnt=0;
			sSortie="\nPointage :";
			for(int i2=0;i2<iNOMBREPION;i2++)
			{
				sSortie+=" Joueur #"+(i2+1)+" -> "+ iPoint[i2]+" Points. ";
			}
			iSaisie=JOptionPane.showOptionDialog(null, dessinerDamier(tYActu, tXActu, iTAILLEDAMIER, ID)+"\nVotre mouvement joueur #"+(iPionMvmnt+1)+sSortie, "Fen�tre principale du jeu de dame", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, sMenuDepl, sMenuDepl[0]);
			sSortie="";
			System.out.println(iSaisie);
			switch (iSaisie)
			{
			case 0://En haut � gauche
				iPionDeplX=-1;
				iPionDeplY=-1;
				break;
			case 1://En haut � droite
				iPionDeplX=1;
				iPionDeplY=-1;
				break;
			case 2://En bas � gauche
				iPionDeplX=-1;
				iPionDeplY=1;
				break;
			case 3://En bas � droite
				iPionDeplX=1;
				iPionDeplY=1;
				break;
			case 4://Quitter
				err=true;
				iCodeErreur=1;
				break;
			default://Choix non g�r�
				err=true;
				iCodeErreur=2;
				break;
			
			}
			if(!err)
			{
				err=true;
			
				while(err)
				{
					for(int i=0;i<tXActu.length;i++)//On parcours le tableau de tX, si un pion a le m�me tx et le m�me ty, on va mettre valeur n�gative (bouf�), pis on va additionner tout de usit e la position au d�placement
					{
						if(tXActu[i]==(tXActu[iPionMvmnt]+iPionDeplX)&&tYActu[i]==(tYActu[iPionMvmnt]+iPionDeplY))
						{
					
									tYActu[i]=-1;//On supprime le pion de l'affichage
									tXActu[i]=-1;//On supprime le pion de l'affichage
									iPoint[iPionMvmnt]++; //On ajoute le point au joueur
									tXActu[iPionMvmnt]+=iPionDeplX;
									tYActu[iPionMvmnt]+=iPionDeplY;
									
						}
						else
							err=false;//Si ce n'est pas un pion
							
						
					}
				if((tXActu[iPionMvmnt]+iPionDeplX>(iTAILLEDAMIER-1))||(tXActu[iPionMvmnt]+iPionDeplX<0))
					iPionDeplX=0-(iPionDeplX);
				if((tYActu[iPionMvmnt]+iPionDeplY>(iTAILLEDAMIER-1))||(tYActu[iPionMvmnt]+iPionDeplY<0))
					iPionDeplY=0-(iPionDeplY);
				//On l'a fait rebondir au besoin, on peut donner la nouvelle position au pion. Apr�s on fera le test en boucle pour s'assurer que si y'a un pion, on le saute;
				tXActu[iPionMvmnt]+=iPionDeplX;
				tYActu[iPionMvmnt]+=iPionDeplY;
				}
			}
			if(err)
			{
				switch (iCodeErreur)
				{
				case 1://Quitter
					JOptionPane.showMessageDialog(null, "Aurevoir", "Aurevoir", JOptionPane.PLAIN_MESSAGE);
					System.exit(0);
					break;
				case 2://Choix non g�r�
					sSortie="Un choix non g�r� a �t� soumis au programme";
					sTitre="Erreur";
					break;
				default:
					sSortie="Une erreur non g�r�e s'est produite";
					sTitre="Erreur non g�r�e";
					break;
				}
				JOptionPane.showMessageDialog(null, sSortie, sTitre, JOptionPane.ERROR_MESSAGE);
			}
			/*R�intialisation des variables utilis�es*/
			iCodeErreur=0;
			err=false;
			sSortie="";
			sTitre="";
			iPionDeplX=0;
			iPionDeplY=0;
		}
	}

}
