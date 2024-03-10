public abstract class Player {
    private final String name;
    public Player(String name){
        this.name = name;
    }
    public abstract String getNewLocation(Board board);

    public String getName() {
        return name;
    }
}
