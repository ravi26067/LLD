package lld.snakeladder;

import java.util.List;
import java.util.Map;

public class SnakeLadderBoard {

    private List<Ladder> ladder;

    private List<Snake> snakes;

    private int size;

    private Map<String,Integer> playerPos;

    public SnakeLadderBoard(int size) {
        this.size = size;
    }

    public SnakeLadderBoard(Map<String, Integer> playerPos) {
        this.playerPos = playerPos;
    }

    public SnakeLadderBoard(List<Ladder> ladder, List<Snake> snakes, int size, Map<String, Integer> playerPos) {
        this.ladder = ladder;
        this.snakes = snakes;
        this.size = size;
        this.playerPos = playerPos;
    }

    public List<Ladder> getLadder() {
        return ladder;
    }

    public void setLadder(List<Ladder> ladder) {
        this.ladder = ladder;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Map<String, Integer> getPlayerPos() {
        return playerPos;
    }

    public void setPlayerPos(Map<String, Integer> playerPos) {
        this.playerPos = playerPos;
    }
}
