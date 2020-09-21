package assignment2;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment2 {
	private static App app;
	public static void main(String[] args) {
		App startApp = new App();
		app=startApp;
	}
}

class Zotato{
	private double deliveryCharges;
	private double restaurantCharges;
	public Zotato() {
		super();
	}
	public void display() {
		System.out.println("");
		System.out.println("Total Company balance - INR"+this.restaurantCharges+"/-\n" + 
				"Total Delivery Charges Collected - INR"+this.deliveryCharges+"/-\n");
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
		Zotato z = new Zotato();
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
		Customer ram = new EliteCustomer("Ram", "66-A block", "Elite",restaurantRecord,z);
		customerRecord.add(ram);
		Customer c = new EliteCustomer("Sam", "67-A block", "Elite",restaurantRecord,z);
		customerRecord.add(c);
		c = new SpecialCustomer("Tim", "68-A block", "Special",restaurantRecord,z);
		customerRecord.add(c);
		c = new Customer("Kim", "69-A block", "Customer",restaurantRecord,z);
		customerRecord.add(c);
		c = new Customer("Jim", "70-A block", "Customer",restaurantRecord,z);
		customerRecord.add(c);
		parentMenu();
		
	}

	private static void parentMenu() {
		int loopFlag=1;
    	while(loopFlag==1) {
    		System.out.println("");
    		System.out.println("Welcome to Zotato:\n");
    		System.out.println("1. Enter as Restaurant Owner\n" + 
    				"2. Enter as Customer\n" + 
    				"3. Check User Details\n" + 
    				"4. Company Account details\n" + 
    				"5. Exit");
    		int inputQuery = sc.nextInt();
    		if(inputQuery==1) {
    			int choice = User.restaurantMenu();
    			restaurantRecord.get(choice).displayMenu();
    		}
    		else if(inputQuery==2) {
    			int choice = User.customerMenu();
    			customerRecord.get(choice).displayMenu();
    		}
    		else if(inputQuery==3) {
    			System.out.println("");
    			System.out.println("1) Customer List\n" + 
    					"2) Restaurant List");
    			
    			int input1 = sc.nextInt();
    			if(input1==1) {
    				int choice = User.customerMenu();
    				Customer customer =customerRecord.get(choice);
    				useInterface(customer);
    			}
    			else {
    				int choice = User.restaurantMenu();
    				Restaurant restaurant = restaurantRecord.get(choice);
    				useInterface(restaurant);
    				
    			}
    			
    		}
    		else if(inputQuery==4) {
    			Zotato z = new Zotato();
    			z.display();
    		}
    		else if(inputQuery==5) {
    			loopFlag=0;
    		}	
    		
    	}
		
	}
	private static void useInterface(User user) {
		user.displayUserDetails();

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
	protected int rewardAmount, rewardCriteria ,rewardPoints;
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
	protected void addItem() {		
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
		System.out.println(item.getId() +" "+ input + " "  
		+ inputPrice+ " " + inputQty + " "+ inputOffer+ "% off " + inputCategory );
		
	}
	protected void editItem() {		
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
	protected void editItemMenu(int index) {
		int loopFlag=1;
    	while(loopFlag==1) {
    		System.out.println("");
    		System.out.println("Choose an attribute to edit:\n" + 
    				"1) Name\n" + 
    				"2) Price\n" + 
    				"3) Quantity\n" + 
    				"4) Category\n" + 
    				"5) Offer"+ 
    				"6) Exit\n" );
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
    		else
    			loopFlag=0;
    		Food item = this.menu.get(index);
    		System.out.println(index+1 +" "+ this.getName() +" - "+item.getName() + " " 
    		+ item.getPrice()+ " " +item.getQuantity()+ " "+ item.getDiscount()+ "% off " +  item.getCategory() );
    	}

		
	}
	@Override
	public void displayRewards() {
		System.out.println("Reward Points: "+ this.getRewardPoints());
	}
	@Override
	public void displayUserDetails() {
		System.out.println("/n"+ this.name+" "+ this.address+ " " + this.getNumberOrders());
		
	}
	
	public void setNumberOrders(int numberOrders) {
		this.numberOrders = numberOrders;
	}
	public ArrayList<Food> getMenu() {
		return menu;
	}
	
	public int getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(int rewardPoints) {
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
	public int getRewardAmount() {
		return rewardAmount;
	}
	public int getRewardCriteria() {
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
	protected static Zotato zotato; //association
	protected ArrayList <Cart> pastOrders = new ArrayList<Cart>();
	protected Cart currentOrder;
	protected int rewards;
	protected Wallet wallet;
	protected int delivery=40;	
	protected double discountCriteria,discountAmount;
	protected final String name;
	protected final String address;
	
	public Customer(String name, String address, String category,ArrayList <Restaurant> restaurantList, Zotato z) {
		//Association 
		super();
		this.name = name;
		this.address = address;
		this.category = category;
		this.discountAmount=0;
		restaurants= restaurantList;
		this.discountCriteria=0;
		this.wallet = new Wallet(); //composition
		zotato = z;
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
    		else if(inputQuery==2) currentOrder.checkoutCart(zotato);
    		else if(inputQuery==3) displayRewards();
    		else if(inputQuery==4) displayPreviousOrders();
    		else if(inputQuery==5) {
    			loopFlag=0;
    		}    		
    	}
		
	}
	protected void displayPreviousOrders() {

		System.out.println("");
		for(Cart orders : this.pastOrders) {
			System.out.println(orders.getSummary());
		}
	}
	protected void selectRestaurant() {

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
	
	@Override
	public void displayRewards() {
		System.out.println("Reward Points: "+ this.rewards);
	}
	@Override
	public void displayUserDetails() {
		System.out.println("\n"+ this.name+" "+ this.category+" "+ this.address+ " " + this.wallet.getWallet());
		
	}
	public int getRewards() {
		return rewards;
	}

	public void setRewards(int rewards) {
		this.rewards = rewards;
		wallet.setRewardAmount(rewards);
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
	private double wallet;
	private double rewardAmount;

	public Wallet() {
		this.wallet = 1000;
		this.rewardAmount=0;
	}
	public void deductAmount(double amount) {
		if(amount> this.rewardAmount)
		{
			this.wallet= wallet-amount+this.rewardAmount;
			this.rewardAmount=0;
		}
		else
			this.rewardAmount= this.rewardAmount -amount;
			
	}

	public void setRewardAmount(int rewardAmount) {
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
	private String summary="";
	private double totalAmount=0;
	private double foodDiscount=0;
	private int reward=0;
	private ArrayList <Food> items = new ArrayList<Food>();
	private Restaurant restaurant;
	private Customer customer;
	public static Scanner sc = new Scanner(System.in);
	
	public Cart(Restaurant restaurant, Customer customer) {
		super();
		this.restaurant = restaurant;
		this.customer = customer;
	}
	public void addToCart(Food item) {
		this.items.add(item);
		
	}
	//dependency
	protected void checkoutCart(Zotato zotato ){
		System.out.println("");
		System.out.println("Items in Cart -");
		for(Food item : items) {
			System.out.println(item.getId() +" "+ item.getQuantity() +" "+restaurant.getName()+
					" -"+item.getName() + " " + item.getCategory()+ " " 
		+ item.getPrice()+ " " + item.getDiscount()+ "% off " + item.getQuantity());
			
			double temp;
			if(item.getDiscount()==0)
				temp = (item.getPrice()) * (item.getQuantity());
			else
				temp = (100-item.getDiscount() )*(item.getPrice()) * (item.getQuantity())/100;
			this.foodDiscount = this.foodDiscount +temp;
//			System.out.println("Food discount"+this.foodDiscount);
		}
		double discount = restaurantDiscounts();
		customerDiscounts(discount);	
		System.out.println("Delivery charge -"+customer.getDelivery() +"/-");
		double totalPay=this.totalAmount+customer.getDelivery();
		System.out.println("Total Order Value - INR "+totalPay+"/-");
		
		System.out.println("1) Proceed to checkout");
		int inputidx = sc.nextInt();
		if(inputidx ==1) {
			customer.wallet.deductAmount(totalPay);
//			int qty = itemOld.getQuantity();
			
			//deduction
			System.out.println("items successfully bought for INR "+totalPay+"/-");
			
			// to send rewards to the customer and the Restaurant
			calculateRewards();
			
			customer.setRewards(customer.getRewards()+this.reward);
			restaurant.setRewardPoints(restaurant.getRewardPoints()+this.reward);
			restaurant.setNumberOrders(restaurant.getNumberOrders()+1);			
			//Payout to zotato			
			zotato.setRestaurantCharges(this.totalAmount);
			zotato.setDeliveryCharges(customer.getDelivery());
			
			displayDetails();
		}			
		
	}
	protected void displayDetails() {
		for(Food item : items) {
		this.summary="Bought item: "+item.getName() + " Quantity:" + item.getQuantity()+ " for Rs  " 
				+ item.getPrice()+ " from Restaurant " + restaurant.getName()
				+ " and Delivery Charge "+customer.getDelivery();
		}
	}
	protected void calculateRewards() {
		int temp = (int) (totalAmount/restaurant.getRewardCriteria());
		System.out.println("temp");
		this.reward = (int) (temp*(restaurant.getRewardAmount()));
		System.out.println("Reward calculated ="+this.reward);
		
	}
	protected void customerDiscounts(double discount) {
		if(discount>=customer.getDiscountCriteria()) {
			discount = discount - customer.getDiscountAmount();		
			System.out.println("customer "+discount);}
		this.totalAmount= discount;
	}
	protected double restaurantDiscounts() {
		double temp=this.foodDiscount;
		if(restaurant.getDiscount()==0) {
			temp = this.foodDiscount;
//			System.out.println("c"+temp);
		} //customer
		else if (restaurant.getMorediscountCriteria()==0) {
			temp = (100-restaurant.getDiscount() )*(this.foodDiscount)/100; 
//			System.out.println("s"+temp);
		}//special
		else if(temp >= restaurant.getMorediscountCriteria()) {
			temp = (100-restaurant.getDiscount() )*(this.foodDiscount)/100;
			temp = temp- restaurant.getMorediscountAmount();	
//			System.out.println("e"+temp);
		}		
		return temp;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public ArrayList<Food> getItems() {
		return items;
	}
	public String getSummary() {
		return summary;
	}	
	
}
class EliteCustomer extends Customer{

	public EliteCustomer(String name, String address, String category,ArrayList <Restaurant> restaurantList,Zotato z) {
		super(name, address, category,restaurantList,z);
		this.discountAmount=50;
		this.discountCriteria=200;
		this.delivery=0;
		
	}	
}
class SpecialCustomer extends Customer{

	public SpecialCustomer(String name, String address, String category,ArrayList <Restaurant> restaurantList,Zotato z) {
		super(name, address, category,restaurantList,z);
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


















