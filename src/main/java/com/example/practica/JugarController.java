package com.example.practica;

import com.example.practica.dao.DAOUsers;
import com.example.practica.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Hashtable;

public class JugarController {
    @FXML
    private Label maJugadorL;
    @FXML
    private Label maBancaL;
    @FXML
    private Label missatge;
    @FXML
    Button demanar = new Button();
    @FXML
    Button plantar = new Button();
    @FXML
    Button jugar = new Button();
    @FXML
    Button menu = new Button();
    @FXML
    ImageView card_console = new ImageView();
    @FXML
    ImageView card_console1 = new ImageView();
    @FXML
    ImageView card_console2 = new ImageView();
    @FXML
    ImageView card_console3 = new ImageView();
    @FXML
    ImageView card_console4 = new ImageView();
    @FXML
    ImageView card_console5 = new ImageView();
    @FXML
    ImageView card_console6 = new ImageView();

    @FXML
    ImageView card_player = new ImageView();
    @FXML
    ImageView card_player1 = new ImageView();
    @FXML
    ImageView card_player2 = new ImageView();
    @FXML
    ImageView card_player3 = new ImageView();
    @FXML
    ImageView card_player4 = new ImageView();
    @FXML
    ImageView card_player5 = new ImageView();
    @FXML
    ImageView card_player6 = new ImageView();

    @FXML
    Label nom = new Label();
    @FXML
    Label jugades = new Label();
    @FXML
    Label guanyades = new Label();
    @FXML
    Label perdudes = new Label();
    @FXML
    Label punts = new Label();

    Baralla baralla ;
    Ma maJugador ;
    Ma maBanca;
    int coutCartes = 0;
    Jugador usuari;

    @FXML
    protected void initialize() {
        usuari = LoginController.jugadorLogin;
        nom.setText(usuari.getNom());
        jugar();
        maJugadorL.setText(""+maJugador.getValorMa());
        maBancaL.setText(""+maBanca.getValorMa());
        jugar.setVisible(false);
        menu.setVisible(false);
    }
    @FXML
    protected void jugar(){
        usuari.partidaJugada();
        jugades.setText(""+usuari.getJugades());
        perdudes.setText(""+usuari.getPerdudes());
        guanyades.setText(""+usuari.getGuanyades());
        punts.setText(""+usuari.getPunts());
        baralla = new Baralla();
        maJugador = new Ma();
        maBanca = new Ma();
        coutCartes = 0;
        baralla.crearBaralla();

        Carta auxPlayer = baralla.donarCarta();
        card_player.setImage(auxPlayer.getImatge());
        maJugador.afegirCarta(auxPlayer);

        Carta auxBanca = baralla.donarCarta();
        card_console.setImage(auxBanca.getImatge());
        maBanca.afegirCarta(auxBanca);

        missatge.setText("");
        demanar.setDisable(false);
        plantar.setDisable(false);
    }

    @FXML
    protected void buttonJugar() {
        jugar();
        maJugadorL.setText(""+maJugador.getValorMa());
        maBancaL.setText("" + maBanca.getValorMa());
        jugar.setVisible(false);
        menu.setVisible(false);
        card_player1.setImage(null);
        card_player2.setImage(null);
        card_player3.setImage(null);
        card_player4.setImage(null);
        card_player5.setImage(null);
        card_player6.setImage(null);
        card_console1.setImage(null);
        card_console2.setImage(null);
        card_console3.setImage(null);
        card_console4.setImage(null);
        card_console5.setImage(null);
        card_console6.setImage(null);

    }

    @FXML
    protected void demanarCarta(){
        if (maJugador.getValorMa() <= 7.5f) {
            if (maJugador.getValorMa() == 7.5f) {
                missatge.setText("JA HAS GUANYAT!");
                usuari.partidaGuanyada();
            } else {
                Carta auxPlayer1 = baralla.donarCarta();
                if (coutCartes == 0){
                    card_player1.setImage(auxPlayer1.getImatge());
                }else if (coutCartes == 1){
                    card_player2.setImage(auxPlayer1.getImatge());
                }else if (coutCartes == 2){
                    card_player3.setImage(auxPlayer1.getImatge());
                }else if (coutCartes == 3){
                    card_player4.setImage(auxPlayer1.getImatge());
                }else if (coutCartes == 4){
                    card_player5.setImage(auxPlayer1.getImatge());
                }else if (coutCartes == 5){
                    card_player6.setImage(auxPlayer1.getImatge());
                }
                maJugador.afegirCarta(auxPlayer1);
                coutCartes ++;
            }

        }
        if(maJugador.getValorMa() >= 7.5f){
            missatge.setText("T'HAS PASSAT, la banca es planta");
            usuari.partidaPerduda();
            demanar.setDisable(true);
            plantarse();
        }
        maJugadorL.setText(""+maJugador.getValorMa());
    }

    @FXML
    protected void plantarse(){
        demanar.setDisable(true);
        int cardCountConsole = 0;
        if (maJugador.getValorMa() <= 7.5f) {
            boolean sortir = false;
            do {
                if (maBanca.getValorMa() <= 7.5f) {
                    if (maBanca.getValorMa() == 7.5f) {
                        missatge.setText("La banca s'ha plantat");
                        sortir = true;
                    } else {
                        Carta auxConsola = baralla.donarCarta();
                        if (cardCountConsole == 0){
                            card_console1.setImage(auxConsola.getImatge());
                        }else if (cardCountConsole == 1){
                            card_console2.setImage(auxConsola.getImatge());
                        }else if (cardCountConsole == 2){
                            card_console3.setImage(auxConsola.getImatge());
                        }else if (cardCountConsole == 3){
                            card_console4.setImage(auxConsola.getImatge());
                        }else if (cardCountConsole == 4){
                            card_console5.setImage(auxConsola.getImatge());
                        }else if (cardCountConsole == 5){
                            card_console6.setImage(auxConsola.getImatge());
                        }
                        maBanca.afegirCarta(auxConsola);
                        cardCountConsole ++;

                        maBancaL.setText(""+maBanca.getValorMa());
                    }
                } else {
                    missatge.setText("La banca s'ha passat, has guanyat!");
                    usuari.partidaGuanyada();
                    sortir = true;
                }
            } while (!sortir);
        }
        jugar.setVisible(true);
        plantar.setDisable(true);
        menu.setVisible(true);

    }


    public void buttonMenu(ActionEvent actionEvent) { //TODO: GUARDAR JUGADOR AL ARRAY I ESCRIURE AL FITXER
        DAOUsers dao = new DAOUsers();
        dao.updateUser(usuari);
        try {
            Stage stage = (Stage) maJugadorL.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Menu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}