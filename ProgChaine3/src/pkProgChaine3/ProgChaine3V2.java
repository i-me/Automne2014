package pkProgChaine3;
import javax.swing.JOptionPane;
public class ProgChaine3V2 {

	public static void main(String[] args) 
	{
		int iNbLu=0, iNbPal=0;
		String sSaisie="";
		double dPrcnt=0;
		do
		{
			sSaisie=JOptionPane.showInputDialog("Nombre compris entre 100 et 999, pour sortir inscrire un nombre plus grand que 999");
			if(sSaisie!="")
			{	
				if(Integer.parseInt(sSaisie)<=999&&Integer.parseInt(sSaisie)>=100)
				{
					iNbLu++;
					if(sSaisie.charAt(0)==sSaisie.charAt(2))
					{
						iNbPal++;
					}
						
				}
				else
					break;
			}
			else
				break;
		}while(true);//Je feelais wild. J'ai décidé d'utiliser une do while au lieu d'un while pour le simple plaisir de diversifier mon script=) 
		dPrcnt=(double)(iNbPal*100)/iNbLu;
		System.out.println("Pourcentage palindrome :"+dPrcnt+"%");
	}

}
