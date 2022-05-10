package entities;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private static int ct = 1;
    private int idRestaurant;
    private String numeRestaurant;
    private String adresaRestaurant;
    private double rating;
    private List<Produs> produse;

    public Restaurant(String nume, String adresa){
        numeRestaurant = nume;
        adresaRestaurant = adresa;
        idRestaurant = ct++;
        rating = 5;
        produse = new ArrayList<>();
    }
    public String getNume(){
        return numeRestaurant;
    }

    public int getId(){
        return idRestaurant;
    }
    public void PrintInfo() {
        System.out.println(idRestaurant);
        System.out.println(numeRestaurant);
        System.out.println(adresaRestaurant);
        System.out.println(rating);
    }
    public void updateRating(List<Rating> l)
    {
        double nr = 0, sum = 0;
        for(Rating rating:l)
        {
            if(rating.getRestaurant() == this)
            {
                sum+=rating.getScor();
                nr++;
            }
        }
        rating = sum/nr;
    }

    public void AddMancare(String nume, String desc, int pr, int cantitate, List <String> ingrediente){
        Produs p;
        p = new Mancare(nume, desc, this, pr, cantitate, ingrediente);
        produse.add(p);
    }

    public void AddRacoritoare(String nume, String desc, int pr, int cantitate){
        Produs p;
        p = new Racoritoare(nume, desc, this, pr, cantitate);
        produse.add(p);
    }

    public Produs takeProdus(String nume){
        for(Produs p:produse)
            if(p.getNume().equals(nume))
                return p;
        return null;
    }

    public void printProduse()
    {
        for (Produs p:produse)
            p.print();
    }

    public void printRating(){
        System.out.println("Restaurantul " + numeRestaurant + " are ratingul " + rating);
    }

    @Override
    public String toString(){
        return numeRestaurant + ',' + adresaRestaurant + ',' + Double.toString(rating);
    }
}
