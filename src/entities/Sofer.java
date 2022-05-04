package entities;

import java.util.Date;
import java.util.Random;

public class Sofer {
    private String numeSofer;
    private String emailSofer;
    private String telefonSofer;
    private double salariu;
    private boolean activ;

    public Sofer(String name, String email, String phone, double sal) {
        this.numeSofer = name;
        this.emailSofer= email;
        this.telefonSofer = phone;
        this.salariu = sal;
        this.activ = true; // sofer activ = 1 , sofer inactiv = 0 (activ = aofer logged in in aplicatie)
    }

}
