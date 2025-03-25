import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Problem8 {
    public static void main(String[] args) {
        String inputFile = "D:\\Study\\theory\\ans\\prob8input.txt";
        String outputFile = "D:\\Study\\theory\\ans\\prob8output.txt";
        List<String> inputStrings = new ArrayList<>();
        boolean sectionFound = false;

        // Read the input file
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.equals("8")) {
                    sectionFound = true;
                    continue;
                }
                if (sectionFound && line.equals("end")) {
                    break;
                }
                if (sectionFound) {
                    inputStrings.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println(" Error reading the file: " + e.getMessage());
            return;
        }

        if (inputStrings.isEmpty()) {
            return;
        }

        String input = String.join(" ", inputStrings);

        // Write output to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) { // Append mode
            writer.write("8\n"); // Write section header "8"

            List<String> results = processString(input);
            for (String result : results) {
                writer.write(result + "\n");
            }

            writer.write("x\n"); // Write "x" at the end
        } catch (IOException e) {
            System.out.println(" Error writing to the file: " + e.getMessage());
        }
    }

    private static List<String> processString(String input) {
        List<String> output = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\b\\w{5}(\\w{5})*\\b");
        Matcher matcher = pattern.matcher(input);

        int count = 0;
        while (matcher.find()) {
            count++;
            output.add(matcher.group() + " [" + matcher.start() + ", " + matcher.end() + "]");
        }

        output.add("Number of matched words: " + count);
        return output;
    }
}
