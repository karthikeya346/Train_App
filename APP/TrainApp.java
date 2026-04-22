import java.util.ArrayList;
import java.util.List;

public class TrainApp {

    // Custom Exception
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // Passenger Bogie Class
    static class PassengerBogie {
        private String type;
        private int capacity;

        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.type = type;
            this.capacity = capacity;
        }

        public void display() {
            System.out.println("Bogie: " + type + " | Capacity: " + capacity);
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        List<PassengerBogie> bogies = new ArrayList<>();

        try {
            // Valid bogies
            bogies.add(new PassengerBogie("Sleeper", 72));
            bogies.add(new PassengerBogie("AC Chair", 56));

            // Invalid bogie (will throw exception)
            bogies.add(new PassengerBogie("First Class", 0));

        } catch (InvalidCapacityException e) {
            System.out.println("\nException Occurred: " + e.getMessage());
        }

        // Display valid bogies
        System.out.println("\nValid Passenger Bogies:");
        for (PassengerBogie b : bogies) {
            b.display();
        }

        System.out.println("\nSystem continues safely.");
    }
}