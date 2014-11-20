package pkJeuDame;
import javax.swing.JOptionPane;
public class JeuDame {
	public static String dessinerDamier(int tYActu[], int tXActu[], int iTailleDamier, String ID[])
	{
		boolean err=false;
		int iCodeErreur=0;
		String sRetour="";
		String sValueTemp="";
		for(int i=0;i<iTailleDamier;i++)//Dessine les lignes
		{
			sRetour+="\n|";
			for(int i2=0;i2<iTailleDamier;i2++)//Dessine les colones
			{	
				if(!((tYActu.length+tXActu.length)==(ID.length*2)))
				{
					iCodeErreur=1;
					err=true;
				}
				if(!err)
				{
					for(int i3=0;i3<tYActu.length;i3++)//On parcours les 2 tableaux, 
					{
						if(tYActu[i3]>iTailleDamier||tXActu[i3]>iTailleDamier)
						{
							iCodeErreur=2;
							err=true;
						}
						if(!err)
						{
							if(tYActu[i3]==i&&tXActu[i3]==i2)//Donc que la position d'une des pi�ces es tcelle de la case qu'on affiche
							{
								sValueTemp=ID[i3];
								break;
							}
							else
								sValueTemp="O";
						}
					}
					sRetour+=sValueTemp;
					sRetour+="|";
				}
				
			}
			//sRetour+="\n";
			
			for(int i2=0;i2<iTailleDamier;i2++)//La ligne inf�rieure
			{
				//sRetour+="_";
			}
			
			
		}
		if(err)
		{
			switch(iCodeErreur)
			{
			case 1://Si il y a plus de pions ou de position que de pions
				sRetour="Une erreur d'ex�cution s'est produite. Il y a plus de positions annonc�es par le programme que de pions";
				break;
			case 2://Si en dehors du damier
				sRetour="Une erreur d'ex�cution s'est produite. La position donn�e par le programme est plus grande que le damier";
				break;
			default:
				sRetour="Une erreur d'ex�cution non g�r�e s'est produite";
				break;
			}
		}
		return(sRetour);
	}
	public static void main(String[] args) {
		int tYActu[], tXActu[];
	    final int iNOMBREPION=2;
		final int iTAILLEDAMIER=10;
		int iPionDeplX=0, iPionDeplY=0, iPionMvmnt=-1;//iPionDepl X & Y -> Taille du d�placement, iPionMvmnt -> Num�ro du pion en mvmnt (pour r�f�rence � tYActu
		
		tYActu=new int[iNOMBREPION];
		tXActu=new int[iNOMBREPION];//position 
		String ID[]={"X","Y"};//Caract�re � afficher pour les pions TAILLE DOIT �TRE = � iNOMBREPION
		
		JOptionPane.showMessageDialog(null, dessinerDamier(tYActu, tXActu, 10, ID));
	}

}
