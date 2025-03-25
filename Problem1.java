
import java.io.*;
import java.util.regex.*;

public class Problem1 {

    public static void main(String[] args) throws IOException {

        String inputFilePath = "D:\\\\Study\\\\theory\\\\ans\\\\prob1input.txt";
        String outputFilePath = "D:\\\\Study\\\\theory\\\\ans\\\\prob1output.txt";

        BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

        Pattern pattern = Pattern.compile(
                "^(?:[0-9A-Fa-f]{2}([-:])([0-9A-Fa-f]{2}\\1){4}[0-9A-Fa-f]{2}|[0-9A-Fa-f]{12})$"
        );

        String line;
        boolean firstLine = true;
        while ((line = reader.readLine()) != null) {
            if (line.equals("end")) {
                writer.write("x\n");
                break;
            }
            if (firstLine) {
                writer.write(line + "\n");
                firstLine = false;
                continue;
            }
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                writer.write("valid\n");
            } else {
                writer.write("invalid\n");
            }
        }

        reader.close();
        writer.close();
        System.out.println("MAC address validation completed. Results saved to: " + outputFilePath);
    }
}
