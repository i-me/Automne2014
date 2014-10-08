package pkProgTantQueNo1;
import javax.swing.JOptionPane;
public class ProgTantQueno1 {

	public static void main(String[] args) {
		String sMessage="", sSaisie="";
		double dResult=0;
		double dNombre=0;
		int i=0;
		while(true)
		{
			sMessage="Opérations permises : + - / *\n";
			sMessage+="Pour quitter, saisissez Oui";
			sSaisie=JOptionPane.showInputDialog(sMessage).toLowerCase();

			if(sSaisie.charAt(0)=='o')//Quit
				break;
			
					switch(sSaisie.charAt(0))
					{
						case '+':
						{
							dResult+=dNombre;
							break;
						}
						case '-':
						{
							dResult-=Double.parseDouble(sNombreTempo);
							break;
						}
						case '*':
						{
							dResult*=Double.parseDouble(sNombreTempo);
							break;
						}
						case '/':
						{
							if(sNombreTempo!="0")
							{
								dResult/=Double.parseDouble(sNombreTempo);
							}
							else
								JOptionPane.showMessageDialog(null, "Division par zéro impossible");
							break;
						}
						case '=':
						{
							break;
						}
						default:
						{
							dNombre=Double.parseDouble(sSaisie);
						}
						if(i==0)
							dResult=dNombre;
						i++;
					}
					
				
			System.out.println("Le résultat de l'opération " + sSaisie + " est de "+dResult);
			dResult=0;
		}
	}

}
