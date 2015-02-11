package ca.qc.cegeptr.mat1393667.outils;

public class FlipMonnaie {
		private final int pile = 0;
		private final int face = 1;
		private int cote=-1;
		public FlipMonnaie()//Constructeur
		{
			cote=lancer();
		}
		public FlipMonnaie(int iValeurSoumise)//Constructeur param�tr� 
		{
			setFace(iValeurSoumise);
		}
		public int getFace()
		{
			return(cote);
		}
		public void setFace(int iValeur)
		{
			if(iValeur==face || iValeur==pile)
				cote=iValeur;
			else
				cote=lancer();
		}
		public int lancer()//Lancement de la fac
		{
			int iRand=(int)Math.round(Math.random());
			return(iRand);//logiquement, si <0.5, retourne 0, si >=0.5 retourne 1;
		}
		public boolean quelFace()//Sort le c�t� de la pi�ce sous forme boolean
		{
			boolean retour=(cote==face)?true:false;//Si cote == face
			return(retour);
		}
		public String quelFaceFormat()//Sort la valeur de la pi�ce sous forme texte
		{
			String sRetour=(cote==face)?"Face":"Pile";
			return(sRetour);
		}
		public String gagnant()
		{
			String retour=(cote==pile)?"Vous �tes gagnant":"Meilleure chance la prochaine fois";
			return(retour);
		}
		public String toString()
		{
			return("La pi�ce est tomb� du c�t� "+quelFaceFormat());
		}
		
}
