package com.example.practica;

import com.example.practica.model.Jugador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    Button buttonJugar = new Button();
    @FXML
    Button buttonRanking = new Button();
    @FXML
    Button butSortir = new Button();
    @FXML
    Label jugador = new Label();

    Jugador usuari;

    @FXML
    protected void initialize() {
        usuari = LoginController.jugadorLogin;
        jugador.setText(usuari.getNom());
    }
    @FXML
    public void jugar(ActionEvent actionEvent){
        try {
            Stage stage = (Stage) buttonJugar.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("JugarView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void ranking(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) buttonJugar.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("rankingView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @FXML
    public void sortir(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) butSortir.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
