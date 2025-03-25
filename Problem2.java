
import java.io.*;
import java.util.regex.*;

public class Problem2 {

    public static void main(String[] args) throws IOException {
        String inputFilePath = "D:\\\\Study\\\\theory\\\\ans\\\\prob2input.txt";
        String outputFilePath = "D:\\\\Study\\\\theory\\\\ans\\\\prob2output.txt";

        BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

        String line;
        boolean isFirstLine = true;

        // Strict regex ensuring every 'a' is followed by exactly 'bb' or 'bbb', and 'b' alone is valid
        Pattern pattern = Pattern.compile("^b*(?:a(?:b(?!b)|bbb(?!b))b*)*$", Pattern.CASE_INSENSITIVE);

        while ((line = reader.readLine()) != null) {
            line = line.trim();

            if (line.equalsIgnoreCase("end")) {
                writer.write("x\n");
                break;
            }

            if (isFirstLine) {
                writer.write(line + "\n");
                isFirstLine = false;
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

        System.out.println("Validation completed. Check output file.");
    }
}
