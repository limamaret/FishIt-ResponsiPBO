import java.util.ArrayList;
import java.util.List;

public class FishDatabase {
    private final List<Fish> fish = new ArrayList<>();

    public FishDatabase() {
        // Sample species data. Prices and catch weights are prototype balancing values,
        // not verified official Fish It game data.
        fish.add(new Fish("Sardine", "Sardina pilchardus", Rarity.COMMON, "saltwater", 2, 1, 3, 5000));
        fish.add(new Fish("Anchovy", "Engraulidae", Rarity.COMMON, "saltwater", 2, 1, 2, 4500));
        fish.add(new Fish("Mackerel", "Scombridae", Rarity.UNCOMMON, "saltwater", 5, 2, 8, 2500));
        fish.add(new Fish("Yellowfin Tuna", "Thunnus albacares", Rarity.UNCOMMON, "saltwater", 8, 5, 80, 1500));
        fish.add(new Fish("Rainbow Trout", "Oncorhynchus mykiss", Rarity.RARE, "freshwater", 12, 1, 12, 1000));
        fish.add(new Fish("Swordfish", "Xiphias gladius", Rarity.RARE, "saltwater", 18, 20, 100, 700));
        fish.add(new Fish("Arapaima", "Arapaima gigas", Rarity.EPIC, "freshwater", 30, 30, 200, 350));
        fish.add(new Fish("Ocean Sunfish", "Mola mola", Rarity.EPIC, "saltwater", 35, 100, 1000, 250));
        fish.add(new Fish("Coelacanth", "Latimeria chalumnae", Rarity.LEGENDARY, "saltwater", 70, 30, 100, 100));
        fish.add(new Fish("Whale Shark", "Rhincodon typus", Rarity.LEGENDARY, "saltwater", 90, 1000, 20000, 60));
        fish.add(new Fish("Goblin Shark", "Mitsukurina owstoni", Rarity.MYTHIC, "saltwater", 120, 100, 700, 25));
        fish.add(new Fish("Giant Oarfish", "Regalecus glesne", Rarity.MYTHIC, "saltwater", 140, 100, 270, 15));

        // Secret tier is intentionally reserved for mythical creatures.
        fish.add(new Fish("Leviathan", "Mythological sea monster", Rarity.SECRET, "mythical", 500, 1000, 10000, 2, true, 1000));
        fish.add(new Fish("Kraken", "Mythological sea monster", Rarity.SECRET, "mythical", 450, 500, 8000, 2, true, 500));
        fish.add(new Fish("Jormungandr", "Norse world serpent", Rarity.SECRET, "mythical", 600, 1000, 15000, 1, true, 1000));
        fish.add(new Fish("Umibozu", "Japanese sea spirit", Rarity.SECRET, "mythical", 400, 500, 7000, 2, true, 500));
    }

    public List<Fish> getAllFish() { return new ArrayList<>(fish); }

    public List<Fish> getAvailableFish(Location location) {
        List<Fish> result = new ArrayList<>();
        for (Fish item : fish) {
            if (item.canBeCaughtAt(location)) result.add(item);
        }
        return result;
    }
}
