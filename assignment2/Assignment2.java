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
	public User(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	
	
}

class Restaurant extends User{
	protected static ArrayList <Food> menu = new ArrayList<Food>();
	protected double discount;
	protected int numberOrders=0;
	protected double morediscountCriteria,morediscountAmount;
	public Restaurant(String name, String address) {
		super(name, address);
		this.discount = 0;
		this.morediscountCriteria = 0;
		this.morediscountAmount = 0;
	}
	
}
class AuthenticRestaurant extends Restaurant{

	public AuthenticRestaurant(String name, String address , double discount) {
		super(name, address);
		this.discount =discount ;
		this.morediscountCriteria = 100;
		this.morediscountAmount = 50;
	}	
}
class FastfoodRestaurant extends Restaurant{

	public FastfoodRestaurant(String name, String address, double discount) {
		super(name, address);
		this.discount =discount ;
		this.morediscountCriteria = 0;
		this.morediscountAmount = 0;
	}
	
}

class Customer extends User{
	
	
}

class Food{
	private static int idGenerator=1;
	private int id;
	private String name;
	private double price, discount;
	private int quantity;

	public Food(String name, double price, double discount, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.discount = discount;
		this.quantity = quantity;
		this.id=Food.idGenerator;
		Food.idGenerator++;
		
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}


















