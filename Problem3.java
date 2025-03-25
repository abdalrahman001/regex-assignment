
import java.io.*;
import java.util.regex.*;

public class Problem3 {

    public static void main(String[] args) throws IOException {

        String inputFilePath = "D:\\Study\\theory\\ans\\prob3input.txt";
        String outputFilePath = "D:\\Study\\theory\\ans\\prob3output.txt";

        BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

        //  regex pattern to match valid date formats
        String regex = "^(\\d{4}[-/]\\d{1,2}[-/]\\d{1,2})$|^(\\d{1,2}[-/]\\d{1,2}[-/]\\d{4})$";
        Pattern pattern = Pattern.compile(regex);

        String line;
        boolean firstLine = true;

        while ((line = reader.readLine()) != null) {
            line = line.trim();

            if (line.equalsIgnoreCase("end")) {
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

        System.out.println("Validation completed. Check output file.");
    }
}
