package lld.snakeladder;

import java.util.*;

public class SnakeLadderService {

    private SnakeLadderBoard snakeLadderBoard;

    private int initailPlayers;

    private Queue<Players> players;

    private boolean isGameCompleted;

    public static final int DEFAULT_BORAD_SIZE = 100;

    private boolean shouldContinueTillLast;

    public SnakeLadderService(int boardSize) {
        this.snakeLadderBoard = new SnakeLadderBoard(boardSize);
        this.players = new LinkedList<>();
    }

    public SnakeLadderService(){
        this.snakeLadderBoard = new SnakeLadderBoard(SnakeLadderService.DEFAULT_BORAD_SIZE);
    }

    public SnakeLadderBoard getSnakeLadderBoard() {
        return snakeLadderBoard;
    }

    public void setSnakeLadderBoard(SnakeLadderBoard snakeLadderBoard) {
        this.snakeLadderBoard = snakeLadderBoard;
    }

    public int getInitailPlayers() {
        return initailPlayers;
    }

    public void setInitailPlayers(int initailPlayers) {
        this.initailPlayers = initailPlayers;
    }

    public Queue<Players> getPlayers() {
        return players;
    }

    public boolean isGameCompleted() {
        int currentPlayers = players.size();
        return currentPlayers<initailPlayers;
    }

    public void setGameCompleted(boolean gameCompleted) {
        isGameCompleted = gameCompleted;
    }

    public boolean isShouldContinueTillLast() {
        return shouldContinueTillLast;
    }

    public void setShouldContinueTillLast(boolean shouldContinueTillLast) {
        this.shouldContinueTillLast = shouldContinueTillLast;
    }

    public void setPlayers(List<Players> players) {
        this.players = new LinkedList<>();
        this.initailPlayers = players.size();
        Map<String,Integer> playerPieces = new HashMap<>();
        for(Players player:players){
            this.players.add(player);
            playerPieces.put(player.getUid(),0);
        }
        snakeLadderBoard.setPlayerPos(playerPieces);
    }

    public void setLadder(List<Ladder> ladder){
        this.snakeLadderBoard.setLadder(ladder);
    }

    public void setSnake(List<Snake> snake){
        this.snakeLadderBoard.setSnakes(snake);
    }


    private int getPosAfterSnakesLadder(int newPos){
        List<Ladder> ladders = snakeLadderBoard.getLadder();
        List<Snake> snakes = snakeLadderBoard.getSnakes();

        for(Ladder ladder:ladders){
            if(newPos==ladder.getStart())
                newPos = ladder.getEnd();
        }
        for(Snake snake:snakes){
            if(newPos==snake.getStart())
                newPos = snake.getEnd();
        }
        return newPos;
    }

    public void movePlayer(Players currentPlayer,int diceRoll){

        int boardSize = snakeLadderBoard.getSize();
        int currentPos = snakeLadderBoard.getPlayerPos().get(currentPlayer.getUid());
        int newPos = currentPos + diceRoll;
        if(newPos > boardSize)
            newPos -= diceRoll;
        else
            newPos = getPosAfterSnakesLadder(newPos);
        snakeLadderBoard.getPlayerPos().put(currentPlayer.getUid(),newPos);

    }

    public int getValueofDiceRoll(){
        return DiceService.roll();
    }

    public boolean hasWon(Players player){
        int boardSize = snakeLadderBoard.getSize();
        int pos = snakeLadderBoard.getPlayerPos().get(player.getUid());
        return (pos==boardSize);
    }

    public void startGame(){
        while (!isGameCompleted()){
            Players currentPlayer = players.poll();
            movePlayer(currentPlayer,getValueofDiceRoll());
            if(hasWon(currentPlayer))
            {
                System.out.println("Winner is :" + currentPlayer.getName());
                snakeLadderBoard.getPlayerPos().remove(currentPlayer.getUid());

            }else{
                players.add(currentPlayer);
            }

        }
    }

}
