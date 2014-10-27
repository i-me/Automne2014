package pkProgCond1;
import javax.swing.JOptionPane;
public class ProgCond1 {

	public static void main(String[] args) {
		int iNbr1, iNbr2, iChoix, iSortie;
		String sMessage="";
		iChoix=Integer.parseInt(JOptionPane.showInputDialog("1-Addition, 2- Multiplication"));
		iNbr1=Integer.parseInt(JOptionPane.showInputDialog("Nombre 1"));
		iNbr2=Integer.parseInt(JOptionPane.showInputDialog("Nombre 2"));
		if(iChoix==1)
		{
			iSortie=iNbr1+iNbr2;
			sMessage=iNbr1+"+"+iNbr2+"="+iSortie;
		}
		else if(iChoix==2)
		{
			iSortie=iNbr1*iNbr2;
			sMessage=iNbr1+"*"+iNbr2+"="+iSortie;
		}
		else
			JOptionPane.showMessageDialog(null, "Erreur de choix");
		JOptionPane.showMessageDialog(null, "Le résultat:"+sMessage);
			
	}

}
