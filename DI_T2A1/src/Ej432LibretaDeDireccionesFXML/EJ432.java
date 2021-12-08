/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ej432LibretaDeDireccionesFXML;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author RaulOG
 */
public class EJ432 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {

        //Set up del panel y cargar la interfaz del fxml
        Pane myPane = (Pane)FXMLLoader.load(getClass().getResource
        ("fxml_tableview.fxml"));
        
        //Set up del primary stage y la escena
        primaryStage.setTitle("FXML TableView Example");
        Scene myScene = new Scene(myPane);
        primaryStage.setScene(myScene);
        primaryStage.show();
    }
    //Ejecución
    public static void main(String[] args) {
        launch(args);
    }
}
