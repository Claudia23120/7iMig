package com.example.practica.model;

import java.util.ArrayList;

public class Baralla {
    private ArrayList<Carta> baralla = new ArrayList<>();
    private int [] num = {1, 2, 3, 4, 5, 6, 7, 10, 11, 12};
    private PalCarta [] pal = {PalCarta.Or,PalCarta.Bastos,PalCarta.Copes,PalCarta.Espases};
    private Carta carta;
    private ArrayList<Integer> numCartes ;

    /**
     * Metode per crear la Baralla cada cop que vulguis jugar
     * Crea Cartes a partir de dos vectors (num i pal) i les afegeix al ArrayList baralla
     */
    public void crearBaralla () {
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < pal.length; j++) {
                carta = new Carta(num[i],pal[j]);
                baralla.add(carta);
            }
        }
        numCartes = new ArrayList<>();
        /* mostrar baralla
        for (Carta i: baralla2){
            System.out.println(i);
        }*/
    }

    /**
     * Metode per repartir un nova carta aleatoria a la ma
     * @return --> Carta donada
     */
    public Carta donarCarta (){
        Carta cartadonada;
        int numcarta = comprovarNumCartes();

        cartadonada = new Carta(baralla.get(numcarta).getNum(),baralla.get(numcarta).getPal()) ;
        return cartadonada;
    }

    /**
     * Metode helpper que comprova si la carta aleatoria (1-40) donada ja s'havia donat abans, si no s'ha donat s'afegeix a un ArrayList de cartes donades
     * @return --> Numero de carta que no s'ha donat
     */
    private int comprovarNumCartes (){
        boolean trobada ;
        int numcarta;
        do{
            trobada = false;
            numcarta = (int) (Math.random() * 40 + 1);
            if (numCartes.isEmpty()){
                trobada = false;
            }else {
                for (Integer x : numCartes) {
                    if (numcarta == x) {
                        System.out.println("carta"+x+" cartaRandom"+numcarta);
                        trobada = true;
                    }
                }
            }
            System.out.println(numcarta);
        }while(trobada);
        numCartes.add(numcarta-1);
        return numcarta-1;
    }
}
