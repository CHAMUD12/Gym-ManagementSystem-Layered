package lk.ijse.Musclehut.bo.Custom;

import lk.ijse.Musclehut.bo.SuperBO;
import lk.ijse.Musclehut.dto.InventoryDto;

import java.sql.SQLException;
import java.util.List;

public interface InventoryBO extends SuperBO {
    boolean saveInventory(final InventoryDto dto) throws SQLException, ClassNotFoundException;
    boolean updateInventory(final InventoryDto dto) throws SQLException, ClassNotFoundException;
    InventoryDto searchInventory(String id) throws SQLException, ClassNotFoundException;
    boolean deleteInventory(String id) throws SQLException, ClassNotFoundException;
    List<InventoryDto> loadAllInventory() throws SQLException, ClassNotFoundException;
}
