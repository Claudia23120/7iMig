package com.example.practica.dao;

import com.example.practica.model.Jugador;
import com.example.practica.utilities.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Hashtable;

public class DAOUsers {
    Connection con = null;

    public DAOUsers() {
        try {
            con = ConnectionDB.getInstance();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Hashtable<String, Jugador> getALLUsers() throws SQLException {
        try (Statement stmt = con.createStatement()) {
            Hashtable<String, Jugador> players = new Hashtable<>();
            String query = "SELECT * FROM User";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("nom");
                String contrasenya = rs.getString("contrasenya");
                int jugades = rs.getInt("partidesJugades");
                int guanyades = rs.getInt("partidesGuanyades");
                int perdudes = rs.getInt("partidesPerdudes");
                int punts = rs.getInt("punts");
                Jugador aux = new Jugador(name, contrasenya);
                aux.setJugades(jugades);
                aux.setGuanyades(guanyades);
                aux.setPunts(punts);
                aux.setPerdudes(perdudes);

                players.put(name, new Jugador(name, contrasenya));

                //emps.add(aux);
            }
            return players;
        }
    }
    public Hashtable<String, Jugador> getRanking() throws SQLException {
        try (Statement stmt = con.createStatement()) {
            Hashtable<String, Jugador> players = new Hashtable<>();
            String query = "SELECT * FROM User ORDER BY punts DESC LIMIT 3";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("nom");
                String contrasenya = rs.getString("contrasenya");
                int jugades = rs.getInt("partidesJugades");
                int guanyades = rs.getInt("partidesGuanyades");
                int perdudes = rs.getInt("partidesPerdudes");
                int punts = rs.getInt("punts");
                Jugador aux = new Jugador(name, contrasenya);
                aux.setJugades(jugades);
                aux.setGuanyades(guanyades);
                aux.setPunts(punts);
                aux.setPerdudes(perdudes);

                players.put(name, aux);
            }
            return players;
        }
    }
    public boolean addUser(Jugador user) {
        String queryInsert = "INSERT INTO User(nom,contrasenya) VALUES (?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(queryInsert)){
            stmt.setString(1,user.getNom());
            stmt.setString(2,user.getContrasenya());
            stmt.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
    public boolean getUserR(String nom)throws SQLException{
        try (Statement stmt = con.createStatement()) {
            String query = "SELECT nom FROM User WHERE nom='"+nom+"' LIMIT 1";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return false;
            }
            return true;
        }
    }
    public Jugador getUser(String nom,String contrasenya)throws SQLException{
        try (Statement stmt = con.createStatement()) {
            Jugador aux = null;
            String query = "SELECT nom, contrasenya FROM User WHERE nom='"+nom+"' AND contrasenya='"+contrasenya+"' LIMIT 1";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("nom");
                String contrasenyaa = rs.getString("contrasenya");
                aux = new Jugador(name,contrasenyaa);
            }
            return aux;
        }
    }
    public boolean updateUser(Jugador jugador) {
        try (PreparedStatement stmt = con.prepareStatement("UPDATE User SET partidesJugades = ?,partidesGuanyades = ?, partidesPerdudes = ?, punts = ? WHERE nom = ?")){
            stmt.setInt(1,jugador.getJugades());
            stmt.setInt(2,jugador.getGuanyades());
            stmt.setInt(3,jugador.getPerdudes());
            stmt.setInt(4,jugador.getPunts());
            stmt.setString(5,jugador.getNom());
            stmt.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    /*
    public ArrayList<Provider> getALLProviders() throws SQLException {
        try (Statement stmt = con.createStatement()) {
            ArrayList<Provider> emps = new ArrayList<>();
            String query = "SELECT * FROM provider";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("ProviderName");
                String address = rs.getString("Address");
                int idProvider = rs.getInt("idProvider");
                emps.add(new Provider(idProvider,name, address));
            }
            return emps;
        }
    }
    public Provider getProvider(int id)throws SQLException{
        try (Statement stmt = con.createStatement()) {
            Provider aux = null;
            String query = "SELECT * FROM provider WHERE idProvider = "+id;
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("ProviderName");
                String address = rs.getString("Address");
                aux = new Provider(id,name,address);
            }
            return aux;
        }
    }
    public Provider getProviderName(String names)throws SQLException{
        try (Statement stmt = con.createStatement()) {
            Provider aux = null;
            String query = "SELECT * FROM provider WHERE ProviderName = '"+names+"'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("idProvider");
                String name = rs.getString("ProviderName");
                String address = rs.getString("Address");
                aux = new Provider(id,name,address);
            }
            return aux;
        }
    }
    public int getLengthProducts() throws SQLException {
        try (Statement stmt = con.createStatement()) {
            ArrayList<Product> emps = new ArrayList<>();
            String query = "SELECT * FROM products";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("idProducts");
                String name = rs.getString("Name");
                float price = rs.getFloat("Price");
                String description = rs.getString("Description");
                int idProvider = rs.getInt("idProvider");
                Provider provider = getProvider(idProvider);
                emps.add(new Product(id,name, price, description, provider));
            }
            return emps.size();
        }
    }
    public Product getFirstProductAsc(String orderBy) throws SQLException {
        try (Statement stmt = con.createStatement()) {
            Product aux = null;
            String query = "SELECT * FROM products ORDER BY "+orderBy+" ASC LIMIT 1 ";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("idProducts");

                String name = rs.getString("Name");
                float price = rs.getFloat("Price");
                String description = rs.getString("Description");
                int idProvider = rs.getInt("idProvider");
                Provider provider = getProvider(idProvider);
                aux = new Product(id,name, price, description, provider);
            }
            return aux;
        }
    }
    public Product getSegProductAsc(String orderBy, int count) throws SQLException {
        try (Statement stmt = con.createStatement()) {
            Product aux = null;
            String query = "SELECT * FROM products ORDER BY "+orderBy+" LIMIT "+count+",1";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("idProducts");
                String name = rs.getString("Name");
                float price = rs.getFloat("Price");
                String description = rs.getString("Description");
                int idProvider = rs.getInt("idProvider");
                Provider provider = getProvider(idProvider);
                aux = new Product(id,name, price, description,provider);
            }
            return aux;
        }
    }
    public Product getLastProduct(String orderBy) throws SQLException {
        try (Statement stmt = con.createStatement()) {
            Product aux = null;
            String query = "SELECT * FROM products ORDER BY "+orderBy+" DESC LIMIT 1 ";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("idProducts");
                String name = rs.getString("Name");
                float price = rs.getFloat("Price");
                String description = rs.getString("Description");
                int idProvider = rs.getInt("idProvider");
                Provider provider = getProvider(idProvider);
                aux = new Product(id,name, price, description, provider);
            }
            return aux;
        }
    }

    public boolean addProduct(Product nouProduct) {
        String queryInsert = "INSERT INTO products(Name,Price,Description,idProvider) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(queryInsert)){
            stmt.setString(1,nouProduct.getName());
            stmt.setFloat(2, nouProduct.getPrice());
            stmt.setString(3,nouProduct.getDescription());
            stmt.setInt(4,nouProduct.getProvider().getId());

            //stmt.setString(4,nouProduct.getProvider().getName());
            stmt.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean deleteProduct(int identificador) throws Exception {
        try (PreparedStatement stmt = con.prepareStatement("DELETE FROM products WHERE idProducts = ?")) {
            stmt.setInt(1,identificador);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            throw new Exception("Failed to delete a product record");
        }
    }
    public boolean updateProduct(Product product) {
        try (PreparedStatement stmt = con.prepareStatement("UPDATE products SET Name = ?, Price= ?, Description = ?,idProvider = ? WHERE idProducts = ?")){
            stmt.setString(1,product.getName());
            stmt.setFloat(2,product.getPrice());
            stmt.setString(3,product.getDescription());
            stmt.setInt(4,product.getProvider().getId());
            stmt.setInt(5,product.getId());
            stmt.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
*/

}
