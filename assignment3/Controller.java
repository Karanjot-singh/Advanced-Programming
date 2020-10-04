package assignment3;

import java.util.HashMap;
import java.util.Map;

public class Controller<T1> {
    private HashMap<Integer,Player> playerList;

    public Controller() {
    }

    protected void displayPreviousOrders() {
        System.out.println("");
        for (Map.Entry m : players.entrySet()) {
            Player order = (Player) m.getValue();
            System.out.println();
        }
    }
    public void displayPlayers(){
        for (Map.Entry m : playerList.entrySet()) {
            Player type = (Player) m.getKey();
            System.out.println();
        }

    }

    public HashMap getPlayerList() {
        return playerList;
    }

    public void setPlayerList(HashMap playerList) {
        this.playerList = playerList;
    }
}
