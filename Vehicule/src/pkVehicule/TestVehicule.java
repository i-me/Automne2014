package pkVehicule;

public class TestVehicule {

	public static void main(String[] args) {
		Vehicule unCivic=new Vehicule();
		unCivic.Remplissage(12);//On va tanker 12L chez irving :) 
		System.out.println(unCivic.Afficher());
		Vehicule unBMW=new Vehicule();
		unBMW.sMarque="BMW";
		unBMW.dConsommation=7.2;
		unBMW.dReservoir=85;
		unBMW.Remplissage(12);
		System.out.println(unBMW.Afficher());
	}

}
