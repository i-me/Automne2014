package pkProgChaine3;

public class ProgChaine3V1 {

	public static void main(String[] args) 
	{
		int iNbLu=0,iNbPal=0;
		double dPrcnt=0;
		String sNbLu="";
		for(int i=100;i<=999;i++)
		{
			sNbLu=String.valueOf(i);
			if(sNbLu.charAt(0)==sNbLu.charAt(2))//C'est un palyndrome
			{
				System.out.println(sNbLu);
				iNbPal++;
			}
			iNbLu++;
		}
		dPrcnt=(double)(iNbPal*100)/iNbLu;
		System.out.println("Pourcentage palindrome :"+dPrcnt);
		
	}

}
