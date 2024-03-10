import java.util.ArrayList;
import java.util.List;

public class Board {
    private final int[][] board;
    private int emptyBlocks;
    
    public Board(){
        board = new int[3][3];
        for(int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j] = -1;
        emptyBlocks = 9;
    }

    public int[][] getBoard() {
        return board;
    }

    public int getBoardItem(int first, int second){
        return board[first][second];
    }
    
    public void showBoard(){
        System.out.println("\\ A B C");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + 1);
            for(int j = 0; j < 3; j++){
                System.out.print(" ");
                if(board[i][j] == -1)
                    System.out.print(" ");
                else if (board[i][j] == 1) {
                    System.out.print("X");
                }
                else { //should be 2
                    System.out.print("O");
                }
            }
            System.out.println();
        }
    }

    public int addSymbol(int player, int first, int second){
        if(emptyBlocks == 0)
            return -1;
        board[first][second] = player;
        emptyBlocks--;
        if((board[first][0] == player && board[first][1] == player && board[first][2] == player) || (board[0][second] == player && board[1][second] == player && board[2][second] == player))
            return player;
        if (first == second && board[0][0] == player && board[1][1] == player && board[2][2] == player)
            return player;
        if(first + second == 2 && board[0][2] == player && board[1][1] == player && board[2][0] == player)
            return player;
        return 0;
    }

    public int getEmptyBlocks() {
        return emptyBlocks;
    }

    public List<String> getPlayerBlocks(int player){
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j] ==player){
                    char first = (char) ('A' + j);
                    char second = (char) ('1' + i);
                    arr.add("" + first + second);
                }
            }
        }
        return arr;
    }
}
