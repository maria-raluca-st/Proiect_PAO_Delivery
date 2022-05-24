package services;

import entities.Restaurant;
import entities.Utilizator;
import services.csv.RestaurantCSV;
import services.csv.UtilizatorCSV;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UtilizatorService {
    private static HashMap<String, Utilizator> utilizatori;

    public UtilizatorService() throws FileNotFoundException {
        utilizatori = new HashMap<>();
        for(Utilizator u : UtilizatorCSV.getInstance().load("./csv/utilizatori.csv"))
        {
            utilizatori.put(u.getEmail() ,u);
        }
    }


    public void adaugareUtilizator(String nume, String email, String parola, String telefon, String adresa){
        Utilizator u = new Utilizator(nume, email, parola, telefon, adresa);
        utilizatori.put(email, u);
        UtilizatorCSV.getInstance().add("./csv/utilizatori.csv", u);
    }

    public void adaugareUtilizatori(List<List<String>> useriNoi)
    {
        for(List <String> linie : useriNoi)
        {
            String nume = linie.get(0);
            String email = linie.get(1);
            String parola = linie.get(2);
            String telefon = linie.get(3);
            String adresa = linie.get(4);
            adaugareUtilizator(nume, email, parola, telefon, adresa);
        }
    }

    public String login(String email)
    {
        boolean f = false; // f = false daca userul nu e inregistrat
        for(String e : utilizatori.keySet())
        {
            if(e == email)
                {
                    f = true;
                }
        }
        if(f == false)
        {
            email = null;
        }

        return email;
    }

    public static HashMap<String, Utilizator> getUtilizatori(){
        return utilizatori;
    }


}
