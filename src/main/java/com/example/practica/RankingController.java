package com.example.practica;

import com.example.practica.dao.DAOUsers;
import com.example.practica.model.Jugador;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;


public class RankingController {

    @FXML
    Button menu = new Button();

    @FXML
    Label nom1 = new Label();
    @FXML
    Label pg1 = new Label();
    @FXML
    Label pj1 = new Label();
    @FXML
    Label pp1 = new Label();
    @FXML
    Label p1 = new Label();

    @FXML
    Label nom2 = new Label();
    @FXML
    Label pg2 = new Label();
    @FXML
    Label pj2 = new Label();
    @FXML
    Label pp2 = new Label();
    @FXML
    Label p2 = new Label();

    @FXML
    Label nom3 = new Label();
    @FXML
    Label pg3 = new Label();
    @FXML
    Label pj3 = new Label();
    @FXML
    Label pp3 = new Label();
    @FXML
    Label p3 = new Label();




    @FXML
    protected void initialize() throws SQLException {
        DAOUsers dao = new DAOUsers();
        Hashtable<String, Jugador> jugadors = dao.getRanking() ;


        List<Jugador> aaa = new ArrayList();;
        Enumeration<String> elements = jugadors.keys();
        while(elements.hasMoreElements()) {
            Jugador aux = jugadors.get(elements.nextElement());
            System.out.println(aux);
            aaa.add(aux);
        }
        Collections.sort(aaa);
        System.out.println(aaa);
        nom1.setText(aaa.get(0).getNom());
        pj1.setText(""+aaa.get(0).getJugades());
        pg1.setText(""+aaa.get(0).getGuanyades());
        pp1.setText(""+aaa.get(0).getPerdudes());
        p1.setText(""+aaa.get(0).getPunts());

        if (aaa.size() >=2) {
            nom2.setText(aaa.get(1).getNom());
            pj2.setText("" + aaa.get(1).getJugades());
            pg2.setText("" + aaa.get(1).getGuanyades());
            pp2.setText("" + aaa.get(1).getPerdudes());
            p2.setText("" + aaa.get(1).getPunts());
            if (aaa.size()>=3) {
                nom3.setText(aaa.get(2).getNom());
                pj3.setText("" + aaa.get(2).getJugades());
                pg3.setText("" + aaa.get(2).getGuanyades());
                pp3.setText("" + aaa.get(2).getPerdudes());
                p3.setText("" + aaa.get(2).getPunts());
            }else {
                nom3.setText("");
                pj3.setText("");
                pg3.setText("");
                pp3.setText("");
                p3.setText("");
            }
        }else{
            nom2.setText("");
            pj2.setText("");
            pg2.setText("");
            pp2.setText("");
            p2.setText("");
        }

    }

    public void buttonMenu(ActionEvent actionEvent) {
        try {
            Stage stage = (Stage) menu.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Menu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}