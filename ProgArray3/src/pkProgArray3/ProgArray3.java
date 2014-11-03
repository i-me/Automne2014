package pkProgArray3;
import javax.swing.JOptionPane;

import java.text.*;
public class ProgArray3 {

	public static void main(String[] args) {
		NumberFormat prcnt=NumberFormat.getPercentInstance();
		
		final int NBBUREAUVOTE=5;
		final String CANDIDATS[]={"Monique Lagacé", "Myriam Laposte", "Julien Lafrenière", "Alex Beaubien", "Jules Laliberté", "Diane Montplaisir"};
		int iVote[][], iTotalVote[], iTotal=0, iVoteMax=-1;


		iVote=new int[CANDIDATS.length][NBBUREAUVOTE];
		iTotalVote=new int[CANDIDATS.length];
		String sSortie="";
		for(int i=0;i<NBBUREAUVOTE;i++)//lecture des bureaux de vote
		{
			for(int i2=0;i2<CANDIDATS.length;i2++)//Lecture des candidats
			{
				iVote[i2][i]=Integer.parseInt(JOptionPane.showInputDialog(null,"Concernant le bureau de scrutin numéro "+(i+1)+", le nombre de vote pour le candidant \""+CANDIDATS[i2]+"\" est:"));
			//	iVote[i2][i]=i2*2;//Pour les tests
				iTotalVote[i2]+=i2*2;
				iTotal+=i2*2;
				iVoteMax=((iVoteMax==-1)||(iVoteMax<iTotalVote[i2]))?iTotalVote[i2]:iVoteMax;
			
			}
		}
		
		for(int i=0;i<CANDIDATS.length;i++)
		{
			if(iTotalVote[i]==iVoteMax)
			{
				sSortie+="**CANDIDAT GAGNANT**";
			}
			sSortie+=CANDIDATS[i]+" ("+ iTotalVote[i]+"votes/"+iTotal+" SOIT "+prcnt.format(((double)(double)(iTotalVote[i]*100)/iTotal)/100)+" des votes) \n";
			for(int i2=0;i2<NBBUREAUVOTE;i2++)
			{
				sSortie+="|| Bureau #"+(i2+1)+" -> "+ iVote[i][i2]+"\n";
			}
		}
		System.out.println(sSortie);
	}

}
