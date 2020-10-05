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
    private static Controller<Mafia> mafiaController;
    private static Controller<Detective> detectiveController;
    private static Controller<Healer> healerController;
    private static Controller<Commoner> commonerController;

    Game() {
        mafiaController = new Controller<Mafia>();
        detectiveController = new Controller<Detective>();
        healerController = new Controller<Healer>();
        commonerController = new Controller<Commoner>();
        int choice =displaymenu();
        choice = chooseUser(choice); //calls addPlayers
        gameRound(choice);
    }

    public static void gameRound(int choice) {
        mafiaController.othersList(players);
        detectiveController.othersList(players);
        healerController.othersList(players);
        commonerController.othersList(players);
        if


    }

    public static int displaymenu() {
        System.out.println("Welcome to Mafia");
        int numberPlayers = safeInput("Enter Number of players:");
        countPlayers(numberPlayers);
        int choice = safeInput("Choose a Character\n" +
                "1) Mafia\n" +
                "2) Detective\n" +
                "3) Healer\n" +
                "4) Commoner\n" +
                "5) Assign Randomly");
        System.out.println("You are Player1.");
        return choice;
    }

    public static int chooseUser(int choice) {
        //tryp
        int count = 1;
        if (choice == 1) {
            Player player1 = new Mafia();
            player1.setUser(1);
            players.put(count++, player1);
            mafiaController.addToList(player1);
            maxMafias -= 1;
            addPlayers();
            maxMafias += 1;
            System.out.print("You are a Mafia."+"All Mafias are: ");
            mafiaController.displayPlayers();
        } else if (choice == 2) {
            Player player1 = new Detective();
            player1.setUser(1);
            players.put(count++, player1);
            detectiveController.addToList(player1);
            maxDetectives -= 1;
            addPlayers();
            maxDetectives += 1;
            System.out.print("You are a Detective."+"All Detectives are :");
            detectiveController.displayPlayers();
        } else if (choice == 3) {
            Player player1 = new Healer();
            player1.setUser(1);
            players.put(count++, player1);
            healerController.addToList(player1);
            maxHealers -= 1;
            addPlayers();
            maxHealers += 1;
            System.out.print("You are a Healer."+"All Healers are:");
            healerController.displayPlayers();
        } else if (choice == 4) {
            Player player1 = new Commoner();
            player1.setUser(1);
            players.put(count++, player1);
            maxCommoners -= 1;
            addPlayers();
            maxCommoners += 1;
            System.out.print("You are a Commoner.");
        } else if (choice == 5) {
            Random selector = new Random();
            int randomChoice = (int) selector.nextInt(4 - 1) + 1;
            chooseUser(randomChoice);
            return randomChoice;
        }
        return choice;
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
        int count = 2;
        for (int i = 0; i < maxMafias; i++) {
            Player player = new Mafia();
            players.put(count++, player);
            mafiaController.addToList(player);
//            System.out.println("m");
        }
        for (int i = 0; i < maxDetectives; i++) {
            Player player = new Detective();
            players.put(count++, player);
            detectiveController.addToList(player);

//            System.out.println("d");

        }
        for (int i = 0; i < maxHealers; i++) {
            Player player = new Healer();
            players.put(count++, player);
            healerController.addToList(player);

//            System.out.println("h");

        }
        for (int i = 0; i < maxCommoners; i++) {
            Player player = new Commoner();
            players.put(count++, player);
            commonerController.addToList(player);
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

