package com.jcaa.usersmanagement.domain.valueobject;

import java.util.Objects;

public class Ponderacion {
    private final double valor; 

    public Ponderacion(double valor){
        if (valor < 0 || valor > 5.0) {
            throw new IllegalArgumentException("La ponderación debe estar entre 0 y 5.0.");
        }
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    @Override 
    public boolean equals(Object ob){
        if (this == ob) return true;
        if ( ob == null || getClass() != ob.getClass()) return false;
        Ponderacion that = (Ponderacion) ob;
        return Double.compare(that.valor, valor) == 0;
    }

    @Override 
    public int hashCode() {
        return Objects.hash(valor);
    }

}
