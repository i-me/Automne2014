package pkProgCond5;
import javax.swing.JOptionPane;

public class ProgCond5 {

	public static void main(String[] args) 
	{
		int iNbEtudiants=0;
		double dPrixBillet=0, dBalance=0, dCoutTraiteur=0;
		String sSortie="Concernant le souper de la rentr� pour le s�tudiants d'informatique\n";
		iNbEtudiants=Integer.parseInt(JOptionPane.showInputDialog("Nombre d'�tudiants"));
		dPrixBillet=Double.parseDouble(JOptionPane.showInputDialog("Prix du billet"));
		dBalance+=iNbEtudiants*dPrixBillet;

		sSortie+="Merci pour les "+iNbEtudiants+" qui ont particip�s au souper.\n";
		if(iNbEtudiants>12)
		{
			dCoutTraiteur-=(15*iNbEtudiants);
			iNbEtudiants-=12;
			dCoutTraiteur-=(12*iNbEtudiants);
		}
		else
			dCoutTraiteur=(-15*iNbEtudiants);
		sSortie+="Le prix du billet �tait de "+dPrixBillet+" par �tudiant.\n";
		sSortie+="Le total des ventes pour le souper a �t� de "+ dBalance +".\n";
		dBalance-=dCoutTraiteur;
		if(dCoutTraiteur<0)
		{
			sSortie+="Le comit� a donc r�alis� une perte de "+ dBalance +" pour le souper. On se reprend\n";
		}
		else
			sSortie+="Le comite a donc r�alis� un profit de "+ dBalance +" pour cette belle activit�. F�licitations.\n";
		System.out.println(sSortie);
	}

}
