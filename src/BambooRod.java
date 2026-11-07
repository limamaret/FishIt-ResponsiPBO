public class BambooRod extends FishingRod {
    public BambooRod() {
        super("Bamboo Rod", 1500, 100, 15, 5);
    }

    @Override
    public int calculateLuckBonus() {
        int bonus;
        if (getLuck() >= 100) {
            bonus = getLuck() / 5;
        } else {
            bonus = getLuck() + 5;
        }
        updateLuckBonus(bonus);
        return getLastLuckBonus();
    }
}
