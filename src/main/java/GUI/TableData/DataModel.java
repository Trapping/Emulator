package GUI.TableData;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataModel {
    private StringProperty address;
    private StringProperty flag;
    private StringProperty code;
    private StringProperty value;

    public DataModel(String address, String flag,String code, String value) {
        this.setAddress(new SimpleStringProperty(address));
        this.setFlag(new SimpleStringProperty(flag));
        this.setCode(new SimpleStringProperty(code));
        this.setValue(new SimpleStringProperty(value));
    }

    public StringProperty getAddress() {
        return address;
    }

    public void setAddress(StringProperty address) {
        this.address = address;
    }

    public StringProperty getFlag() {
        return flag;
    }

    public void setFlag(StringProperty flag) {
        this.flag = flag;
    }

    public StringProperty getValue() {
        return value;
    }

    public void setValue(StringProperty value) {
        this.value = value;
    }

    public StringProperty getCode() {
        return code;
    }

    public void setCode(StringProperty code) {
        this.code = code;
    }
}
