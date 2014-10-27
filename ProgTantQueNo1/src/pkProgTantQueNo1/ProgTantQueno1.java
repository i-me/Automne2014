package pkProgTantQueNo1;
import javax.swing.JOptionPane;
public class ProgTantQueno1 {

	public static void main(String[] args) {
		String sMessage="", sSaisie="";
		double dResult=0;
		double dNombre=0, dNombre1=0;;
		int i=0;
		while(true)
		{
			sMessage="Opérations permises : + - / *\n";
			sMessage+="Pour quitter, saisissez Oui";
			sSaisie=JOptionPane.showInputDialog(sMessage).toLowerCase();
			
			if(sSaisie.charAt(0)=='o')//C'est une sortie
				break;
			if(sSaisie.charAt(0))
				
			System.out.println("Le résultat de l'opération " + sSaisie + " est de "+dResult);
			dResult=0;
		}
	}

}
