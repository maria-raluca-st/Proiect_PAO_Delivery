package entities;

public class Racoritoare extends Produs{
    int cantitate;
    public Racoritoare(String nume, String descriere, Restaurant restaurant, int pr, int c){
        super(nume, descriere, restaurant, pr);
        cantitate = c;
    }

    @Override
    public void print(){
        super.print();
        System.out.print(cantitate + "ml\n");
    }
}
