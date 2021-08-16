package clases;

import java.util.Date;

public class Boleta {
    private String codbol,fecemi,codped;
    private double pretotal;
    private int idusuario;

    public Boleta() {
    }

    public String getCodbol() {
        return codbol;
    }

    public void setCodbol(String codbol) {
        this.codbol = codbol;
    }

    public String getFecemi() {
        return fecemi;
    }

    public void setFecemi(String fecemi) {
        this.fecemi = fecemi;
    }

    public String getCodped() {
        return codped;
    }

    public void setCodped(String codped) {
        this.codped = codped;
    }

    public double getPretotal() {
        return pretotal;
    }

    public void setPretotal(double pretotal) {
        this.pretotal = pretotal;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idususario) {
        this.idusuario = idususario;
    } 
}
