package model;

import java.util.Date;

public class Reembolso {
    private Date data;
    private double valor;

    public Reembolso(double valor) {
        data = new Date();
        this.valor= valor;
    }

    public Date getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }
}
