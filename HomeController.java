package com.example.projet_esalaf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private Button client;

    @FXML
    private Button credit;

    @FXML
    private Button produit;


    @FXML
    void produit(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Produit.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = (Stage) produit.getScene().getWindow();
            stage.setScene(new Scene(root, 901, 579));


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void credit(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Credit.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = (Stage) credit.getScene().getWindow();
            stage.setScene(new Scene(root, 901, 579));

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        @FXML
        void client(ActionEvent event){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Client.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = (Stage) client.getScene().getWindow();
                stage.setScene(new Scene(root, 901, 579));

            }
catch (IOException e) {
                    throw new RuntimeException(e);
                }
        }








    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
