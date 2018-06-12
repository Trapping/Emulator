package GUI;

import Core.Command;
import Core.CommandsList;
import Core.Core8080;
import GUI.TableData.DataModel;
import GUI.TableData.DataModelObservableList;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import org.controlsfx.control.textfield.CustomTextField;
import org.controlsfx.control.textfield.TextFields;
import org.controlsfx.dialog.ExceptionDialog;

import java.io.*;
import java.net.URL;
import java.util.*;

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
    @FXML
    public CustomTextField tbValue;
    @FXML
    public ToggleButton tglSafeInput;

    private int addressMarker;

    private CommandsList commandsList;

    private DataModelObservableList dataModelObservableList = new DataModelObservableList();

    private Core8080 core8080;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clmAddress.setCellValueFactory(cellData -> cellData.getValue().getAddress());
        clmFlag.setCellValueFactory(cellData -> cellData.getValue().getFlag());
        clmCode.setCellValueFactory(cellData -> cellData.getValue().getCode());
        clmValue.setCellValueFactory(cellData -> cellData.getValue().getValue());
        tblData.setItems(dataModelObservableList.getDataModels());
        tblData.setEditable(false);
        tblData.setSortPolicy(param -> false);


        core8080 = new Core8080();

        commandsList = new CommandsList();

        commandsList.addCommand(new Command("87", "ADD A"));
        commandsList.addCommand(new Command("80", "ADD B"));
        commandsList.addCommand(new Command("81", "ADD C"));
        commandsList.addCommand(new Command("82", "ADD D"));
        commandsList.addCommand(new Command("83", "ADD E"));
        commandsList.addCommand(new Command("84", "ADD H"));
        commandsList.addCommand(new Command("85", "ADD L"));
        commandsList.addCommand(new Command("86", "ADD M"));
        commandsList.addCommand(new Command("C6", "ADI d8"));
        commandsList.addCommand(new Command("8F", "ADC A"));
        commandsList.addCommand(new Command("88", "ADC B"));
        commandsList.addCommand(new Command("89", "ADC C"));
        commandsList.addCommand(new Command("8A", "ADC D"));
        commandsList.addCommand(new Command("8B", "ADC E"));
        commandsList.addCommand(new Command("8C", "ADC H"));
        commandsList.addCommand(new Command("8D", "ADC L"));
        commandsList.addCommand(new Command("8E", "ADC M"));
        commandsList.addCommand(new Command("CE", "ACI d8"));
        commandsList.addCommand(new Command("A7", "ANA A"));
        commandsList.addCommand(new Command("A0", "ANA B"));
        commandsList.addCommand(new Command("A1", "ANA C"));
        commandsList.addCommand(new Command("A2", "ANA D"));
        commandsList.addCommand(new Command("A3", "ANA E"));
        commandsList.addCommand(new Command("A4", "ANA H"));
        commandsList.addCommand(new Command("A5", "ANA L"));
        commandsList.addCommand(new Command("A6", "ANA M"));
        commandsList.addCommand(new Command("E6", "ANI d8"));
        commandsList.addCommand(new Command("CD", "CALL a16"));
        commandsList.addCommand(new Command("CC", "CZ a16"));
        commandsList.addCommand(new Command("C4", "СNZ a16"));
        commandsList.addCommand(new Command("F4", "СP a16"));
        commandsList.addCommand(new Command("FC", "СM a16"));
        commandsList.addCommand(new Command("DC", "CC a16"));
        commandsList.addCommand(new Command("D4", "CNC a16"));
        commandsList.addCommand(new Command("EC", "CPE a16"));
        commandsList.addCommand(new Command("E4", "CPO a16"));
        commandsList.addCommand(new Command("2F", "CMA"));
        commandsList.addCommand(new Command("3F", "CMC"));
        commandsList.addCommand(new Command("BF", "CMP A"));
        commandsList.addCommand(new Command("B8", "CMP B"));
        commandsList.addCommand(new Command("B9", "CMP C"));
        commandsList.addCommand(new Command("BA", "CMP D"));
        commandsList.addCommand(new Command("BB", "CMP E"));
        commandsList.addCommand(new Command("BC", "CMP H"));
        commandsList.addCommand(new Command("BD", "CMP L"));
        commandsList.addCommand(new Command("BE", "CMP M"));
        commandsList.addCommand(new Command("FE", "CPI d8"));
        commandsList.addCommand(new Command("27", "DAA"));
        commandsList.addCommand(new Command("9", "DAD B"));
        commandsList.addCommand(new Command("19", "DAD D"));
        commandsList.addCommand(new Command("29", "DAD H"));
        commandsList.addCommand(new Command("39", "DAD SP"));
        commandsList.addCommand(new Command("3D", "DCR A"));
        commandsList.addCommand(new Command("5", "DCR B"));
        commandsList.addCommand(new Command("0D", "DCR C"));
        commandsList.addCommand(new Command("15", "DCR D"));
        commandsList.addCommand(new Command("1D", "DCR E"));
        commandsList.addCommand(new Command("25", "DCR H"));
        commandsList.addCommand(new Command("2D", "DCR L"));
        commandsList.addCommand(new Command("35", "DCR M"));
        commandsList.addCommand(new Command("0B", "DCX B"));
        commandsList.addCommand(new Command("1B", "DCX D"));
        commandsList.addCommand(new Command("2B", "DCX H"));
        commandsList.addCommand(new Command("3B", "DCX SP"));
        commandsList.addCommand(new Command("F3", "DI"));
        commandsList.addCommand(new Command("FB", "EI"));
        commandsList.addCommand(new Command("76", "HLT"));
        commandsList.addCommand(new Command("DB", "IN pp"));
        commandsList.addCommand(new Command("3C", "INR A"));
        commandsList.addCommand(new Command("4", "INR B"));
        commandsList.addCommand(new Command("0C", "INR C"));
        commandsList.addCommand(new Command("14", "INR D"));
        commandsList.addCommand(new Command("1C", "INR E"));
        commandsList.addCommand(new Command("24", "INR H"));
        commandsList.addCommand(new Command("2C", "INR L"));
        commandsList.addCommand(new Command("34", "INR M"));
        commandsList.addCommand(new Command("3", "INX B"));
        commandsList.addCommand(new Command("13", "INX D"));
        commandsList.addCommand(new Command("23", "INX H"));
        commandsList.addCommand(new Command("33", "INX SP"));
        commandsList.addCommand(new Command("C3", "JMP a16"));
        commandsList.addCommand(new Command("CA", "JZ a16"));
        commandsList.addCommand(new Command("C2", "JNZ a16"));
        commandsList.addCommand(new Command("F2", "JP a16"));
        commandsList.addCommand(new Command("FA", "JM a16"));
        commandsList.addCommand(new Command("DA", "JC a16"));
        commandsList.addCommand(new Command("D2", "JNC a16"));
        commandsList.addCommand(new Command("EA", "JPE a16"));
        commandsList.addCommand(new Command("E2", "JPO a16"));
        commandsList.addCommand(new Command("3A", "LDA a16"));
        commandsList.addCommand(new Command("0A", "LDAX B"));
        commandsList.addCommand(new Command("1A", "LDAX D"));
        commandsList.addCommand(new Command("2A", "LHLD a16"));
        commandsList.addCommand(new Command("1", "LXI B,d16"));
        commandsList.addCommand(new Command("11", "LXI D,d16"));
        commandsList.addCommand(new Command("21", "LXI H,d16"));
        commandsList.addCommand(new Command("31", "LXI SP,d16"));
        commandsList.addCommand(new Command("7F", "MOV A,A"));
        commandsList.addCommand(new Command("78", "MOV A,B"));
        commandsList.addCommand(new Command("79", "MOV A,C"));
        commandsList.addCommand(new Command("7A", "MOV A,D"));
        commandsList.addCommand(new Command("7B", "MOV A,E"));
        commandsList.addCommand(new Command("7C", "MOV A,H"));
        commandsList.addCommand(new Command("7D", "MOV A,L"));
        commandsList.addCommand(new Command("7E", "MOV A,M"));
        commandsList.addCommand(new Command("47", "MOV B,A"));
        commandsList.addCommand(new Command("40", "MOV B,B"));
        commandsList.addCommand(new Command("41", "MOV B,C"));
        commandsList.addCommand(new Command("42", "MOV B,D"));
        commandsList.addCommand(new Command("43", "MOV B,E"));
        commandsList.addCommand(new Command("44", "MOV B,H"));
        commandsList.addCommand(new Command("45", "MOV B,L"));
        commandsList.addCommand(new Command("46", "MOV B,M"));
        commandsList.addCommand(new Command("4F", "MOV C,A"));
        commandsList.addCommand(new Command("48", "MOV C,B"));
        commandsList.addCommand(new Command("49", "MOV C,C"));
        commandsList.addCommand(new Command("4A", "MOV C,D"));
        commandsList.addCommand(new Command("4B", "MOV C,E"));
        commandsList.addCommand(new Command("4C", "MOV C,H"));
        commandsList.addCommand(new Command("4D", "MOV C,L"));
        commandsList.addCommand(new Command("4E", "MOV C,M"));
        commandsList.addCommand(new Command("57", "MOV D,A"));
        commandsList.addCommand(new Command("50", "MOV D,B"));
        commandsList.addCommand(new Command("51", "MOV D,C"));
        commandsList.addCommand(new Command("52", "MOV D,D"));
        commandsList.addCommand(new Command("53", "MOV D,E"));
        commandsList.addCommand(new Command("54", "MOV D,H"));
        commandsList.addCommand(new Command("55", "MOV D,L"));
        commandsList.addCommand(new Command("56", "MOV D,M"));
        commandsList.addCommand(new Command("5F", "MOV E,A"));
        commandsList.addCommand(new Command("58", "MOV E,B"));
        commandsList.addCommand(new Command("59", "MOV E,C"));
        commandsList.addCommand(new Command("5A", "MOV E,D"));
        commandsList.addCommand(new Command("5B", "MOV E,E"));
        commandsList.addCommand(new Command("5C", "MOV E,H"));
        commandsList.addCommand(new Command("5D", "MOV E,L"));
        commandsList.addCommand(new Command("5E", "MOV E,M"));
        commandsList.addCommand(new Command("67", "MOV H,A"));
        commandsList.addCommand(new Command("60", "MOV H,B"));
        commandsList.addCommand(new Command("61", "MOV H,C"));
        commandsList.addCommand(new Command("62", "MOV H,D"));
        commandsList.addCommand(new Command("63", "MOV H,E"));
        commandsList.addCommand(new Command("64", "MOV H,H"));
        commandsList.addCommand(new Command("65", "MOV H,L"));
        commandsList.addCommand(new Command("66", "MOV H,M"));
        commandsList.addCommand(new Command("6F", "MOV L,A"));
        commandsList.addCommand(new Command("68", "MOV L,B"));
        commandsList.addCommand(new Command("69", "MOV L,C"));
        commandsList.addCommand(new Command("6A", "MOV L,D"));
        commandsList.addCommand(new Command("6B", "MOV L,E"));
        commandsList.addCommand(new Command("6C", "MOV L,H"));
        commandsList.addCommand(new Command("6D", "MOV L,L"));
        commandsList.addCommand(new Command("6E", "MOV L,M"));
        commandsList.addCommand(new Command("77", "MOV M,A"));
        commandsList.addCommand(new Command("70", "MOV M,B"));
        commandsList.addCommand(new Command("71", "MOV M,C"));
        commandsList.addCommand(new Command("72", "MOV M,D"));
        commandsList.addCommand(new Command("73", "MOV M,E"));
        commandsList.addCommand(new Command("74", "MOV M,H"));
        commandsList.addCommand(new Command("75", "MOV M,L"));
        commandsList.addCommand(new Command("3E", "MVI A,d8"));
        commandsList.addCommand(new Command("6", "MVI B,d8"));
        commandsList.addCommand(new Command("0E", "MVI C,d8"));
        commandsList.addCommand(new Command("16", "MVI D,d8"));
        commandsList.addCommand(new Command("1E", "MVI E,d8"));
        commandsList.addCommand(new Command("26", "MVI H,d8"));
        commandsList.addCommand(new Command("2E", "MVI L,d8"));
        commandsList.addCommand(new Command("36", "MVI M,d8"));
        commandsList.addCommand(new Command("0", "NOP"));
        commandsList.addCommand(new Command("B7", "ORA A"));
        commandsList.addCommand(new Command("B0", "ORA B"));
        commandsList.addCommand(new Command("B1", "ORA C"));
        commandsList.addCommand(new Command("B2", "ORA D"));
        commandsList.addCommand(new Command("B3", "ORA E"));
        commandsList.addCommand(new Command("B4", "ORA H"));
        commandsList.addCommand(new Command("B5", "ORA L"));
        commandsList.addCommand(new Command("B6", "ORA M"));
        commandsList.addCommand(new Command("F6", "ORI d8"));
        commandsList.addCommand(new Command("D3", "OUT pp"));
        commandsList.addCommand(new Command("E9", "PCHL"));
        commandsList.addCommand(new Command("C1", "POP B"));
        commandsList.addCommand(new Command("D1", "POP D"));
        commandsList.addCommand(new Command("E1", "POP H"));
        commandsList.addCommand(new Command("F1", "POP PSW"));
        commandsList.addCommand(new Command("C5", "PUSH B"));
        commandsList.addCommand(new Command("D5", "PUSH D"));
        commandsList.addCommand(new Command("E5", "PUSH H"));
        commandsList.addCommand(new Command("F5", "PUSH PSW"));
        commandsList.addCommand(new Command("17", "RAL"));
        commandsList.addCommand(new Command("1F", "RAR"));
        commandsList.addCommand(new Command("7", "RLC"));
        commandsList.addCommand(new Command("0F", "RRC"));
        commandsList.addCommand(new Command("C9", "RET"));
        commandsList.addCommand(new Command("C8", "RZ"));
        commandsList.addCommand(new Command("C0", "RNZ"));
        commandsList.addCommand(new Command("F0", "RP"));
        commandsList.addCommand(new Command("F8", "RM"));
        commandsList.addCommand(new Command("D8", "RC"));
        commandsList.addCommand(new Command("D0", "RNC"));
        commandsList.addCommand(new Command("E8", "RPE"));
        commandsList.addCommand(new Command("E0", "RPO"));
        commandsList.addCommand(new Command("C7", "RST 0"));
        commandsList.addCommand(new Command("CF", "RST 1"));
        commandsList.addCommand(new Command("D7", "RST 2"));
        commandsList.addCommand(new Command("DF", "RST 3"));
        commandsList.addCommand(new Command("E7", "RST 4"));
        commandsList.addCommand(new Command("EF", "RST 5"));
        commandsList.addCommand(new Command("F7", "RST 6"));
        commandsList.addCommand(new Command("FF", "RST 7"));
        commandsList.addCommand(new Command("F9", "SPHL"));
        commandsList.addCommand(new Command("22", "SHLD a16"));
        commandsList.addCommand(new Command("32", "STA a16"));
        commandsList.addCommand(new Command("2", "STAX B"));
        commandsList.addCommand(new Command("12", "STAX D"));
        commandsList.addCommand(new Command("37", "STC"));
        commandsList.addCommand(new Command("97", "SUB A"));
        commandsList.addCommand(new Command("90", "SUB B"));
        commandsList.addCommand(new Command("91", "SUB C"));
        commandsList.addCommand(new Command("92", "SUB D"));
        commandsList.addCommand(new Command("93", "SUB E"));
        commandsList.addCommand(new Command("94", "SUB H"));
        commandsList.addCommand(new Command("95", "SUB L"));
        commandsList.addCommand(new Command("96", "SUB M"));
        commandsList.addCommand(new Command("D6", "SUI d8"));
        commandsList.addCommand(new Command("9F", "SBB A"));
        commandsList.addCommand(new Command("98", "SBB B"));
        commandsList.addCommand(new Command("99", "SBB C"));
        commandsList.addCommand(new Command("9A", "SBB D"));
        commandsList.addCommand(new Command("9B", "SBB E"));
        commandsList.addCommand(new Command("9C", "SBB H"));
        commandsList.addCommand(new Command("9D", "SBB L"));
        commandsList.addCommand(new Command("9E", "SBB M"));
        commandsList.addCommand(new Command("DE", "SBI d8"));
        commandsList.addCommand(new Command("EB", "XCHG"));
        commandsList.addCommand(new Command("E3", "XTHL"));
        commandsList.addCommand(new Command("AF", "XRA A"));
        commandsList.addCommand(new Command("A8", "XRA B"));
        commandsList.addCommand(new Command("A9", "XRA C"));
        commandsList.addCommand(new Command("AA", "XRA D"));
        commandsList.addCommand(new Command("AB", "XRA E"));
        commandsList.addCommand(new Command("AC", "XRA H"));
        commandsList.addCommand(new Command("AD", "XRA L"));
        commandsList.addCommand(new Command("AE", "XRA M"));
        commandsList.addCommand(new Command("EE", "XRI d8"));


        ArrayList<String> possibleSuggestions = commandsList.getCodesArrayList();

        TextFields.bindAutoCompletion(tbValue, possibleSuggestions);

        int startValue = 0x8000;
        for (int i = 0; i <= 966; i++) {
            dataModelObservableList.addData(Integer.toHexString(startValue).toUpperCase(), "", "", "");
            startValue++;
        }

        tblData.refresh();

        //core8080.i8080_init();


        core8080.i8080_init();
        markAddress(Integer.parseUnsignedInt("8000", 16));
        safeScrollTable(getIndexOfAdressInTable("8000"));
        refreshRegs();

    }

    public void setDataInRowFromCode(String address, String code){
        for (int i = 0; i < dataModelObservableList.getDataModels().size(); i++) {
            if (address.equals(dataModelObservableList.getDataModels().get(i).getAddress().getValue())) {
                for (int j = 0; j < commandsList.getCommandArrayList().size(); j++) {

                    if(code.equals(commandsList.getCommandArrayList().get(j).getCode())){
                        setDataCodeInCell(i, commandsList.getCommandArrayList().get(j).getCode());
                        setDataValueInCell(i, commandsList.getCommandArrayList().get(j).getName());
                    }

                }

                tblData.refresh();
                break;
            }
        }
    }

    private void setDataInRow(String address, String value) {
        for (int i = 0; i < dataModelObservableList.getDataModels().size(); i++) {
            if (address.equals(dataModelObservableList.getDataModels().get(i).getAddress().getValue())) {
                try {
                    core8080.WR_BYTE(getIntFromAdressInTable(i), Integer.parseUnsignedInt(value, 16));
                    setDataValueInCell(i, value);
                } catch (NumberFormatException e){
                    System.out.println("Неможливо записати нечислове значення в пам'ять!");
                    e.printStackTrace();
                    Dialog dialog = new ExceptionDialog(e);
                    dialog.setTitle("Помилка!");
                    dialog.setHeaderText("Неможливо записати нечислове значення в пам'ять!");
                    dialog.showAndWait();
                }
                tblData.refresh();
                break;
            }
        }
    }

    private void setDataValueInCell(int indexOfCell, String value) {
        dataModelObservableList.getDataModels().get(indexOfCell).setValue(new SimpleStringProperty(value));
    }

    private void setDataCodeInCell(int indexOfCell, String code) {
        dataModelObservableList.getDataModels().get(indexOfCell).setCode(new SimpleStringProperty(code));
        core8080.WR_BYTE(getIntFromAdressInTable(indexOfCell), getIntFromCodeInTable(indexOfCell));
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
        try {
            addressMarker = Integer.parseUnsignedInt(tbAddress.getText(), 16);
        } catch (NumberFormatException e){
            e.printStackTrace();
            return;
        }
        if (tglSafeInput.isSelected()) {
            setDataInRowFromCode(tbAddress.getText(), tbValue.getText());
        } else {
            setDataInRow(tbAddress.getText(), tbValue.getText());
        }
    }

    public void onBreak(ActionEvent actionEvent) {
        core8080.i8080_init();
        markAddress(Integer.parseUnsignedInt("8000", 16));
        safeScrollTable(getIndexOfAdressInTable("8000"));
        refreshRegs();
    }

    public void onAdPlus(ActionEvent actionEvent) {
        incrementMarkedAddress(addressMarker);
    }

    public void onAdMinus(ActionEvent actionEvent) {
        decrementMarkedAddress(addressMarker);
    }

    public void onStart(ActionEvent actionEvent) {
        core8080.i8080_instruction();
        markAddress(core8080.i8080_pc());
        refreshRegs();
        safeScrollTable(getIndexOfAdressInTable(Integer.toHexString(addressMarker).toUpperCase()));
    }

    public void onAddress(ActionEvent actionEvent) {
        //addressMarker = Integer.parseUnsignedInt(tbAddress.getText(), 16);
        markAddress(Integer.parseUnsignedInt(tbAddress.getText(), 16));
        safeScrollTable(getIndexOfAdressInTable(Integer.toHexString(addressMarker)));
        core8080.i8080_jump(addressMarker);

    }

    public void onValue(ActionEvent actionEvent) {
    }

    public void onRegister(ActionEvent actionEvent) {
    }

    public void onComandsTableClicked(ActionEvent actionEvent) {
    }

    public void tbAddressEdited(ActionEvent actionEvent) {
        int index = -1;
        int i = 0;
        for (DataModel dataModel: dataModelObservableList.getDataModels()
                ) {
            i ++;
            if (dataModel.getAddress().getValue().equals(tbAddress.getText())){
                index = i;
                break;
            }
        }

        if (index > -1) {
            tblData.getSelectionModel().select(index -1);
            tblData.scrollTo(index -1);
        }
    }

    public void tbAdressKeyTypeDetected(KeyEvent keyEvent) {
        int index = -1;
        int i = 0;
        for (DataModel dataModel: dataModelObservableList.getDataModels()
             ) {
            i ++;
            if (dataModel.getAddress().getValue().equals(tbAddress.getText())){
                index = i;
                break;
            }
        }

        if (index > -1) {
            tblData.getSelectionModel().select(index -1);
            tblData.scrollTo(index -1);
        }
    }

    public void refreshRegs(){
        rgA.setText(String.valueOf(Integer.toHexString(core8080.i8080_regs_a()).toUpperCase()));
        rgB.setText(String.valueOf(Integer.toHexString(core8080.i8080_regs_b()).toUpperCase()));
        rgC.setText(String.valueOf(Integer.toHexString(core8080.i8080_regs_c()).toUpperCase()));
        rgD.setText(String.valueOf(Integer.toHexString(core8080.i8080_regs_d()).toUpperCase()));
        rgE.setText(String.valueOf(Integer.toHexString(core8080.i8080_regs_e()).toUpperCase()));
        rgH.setText(String.valueOf(Integer.toHexString(core8080.i8080_regs_h()).toUpperCase()));
        rgL.setText(String.valueOf(Integer.toHexString(core8080.i8080_regs_l()).toUpperCase()));
    }

    public int getIntFromAdressInTable(int index){
        return Integer.parseUnsignedInt(tblData.getItems().get(index).getAddress().getValue(), 16);
    }

    public int getIntFromCodeInTable(int index){
        return Integer.parseUnsignedInt(tblData.getItems().get(index).getCode().getValue(), 16);
    }

    public void markAddress(int address){
        addressMarker = address;
        tbAddress.setText(Integer.toHexString(address).toUpperCase());
        int index = getIndexOfAdressInTable(Integer.toHexString(address -1).toUpperCase());
        tblData.getSelectionModel().select(index);
        //safeScrollTable(index);
        core8080.i8080_jump(address);
    }

    public void safeScrollTable(int index){
        if (index > 10){
            tblData.scrollTo(index -5);
        }
    }

    public int getIndexOfAdressInTable(String address){
        int index = -1;
        int i = 0;
        for (DataModel dataModel: dataModelObservableList.getDataModels()
                ) {
            i ++;
            if (dataModel.getAddress().getValue().equals(address)){
                index = i;
                break;
            }
        }
        return index;
    }

    public void incrementMarkedAddress(int address){
        markAddress(++address);
        safeScrollTable(getIndexOfAdressInTable(Integer.toHexString(address -1).toUpperCase()));
    }

    public void decrementMarkedAddress(int address){
        markAddress(--address);
        safeScrollTable(getIndexOfAdressInTable(Integer.toHexString(address -1).toUpperCase()));
    }

    public void onTblDataMouseClicked(MouseEvent mouseEvent) {
        int selectedAddress = getIntFromAdressInTable(tblData.getSelectionModel().getFocusedIndex());
        markAddress(selectedAddress);
    }

    public void mnFileSave(ActionEvent actionEvent) {
        StringBuilder string = new StringBuilder();
        for (DataModel dataModel: tblData.getItems()
             ) {
            //System.out.println(dataModel.toString());
            string.insert(string.length(), dataModel.toString() + "\n");
        }
        System.out.println(string + "\n Ці данні збережено!");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Збереження програми");
        File file = fileChooser.showSaveDialog(tblData.getScene().getWindow());

        try(FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(String.valueOf(string));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mnFileLoad(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Завантаження програми");
        File file = fileChooser.showOpenDialog(tblData.getScene().getWindow());
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String stringLine;
            while ((stringLine = bufferedReader.readLine()) != null){
                System.out.println(DataModel.parseDataModel(stringLine).toString());
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void mnFileQuit(ActionEvent actionEvent) {
    }

    public void tglSafeInputSelectedChange(ActionEvent actionEvent) {
    }
}