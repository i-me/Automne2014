package pkLogPourEX4;
import javax.swing.JOptionPane;

public class LogPourEX4 {

	public static void main(String[] args) 
	{
		int iSomme=0, iNbr1=0,iNbr2=0, iProduit=0;
		String sMessage="";
		
		for(int i=0;i<5;i++)
		{
			iNbr1=Integer.parseInt(JOptionPane.showInputDialog("Premier nombre à multiplier :"));
			iNbr2=Integer.parseInt(JOptionPane.showInputDialog("Deuxième nombre à multiplier :"));
			
			iProduit=iNbr1*iNbr2;
			sMessage += "\n#"+ (i+1) +" Produit : "+iProduit;
			iSomme+=iProduit;
			iProduit=0;
		}
		sMessage+="\nLa somme des produits est :"+iSomme;
		System.out.println(sMessage);
			

	}

}
