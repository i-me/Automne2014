package pkProgPourEX1;
import javax.swing.JOptionPane;
import java.lang.Math;

public class ProgPourEX1 {

	public static void main(String[] args) 
	{
		int iNbr;
		String sMessage="";
		for(int i=0;i<5;i++)
		{
			iNbr=Integer.parseInt(JOptionPane.showInputDialog("Votre nombre"));
			if(iNbr>0&&iNbr<=500)
			{
				sMessage+="Le carré du nombre "+iNbr+" égale "+ (int)Math.pow(iNbr, 2);
				sMessage+=" son cube est de "+ (int)Math.pow(iNbr, 3);

				JOptionPane.showMessageDialog(null, sMessage, "Puisse", JOptionPane.INFORMATION_MESSAGE);
				sMessage="";
			}

		}

	}

}
