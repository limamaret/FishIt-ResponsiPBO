import java.util.List;
import java.util.Scanner;

public class Game {
    private final Scanner scanner = new Scanner(System.in);
    private final Player player;
    private final FishDatabase fishDatabase = new FishDatabase();
    private final LocationDatabase locationDatabase = new LocationDatabase();
    private final FishingSystem fishingSystem = new FishingSystem(fishDatabase);
    private final Shop shop = new Shop();
    private Location currentLocation;

    public Game() {
        System.out.print("Enter player name: ");
        String name = scanner.nextLine().trim();
        player = new Player(name, GameConfig.STARTING_COINS);
        currentLocation = locationDatabase.findByName("Laut Jawa");
    }

    public void start() {
        boolean running = true;
        System.out.println("\n=== " + GameConfig.GAME_NAME + " ===");
        while (running) {
            System.out.println("\nPlayer: " + player.getName() + " | Coins: " + player.getCoins());
            System.out.println("Location: " + currentLocation.getName()
                    + " | Rod: " + player.getActiveRod().getName());
            System.out.println("1. Fish  2. Inventory  3. Sell all  4. Rod shop");
            System.out.println("5. Change location  6. Fish index  7. Status");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            int choice = readInt();
            switch (choice) {
                case 1: doFishing(); break;
                case 2: player.getInventory().display(); break;
                case 3: sellAll(); break;
                case 4: openShop(); break;
                case 5: changeLocation(); break;
                case 6: displayFishIndex(); break;
                case 7: displayStatus(); break;
                case 0: running = false; break;
                default: System.out.println("Invalid menu.");
            }
        }
        System.out.println("Thanks for playing!");
    }

    private void doFishing() {
        System.out.println("Fishing...");
        Fish caught = fishingSystem.fish(player.getActiveRod(), currentLocation);
        if (caught == null) {
            System.out.println("No fish available here.");
            return;
        }
        player.getInventory().addFish(caught);
        player.registerFish(caught);

        // Explicit polymorphism through an interface reference.
        Sellable itemForSale = caught;
        System.out.println("\nFISH CAUGHT!");
        System.out.println("Name: " + caught.getName());
        System.out.println("Scientific name: " + caught.getScientificName());
        System.out.println("Rarity: " + caught.getRarity());
        System.out.println("Weight: " + caught.getWeight() + " kg");
        System.out.println("Estimated value: " + itemForSale.getSellPrice() + " Coins");
    }

    private void sellAll() {
        long earned = player.getInventory().sellAll();
        if (earned <= 0) {
            System.out.println("No fish to sell.");
            return;
        }
        player.addCoins(earned);
        System.out.println("Sold all fish for " + earned + " Coins.");
    }

    private void openShop() {
        shop.displayRods();
        System.out.print("Choose rod (0 cancel): ");
        int choice = readInt();
        if (choice == 0) return;
        FishingRod rod = shop.getRod(choice - 1);
        if (rod == null) {
            System.out.println("Invalid rod.");
            return;
        }
        if (!player.spendCoins(rod.getPrice())) {
            System.out.println("Not enough Coins.");
            return;
        }
        player.setActiveRod(rod);
        System.out.println("Equipped " + rod.getName());
    }

    private void changeLocation() {
        List<Location> all = locationDatabase.getAll();
        for (int i = 0; i < all.size(); i++) {
            Location location = all.get(i);
            String status = player.hasLocation(location.getName()) || location.isUnlockedByDefault()
                    ? "UNLOCKED" : "Unlock: " + location.getUnlockPrice() + " Coins";
            System.out.println((i + 1) + ". " + location.getName() + " - " + status);
        }
        System.out.print("Choose location (0 cancel): ");
        int choice = readInt();
        if (choice == 0) return;
        if (choice < 1 || choice > all.size()) {
            System.out.println("Invalid location.");
            return;
        }
        Location selected = all.get(choice - 1);
        if (!player.hasLocation(selected.getName()) && !selected.isUnlockedByDefault()) {
            if (!player.spendCoins(selected.getUnlockPrice())) {
                System.out.println("Not enough Coins.");
                return;
            }
            player.unlockLocation(selected.getName());
        }
        currentLocation = selected;
        System.out.println("Travelled to " + selected.getName());
    }

    private void displayFishIndex() {
        if (player.getFishIndex().isEmpty()) {
            System.out.println("No discoveries yet.");
            return;
        }
        for (String name : player.getFishIndex()) System.out.println("- " + name);
    }

    private void displayStatus() {
        System.out.println("Name: " + player.getName());
        System.out.println("Coins: " + player.getCoins());
        System.out.println("Rod: " + player.getActiveRod().getName());
        System.out.println("Fish inventory: " + player.getInventory().getSize());
        System.out.println("Species discovered: " + player.getFishIndex().size());
    }

    private int readInt() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
