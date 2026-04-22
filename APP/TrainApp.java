import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TrainApp {

    // Bogie class (inner class)
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

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();

        // Add bogies
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));

        // Before sorting
        System.out.println("\nBefore Sorting:");
        for (Bogie b : bogies) {
            b.display();
        }

        // Sort using Comparator (ascending order)
        bogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        // After sorting
        System.out.println("\nAfter Sorting (Ascending by Capacity):");
        for (Bogie b : bogies) {
            b.display();
        }

        System.out.println("\nSorting completed successfully.");
    }
}