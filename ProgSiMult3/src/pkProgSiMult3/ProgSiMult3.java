package pkProgSiMult3;
import javax.swing.JOptionPane;
public class ProgSiMult3 {

	public static void main(String[] args) {
		String sMessage="NON VALIDE", sTel;
		sTel=JOptionPane.showInputDialog("Numéro de téléphone");
		int iPosition=0, iCountSuite=1, iNbSuite=1;
		for(int i=0;i<sTel.length();i++)
		{
			if(sTel.charAt(0)=='('&&sTel.charAt(5)==')'&&sTel.charAt(8)=='-'&&sTel.length()==12)
			{
				iCountSuite++;
				if((iNbSuite==1||iNbSuite==2)&&iCountSuite==3)
				{
					iNbSuite++;//On passe à la seconde série de chiffre
					iCountSuite=0;//On recommence un nouvelle série de chiffre
				}
				else if((iNbSuite==3)&&iCountSuite==4)
				{
					sMessage="VALIDE";
				}
				else
				{}
			}
			else if(sTel.charAt(3)=='-'&&sTel.charAt(7)=='-'&&sTel.length()==11)
			{
				iCountSuite++;
				if((iNbSuite==1||iNbSuite==2)&&iCountSuite==3)
				{
					iNbSuite++;
					iCountSuite=0;
				}
				else if(iNbSuite==3&&iCountSuite==4)
				{
					sMessage="VALIDE";
				}
			}
			else if(sTel.charAt(3)=='-'&&sTel.length()==8)
			{
				if(iNbSuite==1&&iCountSuite==3)
				{	iNbSuite++;
					iCountSuite=0;
				}
				else if(iNbSuite==2&&iCountSuite==4)
				{
					sMessage="VALIDE";
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Numéro de téléphone "+sMessage);
	}

}
