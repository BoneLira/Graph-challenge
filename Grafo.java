import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Grafo {

    public static void main(String[] args) {
        String fileName = "pequenoG.txt";

        try {
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
