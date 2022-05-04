package entities;

import java.util.Date;
import java.util.List;
import java.util.Random;

public class Comanda implements Comparable<Comanda>{
    private static int contor = 1;
    private int idComanda;
    private int idRestaurant;
    private String emailUtilizator;
    private List<Produs> produse;
    private int cost;
    private Date data;
    private Sofer sofer;
    private int timpProcesare; // timp procesare comanda in minute
    private Date timpFinalizare;


    public Comanda(int id, String mailutilizator, List <Produs> p){
        idComanda = contor++;
        idRestaurant = id;
        emailUtilizator = mailutilizator;
        produse = p;
        cost = calculCost();
        data = new Date();
        timpProcesare = 60;

        long timpCurent = data.getTime();
        timpFinalizare = new Date(timpCurent + (timpProcesare * 60000));
    }

    private int calculCost(){
        int costTotal = 0;
        for(Produs p: produse)
            costTotal += p.getPret();
        return costTotal;
    }

    public void setSofer(Sofer s){
        sofer = s;
    }

    public void PrintOrder(){
        System.out.println(new StringBuilder().append("ID Comanda: ").append(idComanda).toString());
        System.out.println(new StringBuilder().append("ID: Restaurant ").append(idRestaurant).toString());
        System.out.println(emailUtilizator);
        System.out.println(new StringBuilder().append("Cost Comanda : ").append(cost).append(" lei").toString());
        System.out.println(new StringBuilder().append("Comanda plasata la : ").append(data).toString());
        System.out.println(new StringBuilder().append("Comanda livrata la : ").append(timpFinalizare).toString());
    }

    public Date getTimpFinalizare(){
        return timpFinalizare;
    }

    public Sofer getSofer(){
        return sofer;
    }

    public String getEmailUtilizator() {
        return emailUtilizator;
    }

    @Override
    public int compareTo(Comanda c) {
        return c.timpFinalizare.compareTo(timpFinalizare);
    }
}
