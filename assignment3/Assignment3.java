package assignment3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Assignment3 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) {
        Game newGame = new Game();
    }
}

class Game {
    public static Scanner sc = new Scanner(System.in);

    public static void displayMenu() {
        System.out.println("Welcome to Mafia");
        System.out.println("Enter Number of players:\n");
        int numberPlayers;
        try {
            numberPlayers = sc.nextInt();

        } catch (InputMismatchException) {
            System.out.println("Invalid input. \nPlease Try Again.");
        }
        System.out.println("Choose a Character\n" +
                "1) Mafia\n" +
                "2) Detective\n" +
                "3) Healer\n" +
                "4) Commoner\n" +
                "5) Assign Randomly");
        int choice;
        try {
            choice = sc.nextInt();
            if (choice == 1) {

            } else if (choice == 2) {
            } else if (choice == 3) {
            } else if (choice == 4) {
            } else if (choice == 5) {

            }

        } catch (InputMismatchException) {
            System.out.println("Invalid input. \nPlease Try Again.");
        }
    }

    class Round {
        displayMenu();

    }

    class User<T> {


    }
}

abstract class Player {
    private static ArrayList<Player> players;

    public Player() {
    }

    public void randomSelector(){
        Random selector = new Random();
        int randomPlayer = selector.nextInt(players.size());


    }
    public static int generateRandom() {
        return 0;
    }
}

class Mafia extends Player {
    public Mafia() {
    }
}

class Healer extends Player {
}

class Commoner extends Player {
}

class Detective extends Player {
}



