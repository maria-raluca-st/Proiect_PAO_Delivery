package menu;

import entities.*;
import services.*;

import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class menuapp {
    private Scanner s = new Scanner(System.in);
    private RestaurantService restaurantServices = new RestaurantService();
    private UtilizatorService utilizatorServices = new UtilizatorService();

    public menuapp() throws FileNotFoundException {
    }

    public static void main(String args[]) throws FileNotFoundException {
        menuapp meniuaplicatie = new menuapp();
        System.out.println("Meniu aplicatie livrare mancare");
        while (true)
        {
            System.out.println("""
            0.Exit
            1.Adaugare utilizator
            2.Afisare mailuri utilizatori
            3.Log in
            4.Adaugare restauant
            5.Adaugare restaurante
            6.Adaugare mancare
            7.Adaugare mancaruri
            8.Adaugare racoritoare ( o buc )
            9.Adaugare mai multe racoritoare
            10.Afisare meniu complet
            11.Afisare meniu restaurant"""
        );
            System.out.println("Optiune: ");
            int option = meniuaplicatie.Optiune();
            meniuaplicatie.meniu(option);
        }
    }

    private int Optiune()
    {
        try
        {
            int optiune = Integer.parseInt(s.nextLine());
            if (optiune >= 0 && optiune < 12)
            {
                return optiune;
            }
        }
        catch (Exception invalid)
        {

        }
        System.out.println("Optiune invalida.Incercati din nou.");
        return Optiune();
    }

    private void meniu(int optiune)
    {
        if(optiune == 1)
        {
            System.out.println("Nume:");
            String nume = s.nextLine();
            System.out.println("Mail:");
            String mail = s.nextLine();
            System.out.println("Parola:");
            String parola = s.nextLine();
            System.out.println("Telefon:");
            String telefon = s.nextLine();
            System.out.println("Adresa:");
            String adresa = s.nextLine();
            utilizatorServices.adaugareUtilizator(nume, mail,parola,telefon,adresa);
        }
        else if(optiune == 2)
        {
           for(String e : UtilizatorService.getUtilizatori().keySet())
           {
               System.out.println(e);

           }
        }
        else if(optiune == 3)
        {
            System.out.println("Mail:");
            String mail = s.nextLine();
            utilizatorServices.login(mail);
        }
        else if(optiune == 4)
        {
            System.out.println("Nume restaurant:");
            String nume = s.nextLine();
            System.out.println("Adresa restaurant:");
            String adresa = s.nextLine();
            restaurantServices.adaugareRestaurant(nume,adresa);
        }
        else if(optiune == 5)
        {
            ArrayList<ArrayList<String>> rest = new ArrayList<ArrayList<String>>();
            ArrayList<String> r = new ArrayList<>();
            System.out.println("Numar restaurante:");
            int nr = Integer.parseInt(s.nextLine());
            for(int i = 1; i<= nr; i++)
            {
                System.out.println("Nume restaurant:");
                String nume = s.nextLine();
                r.add(nume);
                System.out.println("Adresa restaurant:");
                String adresa = s.nextLine();
                r.add(adresa);
                rest.add(r);
                r.clear();
            }
            restaurantServices.adaugareRestaurante(rest);

        }
        else if(optiune == 6)
        {
            System.out.println("Nume restaurant:");
            String nume = s.nextLine();
            System.out.println("Nume mancare:");
            String numem = s.nextLine();
            System.out.println("Descriere mancare:");
            String desc = s.nextLine();
            System.out.println("Pret mancare:");
            int pret = Integer.parseInt(s.nextLine());
            System.out.println("Cantitate mancare:");
            int cantitate = Integer.parseInt(s.nextLine());
            System.out.println("Numar ingrediente :");
            int nring = Integer.parseInt(s.nextLine());
            System.out.println("Ingrediente mancare:");
            ArrayList <String> Ingred = new ArrayList<>();
            for ( int i = 1 ; i <= nring ; i++)
            {
                String ing = s.nextLine();
                Ingred.add(ing);
            }
            restaurantServices.adaugareMancare(nume,numem,desc,pret,cantitate,Ingred);
        }
        else if(optiune == 7)
        {
            System.out.println("Numar produse mancare : ");
            int nrmancare = Integer.parseInt(s.nextLine());
            ArrayList<ArrayList<String>> m = new ArrayList<ArrayList<String>>();
            ArrayList<String> mm = new ArrayList<>();
            for(int i = 1 ; i <= nrmancare; i++)
            {
                System.out.println("Nume restaurant:");
                String nume = s.nextLine();
                mm.add(nume);
                System.out.println("Nume mancare:");
                String numem = s.nextLine();
                mm.add(numem);
                System.out.println("Descriere mancare:");
                String desc = s.nextLine();
                mm.add(desc);
                System.out.println("Pret mancare:");
                String pret = s.nextLine();
                mm.add(pret);
                System.out.println("Cantitate mancare:");
                String cantitate = s.nextLine();
                mm.add(cantitate);
                System.out.println("Numar ingrediente :");
                int nring = Integer.parseInt(s.nextLine());
                System.out.println("Ingrediente mancare:");
                ArrayList <String> Ingred = new ArrayList<>();
                for ( int j = 1 ; j <= nring ; j++)
                {
                    String ing = s.nextLine();
                    Ingred.add(ing);
                }
                mm.add(String.valueOf(Ingred));
                m.add(mm);
                mm.clear();
                Ingred.clear();
            }
            restaurantServices.adaugareMancaruri(m);

        }
        else if(optiune == 8)
        {
            System.out.println("Nume restaurant:");
            String nume = s.nextLine();
            System.out.println("Nume racoritoare:");
            String numerac = s.nextLine();
            System.out.println("Descriere racoritoare:");
            String desc = s.nextLine();
            System.out.println("Pret racoritoare:");
            int pret = Integer.parseInt(s.nextLine());
            System.out.println("Cantitate racoritoare:");
            int cantitate = Integer.parseInt(s.nextLine());
            restaurantServices.adaugareRacoritoare(nume,numerac,desc,pret,cantitate);
        }
        else if(optiune == 9)
        {
            System.out.println("Numar produse racoritoare(bauturi) : ");
            int nrr = Integer.parseInt(s.nextLine());
            ArrayList<ArrayList<String>> r = new ArrayList<ArrayList<String>>(); //arrayul pt racoritoare
            ArrayList<String> rr = new ArrayList<>();  //array pt un produs
            for(int i = 1 ; i <= nrr ; i ++)
            {
                System.out.println("Nume restaurant:");
                String nume = s.nextLine();
                rr.add(nume);
                System.out.println("Nume racoritoare:");
                String numerac = s.nextLine();
                rr.add(numerac);
                System.out.println("Descriere racoritoare:");
                String desc = s.nextLine();
                rr.add(desc);
                System.out.println("Pret racoritoare:");
                String pret = s.nextLine();
                rr.add(pret);
                System.out.println("Cantitate racoritoare:");
                String cantitate = s.nextLine();
                rr.add(cantitate);
                r.add(rr);
                rr.clear();
            }
            restaurantServices.adaugareMRacoritoare(r);

        }
        else if(optiune == 10)
        {
             restaurantServices.Produse();
        }
        else if(optiune == 11)
        {
            System.out.println("Nume restaurant:");
            String nume = s.nextLine();
            restaurantServices.ProduseRest(nume);
        }
        else if(optiune == 0)
        {
            System.exit(0);
        }
        else
        {
            System.out.println("Optiune invalida.");
        }
    }
}
