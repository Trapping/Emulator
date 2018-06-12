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

    public static DataModel parseDataModel(String string){
        String address;
        String flag;
        String code;
        String value;
        //DataModel{address=8000, flag=, code=, value=}


        int index = string.indexOf("address=") + 7;
        StringBuilder stringBuilder = new StringBuilder();
        char c;

        while ((c=string.charAt(++index)) != ','){
            stringBuilder.append(c);
        }
        address = stringBuilder.toString();

        stringBuilder.delete(0, stringBuilder.length());
        index = string.indexOf("flag=") + 4;

        while ((c=string.charAt(++index)) != ','){
            stringBuilder.append(c);
        }
        flag = stringBuilder.toString();

        stringBuilder.delete(0, stringBuilder.length());
        index = string.indexOf("code=") + 4;

        while ((c=string.charAt(++index)) != ','){
            stringBuilder.append(c);
        }
        code = stringBuilder.toString();

        stringBuilder.delete(0, stringBuilder.length());
        index = string.indexOf("value=") + 5;

        while ((c=string.charAt(++index)) != '}'){
            stringBuilder.append(c);
        }
        value = stringBuilder.toString();

        return new DataModel(address, flag, code, value);
    }

    @Override
    public String toString() {
        return "DataModel{" +
                "address=" + address.getValue() +
                ", flag=" + flag.getValue() +
                ", code=" + code.getValue() +
                ", value=" + value.getValue() +
                '}';
    }
}
