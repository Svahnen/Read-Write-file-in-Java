import java.util.Scanner;

public class InputScanner {
    String input;

    public InputScanner() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            input = scanner.nextLine();
            System.out.println("Input: " + input);
        }
        scanner.close();
    }
}
