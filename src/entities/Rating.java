package entities;

public class Rating {
    private Restaurant restaurant;
    private Utilizator utilizator;
    private int scor;

    public Rating(Restaurant r, Utilizator u, int s)
    {
        restaurant = r;
        utilizator = u;
        scor = s;
    }

    public Restaurant getRestaurant(){
        return restaurant;
    }

    public Utilizator getUtilizator(){
        return utilizator;
    }
    public void setScor(int s){
        scor = s;
    }
    public int getScor(){
        return scor;
    }
}
