import java.util.*;
import java.util.stream.Collectors;

public class TrainApp {

    // Bogie class
    static class Bogie {
        private String name;
        private int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() {
            return name;
        }

        public int getCapacity() {
            return capacity;
        }

        public void display() {
            System.out.println("Bogie: " + name + " | Capacity: " + capacity);
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create bogie list
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Luxury AC", 80));

        // Display bogies
        System.out.println("\nAll Bogies:");
        for (Bogie b : bogies) {
            b.display();
        }

        // Step 1: map() → extract capacities
        // Step 2: reduce() → sum them
        int totalCapacity = bogies.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);

        // Display result
        System.out.println("\nTotal Seating Capacity: " + totalCapacity);

        System.out.println("\nAggregation completed successfully.");
    }
}