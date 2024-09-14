import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MVC {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        List<List<String>> db = new ArrayList<>();
        db = readCSV();
        for (List<String> list : db) {
            System.out.println(list);
        }
    }

    private static final String COMMA_DELIMITER = ",";

    private static List<List<String>> readCSV() throws FileNotFoundException, IOException {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Database.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        }
        return records;
    }

    private static Cow retriveCowFromDatabase() {
        Cow cow = new Cow();
        
        return cow;
    }
}
