package abstraction.assigment_problems;

/**
 * Problem 3: Backyard Toolshed Routine
 * 
 * Demonstrates multilevel inheritance with abstract methods and incremental behavior
 * reuse via super.use() chaining.
 */
public abstract class GardenTool {
    public GardenTool() {
        super();
    }

    public abstract String use();

    public static void main(String[] args) {
        CuttingTool c = new CuttingTool();
        System.out.println(c.use());

        Pruner p = new Pruner();
        System.out.println(p.use());
    }
}

class CuttingTool extends GardenTool {
    public CuttingTool() {
        super();
    }

    @Override
    public String use() {
        return "Using the tool in the garden, blade sharpened first";
    }
}

class Pruner extends CuttingTool {
    public Pruner() {
        super();
    }

    @Override
    public String use() {
        return super.use() + ", then trimming branches precisely";
    }
}
