import java.util.ArrayList;
import java.util.List;

public class TrainApp {

    // Goods Bogie class
    static class GoodsBogie {
        private String type;   // Cylindrical / Rectangular / Open
        private String cargo;  // Petroleum / Coal / Grain

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        public String getType() {
            return type;
        }

        public String getCargo() {
            return cargo;
        }

        public void display() {
            System.out.println("Type: " + type + " | Cargo: " + cargo);
        }
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Create goods bogie list
        List<GoodsBogie> goodsBogies = new ArrayList<>();

        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Rectangular", "Coal"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Grain"));

        // Display bogies
        System.out.println("\nGoods Bogies:");
        for (GoodsBogie b : goodsBogies) {
            b.display();
        }

        // Safety compliance check using allMatch()
        boolean isSafe = goodsBogies.stream()
                .allMatch(b ->
                        !b.getType().equals("Cylindrical") ||
                                b.getCargo().equals("Petroleum")
                );

        // Display result
        if (isSafe) {
            System.out.println("\nTrain is SAFETY COMPLIANT.");
        } else {
            System.out.println("\nTrain is NOT SAFE!");
        }

        System.out.println("\nSafety validation completed.");
    }
}