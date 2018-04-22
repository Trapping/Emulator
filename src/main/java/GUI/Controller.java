package GUI;

import GUI.TableData.DataModel;
import GUI.TableData.DataModelObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public TextField rgA;
    @FXML
    public TextField rgFlag;
    @FXML
    public TextField rgB;
    @FXML
    public TextField rgC;
    @FXML
    public TextField rgD;
    @FXML
    public TextField rgE;
    @FXML
    public TextField rgH;
    @FXML
    public TextField rgL;
    @FXML
    public TextField rgSPhi;
    @FXML
    public TextField rgSPlo;
    @FXML
    public TextField rgPChi;
    @FXML
    public TextField rgPClo;
    @FXML
    public TextField tbAddress;
    @FXML
    public TextField tbValue;
    @FXML
    public TableView<DataModel> tblData;
    @FXML
    public RadioButton tglStep;
    @FXML
    public ToggleGroup tglGroup1;
    @FXML
    public RadioButton tglAuto;
    @FXML
    public TableColumn<DataModel, String> clmAddress;
    @FXML
    public TableColumn<DataModel, String> clmFlag;
    @FXML
    public TableColumn<DataModel, String> clmCode;
    @FXML
    public TableColumn<DataModel, String> clmValue;

    private DataModelObservableList dataModelObservableList = new DataModelObservableList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clmAddress.setCellValueFactory(cellData -> cellData.getValue().getAddress());
        clmFlag.setCellValueFactory(cellData -> cellData.getValue().getFlag());
        clmCode.setCellValueFactory(cellData -> cellData.getValue().getCode());
        clmValue.setCellValueFactory(cellData -> cellData.getValue().getValue());
        tblData.setItems(dataModelObservableList.getDataModels());
        tblData.setEditable(false);
        tblData.setSortPolicy(param -> false);

        int startValue = 0x8000;

        for (int i = 0; i <= 966; i++) {
            dataModelObservableList.addData(Integer.toHexString(startValue).toUpperCase(), "", "", "");
            startValue++;
        }

    }

    public void on0(ActionEvent actionEvent) {
    }

    public void on1(ActionEvent actionEvent) {
    }

    public void on2(ActionEvent actionEvent) {
    }

    public void on3(ActionEvent actionEvent) {
    }

    public void on4(ActionEvent actionEvent) {
    }

    public void on5(ActionEvent actionEvent) {
    }

    public void on6(ActionEvent actionEvent) {
    }

    public void on7(ActionEvent actionEvent) {
    }

    public void on8(ActionEvent actionEvent) {
    }

    public void on9(ActionEvent actionEvent) {
    }

    public void onA(ActionEvent actionEvent) {
    }

    public void onB(ActionEvent actionEvent) {
    }

    public void onC(ActionEvent actionEvent) {
    }

    public void onD(ActionEvent actionEvent) {
    }

    public void onE(ActionEvent actionEvent) {
    }

    public void onF(ActionEvent actionEvent) {
    }

    public void onSetValue(ActionEvent actionEvent) {
    }

    public void onBreak(ActionEvent actionEvent) {
    }

    public void onAdPlus(ActionEvent actionEvent) {
    }

    public void onAdMinus(ActionEvent actionEvent) {
    }

    public void onStart(ActionEvent actionEvent) {
    }

    public void onAddress(ActionEvent actionEvent) {
    }

    public void onValue(ActionEvent actionEvent) {
    }

    public void onRegister(ActionEvent actionEvent) {
    }

    public void onComandsTableClicked(ActionEvent actionEvent) {
    }
}
