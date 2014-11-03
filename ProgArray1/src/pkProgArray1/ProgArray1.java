package pkProgArray1;
import javax.swing.JOptionPane;
public class ProgArray1 {

	public static void main(String[] args) {
		int iNbEmploye[]={20,10,40,50,80}, iNbJMala[]={18,8,10,11,8};
		String sNomEmploye[]={"Benoit", "Alice", "Daniel", "Emile", "Julien"}, sNomEmploye8JMala="", sMessageSortie="", sSaisie;
		double dMoyJMala=0, dMoyJMala10M=0;
		int iNb10JP=0, iNbEmployeMaxJMala=0, iNbEmployeMinJMala=0, iEtendu=0, iSaisie;
		boolean err=false;//Ne sert qu'au moment de parser la saisie pour v�rifier si c'est un nombre ou un code de sortie
		//System.out.println(iNbEmploye.length);
		for(int i=0;i<iNbJMala.length;i++)
		{
			if(iNbJMala[i]>=10)
				iNb10JP++;
			dMoyJMala+=iNbJMala[i];
			if(iNbJMala[i]<10)
				dMoyJMala10M+=iNbJMala[i];
			if(iNbJMala[iNbEmployeMaxJMala]<iNbJMala[i])//Donc le maximum de jour associ� � l'employ� ayant le plus d'absence est plus petit que le jour d'absence de l'employ� actule
				iNbEmployeMaxJMala=i;
			if(iNbJMala[iNbEmployeMinJMala]>iNbJMala[i])
				iNbEmployeMinJMala=i;
			if(iNbJMala[i]==8)
				sNomEmploye8JMala+=" #"+i+" "+sNomEmploye[i];
			
		}
		iEtendu=(iNbJMala[iNbEmployeMaxJMala]-iNbJMala[iNbEmployeMinJMala]);
		dMoyJMala=(dMoyJMala/iNbEmploye.length);
		dMoyJMala10M=(dMoyJMala10M/iNbEmploye.length);
		/*Formatage d'une sortie valide*/
			sMessageSortie+="Le nombre d'employ�s ayant accumul� 10 journ�es de maladie et plus est de :"+ iNb10JP +"\n";
			sMessageSortie+="La moyenne du nombre de journ�es de maladies ccumul�es pour tous les employ�s :"+ dMoyJMala+"\n";
			sMessageSortie+="La moyenne du nombre de journ�es de maladies accumul�es pour les employ�es ayant moins de 10 jours de maladies accumul� :"+ dMoyJMala10M +"\n";
			sMessageSortie+="L'employ� #"+iNbEmployeMaxJMala+" "+ sNomEmploye[iNbEmployeMaxJMala]+" a eu le plus d'absence maladie. (Il faudrait le mettre � pied)\n";
			sMessageSortie+="Les employ�s suivants ont accumul�s 8 jours de cong� maladie "+sNomEmploye8JMala+"\n";
		/*Fin formatage d'une sortie*//*Affichage*/ JOptionPane.showMessageDialog(null, sMessageSortie);
		
		do
		{
			sSaisie=JOptionPane.showInputDialog("Num�ro de l'employ�. Pour quitter, inscrire une lettre.");
			for(int i=0;i<sSaisie.length();i++)
			{
				if(!(Character.isDigit(sSaisie.charAt(0))))//On conserve seulement les entiers positifs (-127, 30.45) seront �limin�s 1.position[0]->'-', 2.position[3]->'.'
				{
					err=true;
					break;
				}
			}
			if(!err)//Il n'y pas de lettres dans la saisie. Donc 
			{
				iSaisie=Integer.parseInt(sSaisie);
				if(iSaisie<sNomEmploye.length)
					JOptionPane.showMessageDialog(null, "L'employ� #"+iSaisie+" "+sNomEmploye[iSaisie]+" fait partie des employ�s, cet employ� a accumul� "+iNbJMala[iSaisie]+" jours de maladie.");
				else
					JOptionPane.showMessageDialog(null, "L'employ� #"+iSaisie+" ne fait pas partie des employ�s");
			}
			else
				JOptionPane.showMessageDialog(null, "Aurevoir!");
		}while(!err);
		
	}

}
