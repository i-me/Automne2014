package pkProgLabSiMult3;
import javax.swing.JOptionPane;
public class ProgLabSiMult3 {

	public static void main(String[] args) 
	{

		String sTel="", sMessage="NON VALIDE";//sTel est la chaine du numéro, sMessage est la sortie du programme
		sTel=JOptionPane.showInputDialog("Numéro de téléphone");
		int iNbChiffre=1, iNbSuite=1, iLongueurSuite=1, iSuiteOK=0;
		/*iNbChiffre== le nombre de chiffre dans la chaine, 7 ou 10, 
		 * iNbSuite==Le numéro est composé de 3 suites de chiffre {1-->3, 2-->3, 3-->4} [[USAGE DE POSITIONNEMENT]], 
		 * iLongueurSuite== Longueur de la suite, de travail en cours lorsque 3 ou 4 selon iNbSuiet est réinitialisé à 1, 
		 * iSuiteOK== Calcule le nombre de suite ayant passé les tests de validités. Comme il y a 3 suites il faut que le telephone aie 10 chiffres et 3 séries 3,3,4
		 */
		for(int i=0;i<sTel.length();i++)
		{
				/*Adaptons 333-4444 pour être validé par la condition dessous */
				if(sTel.length()==8&&i==0)
				{
					iSuiteOK++;//Donne au script l'indication qu'il a passé avec succès la suite #1, indicatif régional
					iNbChiffre+=3;//Donne au script l'indication qu'il a passé l'indicatif régional avec succès 
				}
				/*Fin adaptation*/
			if(Character.isDigit(sTel.charAt(i)))
			{
//				System.out.println("1 iNbChiffre"+iNbChiffre+" iLongueurSuite"+iLongueurSuite+"iNbSuite"+iNbSuite+"iSuiteOK="+iSuiteOK);// à décommenter si vous voulez connaître parcours du programme
				iNbChiffre++;
				iLongueurSuite++;
			}
			
			if((iNbSuite==1||iNbSuite==2)&&iLongueurSuite==3)
			{
//				System.out.println("2");// à décommenter si vous voulez connaître parcours du programme
				iSuiteOK++;
				iNbSuite++;
				iLongueurSuite=1;
			}
			if((iNbSuite==3)&&iLongueurSuite==4)
			{
//			System.out.println("3");// à décommenter si vous voulez connaître parcours du programme
			iNbSuite++;
				iSuiteOK++;
				iLongueurSuite=1;
			}
			/*
			 * Position--iNbChiffre--String //À noter, il y a un décalage dans la colone des 374-1158, mais redécaller la chaine serait trop de trouble. Ajouter simplement 1 position =)
			 * 0--0-->(-||->1--8-||->0--AUTO
			 * 1--1-->8-||->2--1-||->0--AUTO
			 * 2--2-->1-||->3--9-||->0--AUTO
			 * 3--3-->9-||->3----||->1--3
			 * 4--3-->)-||->4--3-||->2--7
			 * 5--4-->3-||->5--7-||->3--4
			 * 6--5-->7-||->6--4-||->3---
			 * 7--6-->4-||->6----||->4--1
			 * 8--7-->1-||->7--1-||->5--1
			 * 9--8-->1-||->8--1-||->6--5
			 * 10-9-->5-||->9--5-||->7--8
			 * 11-10-->8-||>10-8-||->DÉCALLAGE
			 */
			if(iNbChiffre==10&&iSuiteOK==3&&((sTel.charAt(0)=='('&&sTel.charAt(4)==')'&&sTel.charAt(8)=='-')||(sTel.charAt(3)=='-'&&sTel.charAt(7)=='-')||(sTel.charAt(3)=='-')))
			{
//			System.out.println("4");// à décommenter si vous voulez connaître parcours du programme
				sMessage="VALIDE";
			}
			
		}
		System.out.println("Numéro de téléphone "+sMessage);
	}

}
