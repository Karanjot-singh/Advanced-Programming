package assignment3;

import java.util.*;

public class Game implements SafeInput {
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

    public static int getChoice(int choice) {
        Player user = players.get(1);
        int inputValue;
        if (choice == 1)
            inputValue = user.fetchInput(mafiaController);
        else if (choice == 2)
            inputValue = user.fetchInput(detectiveController);
        else if (choice == 3)
            inputValue = user.fetchInput(healerController);
        else
            inputValue = user.fetchInput(commonerController);
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
        while (true) {
            //Game End Conditions
            if (maxMafias >= maxCommoners + maxHealers + maxDetectives) {
                results(1);
                break;
            } else if (maxMafias <= 0) {
                results(0);
                break;
            }
            System.out.println("number of" + numberPlayers + " M" + maxMafias + " D" + maxDetectives + " H" + maxHealers + " C" + maxCommoners);
            System.out.println("--Round " + ++count + "--");
            System.out.print(numberPlayers + " Players remaining: ");
            displayAlive();
            System.out.println(" are Alive.");
            mafiaController.othersList(players);
            detectiveController.othersList(players);
            healerController.othersList(players);
            commonerController.othersList(players);
            int mafiaChoice, detectiveChoice, userChoice, healerChoice;
            // User condition
            if (flag == 0) {
                mafiaChoice = mafiaController.getRandom("");
                int target = mafiaController.killTarget(mafiaChoice, maxMafias);
                detectiveChoice = detectiveController.getRandom("Detectives have chosen a player to test.");
                healerChoice = healerController.getRandomAll("Healers have chosen someone to heal.", players);
                heal(healerChoice,maxHealers);
                boolean check = checkMafia(detectiveChoice,choice);
                if(maxDetectives==0)
                    check=false;
                System.out.println("mc " + mafiaChoice + " dc " + detectiveChoice + " hc " + healerChoice);
                System.out.println("--End of actions--");
                eliminatePlayer(target, healerChoice);
                votingProcess(detectiveChoice, check);

            } else if (choice == 1) {
                userChoice = getChoice(1);
                mafiaChoice = userChoice;
                int target = mafiaController.killTarget(mafiaChoice, maxMafias);
                detectiveChoice = detectiveController.getRandom("Detectives have chosen a player to test.");
                boolean check = checkMafia(detectiveChoice,choice);
                if(maxDetectives==0)
                    check=false;
                healerChoice = healerController.getRandomAll("Healers have chosen someone to heal.", players);
                heal(healerChoice,maxHealers);
                System.out.println("mc " + mafiaChoice + " dc " + detectiveChoice + " hc " + healerChoice);
                System.out.println("--End of actions--");
                eliminatePlayer(target, healerChoice);
                //test if player is mafia
                votingProcess(detectiveChoice, check);
            } else if (choice == 2) {
                mafiaChoice = mafiaController.getRandom("");
                int target = mafiaController.killTarget(mafiaChoice, maxMafias);
                userChoice = getChoice(2);
                detectiveChoice = userChoice;
                boolean check = checkMafia(detectiveChoice,choice);
                healerChoice = healerController.getRandomAll("Healers have chosen someone to heal.", players);
                heal(healerChoice,maxHealers);
                System.out.println("mc " + mafiaChoice + " dc " + detectiveChoice + " hc " + healerChoice);
                System.out.println("--End of actions--");
                eliminatePlayer(target, healerChoice);
                votingProcess(detectiveChoice, check);
            } else if (choice == 3) {
                mafiaChoice = mafiaController.getRandom("");
                int target = mafiaController.killTarget(mafiaChoice, maxMafias);
                detectiveChoice = detectiveController.getRandom("Detectives have chosen a player to test.");
                boolean check = checkMafia(detectiveChoice,choice);
                if(maxDetectives==0)
                    check=false;
                userChoice = getChoice(3);
                healerChoice = userChoice;
                heal(healerChoice,maxHealers);
                System.out.println("mc " + mafiaChoice + " dc " + detectiveChoice + " hc " + healerChoice);
                System.out.println("--End of actions--");
                eliminatePlayer(target, healerChoice);
                votingProcess(detectiveChoice, check);
            }
            System.out.println("--End of Round " + count + "--");
        }
    }

