package pkVehicule;

public class Vehicule {
	public String sMarque;
	public double dConsommation;
	public double dReservoir;
	
	public Vehicule()
	{
		sMarque="Honda";//CIVIC
		dConsommation=6.7;//Litre au 100
		dReservoir=55;//Capacité
	}
	public void Remplissage(int qty)
	{
		dReservoir+=qty;
	}
	public String Afficher()
	{
		return("La voiture "+sMarque+" a une consommation de "+dConsommation+"L/100Km. Le réservoir contient présentement "+dReservoir);
	}
	
}
