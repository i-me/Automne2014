package pkLogPourEX8;
import javax.swing.JOptionPane;

public class LogPourEX8 {

	public static void main(String[] args) {
	String sNom, sMessage="";
	double dSommeNoteEtu, dNoteFinale=0, dMoyenneEtu, dSommeMoyGlobale=0, dMoyGlobale;
	
	for(int i=0;i<3;i++)
	{
		sNom=JOptionPane.showInputDialog("Nom de l'étudiant");
		sMessage+="\nL'étudiant "+sNom;
		for(int i2=0;i2<3;i2++)
		{
			dNoteFinale+=Double.parseDouble(JOptionPane.showInputDialog("Note de l'examen #"+(i2+1)));
		}
		dNoteFinale+=Double.parseDouble(JOptionPane.showInputDialog("Note des labs"));
		dMoyenneEtu=dNoteFinale/4;
		sMessage+=" a une note finale de "+dNoteFinale+"%";
		sMessage+=", et une note moyenne de "+dMoyenneEtu+" à ses évaluation";
		dSommeMoyGlobale+=dMoyenneEtu;
	}
	dMoyGlobale=dSommeMoyGlobale/3;
	sMessage+="\nLa moyenne de tous les étudiants est de "+dMoyGlobale;
	

	}

}
