package pkProgArray6;
import javax.swing.JOptionPane;
/**
 * Nom: ProgArray6
 * Description: Gestion des réservations de siège dans un avion
 * Nom des classes : JOptionPane
 * Nom et version de l'IDE : Eclipse Luna 4.4.0, JRE 1.8.0-20
 * OS : Windows 7 professionnal
 * Auteur : Olivier Bois
 * Date : Novembre 2014
 * 
 */
public class ProgArray6 {

	public static void main(String[] args) {
		final String EXIGENCE_PROF= "* Nom: ProgArray6\n * Description: Gestion des réservations de siège dans un avion\n * Nom des classes : JOptionPane\n * Nom et version de l'IDE : Eclipse Luna 4.4.0, JRE 1.8.0-20 \n * OS : Windows 7 professionnal\n * Auteur : Olivier Bois\n * Date : Novembre 2014";
		JOptionPane.showMessageDialog(null,  EXIGENCE_PROF, "Exigence professeure", JOptionPane.PLAIN_MESSAGE);
	final int iTAILLEAVION=10;
	final int iSECTIONFUMEUR=5;
	/*
	 * iTailleAvion -> Taille de l'avion en termes de sièges
	 * iSECTIONFUMEUR->Taille de la section ufmeur
	 */
	boolean avion[]=new boolean[iTAILLEAVION];
	/*
	 * avion -> Tableau des booléen, true/false, false -> Libre true -> Occupé
	 */
	String sMenu[]={"Fumeur", "Non Fumeur", "Quitter"}, sOptionOuiNon[]={"Oui", "Non"};
	/*
	 * sMenu -> Menu principal, 
	 * sOptionOuiNon -> Contient le sous-menu d'options
	 */
	String sSortie="", sSaisie="", sTitre="";
	/*
	 * sSortie -> Contient les sorties du programme (à afficher)
	 * sSaisie -> Contient les entrées du programme ( saisies de l'utilisateur)
	 * sTitre -> Contient les titres des fenêtres lorsques nécessaires
	 */
	boolean err=false;
	/*
	 * err -> Sert à la sortie des boucles, détecte les erreurs
	 */
	int iCodeErreur=0,iPositionTravail=-1, iPositionTravailFumeur=-1, iPositionTravailNonFumeur=-1;
	/*
	 * iCodeErreur -> Contient le code de l'erreur qui est arrivé
	 * iPositionTravail = -> Contient la position de travail dans le tableau lors d'un traitement
	 * iPositionTravailFumeur -> Contient la position de travail dans la section fumeur ( la prochaine place libre exemple)
	 * iPositionTravailNonFumeur -> || || || || voir haut || || || ||
	 */
	while(true)//Boucle d'execution du programme. Sauf interruption volontaire, c'est non stop
	{
		for(int i=0;i<iTAILLEAVION;i++)																			//Parcours de l'avion à la recherche d'un siège libre && on enregistre les occurences fumeur//non-fumeur 
		{
			if(!avion[i])																						//Place libre
			{
				if(i<iSECTIONFUMEUR)																			//On enregistre la position libre is c'est un siège fumeur
					iPositionTravailFumeur=i;
				else
					iPositionTravailNonFumeur=i;																//On enregistre la position libre si c'est un siège non fumeur
			}
			if(i==(iTAILLEAVION-1)&&iPositionTravailFumeur==-1&&iPositionTravailNonFumeur==-1)					//Il n'y a aucun siège dispo dans aucune des sections
			{
				err=true;
				iCodeErreur=1;
				avion=new boolean[iTAILLEAVION];
			}
		}
		if(!err)
		{
			sSortie="Choisir quel typde de siège souhaité";
			sTitre="Réservation AirInuit2000";
			sSaisie=String.valueOf(JOptionPane.showOptionDialog(null,sSortie, sTitre, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, sMenu, sMenu[0] ));
			
			
			switch(Integer.parseInt(sSaisie))
			{
			case 0:																								//Fumeur
				iPositionTravail=iPositionTravailFumeur;
				if(iPositionTravailFumeur==-1&&iPositionTravailNonFumeur!=-1)
				{
					sSortie="Aucun siège disponible, souhaitez-vous être replacé dans l'autre section?";
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
					sSortie="Aucun siège disponible, souhaitez-vous être replacé dans l'autre section?";
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
				JOptionPane.showMessageDialog(null, "Un choix non géré a été soumis au programme");
			}
			if(!err)
			{
				avion[iPositionTravail]=true;
				sSortie="Vous avez le siège #"+iPositionTravail;
				sTitre="Assignation de siège";
				JOptionPane.showMessageDialog(null, sSortie, sTitre, JOptionPane.INFORMATION_MESSAGE);
			}
			
			
			/*Réinitialiser les variables utilisées*/
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
			case 2:																								//Déjà assigné
				sTitre="Siège déjà assigné";
				sSortie="Le siège est déjà assigné";
				break;
			case 3:																								//Le client ne veut pas du nouveau vol
				sTitre="Prochains vol";
				sSortie="Le départ du prochains vol est dans 4 heures";
				break;
			case 4:																								//Sortie du programme
				sTitre="Aurevoir";
				sSortie="Aurevoir!";
				System.exit(1);
				break;
				
			default:
				sTitre="Erreur inconnue";
				sSortie="Une erreur non gérée s'est produite";
				break;
			}
			JOptionPane.showMessageDialog(null, sSortie, sTitre, JOptionPane.ERROR_MESSAGE);

			/*Réinitialisation des variables utilisées*/
			iCodeErreur=0;
			err=false;
		}
		/*Réinitialisation des variables utilisées*/
		iPositionTravail=-1;
		iPositionTravailFumeur=-1;
		iPositionTravailNonFumeur=-1;
		sTitre="";
		sSortie="";
		
	}
	}

}
