package assignment2;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment2 {
	public Scanner sc = new Scanner(System.in);
	private Zotato zotato = new Zotato();
	private App startApp = new App();
	public static void main(String[] args) {
		
	}
	public Zotato getZotato() {
		return zotato;
	}
	public App getStartApp() {
		return startApp;
	}
	

}

class Zotato{
	private double deliveryCharges;
	private double restaurantCharges;
	public Zotato() {
		super();
	}
	public double getDeliveryCharges() {
		return deliveryCharges;
	}
	public void setDeliveryCharges(double deliveryCharges) {
		this.deliveryCharges = deliveryCharges;
	}
	public double getRestaurantCharges() {
		return restaurantCharges;
	}
	public void setRestaurantCharges(double restaurantCharges) {
		this.restaurantCharges = restaurantCharges;
	}
	
	
}
class App{
	protected static ArrayList <Customer> customerRecord = new ArrayList<Customer>();
	protected static ArrayList <Restaurant> restaurantRecord = new ArrayList<Restaurant>();
	//getter?
	App(){
		//hardcode data
		Restaurant shah = new AuthenticRestaurant("Shah", "101 Street", 1);
		restaurantRecord.add(shah);
		Restaurant ravi = new Restaurant("Ravi's", "100 Street");
		restaurantRecord.add(ravi);
		Restaurant chinese = new AuthenticRestaurant("The Chinese", "102 Street", 1);
		restaurantRecord.add(chinese);
		Restaurant wang = new FastfoodRestaurant("Wang's", "B22 Street", 1);
		restaurantRecord.add(wang);
		Restaurant paradise = new Restaurant("Paradise", "K01 Street");
		restaurantRecord.add(paradise);
		
		Customer ram = new EliteCustomer("Ram", "66-A block", "Elite");
		customerRecord.add(ram);
		Customer c = new EliteCustomer("Sam", "67-A block", "Elite");
		customerRecord.add(c);
		c = new SpecialCustomer("Tim", "68-A block", "Special");
		customerRecord.add(c);
		c = new Customer("Kim", "69-A block", "Customer");
		customerRecord.add(c);
		c = new Customer("Jim", "70-A block", "Customer");
		customerRecord.add(c);
		
		
	}
	
	public static ArrayList<Customer> getCustomerRecord() {
		return customerRecord;
	}

	public static ArrayList<Restaurant> getRestaurantRecord() {
		return restaurantRecord;
	}

}

class Restaurant implements User{
	protected static ArrayList <Food> menu = new ArrayList<Food>();
	protected int numberOrders=0;
	protected double discount;
	protected double morediscountCriteria,morediscountAmount;
	protected double rewardAmount, rewardCriteria;
	protected final String name;
	protected final String address;
	public Restaurant(String name, String address) {
		super();
		this.name = name;
		this.address = address;
		this.discount = 0;
		this.morediscountCriteria = 0;
		this.morediscountAmount = 0;
		this.rewardAmount=5;
		this.rewardCriteria=100;
	}
	@Override
	public void displayMenu() {
		
	}
	@Override
	public void displayRewards() {
		
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
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
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

class Customer implements User{
	private String category;
	protected static ArrayList <Restaurant> restaurants = new ArrayList<Restaurant>();
	protected ArrayList <Cart> pastOrders = new ArrayList<Cart>();
	protected Restaurant selectedRestaurant;
	protected Cart currentOrder;
	protected Wallet userAccount;
	protected int delivery=40;	
	protected double discountCriteria,discountAmount;
	protected final String name;
	protected final String address;
	
	public Customer(String name, String address, String category) {
		super();
		this.name = name;
		this.address = address;
		this.category = category;
		this.discountAmount=0;
		this.discountCriteria=0;
		this.userAccount = new Wallet(); //composition
		
	}
	
	@Override
	public void displayMenu() {
		
	}
	@Override
	public void displayRewards() {
		
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

	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	
}
class Wallet{
	private double rewardAmount,wallet;
	public Wallet() {
		this.wallet = 1000;
		this.rewardAmount=0;
	}

	public void setRewardAmount(double rewardAmount) {
		this.rewardAmount = rewardAmount;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

	public double getRewardAmount() {
		return rewardAmount;
	}

	public double getWallet() {
		return wallet;
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
	public double getTotalAmount() {
		return totalAmount;
	}
	public ArrayList<Food> getItems() {
		return items;
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


















