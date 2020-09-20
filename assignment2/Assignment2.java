package assignment2;
import java.util.ArrayList;

public class Assignment2 {

	public static void main(String[] args) {

	}

}

class Zotato{
	private double deliveryCharges;
	private double restaurantCharges;
	public Zotato(double deliveryCharges, double restaurantCharges) {
		super();
		this.deliveryCharges = deliveryCharges;
		this.restaurantCharges = restaurantCharges;
	}
	
}
class App{
	protected static ArrayList <Customer> customerRecord = new ArrayList<Customer>();
	protected static ArrayList <Restaurant> restaurantRecord = new ArrayList<Restaurant>();
	App(){
		//hardcode data
	}
}

abstract class User{
	protected String name;
	protected String address;
	
}

class Restaurant extends User{
	
	
}
class Customer extends User{
	
}

class Food{
	private static int idGenerator=0;
	private String name;
	private double price, discount;
	private int quantity;
	
}


















