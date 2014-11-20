package pkProgArray1;
import javax.swing.JOptionPane;

 
/**
 * # Nom:ProgArray1
 * # Description: Analyse des journées d'absences des employés
 * # Nom des classes utilisées : JOptionPane;
 * # Nom et version de l'IDE : Eclipse Luna 4.4.0, JRE 1.8.0-20
 * # OS : Windows 7 Professional
 * # Auteur : Olivier Bois
 * # Date : Octobre 2014
 * 
 * **** NOTE : LES DÉCIMALES SONT CONSERVÉES PUISQUE SELON LES NORMES DU TRAVAIL LES ABSENCES MALADIES PEUVENT ÊTRE PRISES EN DEMI JOURNÉES. EX POUR S'OCCUPER 
 * D'UN PROCHE MALADE ****
 */
public class ProgArray1 {

	public static void main(String[] args) {
		final String EXIGENCE_PROF="* # Nom:ProgArray1\n * # Description: Analyse des journées d'absences des employés\n * # Nom des classes utilisées : JOptionPane;\n * # Nom et version de l'IDE : Eclipse Luna 4.4.0, JRE 1.8.0-20\n * # OS : Windows 7 Professional\n * # Auteur : Olivier Bois\n * # Date : Octobre 2014\n *\n* **** NOTE : LES DÉCIMALES SONT CONSERVÉES PUISQUE SELON LES NORMES DU TRAVAIL LES ABSENCES MALADIES PEUVENT ÊTRE PRISES EN DEMI JOURNÉES. EX POUR S'OCCUPER D'UN PROCHE MALADE ****";
		JOptionPane.showMessageDialog(null, EXIGENCE_PROF, "ExigenceProf", JOptionPane.PLAIN_MESSAGE);
		final int iNBEMPLOYE[]={20,10,40,50,80}, iNBJMALA[]={18,8,10,11,8};
		/* CONSTANTE
		 * iNBEMPLOYE -> Tableau des numéros d'employés
		 * iNBJMALA -> tableau du nobre de jours des employés
		 */
		String sNomEmploye[]={"Benoit", "Alice", "Daniel", "Emile", "Julien"}, sNomEmploye8JMala="", sMessageSortie="", sSaisie;
		/*
		 * sNomEpmployé -> Tableau des prénom d'employés
		 * sNomEmploye8JMala -> Contiendra le nom des emloyés ayant 8 jours de maladie
		 */
		double dMoyJMala=0, dMoyJMala10M=0;
		/*
		 * dMoyJMala ->Contiendra la moyenne des jours de maladie
		 * dMoyJMala10M -> Contiendra la moyenne des jours de maladie des employés ayant accumulé moins de 10 jours de maladie
		 */
		int iNb10JP=0, iNbEmployeMaxJMala=0, iNbEmployeMinJMala=0, iEtendu=0, iSaisie, iNbEmployeJMala10M=0;
		/* 
		 * iNb10JPlus -> contienra le nombre d'employé ayant 10 jours ou plus de maladie
		 * iNbEmployMaxJMala -> Contiendra la nombre d'employé ayant le max de j maladie
		 * iNbemployMinJMala -> Contiendra le nobre d'employé ayant le min de j maladie
		 * iEtendu -> Contiendra l'étendu du nombre de j maladie
		 * iSaisie -> Sert à traiter la saisie
		 * iNbemployJMala10M -> Sert à calculer le nombre d'employé ayant eu moins de 10 jours de maladie, pour faire la moyenne
		 */
		boolean err=false;	
		//Sert d'indicateur d'erreur. Ne sert qu'au moment de parser la saisie pour vérifier si c'est un nombre ou un code de sortie
		
		for(int i=0;i<iNBJMALA.length;i++)
		{
			if(iNBJMALA[i]>=10)
				iNb10JP++;
			dMoyJMala+=iNBJMALA[i];
			if(iNBJMALA[i]<10)
			{
				dMoyJMala10M+=iNBJMALA[i];
				iNbEmployeJMala10M++;
			}
			if(iNBJMALA[iNbEmployeMaxJMala]<iNBJMALA[i])																				//Donc le maximum de jour associé à l'employé ayant le plus d'absence est plus petit que le jour d'absence de l'employé actule
				iNbEmployeMaxJMala=i;
			if(iNBJMALA[iNbEmployeMinJMala]>iNBJMALA[i])
				iNbEmployeMinJMala=i;
			if(iNBJMALA[i]==8)
				sNomEmploye8JMala+=" #"+iNBEMPLOYE[i]+" "+sNomEmploye[i];
			
		}
		iEtendu=(iNBJMALA[iNbEmployeMaxJMala]-iNBJMALA[iNbEmployeMinJMala]);
		dMoyJMala=(dMoyJMala/iNBEMPLOYE.length);
		dMoyJMala10M=(dMoyJMala10M/iNbEmployeJMala10M);
		/*Formatage d'une sortie valide*/
			sMessageSortie+="Le nombre d'employés ayant accumulé 10 journées de maladie et plus est de :"+ iNb10JP +"\n";
			sMessageSortie+="La moyenne du nombre de journées de maladies ccumulées pour tous les employés :"+ dMoyJMala+"\n";
			sMessageSortie+="La moyenne du nombre de journées de maladies accumulées pour les employées ayant moins de 10 jours de maladies accumulé :"+ dMoyJMala10M +"\n";
			sMessageSortie+="L'employé #"+iNBEMPLOYE[iNbEmployeMaxJMala]+" "+ sNomEmploye[iNbEmployeMaxJMala]+" a eu le plus d'absence maladie. (Il faudrait le mettre à pied)\n";
			sMessageSortie+="L'étendu des jours de maladie est de "+ iEtendu +" jours.\n";
			sMessageSortie+="Les employés suivants ont accumulés 8 jours de congé maladie "+sNomEmploye8JMala+"\n";
			
		/*Fin formatage d'une sortie*/
		/*Affichage sortie*/ 
		JOptionPane.showMessageDialog(null, sMessageSortie);
		/*fin Affichage sortie */
		do																																//Boucle infini de question programme
		{
			sSaisie=JOptionPane.showInputDialog("Numéro de l'employé. Pour quitter, inscrire une lettre.");
			for(int i=0;i<sSaisie.length();i++)
			{
				if(!(Character.isDigit(sSaisie.charAt(0))))																				//On conserve seulement les entiers positifs (-127, 30.45) seront éliminés 1.position[0]->'-', 2.position[3]->'.'
				{
					err=true;
					break;
				}
			}
			if(!err)																													//Il n'y pas de lettres dans la saisie. Donc 
			{
				err=true;
				iSaisie=Integer.parseInt(sSaisie);
				for(int i=0;i<iNBEMPLOYE.length;i++)																					//On parcours les employes  a la recherche du numéro d'employé
				{
					if(iNBEMPLOYE[i]==iSaisie)																							//C'est un employé
					{
						err=false;
						JOptionPane.showMessageDialog(null, "L'employé #"+iNBEMPLOYE[i]+" "+sNomEmploye[i]+" fait partie des employés, cet employé a accumulé "+iNBJMALA[i]+" jours de maladie.");
						break;
					}
				}
				if(err)																													//si il n'est pas employé
				{
					JOptionPane.showMessageDialog(null, "L'employé #"+iSaisie+" ne fait pas partie des employés");
					err=false;
				}
			}
			else
				JOptionPane.showMessageDialog(null, "Aurevoir!");
		}while(!err);
		/* La boule est infini. Seul l'execution du programme peut l'intérrompre */
		
	}

}
