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

abstract class Player {
    protected HashMap<Integer, Player> players = new HashMap<Integer, Player>();
    protected int hp;
    protected int user;

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
        this.hp = 2500;
    }
}

class Healer extends Player {
    public Healer() {
        this.hp = 800;
    }
}

class Commoner extends Player {
    public Commoner() {
        this.hp = 1000;
    }
}

class Detective extends Player {
    public Detective() {
        this.hp = 800;
    }
}




