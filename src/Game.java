public class Game {
    private Board board;
    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2){
        board = new Board();
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startGame(){
        boolean player1Turn = true;
        int winner = 0;
        for (int i = 0; i < 9 && winner == 0 ; i++) {
            board.showBoard();
            boolean goodLocation = false;
            while (!goodLocation) {
                String s;
                if (player1Turn) {
                    System.out.println(player1.getName()+ ", please enter a location in the board to place the X:");
                    s = player1.getNewLocation(board);
                }
                else {
                    System.out.println(player2.getName()+ ", please enter a location in the board to place the O:");
                    s = player2.getNewLocation(board);
                }
                if(s.length() == 2) {
                    int first = s.charAt(1) - '1';
                    int second = s.charAt(0) - 'A';
                    if (first >= 0 && first <= 2 && second >= 0 && second <= 2){
                        if(board.getBoardItem(first,second) == -1){
                            goodLocation = true;
                            winner = board.addSymbol(player1Turn? 1 : 2, first, second);
                            player1Turn = !player1Turn;
                        }
                    }
                }
                if(!goodLocation)
                    System.out.println("Bad location entered. Please try again!");
            }
        }
        board.showBoard();
        if(winner == 0)
            System.out.println("The game end in a draw");
        else if(winner == 1)
            System.out.println(player1.getName() + " win the game");
        else
            System.out.println("Player " + player2.getName() + " win the game");
    }
}
