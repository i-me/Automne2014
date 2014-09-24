package pkProgPourEX7;
import javax.swing.JOptionPane;
import java.text.NumberFormat;

public class ProgPourEX7 {

	public static void main(String[] args) {
		double dNote, dSommeNote, dPGNote, dPPNote=-1, dEcartPPPGNote, dMoyenneNote;
		dSommeNote = dNote=dPGNote = dEcartPPPGNote = dMoyenneNote=0;
		NumberFormat prcntg=NumberFormat.getPercentInstance();
		prcntg.setMaximumFractionDigits(2);
		
		for(int i=0;i<=9;i++)
		{
			dNote=Double.parseDouble(JOptionPane.showInputDialog("Note #"+(i+1)));
			
			dSommeNote+=dNote;
			dPGNote=(dPGNote<dNote)?dNote:dPGNote;
			dPPNote=(dPPNote>dNote||dPPNote==-1)?dNote:dPPNote;
		}
		dEcartPPPGNote=dPGNote-dPPNote;
		dMoyenneNote=dSommeNote/10;
		String sMessage="";
		sMessage="La note la plus haute est "+ prcntg.format(dPGNote/100)+", la note la plus basse est de "+prcntg.format(dPPNote/100)+", la moyenne des notes est de "+prcntg.format(dMoyenneNote/100)+". L'écart entre la plus grande note et la plus basse est de "+prcntg.format(dEcartPPPGNote/100);
		System.out.println(sMessage);
	}

}
