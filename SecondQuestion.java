import java.io.*;
import java.util.regex.*;

public class SecondQuestion {
    public static void main(String[] args) {
        String inputFile = "D:\\Study\\theory\\assignment1\\ans\\SecondQues.txt";
        String outputFile = "D:\\Study\\theory\\assignment1\\ans\\sample_output.txt";
        StringBuilder outputData = new StringBuilder();

        outputData.append("13\n"); 

        // Read input file
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                String sanitizedLine = sanitizeText(line);
                outputData.append(sanitizedLine).append("\n");
            }
        } catch (IOException e) {
            System.err.println(" Error reading file: " + e.getMessage());
            return;
        }

        outputData.append("x\n");

        // Write output to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) { // Append mode
            writer.write(outputData.toString());
        } catch (IOException e) {
            System.err.println(" Error writing to file: " + e.getMessage());
        }
    }

    private static String sanitizeText(String text) {
        text = replaceWithPattern(text, "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b",
                "********************"); // Email
        text = replaceWithPattern(text, "(?<!\\d)\\d{14}(?!\\d)", "**************"); // Egyptian National ID (14 digits)
        text = replaceWithPattern(text, "\\b0?1[0-5]\\d{8}\\b", "************"); // Egyptian Phone Number
        text = replaceWithPattern(text, "\\b\\d{4}(?:\\s?\\d{4}){3}\\d{1}\\b", "****************"); // Bank Account (17
                                                                                                    // digits)
        text = replaceWithPattern(text, "\\bEG\\d{2}\\s?(?:\\d{4}\\s?){6}\\d{1}\\b", "****************"); // IBAN
        text = replaceWithPattern(text, "\\b[A-Z]{8,11}\\b", "************"); // Swift Code
        return text;
    }

    private static String replaceWithPattern(String text, String regex, String replacement) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll(replacement);
    }
}
