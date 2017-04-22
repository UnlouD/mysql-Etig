package control;

import app.entity.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.sql.Date;

public class Controller {

    @FXML
    private TextField fxId, fxFirstname, fxSurname, fxBirthday, fxAddress, fxPhone;
    @FXML
    private ComboBox<String> fxGender, fxCity;

    @FXML
    private void initialize() {
        fxGender.getItems().addAll("Мужской", "Женский");
    }

    public void add(ActionEvent actionEvent) {

    }

    public void update(ActionEvent actionEvent) {
    }

    public void delete(ActionEvent actionEvent) {
    }

    public void print(ActionEvent actionEvent) {
        Student student = new Student();
        student.setFirstname("Рамин");
        student.setSurname("Расули");
        student.setGender("Мужской");
        student.setBirthday(new Date(1994, 01, 24));
        student.setAddress("Рылеева 3 16");
        student.setPhone("+7(950) 386-34-44");

        System.out.println(student);
    }
}
