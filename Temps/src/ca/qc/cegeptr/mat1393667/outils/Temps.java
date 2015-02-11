package ca.qc.cegeptr.mat1393667.outils;

public class Temps {
	private int iTemps[]=new int[3];//[HH:MM:SS]
	
	public Temps()
	{
		iTemps[0]=12;
		iTemps[1]=00;
		iTemps[2]=00;
	}
	public Temps(int iHH, int iMM, int iSS)
	{
		setHeure(iHH);
		setMinute(iMM);
		setSeconde(iSS);
	}
	/*GET*/
	public int getHeure()
	{
		return(iTemps[0]);
	}
	public int getMinute()
	{
		return(iTemps[1]);
	}
	public int getSeconde()
	{
		return(iTemps[2]);
	}
	/*SET*/
	public void setHeure(int iHH)
	{
		
		iTemps[0]=(iHH>=0&&iHH<24)?iHH:00;
	}
	public void setMinute(int iMM)
	{
		iTemps[1]=(iMM>=0&&iMM<60)?iMM:00;
	}
	public void setSeconde(int iSS)
	{
		iTemps[2]=(iSS>=0&&iSS<60)?iSS:00;
	}
	public String tempsFUTC()
	{
		String sRetour="";
		sRetour+=getHeure()+":"+getMinute()+":"+getSeconde();
		return(sRetour);
	}
	public String tempsF12()
	{
		String sRetour="";
		sRetour+=(getHeure()>12)?getHeure()-12:getHeure();
		sRetour+=":H:"+getMinute()+":MM:"+getSeconde()+":SS:";
		sRetour+=(getHeure()>12)?" PM":" AM";
		return(sRetour);
	}
	/*toString*/
	public String toString()
	{
		String sRetour="L'heure au format 24H est "+tempsFUTC();
		sRetour+="\nL'heure au format 12H est "+tempsF12();
		return(sRetour);
	}
}
