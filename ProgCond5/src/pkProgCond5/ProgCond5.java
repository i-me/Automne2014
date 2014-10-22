package pkProgCond5;
import javax.swing.JOptionPane;

public class ProgCond5 {

	public static void main(String[] args) 
	{
		int iNbEtudiants=0;
		double dPrixBillet=0, dBalance=0, dCoutTraiteur=0;
		String sSortie="Concernant le souper de la rentré pour le sétudiants d'informatique\n";
		iNbEtudiants=Integer.parseInt(JOptionPane.showInputDialog("Nombre d'étudiants"));
		dPrixBillet=Double.parseDouble(JOptionPane.showInputDialog("Prix du billet"));
		dBalance+=iNbEtudiants*dPrixBillet;

		sSortie+="Merci pour les "+iNbEtudiants+" qui ont participés au souper.\n";
		if(iNbEtudiants>12)
		{
			dCoutTraiteur-=(15*iNbEtudiants);
			iNbEtudiants-=12;
			dCoutTraiteur-=(12*iNbEtudiants);
		}
		else
			dCoutTraiteur=(-15*iNbEtudiants);
		sSortie+="Le prix du billet était de "+dPrixBillet+" par étudiant.\n";
		sSortie+="Le total des ventes pour le souper a été de "+ dBalance +".\n";
		dBalance-=dCoutTraiteur;
		if(dCoutTraiteur<0)
		{
			sSortie+="Le comité a donc réalisé une perte de "+ dBalance +" pour le souper. On se reprend\n";
		}
		else
			sSortie+="Le comite a donc réalisé un profit de "+ dBalance +" pour cette belle activité. Félicitations.\n";
		System.out.println(sSortie);
	}

}
