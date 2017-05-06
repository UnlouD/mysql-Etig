package app.control;

/**
 * Created by Этигэл
 */
        import app.alert.AppAlert;
        import app.service.impl.CityServiceImpl;
        import app.service.impl.RegionServiceImpl;
        import app.model.City;
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

public class CityController {

    @FXML
    private TextField idTxt, cityTxt;
    @FXML
    private ComboBox<Region> regionCB;
    @FXML
    private TableView<City> tbCity;
    @FXML
    private TableColumn<City, Integer> tcId, tcRegion;
    @FXML
    private TableColumn<City, String> tcCity;

    private AppAlert alert = new AppAlert();
    private RegionServiceImpl regionService = new RegionServiceImpl();
    private CityServiceImpl cityService = new CityServiceImpl();
    private List<City> allCity;
    private List<Region> allRegion = regionService.getAll();
    private ObservableList<City> cities;

    @FXML
    private void initialize() {
        for (Region region : allRegion) {
            regionCB.getItems().add(new Region(region.getId(), region.getName()));
        }
        viewCity();
    }

    public void viewCity() {
        allCity = cityService.getAll();
        cities = FXCollections.observableArrayList();

        tbCity.setItems(null);
        for (City city : allCity) {
            cities.add(new City(
                    city.getId(),
                    city.getName(),
                    city.getRegion()
            ));
        }
        tbCity.setItems(cities);

        tcId.setCellValueFactory(new PropertyValueFactory<City, Integer>("id"));
        tcCity.setCellValueFactory(new PropertyValueFactory<City, String>("name"));
        tcRegion.setCellValueFactory(new PropertyValueFactory<City, Integer>("region"));
    }

    public void addCity(ActionEvent actionEvent) {
        if ((cityTxt.getText().length() > 0) && (!regionCB.getSelectionModel().isEmpty())) {
            City city = new City();
            city.setName(cityTxt.getText());
            city.setRegion(new Region(regionCB.getSelectionModel().getSelectedItem().getId()));

            cityService.add(city);

            viewCity();
            alert.setAlertInfo("Поздравляю!", "Новый город успешно добавлен в БД!", cityTxt.getText());
        } else {
            alert.setAlertWarning("Предупреждение!", "Поле '№' является не обязательным.", "Не все поля заполнены!");
        }
    }

    public void deleteCity(ActionEvent actionEvent) {
        if (idTxt.getText().length() > 0) {
            cityService.delete(Integer.parseInt(idTxt.getText()));
            viewCity();
            alert.setAlertInfo("Поздравляю!", "Город под №: " + idTxt.getText() + ". был удален из БД!", null);
        } else {
            alert.setAlertWarning("Предупреждение!", "Поле '№' является обязательным.", "Удаление происходит по выбору порядкового номера '№'!");
        }
    }

    public void updateCity(ActionEvent actionEvent) {

        if ((cityTxt.getText().length() > 0) && (!regionCB.getSelectionModel().isEmpty())) {
            City city = (City) cityService.getById(Integer.parseInt(idTxt.getText()));
            city.setName(cityTxt.getText());
            city.setRegion(new Region(regionCB.getSelectionModel().getSelectedItem().getId()));

            cityService.update(city);

            viewCity();
            alert.setAlertInfo("Поздравляю!", "Город был изменен.", null);
        } else {
            alert.setAlertWarning("Предупреждение!", "Поле '№' является обязательным.", "Удаление происходит по выбору порядкового номера '№'!");
        }
    }


    public void pick(MouseEvent mouseEvent) {
        tbCity.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                idTxt.setText(String.valueOf(tbCity.getSelectionModel().getSelectedItem().getId()));
                cityTxt.setText(String.valueOf(tbCity.getSelectionModel().getSelectedItem().getName()));
                regionCB.setValue(new Region(tbCity.getSelectionModel().getSelectedItem().getRegion().getId(),
                        String.valueOf(tbCity.getSelectionModel().getSelectedItem().getRegion())));
                System.out.println(new Region(tbCity.getSelectionModel().getSelectedItem().getRegion().getId(),
                        String.valueOf(tbCity.getSelectionModel().getSelectedItem().getRegion())));
            }
        });
    }
}
