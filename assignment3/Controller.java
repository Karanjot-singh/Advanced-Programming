package assignment3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Controller<T extends Player> {
    private final HashMap<Integer, T> players;
    private final HashMap<Integer, T> others;
    private final HashMap<Integer, T> original;
    public final static Random selector = new Random();

    public Controller() {
        players = new HashMap<>();
        others = new HashMap<>();
        original = new HashMap<>();
    }

    private void mafiaDamage(int targetHp, int count) {
        int damage = targetHp / count;

        if (count > 1) {
            for (Map.Entry<Integer, T> m : players.entrySet()) {
                Player p = m.getValue();
                int hp = p.getHp();
                if (hp < damage) {
                    int temp = damage - hp;
                    p.setHp(0);
                    count--;
                    damage += temp / count;
                }
            }
            for (Map.Entry<Integer, T> m : players.entrySet()) {
                Player p = m.getValue();
                int hp = p.getHp();
                if (hp > 0)
                    p.setHp(hp - damage);
            }
        }
    }

    public int killTarget(int target, int count) {
        //Generic
        //ret -1 if not able to kill
        System.out.println("Mafias have chosen their target.");
        int hpSum = 0;
        for (Map.Entry<Integer, T> m : players.entrySet()) {
            Player p = m.getValue();
            hpSum += p.getHp();
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
            } catch (NullPointerException ignored) {
            }

        }
        return -1;
    }

    public void removeFromList(int key) {
        players.remove(key);
    }

    public int getRandom(String message) {
        System.out.println(message);
        ArrayList<Integer> temp = new ArrayList<>(others.keySet());
        return temp.get(selector.nextInt(others.size()));
    }

    public boolean checkInput(int value) {
        ArrayList<Integer> temp = new ArrayList<>(players.keySet());
        for (int i : temp
        ) {
//            System.out.print("Test " + i + " ");
            if (i == value)
                return false;
        }
        return true;
    }

    public boolean validInput(int value) {
        //healercontroller
        ArrayList<Integer> temp = new ArrayList<>(others.keySet());
        for (int i : temp
        ) {
            if (i == value)
                return true;
        }
        return false;
    }

    public int getRandomAll(String message, HashMap<Integer, Player> players1) {
        System.out.println(message);
        ArrayList<Integer> temp = new ArrayList<>(players1.keySet());
        return temp.get(selector.nextInt(players1.size()));
    }

    public int getRandomVotes(HashMap<Integer, Player> players) {
        HashMap<Integer, Player> players1 = (HashMap<Integer, Player>) players.clone();
        players1.put(0, null);
        ArrayList<Integer> temp = new ArrayList<>(players1.keySet());
        int rand = temp.get(selector.nextInt(players1.size()));
        return rand;
    }

    public void addToList(int index, Player p) {
        try {
            players.put(index, (T) p);
            original.put(index, (T) p);

        } catch (NullPointerException e) {
            System.out.println("error");
        }
    }

    public void temp() {

        specialVote();
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
            System.out.print(p.toString());
        }
        System.out.println();
    }

    public void showResults(String message) {
        System.out.print(message);
        for (Map.Entry<Integer, T> m : original.entrySet()) {
            Player p = m.getValue();
            System.out.print(" " + p.toString());
        }
        System.out.println();

    }

    public void specialVote() {
        for (Map.Entry<Integer, T> m : players.entrySet()) {
            Player p = m.getValue();
            players.get(1).compareTo(p);
            getRandomVotes((HashMap<Integer, Player>) players);
        }

    }

}
