package pkProgCond3;
import javax.swing.JOptionPane;
public class ProgCond3 {

	public static void main(String[] args) 
	{
		double dNote1=0, dNote2=0, dNote3=0, dNoteMinimum=0;
		dNote1=Double.parseDouble(JOptionPane.showInputDialog("Note du premier examen/25"))*4;//on ram�ne %
		dNote2=Double.parseDouble(JOptionPane.showInputDialog("Note du deuxi�me examen/25"))*4;//on ram�ne %
		dNote3=Double.parseDouble(JOptionPane.showInputDialog("Note des laboratoires/25"))*4;//On ram�ne %
		
		dNoteMinimum=(100-dNote3-dNote2-dNote1);//On ram�ne sur 25
		if(dNoteMimum)
	}

}
