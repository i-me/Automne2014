package pkProgPourEX6;

public class ProgPourEX6 {

	public static void main(String[] args) {
		int iProduit=1, iSomme=0;
		for(int i=1; i<=10;i++)
		{
			if(i%2==0)
			{
				iProduit*=i;
			}
			else
				iSomme+=i;
		}
		System.out.println("La somme des nombres impairs est de "+iSomme+", le produit des nombres pairs est de "+iProduit);
		

	}

}
