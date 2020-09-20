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
	
	public static ArrayList<Customer> getCustomerRecord() {
		return customerRecord;
	}

	public static ArrayList<Restaurant> getRestaurantRecord() {
		return restaurantRecord;
	}

}

abstract class User{

	protected final String name;
	protected final String address;	
	public User(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	
}

class Restaurant extends User{
	protected static ArrayList <Food> menu = new ArrayList<Food>();
	protected int numberOrders=0;
	protected double discount;
	protected double morediscountCriteria,morediscountAmount;
	protected double rewardAmount, rewardCriteria;
	public Restaurant(String name, String address) {
		super(name, address);
		this.discount = 0;
		this.morediscountCriteria = 0;
		this.morediscountAmount = 0;
		this.rewardAmount=5;
		this.rewardCriteria=100;
	}
	public static ArrayList<Food> getMenu() {
		return menu;
	}
	public double getDiscount() {
		return discount;
	}
	public int getNumberOrders() {
		return numberOrders;
	}
	public double getMorediscountCriteria() {
		return morediscountCriteria;
	}
	public double getMorediscountAmount() {
		return morediscountAmount;
	}
	public double getRewardAmount() {
		return rewardAmount;
	}
	public double getRewardCriteria() {
		return rewardCriteria;
	}
	
	
}
class AuthenticRestaurant extends Restaurant{

	public AuthenticRestaurant(String name, String address , double discount) {
		super(name, address);
		this.discount =discount ;
		this.morediscountCriteria = 100;
		this.morediscountAmount = 50;
		this.rewardAmount=25;
		this.rewardCriteria=200;
	}	
}
class FastfoodRestaurant extends Restaurant{

	public FastfoodRestaurant(String name, String address, double discount) {
		super(name, address);
		this.discount =discount ;
		this.morediscountCriteria = 0;
		this.morediscountAmount = 0;
		this.rewardAmount=10;
		this.rewardCriteria=150;
	}
	
}

class Customer extends User{
	private String category;
	protected static ArrayList <Restaurant> restaurants = new ArrayList<Restaurant>();
	protected ArrayList <Cart> pastOrders = new ArrayList<Cart>();
	protected Restaurant selectedRestaurant;
	protected Cart currentOrder;		
	protected int delivery=40;
	protected double discountCriteria,discountAmount;
	protected double rewardAmount,wallet;
	
	public Customer(String name, String address, String category) {
		super(name, address);
		this.category = category;
		this.wallet = 1000;
		this.discountAmount=0;
		this.discountCriteria=0;		
	}

	public String getCategory() {
		return category;
	}

	public static ArrayList<Restaurant> getRestaurants() {
		return restaurants;
	}

	public ArrayList<Cart> getPastOrders() {
		return pastOrders;
	}

	public Restaurant getSelectedRestaurant() {
		return selectedRestaurant;
	}

	public Cart getCurrentOrder() {
		return currentOrder;
	}

	public int getDelivery() {
		return delivery;
	}

	public double getDiscountCriteria() {
		return discountCriteria;
	}

	public double getDiscountAmount() {
		return discountAmount;
	}

	public double getRewardAmount() {
		return rewardAmount;
	}

	public double getWallet() {
		return wallet;
	}
	
	
}
class EliteCustomer extends Customer{

	public EliteCustomer(String name, String address, String category) {
		super(name, address, category);
		this.discountAmount=50;
		this.discountCriteria=200;
		this.delivery=0;
	}	
}
class SpecialCustomer extends Customer{

	public SpecialCustomer(String name, String address, String category) {
		super(name, address, category);
		this.discountAmount=25;
		this.discountCriteria=200;
		this.delivery=20;
	}	
	
	
}

class Cart{
	private double totalAmount;
	private ArrayList <Food> items = new ArrayList<Food>();
	public Cart(ArrayList<Food> items) {
		super();
		this.items = items;
		//code to calculate discounts, checkout , rewards
	}
	
	
	
}

class Food{
	private static int idGenerator=1;
	private int id;
	private String name, category;
	private double price, discount;
	private int quantity;

	public Food(String name, String category, double price, double discount, int quantity) {
		super();
		this.name = name;
		this.price = price;
		this.discount = discount;
		this.quantity = quantity;
		this.category=category;
		this.id=Food.idGenerator;
		Food.idGenerator++;
		
	}
	
	public int getId() {
		return id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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


















