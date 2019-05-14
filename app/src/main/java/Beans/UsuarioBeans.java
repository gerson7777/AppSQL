package Beans;

/**
 * Created by BYTE on 08/07/2018.
 */

public class UsuarioBeans {

    private int cod;
    private  String nom, dis, cor,pas;

    public UsuarioBeans() {

    }

    public UsuarioBeans(int cod, String nom, String dis, String cor, String pas) {
        this.cod = cod;
        this.nom = nom;
        this.dis = dis;
        this.cor = cor;
        this.pas = pas;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDis() {
        return dis;
    }

    public void setDis(String dis) {
        this.dis = dis;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPas() {
        return pas;
    }

    public void setPas(String pas) {
        this.pas = pas;
    }

    @Override
    public String toString() {
        return cod + " - " + nom + " - " + dis + " - " + cor;
    }
}
