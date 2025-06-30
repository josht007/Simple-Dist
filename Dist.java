import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CityDistanceGuesser {

    public static void main(String[] args) {
        // Create a map of distances between cities (in kilometers)
        Map<String, Integer> distances = new HashMap<>();
        distances.put("Toronto-Montreal", 541);
        distances.put("Toronto-Vancouver", 3359);
        distances.put("Toronto-Calgary", 2704);
        distances.put("Montreal-Vancouver", 3681);
        distances.put("Calgary-Vancouver", 970);
        distances.put("Ottawa-Montreal", 199);
        distances.put("Ottawa-Toronto", 450);
        distances.put("Edmonton-Calgary", 299);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Canadian City Distance Guesser!");
        System.out.print("Enter the first city: ");
        String city1 = scanner.nextLine().trim();

        System.out.print("Enter the second city: ");
        String city2 = scanner.nextLine().trim();

        // Normalize key format
        String key1 = city1 + "-" + city2;
        String key2 = city2 + "-" + city1;

        if (distances.containsKey(key1) || distances.containsKey(key2)) {
            int actualDistance = distances.getOrDefault(key1, distances.get(key2));
            System.out.print("Guess the distance between " + city1 + " and " + city2 + " (in km): ");
            int guess = scanner.nextInt();

            int difference = Math.abs(actualDistance - guess);
            System.out.println("Actual distance: " + actualDistance + " km");

            if (difference <= 50) {
                System.out.println("Great guess! You were within 50 km.");
            } else if (difference <= 200) {
                System.out.println("Not bad! You were within 200 km.");
            } else {
                System.out.println("Nice try, but you were off by " + difference + " km.");
            }
        } else {
            System.out.println("Sorry, distance data not available for that pair of cities.");
        }

        scanner.close();
    }
}
