package pkProgArray6;
import javax.swing.JOptionPane;
/**
 * Nom: ProgArray6
 * Description: Gestion des r�servations de si�ge dans un avion
 * Nom des classes : JOptionPane
 * Nom et version de l'IDE : Eclipse Luna 4.4.0, JRE 1.8.0-20
 * OS : Windows 7 professionnal
 * Auteur : Olivier Bois
 * Date : Novembre 2014
 * 
 */
public class ProgArray6 {

	public static void main(String[] args) {
		final String EXIGENCE_PROF= "* Nom: ProgArray6\n * Description: Gestion des r�servations de si�ge dans un avion\n * Nom des classes : JOptionPane\n * Nom et version de l'IDE : Eclipse Luna 4.4.0, JRE 1.8.0-20 \n * OS : Windows 7 professionnal\n * Auteur : Olivier Bois\n * Date : Novembre 2014";
		JOptionPane.showMessageDialog(null,  EXIGENCE_PROF, "Exigence professeure", JOptionPane.PLAIN_MESSAGE);
	final int iTAILLEAVION=10;
	final int iSECTIONFUMEUR=5;
	/*
	 * iTailleAvion -> Taille de l'avion en termes de si�ges
	 * iSECTIONFUMEUR->Taille de la section ufmeur
	 */
	boolean avion[]=new boolean[iTAILLEAVION];
	/*
	 * avion -> Tableau des bool�en, true/false, false -> Libre true -> Occup�
	 */
	String sMenu[]={"Fumeur", "Non Fumeur", "Quitter"}, sOptionOuiNon[]={"Oui", "Non"};
	/*
	 * sMenu -> Menu principal, 
	 * sOptionOuiNon -> Contient le sous-menu d'options
	 */
	String sSortie="", sSaisie="", sTitre="";
	/*
	 * sSortie -> Contient les sorties du programme (� afficher)
	 * sSaisie -> Contient les entr�es du programme ( saisies de l'utilisateur)
	 * sTitre -> Contient les titres des fen�tres lorsques n�cessaires
	 */
	boolean err=false;
	/*
	 * err -> Sert � la sortie des boucles, d�tecte les erreurs
	 */
	int iCodeErreur=0,iPositionTravail=-1, iPositionTravailFumeur=-1, iPositionTravailNonFumeur=-1;
	/*
	 * iCodeErreur -> Contient le code de l'erreur qui est arriv�
	 * iPositionTravail = -> Contient la position de travail dans le tableau lors d'un traitement
	 * iPositionTravailFumeur -> Contient la position de travail dans la section fumeur ( la prochaine place libre exemple)
	 * iPositionTravailNonFumeur -> || || ||�|| voir haut || || || ||
	 */
	while(true)//Boucle d'execution du programme. Sauf interruption volontaire, c'est non stop
	{
		for(int i=0;i<iTAILLEAVION;i++)																			//Parcours de l'avion � la recherche d'un si�ge libre && on enregistre les occurences fumeur//non-fumeur 
		{
			if(!avion[i])																						//Place libre
			{
				if(i<iSECTIONFUMEUR)																			//On enregistre la position libre is c'est un si�ge fumeur
					iPositionTravailFumeur=i;
				else
					iPositionTravailNonFumeur=i;																//On enregistre la position libre si c'est un si�ge non fumeur
			}
			if(i==(iTAILLEAVION-1)&&iPositionTravailFumeur==-1&&iPositionTravailNonFumeur==-1)					//Il n'y a aucun si�ge dispo dans aucune des sections
			{
				err=true;
				iCodeErreur=1;
				avion=new boolean[iTAILLEAVION];
			}
		}
		if(!err)
		{
			sSortie="Choisir quel typde de si�ge souhait�";
			sTitre="R�servation AirInuit2000";
			sSaisie=String.valueOf(JOptionPane.showOptionDialog(null,sSortie, sTitre, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, sMenu, sMenu[0] ));
			
			
			switch(Integer.parseInt(sSaisie))
			{
			case 0:																								//Fumeur
				iPositionTravail=iPositionTravailFumeur;
				if(iPositionTravailFumeur==-1&&iPositionTravailNonFumeur!=-1)
				{
					sSortie="Aucun si�ge disponible, souhaitez-vous �tre replac� dans l'autre section?";
					sSaisie=String.valueOf(JOptionPane.showOptionDialog(null, sSortie, sTitre, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, sOptionOuiNon, sOptionOuiNon[0]));
					if(sSaisie.equals("0"))
						iPositionTravail=iPositionTravailNonFumeur;
					else
					{
						err=true;
						iCodeErreur=3;
					}
				}
				break;
			case 1:																								//non-fumeur
				iPositionTravail=iPositionTravailNonFumeur;
				if(iPositionTravailNonFumeur==-1&&iPositionTravailFumeur!=-1)
				{
					sSortie="Aucun si�ge disponible, souhaitez-vous �tre replac� dans l'autre section?";
					sSaisie=String.valueOf(JOptionPane.showOptionDialog(null, sSortie, sTitre, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, sOptionOuiNon, sOptionOuiNon[0]));
					if(sSaisie.equals("0"))
						iPositionTravail=iPositionTravailFumeur;
					else
					{
						err=true;
						iCodeErreur=3;
					}
				}
				break;
			case 2:																								//Quitter
				err=true;
				iCodeErreur=4;
				JOptionPane.showMessageDialog(null, "Aurevoir!", "Aurevoir", JOptionPane.INFORMATION_MESSAGE);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Un choix non g�r� a �t� soumis au programme");
			}
			if(!err)
			{
				avion[iPositionTravail]=true;
				sSortie="Vous avez le si�ge #"+iPositionTravail;
				sTitre="Assignation de si�ge";
				JOptionPane.showMessageDialog(null, sSortie, sTitre, JOptionPane.INFORMATION_MESSAGE);
			}
			
			
			/*R�initialiser les variables utilis�es*/
			sSortie="";
			sTitre="";
			sSaisie="";
		}
		if(err)																									//Gestion des erreurs
		{
			switch (iCodeErreur)
			{
			case 1:																								//L'avion est pleins
				sTitre="Avion Pleins";
				sSortie="Il n'y a plus de places disponibles";
				avion=new boolean[iTAILLEAVION];
				break;
			case 2:																								//D�j� assign�
				sTitre="Si�ge d�j� assign�";
				sSortie="Le si�ge est d�j� assign�";
				break;
			case 3:																								//Le client ne veut pas du nouveau vol
				sTitre="Prochains vol";
				sSortie="Le d�part du prochains vol est dans 4 heures";
				break;
			case 4:																								//Sortie du programme
				sTitre="Aurevoir";
				sSortie="Aurevoir!";
				System.exit(1);
				break;
				
			default:
				sTitre="Erreur inconnue";
				sSortie="Une erreur non g�r�e s'est produite";
				break;
			}
			JOptionPane.showMessageDialog(null, sSortie, sTitre, JOptionPane.ERROR_MESSAGE);

			/*R�initialisation des variables utilis�es*/
			iCodeErreur=0;
			err=false;
		}
		/*R�initialisation des variables utilis�es*/
		iPositionTravail=-1;
		iPositionTravailFumeur=-1;
		iPositionTravailNonFumeur=-1;
		sTitre="";
		sSortie="";
		
	}
	}

}
