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
    protected HashMap<Integer, Player> players = new HashMap<Integer, Player>();
    protected int hp,playerType;
    protected int user;
    protected int id;

    public Player() {
    }

    @Override
    public boolean equals(Object o1) {
        if (o1 != null && getClass() == o1.getClass()) {
            Player o = (Player) o1; //type casting
            return (id == o.id );
        } else {
            return false;
        }
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

    public int getPlayerType() {
        return playerType;
    }

    public void setPlayerType(int playerType) {
        this.playerType = playerType;
    }
}

class Mafia extends Player {
    public Mafia() {
        this.hp = 2500;
        this.playerType=1;
    }
}

class Healer extends Player {
    public Healer() {
        this.hp = 800;
        this.playerType=3;

    }
}

class Commoner extends Player {
    public Commoner() {
        this.hp = 1000;
        this.playerType=4;

    }
}

class Detective extends Player {
    public Detective() {
        this.hp = 800;
        this.playerType=2;

    }
}




