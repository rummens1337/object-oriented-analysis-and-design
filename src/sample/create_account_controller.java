package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;

public class create_account_controller extends MainController{

    @FXML
    private TextField txt_lastName;
    @FXML
    private TextField txt_firstName;
    @FXML
    private DatePicker dte_dateOfBirth;
    @FXML
    private ComboBox cmb_sex;
    @FXML
    private TextField txt_email;
    @FXML
    private TextField txt_phoneNumber;
    @FXML
    private TextField txt_adres;
    @FXML
    private Button btn_createAccount;
    @FXML
    private Button btn_back;

    public void createAccountButtonPressed (ActionEvent event) throws IOException {
        
        SQL sql = new SQL("jdbc:mysql://oege.ie.hva.nl:3306/zhadiyem?useUnicode=true&useJDBCCompliantTimezoneShift" +
                           "=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "hadiyem","F+OYAvrrsj26nQ");

        sql.update("INSERT INTO Account (email, lastName, firstName, dateOfBirth," +
                " sex, phoneNumber, adres) VALUES ('" + user.getEmail() + "', '" + user.getLastName() + "', '" +
                user.getFirstName() + "', '" + user.getDateOfBirth() + "', '" + user.getSex() + "', '" +
                user.getPhoneNumber() + "', '" + user.getAdres() + "')");

        sql.close();
    }

    public void backButtonPressed (ActionEvent event) throws IOException {
        super.switchSceneLogin(event, btn_back);
    }

}
