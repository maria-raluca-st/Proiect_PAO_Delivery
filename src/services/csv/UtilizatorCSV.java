package services.csv;

import entities.Racoritoare;
import entities.Restaurant;
import entities.Utilizator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class UtilizatorCSV implements SingletonCSV<Utilizator> {
    private static final UtilizatorCSV INSTANCE = new UtilizatorCSV();

    private final String auditPath = "./csv/audit.csv";

    private UtilizatorCSV(){}

    @Override
    public ArrayList<Utilizator> load(String fileName) throws FileNotFoundException {
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        ArrayList<Utilizator> utilizatori = new ArrayList<Utilizator>();
        try {
            String line = csvReader.readLine();
            while (line != null)
            {
                String[] data = line.split(",");
                Utilizator utilizator = new Utilizator(data[0], data[1], data[2] ,data[3],data[4]);
                utilizatori.add(utilizator);
                line = csvReader.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        audit(auditPath, "incarcare_racoritoare");
        return utilizatori;
    }


    @Override
    public void add(String fileName, Utilizator content) {
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
        audit(auditPath, "add_utilizator");
    }

    public static UtilizatorCSV getInstance() {
        return INSTANCE;
    }
}
