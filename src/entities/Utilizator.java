package entities;

import java.util.List;

public class Utilizator {

    private String nume;
    private String email;
    private String parola;
    private String numarTelefon;
    private String adresaUtilizator;

    public Utilizator(String n, String e, String ps, String pn, String ad)
    {
        nume = n;
        email = e;
        parola = ps;
        numarTelefon = pn;
        adresaUtilizator = ad;
    }

    public void giveRating(List <Rating> l, Restaurant r, int scor)
    {
        if(scor < 1 || scor > 5)
        {
            System.out.println("Ratingul este de la 1 la 5.");
            return;
        }

        boolean found = false;

        for (Rating rating: l)
        {
            if(rating.getUtilizator() == this && rating.getRestaurant() == r)
            {
                rating.setScor(scor);
                found = true;
            }
        }

        if(found == false)
        {
            Rating newR = new Rating(r, this, scor);
            l.add(newR);
        }
        r.updateRating(l);
    }
    public void printUtilizator()
    {
        System.out.println("Nume " + nume + " are mailul " + email + "\n");
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString(){
        return nume+ "," + email + ',' + parola + ',' + numarTelefon + ',' + adresaUtilizator;
    }


}

