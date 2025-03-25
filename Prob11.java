import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.regex.*;

public class Prob11{
    public static void main(String[] args) {
        String endRegex="^end";
        String regex = "^\\b\\w+\\b(?:\\s+\\b\\w+\\b){6}$";   
        String inputFilePath = "D:\\Study\\theory\\ans\\prob11input.txt";
        String outputFilePath = "D:\\Study\\theory\\ans\\prob11output.txt";

        String[] expressions = {
            "11",
            "The sky turned orange at sunset today",
            "Creativity makes life more interesting",
            "end",
            
        };
        try (
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))
        ){
        for (String exp : expressions) {
            if (exp.matches("\\d+")) {  // Checks if exp contains only digits
                System.out.println(exp);
                continue;
            }
            if (exp.matches(endRegex)) {  // Checks if exp contains only digits
                System.out.println("x");
                continue;
            }
            boolean isValid = exp.matches(regex) ;
            writer.println( (isValid ? "valid" : "invalid"));
        }
    }catch (Exception e) {
        // TODO: handle exception
    }}
}
