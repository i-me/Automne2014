package pkLogSiMultEX6;
import javax.swing.JOptionPane;

public class LogSiMultEX6 {

	public static void main(String[] args) 
	{
		int iNoAbon, iNbVolMax, iDuree, iNbVolActu, iNbVol;
		String sCate, sMessage;
		iNoAbon=Integer.parseInt(JOptionPane.showInputDialog("Num�ro d'abonn�"));
		iNbVolActu=Integer.parseInt(JOptionPane.showInputDialog("Nombre de volume actuellement en location"));
		iNbVol=Integer.parseInt(JOptionPane.showInputDialog("Nombre de volume que le client souhaite louer aujourd'hui"));
		sCate=JOptionPane.showInputDialog("Cat�gorie du membre, (A)dulte, A(I)n� ,(E)nfant").toLowerCase();
		
		switch(sCate.charAt(0))
		{
		case 'a':
			iNbVolMax=10;
			iDuree=20;
			break;
		case 'i':
			iNbVolMax=5;
			iDuree=30;
			break;
		case 'e':
			iNbVolMax=15;
			iDuree=45;
			break;
		default:
			iNbVolMax=0;
			iDuree=0;
		}
		sMessage="L'abonn� no� "+iNoAbon+" ne peut pas emprunter de volumes pour le moment";
		if(iNbVolMax>=(iNbVolActu+iNbVol))
		{
			sMessage="L'abonn� n� "+iNoAbon+" peut emprunter les volumes pour "+iDuree+" jours";
		}
		System.out.println(sMessage);
		
		
		
	}

}
