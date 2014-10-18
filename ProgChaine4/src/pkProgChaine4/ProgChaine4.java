package pkProgChaine4;
import java.lang.Math;
public class ProgChaine4 {

	public static void main(String[] args) 
	{
		String sNb="";
		int iChiffre;
		for(int i=1;i<=999;i++)
		{
			iChiffre=0;
			sNb=String.valueOf(i);
			for(int j=0;j<sNb.length();j++)
			{
				iChiffre+=Math.pow(Integer.parseInt(""+sNb.charAt(j)),sNb.length());
			}
			if(iChiffre==Integer.parseInt(sNb))
			{
				System.out.println(sNb+" est un nombre Armstrong");
			}
		}
	}

}
