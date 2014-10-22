package pkProgCond3;
import javax.swing.JOptionPane;
public class ProgCond3 {

	public static void main(String[] args) 
	{
		double dNote1=0, dNote2=0, dNote3=0, dNoteMinimum=0;
		dNote1=Double.parseDouble(JOptionPane.showInputDialog("Note du premier examen/25"))*4;//on ramène %
		dNote2=Double.parseDouble(JOptionPane.showInputDialog("Note du deuxième examen/25"))*4;//on ramène %
		dNote3=Double.parseDouble(JOptionPane.showInputDialog("Note des laboratoires/25"))*4;//On ramène %
		
		dNoteMinimum=(100-dNote3-dNote2-dNote1);//On ramène sur 25
		if(dNoteMimum)
	}

}
