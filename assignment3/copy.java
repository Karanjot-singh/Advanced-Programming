//package assignment3;
//
//import java.util.ArrayList;
//import java.util.InputMismatchException;
//import java.util.Random;
//import java.util.Scanner;
//
//
//public class Assignment3 {
//    public static Scanner sc = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        Game newGame = new Game();
//    }
//}
//
//class Game {
//    public static Scanner sc = new Scanner(System.in);
//    private static ArrayList<Player> players;
//
//    public static void chooseUser(int choice) {
//        if (choice == 1) {
//            User<Mafia> player1 = new User<Mafia>();
//            players.add(player1);
//
//        } else if (choice == 2) {
//            User<Detective> player1 = new User<Detective>();
//            players.add(player1);
//        } else if (choice == 3) {
//            User<Healer> player1 = new User<Healer>();
//            players.add(player1);
//        } else if (choice == 4) {
//            User<Commoner> player1 = new User<Commoner>();
//            players.add(player1);
//        } else if (choice == 5) {
//            Random selector = new Random();
//            int randomChoice = (int) selector.nextInt(4-1)+1;
//            chooseUser(randomChoice);
//        }
//    }
//
//    public static void displayMenu() {
//        System.out.println("Welcome to Mafia");
//        int numberPlayers, loop;
//        loop = 1;
//        while (loop == 1) {
//            try {
//                System.out.println("Enter Number of players:\n");
//                numberPlayers = sc.nextInt();
//                loop = 0;
//            } catch (InputMismatchException e) {
//                System.out.println("Invalid input. \nPlease Try Again.");
//            }
//        }
//
//        System.out.println("Choose a Character\n" +
//                "1) Mafia\n" +
//                "2) Detective\n" +
//                "3) Healer\n" +
//                "4) Commoner\n" +
//                "5) Assign Randomly");
//        int choice;
//        loop = 1;
//        while (loop == 1) {
//            try {
//                choice = sc.nextInt();
//                chooseUser(choice);
//                loop = 0;
//            } catch (InputMismatchException e) {
//                System.out.println("Invalid input. \nPlease Try Again.");
//            }
//        }
//    }
//}
//
//class Round {
//
//
//}
//
//class User<T>extends Player {
//    public User() {
//    }
//}
//
//abstract class Player {
//    private static ArrayList<Player> players;
//
//    public Player() {
//    }
//
//    public void randomSelector() {
//        Random selector = new Random();
//        int randomPlayer = selector.nextInt(players.size());
//
//
//    }
//
//    public static int generateRandom() {
//        return 0;
//    }
//}
//
//class Mafia extends Player {
//    public Mafia() {
//    }
//}
//
//class Healer extends Player {
//}
//
//class Commoner extends Player {
//}
//
//class Detective extends Player {
//}
//
//
//
