package pkProgLab1EX6;
import javax.swing.JOptionPane;
public class ProgLab1EX6 {

	public static void main(String[] args)
	{
		double celsius;
		celsius=Double.parseDouble(JOptionPane.showInputDialog("Temp�rature en C�"));
		System.out.println("Temp�rature F� :"+((celsius*1.8)+32));
	}

}
