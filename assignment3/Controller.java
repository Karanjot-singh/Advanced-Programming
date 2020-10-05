package assignment3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Controller<T extends Player> {
    private HashMap<Integer, T> players;
    private HashMap<Integer, T> others;
    private HashMap<Integer, T> original;
    public static Random selector;

    public Controller() {
        players = new HashMap<>();
        others = new HashMap<>();
        original = new HashMap<>();
        selector = new Random();
    }

    private void mafiaDamage(int targetHp,int count) {
        int damage = targetHp / count;

        if (count > 1) {
            for (Map.Entry<Integer, T> m : players.entrySet()) {
                Object p = m.getValue();
                int hp = ((Player) p).getHp();
                if (hp <damage){
                    int temp = damage-hp;
                    ((Player) p).setHp(0);
                    count--;
                    damage+= temp/count;
                }
            }
            for (Map.Entry<Integer, T> m : players.entrySet()) {
                Object p = m.getValue();
                int hp = ((Player) p).getHp();
                if(hp>0)
                    ((Player) p).setHp(hp-damage);
            }
        }
    }

    public int killTarget(int target, int count) {
        //Generic
        //ret -1 if not able to kill
        System.out.println("Mafias have chosen their target.");
        int hpSum = 0;
        for (Map.Entry<Integer, T> m : players.entrySet()) {
            Object p = m.getValue();
            hpSum += ((Player) p).getHp();
            try {
                Player selected = others.get(target);
                if (hpSum >= selected.getHp()) {
                    others.get(target).setHp(0);
                    mafiaDamage(target, count);
                    return target;
                } else {
                    selected.setHp(selected.getHp() - hpSum);
                    mafiaDamage(target, count);
                    return -1;
                }
            }
            catch(NullPointerException e){}

            }
        return -1;
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
    public int getRandomVotes( HashMap<Integer, Player> players) {
        HashMap<Integer, Player> players1= (HashMap<Integer, Player>) players.clone();
        players1.put(0,null);
        ArrayList<Integer> temp = new ArrayList<>(players1.keySet());
        int rand = temp.get(selector.nextInt(players1.size()));
        return rand;
    }

    public void addToList(int count ,Player p) {
        try {
            players.put(count, (T) p);
            players.put(count, (T) p);


        } catch (NullPointerException e) {
            System.out.println("error");
        }
    }

    public void othersList(HashMap<Integer, Player> all) {
        others.clear();
        others.putAll(players);
        others.putAll((HashMap<Integer, T>) all);

        for (Integer a : players.keySet()) {
            if (all.containsKey(a)) {
                others.remove(a);
            }
        }

    }

    public void displayPlayers() {
        for (Map.Entry<Integer, T> m : players.entrySet()) {
            Player p = m.getValue();
            p.id= m.getKey();
            System.out.print(p.toString());
        }
        System.out.println();
    }
    public void showResults(String message){
        for (Map.Entry<Integer, T> m : original.entrySet()) {
            Player p = m.getValue();
            System.out.print(message);
            System.out.print(" "+p.toString());
        }
        System.out.println();

    }

}
