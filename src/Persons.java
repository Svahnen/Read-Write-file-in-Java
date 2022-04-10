import java.io.BufferedReader;
import java.io.FileReader;
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
}