package midsem;

public class q1 {
    public static void main(String args[]) {

    }
}

class Tournament {

}

class Game {
    private int ho;
    public void hello(){}


}

class Player extends Game {
    @Override
    public void hello(){}

    private int ranking;
    private float prize;

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public float getPrize() {
        return prize;
    }

    public void setPrize(float prize) {
        this.prize = prize;
    }

    Player(int ranking, float prize) {
        this.ranking = ranking;
        this.prize = prize;
        Game g = new Game();
    }


}
