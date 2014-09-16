package pkProgLab1EX10;
import javax.swing.JOptionPane;
public class ProgLab1EX10 {

	public static void main(String[] args) 
	{
		int temps, seconde, minute, heure;
		temps=Integer.parseInt(JOptionPane.showInputDialog("Nombre de secondes"));
		heure=(temps-(temps%3600))/3600;
		minute=((temps%3600)-(temps%60))/60;
		seconde=temps%60;
		
		String message="";
		message=temps +"secondes équivaut à ";
		message+=heure+" heures, "+minute+" minutes et "+seconde+"secondes";
		System.out.println(message);

	}

}
