package Ej432LibretaDeDireccionesFXML;

import javafx.beans.property.SimpleStringProperty;
 
public class Person {
    
   //Declara las variables de la clase
   private final SimpleStringProperty firstName = new SimpleStringProperty("");
   private final SimpleStringProperty lastName = new SimpleStringProperty("");
   private final SimpleStringProperty email = new SimpleStringProperty("");

//Contructor vacio para la creación de lineas nuevas desde la app
public Person() {
        this("", "", "");
    }
    //Contructor con los setters para la creación de lineas desde el código
    public Person(String firstName, String lastName, String email) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }
    
    //Getters y Seters
    public String getFirstName() {
        return firstName.get();
    }
 
    public void setFirstName(String fName) {
        firstName.set(fName);
    }
        
    public String getLastName() {
        return lastName.get();
    }
    
    public void setLastName(String fName) {
        lastName.set(fName);
    }
    
    public String getEmail() {
        return email.get();
    }
    
    public void setEmail(String fName) {
        email.set(fName);
    }
}
