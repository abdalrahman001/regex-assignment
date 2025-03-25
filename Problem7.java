import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Problem7 {
    public static void main(String[] args) {
        String inputFile = "D:\\Study\\theory\\ans\\prob7input.txt";
        String outputFile = "D:\\Study\\theory\\ans\\prob7output.txt";

        List<String> inputStrings = new ArrayList<>();
        boolean sectionFound = false;

        // Read input from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.equals("7")) {
                    sectionFound = true;
                    continue;
                }

                if (line.equals("end")) {
                    sectionFound = false;
                    continue;
                }

                if (sectionFound) {
                    inputStrings.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Write output to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write("7\n");

            for (String input : inputStrings) {
                writer.write("**" + input + "**\n"); // Bold input string

                List<String> results = processString(input);

                // Get count and remove it from results list
                int count = Integer.parseInt(results.get(results.size() - 1));
                results.remove(results.size() - 1);

                writer.write("number of matched substrings: " + count + "\n");

                for (String result : results) {
                    String[] parts = result.split(" ");
                    String substring = parts[0];
                    int start = Integer.parseInt(parts[1]);
                    int end = Integer.parseInt(parts[2]);
                    writer.write(substring + " [" + start + ", " + end + "]\n");
                }

                writer.write("---------------------------------------------\n");
            }

            writer.write("x\n"); // Write "x" at the end
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }

    private static List<String> processString(String input) {
        List<String> output = new ArrayList<>();
        int count = 0;

        for (int start = 0; start < input.length(); start++) {
            for (int end = start; end < input.length(); end++) {
                Pattern subPattern = Pattern
                        .compile("(?<=^.{" + start + "})([ab]+)(?=.{" + (input.length() - end - 1) + "}$)");
                Matcher subMatcher = subPattern.matcher(input);

                if (subMatcher.find()) {
                    String substring = subMatcher.group(1);

                    if (hasOddCount(substring, 'a') && hasOddCount(substring, 'b')) {
                        count++;
                        output.add(substring + " " + start + " " + end);
                    }
                }
            }
        }

        output.add(String.valueOf(count)); // Append the count at the end
        return output;
    }

    private static boolean hasOddCount(String str, char c) {
        Matcher matcher = Pattern.compile("[" + c + "]").matcher(str);
        int occurrences = 0;

        while (matcher.find()) {
            occurrences++;
        }

        return occurrences % 2 == 1;
    }
}
