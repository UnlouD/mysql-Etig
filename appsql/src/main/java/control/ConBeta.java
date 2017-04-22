package control;

import app.alert.AppAlert;
import app.entity.Student;
import app.function.AppFunction;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * Created by RRM on 22.04.17.
 */
public class ConBeta {

    @FXML
    private TextField tfID;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfAge;
    @FXML
    private TextField tfEmail;
    @FXML
    private TableView<GetSetStudent> tbUsers;
    @FXML
    private TableColumn<GetSetStudent, Long> tcID;
    @FXML
    private TableColumn<GetSetStudent, String> tcNAME;
    @FXML
    private TableColumn<GetSetStudent, Integer> tcAGE;
    @FXML
    private TableColumn<GetSetStudent, String> tcEMAIL;

    private ObservableList<GetSetStudent> userObservableList;
    private AppAlert alertBox = new AppAlert();
    private AppFunction studentMethod = new AppFunction();

    public void insertDB(ActionEvent actionEvent) {
//        if ((tfName.getText().trim().length() > 0)
//                && (tfAge.getText().trim().length() > 0)
//                && (tfEmail.getText().trim().length() > 0)) {
//            Student student = new Student();
////            student.setFirstName(tfName.getText());
////            student.setAgeStudent(Integer.parseInt(tfAge.getText()));
////            student.setEmailStudent(tfEmail.getText());
//            studentMethod.addStudent(student);
//            alertBox.Info("Поздравляю!", tfName.getText() + " успешно добавлен в БД!", null);
//        } else {
//            alertBox.Warning("Предупреждение!", "Поле ID является не обязательным.", "Не все поля заполнены!");
//        }
    }

    public void deleteDB(ActionEvent actionEvent) {
//
//        if (tfID.getText().trim().length() > 0) {
//            studentMethod.deleteStudent(Integer.parseInt(tfID.getText()));
//            alertBox.Info("Поздравляю!", "Пользователь под # " + tfID.getText() + ". был удален из БД!", null);
//        } else {
//            alertBox.Warning("Предупреждение!", "Поле ID является обязательным.", "Удаление происходит по выбору порядкового номера (ID)!");
//        }
    }

    public void updateDB(ActionEvent actionEvent) {
        if ((tfName.getText().trim().length() > 0)
                && (tfAge.getText().trim().length() > 0)
                && (tfEmail.getText().trim().length() > 0)) {

//            Student student = studentMethod.getByIdStudent(Integer.parseInt(tfID.getText()));
//            student.setNameStudent(tfName.getText());
//            student.setAgeStudent(Integer.parseInt(tfAge.getText()));
//            student.setEmailStudent(tfEmail.getText());
//
//            studentMethod.updateStudent(student);

            alertBox.Info("Поздравляю!", "Пользователь был изменен.", null);
        } else {
            alertBox.Warning("Предупреждение!", "Поле ID является не обязательным.", "Не все поля заполнены!");
        }
    }

    public void selectDB(ActionEvent actionEvent) {
//        List<Student> lsStudent = studentMethod.getAllStudent();
//        userObservableList = FXCollections.observableArrayList();
//        for (Student student : lsStudent){
//            userObservableList.add(new GetSetStudent(student.getIdStudent(), student.getAgeStudent(), student.getNameStudent(), student.getEmailStudent()));
//        }
//
//        tbUsers.setItems(userObservableList);
//
//        tcID.setCellValueFactory(new PropertyValueFactory<GetSetStudent, Long>("idStudent"));
//        tcNAME.setCellValueFactory(new PropertyValueFactory<GetSetStudent, String>("nameStudent"));
//        tcAGE.setCellValueFactory(new PropertyValueFactory<GetSetStudent, Integer>("ageStudent"));
//        tcEMAIL.setCellValueFactory(new PropertyValueFactory<GetSetStudent, String>("emailStudent"));

    }

    public void pickTableItem(MouseEvent mouseEvent) {
//        tbUsers.setOnMouseClicked(new EventHandler<MouseEvent>(){
//            @Override
//            public void handle(MouseEvent event){
//                tfID.setText(String.valueOf(tbUsers.getSelectionModel().getSelectedItem().getIdStudent()));
//                tfName.setText(tbUsers.getSelectionModel().getSelectedItem().getNameStudent());
//                tfAge.setText(String.valueOf(tbUsers.getSelectionModel().getSelectedItem().getAgeStudent()));
//                tfEmail.setText(tbUsers.getSelectionModel().getSelectedItem().getEmailStudent());
//            }
//        });
    }

}
