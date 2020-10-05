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
    public void killTarget(){

    }
    public int getRandom(String message){
        System.out.println(message);
        ArrayList<Integer> temp = new ArrayList<>(others.keySet());
        int rand = temp.get(selector.nextInt(others.size()));
        return rand;
    }
    public boolean checkInput(int value){
        ArrayList<Integer> temp = new ArrayList<>(players.keySet());
        for (int i: temp
             ) {if(i==value)
                 return false;
        }
        return true;
    }
    public int getRandomAll(String message){
        System.out.println(message);
        ArrayList<Integer> temp = new ArrayList<>(players.keySet());
        int rand = temp.get(selector.nextInt(players.size()));
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

    public void displayPlayers() {
        System.out.println("");
        for (Map.Entry m : players.entrySet()) {
            Integer id = (Integer) m.getKey();
            System.out.print("Player" + id+" ");
        }
    }
//
//    public void displayPlayers() {
//        for (Player p : playerList
//        ) {
//            System.out.println("Player"+p.getId());
//        }
//
//    }

}
