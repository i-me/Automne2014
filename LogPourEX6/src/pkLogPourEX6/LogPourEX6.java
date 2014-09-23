package pkLogPourEX6;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
public class LogPourEX6 {

	public static void main(String[] args) 
	{
		String sNom, sMeiEtu="";
		double dNote, dMoyNote, dSommeNote=0.0 ,dMeiNote=0.0;
		DecimalFormat prcntg=new DecimalFormat("00.0#%");
		
		for(int i=0; i<5;i++)
		{
			//sNom=JOptionPane.showInputDialog("Nom de l'étudiant:");
			sNom="alphone";
			dNote=Double.parseDouble(JOptionPane.showInputDialog("Note de l'étudiant"));
			dSommeNote+=dNote;
			if(dNote>dMeiNote)//L'étudiant a une meilleure note
			{
				sMeiEtu=sNom;
				dMeiNote=dNote;
			}
			
			
		}
		dMoyNote=dSommeNote/5;
		System.out.println("La note moyenne des étudiants est de "+ prcntg.format(dMoyNote/100));
		System.out.println("C'est "+ sMeiEtu +" qui a eu la meilleure note de la classe avec un résultat de "+ prcntg.format(dMeiNote/100));
		
	}

}
