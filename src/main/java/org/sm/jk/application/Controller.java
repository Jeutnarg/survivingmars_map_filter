package org.sm.jk.application;

import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.controlsfx.control.CheckComboBox;
import org.sm.jk.application.model.DisplayMap;
import org.sm.jk.application.utils.AdvancedBreakthroughParserUtil;
import org.sm.jk.application.utils.ChoGGiParser;
import org.sm.jk.application.utils.DisplayMapFilter;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button_fileSelector;

    @FXML
    private Label label_fileSelector;

    @FXML
    private CheckComboBox<String> combobox_topography_options;

    @FXML
    private CheckComboBox<String> combobox_maptype_options;

    @FXML
    private CheckComboBox<String> combobox_location_options;

    @FXML
    private CheckComboBox<String> combobox_breakthroughplus_options;

    @FXML
    private CheckComboBox<String> combobox_breakthroughminus_options;

    @FXML
    private CheckBox checkbox_advancedbreak;

    @FXML
    private TextArea textarea_advancedbreak;

    @FXML
    private CheckComboBox<Integer> combobox_resources_metal;

    @FXML
    private CheckComboBox<Integer> combobox_resources_raremetals;

    @FXML
    private CheckComboBox<Integer> combobox_resources_concrete;

    @FXML
    private CheckComboBox<Integer> combobox_resources_water;

    @FXML
    private CheckComboBox<Integer> combobox_resources_dustdevils;

    @FXML
    private CheckComboBox<Integer> combobox_resources_duststorms;

    @FXML
    private CheckComboBox<Integer> combobox_resources_meteorshowers;

    @FXML
    private CheckComboBox<Integer> combobox_resources_coldwaves;

    @FXML
    private TableView<DisplayMap> table;

    @FXML
    private TableColumn<DisplayMap, String> table_coordinates;

    @FXML
    private TableColumn<DisplayMap, String> table_topography;

    @FXML
    private TableColumn<DisplayMap, Integer> table_altitude;

    @FXML
    private TableColumn<DisplayMap, Integer> table_temperature;

    @FXML
    private TableColumn<DisplayMap, String> table_maptype;

    @FXML
    private TableColumn<DisplayMap, String> table_location;

    @FXML
    private TableColumn<DisplayMap, String> table_resources;

    @FXML
    private TableColumn<DisplayMap, String> table_threats;

    @FXML
    private TableColumn<DisplayMap, Integer> table_difficulty;

    @FXML
    private ListView<String> mapdetails_breakthroughs1;
    @FXML
    private ListView<String> mapdetails_breakthroughs2;
    //
    //
    //
    private Stage primaryStage;
    private DisplayMapFilter filterMaster;
    private FilteredList<DisplayMap> displayMapFilteredList;
    private ChoGGiParser choGGiParser;

    @FXML
    void initialize() {
        assert button_fileSelector != null : "fx:id=\"button_fileSelector\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert label_fileSelector != null : "fx:id=\"label_fileSelector\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert combobox_topography_options != null : "fx:id=\"combobox_topography_options\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert combobox_maptype_options != null : "fx:id=\"combobox_maptype_options\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert combobox_location_options != null : "fx:id=\"combobox_location_options\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert combobox_breakthroughplus_options != null : "fx:id=\"combobox_breakthroughplus_options\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert combobox_breakthroughminus_options != null : "fx:id=\"combobox_breakthroughminus_options\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert checkbox_advancedbreak != null : "fx:id=\"checkbox_advancedbreak\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert textarea_advancedbreak != null : "fx:id=\"textarea_advancedbreak\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert combobox_resources_metal != null : "fx:id=\"combobox_resources_metal\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert combobox_resources_raremetals != null : "fx:id=\"combobox_resources_raremetals\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert combobox_resources_concrete != null : "fx:id=\"combobox_resources_concrete\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert combobox_resources_water != null : "fx:id=\"combobox_resources_water\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert combobox_resources_dustdevils != null : "fx:id=\"combobox_resources_dustdevils\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert combobox_resources_duststorms != null : "fx:id=\"combobox_resources_duststorms\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert combobox_resources_meteorshowers != null : "fx:id=\"combobox_resources_meteorshowers\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert combobox_resources_coldwaves != null : "fx:id=\"combobox_resources_coldwaves\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert table != null : "fx:id=\"table\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert table_coordinates != null : "fx:id=\"table_coordinates\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert table_topography != null : "fx:id=\"table_topography\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert table_altitude != null : "fx:id=\"table_altitude\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert table_temperature != null : "fx:id=\"table_temperature\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert table_maptype != null : "fx:id=\"table_maptype\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert table_location != null : "fx:id=\"table_location\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert table_resources != null : "fx:id=\"table_resources\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert table_threats != null : "fx:id=\"table_threats\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert table_difficulty != null : "fx:id=\"table_difficulty\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert mapdetails_breakthroughs1 != null : "fx:id=\"mapdetails_breakthroughs1\" was not injected: check your FXML file 'initial_screen.fxml'.";
        assert mapdetails_breakthroughs2 != null : "fx:id=\"mapdetails_breakthroughs2\" was not injected: check your FXML file 'initial_screen.fxml'.";

        addNumbers(combobox_resources_metal);
        addNumbers(combobox_resources_raremetals);
        addNumbers(combobox_resources_concrete);
        addNumbers(combobox_resources_water);
        addNumbers(combobox_resources_dustdevils);
        addNumbers(combobox_resources_duststorms);
        addNumbers(combobox_resources_meteorshowers);
        addNumbers(combobox_resources_coldwaves);

        table_coordinates.setCellValueFactory(
            new PropertyValueFactory<DisplayMap, String>("coordinates")
        );
        table_topography.setCellValueFactory(
            new PropertyValueFactory<DisplayMap, String>("topography")
        );
        table_altitude.setCellValueFactory(
            new PropertyValueFactory<DisplayMap, Integer>("altitude")
        );
        table_temperature.setCellValueFactory(
            new PropertyValueFactory<DisplayMap, Integer>("temperature")
        );
        table_maptype.setCellValueFactory(
            new PropertyValueFactory<DisplayMap, String>("mapType")
        );
        table_location.setCellValueFactory(
            new PropertyValueFactory<DisplayMap, String>("location")
        );
        table_resources.setCellValueFactory(
            new PropertyValueFactory<DisplayMap, String>("resources")
        );
        table_threats.setCellValueFactory(
            new PropertyValueFactory<DisplayMap, String>("threats")
        );
        table_difficulty.setCellValueFactory(
            new PropertyValueFactory<DisplayMap, Integer>("difficulty")
        );

        filterMaster = new DisplayMapFilter();
    }

    private void addNumbers(CheckComboBox<Integer> comboBox) {
        comboBox.getItems().addAll(1,2,3,4);
    }

    @FXML
    void fileSelectorSelected(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select ChoGGi File");
        File choggiFile = fileChooser.showOpenDialog(primaryStage);
        if(choggiFile != null) {
            choGGiParser = new ChoGGiParser();
            choGGiParser.parse(choggiFile);
            ObservableList<String> topographies = FXCollections.observableList(collectAndSort(choGGiParser.getTopographies()));
            ObservableList<String> mapTypes = FXCollections.observableList(collectAndSort(choGGiParser.getMapTypes()));
            ObservableList<String> locations = FXCollections.observableList(collectAndSort(choGGiParser.getLocations()));
            ObservableList<String> breakthroughs = FXCollections.observableList(collectAndSort(choGGiParser.getBreakthroughs()));
            ObservableList<String> breakthroughs2 = FXCollections.observableList(collectAndSort(choGGiParser.getBreakthroughs()));
            combobox_topography_options.getItems().setAll(topographies);
            combobox_maptype_options.getItems().setAll(mapTypes);
            combobox_location_options.getItems().setAll(locations);
            combobox_breakthroughplus_options.getItems().setAll(breakthroughs);
            combobox_breakthroughminus_options.getItems().setAll(breakthroughs2);

            ObservableList<DisplayMap> displayMaps = FXCollections.observableList(choGGiParser.getDisplayMaps());
            displayMapFilteredList = new FilteredList(displayMaps, o -> true);
            table.setItems(displayMapFilteredList);
            replaceListeners(displayMapFilteredList, filterMaster);
            table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            table.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
                if(newSelection != null && newSelection.getBreakthroughs() != null && newSelection.getBreakthroughs().size() > 11) {
                    mapdetails_breakthroughs1.setItems(FXCollections.observableList(newSelection.getBreakthroughs().subList(0, 4)));
                    mapdetails_breakthroughs2.setItems(FXCollections.observableList(newSelection.getBreakthroughs().subList(4, 12)));
                }
                else {
//                    mapdetails_breakthroughs1.getItems().clear();
//                    mapdetails_breakthroughs2.getItems().clear();
//                    mapdetails_breakthroughs3.getItems().clear();
                }
            });

            label_fileSelector.setText("File \""+choggiFile.getName()+"\" selected. "+choGGiParser.getMaps().size()+" rows parsed.");
        }
        else {
            label_fileSelector.setText("No file selected.");
        }
    }

    @FXML
    void advancedModeSwitched(ActionEvent event) {
        filterMaster.setAdvancedMode(checkbox_advancedbreak.isSelected());
    }

    @FXML
    void parseAdvanced(ActionEvent event) {
        if(checkbox_advancedbreak.isSelected()) {
            String advancedBreakthroughText = textarea_advancedbreak.getText();
            filterMaster.updateAdvancedBreakthrough(AdvancedBreakthroughParserUtil.parseAdvancedBreakthroughs(advancedBreakthroughText, choGGiParser.getBreakthroughs()));
        }
    }

    private void replaceListeners(FilteredList<DisplayMap> displayMapFilteredList, DisplayMapFilter filterMaster) {
        ListChangeListener<String> listener = filterMaster.genBreakthroughPlusListener(displayMapFilteredList);
        combobox_breakthroughplus_options.getCheckModel().getCheckedItems().addListener(listener);
        ListChangeListener<String> listener2 = filterMaster.genBreakthroughMinusListener(displayMapFilteredList);
        combobox_breakthroughminus_options.getCheckModel().getCheckedItems().addListener(listener2);
        ListChangeListener<Integer> listener3 = filterMaster.genThreatDustDevilsListener(displayMapFilteredList);
        combobox_resources_dustdevils.getCheckModel().getCheckedItems().addListener(listener3);
        ListChangeListener<Integer> listener4 = filterMaster.genThreatDustStormsListener(displayMapFilteredList);
        combobox_resources_duststorms.getCheckModel().getCheckedItems().addListener(listener4);
        ListChangeListener<Integer> listener5 = filterMaster.genThreatMeteorShowersListener(displayMapFilteredList);
        combobox_resources_meteorshowers.getCheckModel().getCheckedItems().addListener(listener5);
        ListChangeListener<Integer> listener6 = filterMaster.genThreatColdWavesListener(displayMapFilteredList);
        combobox_resources_coldwaves.getCheckModel().getCheckedItems().addListener(listener6);
        ListChangeListener<Integer> listener7 = filterMaster.genResourceMetalsListener(displayMapFilteredList);
        combobox_resources_metal.getCheckModel().getCheckedItems().addListener(listener7);
        ListChangeListener<Integer> listener8 = filterMaster.genResourceRareMetalsListener(displayMapFilteredList);
        combobox_resources_raremetals.getCheckModel().getCheckedItems().addListener(listener8);
        ListChangeListener<Integer> listener9 = filterMaster.genResourceConcreteListener(displayMapFilteredList);
        combobox_resources_concrete.getCheckModel().getCheckedItems().addListener(listener9);
        ListChangeListener<Integer> listener10 = filterMaster.genResourceWaterListener(displayMapFilteredList);
        combobox_resources_water.getCheckModel().getCheckedItems().addListener(listener10);
        //exact strings
        ListChangeListener<String> listener11 = filterMaster.genTopographyListener(displayMapFilteredList);
        combobox_topography_options.getCheckModel().getCheckedItems().addListener(listener11);
        ListChangeListener<String> listener12 = filterMaster.genMapTypeListener(displayMapFilteredList);
        combobox_maptype_options.getCheckModel().getCheckedItems().addListener(listener12);
        ListChangeListener<String> listener13 = filterMaster.genLocationListener(displayMapFilteredList);
        combobox_location_options.getCheckModel().getCheckedItems().addListener(listener13);
    }

    private List<String> collectAndSort(Set<String> input) {
        List<String> results = input.stream().collect(Collectors.toList());
        Collections.sort(results);
        return results;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
