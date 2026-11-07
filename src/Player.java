import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Player {
    private final String name;
    private long coins;
    private FishingRod activeRod;
    private final Inventory inventory = new Inventory();
    private final Set<String> unlockedLocations = new HashSet<>();
    private final Set<String> fishIndex = new HashSet<>();

    public Player(String name, long coins) {
        this.name = (name == null || name.trim().isEmpty()) ? "Angler" : name.trim();
        this.coins = Math.max(0, coins);
        this.activeRod = new BasicRod();
        unlockedLocations.add("Laut Jawa");
    }

    public boolean spendCoins(long amount) {
        if (amount < 0 || coins < amount) return false;
        coins -= amount;
        return true;
    }

    public void addCoins(long amount) {
        if (amount > 0) coins += amount;
    }

    public void setActiveRod(FishingRod rod) {
        if (rod != null) this.activeRod = rod;
    }

    public void unlockLocation(String name) {
        if (name != null && !name.trim().isEmpty()) unlockedLocations.add(name);
    }

    public boolean hasLocation(String name) { return unlockedLocations.contains(name); }
    public void registerFish(Fish fish) {
        if (fish != null) fishIndex.add(fish.getName());
    }

    public String getName() { return name; }
    public long getCoins() { return coins; }
    public FishingRod getActiveRod() { return activeRod; }
    public Inventory getInventory() { return inventory; }
    public Set<String> getUnlockedLocations() { return Collections.unmodifiableSet(unlockedLocations); }
    public Set<String> getFishIndex() { return Collections.unmodifiableSet(fishIndex); }
}
