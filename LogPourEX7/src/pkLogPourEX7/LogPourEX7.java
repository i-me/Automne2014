package pkLogPourEX7;
import javax.swing.JOptionPane;

public class LogPourEX7 {

	public static void main(String[] args) 
	{
		int iNbrEntiers;
		int iPlusPNbr=0, iNbrSaisi = 0;
		iNbrEntiers=Integer.parseInt(JOptionPane.showInputDialog("Combien de nombre souhaitez-vous entrer"));
		for(int i=0;i<iNbrEntiers;i++)
		{
			iNbrSaisi=Integer.parseInt(JOptionPane.showInputDialog("Nombre #"+(i+1)));
			if (i==0)
				iPlusPNbr=iNbrSaisi;
			if(iNbrSaisi<iPlusPNbr)
			{
				iPlusPNbr=iNbrSaisi;
			}
		}
		System.out.println("Le plus petit nombre saisis est "+iPlusPNbr);
		
	}

}
