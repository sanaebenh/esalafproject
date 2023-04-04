package com.example.projet_esalaf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
public class HelloApplicationController implements Initializable {

    @FXML
    private Button btnok;

    @FXML
    private PasswordField txtpass;

    @FXML
    private TextField txtuname;

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    @FXML
    void login(ActionEvent event) {
        String uname = txtuname.getText();
        String pass = txtpass.getText();
        if (uname.equals("") && pass.equals("")) {


            JOptionPane.showMessageDialog(null, "user name or password is empty");

        } else {
            try{

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/esalaf", "root", "");
                pst = con.prepareStatement("select * from users where email=? and password=?");
                pst.setString(1, uname);
                pst.setString(2, pass);

                rs = pst.executeQuery();
                if (rs.next()) {

    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Home.fxml"));
    Parent root = (Parent) fxmlLoader.load();


Stage stage = (Stage) btnok.getScene().getWindow();
stage.setScene(new Scene(root,901,579));

                 } else {
                  JOptionPane.showMessageDialog(null, "login false");
                  txtuname.setText("");
                  txtpass.setText("");
                  txtuname.requestFocus();
                }
            } catch (ClassNotFoundException | SQLException ex) {
                throw new RuntimeException(ex);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}






