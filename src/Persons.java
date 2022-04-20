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
    Path myPath = Paths.get("longPersons.txt");

    public Persons() throws Exception {
        readFile();
        // data = Files.readAllLines(myPath);
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
        try {
            Files.createFile(myPath);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        try (PrintWriter w = new PrintWriter(Files.newBufferedWriter(myPath));) {

            for (int i = 0; i < infoList.size(); i++) {
                String[] parts = infoList.get(i).split(", ");
                int length = Integer.parseInt(parts[2]);
                System.out.println(length);
                if (length > 200) {
                    w.println(personList.get(i));
                    w.println(infoList.get(i));
                    System.out.println(personList.get(i));
                    System.out.println(infoList.get(i));
                }
            }
            w.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
