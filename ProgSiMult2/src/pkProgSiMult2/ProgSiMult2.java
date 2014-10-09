package pkProgSiMult2;
import javax.swing.JOptionPane;
public class ProgSiMult2 {

	public static void main(String[] args) {

		String sNAS, sMessage;
		sNAS=JOptionPane.showInputDialog("Numéro d'assurance Social");
		sMessage="VALIDE";
		int iNbChif=1;
		for(int i=0;i<sNAS.length();i++)
		{
			if(iNbChif==9)
				sMessage="VALIDE";
			else
				sMessage="NON VALIDE";
			if(Character.isDigit(sNAS.charAt(i)))
				iNbChif++;
			if(!((sNAS.charAt(i)=='-'||sNAS.charAt(i)==' '||sNAS.charAt(i)=='/'||Character.isDigit(sNAS.charAt(i)))&&(sNAS.length()==9||sNAS.length()==11)))
			{
				sMessage="NON VALIDE";
			}
			
		}
		JOptionPane.showMessageDialog(null, "Numéro d'assurance sociale "+sMessage);
	}

}
