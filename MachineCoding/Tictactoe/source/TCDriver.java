package lld.tictac;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TCDriver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true){

            TicTacToe tct = new TicTacToe();
            List<Player> playerList = new ArrayList();
            System.out.println("Start the game? Yes or No");
            String start = scanner.nextLine();
            if(!start.toLowerCase().equals("yes"))
                break;

            System.out.println("Enter player1 name: ");
            String name = scanner.nextLine();
            Player player ;
            System.out.println("Select O or X");
            String type = scanner.nextLine();
            boolean isX = false;
            if(type.charAt(0)=='X' || type.charAt(0)=='x'){
                player = new Player(name,MarkType.X);
                isX = true;
            }else {
                player = new Player(name,MarkType.O);
            }
            playerList.add(player);

            System.out.println("Enter player2 name: ");
            name = scanner.nextLine();
            if(isX){
                player = new Player(name,MarkType.O);
            }else
                player = new Player(name,MarkType.X);

            playerList.add(player);
            tct.setPlayers(playerList);
            tct.startGame();
        }

    }
}
