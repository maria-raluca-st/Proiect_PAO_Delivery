package services;

import java.io.FileNotFoundException;
import java.util.*;

import entities.Mancare;
import entities.Racoritoare;
import entities.Restaurant;
import services.csv.MancareCSV;
import services.csv.RacoritoareCSV;
import services.csv.RestaurantCSV;

public class RestaurantService {

    private HashMap<String, Restaurant> restaurante;

    private NavigableSet<Mancare> mancare = new TreeSet<>();
    private ArrayList<Racoritoare> racoritoare = new ArrayList<>();
    private final MancareCSV mancareCSV = MancareCSV.getInstance();

    public RestaurantService() throws FileNotFoundException {
        restaurante = new HashMap<>();
        mancare.addAll(MancareCSV.getInstance().load("./csv/mancare.csv"));
        racoritoare.addAll(RacoritoareCSV.getInstance().load("./csv/racoritoare.csv"));
        for(Restaurant r : RestaurantCSV.getInstance().load("./csv/restaurante.csv"))
        {
                restaurante.put(r.getNume() ,r);
        }

    }

    public int getIDRestaurant(String nume) {
        int id = 0;
        if (restaurante.containsKey(nume))
        {
            id = restaurante.get(nume).getId();
        }
        return id;
    }


    public void adaugareRestaurant(String nume, String adresa) {
        Restaurant r = new Restaurant(nume, adresa);
        restaurante.put(nume, r);
        RestaurantCSV.getInstance().add("./csv/restaurante.csv", r);
    }

    public void adaugareRestaurante(ArrayList<ArrayList<String>> rest)
    {

        for(ArrayList <String> line : rest)
        {
            String nume = line.get(0);
            String adresa = line.get(1);
            Restaurant r = new Restaurant(nume, adresa);
            restaurante.put(nume, r);
            RestaurantCSV.getInstance().add("./csv/restaurante.csv", r);
        }
    }


    public void adaugareMancare(String restaurant, String nume, String desc, int pr, int cantitate, List<String> ingrediente) {

        Restaurant r;
        if (restaurante.containsKey(restaurant))
        {
            r = restaurante.get(restaurant);
        }
        else
        {
            System.out.println("Restaurantul " + restaurant + " nu este disponibil in aplicatie.");
            return;
        }
        r.addMancare(nume, desc, pr, cantitate, ingrediente);
        Mancare m = new Mancare(nume, desc,r, pr,cantitate, ingrediente);
        mancareCSV.add("./csv/mancare.csv",m);
    }

    public void adaugareMancaruri(ArrayList<ArrayList <String>> foods){

        for(ArrayList <String> line : foods)
        {
            String numeRest = line.get(0);
            String numeProdus = line.get(1);
            String desc = line.get(2);
            int pret= Integer.parseInt(line.get(3));
            int cantitate = Integer.parseInt(line.get(4));
            List <String> ingrediente = Arrays.asList(line.get(5).split(","));
            adaugareMancare(numeRest, numeProdus, desc, pret, cantitate, ingrediente);

        }
    }

    public void adaugareRacoritoare(String numeRest, String nume, String desc, int pr, int cantitate){
        Restaurant r;
        if(restaurante.containsKey(numeRest))
        {
            r = restaurante.get(numeRest);
        }
        else
        {
            System.out.println("Restaurantul " + numeRest + "nu este disponibil in aplicatie.");
            return;
        }
        r.addRacoritoare(nume, desc, pr, cantitate);
        Racoritoare ra = new Racoritoare(nume, desc, r, pr,cantitate);
        RacoritoareCSV.getInstance().add("./csv/racoritoare.csv",ra);
    }

    public void adaugareMRacoritoare(ArrayList<ArrayList <String>> r){

        for(ArrayList <String> line : r )
        {

            String numeRest = line.get(0);
            String numeProdus = line.get(1);
            String desc = line.get(2);
            int pret = Integer.parseInt(line.get(3));
            int cantitate = Integer.parseInt(line.get(4));
            adaugareRacoritoare(numeRest, numeProdus, desc, pret, cantitate);
        }
    }


    public void produse()
    {
        for (Restaurant r: restaurante.values())
        {
            System.out.println("Restaurantul " + r.getNume() + " ofera produsele: ");
            r.printProduse();
            System.out.println("\n");
        }
    }


    public void produseRest(String restName)
    {
        Restaurant r;
        if(restaurante.containsKey(restName))
        {
            r = restaurante.get(restName);
        }
        else
        {
            System.out.println("Restaurantul " + restName + " nu este disponibil in aplicatie.");
            return;
        }
        r.printProduse();
    }

    public HashMap<String, Restaurant> getRestaurante()
    {
        return restaurante;
    }

    public boolean gasesteRestaurant(String nume)
    {
        return restaurante.containsKey(nume);
    }
}
