import java.io.*;
import java.util.regex.*;
public class Problem4 {

    

private static void processProblem4(BufferedReader reader, BufferedWriter writer) throws IOException {
        String ipPattern = "^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        processProblem(reader, writer, ipPattern);
    }
}