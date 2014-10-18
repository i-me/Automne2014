package pkProgChaine2;
import java.lang.Math;;
public class ProgChaine2 {

	public static void main(String[] args) 
	{
		int iAlea, iDiffDizaine=0, iSommeSerie2, iPositionSerie1, iPositionSerie2;
		String sSerie1, sProduitSerie1, sSommeProduitSerie1, sSerie2, sNAS;
		/*C'est ici que on devra insérer une boucle de génération jusqu'à 5 NAS valide */
		for(int j=0;j<5;j++)
		{
			sSerie1="";
			sProduitSerie1="0";
			sSommeProduitSerie1="0";
			sNAS="";
			for(int i=0;i<4;i++)//On genere une suite 
			{
				sSerie1+=String.valueOf((int)(Math.random()*10));	
			}
			sProduitSerie1=String.valueOf(Integer.parseInt(sSerie1)*2);//OK;
			while(sProduitSerie1.length()<5)//On rajoute 2 zéros pour ?? --> Une note manuscrite sur mon cahier des charges indique que le produit doit avoir 5 caractères 
			{
				sProduitSerie1="0"+sProduitSerie1;
			}
			for(int i=0;i<sProduitSerie1.length();i++)//On aditionne les caractères du produit pour obtenir la somme du produite de la première série
			{
				sSommeProduitSerie1=String.valueOf(Integer.parseInt(sSommeProduitSerie1)+Integer.parseInt("0"+sProduitSerie1.charAt(i)));//C'est horrible. Je sais. Normalement j'aurais utilisé un array de int. Mais comme la matière n'a pas encore été montré, je me sers d'un string de la ême façons :) 
			}
			iDiffDizaine=(10-(Integer.parseInt(sSommeProduitSerie1)%10))+20;//Comme on veut un chiffre rond, je soustrait le modulo à la dizaine. Puis je rajoute 20. Le 20 est arbitraire. Pour donne plus de chance aux 5 nombres de la prochaine suite d'égaler à ce nombre;
			/*SÉRIE 2*/
			do//On va executer cette boucle tant qu'il n'y aura pas d'égalité 
			{
			sSerie2="";
			iSommeSerie2=0;
				for(int i=0;i<5;i++)//On génère 5 chiffres de la série 2
				{
					iAlea=(int)(Math.random()*10);
					iSommeSerie2+=iAlea;//C'était impossible d'utiliser cette technique en Serie1, puisque il fallait traiter la multiplication, avant d'aditionner.
					sSerie2+=String.valueOf(iAlea);	
				}

			}while(iSommeSerie2!=iDiffDizaine);
			/*Fin SÉRIE 2*/
			/*Mise en forme du NAS*/
			iPositionSerie1=0; iPositionSerie2=0;
			for(int i=0;i<=8;i++)
			{
				if(i%2==0)//On va piger dans la série2
				{
					sNAS+=""+sSerie2.charAt(iPositionSerie2);
					iPositionSerie2++;
				}
				else
				{
					sNAS+=""+sSerie1.charAt(iPositionSerie1);
					iPositionSerie1++;
				}
				
			}
			/*Fin Mise en forme NAS*/
			
			System.out.println("Numéro d'assurance sociale #"+(j+1)+" :"+ sNAS);
		}
	}

}
