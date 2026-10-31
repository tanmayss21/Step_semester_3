package abstraction.assigment_problems;

/**
 * Problem 2: Gallery Description Cards
 * 
 * Demonstrates abstract class inheritance with unique identifier generation
 * using shared static counter initialization.
 */
public abstract class ArtPiece {
    private final String pieceId;
    private static int counter = 1000;

    public ArtPiece() {
        counter++;
        this.pieceId = "ART-" + counter;
    }

    public abstract String describe();

    public String getPieceId() {
        return pieceId;
    }

    public static void main(String[] args) {
        Painting p = new Painting("Sunset Fields");
        System.out.println(p.describe());

        Sculpture s = new Sculpture("The Thinker II");
        System.out.println(s.describe());
    }
}

class Painting extends ArtPiece {
    private String title;

    public Painting(String title) {
        super();
        this.title = title;
    }

    @Override
    public String describe() {
        return "Painting: " + title + ", framed on canvas";
    }
}

class Sculpture extends ArtPiece {
    private String title;

    public Sculpture(String title) {
        super();
        this.title = title;
    }

    @Override
    public String describe() {
        return "Sculpture: " + title + ", carved from stone";
    }
}
