package com.example.biblio;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable{
    @FXML
    private Button btnValider;

    @FXML
    private Label labAuteur;

    @FXML
    private Label labColonne;

    @FXML
    private Label labParution;

    @FXML
    private Label labRangee;

    @FXML
    private Label labResume;

    @FXML
    private Label labTitre;

    @FXML
    private TextField texteAuteur;

    @FXML
    private TextField texteColonne;

    @FXML
    private TextField texteParution;

    @FXML
    private TextField texteRangee;

    @FXML
    private TextArea texteResume;

    @FXML
    private TextField texteTitre;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}