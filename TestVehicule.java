package pkVehicule;

public class TestVehicule {

	public static void main(String[] args) {
		Vehicule unCivic=new Vehicule("Honda", 6.5, 55);
		unCivic.setRemplissage(12);//On va tanker 12L chez irving :) 
		System.out.println(unCivic.toString());
		Vehicule unBMW=new Vehicule("BMW", 7.2, 85);
		System.out.println(unBMW.toString());
	}

}
