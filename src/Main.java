public class Main {
    public static void main(String[] args) {
        Game game = new Game(new CPUPlayer(), new KeyBoardPlayer());
        game.startGame();
    }
}