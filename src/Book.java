public class Book {
    private static int idCounter = 0;
    private int id;
    private int score;
    private boolean scanned = false;

    public Book(int score) {
        this.id = idCounter++;
        this.score = score;

    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
    }

    public boolean isScanned() {
        return scanned;
    }

    public void setScanned(boolean scanned) {
        this.scanned = scanned;
    }
}
