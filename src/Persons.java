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
    List<String> personList = new ArrayList<>();

    public Persons() throws Exception {
        readFile();
        if (personList.size() > 0) {
            // TODO: Code here
        } else {
            throw new Exception("List is empty"); // Currently no error handling for wrong format
        }
        for (String person : personList) {
            System.out.println(person);
        }
        writeFile();
    }

    public void readFile() {
        String line;
        try (BufferedReader bufIn = new BufferedReader(new FileReader("persons.txt"));) {
            while ((line = bufIn.readLine()) != null) {
                personList.add(line);
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
