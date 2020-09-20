package assignment2;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment2 {
	private static Zotato zotato;
	private static App app;
	public static void main(String[] args) {
		App startApp = new App();
		app=startApp;
		Zotato company = new Zotato();
		zotato = company;
	}
	public Zotato getZotato() {
		return zotato;
	}
	public App getApp() {
		return app;
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
	public static Scanner sc = new Scanner(System.in);
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
		Customer ram = new EliteCustomer("Ram", "66-A block", "Elite",restaurantRecord);
		customerRecord.add(ram);
		Customer c = new EliteCustomer("Sam", "67-A block", "Elite",restaurantRecord);
		customerRecord.add(c);
		c = new SpecialCustomer("Tim", "68-A block", "Special",restaurantRecord);
		customerRecord.add(c);
		c = new Customer("Kim", "69-A block", "Customer",restaurantRecord);
		customerRecord.add(c);
		c = new Customer("Jim", "70-A block", "Customer",restaurantRecord);
		customerRecord.add(c);
		parentMenu(c);
		
	}
	private static void parentMenu(Customer c) {
		int loopFlag=1;
    	while(loopFlag==1) {
    		System.out.println("");
    		System.out.println("Welcome to Zotato:");
    		System.out.println("1. Enter as Restaurant Owner\n" + 
    				"    		2. Enter as Customer\n" + 
    				"    		3. Check User Details\n" + 
    				"    		4. Company Account details\n" + 
    				"    		5. Exit");
    		int inputQuery = sc.nextInt();
    		if(inputQuery==1) {
    			int choice = User.restaurantMenu();
    			restaurantRecord.get(choice).displayMenu();
    		}
    		else if(inputQuery==2) {
    			int choice = User.customerMenu();
    			c.displayMenu();
    		}
    		else if(inputQuery==3) {}
    		else if(inputQuery==4) {}
    		else if(inputQuery==5) {
    			loopFlag=0;
    		}	
    		
    	}
		
	}
	
	public static ArrayList<Customer> getCustomerRecord() {
		return customerRecord;
	}

	public static ArrayList<Restaurant> getRestaurantRecord() {
		return restaurantRecord;
	}

}

