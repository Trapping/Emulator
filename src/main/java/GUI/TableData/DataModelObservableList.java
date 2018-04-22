package GUI.TableData;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataModelObservableList {

    private ObservableList<DataModel> dataModels = FXCollections.observableArrayList();

    public ObservableList<DataModel> getDataModels() {
        return dataModels;
    }

    public void addData(String address, String flag, String code, String value){
        dataModels.add(new DataModel(address, flag, code, value));
    }
}


