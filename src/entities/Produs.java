package entities;

public class Produs {
    protected String numeProdus;
    protected String descriereProdus;
    protected Restaurant restaurant;
    protected int pret;

    public Produs(String numeProdus, String descriereProdus, Restaurant restaurant, int pret) {
        this.numeProdus = numeProdus;
        this.descriereProdus = descriereProdus;
        this.restaurant = restaurant;
        this.pret = pret;
    }

    public int getPret() {
        return pret;
    }

    public String getNume() {
        return numeProdus;
    }

    public void print() {
        System.out.print(numeProdus + " " + descriereProdus + " " + pret + " lei ");
    }

    @Override
    public String toString(){
        return numeProdus +","+ "," + descriereProdus + "," + Integer.toString(pret);
    }
}
