package GUI;

import GUI.DBDataModels.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import org.controlsfx.dialog.ExceptionDialog;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DBController implements Initializable {
    @FXML
    public TextField tbRaiting;
    @FXML
    public ComboBox<String> cbGroup;
    @FXML
    public ComboBox<String> cbStudent;
    @FXML
    public ComboBox<String> cbLab;

    private ArrayList<Student> students = new ArrayList<>();

    private ObservableList<String> cbGroups = FXCollections.observableArrayList();
    private ObservableList<String> cbStudents = FXCollections.observableArrayList();
    private ObservableList<String> cbLabs = FXCollections.observableArrayList();

    private String selectedGroup;
    private int selectedCourse;
    private int selectedStudentJCode;
    private int selectedLab;

    private Connection connection = null;
    private String url = "jdbc:mysql://127.0.0.1:3306/KSAK?useLegacyDatetimeCode=false&amp&serverTimezone=UTC";
    private String name = "Trapping";
    private String password = "1111";

    private Statement statement = null;

    private ArrayList<String> labNameList = new ArrayList<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadData();
        for (int i = 1; i < 8; i++) {
            labNameList.add("`Лаб_" + i + "`");
            cbLabs.add("Лабораторна #" + i);
        }
        cbLab.setItems(cbLabs);
    }

    private void reloadGroups(){
        cbGroups.clear();
        for (Student student: students
             ) {
            if (!cbGroups.contains(student.getGroupName() + ", " + student.getCourse() + " курс;")){
            cbGroups.add(student.getGroupName() + ", " + student.getCourse() + " курс;");
            }
        }
    }

    private void reloadStudents(){
        cbStudents.clear();
        for (Student student: students
             ) {
            if (student.getGroupName().equals(selectedGroup))
            {
                cbStudents.add(student.getLastName() + " "
                        + student.getName() + " " +student.getFathersName() + ", Журнал #" + student.getJCode());
            }
            cbStudent.setItems(cbStudents);
        }
    }

    private void loadData(){

        try {
            connection = DriverManager.getConnection(url, name, password);

            statement = connection.createStatement();

            //language=MySql
            ResultSet resultSet1 = statement.executeQuery("SELECT `Код_студента`, `Прізвище`, `Імя`," +
                    " `По_батькові`, `Код_журналу`, `Рік_вступу`, `Група_Код_групи`\n" +
                    "\tFROM `Студент`");
            while (resultSet1.next()){

                students.add(new Student(resultSet1.getInt(1),
                        resultSet1.getString(2),
                        resultSet1.getString(3),
                        resultSet1.getString(4),
                        resultSet1.getInt(5),
                        resultSet1.getDate(6).toLocalDate().getYear(),
                        resultSet1.getInt(7), "", 0));
            }

            for (Student student: students
                 ) {
                resultSet1 = statement.executeQuery("SELECT `Скорочена_назва`, `Курс_Код_курсу`\n" +
                        "\tFROM `Група`\n" +
                        "\tWHERE `Код_групи`=" + student.getGCode());
                resultSet1.next();
                student.setCourse(resultSet1.getInt(2));
                student.setGroupName(resultSet1.getString(1));
            }


        } catch (Exception e){
            e.printStackTrace();
        }

        reloadGroups();
        cbGroup.setItems(cbGroups);

        /*for (Student student: students
                ) {
            System.out.println(student.toString());
        }*/
    }

    public void cbGroupSelected(ActionEvent actionEvent) {
        StringBuilder stringBuilder = new StringBuilder();
        char c;
        int i=0;
        while ((c=cbGroup.getValue().charAt(i++)) !=','){
            stringBuilder.append(c);
        }
        selectedGroup = stringBuilder.toString();
        stringBuilder.delete(0, stringBuilder.length());
        stringBuilder.append(cbGroup.getValue().charAt(i + 1));
        selectedCourse = Integer.parseInt(stringBuilder.toString());
        reloadStudents();
    }

    public void cbStudentSelected(ActionEvent actionEvent) {
        StringBuilder stringBuilder = new StringBuilder();
        char c;
        int i=cbStudent.getValue().length();
        while ((c=cbStudent.getValue().charAt(--i)) !='#'){
            stringBuilder.append(c);
        }
        stringBuilder.reverse();
        selectedStudentJCode = Integer.parseInt(stringBuilder.toString());
    }

    public void cbLabSelected(ActionEvent actionEvent) {
        StringBuilder stringBuilder = new StringBuilder();
        char c;
        int i=cbLab.getValue().length();
        while ((c=cbLab.getValue().charAt(--i)) !='#'){
            stringBuilder.append(c);
        }
        stringBuilder.reverse();
        selectedLab = Integer.parseInt(stringBuilder.toString());
        System.out.println(labNameList.get(selectedLab-1));
    }

    public void onFormJournal(ActionEvent actionEvent) {
    }

    public void onSetRaiting(ActionEvent actionEvent) {
        int rating = 0;
        try {
            rating = Integer.parseInt(tbRaiting.getText());
        }catch (NumberFormatException e){
            Dialog dialog = new Alert(Alert.AlertType.ERROR);
            dialog.setContentText("Введено не числове значення!");
            dialog.showAndWait();
            return;
        }

        try {
            //language=mysql
            statement.executeUpdate("UPDATE `Журнал`\n" +
                    "\tSET\n" +
                    "\t\t" + labNameList.get(selectedLab) + "=" + rating +
                    "\n\tWHERE `Код_журналу`=" + selectedStudentJCode);
        } catch (SQLException e) {
            Dialog dialog = new ExceptionDialog(e);
            dialog.showAndWait();
            e.printStackTrace();
        }
    }
}
