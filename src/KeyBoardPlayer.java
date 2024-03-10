import java.util.Scanner;

public class KeyBoardPlayer extends Player{
    public KeyBoardPlayer() {
        super("Key Board Player");
    }

    @Override
    public String getNewLocation(Board board) {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
