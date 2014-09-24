package pkProgPourEX5;
import javax.swing.JOptionPane;
public class ProgPourEX5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int iNbr, iProduit;
		String sMessage;
		iNbr=Integer.parseInt(JOptionPane.showInputDialog("Nombre dont vous voulez la table des multiplications"));
		for(int i=1;i<=9;i++)
		{
			sMessage="";
			iProduit=iNbr*i;
			sMessage=iNbr+" × "+i+" = "+iProduit;
			System.out.println(sMessage);
			
		}
	}

}
