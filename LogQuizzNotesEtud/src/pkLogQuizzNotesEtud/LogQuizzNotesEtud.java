package pkLogQuizzNotesEtud;
import javax.swing.JOptionPane;
import java.text.*;
public class LogQuizzNotesEtud {

	public static void main(String[] args) {
		int iNoMatricule, iNbEchec, iNbEtudiants=0, iRepartNoteFinale[]={0,0,0,0};
		iNbEchec=0;
		double dExam1,dExam1Pond, dExam2, dExam2Pond, dTP, dTPPond, dNoteMin, dNoteMax, dMoyenne, dMoyenneGlobale=0;
		dNoteMin = dNoteMax=-1;
		String sMessage="", sRetour="", sRetourPartTwo="";
		NumberFormat prcnt=NumberFormat.getPercentInstance();
		while(true)
		{
			dExam1 = dExam2= dTP= iNoMatricule=0;
			iNbEtudiants++;
			sMessage="Saisissez le numéro de matricule de l'étudiant. ";
			iNoMatricule=Integer.parseInt(JOptionPane.showInputDialog(sMessage));
			sMessage="Saisissez la note de l'examen de mi-session";
			dExam1=Double.parseDouble(JOptionPane.showInputDialog(sMessage));
			dExam1Pond=dExam1*0.25;
			
			sMessage="Saisissez la note de l'examen de fin de session";
			dExam2=Double.parseDouble(JOptionPane.showInputDialog(sMessage));
			dExam2Pond=dExam2*0.35;
			
			sMessage="Saisissez la note des travaux pratiques";
			dTP=Double.parseDouble(JOptionPane.showInputDialog(sMessage));
			dTPPond=dTP*0.40;
			
			dMoyenne=dExam1Pond+dExam2Pond+dTPPond;//Addition des notes pondérées
			sRetour="\nNuméro de matricule: "+iNoMatricule+"\n";
			sRetour+="Note Intra:"+ dExam1 +"      "+dExam1Pond+"/25";
			sRetour+="\nNote finale:"+ dExam2 +"     "+dExam2Pond+"/35 		"+ prcnt.format(dMoyenne/100);
			sRetour+="\nTravaux:"+ dTP+"      "+dTPPond+"/40\n\n";
			System.out.println(sRetour);
			sRetourPartTwo="L'étudiant ayant le numéro de matricule "+iNoMatricule+" a comme note "+prcnt.format(dMoyenne/100)+"\n";
			dNoteMin=(dMoyenne<dNoteMin||dNoteMin==-1)?dMoyenne:dNoteMin;
			dNoteMax=(dMoyenne>dNoteMax||dNoteMax==-1)?dMoyenne:dNoteMax;
			dMoyenneGlobale+=dMoyenne;
			iNbEchec=(dMoyenne<60)?iNbEchec++:iNbEchec;
				if(dMoyenne<=25)
				{iRepartNoteFinale[0]++;}
				else if(dMoyenne>25&&dMoyenne<=50)
				{iRepartNoteFinale[1]++;}
				else if(dMoyenne>50&&dMoyenne<=75)
				{iRepartNoteFinale[2]++;}
				else
				{
				iRepartNoteFinale[3]++;}

			if(iNbEtudiants==5)
				{
				break;}
		}
		dMoyenneGlobale=dMoyenneGlobale/iNbEtudiants;
		System.out.println(sRetourPartTwo);
		System.out.println("\nLe groupe comporte "+iNbEtudiants+" étudiants");
		System.out.println("La moyenne du groupe est de "+prcnt.format(dMoyenneGlobale/100));
		System.out.println("\nLa note la plus haute du groupe est de "+prcnt.format(dNoteMax/100));
		System.out.println("La note la plus basse du groupe est de "+prcnt.format(dNoteMin/100));
		System.out.println("\nLe nombre d'échecs pour le groupe est de "+iNbEchec+" étudiants.");
		System.out.println("\nEntre les notes 0 et 25%, il y a "+iRepartNoteFinale[0]+" étudiants");
		System.out.println("\nEntre les notes 26 et 50%, il y a "+iRepartNoteFinale[1]+" étudiants");
		System.out.println("\nEntre les notes de 51 et 75%, il y a "+iRepartNoteFinale[2]+" étudiants");
		System.out.println("\nEntre les notes de 76 et 100%, il y a "+iRepartNoteFinale[3]+" étudiants");
	}

}
