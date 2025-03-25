import java.io.*;
import java.util.regex.*;

public class Problem9 {
    public static void main(String[] args) {
        String inputFile = "D:\\Study\\theory\\ans\\prob9input.txt";
        String outputFile = "D:\\Study\\theory\\ans\\prob9output.txt";
        boolean inSection9 = false;
        Pattern pattern = Pattern.compile(
                "\\[(\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2})\\] \\[(INFO|ERROR|DEBUG|WARN)\\] (.+)");

        StringBuilder outputData = new StringBuilder();
        outputData.append("9\n"); // Section 9 header

        // Read input file
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.equals("9")) {
                    inSection9 = true;
                    continue;
                }

                if (inSection9 && line.equalsIgnoreCase("end")) {
                    break;
                }

                if (inSection9) {
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        String timestamp = matcher.group(1);
                        String level = matcher.group(2);
                        String message = matcher.group(3);

                        outputData.append("Timestamp: ").append(timestamp)
                                .append(", Level: ").append(level)
                                .append(", Message: ").append(message)
                                .append("\n");
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return;
        }

        outputData.append("x\n"); // End marker

        // Write output to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) { // Append mode
            writer.write(outputData.toString());
        } catch (IOException e) {
            System.err.println(" Error writing to file: " + e.getMessage());
        }
    }
}
