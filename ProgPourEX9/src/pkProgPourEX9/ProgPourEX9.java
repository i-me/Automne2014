package pkProgPourEX9;
import javax.swing.JOptionPane;
public class ProgPourEX9 {

	public static void main(String[] args)
	{
		int iNbr1, iNbr2, iAAdd, iNbAdd,iSomme=0;
		String sMessage="";
		iNbr1=Integer.parseInt(JOptionPane.showInputDialog("Premier nombre"));
		iNbr2=Integer.parseInt(JOptionPane.showInputDialog("Deuxième nombre"));
		
		iNbAdd=(iNbr1<=iNbr2)?iNbr1:iNbr2;
		iAAdd=(iNbr2>=iNbr1)?iNbr2:iNbr1;
		for(int i=1;i<=iNbAdd;i++)
		{
			sMessage+=iAAdd+" ";
			iSomme+=iAAdd;
			if(i!=iNbAdd)
				sMessage+="+ ";
		}
		sMessage+="= "+iSomme;
		System.out.println(sMessage);
		
	}

}
