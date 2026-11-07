import java.util.ArrayList;
import java.util.List;

public class LocationDatabase {
    private final List<Location> locations = new ArrayList<>();

    public LocationDatabase() {
        locations.add(new Location("Laut Jawa", "Perairan tropis Indonesia.", "saltwater", 0));
        locations.add(new Location("Great Barrier Reef", "Terumbu karang Australia.", "saltwater", 2500));
        locations.add(new Location("Samudra Pasifik", "Perairan samudra luas.", "saltwater", 5000));
        locations.add(new Location("Laut Karibia", "Perairan tropis Karibia.", "saltwater", 7500));
        locations.add(new Location("Laut Mediterania", "Laut antara Eropa, Afrika, dan Asia.", "saltwater", 10000));
        locations.add(new Location("Danau Toba", "Danau vulkanik di Sumatra.", "freshwater", 3000));
        locations.add(new Location("Danau Baikal", "Danau air tawar di Rusia.", "freshwater", 6500));
        locations.add(new Location("Sungai Amazon", "Sungai besar Amerika Selatan.", "freshwater", 8000));
        locations.add(new Location("Sungai Kongo", "Sungai besar Afrika Tengah.", "freshwater", 9000));
        locations.add(new Location("Palung Mariana", "Wilayah laut dalam Pasifik.", "saltwater", 15000));
        locations.add(new Location("Laut Mitos", "Spot rahasia untuk makhluk mitologi.", "mythical", 25000));
    }

    public List<Location> getAll() { return new ArrayList<>(locations); }

    public Location findByName(String name) {
        for (Location item : locations) {
            if (item.getName().equalsIgnoreCase(name)) return item;
        }
        return null;
    }
}
