package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import entities.Restaurant;

public class RestaurantService {

    private static HashMap<String, Restaurant> restaurante;

    public RestaurantService() {
        restaurante = new HashMap<>();
    }

    public static int GetIDRestaurant(String nume) {
        int id = 0;
        if (restaurante.containsKey(nume))
            id = restaurante.get(nume).getId();
        return id;
    }


    public void adaugareRestaurant(String nume, String adresa) {
        Restaurant r = new Restaurant(nume, adresa);
        restaurante.put(nume, r);
    }

    public void adaugareRestaurante(ArrayList<ArrayList<String>> rest)
    {

        for(ArrayList <String> line : rest)
        {
            String nume = line.get(0);
            String adresa = line.get(1);
            Restaurant r = new Restaurant(nume, adresa);
            restaurante.put(nume, r);
        }
    }


    public void adaugareMancare(String restaurant, String nume, String desc, int pr, int cantitate, List<String> ingrediente) {

        Restaurant r;
        if (restaurante.containsKey(restaurant))
            r = restaurante.get(restaurant);
        else
        {
            System.out.println("Restaurantul " + restaurant + " nu este disponibil in aplicatie.");
            return;
        }
        r.AddMancare(nume, desc, pr, cantitate, ingrediente);
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
            r = restaurante.get(numeRest);
        else
        {
            System.out.println("Restaurantul " + numeRest + "nu este disponibil in aplicatie.");
            return;
        }
        r.AddRacoritoare(nume, desc, pr, cantitate);
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


    public void Produse()
    {
        for (Restaurant r: restaurante.values())
        {
            System.out.println("Restaurantul " + r.getNume() + " ofera produsele: ");
            r.printProduse();
            System.out.println("\n");
        }
    }


    public void ProduseRest(String restName)
    {
        Restaurant r;
        if(restaurante.containsKey(restName))
            r = restaurante.get(restName);
        else
        {
            System.out.println("Restaurantul " + restName + " nu este disponibil in aplicatie.");
            return;
        }
        r.printProduse();
    }

    public static HashMap<String, Restaurant> getRestaurante()
    {
        return restaurante;
    }

    public boolean gasesteRestaurant(String nume)
    {
        return restaurante.containsKey(nume);
    }
}
