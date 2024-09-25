import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Arrows {

    private static String read() {
        String line = "";
        try (BufferedReader input = new BufferedReader(new FileReader("input.txt"))) {
            line = input.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return line;
    }

    private static int countArrows(String line) {
        if (line.length() < 5)
            return 0;
        int pos1 = 0, pos2 = 0, pos1tmp, pos2tmp, counter = 0;
        pos1tmp = line.indexOf(">>-->", pos1);
        pos2tmp = line.indexOf("<--<<", pos2);
        while (pos1tmp != -1 || pos2tmp != -1) {
            if (pos1tmp != -1) {
                pos1 = pos1tmp + 1;
                counter++;
            }
            if (pos2tmp != -1) {
                pos2 = pos2tmp + 1;
                counter++;
            }
            pos1tmp = line.indexOf(">>-->", pos1);
            pos2tmp = line.indexOf("<--<<", pos2);
        }
        return counter;
    }

    public static void main(String[] args) {
        String inputLine = read();
        int counter = countArrows(inputLine);
        System.out.println(counter);
    }
}