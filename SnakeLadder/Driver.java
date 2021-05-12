package lld.snakeladder;

import java.util.ArrayList;
import java.util.List;

public class Driver {

    public static void main(String[] args) {
        List<Snake> snakeList = new ArrayList<>();
        snakeList.add(new Snake(99,78));
        snakeList.add(new Snake(96,65));
        snakeList.add(new Snake(94,48));
        snakeList.add(new Snake(90,49));
        snakeList.add(new Snake(81,63));
        snakeList.add(new Snake(66,47));
        snakeList.add(new Snake(57,19));
        snakeList.add(new Snake(43,22));
        snakeList.add(new Snake(36,14));
        snakeList.add(new Snake(11,9));
        List<Ladder> ladderList = new ArrayList<>();
        ladderList.add(new Ladder(84,98));
        ladderList.add(new Ladder(69,93));
        ladderList.add(new Ladder(71,92));
        ladderList.add(new Ladder(64,85));
        ladderList.add(new Ladder(52,68));
        ladderList.add(new Ladder(44,80));
        ladderList.add(new Ladder(39,60));
        ladderList.add(new Ladder(28,46));
        ladderList.add(new Ladder(8,51));
        ladderList.add(new Ladder(4,26));
        List<Players> players = new ArrayList<>();
        players.add(new Players("Ravi","1"));
        players.add(new Players("Deepu","2"));
        players.add(new Players("Kiran","3"));
        players.add(new Players("Vishal","4"));
        SnakeLadderService service = new SnakeLadderService();
        service.setLadder(ladderList);
        service.setSnake(snakeList);
        service.setPlayers(players);
        service.startGame();
    }
}
