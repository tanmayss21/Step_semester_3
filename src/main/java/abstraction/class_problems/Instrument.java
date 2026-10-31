package abstraction.class_problems;

/**
 * Problem 3: Orchestra Warm-Up Routine
 * 
 * Demonstrates a multilevel class hierarchy with abstract and concrete method overrides
 * using super.play() call chaining.
 */
public abstract class Instrument {
    public Instrument() {
        super();
    }

    public abstract String play();

    public static void main(String[] args) {
        StringInstrument s = new StringInstrument();
        System.out.println(s.play());

        Violin v = new Violin();
        System.out.println(v.play());
    }
}

class StringInstrument extends Instrument {
    public StringInstrument() {
        super();
    }

    @Override
    public String play() {
        return "Strumming the strings";
    }
}

class Violin extends StringInstrument {
    public Violin() {
        super();
    }

    @Override
    public String play() {
        return super.play() + ", with a bow drawn across four strings";
    }
}
