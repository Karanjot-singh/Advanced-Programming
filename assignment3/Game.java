package assignment3;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static Scanner sc = new Scanner(System.in);
    protected static HashMap<Integer, Player> players = new HashMap<Integer, Player>();
    private static int numberPlayers;
    private static int maxMafias;
    private static int maxDetectives;
    private static int maxHealers;
    private static int maxCommoners;

    Game() {
        displaymenu();
    }

    public static void displaymenu() {
        System.out.println("Welcome to Mafia");
        int numberPlayers = safeInput("Enter Number of players:");
        countPlayers(numberPlayers);
        int choice= safeInput("Choose a Character\n" +
                "1) Mafia\n" +
                "2) Detective\n" +
                "3) Healer\n" +
                "4) Commoner\n" +
                "5) Assign Randomly");
        chooseUser(choice);

    }

    public static void chooseUser(int choice) {
        int count = 0;
        if (choice == 1) {
            Player player1 = new Mafia();
            players.put(++count, player1);
            maxMafias -= 1;
            addPlayers();
            maxMafias += 1;
        } else if (choice == 2) {
            Player player1 = new Detective();
            players.put(++count, player1);
            maxDetectives -= 1;
            addPlayers();
            maxDetectives += 1;
        } else if (choice == 3) {
            Player player1 = new Healer();
            players.put(++count, player1);
            maxHealers -= 1;
            addPlayers();
            maxHealers += 1;
        } else if (choice == 4) {
            Player player1 = new Commoner();
            players.put(++count, player1);
            maxCommoners -= 1;
            addPlayers();
            maxCommoners += 1;
        } else if (choice == 5) {
            Random selector = new Random();
            int randomChoice = (int) selector.nextInt(4 - 1) + 1;
            chooseUser(randomChoice);
        }
    }

    public static void countPlayers(int n) {
        numberPlayers = n;
        int count = 0;
        maxMafias = numberPlayers / 5;
        maxDetectives = numberPlayers / 5;
        maxHealers = Math.max(numberPlayers / 10, 1);
        count += maxMafias + maxDetectives + maxHealers;
        maxCommoners = numberPlayers - count;
    }

    public static void addPlayers() {
        int count = 1;
        for (int i = 0; i < maxMafias; i++) {
            Player player = new Mafia();
            players.put(++count, player);
//            System.out.println("m");
        }
        for (int i = 0; i < maxDetectives; i++) {
            Player player = new Mafia();
            players.put(++count, player);
//            System.out.println("d");

        }
        for (int i = 0; i < maxHealers; i++) {
            Player player = new Mafia();
            players.put(++count, player);
//            System.out.println("h");

        }
        for (int i = 0; i < maxCommoners; i++) {
            Player player = new Mafia();
            players.put(++count, player);
        }

    }

    public static int safeInput(String message) {
        int input = 0;
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


}

