package com.example.biblio;


import com.example.biblio.model.Livre;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.controlsfx.control.action.Action;

import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    private Label idMsgVude;

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
    private HBox idHboxBtn;

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

    @FXML
    private MenuItem idQuitter;

    private ObservableList<Livre> list = FXCollections.observableArrayList();

    public List<Livre> modif = new ArrayList<Livre>();

    @FXML
    private Label idLabelIncorect;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        HBoxFormu.getChildren().removeAll(VBoxFormu,VBoxFormu1);
        idHboxBtn.getChildren().removeAll(idMsgVude);

        //Button faire apparaitre le formulaire
        btnCreer.setOnMouseClicked(action -> {
            HBoxFormu.getChildren().addAll(VBoxFormu,VBoxFormu1);
            VBoxFormu1.getChildren().removeAll(idLabelIncorect);
        });

        //Button d'ajout du livre
        btnValider.setOnMouseClicked(action -> {
            //Condition pour la rangée et pour la colonne
            if ((Integer.parseInt(texteColonne.getText())> 0 && Integer.parseInt(texteColonne.getText()) < 6 ) && ((Integer.parseInt(texteRangee.getText()) >0) && (Integer.parseInt(texteRangee.getText())<8))){
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
                //remove le msg bibbli vide
                idHboxBtn.getChildren().removeAll(idMsgVude);
                    VBoxFormu1.getChildren().removeAll(idLabelIncorect);

            }else{
                VBoxFormu1.getChildren().addAll(idLabelIncorect);

            }




            //Partie modification de la biblio
            if (modif.isEmpty()){
                System.out.println("");
            }else{
                modif.remove(0);
            }

            System.out.println(list);
            System.out.println(modif);
        });

        idQuitter.setOnAction(action ->{
           System.exit(0);

        });
    }
    //Fonction pour delete une ligne de la liste
    public void DeleteRowFromTable(ActionEvent actionEvent) {
        if (list.isEmpty()){
            //ajoute le msg si biblio est vide
            idHboxBtn.getChildren().addAll(idMsgVude);
        }else{
            //remove le msg bibbli vide
            idHboxBtn.getChildren().removeAll(idMsgVude);
            //Delete la ligne selectionné dans la biblio
        idTable.getItems().removeAll(idTable.getSelectionModel().getSelectedItem());
        }
    }


    public void ModifFromLigne(ActionEvent actionEvent) {

        if (list.isEmpty()){
            //ajoute le msg si biblio est vide
            idHboxBtn.getChildren().addAll(idMsgVude);
        }else{
            HBoxFormu.getChildren().addAll(VBoxFormu,VBoxFormu1);
            //remove le msg bibbli vide
            idHboxBtn.getChildren().removeAll(idMsgVude);
            //Delete la ligne selectionné dans la biblio
            modif.add(idTable.getSelectionModel().getSelectedItem());
            String auteur = modif.get(0).getAuteur();
            String titre = modif.get(0).getTitre();
            String resume = modif.get(0).getResume();
            int colonne = modif.get(0).getColonne();
            int range = modif.get(0).getRange();
            int parution = modif.get(0).getParution();

            //Remplir les champ pour modif
            texteAuteur.setText(auteur);
            texteParution.setText(String.valueOf(parution));
            texteResume.setText(resume);
            texteRangee.setText(String.valueOf(range));
            texteColonne.setText(String.valueOf(colonne));
            texteTitre.setText(titre);

            //renvoie le nouveau livre
            idTable.getItems().removeAll(idTable.getSelectionModel().getSelectedItem());
        }

    }
}