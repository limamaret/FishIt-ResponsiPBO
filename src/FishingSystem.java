import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FishingSystem {
    private final FishDatabase database;
    private final Random random = new Random();

    public FishingSystem(FishDatabase database) {
        this.database = database;
    }

    public Fish fish(FishingRod rod, Location location) {
        if (rod == null || location == null) return null;

        List<Fish> candidates = database.getAvailableFish(location);
        if (candidates.isEmpty()) return null;

        int luckBonus = rod.calculateLuckBonus();
        List<Integer> weights = new ArrayList<>();
        long total = 0;

        for (Fish candidate : candidates) {
            int adjusted = Math.max(1, candidate.getCatchWeight()
                    + candidate.getRarity().ordinal() * luckBonus / 20);
            weights.add(adjusted);
            total += adjusted;
        }

        long roll = (long) (random.nextDouble() * total);
        for (int i = 0; i < candidates.size(); i++) {
            roll -= weights.get(i);
            if (roll < 0) {
                Fish template = candidates.get(i);
                int range = template.getMaxWeight() - template.getMinWeight() + 1;
                int caughtWeight = template.getMinWeight() + random.nextInt(Math.max(1, range));
                return template.createCatch(caughtWeight);
            }
        }

        Fish fallback = candidates.get(0);
        return fallback.createCatch(fallback.getMinWeight());
    }
}