    public static int displaymenu() {
        System.out.println("Welcome to Mafia");
        int numberPlayers = SafeInput.safeInput("Enter Number of players:");
        countPlayers(numberPlayers);
        int choice = SafeInput.safeInput("Choose a Character\n" +
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
            Player player1 = new Mafia(1);
            player1.setUser(1);
            players.put(1, player1);
            mafiaController.addToList(1, player1);
            maxMafias -= 1;
            addPlayers();
            maxMafias += 1;
            System.out.print("You are a Mafia." + "All Mafias are: ");
            mafiaController.displayPlayers();
        } else if (choice == 2) {
            Player player1 = new Detective(1);
            player1.setUser(1);
            players.put(1, player1);
            detectiveController.addToList(1, player1);
            maxDetectives -= 1;
            addPlayers();
            maxDetectives += 1;
            System.out.print("You are a Detective." + "All Detectives are :");
            detectiveController.displayPlayers();
        } else if (choice == 3) {
            Player player1 = new Healer(1);
            player1.setUser(1);
            players.put(1, player1);
            healerController.addToList(1, player1);
            maxHealers -= 1;
            addPlayers();
            maxHealers += 1;
            System.out.print("You are a Healer." + "All Healers are:");
            healerController.displayPlayers();
        } else if (choice == 4) {
            Player player1 = new Commoner(1);
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

    public static boolean checkMafia(int detectiveChoice, int choice) {
        System.out.println("Check mafia " + detectiveChoice);
        if (!mafiaController.checkInput(detectiveChoice)) {
            if (choice == 2)
                System.out.println("Player" + detectiveChoice + " is a Mafia.");
            return true;
        } else {
            if (choice == 2)
                System.out.println("Player" + detectiveChoice + " is not a Mafia.");
            return false;
        }
    }

    public static void votingProcess(int detectiveChoice, boolean mafiaCaught) {
        int voteUser = SafeInput.safeInput("Select a person to vote out: ");
        if (mafiaCaught) {
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

    public static void heal(int healerChoice , int maxHealers) {
        if(maxHealers>0) {
            int hp = players.get(healerChoice).getHp() + 500;
            players.get(healerChoice).setHp(hp);
            System.out.println("heal " + healerChoice + " " + hp);
        }
    }

    public static void eliminatePlayer(int target, int healerChoice) {
        //Target returns -1 if player hp > combined mafia hp
        if (target == -1 || players.get(target).equals(players.get(healerChoice))) {
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
        int ct = 0;
        for (int i = 0; i < maxMafias; i++) {
            index = allocateId.get(ct);
            ct++;
            Player player = new Mafia(index);
//            System.out.println("index=" + index);
            players.put(index, player);
            mafiaController.addToList(index, player);
        }
        for (int i = 0; i < maxDetectives; i++) {
            index = allocateId.get(ct);
            ct++;
            Player player = new Detective(index);
//            System.out.println("index=" + index);
            players.put(index, player);
            detectiveController.addToList(index, player);
        }
        for (int i = 0; i < maxHealers; i++) {
            index = allocateId.get(ct);
            ct++;
            Player player = new Healer(index);
//            System.out.println("index=" + index);
            players.put(index, player);
            healerController.addToList(index, player);
        }
        for (int i = 0; i < maxCommoners; i++) {
            index = allocateId.get(ct);
            ct++;
            Player player = new Commoner(index);
//            System.out.println("index=" + index);
            players.put(index, player);
            commonerController.addToList(index, player);
        }
    }

    public static void checkUserAlive(int removed) {
        if (removed == 1) {
            flag = 0;
        }
    }

}

