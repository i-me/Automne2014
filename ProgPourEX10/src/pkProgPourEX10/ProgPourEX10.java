package pkProgPourEX10;
import javax.swing.JOptionPane;
import java.lang.Math;
public class ProgPourEX10 {

	public static void main(String[] args) {;
	int iChoix=12,iNbr1=0, iNbr2=0, iNbEssaie=5, iSomme, iReponse, iBReponse=0, iMReponse=0;
	String sMessage="";
	for(boolean i=true;i;)
	{
		iChoix=Integer.parseInt(JOptionPane.showInputDialog("1-Addition\n2-Soustraction"));
		if(iChoix==1||iChoix==2)
		{break;
		
		}
	}
	for(int i=1;i<=3;i++)//Permet de g�n�rer 3 op�rations
	{
		iNbr1=(int)(Math.random()*10);
		iNbr2=(int)(Math.random()*10);
		switch(iChoix)
		{
			case 1://Addition
			{
				iSomme=iNbr1+iNbr2;
				sMessage="Voici l'�nonc� #"+i+" : "+iNbr1+" + "+iNbr2+" = ?\n";
				for(int i2=0;i2<iNbEssaie;i2++)
				{
					iReponse=Integer.parseInt(JOptionPane.showInputDialog(sMessage+"Votre r�ponse? Essaie #"+(i2+1)));
					if(iReponse==iSomme)
					{
						iBReponse++;
						JOptionPane.showMessageDialog(null,"F�licitations, vous avez la bonne r�ponse � l'expression arithm�tique");
						break;
					}
					else
					{
						iMReponse++;
						JOptionPane.showMessageDialog(null,"D�sol�, vous n'avez pas la bonne r�ponse");
					}
				}
				break;
			}
			case 2:
			{
				iSomme=iNbr1-iNbr2;
				sMessage="Voici l'�nonc� #"+i+" : "+iNbr1+" - "+iNbr2+" = ?\n";
				for(int i2=0;i2<iNbEssaie;i2++)
				{
					iReponse=Integer.parseInt(JOptionPane.showInputDialog(sMessage+"Votre r�ponse? Essaie #"+(i2+1)));
					if(iReponse==iSomme)
					{
						iBReponse++;
						JOptionPane.showMessageDialog(null,"F�licitaiton, vous avez la bonne r�ponse � l'expression arithm�tique.");
						break;
					}
					else
					{
						iMReponse++;
						JOptionPane.showMessageDialog(null,"D�sol�, vous n'avez pas la bonne r�ponse.");
					
					}
					
				}
			break;
			}
			default:
			{
				JOptionPane.showMessageDialog(null,"Une erreur inattendue s'est produit");
			}
		}
	}
	sMessage="";
	sMessage="Vous avez "+iBReponse+" r�ponses ainsi que "+iMReponse+" mauvaise r�ponse parmi les 3 expressions g�n�r�es";
	JOptionPane.showMessageDialog(null,sMessage,"R�sultat du d�fi",JOptionPane.WARNING_MESSAGE);
		
		
	}

}
