package assignment3;

import java.util.*;

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
        int choice = displaymenu();
        choice = chooseUser(choice); //calls addPlayers
        System.out.println("number of"+numberPlayers+" "+maxMafias+" "+maxDetectives+" "+maxHealers+" "+maxCommoners);

        gameRound(choice);
    }

    public static void gameRound(int choice) {
        int count = 0;
        while ((maxMafias < maxCommoners + maxHealers + maxDetectives) && maxMafias != 0) {
            System.out.println("Round " + ++count);

            System.out.print(numberPlayers + " Players remaining: ");
            displayAlive();
            System.out.println(" are Alive.");
            mafiaController.othersList(players);
            detectiveController.othersList(players);
            healerController.othersList(players);
            commonerController.othersList(players);
            int mafiaChoice, detectiveChoice, commonerChoice, healerChoice;
//            if (players.get(1).getHp() == 0 && players.get(1).getPlayerType() != 1) {
//                //User is dead
//
//            }
            if (choice == 1) {
                int value;
                while (true) {
                    try {
                        System.out.println("Choose the target: ");
                        value = Integer.parseInt(sc.next());
                        if (mafiaController.checkInput(value))
                            break;
                        else
                            System.out.println("Mafia can't be chosen Target");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. \nPlease Try Again.");

                    }
                }
                mafiaChoice = value;
                int target = mafiaController.killTarget(mafiaChoice, maxMafias);
                detectiveChoice = detectiveController.getRandom("Detectives have chosen a player to test.");
                healerChoice = healerController.getRandomAll("Healers have chosen someone to heal.", players);
                //Healing process
                int hp = players.get(healerChoice).getHp();
                players.get(healerChoice).setHp(hp + 500);

                System.out.println("--End of actions--");
                //Target returns -1 if player hp > combined mafia hp
                if (target == -1 || players.get(target) == players.get(healerChoice)) {
                    System.out.println("No one died.");

                } else {
                    System.out.println("Player" + target + " has died.");
                    removeValues(target);
                    if (!checkUserAlive(target))
                        choice = 0;
                }
                //vote
                //fix
                //test if player is mafia
                if (!mafiaController.checkInput(detectiveChoice)) {
                    System.out.println("Player" + detectiveChoice + " has been voted out.");
                    removeValues(detectiveChoice);
                    if (!checkUserAlive(detectiveChoice))
                        choice = 0;
                } else {
                    int voteOut = healerController.getRandomAll("", players);
                    System.out.println("Player" + voteOut + " has been voted out.");
                    removeValues(voteOut);
                    if (!checkUserAlive(voteOut))
                        choice = 0;
                }
            }
            System.out.println("--End of Round " + count + "--");
        }
        //        gameOver();

    }

    public static void removeValues(int target) {
//        try {
        int type = players.get(target).getPlayerType();
        Controller<? extends Player> newControl = returnController(type);
        newControl.removeFromList(target);
        players.remove(target);

//        }
//        catch (NullPointerException e){
//            System.out.println("Error");
//        }
    }

    public static int displaymenu() {
        System.out.println("Welcome to Mafia");
        int numberPlayers = safeInput("Enter Number of players:");
        countPlayers(numberPlayers);
        System.out.println("displ of"+numberPlayers+" "+maxMafias+" "+maxDetectives+" "+maxHealers+" "+maxCommoners);

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
            mafiaController.addToList(count,player1);
            maxMafias -= 1;
            addPlayers();
            maxMafias += 1;
            System.out.print("You are a Mafia." + "All Mafias are: ");
            mafiaController.displayPlayers();
        } else if (choice == 2) {
            Player player1 = new Detective();
            player1.setUser(1);
            players.put(count, player1);
            detectiveController.addToList(count,player1);
            maxDetectives -= 1;
            addPlayers();
            maxDetectives += 1;
            System.out.print("You are a Detective." + "All Detectives are :");
            detectiveController.displayPlayers();
        } else if (choice == 3) {
            Player player1 = new Healer();
            player1.setUser(1);
            players.put(count, player1);
            healerController.addToList(count,player1);
            maxHealers -= 1;
            addPlayers();
            maxHealers += 1;
            System.out.print("You are a Healer." + "All Healers are:");
            healerController.displayPlayers();
        } else if (choice == 4) {
            Player player1 = new Commoner();
            player1.setUser(1);
            players.put(count, player1);
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

    public static void displayAlive() {
        for (Map.Entry m : players.entrySet()) {
            Integer id = (Integer) m.getKey();
            System.out.print("Player" + id + " ");
        }
    }

    public static Controller<? extends Player> returnController(int playerType) {
        if (playerType == 1) {
            numberPlayers--;
            maxMafias--;
            return mafiaController;
        } else if (playerType == 2) {
            numberPlayers--;
            maxDetectives--;
            return detectiveController;
        } else if (playerType == 3) {
            numberPlayers--;
            maxHealers--;
            return healerController;
        } else {
            maxCommoners--;
            numberPlayers--;
            return commonerController;
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
        int count = 2;
        for (int i = 0; i < maxMafias; i++) {
            System.out.println("hello"+i);
            Player player = new Mafia();
            players.put(count++, player);
            mafiaController.addToList(count,player);
        }
        for (int i = 0; i < maxDetectives; i++) {
            Player player = new Detective();
            players.put(count++, player);
            detectiveController.addToList(count,player);
        }
        for (int i = 0; i < maxHealers; i++) {
            Player player = new Healer();
            players.put(count++, player);
            healerController.addToList(count,player);

//            System.out.println("h");

        }
        for (int i = 0; i < maxCommoners; i++) {
            Player player = new Commoner();
            players.put(count++, player);
            commonerController.addToList(count,player);
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

    public static boolean checkUserAlive(int removed) {
        return (removed == 1) ? false : true;
    }

}

