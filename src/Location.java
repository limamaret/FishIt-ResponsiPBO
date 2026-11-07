import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Location {
    private final String name;
    private final String description;
    private final List<String> habitats;
    private final long unlockPrice;

    public Location(String name, String description, List<String> habitats, long unlockPrice) {
        this.name = name;
        this.description = description;
        this.habitats = new ArrayList<>(habitats);
        this.unlockPrice = unlockPrice;
    }

    // Overloaded constructor.
    public Location(String name, String description, String habitat, long unlockPrice) {
        this(name, description, java.util.Arrays.asList(habitat), unlockPrice);
    }

    public boolean supportsHabitat(String habitat) { return habitats.contains(habitat); }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public List<String> getHabitats() { return Collections.unmodifiableList(habitats); }
    public long getUnlockPrice() { return unlockPrice; }
    public boolean isUnlockedByDefault() { return unlockPrice == 0; }
}
