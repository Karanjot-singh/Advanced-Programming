package assignment3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Controller<T1> {
    private int count;
    private HashMap<Integer, Player> players;
    private HashMap<Integer, Player> others;
    public static Random selector;

    public Controller() {
        this.count = 1;
        players = new HashMap<>();
        others = new HashMap<>();
        selector = new Random();
    }

    public int killTarget(int target) {

        //ret -1 if not able to kill
        return 0;
    }

    public void removeFromList(int key) {
        players.remove(key);
    }

    public int getRandom(String message) {
        System.out.println(message);
        ArrayList<Integer> temp = new ArrayList<>(others.keySet());
        int rand = temp.get(selector.nextInt(others.size()));
        return rand;
    }

    public boolean checkInput(int value) {
        ArrayList<Integer> temp = new ArrayList<>(players.keySet());
        for (int i : temp
        ) {
            if (i == value)
                return false;
        }
        return true;
    }

    public int getRandomAll(String message, HashMap<Integer, Player> players1) {
        System.out.println(message);
        ArrayList<Integer> temp = new ArrayList<>(players1.keySet());
        int rand = temp.get(selector.nextInt(players1.size()));
        return rand;
    }

    public void addToList(Player p) {
        try {
            players.put(count, p);

        } catch (NullPointerException e) {
            System.out.println("error");
        }
    }

    public void othersList(HashMap<Integer, Player> all) {
        others.clear();
        others.putAll(players);
        others.putAll(all);

        for (Integer a : players.keySet()) {
            if (all.containsKey(a)) {
                others.remove(a);
            }
        }

    }

    public void clearOthers() {

    }

    public void displayList(HashMap<Integer, Player> map) {
        System.out.println("");
        for (Map.Entry m : map.entrySet()) {
            Integer id = (Integer) m.getKey();
            System.out.print("Player" + id + " ");
        }
    }

    public void displayPlayers() {
        System.out.println("");
        for (Map.Entry m : players.entrySet()) {
            Integer id = (Integer) m.getKey();
            System.out.print("Player" + id + " ");
        }
    }

}
