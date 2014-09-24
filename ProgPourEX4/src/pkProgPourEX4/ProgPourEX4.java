package pkProgPourEX4;

public class ProgPourEX4 {

	public static void main(String[] args) 
	{
		int iNbr=1, iProduit;
		String sMessage;
		for(int i=1;i<=5;i++)
		{
			sMessage="";
			for(int i2=1;i2<=5;i2++)
			{
				iProduit=i*i2;
				sMessage+=iNbr+" × "+i2+" = "+iProduit+"  ***   ";
			}
			System.out.println(sMessage);
			
		}

	}

}
