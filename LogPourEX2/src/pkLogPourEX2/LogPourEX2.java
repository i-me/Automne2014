package pkLogPourEX2;

public class LogPourEX2 {

	public static void main(String[] args) {
	int iSomme=0;
	String sMessage="";
		for(int iI=0;iI<=100;iI++)
		{
			if(iI<=20)
			{
				iSomme+=iI;
				if(iI==20)
				{
					sMessage+="La somme des nombres entiers jusqu'à 20  = "+iSomme;
					iSomme=0;
				}
			}
			else if(iI<=50)
			{
				if((iI%2)==0)//Donc c'est un nombre pair
				{
					iSomme+=iI;
					
				}
				if(iI==50)
				{
					sMessage+="\nLa somme des nombres entiers pairs de 21 à 50 = "+iSomme;
					iSomme=0;
				}
			}
			else
			{
				if((iI%2)!=0)
				{
					iSomme+=iI;
				}
				if(iI==100)
				{
					sMessage+="\nLa somme des nombres entiers impairs de 51 à 100 = "+iSomme;
					iSomme=0;
				}
			}
		}
		System.out.println(sMessage);
	}

}
