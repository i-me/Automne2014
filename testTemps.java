package ca.qc.cegeptr.mat1393667.testTemps;
import ca.qc.cegeptr.mat1393667.outils.*;
import je.suis.vedge.*;
public class testTemps {

	public static void main(String[] args) {
		Temps unTemps=new Temps();
		Temps deuxTemps=new Temps(14, 57, 22);
		vedge pr=new vedge();
		
		pr.t("Premier temps, constructeur par d�faut");
		pr.t("Temps UFC:"+unTemps.tempsFUTC());
		pr.t("Get : "+unTemps.getHeure()+":"+unTemps.getMinute()+":"+unTemps.getSeconde());
		unTemps.setHeure(15);
		unTemps.setMinute(01);
		unTemps.setSeconde(05);
		pr.t("Set 15:01:05");
		pr.t(unTemps.tempsFUTC());
		pr.t("Deuxi�me Temps, constructeur param�tr�");
		pr.t("Heure soumise: 14:57:22");
		pr.t(deuxTemps.toString());
		pr.t("Heure format 12h est "+deuxTemps.tempsF12());
	}

}
/*
Premier temps, constructeur par d�faut
Temps UFC:12:0:0
Get : 12:0:0
Set 15:01:05
15:1:5
Deuxi�me Temps, constructeur param�tr�
Heure soumise: 14:57:22
L'heure au format 24H est 14:57:22
L'heure au format 12H est 2:H:57:MM:22:SS: PM
Heure format 12h est 2:H:57:MM:22:SS: PM
*/