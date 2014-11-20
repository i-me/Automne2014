package pkProgArray1;
import javax.swing.JOptionPane;

 
/**
 * # Nom:ProgArray1
 * # Description: Analyse des journ�es d'absences des employ�s
 * # Nom des classes utilis�es : JOptionPane;
 * # Nom et version de l'IDE : Eclipse Luna 4.4.0, JRE 1.8.0-20
 * # OS : Windows 7 Professional
 * # Auteur : Olivier Bois
 * # Date : Octobre 2014
 * 
 * **** NOTE : LES D�CIMALES SONT CONSERV�ES PUISQUE SELON LES NORMES DU TRAVAIL LES ABSENCES MALADIES PEUVENT �TRE PRISES EN DEMI JOURN�ES. EX POUR S'OCCUPER 
 * D'UN PROCHE MALADE ****
 */
public class ProgArray1 {

	public static void main(String[] args) {
		final String EXIGENCE_PROF="* # Nom:ProgArray1\n * # Description: Analyse des journ�es d'absences des employ�s\n * # Nom des classes utilis�es : JOptionPane;\n * # Nom et version de l'IDE : Eclipse Luna 4.4.0, JRE 1.8.0-20\n * # OS : Windows 7 Professional\n * # Auteur : Olivier Bois\n * # Date : Octobre 2014\n *\n* **** NOTE : LES D�CIMALES SONT CONSERV�ES PUISQUE SELON LES NORMES DU TRAVAIL LES ABSENCES MALADIES PEUVENT �TRE PRISES EN DEMI JOURN�ES. EX POUR S'OCCUPER D'UN PROCHE MALADE ****";
		JOptionPane.showMessageDialog(null, EXIGENCE_PROF, "ExigenceProf", JOptionPane.PLAIN_MESSAGE);
		final int iNBEMPLOYE[]={20,10,40,50,80}, iNBJMALA[]={18,8,10,11,8};
		/* CONSTANTE
		 * iNBEMPLOYE -> Tableau des num�ros d'employ�s
		 * iNBJMALA -> tableau du nobre de jours des employ�s
		 */
		String sNomEmploye[]={"Benoit", "Alice", "Daniel", "Emile", "Julien"}, sNomEmploye8JMala="", sMessageSortie="", sSaisie;
		/*
		 * sNomEpmploy� -> Tableau des pr�nom d'employ�s
		 * sNomEmploye8JMala -> Contiendra le nom des emloy�s ayant 8 jours de maladie
		 */
		double dMoyJMala=0, dMoyJMala10M=0;
		/*
		 * dMoyJMala ->Contiendra la moyenne des jours de maladie
		 * dMoyJMala10M -> Contiendra la moyenne des jours de maladie des employ�s ayant accumul� moins de 10 jours de maladie
		 */
		int iNb10JP=0, iNbEmployeMaxJMala=0, iNbEmployeMinJMala=0, iEtendu=0, iSaisie, iNbEmployeJMala10M=0;
		/* 
		 * iNb10JPlus -> contienra le nombre d'employ� ayant 10 jours ou plus de maladie
		 * iNbEmployMaxJMala -> Contiendra la nombre d'employ� ayant le max de j maladie
		 * iNbemployMinJMala -> Contiendra le nobre d'employ� ayant le min de j maladie
		 * iEtendu -> Contiendra l'�tendu du nombre de j maladie
		 * iSaisie -> Sert � traiter la saisie
		 * iNbemployJMala10M -> Sert � calculer le nombre d'employ� ayant eu moins de 10 jours de maladie, pour faire la moyenne
		 */
		boolean err=false;	
		//Sert d'indicateur d'erreur. Ne sert qu'au moment de parser la saisie pour v�rifier si c'est un nombre ou un code de sortie
		
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
			if(iNBJMALA[iNbEmployeMaxJMala]<iNBJMALA[i])																				//Donc le maximum de jour associ� � l'employ� ayant le plus d'absence est plus petit que le jour d'absence de l'employ� actule
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
			sMessageSortie+="Le nombre d'employ�s ayant accumul� 10 journ�es de maladie et plus est de :"+ iNb10JP +"\n";
			sMessageSortie+="La moyenne du nombre de journ�es de maladies ccumul�es pour tous les employ�s :"+ dMoyJMala+"\n";
			sMessageSortie+="La moyenne du nombre de journ�es de maladies accumul�es pour les employ�es ayant moins de 10 jours de maladies accumul� :"+ dMoyJMala10M +"\n";
			sMessageSortie+="L'employ� #"+iNBEMPLOYE[iNbEmployeMaxJMala]+" "+ sNomEmploye[iNbEmployeMaxJMala]+" a eu le plus d'absence maladie. (Il faudrait le mettre � pied)\n";
			sMessageSortie+="L'�tendu des jours de maladie est de "+ iEtendu +" jours.\n";
			sMessageSortie+="Les employ�s suivants ont accumul�s 8 jours de cong� maladie "+sNomEmploye8JMala+"\n";
			
		/*Fin formatage d'une sortie*/
		/*Affichage sortie*/ 
		JOptionPane.showMessageDialog(null, sMessageSortie);
		/*fin Affichage sortie */
		do																																//Boucle infini de question programme
		{
			sSaisie=JOptionPane.showInputDialog("Num�ro de l'employ�. Pour quitter, inscrire une lettre.");
			for(int i=0;i<sSaisie.length();i++)
			{
				if(!(Character.isDigit(sSaisie.charAt(0))))																				//On conserve seulement les entiers positifs (-127, 30.45) seront �limin�s 1.position[0]->'-', 2.position[3]->'.'
				{
					err=true;
					break;
				}
			}
			if(!err)																													//Il n'y pas de lettres dans la saisie. Donc 
			{
				err=true;
				iSaisie=Integer.parseInt(sSaisie);
				for(int i=0;i<iNBEMPLOYE.length;i++)																					//On parcours les employes  a la recherche du num�ro d'employ�
				{
					if(iNBEMPLOYE[i]==iSaisie)																							//C'est un employ�
					{
						err=false;
						JOptionPane.showMessageDialog(null, "L'employ� #"+iNBEMPLOYE[i]+" "+sNomEmploye[i]+" fait partie des employ�s, cet employ� a accumul� "+iNBJMALA[i]+" jours de maladie.");
						break;
					}
				}
				if(err)																													//si il n'est pas employ�
				{
					JOptionPane.showMessageDialog(null, "L'employ� #"+iSaisie+" ne fait pas partie des employ�s");
					err=false;
				}
			}
			else
				JOptionPane.showMessageDialog(null, "Aurevoir!");
		}while(!err);
		/* La boule est infini. Seul l'execution du programme peut l'int�rrompre */
		
	}

}
