import java.util.ArrayList;
import java.util.List;

public class Shop {
    private final List<FishingRod> rods = new ArrayList<>();

    public Shop() {
        rods.add(new BasicRod());
        rods.add(new BambooRod());
        rods.add(new CarbonRod());
    }

    public void displayRods() {
        for (int i = 0; i < rods.size(); i++) {
            System.out.print((i + 1) + ". ");
            rods.get(i).displayInfo();
        }
    }

    public FishingRod getRod(int index) {
        if (index < 0 || index >= rods.size()) return null;
        FishingRod rod = rods.get(index);
        if (rod instanceof BasicRod) return new BasicRod();
        if (rod instanceof BambooRod) return new BambooRod();
        if (rod instanceof CarbonRod) return new CarbonRod();
        return null;
    }

    public int getRodCount() { return rods.size(); }
}
