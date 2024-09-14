import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.SwingUtilities;

public class MVC {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        List<Cow> list = retriveCowFromDatabase();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CowView(list).setVisible(true);
            }
        });
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

    private static List<Cow> retriveCowFromDatabase() throws FileNotFoundException, IOException {
        List<Cow> cowlist = new ArrayList<>();
        List<List<String>> db = new ArrayList<>();
        db = readCSV();
        for (List<String> list : db) {
            Cow cow = new Cow();
            cow.setNumber(Integer.valueOf(list.get(0).replace("ï»¿", "").trim()));
            cow.setColor(list.get(1));
            cow.setYear(Integer.valueOf(list.get(2)));
            cow.setMonth(Integer.valueOf(list.get(3)));
            cowlist.add(cow);
        }
        return cowlist;
    }
}
