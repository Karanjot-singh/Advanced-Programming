package assignment3;

import java.util.*;


public class Assignment3 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Game newGame = new Game();
    }
}

class Game {

    public static Scanner sc = new Scanner(System.in);
    protected static HashMap<Integer, Player> players = new HashMap<Integer, Player>();

    public static void addPlayers(int choice) {
//        N/5 Mafias, N/5 Detectives, max {1,
//                N/10}
    }

    public static void chooseUser(int choice) {
        int count = 0;
        if (choice == 1) {
            Player player1 = new Mafia();
            players.put(++count, player1);
            addPlayers(choice);
        } else if (choice == 2) {
            Player player1 = new Detective();
            players.put(++count, player1);
            addPlayers(choice);
        } else if (choice == 3) {
            Player player1 = new Healer();
            players.put(++count, player1);
            addPlayers(choice);
        } else if (choice == 4) {
            Player player1 = new Commoner();
            players.put(++count, player1);
            addPlayers(choice);
        } else if (choice == 5) {
            Random selector = new Random();
            int randomChoice = (int) selector.nextInt(4 - 1) + 1;
            chooseUser(randomChoice);
        }
    }
        public static void displayMenu () {
            System.out.println("Welcome to Mafia");
            int numberPlayers, loop;
            loop = 1;
            while (loop == 1) {
                try {
                    System.out.println("Enter Number of players:\n");
                    numberPlayers = sc.nextInt();
                    loop = 0;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. \nPlease Try Again.");
                }
            }

            System.out.println("Choose a Character\n" +
                    "1) Mafia\n" +
                    "2) Detective\n" +
                    "3) Healer\n" +
                    "4) Commoner\n" +
                    "5) Assign Randomly");
            int choice;
            loop = 1;
            while (loop == 1) {
                try {
                    choice = sc.nextInt();
                    chooseUser(choice);
                    loop = 0;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. \nPlease Try Again.");
                }
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



