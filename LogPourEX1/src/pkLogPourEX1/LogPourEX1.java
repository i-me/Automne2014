package pkLogPourEX1;
import javax.swing.JOptionPane;

public class LogPourEX1 {

	public static void main(String[] args) 
	{
		double dCelsius=0;
		for(int iTempFrn=-40;iTempFrn<=240;iTempFrn+=20)
		{
			dCelsius=(iTempFrn-32)*5/9;
			System.out.println("Température Fahrenheit : "+iTempFrn+"°F -->Température Celsius : "+dCelsius+"°C");
		}
	}

}
