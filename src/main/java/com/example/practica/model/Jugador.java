package com.example.practica.model;

public class Jugador implements Comparable<Jugador>{
    private String nom ;
    private String contrasenya;
    private int jugades=0;
    private int guanyades=0;
    private int perdudes=0;
    private int punts = 0;

    /**
     * Constructor per crear un jugador a partir del seu nom
     * @param nom --> Nom del nou Jugador
     */
    public Jugador(String nom, String contrasenya) {
        this.nom = nom;
        this.contrasenya = contrasenya;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    /**
     * Getter del Nom del Jugador
     * @return --> Nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Metode per cada cop que el jugador jugui una partida, s'incrementi el valor de partides jugades
     */
    public void partidaJugada ( ) {
        this.jugades++;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Metode per cada cop que el jugador guanyi una partida, s'incrementi el valor de partides guanyades
     */
    public void partidaGuanyada ( ) {
        this.guanyades++;
        this.punts += 5;
    }

    /**
     * Metode per cada cop que el jugador perdi una partida, s'incrementi el valor de partides perdudes
     */
    public void partidaPerduda ( ) {
        this.perdudes++;
        this.punts -= 3;
    }

    public int getJugades() {
        return jugades;
    }

    public int getGuanyades() {
        return guanyades;
    }

    public int getPerdudes() {
        return perdudes;
    }

    public int getPunts() {
        return punts;
    }

    public void setJugades(int jugades) {
        this.jugades = jugades;
    }

    public void setGuanyades(int guanyades) {
        this.guanyades = guanyades;
    }

    public void setPerdudes(int perdudes) {
        this.perdudes = perdudes;
    }

    public void setPunts(int punts) {
        this.punts = punts;
    }

    /**
     * Metode equals per que no hi hagin jugadors repetits
     * @param obj --> Nou jugador que vulguis crear
     * @return --> Si existeix o no (true or false)
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * Metode ToSring per veure tota la informació del jugador
     * @return --> Nom, jugades, guanyades, perdudes
     */
    @Override
    public String toString() {
        return "Nom: '" + nom + "'\n " +
                "Partides Jugades: " + jugades + "\n "+
                "Partides Guanyades: " + guanyades +"\n "+
                "Partides Perdudes: " + perdudes +"\n "+
                "Punts: " + punts +"\n ";
    }

    @Override
    public int compareTo(Jugador a) {
        if (this.getPunts() > a.getPunts()){
            return -1;
        }
        return 1;

    }
}
