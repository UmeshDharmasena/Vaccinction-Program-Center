package sample;

import java.time.LocalDateTime;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Timestamp;

public class Controller {
    @FXML
    private TextField name;
    @FXML
    private TextField surname;
    @FXML
    private TextField age;
    @FXML
    private TextField city;
    @FXML
    private TextField id;
    @FXML
    private RadioButton AstraZeneca;
    @FXML
    private RadioButton Sinopharm;
    @FXML
    private RadioButton Pfizer;


    public void alert(){
        Alert a1 = new Alert(Alert.AlertType.NONE);
        String n = name.getText();
        String s = surname.getText();
        String a = age.getText();
        String c = city.getText();
        String i = id.getText();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());


        if(AstraZeneca.isSelected()){
            String details = "Name: "+n +" "+ s+ "\n" +"Age: "+ a + "\n" + "City: "+ c +"\n"+"NIC or Passport Number: "+ i+"\n"+"Vaccination Requested: AstraZeneca"+"\n"+"Date & Time: "+timestamp;

            a1.setTitle("Receipt");
            a1.setHeaderText("Patient Details");
            a1.setContentText(details);
            a1.showAndWait();
        }
        if(Sinopharm.isSelected()){
            String details = "Name: "+n +" "+ s+ "\n" +"Age: "+ a + "\n" + "City: "+ c +"\n"+"NIC or Passport Number: "+ i+"\n"+"Vaccination Requested: Sinopharm"+"\n"+"Date & Time: "+timestamp;
            a1.setTitle("Receipt");
            a1.setHeaderText("Patient Details");
            a1.setContentText(details);
            a1.showAndWait();
        }
        if(Pfizer.isSelected()){
            String details = "Name: "+n +" "+ s+ "\n" +"Age: "+ a + "\n" + "City: "+ c +"\n"+"NIC or Passport Number: "+ i+"\n"+"Vaccination Requested: Pfizer"+"\n"+"Date & Time: "+timestamp;
            a1.setTitle("Receipt");
            a1.setHeaderText("Patient Details");
            a1.setContentText(details);
            a1.showAndWait();
        }

    }

}
