package lk.ijse.Musclehut.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.Musclehut.bo.BOFactory;
import lk.ijse.Musclehut.bo.Custom.InventoryBO;
import lk.ijse.Musclehut.dto.InventoryDto;
import lk.ijse.Musclehut.view.tdm.InventoryTm;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class InventoryFormController {
    @FXML
    private TableColumn<?, ?> colCategory;

    @FXML
    private TableColumn<?, ?> colCount;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private AnchorPane pane;

    @FXML
    private TableView<InventoryTm> tblInventory;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtCount;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    InventoryBO inventoryBO = (InventoryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.INVENTORY);

    public void initialize() {
        setCellValueFactory();
        loadAllInventory();
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colCount.setCellValueFactory(new PropertyValueFactory<>("count"));

    }
    private void loadAllInventory() {

        ObservableList<InventoryTm> obList = FXCollections.observableArrayList();

        try {
            List<InventoryDto> dtoList = inventoryBO.loadAllInventory();

            for(InventoryDto dto : dtoList) {
                obList.add(
                        new InventoryTm(
                                dto.getId(),
                                dto.getName(),
                                dto.getCategory(),
                                dto.getCount()
                        )
                );
            }

            tblInventory.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtId.getText();

        try {
            boolean isDeleted = inventoryBO.deleteInventory(id);

            if(isDeleted) {
                tblInventory.refresh();
                new Alert(Alert.AlertType.CONFIRMATION, "inventory deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        boolean isInventoryIDValidated = ValidateInventory();
        boolean isInventoryNameValidated = ValidateInventory();
        boolean isInventoryCategoryValidated = ValidateInventory();
        boolean isInventoryCountValidated = ValidateInventory();

        if (isInventoryIDValidated && isInventoryNameValidated && isInventoryCategoryValidated && isInventoryCountValidated ) {

            String id = txtId.getText();
            String name = txtName.getText();
            String category = txtCategory.getText();
            String count = txtCount.getText();

            var dto = new InventoryDto(id, name, category, count);

            try {
                boolean isSaved = inventoryBO.saveInventory(dto);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "inventory saved!").show();
                    clearFields();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
    void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtCategory.setText("");
        txtCount.setText("");
    }

    private boolean ValidateInventory() {

        String idText = txtId.getText();
        boolean isInventoryIDValidated = Pattern.compile("[I][0-9]{3}").matcher(idText).matches();
        if (!isInventoryIDValidated) {
            new Alert(Alert.AlertType.ERROR, "invalid inventory id!").show();
            return false;
        }

        String nameText = txtName.getText();
        boolean isInventoryNameValidated = Pattern.compile("^[A-Za-z]+([ '-][A-Za-z]+)*$").matcher(nameText).matches();
        if (!isInventoryNameValidated) {
            new Alert(Alert.AlertType.ERROR, "invalid inventory name!").show();
            return false;
        }

        String categoryText = txtCategory.getText();
        boolean isInventoryCategoryValidated = Pattern.compile("^[A-Za-z]+([ '-][A-Za-z]+)*$").matcher(categoryText).matches();
        if (!isInventoryCategoryValidated) {
            new Alert(Alert.AlertType.ERROR, "invalid inventory category!").show();
            return false;
        }

        String countText = txtCount.getText();
        boolean isInventoryCountValidated = Pattern.compile("[0-9](.*)").matcher(countText).matches();
        if (!isInventoryCountValidated) {
            new Alert(Alert.AlertType.ERROR, "invalid inventory count!").show();
            return false;
        }
        return true;
    }
    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String category = txtCategory.getText();
        String count = txtCount.getText();

        var dto = new InventoryDto(id, name, category, count);

        try {
            boolean isUpdated = inventoryBO.updateInventory(dto);
            System.out.println(isUpdated);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "inventory updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void txtSearchOnAction(ActionEvent event) {
        String id = txtId.getText();

        try {
            InventoryDto dto = inventoryBO.searchInventory(id);

            if(dto != null) {
                fillFields(dto);
            } else {
                new Alert(Alert.AlertType.INFORMATION, "inventory not found!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void fillFields(InventoryDto dto) {
        txtId.setText(dto.getId());
        txtName.setText(dto.getName());
        txtCategory.setText(dto.getCategory());
        txtCount.setText(dto.getCount());
    }
}
