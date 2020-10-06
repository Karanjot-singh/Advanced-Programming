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
    private static int flag;
    private static Controller<Mafia> mafiaController;
    private static Controller<Detective> detectiveController;
    private static Controller<Healer> healerController;
    private static Controller<Commoner> commonerController;

    Game() {
        mafiaController = new Controller<Mafia>();
        detectiveController = new Controller<Detective>();
        healerController = new Controller<Healer>();
        commonerController = new Controller<Commoner>();
        flag = 1;
        int choice = displaymenu();
        choice = chooseUser(choice); //calls addPlayers
        gameRound(choice);
    }

    public static int getChoice(int choice, String input, String exception) {
        Controller<? extends Player> newControl = returnController(choice);
        Player user = players.get(1);
        int inputValue = user.fetchInput(newControl, input, exception);
        return inputValue;
    }

    public static void results(int status) {
        if (status == 1)
            System.out.println("Game Over.\nThe Mafias have won.");
        else
            System.out.println("Game Over.\nThe Mafias have lost.");
        mafiaController.showResults("The Mafias were: ");
        detectiveController.showResults("The Detectives were: ");
        healerController.showResults("The Healers were: ");
        commonerController.showResults("The Commoners were: ");
    }

    public static void gameRound(int choice) {
        int count = 0;
        boolean game = true;
        while (game) {
            System.out.println("number of" + numberPlayers + " M" + maxMafias + " D" + maxDetectives + " H" + maxHealers + " C" + maxCommoners);

            System.out.println("Round " + ++count);
            System.out.print(numberPlayers + " Players remaining: ");
            displayAlive();
            System.out.println(" are Alive.");
            mafiaController.othersList(players);
            detectiveController.othersList(players);
            healerController.othersList(players);
            commonerController.othersList(players);
            int mafiaChoice, detectiveChoice, userChoice, healerChoice;
            if (maxMafias >= maxCommoners + maxHealers + maxDetectives) {
                results(1);
                game = false;
            } else if (maxMafias <= 0) {
                results(0);
                game = false;
            }
            // User condition
            if (flag == 0) {
                mafiaChoice = mafiaController.getRandom("");
                int target = mafiaController.killTarget(mafiaChoice, maxMafias);
                detectiveChoice = detectiveController.getRandom("Detectives have chosen a player to test.");
                healerChoice = healerController.getRandomAll("Healers have chosen someone to heal.", players);
                heal(healerChoice);
                System.out.println("--End of actions--");
                eliminatePlayer(target, healerChoice);
                votingProcess(detectiveChoice);

            } else if (choice == 1) {
                userChoice = getChoice(1, "Choose the target: ", "Mafia can't be chosen Target");
                int target = mafiaController.killTarget(userChoice, maxMafias);
                detectiveChoice = detectiveController.getRandom("Detectives have chosen a player to test.");
                healerChoice = healerController.getRandomAll("Healers have chosen someone to heal.", players);
                heal(healerChoice);
                System.out.println("--End of actions--");
                eliminatePlayer(target, healerChoice);
                //test if player is mafia
                votingProcess(detectiveChoice);
            } else if (choice == 2) {
                userChoice = getChoice(1, "Choose a player to test: ", "You cannot test a detective.");
                mafiaChoice = mafiaController.getRandom("");
                int target = mafiaController.killTarget(mafiaChoice, maxMafias);
                detectiveChoice = userChoice;
                checkMafia(detectiveChoice);
                healerChoice = healerController.getRandomAll("Healers have chosen someone to heal.", players);
                heal(healerChoice);
                System.out.println("--End of actions--");
                eliminatePlayer(target, healerChoice);
                votingProcess(detectiveChoice);
            } else if (choice == 3) {
                userChoice = getChoice(1, "Choose a player to heal: ", "");
                mafiaChoice = mafiaController.getRandom("");
                int target = mafiaController.killTarget(mafiaChoice, maxMafias);
                detectiveChoice = detectiveController.getRandom("Detectives have chosen a player to test.");
                healerChoice = userChoice;
                heal(healerChoice);
                System.out.println("--End of actions--");
                eliminatePlayer(target, healerChoice);
                votingProcess(detectiveChoice);
            }
            System.out.println("--End of Round " + count + "--");
        }
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
        if (choice == 1) {
            Player player1 = new Mafia();
            player1.setUser(1);
            players.put(1, player1);
            mafiaController.addToList(1, player1);
            maxMafias -= 1;
            addPlayers();
            maxMafias += 1;
            System.out.print("You are a Mafia." + "All Mafias are: ");
            mafiaController.displayPlayers();
        } else if (choice == 2) {
            Player player1 = new Detective();
            player1.setUser(1);
            players.put(1, player1);
            detectiveController.addToList(1, player1);
            maxDetectives -= 1;
            addPlayers();
            maxDetectives += 1;
            System.out.print("You are a Detective." + "All Detectives are :");
            detectiveController.displayPlayers();
        } else if (choice == 3) {
            Player player1 = new Healer();
            player1.setUser(1);
            players.put(1, player1);
            healerController.addToList(1, player1);
            maxHealers -= 1;
            addPlayers();
            maxHealers += 1;
            System.out.print("You are a Healer." + "All Healers are:");
            healerController.displayPlayers();
        } else if (choice == 4) {
            Player player1 = new Commoner();
            player1.setUser(1);
            players.put(1, player1);
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

    public static void checkMafia(int detectiveChoice) {
        if (mafiaController.checkInput(detectiveChoice)) {
            System.out.println("Player" + detectiveChoice + " is a Mafia.");
        } else
            System.out.println("Player" + detectiveChoice + " is not a Mafia.");

    }

    public static void votingProcess(int detectiveChoice) {
        if (!mafiaController.checkInput(detectiveChoice)) {
            System.out.println("Player" + detectiveChoice + " has been voted out.");
            removeValues(detectiveChoice);
            checkUserAlive(detectiveChoice);
        } else {
            while (true) {
                int voteOut = healerController.getRandomVotes(players);
                if (voteOut != 0) {
                    System.out.println("Player" + voteOut + " has been voted out.");
                    removeValues(voteOut);
                    checkUserAlive(voteOut);
                    break;
                } else
                    System.out.println("Voting Tied. Voting process re-initiated");
            }
        }
    }

    public static void heal(int healerChoice) {
        int hp = players.get(healerChoice).getHp() + 500;
        players.get(healerChoice).setHp(hp);
        System.out.println("heal " + healerChoice + " " + hp);
    }

    public static void eliminatePlayer(int target, int healerChoice) {
        //Target returns -1 if player hp > combined mafia hp
        if (target == -1 || players.get(target) == players.get(healerChoice)) {
            System.out.println("No one died.");

        } else {
            System.out.println("Player" + target + " has died.");
            removeValues(target);
            checkUserAlive(target);
        }
    }

    public static void removeValues(int target) {
        int type = players.get(target).getPlayerType();
        Controller<? extends Player> newControl = returnController(type);
        newControl.removeFromList(target);
        players.remove(target);
        updatePlayerCount(type);
        numberPlayers--;
    }

    public static void displayAlive() {
        for (Map.Entry m : players.entrySet()) {
            Integer id = (Integer) m.getKey();
            System.out.print("Player" + id + " ");
        }
    }

    public static void updatePlayerCount(int playerType) {
        if (playerType == 1)
            maxMafias--;
        else if (playerType == 2)
            maxDetectives--;
        else if (playerType == 3)
            maxHealers--;
        else
            maxCommoners--;
    }

    public static Controller<? extends Player> returnController(int playerType) {
        if (playerType == 1)
            return mafiaController;
        else if (playerType == 2)
            return detectiveController;
        else if (playerType == 3)
            return healerController;
        else
            return commonerController;
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
        ArrayList<Integer> allocateId = new ArrayList<>();
        Random selector = new Random();
        for (int i = 2; i <= numberPlayers; i++) {
            allocateId.add(i);
        }
        Collections.shuffle(allocateId);
        int index;
        int ct=0;
        for (int i = 0; i < maxMafias; i++) {
            index = allocateId.get(ct);
            ct++;
            Player player = new Mafia();
            System.out.println("index=" + index);
            players.put(index, player);
            mafiaController.addToList(index, player);
        }
        for (int i = 0; i < maxDetectives; i++) {
            index = allocateId.get(ct);
            ct++;
            Player player = new Detective();
            System.out.println("index=" + index);
            players.put(index, player);
            detectiveController.addToList(index, player);
        }
        for (int i = 0; i < maxHealers; i++) {
            index = allocateId.get(ct);
            ct++;
            Player player = new Healer();
            System.out.println("index=" + index);
            players.put(index, player);
            healerController.addToList(index, player);
        }
        for (int i = 0; i < maxCommoners; i++) {
            index = allocateId.get(ct);
            ct++;
            Player player = new Commoner();
            System.out.println("index=" + index);
            players.put(index, player);
            commonerController.addToList(index, player);
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

    public static void checkUserAlive(int removed) {
        if (removed == 1) {
            flag = 0;
        }
    }

}

