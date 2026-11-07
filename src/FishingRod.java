public abstract class FishingRod {
    private final String name;
    private final long price;
    private final int strength;
    private final int luck;
    private final int lureSpeed;
    private int lastLuckBonus;

    public FishingRod(String name, long price, int strength, int luck, int lureSpeed) {
        this.name = name;
        this.price = price;
        this.strength = strength;
        this.luck = luck;
        this.lureSpeed = lureSpeed;
        this.lastLuckBonus = 0;
    }

    // Constructor overloading.
    public FishingRod(String name, long price, int strength, int luck) {
        this(name, price, strength, luck, 0);
    }

    public abstract int calculateLuckBonus();

    protected void updateLuckBonus(int bonus) {
        this.lastLuckBonus = Math.max(0, bonus);
    }

    public void displayInfo() {
        System.out.println(name + " | " + price + " Coins | Strength " + strength
                + " | Luck " + luck + " | Lure Speed " + lureSpeed + "%");
    }

    public String getName() { return name; }
    public long getPrice() { return price; }
    public int getStrength() { return strength; }
    public int getLuck() { return luck; }
    public int getLureSpeed() { return lureSpeed; }
    public int getLastLuckBonus() { return lastLuckBonus; }
}
