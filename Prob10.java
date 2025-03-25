import java.io.*;
import java.util.regex.*;

public class Prob10 {
    public static void main(String[] args) {
        // Regular expressions for validation
        String regex = "^[0-9a-zA-Z^+\\-*/%.=]+$";
        String equationRegex = "^[0-9a-zA-Z^+\\-*/%.]+=[0-9a-zA-Z^+\\-*/%.]+$";
        String endRegex = "^end";

        // Input and output file paths
        String inputFilePath = "D:\\Study\\theory\\ans\\prob10input.txt";
        String outputFilePath = "D:\\Study\\theory\\ans\\prob10output.txt";

        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))
        ) {
            String exp;
            while ((exp = reader.readLine()) != null) {
                if (exp.matches("\\d+")) {  // Checks if exp contains only digits
                    writer.println(exp);
                    continue;
                }
                if (exp.matches(endRegex)) {  // Checks if "end" is found
                    writer.println("x");
                    continue;
                }
                boolean isValid = exp.matches(regex) && exp.matches(equationRegex);
                writer.println( (isValid ? "valid" : "invalid"));
            }
            System.out.println("Processing completed. Check output.txt for results.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
