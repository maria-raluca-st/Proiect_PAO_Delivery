package services.csv;

import entities.Racoritoare;
import entities.Restaurant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class RestaurantCSV implements SingletonCSV<Restaurant>{

    private static final RestaurantCSV INSTANCE = new RestaurantCSV();

    private final String auditPath = "./csv/audit.csv";

    private RestaurantCSV(){}

    @Override
    public ArrayList<Restaurant>load(String fileName) throws FileNotFoundException {
        BufferedReader csvReader = new BufferedReader(new FileReader(fileName));
        ArrayList<Restaurant> restaurante = new ArrayList<Restaurant>();
        try {
            String line = csvReader.readLine();
            while (line != null)
            {
                String[] data = line.split(",");
                Restaurant restaurant = new Restaurant(data[0], data[1]);
                restaurante.add(restaurant);
                line = csvReader.readLine();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        audit(auditPath, "incarcare_restaurante");
        return restaurante;
    }


    @Override
    public void add(String fileName, Restaurant content) {
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
        audit(auditPath, "add_restaurante");
    }

    public static RestaurantCSV getInstance() {
        return INSTANCE;
    }
}
