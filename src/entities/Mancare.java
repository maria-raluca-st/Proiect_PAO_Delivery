package entities;


import java.util.ArrayList;
import java.util.List;


public class Mancare extends Produs{
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
            System.out.print(ing + " ");
        System.out.print("\n");
    }
}
