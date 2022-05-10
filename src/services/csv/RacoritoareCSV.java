package services.csv;


import entities.Racoritoare;
import entities.Restaurant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class RacoritoareCSV implements SingletonCSV<Racoritoare>{

    private static final RacoritoareCSV INSTANCE = new RacoritoareCSV();

    private final String auditPath = "./csv/audit.csv";

    private RacoritoareCSV(){}

    @Override
    public ArrayList<Racoritoare> load(String fileName) throws FileNotFoundException {
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        ArrayList<Racoritoare> racoritoare = new ArrayList<Racoritoare>();
        try {
            String line = csvReader.readLine();
            while (line != null)
            {
                String[] data = line.split(",");
                Racoritoare racorit = new Racoritoare(data[0], data[1], new Restaurant(data[2], data[3]),Integer.parseInt(data[4]), Integer.parseInt(data[5]));
                racoritoare.add(racorit);
                line = csvReader.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        audit(auditPath, "incarcare_racoritoare");
        return racoritoare;
    }


    @Override
    public void add(String fileName, Racoritoare content) {
        FileWriter csvWriter = null;
        try {
            csvWriter = new FileWriter(fileName, true);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            csvWriter.append(content.toString());
            csvWriter.append("\n");
            csvWriter.flush();
            csvWriter.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        audit(auditPath, "add_racoritoare");
    }

    public static RacoritoareCSV getInstance() {
        return INSTANCE;
    }

}
