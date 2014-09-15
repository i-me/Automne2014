package pkLogSiMultno1;
import javax.swing.JOptionPane;

public class LogSiMultno1 {

	public static void main(String[] args)
	{
		int noMois = 0, annee=0, jours=0;
		String mois ="", message="";
		boolean bisex=false;
		
		noMois=Integer.parseInt(JOptionPane.showInputDialog("Mois de l'année (Format numérique)"));
		annee=Integer.parseInt(JOptionPane.showInputDialog("Année(YYYY)"));
		
		if((annee%4)==0)
		{
			bisex=true;
			if((annee%100)==0)
			{
				bisex=false;
				if((annee%400)==0)
				{
					bisex=true;
				}
			}
		}
		switch(noMois)
		{
		case 1: mois="Janvier"; jours=31; break;
		case 2: mois="Février"; jours=28; if(bisex){jours=29;};break;
		case 3: mois="Mars"; jours=31;break;
		case 4: mois="Avril"; jours=30;break;
		case 5: mois="Mais"; jours=31;break;
		case 6: mois="Juin"; jours=30;break;
		case 7: mois="Juillet"; jours=31;break;
		case 8: mois="Août"; jours=31;break;
		case 9: mois="Septembre"; jours=30;break;
		case 10: mois="Octobre"; jours=31; break;
		case 11: mois="Novembre"; jours=30; break;
		case 12: mois="Décembre"; jours=31; break;
		default: mois="INDEF.";break;
		}
		message="Il y a "+jours+" jours en "+mois+" "+annee;
		System.out.println(message);
	}

}
