package pkProgLabSiMult3;
import javax.swing.JOptionPane;
public class ProgLabSiMult3 {

	public static void main(String[] args) 
	{

		String sTel="", sMessage="NON VALIDE";//sTel est la chaine du num�ro, sMessage est la sortie du programme
		sTel=JOptionPane.showInputDialog("Num�ro de t�l�phone");
		int iNbChiffre=1, iNbSuite=1, iLongueurSuite=1, iSuiteOK=0;
		/*iNbChiffre== le nombre de chiffre dans la chaine, 7 ou 10, 
		 * iNbSuite==Le num�ro est compos� de 3 suites de chiffre {1-->3, 2-->3, 3-->4} [[USAGE DE POSITIONNEMENT]], 
		 * iLongueurSuite== Longueur de la suite, de travail en cours lorsque 3 ou 4 selon iNbSuiet est r�initialis� � 1, 
		 * iSuiteOK== Calcule le nombre de suite ayant pass� les tests de validit�s. Comme il y a 3 suites il faut que le telephone aie 10 chiffres et 3 s�ries 3,3,4
		 */
		for(int i=0;i<sTel.length();i++)
		{
				/*Adaptons 333-4444 pour �tre valid� par la condition dessous */
				if(sTel.length()==8&&i==0)
				{
					iSuiteOK++;//Donne au script l'indication qu'il a pass� avec succ�s la suite #1, indicatif r�gional
					iNbChiffre+=3;//Donne au script l'indication qu'il a pass� l'indicatif r�gional avec succ�s 
				}
				/*Fin adaptation*/
			if(Character.isDigit(sTel.charAt(i)))
			{
//				System.out.println("1 iNbChiffre"+iNbChiffre+" iLongueurSuite"+iLongueurSuite+"iNbSuite"+iNbSuite+"iSuiteOK="+iSuiteOK);// � d�commenter si vous voulez conna�tre parcours du programme
				iNbChiffre++;
				iLongueurSuite++;
			}
			
			if((iNbSuite==1||iNbSuite==2)&&iLongueurSuite==3)
			{
//				System.out.println("2");// � d�commenter si vous voulez conna�tre parcours du programme
				iSuiteOK++;
				iNbSuite++;
				iLongueurSuite=1;
			}
			if((iNbSuite==3)&&iLongueurSuite==4)
			{
//			System.out.println("3");// � d�commenter si vous voulez conna�tre parcours du programme
			iNbSuite++;
				iSuiteOK++;
				iLongueurSuite=1;
			}
			/*
			 * Position--iNbChiffre--String //� noter, il y a un d�calage dans la colone des 374-1158, mais red�caller la chaine serait trop de trouble. Ajouter simplement 1 position =)
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
			 * 11-10-->8-||>10-8-||->D�CALLAGE
			 */
			if(iNbChiffre==10&&iSuiteOK==3&&((sTel.charAt(0)=='('&&sTel.charAt(4)==')'&&sTel.charAt(8)=='-')||(sTel.charAt(3)=='-'&&sTel.charAt(7)=='-')||(sTel.charAt(3)=='-')))
			{
//			System.out.println("4");// � d�commenter si vous voulez conna�tre parcours du programme
				sMessage="VALIDE";
			}
			
		}
		System.out.println("Num�ro de t�l�phone "+sMessage);
	}

}
