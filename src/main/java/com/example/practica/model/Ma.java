package com.example.practica.model;

import java.util.ArrayList;

public class Ma {
    private ArrayList<Carta> ma;
    private float valorMa;

    /**
     * Constructor per crear un ArrayList de Cartes (Ma)
     */
    public Ma(){
        ma = new ArrayList<>();
    }

    /**
     * Getter per saber el valor de la Ma
     * @return --> Valor Ma
     */
    public float getValorMa() {
        return valorMa;
    }

    /**
     * Metode per afegir carta a la ma i calcular de nou el valor de la ma
     * @param carta --> Carta donada
     */
    public void afegirCarta (Carta carta) {
        ma.add(carta);
        calculMa(ma);
    }

    /**
     * Metode helpper per calcular el valor de la ma
     * @param ma --> ArrayList de ma (banca o jugador)
     */
    private void calculMa (ArrayList<Carta> ma){
        float x = 0.0f;
        for (int i = 0; i < ma.size(); i++) {
            x = valorMa+ ma.get(i).getValor();
        }
        this.valorMa =x;
    }



    /**
     * Metode ToString per veure la ma i el valor de la propia
     * @return --> Ma sencera i el seu valor
     */
    @Override
    public String toString() {
        return " " + ma +
                "\n  Valor de la Ma: " + valorMa ;
    }
}
