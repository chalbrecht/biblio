package com.example.biblio;


import com.example.biblio.model.Livre;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
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

    @FXML
    private HBox HBoxFormu;

    @FXML
    private VBox VBoxFormu;

    @FXML
    private VBox VBoxFormu1;

    @FXML
    private Button btnCreer;

    @FXML
    protected TableColumn<Livre, String> idAuthor;

    @FXML
    protected TableColumn<Livre, String> idName;

    @FXML
    protected TableColumn<Livre, Integer> idParution;

    @FXML
    protected TableColumn<Livre, Integer> idRange;

    @FXML
    protected TableColumn<Livre, String> idResume;

    @FXML
    protected TableView<Livre> idTable;
    @FXML
    private TableColumn<Livre, Integer> IdColonne;

    private ObservableList<Livre> list = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        HBoxFormu.getChildren().removeAll(VBoxFormu,VBoxFormu1);

        //Button faire apparaitre le formulaire
        btnCreer.setOnMouseClicked(action -> {
            HBoxFormu.getChildren().addAll(VBoxFormu,VBoxFormu1);

        });


        //Button d'ajout du livre
        btnValider.setOnMouseClicked(action -> {
            //Creation de l'objet Livre
            Livre livre = new Livre(texteTitre.getText(),texteAuteur.getText(),texteResume.getText(),Integer.parseInt(texteColonne.getText()),Integer.parseInt(texteRangee.getText()),Integer.parseInt(texteParution.getText()));
            //Ajout a la liste
            list.add(livre);
            // Creation des cellule
            idName.setCellValueFactory(new PropertyValueFactory<Livre,String>("titre"));
            idAuthor.setCellValueFactory(new PropertyValueFactory<Livre,String>("auteur"));
            idResume.setCellValueFactory(new PropertyValueFactory<Livre,String>("resume"));
            idRange.setCellValueFactory(new PropertyValueFactory<Livre,Integer>("range"));
            idParution.setCellValueFactory(new PropertyValueFactory<Livre,Integer>("parution"));
            IdColonne.setCellValueFactory(new PropertyValueFactory<Livre,Integer>("colonne"));
            // Ajout des donnée du livre
            idTable.setItems(list);

            // Renisialiser les champs
            texteAuteur.setText("");
            texteParution.setText("");
            texteResume.setText("");
            texteRangee.setText("");
            texteColonne.setText("");
            texteTitre.setText("");

            //Remove le formulaire d'ajout
            HBoxFormu.getChildren().removeAll(VBoxFormu,VBoxFormu1);

            System.out.println(list);









        });





    }
}