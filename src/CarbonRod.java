public class CarbonRod extends FishingRod {
    public CarbonRod() {
        super("Carbon Rod", 7000, 500, 40, 20);
    }

    @Override
    public int calculateLuckBonus() {
        int bonus;
        if (getLuck() >= 100) {
            bonus = getLuck() / 4;
        } else {
            bonus = getLuck() + 10;
        }
        updateLuckBonus(bonus);
        return getLastLuckBonus();
    }
}
