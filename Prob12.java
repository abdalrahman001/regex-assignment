import java.io.*;

public class Prob12 {
    public static void main(String[] args) {
        String endRegex = "^end";
        String regex = "^(\\d[a-zA-Z])+$"; // Ensures alternating digits and letters

        String inputFilePath = "D:\\Study\\theory\\ans\\prob12input.txt";
        String outputFilePath = "D:\\Study\\theory\\ans\\prob12output.txt";

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
                boolean isValid = exp.matches(regex);
                writer.println((isValid ? "valid" : "invalid"));
            }
            System.out.println("Processing completed. Check output.txt for results.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
