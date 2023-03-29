package com.example.practica;

import com.example.practica.dao.DAOUsers;
import com.example.practica.model.Jugador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.Console;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class LoginController {
    static Jugador jugadorLogin;

    @FXML
    TextField usr = new TextField();
    @FXML
    PasswordField pwd = new PasswordField();



    public void regist(ActionEvent actionEvent) throws SQLException {
        DAOUsers dao = new DAOUsers();

        if(!usr.getText().equals("") && !pwd.getText().equals("")){
            boolean aux = dao.getUserR(usr.getText());
            System.out.println(aux);
            if (aux){
                dao.addUser(new Jugador(usr.getText(), pwd.getText()));
                usr.setText("");
                pwd.setText("");
                Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                alerta.setContentText("Jugador creat! Inicia sessió!");
                alerta.show();
            }else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setContentText("Error");
                alerta.show();
            }

        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setContentText("Introdueix dades");
            alerta.show();
        }
    }
    public void login(ActionEvent actionEvent) throws SQLException {
        DAOUsers dao = new DAOUsers();

        Jugador aux = dao.getUser(usr.getText(), pwd.getText());

        if (aux != null){
            try {
                jugadorLogin = aux;
                Stage stage = (Stage) usr.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Menu.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                stage.setScene(scene);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error :(");
            alerta.setHeaderText(null);
            alerta.setContentText("error al iniciar sessió");
            alerta.show();
            usr.setText("");
            pwd.setText("");
        }
    }
}
