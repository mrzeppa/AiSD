import java.io.*;
import java.util.Scanner;

public class FileSupport {
    public static String getElemFromFile(String fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder("");
        Scanner scanner = new Scanner(new File(fileName));
        PrintStream out = new PrintStream(new File("outfile.txt"));
        String result = "";
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            sb.append(line);

        }
        return sb.toString();
    }

}
