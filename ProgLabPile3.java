package pkProgLabPile3;
import javax.swing.JOptionPane;
public class ProgLabPile3 {

	public static void main(String[] args) {
	
		//CSTE
		final boolean bDEFAUTERR=true;
		final int iDEFAUTCODEERR=2;
		final int iTAILLEFILE=10;//Longueur Max de la file
		//Création de la file
		int iPositionFile[]=new int[iTAILLEFILE],iTeteFile=-1,iQueueFile=-1, iHeure=0, iMinute=0, iSeconde=0, itAttente=-1;
		String sInfoClients[][]=new String[iTAILLEFILE][3], stMax[]={"","-1"}, stMin[]={"","-1"}, sMenu[]={"Arrivé","Servie","Départ","Stats","Quitter le simulateur"}, sSaisie="",sSaisieNom="", sSaisieHeure="";
		//Variables de stats
		int iNbClients=0;//Nombre total de clients servis
		double dTempsTotalAttente=0;//Contient le temps d'attente total de tous les clients ayant été servis
		//Variables pour les fenêtres d'affichage
		String sTitre="", sSortie="";
		//Variable gestion d'erreur ** DÉCOMMENTER LORSQUE MENUI CONSTRUIT**
		boolean err=bDEFAUTERR;
		int iCodeErreur=iDEFAUTCODEERR;
		
		//On va remplir la table des positions. sInfoClients contient la clé de position relié à iPositionFile. iSommet servira à délimiter les limites de la file. 
		/* une file devrait comporter une tête et une queue. Mais comme lorsqu'un client part il libère sa place, il faut décaller toutes les autres positions. Le prochains client servis est toujours le client 0*/
		for(int i=0;i<iTAILLEFILE;i++)
		{
			iPositionFile[i]=i;
//			for(int i2=0;i2<sInfoClients)
		}
		
		while(true)
		{

			sTitre="Menu principal du simulateur";
			sSortie="Veuillez choisir une option";//Ici devra être la liste des clients et leurs positions
			sSaisie=String.valueOf(JOptionPane.showOptionDialog(null, sSortie, sTitre, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, sMenu, sMenu[0]));
			switch(Integer.parseInt(sSaisie))
			{
			case 0://Arrivée -- AJOUT D'UN CLIENT
				if(iQueueFile<iTAILLEFILE)
				{
					iQueueFile++;
					sSaisieNom=JOptionPane.showInputDialog("Nom du nouveau client dans la file: ");
					err=true;
					/*Transformer sSaisiHeure en sec après minuit*/
					while(err)//tant que l'heure n'est pas valide
					{
						sSaisieHeure=JOptionPane.showInputDialog("Heure d'arrivée du client: (FORMAT 24h->23:59)");
						
						iHeure=Integer.parseInt(sSaisieHeure.substring(0,sSaisieHeure.indexOf(':')));
						iMinute=Integer.parseInt(sSaisieHeure.substring(sSaisieHeure.indexOf(':')+1,sSaisieHeure.length()));
						System.out.println(iHeure+":"+iMinute);
					
						if(iHeure>=0&&iHeure<=24&&iMinute>=0&&iMinute<=59)
						{
							err=false;
							iSeconde=(iHeure*3600)+(iMinute*60);//Calculs des secondes
						}
						if(err)
						{
							JOptionPane.showMessageDialog(null, "L'heure ou les minutes sont invalides", "Erreur du format d'heure", JOptionPane.ERROR_MESSAGE);
						}
					}/*Fin transformation sSaisieHeure en secondes*/
					sInfoClients[iQueueFile][0]=String.valueOf(iQueueFile);
					sInfoClients[iQueueFile][1]=sSaisieNom;
					sInfoClients[iQueueFile][2]=String.valueOf(iSeconde);
					if(iTeteFile==-1)
						iTeteFile++;
					System.out.println(sInfoClients[iQueueFile][0]+"-"+sInfoClients[iQueueFile][1]);
				//Réinitialisaiton des variables
					err=false;
					iCodeErreur=0;
					iSeconde=0;
					iMinute=0;
					iHeure=0;
					sSaisieNom="";
					sSaisieHeure="";
				}
				else
				{
					err=true;
					iCodeErreur=1;
				}
				break;
			case 1://Service
				if(iTeteFile>-1)
				{	
					err=true;
					iCodeErreur=5;
					sSaisieNom=JOptionPane.showInputDialog("Saisir le nom du client à servir: ");
					for(int i=iTeteFile;i<=iQueueFile;i++)
					{
						System.out.println(i+"--"+sInfoClients[i][1]+"--"+sSaisieNom);
						if(sInfoClients[i][1].equals(sSaisieNom))
							{
							iCodeErreur=7;
								if(i==iTeteFile)
								{
									err=false;
									iCodeErreur=0;
								}
							}
					}
					if(!err)
					{System.out.println("ENTREEE");
					err=true;
						/*Transformer sSaisiHeure en sec après minuit*/
						while(err)//tant que l'heure n'est pas valide
						{
							sSaisieHeure=JOptionPane.showInputDialog("Heure de service du client: (FORMAT 24h->23:59)");
							
							iHeure=Integer.parseInt(sSaisieHeure.substring(0,sSaisieHeure.indexOf(':')));
							iMinute=Integer.parseInt(sSaisieHeure.substring(sSaisieHeure.indexOf(':')+1,sSaisieHeure.length()));
							System.out.println(iHeure+":"+iMinute);
						
							if(iHeure>=0&&iHeure<=24&&iMinute>=0&&iMinute<=59)
							{
								err=false;
								iSeconde=(iHeure*3600)+(iMinute*60);//Calculs des secondes
							}
							if(err)
							{
								JOptionPane.showMessageDialog(null, "L'heure ou les minutes sont invalides", "Erreur du format d'heure", JOptionPane.ERROR_MESSAGE);
							}
						}/*Fin transformation sSaisieHeure en secondes*/
						System.out.println(iSeconde+"#"+sInfoClients[iTeteFile][2]);
						if(iSeconde>Integer.parseInt(sInfoClients[iTeteFile][2]))
						{
							itAttente=iSeconde-Integer.parseInt(sInfoClients[iTeteFile][2]);
							if(itAttente>Integer.parseInt(stMax[1])||Integer.parseInt(stMax[1])==-1)
							{
								stMax[0]=sInfoClients[iTeteFile][1];
								stMax[1]=String.valueOf(itAttente);
							}
							if(itAttente<Integer.parseInt(stMin[1])||Integer.parseInt(stMin[1])==-1)
							{
								stMin[0]=sInfoClients[iTeteFile][1];
								stMin[0]=String.valueOf(itAttente);
							}
							dTempsTotalAttente+=itAttente;
							sTitre="Client servis!";
							sSortie="Le client "+sInfoClients[iTeteFile][1]+" a été servis en "+itAttente+" secondes.";
							JOptionPane.showMessageDialog(null, sSortie, sTitre, JOptionPane.INFORMATION_MESSAGE);
							iTeteFile++;
						}
						else
						{
							err=true;
							iCodeErreur=6;
						}
					}
				}
				else
				{
					err=true;
					iCodeErreur=4;
				}
				sTitre="";
				sSortie="";
				iSeconde=0;
				sSaisieNom="";
				sSaisieHeure="";
				iMinute=0;
				iHeure=0;
				break;
			case 2://Quitter de lui même
				if(iTeteFile>-1&&iTeteFile<=iQueueFile)
				{
					sSaisieNom=JOptionPane.showInputDialog("Quel client a quitté? ");
					err=true;
					iCodeErreur=5;
					for(int i=iTeteFile;i<=iQueueFile;i++)
					{
						if(sInfoClients[i][1]==sSaisieNom)
						{
							err=false;
							iCodeErreur=0;
						}
					}
					if(!err)
					{//Comme pas d'erreur, il faut déscendre toutes les occurences d'une et réduire la queue de 1. if(iNoduClientQuiQuitte>iTeteFile)pour s'assurer qu'il n'est pas déjà quitté
						
					}
				}
				else
				{
					err=true;
					iCodeErreur=4;
				}
				break;
			case 3://Statistiques
				break;
			case 4://Quitter le simulateur
				err=true;
				iCodeErreur=2;
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
				case 1://La ligne est pleine
					sTitre="Erreur, la ligne est pleine";
					sSortie="La cafétéria est déjà pleine. Veuillez attendre qu'un client parte avant d'entrer dans la ligne";
					break;
				case 2://Quitter
					JOptionPane.showMessageDialog(null, "Aurevoir", "Aurevoir", JOptionPane.INFORMATION_MESSAGE);
					System.exit(1);
					break;
				case 3://Choix non géré
					sTitre="Erreur, Choix non géré";
					sSortie="Le choix soumis au programme est non géré";
					break;
				case 4://Il n'y a pas de clients en ligne
					sTitre="Erreur, il n'y a pas de clients en ligne";
					sSortie="Aucun client n'est dans la ligne pour être servis. Ils ont tous étés servis";
					break;
				case 5://Le client selectionné n'est pas dans la file
					sTitre="Erreur, le client n'existe pas";
					sSortie="Le client saisie n'est pas dans la file.";
					break;
				case 6://Le client est servis avant d'être entré dans la file
					sTitre="Erreur, le client est servis avant d'être en file";
					sSortie="L'heure d'arrivée du client est plus tard que l'heure du service indiqué. ";
					break;
				case 7://Le client qu'il essaie de passer n'est pas le premier en file
					sTitre="Erreur, le client choisi n'est pas le premier en file";
					sSortie="Le client saisie n'est pas celui ayant la priorité. Il faut respecter l'ordre d'arrivée";
					break;
				default:
					sTitre="Erreur non gérée";
					sSortie="Une erreur non gérée s'est produite";
					break;
				}
				JOptionPane.showMessageDialog(null, sSortie, sTitre, JOptionPane.ERROR_MESSAGE);
				//Réintialisation des variables utilisées
				err=false;
				iCodeErreur=0;
				sTitre="";
				sSortie="";
			}
		}
	}

}
