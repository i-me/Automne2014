package pkProgTantQue2;
import javax.swing.JOptionPane;

public class ProgTantQue2 {//Am�liorations possibles : Trim des chiffres apr�s 2 decimals

	public static void main(String[] args) 
	{
		double dPrixProduit, dMontantSSTaxes=0, dMontantTaxable=0, dTotalAchats=0, dTPS=0, dTVQ=0, dMontantTotal=0;
		double dMontantPrix1=0, dMontantPrix2=0, dMontantPrix3=0, dMontantPrix4=0;
		int iTypeProduit, iNombreProduits2=0;
		String sNomProduit, sFacture="IGA DE \nTrois-Rivi�res\n==========================\n", sTaxable;
		
		while(true)//Boucle de saisie, tr�s peu de calculs effectu�s, seulement des additions
		{
			sNomProduit=""; dPrixProduit=0; sTaxable=""; iTypeProduit=0; 
			while(sNomProduit.contentEquals(""))
			{
				sNomProduit=JOptionPane.showInputDialog("Nom du produit: (Q) pour terminer la saisie").toLowerCase();
			}
			if(!(sNomProduit.contentEquals("q")))
			{		
				while(dPrixProduit<=0)
				{
					dPrixProduit=Double.parseDouble(JOptionPane.showInputDialog("Prix du produit: "));
				}
				while(!(sTaxable.contentEquals("t")||sTaxable.contentEquals("n")))
				{
					sTaxable=String.valueOf(JOptionPane.showInputDialog("(T)axable, (N)on-Taxable:").charAt(0)).toLowerCase();
					
				}
				if(sTaxable.contentEquals("t"))//On ajoute � montant taxable
					dMontantTaxable+=dPrixProduit;
				else
					dMontantSSTaxes+=dPrixProduit;
				
				while(iTypeProduit==0)
				{
					iTypeProduit=Integer.parseInt(JOptionPane.showInputDialog("Type du produit \n 1: Viande \n 2: Fruits et l�gumes \n 3: Produit laitier \n 4: Divers (produits autres que 1, 2, ou 3)"));
					switch(iTypeProduit)
					{
					case 1://Viande
						dMontantPrix1+=dPrixProduit;
						break;
					case 2://Fruits et l�gumes
						dMontantPrix2+=dPrixProduit;
						iNombreProduits2++;
						break;
					case 3://Produits laitiers
						dMontantPrix3+=dPrixProduit;
						break;
					case 4://Autre
						dMontantPrix4+=dPrixProduit;
						break;
					default:
						iTypeProduit=0;
						break;
					}
				}
				sFacture+=String.valueOf(sNomProduit.charAt(0)).toUpperCase()+sNomProduit.substring(1)+"    "+dPrixProduit+"    "+sTaxable+"    "+iTypeProduit+"    \n";
			}
			
			else 
				break;
			
		}//fin boucle de saisie. D�but des calculs
		sFacture+="\nMontant total pour chacun des types de produits:\n";
		sFacture+="Viande    "+ dMontantPrix1 +"\n";
		sFacture+="Fruits et l�gumes    "+ dMontantPrix2 +"\n";
		sFacture+="Produits laitier    "+ dMontantPrix3 +"\n";
		sFacture+="Divers    "+ dMontantPrix4 +"\n";
		
		sFacture +="\nMontant non taxable    "+ dMontantSSTaxes;
		sFacture +="\nMontant taxable    "+ dMontantTaxable;
		sFacture+="\nMontant Total des achats    "+ (dMontantTaxable+dMontantSSTaxes);
		
		dTPS=(dMontantTaxable*0.05);
		dTVQ=(dMontantTaxable*0.15);
		sFacture+="\nMontant co�t TPS (5%)    "+ dTPS;
		sFacture+="\nMontant co�t TVQ (15%)    "+ dTVQ;
		
		dMontantTotal=(dMontantTaxable+dMontantSSTaxes)+(dTPS+dTVQ);
		sFacture+="\nMontant total    "+ dMontantTotal;
		sFacture+="\nMoyenne des prix    "+ (dMontantPrix2/iNombreProduits2);
		sFacture+="\n===============================\n Merci de magasiner chez IGA. \n � la prochaine";
		System.out.println(sFacture);
	}

}
