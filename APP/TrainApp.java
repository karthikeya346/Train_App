import java.util.Scanner;

public class TrainApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Array of bogie IDs (unsorted)
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // User input
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Bogie ID to search: ");
        String searchKey = sc.nextLine();

        // Linear Search
        boolean found = false;

        for (int i = 0; i < bogieIds.length; i++) {
            if (bogieIds[i].equals(searchKey)) {
                found = true;
                System.out.println("Bogie found at position: " + i);
                break; // Early termination
            }
        }

        if (!found) {
            System.out.println("Bogie ID not found.");
        }

        System.out.println("\nSearch operation completed.");

        sc.close();
    }
}