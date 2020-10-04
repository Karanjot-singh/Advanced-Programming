package assignment3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controller<T1> {
    private int count=1;
    private HashMap<Integer, Player> players;

    public Controller() {
    }
    public void addToList(Player p){
        players.put(count,p);
    }

    public void displayPlayers() {
        System.out.println("");
        for (Map.Entry m : players.entrySet()) {
            Integer id = (Integer) m.getKey();
            System.out.println("Player"+id);
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
