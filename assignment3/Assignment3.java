package assignment3;

import java.util.HashMap;
import java.util.Map;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


public class Assignment3 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Game newGame = new Game();
    }
}

class Game {
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
        int numberPlayers = 0;
        System.out.println("Enter Number of players:");
        numberPlayers = sc.nextInt();
        countPlayers(numberPlayers);
        System.out.println("Choose a Character\n" +
                "1) Mafia\n" +
                "2) Detective\n" +
                "3) Healer\n" +
                "4) Commoner\n" +
                "5) Assign Randomly");
        int choice;
        choice = sc.nextInt();


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


}

abstract class Player {
    protected HashMap<Integer, Player> players = new HashMap<Integer, Player>();
    protected int hp;
    protected int user;

    protected void displayPreviousOrders() {
        System.out.println("");
        for (Map.Entry m : players.entrySet()) {
            Player order = (Player) m.getValue();
            System.out.println();
        }
    }

    public Player() {
    }

    public void randomSelector() {
        Random selector = new Random();
        int randomPlayer = selector.nextInt(players.size());


    }

    public HashMap<Integer, Player> getPlayers() {
        return players;
    }

    public void setPlayers(HashMap<Integer, Player> players) {
        this.players = players;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
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



