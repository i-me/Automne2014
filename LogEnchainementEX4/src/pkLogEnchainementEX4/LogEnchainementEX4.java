package pkLogEnchainementEX4;
import javax.swing.JOptionPane;
import java.text.*;
public class LogEnchainementEX4 {

	public static void main(String[] args) 
	{
		
		int iNbBillet100, iNbBillet50, iNbBillet20, iNbBillet10, iNbBillet5;
		int iNbPiece2, iNbPiece1, iNbPiece025, iNbPiece010, iNbPiece005;
		double dMontantRemis;
		String sMessage,s;
		NumberFormat argent = NumberFormat.getCurrencyInstance();
		
		dMontantRemis=Double.parseDouble(JOptionPane.showInputDialog("Montant à remettre au client"));
		
		sMessage="Remise de "+ argent.format(dMontantRemis);
		
		iNbBillet100=(int)((dMontantRemis-(dMontantRemis%100))/100);
		dMontantRemis-=iNbBillet100*100;
		if(iNbBillet100>0)
		{
			if(iNbBillet100>1)
				s="s";
			else
				s="";
			sMessage+="\n"+iNbBillet100+" billet"+s+" de 100$";
		}
		
		iNbBillet50=(int)((dMontantRemis-(dMontantRemis%50))/50);
		dMontantRemis-=iNbBillet50*50;		
		if(iNbBillet50>0)
		{
			if(iNbBillet50>1)
				s="s";
			else
				s="";
		sMessage+="\n"+iNbBillet50+" billet"+s+" de 50$";
		}
		
		iNbBillet20=(int)((dMontantRemis-(dMontantRemis%20))/20);
		dMontantRemis-=iNbBillet20*20;
		if(iNbBillet20>0)
		{
			if(iNbBillet20>1)
				s="s";
			else
				s="";
		sMessage+="\n"+iNbBillet20+" billet"+s+" de 20$";
		}
		iNbBillet10=(int)((dMontantRemis-(dMontantRemis%10))/10);
		dMontantRemis-=iNbBillet10*10;
		sMessage+="\n"+iNbBillet10+" billet de 10$";
		
		iNbBillet5=(int)((dMontantRemis-(dMontantRemis%5))/5);
		dMontantRemis-=iNbBillet5*5;
		sMessage+="\n"+iNbBillet5+" billet de 5$";
		
		iNbPiece2=(int)((dMontantRemis-(dMontantRemis%2))/2);
		dMontantRemis-=iNbPiece2*2;
		sMessage+="\n"+iNbPiece2+" pièces de monnaie de 2$";
		
		iNbPiece1=(int)((dMontantRemis-(dMontantRemis%1))/1);
		dMontantRemis-=iNbPiece1*1;
		sMessage+="\n"+iNbPiece1+" pièces de monnaie 1$";
		
		iNbPiece025=(int)((dMontantRemis-(dMontantRemis%0.25))/0.25);
		dMontantRemis-=iNbPiece025*0.25;
		sMessage+="\n"+iNbPiece025+" pièces de monnaie 0.25$";
		
		iNbPiece010=(int)((dMontantRemis-(dMontantRemis%0.1))/0.1);
		dMontantRemis-=iNbPiece010*0.1;
		sMessage+="\n"+iNbPiece010+" Pièces de monnaie de 0.1$";
		
		iNbPiece005=(int)((dMontantRemis-(dMontantRemis%0.05))/0.05);
		dMontantRemis-=iNbPiece005*0.05;
		sMessage+="\n"+iNbPiece005+" pièces de monnaie de 0.05$";
		
		
		
		System.out.println(sMessage);
	}

}
