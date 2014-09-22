package pkLogPourEX3;

public class LogPourEX3 {

	public static void main(String[] args) 
	{
		int iSomme=0;
		for(int i=0;i<100;i++)
		{
			if((i%3)==0)
			{
				iSomme+=i;
			}
		}
		System.out.println("La somme des entiers multiples de 3 plus petits que 100 est de "+iSomme);
	}

}
