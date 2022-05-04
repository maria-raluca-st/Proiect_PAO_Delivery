package services;

import entities.Utilizator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UtilizatorService {
    private static HashMap<String, Utilizator> utilizatori;

    public UtilizatorService()
    {
        utilizatori = new HashMap<>();
    }


    public void adaugareUtilizator(String nume, String email, String parola, String telefon, String adresa){
        Utilizator u = new Utilizator(nume, email, parola, telefon, adresa);
        utilizatori.put(email, u);
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
            if(e == email)
                f = true;
        if(f == false)
            email = null;

        return email;
    }

    public static HashMap<String, Utilizator> getUtilizatori(){
        return utilizatori;
    }


}
