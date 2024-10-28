package com.example.device;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class HelloController {

    @FXML
    private Button ButtonDelete;

    @FXML
    private Button Buttonadd;

    @FXML
    private TextField TextPrice;

    @FXML
    private TextField Textname;

    @FXML
    private TextField Textweight;

    @FXML
    private Label label;

    @FXML
    private RadioButton radlaptop;

    @FXML
    private RadioButton radsmart;

    @FXML
    private RadioButton radtablet;

    @FXML
    private ListView<Device> scene;

    ObservableList<Device> devices = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        scene.setItems(devices);
    }

    @FXML
    protected void clickedscene() {
        int id = scene.getSelectionModel().getSelectedIndex();
        if (id >= 0) {
            label.setText(devices.get(id).toString());
        }
    }

    @FXML
    void ButtonDelete() {
        int id = scene.getSelectionModel().getSelectedIndex();
        label.setText( devices.get(id).getName() + " is removed." );
        devices.remove(id);

    }

    @FXML
    void Buttonadd(ActionEvent event) {
        if (radsmart.isSelected()) {
            Smartphone smart = new Smartphone();
            smart.setName(Textname.getText());
            smart.setType(DeviceType.SMARTPHONE);
            smart.setPrice(Double.parseDouble(TextPrice.getText()));
            smart.setWeight(Double.parseDouble(Textweight.getText()));
            devices.add(smart);
        }
        if (radtablet.isSelected()) {
            Tablet tab = new Tablet();
            tab.setName(Textname.getText());
            tab.setType(DeviceType.TABLET);
            tab.setPrice(Double.parseDouble(TextPrice.getText()));
            tab.setWeight(Double.parseDouble(Textweight.getText()));
            devices.add(tab);
        }
        if (radlaptop.isSelected()) {
            Laptop lap = new Laptop();
            lap.setName(Textname.getText());
            lap.setType(DeviceType.LAPTOP);
            lap.setPrice(Double.parseDouble(TextPrice.getText()));
            lap.setWeight(Double.parseDouble(Textweight.getText()));
            devices.add(lap);
        }
        scene.setItems(devices);
    }
}