class Restaurant implements User{
	protected ArrayList <Food> menu = new ArrayList<Food>();
	protected int numberOrders=0;
	protected double discount;
	protected double morediscountCriteria,morediscountAmount;
	protected double rewardAmount, rewardCriteria ,rewardPoints;
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
		this.rewardPoints=0;
	}
	@Override
	public void displayMenu() {
		int loopFlag=1;
    	while(loopFlag==1) {
    		System.out.println("");
    		System.out.println("Welcome " +this.getName() +"\n" + 
    				"1) Add item\n" + 
    				"2) Edit item\n" + 
    				"3) Print Rewards\n" + 
    				"4) Discount on bill value\n" + 
    				"5) Exit");
    		System.out.println();
    		int inputQuery = sc.nextInt();
    		if(inputQuery==1) addItem();
    		else if(inputQuery==2) editItem();
    		else if(inputQuery==3) displayRewards();
    		else if(inputQuery==4)
    			System.out.println("Offer on bill value - ​"+ this.getDiscount()+" %");
    		else if(inputQuery==5) {
    			loopFlag=0;
    		}    		
    	}		
	}
	private void addItem() {		
		System.out.println("");
		System.out.println("Enter food item details\n" + 
				"Food name:");
		String input = sc.next();
		System.out.println("item price:");
		double inputPrice = sc.nextDouble();
		System.out.println("item quantity​ :");
		int inputQty = sc.nextInt();
		System.out.println("item category​ :");
		String inputCategory = sc.next();
		System.out.println("Offer:");
		int inputOffer = sc.nextInt();
		Food item = new Food(input, inputCategory, inputPrice, inputOffer, inputQty);
		this.menu.add(item);
		System.out.println(item.getId() +" "+ input + " " + inputCategory+ " " 
		+ inputPrice+ " " + inputOffer+ "% off " + inputQty);
		
	}
	private void editItem() {		
		System.out.println("");
		int count =0;
		for(Food item : menu) {
			System.out.println(++count +" "+ this.getName() +" -"+item.getName() + " " + item.getCategory()+ " " 
		+ item.getPrice()+ " " + item.getDiscount()+ "% off " + item.getQuantity());
		}
		System.out.println("Choose item by number");
		int inputidx = sc.nextInt();
		this.editItemMenu(inputidx-1);
		
		
	}
	public int showMenu() {
		System.out.println("");
		int count =0;
		for(Food item : menu) {
			System.out.println(++count +" "+ this.getName() +" -"+item.getName() + " " + item.getCategory()+ " " 
		+ item.getPrice()+ " " + item.getDiscount()+ "% off " + item.getQuantity());
		}
		int inputItem = sc.nextInt();
		return inputItem-1;
	}
	private void editItemMenu(int index) {
		int loopFlag=1;
    	while(loopFlag==1) {
    		System.out.println("");
    		System.out.println("Choose an attribute to edit:\n" + 
    				"1) Name\n" + 
    				"2) Price\n" + 
    				"3) Quantity\n" + 
    				"4) Category\n" + 
    				"5) Offer");
    		System.out.println();
    		int inputQuery = sc.nextInt();
    		if(inputQuery==2) {
    			System.out.println("Enter the new price -");
    			double price = sc.nextDouble();
    			this.menu.get(index).setPrice(price);
    		}
    		else if(inputQuery==1) {
    			System.out.println("Enter the new name -");
    			String input = sc.next();
    			this.menu.get(index).setName(input);	
    		}
    		else if(inputQuery==3) {    			
    		System.out.println("Enter the new quantity -");
			int input = sc.nextInt();
			this.menu.get(index).setQuantity(input);
			}
    		else if(inputQuery==4) {
    			System.out.println("Enter the new category -");
    			String input = sc.next();
    			this.menu.get(index).setName(input);
    		}
    		else if(inputQuery==5) {
    			System.out.println("Enter the new offer -");
    			double price = sc.nextDouble();
    			this.menu.get(index).setDiscount(price);
    		}
    		Food item = this.menu.get(index);
    		System.out.println(index+1 +" "+ this.getName() +" -"+item.getName() + " " + item.getCategory()+ " " 
    		+ item.getPrice()+ " " + item.getDiscount()+ "% off " + item.getQuantity());
    	}

		
	}
	@Override
	public void displayRewards() {
		System.out.println("Reward Points: "+ this.getRewardPoints());
	}
	
	public ArrayList<Food> getMenu() {
		return menu;
	}
	
	public double getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(double rewardPoints) {
		this.rewardPoints = rewardPoints;
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
	protected Cart currentOrder;
	protected Wallet userAccount;
	protected int delivery=40;	
	protected double discountCriteria,discountAmount;
	protected final String name;
	protected final String address;
	
	public Customer(String name, String address, String category,ArrayList <Restaurant> restaurantList ) {
		//Association 
		super();
		this.name = name;
		this.address = address;
		this.category = category;
		this.discountAmount=0;
		restaurants= restaurantList;
		this.discountCriteria=0;
		this.userAccount = new Wallet(); //composition
		
	}
	
	@Override
	public void displayMenu() {
		int loopFlag=1;
    	while(loopFlag==1) {
    		System.out.println("");
    		System.out.println("Welcome " +this.getName() +"\n" + 
    				"Customer Menu\n" + 
    				"1) Select Restaurant\n" + 
    				"2) checkout cart\n" + 
    				"3) Reward won\n" + 
    				"4) print the recent orders\n" + 
    				"5) Exit");
    		System.out.println();
    		int inputQuery = sc.nextInt();
    		if(inputQuery==1) selectRestaurant();
    		else if(inputQuery==2) checkoutCart();
    		else if(inputQuery==3) displayRewards();
    		else if(inputQuery==4);
    		else if(inputQuery==5) {
    			loopFlag=0;
    		}    		
    	}
		
	}
	private void selectRestaurant() {

		int choice = User.restaurantMenu();
		Restaurant selected = restaurants.get(choice);
		//Association
		this.currentOrder = new Cart(selected, this);
		int idx = selected.showMenu();
		System.out.println("Enter item quantity - ");
		//Assuming input will always be less than restaurant stock
		int inputQty = sc.nextInt();
		Food itemOld = selected.menu.get(idx);
		Food item;
		try {
			item = (Food)itemOld.clone();
			item.setQuantity(inputQty); // not a reference but a copy
			currentOrder.addToCart(item);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Items added to cart");
	}
	private void checkoutCart()
	{
		
	}	@Override
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
	private Restaurant restaurant;
	private Customer customer;
	
	public Cart(Restaurant restaurant, Customer customer) {
		super();
		this.restaurant = restaurant;
		this.customer = customer;
	}
	public void addToCart(Food item) {
		this.items.add(item);
		
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public ArrayList<Food> getItems() {
		return items;
	}	
	
}
class EliteCustomer extends Customer{

	public EliteCustomer(String name, String address, String category,ArrayList <Restaurant> restaurantList) {
		super(name, address, category,restaurantList);
		this.discountAmount=50;
		this.discountCriteria=200;
		this.delivery=0;
		
	}	
}
class SpecialCustomer extends Customer{

	public SpecialCustomer(String name, String address, String category,ArrayList <Restaurant> restaurantList) {
		super(name, address, category,restaurantList);
		this.discountAmount=25;
		this.discountCriteria=200;
		this.delivery=20;
	}	
	
	
}

class Food implements Cloneable{
	private static int idGenerator=1;
	private int id;
	private String name, category;
	private double price, discount;
	private int quantity;
	
	public Object clone() throws
	    CloneNotSupportedException 
		{ 
		return super.clone(); 
		}
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


















