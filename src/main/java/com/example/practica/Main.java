package com.example.practica;

import com.example.practica.model.Jugador;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import javax.json.*;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //jugadors.put("j", new Jugador("Claudia","a"));
        //jugadors.put("a", new Jugador("a","a"));
        //writeInFile( path);
        //readFromFile(path);

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("JOC 7 I MIG!");
        stage.setScene(scene);
        stage.show();


    }

    static void writeInFile(Hashtable<String,Jugador> jugadors) {
        Path path = Paths.get("dades.json");
        OutputStream os = null;
        JsonArray json_array = null;
        JsonArrayBuilder js = Json.createArrayBuilder();
        JsonWriter jsonWriter = null;
        try{
            Enumeration<String> elements = jugadors.keys();
            while(elements.hasMoreElements()) {
                Jugador aux = jugadors.get(elements.nextElement());
                JsonObjectBuilder json_object_builder = Json.createObjectBuilder();
                json_object_builder.add("Key",aux.getNom());
                json_object_builder.add("Nom",aux.getNom());
                json_object_builder.add("Contrasenya",aux.getContrasenya());
                json_object_builder.add("PartidesJugades",aux.getJugades());
                json_object_builder.add("PartidesGuanyades",aux.getGuanyades());
                json_object_builder.add("PartidesPerdudes",aux.getPerdudes());
                json_object_builder.add("Punts",aux.getPunts());
                js.add(json_object_builder.build());
            }
            os = new FileOutputStream(path.toFile());
            jsonWriter = Json.createWriter(os);
            jsonWriter.writeArray(js.build());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(jsonWriter != null) {
                jsonWriter.close();
            }/*
            try {
                //os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }
    }

    static Hashtable<String, Jugador> readFromFile(){
        Path path = Paths.get("dades.json");
        Hashtable<String, Jugador> jugadors = new Hashtable<>();

        InputStream is = null;
        JsonReader jsonReader =null;
        try {
            is = new FileInputStream(path.toFile());
            jsonReader = Json.createReader(is);
            JsonArray json_array = jsonReader.readArray();
            for (JsonValue row: json_array) {
                JsonObject json_object = row.asJsonObject();
                String nom = json_object.getString("Nom");
                String contrasenya = json_object.getString("Contrasenya");
                int partidesJugades = json_object.getInt("PartidesJugades");
                int partidesGuanyades = json_object.getInt("PartidesGuanyades");
                int partidesPerdudes = json_object.getInt("PartidesPerdudes");

                int punts = json_object.getInt("Punts");

                // read string data
                System.out.print(nom);
                // read integer data
                System.out.println(", ccccc: " + contrasenya+""+partidesGuanyades+""+partidesJugades+""+partidesPerdudes+""+punts);
                Jugador aux = new Jugador(nom, contrasenya);
                aux.setGuanyades(partidesGuanyades);
                aux.setJugades(partidesJugades);
                aux.setPerdudes(partidesPerdudes);
                aux.setPunts(punts);
                jugadors.put(nom,aux);
                // read inner json double
                //System.out.println(", Salario: " + json_object.getJsonNumber("salario"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if(jsonReader != null) {
                jsonReader.close();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jugadors;
    }

    public static void main(String[] args) {
        launch();
    }
}