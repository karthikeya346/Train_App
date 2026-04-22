import java.util.ArrayList;
import java.util.List;

public class TrainApp {

    // Custom Runtime Exception
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie Class
    static class GoodsBogie {
        private String type;   // Cylindrical / Rectangular
        private String cargo;

        public GoodsBogie(String type) {
            this.type = type;
        }

        public void assignCargo(String cargo) {
            try {
                // Safety rule
                if (type.equals("Rectangular") && cargo.equals("Petroleum")) {
                    throw new CargoSafetyException(
                            "Unsafe Assignment: Rectangular bogie cannot carry Petroleum"
                    );
                }

                // Assign cargo if safe
                this.cargo = cargo;
                System.out.println("Cargo assigned successfully: " + cargo + " → " + type);

            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());

            } finally {
                System.out.println("Assignment attempt completed.\n");
            }
        }

        public void display() {
            System.out.println("Type: " + type + " | Cargo: " + cargo);
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        List<GoodsBogie> bogies = new ArrayList<>();

        // Create bogies
        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        GoodsBogie b2 = new GoodsBogie("Rectangular");

        bogies.add(b1);
        bogies.add(b2);

        // Safe assignment
        b1.assignCargo("Petroleum");

        // Unsafe assignment (handled safely)
        b2.assignCargo("Petroleum");

        // Another safe assignment
        b2.assignCargo("Coal");

        // Display final state
        System.out.println("Final Bogie States:");
        for (GoodsBogie b : bogies) {
            b.display();
        }

        System.out.println("\nProgram continues safely.");
    }
}