import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Inventory {
    private final List<Fish> fishList = new ArrayList<>();

    public void addFish(Fish fish) {
        if (fish != null) fishList.add(fish);
    }

    public long sellAll() {
        long total = 0;
        for (Fish fish : fishList) total += fish.getSellPrice();
        fishList.clear();
        return total;
    }

    public List<Fish> getFishList() { return Collections.unmodifiableList(fishList); }
    public int getSize() { return fishList.size(); }
    public boolean isEmpty() { return fishList.isEmpty(); }

    public void display() {
        if (fishList.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        for (int i = 0; i < fishList.size(); i++) {
            System.out.println((i + 1) + ". " + fishList.get(i));
        }
    }
}
