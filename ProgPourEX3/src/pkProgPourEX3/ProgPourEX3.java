package pkProgPourEX3;
import javax.swing.JOptionPane;

public class ProgPourEX3 {

	public static void main(String[] args) {
		int iProduit;
		String sMessage;
		for (int i=1;i<=10;i++)
		{
			iProduit=1;
			sMessage="La valeur factorielle de "+i+" est: ";
			for(int i2=i;i2!=0;i2--)
			{
				sMessage+=i2;
				iProduit*=i2;
				if(i2!=1)
				{
					sMessage+=" * ";
				}
			}
			sMessage+=" soit "+iProduit;
			System.out.println(sMessage);
		}

	}

}
