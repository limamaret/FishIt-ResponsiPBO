public class BasicRod extends FishingRod {
    public BasicRod() {
        super("Starter Rod", 0, 10, 0, 0);
    }

    @Override
    public int calculateLuckBonus() {
        int bonus;
        if (getLuck() >= 100) {
            bonus = getLuck() / 10;
        } else {
            bonus = getLuck();
        }
        updateLuckBonus(bonus);
        return getLastLuckBonus();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Basic rod for new anglers.");
    }
}
