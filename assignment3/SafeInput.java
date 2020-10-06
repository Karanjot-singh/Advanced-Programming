package assignment3;

import java.util.Scanner;

public interface SafeInput {
    public static Scanner sc = new Scanner(System.in);

    public static int safeInput(String message) {
        int input;
        while (true) {
            try {
                System.out.println(message);
                String temp = sc.next();
                input = Integer.parseInt(temp);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. \nPlease Try Again.");
            }
        }
        return input;
    }
    public static int safeInputMin(String message,int min) {
        int input;
        while (true) {
            try {
                System.out.println(message);
                String temp = sc.next();
                input = Integer.parseInt(temp);
                if(input<min){
                    System.out.println("Number of Players must be >="+min);
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. \nPlease Try Again.");
            }
        }
        return input;
    }
    public static int safeInputMax(String message,int max) {
        int input;
        while (true) {
            try {
                System.out.println(message);
                String temp = sc.next();
                input = Integer.parseInt(temp);
                if(input>max){
                    System.out.println("Invalid input. Enter Input within "+max);
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. \nPlease Try Again.");
            }
        }
        return input;
    }
}