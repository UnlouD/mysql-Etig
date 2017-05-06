package app.control;

import app.alert.AppAlert;
import app.service.impl.CountryServiceImpl;
import app.service.impl.RegionServiceImpl;
import app.model.Country;
import app.model.Region;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


import java.util.List;

public class RegionController {

    @FXML
    private TextField idTxt, regionTxt;
    @FXML
    private ComboBox<Country> countryCB;
    @FXML
    private TableView<Region> regionTb;
    @FXML
    private TableColumn<Region, Integer> idTc, countryTc;
    @FXML
    private TableColumn<Region, String> regionTc;

    private AppAlert alert = new AppAlert();
    private RegionServiceImpl regionService = new RegionServiceImpl();
    private CountryServiceImpl countryService = new CountryServiceImpl();
    private List<Country> allCountry = countryService.getAll();
    private List<Region> allRegion;
    private ObservableList<Region> regions;

    @FXML
    private void initialize() {
        for (Country country : allCountry) {
            countryCB.getItems().add(new Country(country.getId(), country.getName()));
        }
        viewRegion();
    }

    public void viewRegion() {
        allRegion = regionService.getAll();
        regions = FXCollections.observableArrayList();

        regionTb.setItems(null);
        for (Region region : allRegion) {
            regions.add(new Region(
                    region.getId(),
                    region.getName(),
                    region.getCountry()
            ));
        }
        regionTb.setItems(regions);
        idTc.setCellValueFactory(new PropertyValueFactory<Region, Integer>("id"));
        regionTc.setCellValueFactory(new PropertyValueFactory<Region, String>("name"));
        countryTc.setCellValueFactory(new PropertyValueFactory<Region, Integer>("country"));
    }

    public void add(ActionEvent actionEvent) {
        if ((regionTxt.getText().length() > 0) && (!countryCB.getSelectionModel().isEmpty())) {
            Region region = new Region();
            region.setName(regionTxt.getText());
            region.setCountry(new Country(countryCB.getSelectionModel().getSelectedItem().getId()));

            regionService.add(region);
            viewRegion();
            alert.setAlertInfo("Поздравляю!", "Новый региона успешно добавлен в БД!", regionTxt.getText());
        } else {
            alert.setAlertWarning("Предупреждение!", "Поле '№' является не обязательным.", "Не все поля заполнены!");
        }
    }

    public void delete(ActionEvent actionEvent) {
        if (idTxt.getText().length() > 0) {
            regionService.delete(Integer.parseInt(idTxt.getText()));
            viewRegion();
            alert.setAlertInfo("Поздравляю!", "Регион под №: " + idTxt.getText() + ". был удален из БД!", null);
        } else {
            alert.setAlertWarning("Предупреждение!", "Поле '№' является обязательным.", "Удаление происходит по выбору порядкового номера '№'!");
        }
    }

    public void update(ActionEvent actionEvent) {
        if ((regionTxt.getText().length() > 0) && (!countryCB.getSelectionModel().isEmpty())) {
            Region region = (Region) regionService.getById(Integer.parseInt(idTxt.getText()));
            region.setName(regionTxt.getText());
            region.setCountry(new Country(countryCB.getSelectionModel().getSelectedItem().getId()));

            regionService.update(region);
            viewRegion();
            alert.setAlertInfo("Поздравляю!", "Регион был изменен.", null);
        } else {
            alert.setAlertWarning("Предупреждение!", "Поле '№' является обязательным.", "Удаление происходит по выбору порядкового номера '№'!");
        }
    }

    public void pick(MouseEvent mouseEvent) {
        regionTb.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                idTxt.setText(String.valueOf(regionTb.getSelectionModel().getSelectedItem().getId()));
                regionTxt.setText(String.valueOf(regionTb.getSelectionModel().getSelectedItem().getName()));
                countryCB.setValue(new Country(regionTb.getSelectionModel().getSelectedItem().getCountry().getId(),
                        String.valueOf(regionTb.getSelectionModel().getSelectedItem().getCountry())));
            }
        });

    }
}
