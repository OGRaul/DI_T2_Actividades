package appagenda;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author RaulOG
 */
public class Main extends Application {
    
    private EntityManagerFactory emf;
    private EntityManager em; 
    
    
    @Override
    public void start(Stage primaryStage)throws IOException{
        //Cargando el FXML
        StackPane rootMain = new StackPane();
        FXMLLoader fxmlLoader = new
        FXMLLoader(getClass().getResource("AgendaView.fxml"));
        Pane rootAgendaView=fxmlLoader.load();
        rootMain.getChildren().add(rootAgendaView);


        // Conexión a la BD creando los objetos EntityManager y EntityManagerFactory
        emf=Persistence.createEntityManagerFactory("AppAgendaPU");
        em=emf.createEntityManager();
        
        //Cargando el controlador
        AgendaViewController agendaViewController =
            (AgendaViewController)fxmlLoader.getController();
        // Después de obtener el objeto del controlador y del EntityManager:
        agendaViewController.setEntityManager(em);
        
        //Usamos el metodo cargar personas del controlador
        agendaViewController.cargarTodasPersonas();
        
        Scene scene = new Scene(rootMain);
        primaryStage.setTitle("App Agenda");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    @Override
    public void stop()throws Exception{
        em.close();
        emf.close();
        try{
            DriverManager.getConnection("jdbc:derby:BDAgenda;shutdown=true");
        } catch(SQLException ex) {
        }
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
