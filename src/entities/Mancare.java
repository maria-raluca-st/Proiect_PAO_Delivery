package entities;


import java.util.ArrayList;
import java.util.List;


public class Mancare extends Produs implements Comparable<Mancare>{
    private List<String> ingrediente;
    int greutate;
    public Mancare(String nume, String desc, Restaurant r, int pr, int gr, List <String> ingrediente){
        super(nume, desc, r, pr);
        greutate = gr;
        this.ingrediente = new ArrayList<>(ingrediente);
    }

    @Override
    public void print()
    {
        super.print();
        System.out.print(greutate + "g\nIngrediente:");
        for (String ing:ingrediente)
        {
            System.out.print(ing + " ");
        }
        System.out.print("\n");
    }

    @Override
    public String toString(){
        String ingr = "";
        for(String i : ingrediente)
        {
            ingr += i;
            ingr += ';';
        }
        ingr.substring(0 , ingr.length()-1);
        return super.toString()+","+String.format("%s", greutate) + "," + ingr;
    }

    @Override
    public int compareTo(Mancare m) {
        return this.numeProdus.compareTo(m.numeProdus);
    }
}
