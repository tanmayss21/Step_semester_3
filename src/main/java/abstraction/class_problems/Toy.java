package abstraction.class_problems;

/**
 * Problem 1: The Talking Toy Box
 * 
 * Demonstrates abstract classes with abstract methods and shared static counter
 * initialization across subclasses.
 */
public abstract class Toy {
    private final String toyId;
    private static int counter = 1000;

    public Toy() {
        counter++;
        this.toyId = "TOY-" + counter;
    }

    public abstract String makeSound();

    public String getToyId() {
        return toyId;
    }

    public static void main(String[] args) {
        ToyCar c = new ToyCar("Speedster");
        System.out.println(c.makeSound());

        ToyRobot r = new ToyRobot("Bolt");
        System.out.println(r.makeSound());

        System.out.println(c.getToyId());
        System.out.println(r.getToyId());
    }
}

class ToyCar extends Toy {
    private String name;

    public ToyCar(String name) {
        super();
        this.name = name;
    }

    @Override
    public String makeSound() {
        return name + ": Vroom vroom!";
    }
}

class ToyRobot extends Toy {
    private String name;

    public ToyRobot(String name) {
        super();
        this.name = name;
    }

    @Override
    public String makeSound() {
        return name + ": Beep boop!";
    }
}
