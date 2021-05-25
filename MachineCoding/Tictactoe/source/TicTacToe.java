package lld.tictac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

    private List<Player> players;

    Mark grid[][];


    public TicTacToe() {
        players = new ArrayList<>();
        this.grid = new Mark[3][3];
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public boolean addMark(Player player , int x, int y){
        Mark mark = new Mark(player.getType(),player);
        if(x>=0 && y>=0 && x<3 && y<3){
            if(grid[x][y]==null){
                grid[x][y] = mark;
            }else{
                System.out.println("Invalid position. Player already existes.");
                return false;
            }
        }else{
            System.out.println("Invalid position.");
            return false;
        }
        return true;
    }

    private boolean checkEqual(int x1, int y1 ,int x2, int y2){

        if(grid[x1][y1]!=null && grid[x2][y2]!=null) {
            if (grid[x1][y1].getType() == grid[x2][y2].getType())
                return true;
            else
                return false;
        }
        else
            return false;
    }

    public Player checkWinner(){

        if ((checkEqual(0,0,0,1) && (checkEqual(0,1,0,2)))){
            return grid[0][0].getPlayer();
        }else if((checkEqual(1,0,1,1) && (checkEqual(1,1,1,2)))){
            return grid[1][0].getPlayer();
        }else if((checkEqual(2,0,2,1) && (checkEqual(2,1,2,2)))){
            return grid[2][0].getPlayer();
        }else if((checkEqual(0,0,1,0) && (checkEqual(1,0,2,0)))){
            return grid[0][0].getPlayer();
        }else if((checkEqual(0,1,1,1) && (checkEqual(1,1,2,1)))){
            return grid[0][1].getPlayer();
        }else if((checkEqual(0,2,1,2) && (checkEqual(1,2,2,2)))){
            return grid[0][2].getPlayer();
        }else if((checkEqual(0,0,1,1) && (checkEqual(1,1,2,2)))){
            return grid[0][0].getPlayer();
        }else if((checkEqual(2,0,1,1) && (checkEqual(1,1,0,2)))){
            return grid[2][0].getPlayer();
        }


        return null;
    }

    private boolean gameIsOn(){

        if(checkWinner() == null)
            return true;

        return false;
    }

    public void showGrid(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(grid[i][j]==null)
                    System.out.print("- ");
                else
                    System.out.print(grid[i][j].getType()+ " ");
            }
            System.out.println();
        }
    }

    public void startGame(){

        int index = 0;
        Scanner sc = new Scanner(System.in);
        while (gameIsOn()){
            int i=index%2;
            System.out.println("enter the position for player"+ (i+1) +" [x,y]");
            String pos = sc.nextLine();
            String[] positions = pos.split(" ");
            Integer x = Integer.parseInt(positions[0]);
            Integer y = Integer.parseInt(positions[1]);
            while (!addMark(players.get(i),x,y)){
            }
            showGrid();
            index++;
            if(index==9)
                break;
        }
        Player winner = checkWinner();
        if(winner!=null)
            System.out.println("Winner is : " + winner.getName());
        else
            System.out.println("It's Draw");

    }


}
