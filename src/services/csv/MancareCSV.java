package services.csv;

import entities.Mancare;
import entities.Racoritoare;
import entities.Restaurant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class MancareCSV implements SingletonCSV<Mancare>{
    private static final MancareCSV INSTANCE = new MancareCSV();

    private final String auditPath = "./csv/audit.csv";

    private MancareCSV(){}

    @Override
    public ArrayList<Mancare> load(String fileName) throws FileNotFoundException {
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        ArrayList<Mancare> mancare = new ArrayList<Mancare>();
        try {
            String line = csvReader.readLine();
            while (line != null)
            {
                String[] data = line.split(",");
                String[] ingr = line.split(";");
                List<String> l = new ArrayList<>();
                Collections.addAll(l, ingr);
                Mancare manc = new Mancare(data[0], data[1], new Restaurant(data[2], data[3]),Integer.parseInt(data[4]), Integer.parseInt(data[5]),l);
                mancare.add(manc);
                line = csvReader.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        audit(auditPath, "incarcare_racoritoare");
        return mancare;
    }


    @Override
    public void add(String fileName, Mancare content) {
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
        audit(auditPath, "add_mancare");
    }

    public static MancareCSV getInstance() {
        return INSTANCE;
    }
}
