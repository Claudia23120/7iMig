package com.example.practica.model;


import javafx.scene.image.Image;

import java.io.File;

public class Carta {
    private int num;
    private PalCarta pal;
    private float valor;
    private Image imatge;

    /**
     * Constructor per crear les Cartes amb el seu pal i el seu valor cridant un metode helpper
     * @param num --> Numero de carta
     * @param pal --> Pal de la carta
     */
    public Carta(int num, PalCarta pal){
        this.num = num;
        this.pal = pal;
        this.valor = calcularValor(num);
        String aux = num+"_"+pal+".png";
        this.imatge = new Image(new File(String.format("src/main/resources/images/"+aux)).toURI().toString());
    }

    /**
     * Metode privat (helpper) per calcular el valor de la carta
     * @param num --> Numero per saber si es mes gran de 7 que valgui 0,5.
     * @return --> Retorna el valor de la carta (float)
     */
    private float calcularValor (int num){
        float x;
        if (num <= 7){
            x = num;
        }else{
            x = 0.5f;
        }
        return x;
    }

    /**
     * Getter del Numero de la Carta
     * @return --> retorna el numero de la carta
     */
    public int getNum() {
        return num;
    }

    /**
     * Getter del Pal de la Carta
     * @return --> retorna el pal de la carta
     */
    public PalCarta getPal() {
        return pal;
    }

    /**
     * Getter del Valor de la Carta
     * @return --> retorna el valor de la carta
     */
    public float getValor() {
        return valor;
    }


    public Image getImatge() {
        return imatge;
    }

    /**
     * Metode ToString per veure la informació completa de la carta
     * @return --> Num, Pal i valor
     */
    @Override
    public String toString() {
        return num +
                " de " + pal  +
                ", valor: " + valor ;
    }



}
