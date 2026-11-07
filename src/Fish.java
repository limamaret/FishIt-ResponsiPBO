public class Fish implements Sellable, Catchable {
    private final String name;
    private final String scientificName;
    private final Rarity rarity;
    private final String habitat;
    private final long basePrice;
    private final int minWeight;
    private final int maxWeight;
    private final int catchWeight;
    private final boolean mythical;
    private final int weight;

    public Fish(String name, String scientificName, Rarity rarity, String habitat,
                long basePrice, int minWeight, int maxWeight, int catchWeight) {
        this(name, scientificName, rarity, habitat, basePrice, minWeight, maxWeight,
                catchWeight, false, minWeight);
    }

    // Overloaded constructor.
    public Fish(String name, String scientificName, Rarity rarity, String habitat,
                long basePrice, int minWeight, int maxWeight, int catchWeight,
                boolean mythical, int weight) {
        this.name = name;
        this.scientificName = scientificName;
        this.rarity = rarity;
        this.habitat = habitat;
        this.basePrice = basePrice;
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
        this.catchWeight = catchWeight;
        this.mythical = mythical;
        this.weight = weight;
    }

    public Fish createCatch(int caughtWeight) {
        return new Fish(name, scientificName, rarity, habitat, basePrice, minWeight,
                maxWeight, catchWeight, mythical, caughtWeight);
    }

    @Override
    public long getSellPrice() {
        return basePrice * weight;
    }

    @Override
    public boolean canBeCaughtAt(Location location) {
        return location != null && location.supportsHabitat(habitat);
    }

    public String getName() { return name; }
    public String getScientificName() { return scientificName; }
    public Rarity getRarity() { return rarity; }
    public String getHabitat() { return habitat; }
    public long getBasePrice() { return basePrice; }
    public int getMinWeight() { return minWeight; }
    public int getMaxWeight() { return maxWeight; }
    public int getCatchWeight() { return catchWeight; }
    public int getWeight() { return weight; }
    public boolean isMythical() { return mythical; }

    @Override
    public String toString() {
        return name + " [" + rarity + "] - " + weight + " kg - " + getSellPrice() + " Coins";
    }
}
