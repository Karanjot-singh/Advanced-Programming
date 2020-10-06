package assignment3;

import java.util.HashMap;
import java.util.Map;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

//you must use OOP concepts, especially inheritance and polymorphism, ​ demonstration of object
//        comparison, and object equality check​ .

public class Assignment3 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Game newGame = new Game();
    }
}

abstract class Player {
    protected HashMap<Integer, Player> players;
    protected int hp, playerType;
    protected int user;
    protected int id;
    public static Scanner sc;

    abstract public int fetchInput(Controller<? extends Player> controller,String input, String exception);

    public Player() {
        players = new HashMap<>();
        sc=new Scanner(System.in);
    }

    @Override
    public String toString() {
        return "Player"+ this.id+" " ;
    }

    @Override
    public boolean equals(Object o1) {
        if (o1 != null && getClass() == o1.getClass()) {
            Player o = (Player) o1; //type casting
            return (id == o.id);
        } else {
            return false;
        }
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

    public int getPlayerType() {
        return playerType;
    }

    public void setPlayerType(int playerType) {
        this.playerType = playerType;
    }
}

class Mafia extends Player {
    @Override
    public int fetchInput(Controller<? extends Player> controller,String input, String exception) {
        int value;
        while (true) {
            try {
                System.out.println(input);
                value = Integer.parseInt(sc.next());
                if (controller.checkInput(value))
                    break;
                else
                    System.out.println(exception);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. \nPlease Try Again.");
            }
        }
        return value;
    }

    public Mafia() {
        this.hp = 2500;
        this.playerType = 1;
    }

}

class Healer extends Player {
    @Override
    public int fetchInput(Controller<? extends Player> controller,String input, String exception) {
        int value;
        while (true) {
            try {
                System.out.println(input);
                value = Integer.parseInt(sc.next());
                if (controller.checkInput(value))
                    break;
                else
                    System.out.println(exception);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. \nPlease Try Again.");

            }
        }
        return value;
    }

    public Healer() {
        this.hp = 800;
        this.playerType = 3;
    }
}

class Commoner extends Player {
    @Override
    public int fetchInput(Controller<? extends Player> controller,String input, String exception) {
        return 0;
    }

    public Commoner() {
        this.hp = 1000;
        this.playerType = 4;

    }
}

class Detective extends Player {
    @Override
    public int fetchInput(Controller<? extends Player> controller,String input, String exception) {
        int value;
        while (true) {
            try {
                System.out.println("Choose a player to test: ");
                value = Integer.parseInt(sc.next());
                if (controller.checkInput(value))
                    break;
                else
                    System.out.println("You cannot test a detective.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. \nPlease Try Again.");
            }
        }
        return value;
    }

    public Detective() {
        this.hp = 800;
        this.playerType = 2;

    }
}