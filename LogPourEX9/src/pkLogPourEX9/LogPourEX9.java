package pkLogPourEX9;
import javax.swing.JOptionPane;

public class LogPourEX9 {

	public static void main(String[] args) 
	{
		int iNbr1, iNbr2, iPlusPetit, iPlusGrand, iPGCD=0;
		iNbr1=Integer.parseInt(JOptionPane.showInputDialog("Premier nombre"));
		iNbr2=Integer.parseInt(JOptionPane.showInputDialog("Deuxième nombre"));
		iPlusGrand=(iNbr1>=iNbr2)?iNbr1:iNbr2;
		iPlusPetit=(iNbr2<=iNbr1)?iNbr2:iNbr1;
		
		for(int i=1; i<=iPlusPetit; i++)
		{
			if((iPlusPetit%i)==0&&(iPlusGrand%i)==0)
			{
				iPGCD=i;
			}
		}
		System.out.println("Le plus grand commun diviseur est "+iPGCD);
		
	}

}
