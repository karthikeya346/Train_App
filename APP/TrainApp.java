import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Train Consist Management App ===");

        // Input from user
        System.out.print("\nEnter Train ID (Format: TRN-1234): ");
        String trainId = sc.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = sc.nextLine();

        // Define regex patterns
        String trainPatternStr = "TRN-\\d{4}";
        String cargoPatternStr = "PET-[A-Z]{2}";

        // Compile patterns
        Pattern trainPattern = Pattern.compile(trainPatternStr);
        Pattern cargoPattern = Pattern.compile(cargoPatternStr);

        // Create matchers
        Matcher trainMatcher = trainPattern.matcher(trainId);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        // Validate Train ID
        if (trainMatcher.matches()) {
            System.out.println("\nTrain ID is VALID.");
        } else {
            System.out.println("\nTrain ID is INVALID.");
        }

        // Validate Cargo Code
        if (cargoMatcher.matches()) {
            System.out.println("Cargo Code is VALID.");
        } else {
            System.out.println("Cargo Code is INVALID.");
        }

        System.out.println("\nValidation process completed.");

        sc.close();
    }
}