package assignment2;

import java.util.Scanner;

public interface User {
	public static Scanner sc = new Scanner(System.in);
	public static int restaurantMenu() {
		int loopFlag=1;
    	while(loopFlag==1) {
    		System.out.println("");
    		System.out.println("Choose Restaurant\n" + 
    				"1) Shah (Authentic)\n" + 
    				"2) Ravi’s\n" + 
    				"3) The Chinese (Authentic)\n" + 
    				"4) Wang’s (Fast Food)\n" + 
    				"5) Paradise");
    		int inputQuery = sc.nextInt();
    		return inputQuery-1;
    	}
    	return 0;		// never executed
	}
	public static int customerMenu() {
		int loopFlag=1;
    	while(loopFlag==1) {
    		System.out.println("\n" + 
    				"1. Ram (Elite)\n" + 
    				"2. Sam (Elite)\n" + 
    				"3. Tim (Special)\n" + 
    				"4. Kim\n" + 
    				"5. Jim");
    		int inputQuery = sc.nextInt();
    		return inputQuery-1;
    	}
		return 0;	// never executed
	}
	public void displayMenu();
	public void displayRewards();
	public void displayUserDetails();
}
