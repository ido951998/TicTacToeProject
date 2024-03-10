import java.util.List;

public class CPUPlayer extends Player{
    private String nextMove;

    public CPUPlayer() {
        super("CPU Player");
        nextMove = "";
    }

    @Override
    public String getNewLocation(Board board) {
        String s = "";
        if (board.getEmptyBlocks() == 9) {
            s = "A1";
        } else if (board.getEmptyBlocks() == 7) {
            List<String> arr = board.getPlayerBlocks(2);
            String pos = arr.get(0);
            switch (pos) {
                case ("B1"), ("C1") -> {
                    s = "A3";
                    nextMove = "C3";
                }
                case ("A2"), ("A3") -> {
                    s = "C1";
                    nextMove = "C3";
                }
                case ("C2"), ("C3") -> {
                    s = "C1";
                    nextMove = "A3";
                }
                case ("B3") -> {
                    s = "A3";
                    nextMove = "C1";
                }
                case ("B2") -> s = "C3";
            }
        } else {
            String winningMove = winningMove(board, 1);
            if (!winningMove.equals(""))
                s = winningMove;
            else {
                String defenceMove = winningMove(board, 2);
                if (!defenceMove.equals("")) {
                    s = defenceMove;
                } else
                    s = nextMove;
            }
        }
        System.out.println(s);
        return s;
    }

    protected String winningMove(Board board, int player) {
        List<String> l = board.getPlayerBlocks(player);
        int[][] b = board.getBoard();
        for (String loc : l) {
            int first = loc.charAt(1) - '1';
            int second = loc.charAt(0) - 'A';
            if (b[first][(second + 1) % 3] == player && b[first][(second + 2) % 3] == -1)
                return "" + (char)((second + 2) % 3 + 'A') + (char)(first + '1');
            if (b[first][(second + 2) % 3] == player && b[first][(second + 1) % 3] == -1)
                return "" + (char)((second + 1) % 3 + 'A') + (char)(first + '1');
            if (b[(first + 1) % 3 ][second] == player && b[(first + 2) % 3][second] == -1)
                return "" + (char)(second + 'A') + (char)((first + 2) % 3 + '1');
            if (b[(first + 2) % 3 ][second] == player && b[(first + 1) % 3][second] == -1)
                return "" + (char)(second + 'A') + (char)((first + 1) % 3 + '1');
            if(first == second && b[(first + 1) % 3 ][(second + 1) % 3] == player && b[(first + 2) % 3 ][(second + 2) % 3] == -1)
                return "" + (char)((second + 2) % 3 + 'A') + (char)((first + 2) % 3 + '1');
            if(first == second && b[(first + 2) % 3 ][(second + 2) % 3] == player && b[(first + 1) % 3 ][(second + 1) % 3] == -1)
                return "" + (char)((second + 1) % 3 + 'A') + (char)((first + 1) % 3 + '1');
            if(first + second == 2 && b[(first + 1) % 3 ][(second + 2) % 3] == player && b[(first + 2) % 3 ][(second + 1) % 3] == -1)
                return "" + (char)((second + 1) % 3 + 'A') + (char)((first + 2) % 3 + '1');
            if(first + second == 2 && b[(first + 2) % 3 ][(second + 1) % 3] == player && b[(first + 1) % 3 ][(second + 2) % 3] == -1)
                return "" + (char)((second + 2) % 3 + 'A') + (char)((first + 1) % 3 + '1');
        }
        return "";
    }
}
