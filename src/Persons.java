import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Persons {
    List<String> data = new ArrayList<>();
    List<String> personList = new ArrayList<>();
    List<String> infoList = new ArrayList<>();
    boolean even = true;

    public Persons() throws Exception {
        readFile();
        for (String line : data) {
            System.out.println(line);
            if (even) {
                personList.add(line);
                even = false;
            } else {
                infoList.add(line);
                even = true;
            }
        }
        for (String line : personList) {
            System.out.println(line);
        }
        for (String line : infoList) {
            System.out.println(line);
        }
        writeFile();
    }

    public void readFile() {
        String line;
        try (BufferedReader bufIn = new BufferedReader(new FileReader("persons.txt"));) {
            while ((line = bufIn.readLine()) != null) {
                data.add(line);
            }
        } catch (Exception e) {
            System.out.println("File could not be found");
        }
    }

    public void writeFile() {
        Path myPath = Paths.get("longPersons.txt");
        PrintWriter w;
        try {
            w = new PrintWriter(Files.newBufferedWriter(myPath));
            w.print("test");
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
