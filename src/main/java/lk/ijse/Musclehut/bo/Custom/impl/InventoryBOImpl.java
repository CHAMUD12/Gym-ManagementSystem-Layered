package lk.ijse.Musclehut.bo.Custom.impl;

import lk.ijse.Musclehut.bo.Custom.InventoryBO;
import lk.ijse.Musclehut.dao.Custom.InventoryDAO;
import lk.ijse.Musclehut.dao.DAOFactory;
import lk.ijse.Musclehut.dto.InventoryDto;
import lk.ijse.Musclehut.entity.Inventory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryBOImpl implements InventoryBO {

    InventoryDAO inventoryDAO = (InventoryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.INVENTORY);
    @Override
    public boolean saveInventory(InventoryDto dto) throws SQLException, ClassNotFoundException {
        Inventory entity = new Inventory(
                dto.getId(),
                dto.getName(),
                dto.getCategory(),
                dto.getCount()
        );
        return inventoryDAO.save(entity);
    }

    @Override
    public boolean updateInventory(InventoryDto dto) throws SQLException, ClassNotFoundException {
        Inventory entity = new Inventory(
                dto.getId(),
                dto.getName(),
                dto.getCategory(),
                dto.getCount()
        );
        return inventoryDAO.update(entity);
    }

    @Override
    public InventoryDto searchInventory(String id) throws SQLException, ClassNotFoundException {
        Inventory entity = inventoryDAO.search(id);
        return new InventoryDto(
                entity.getId(),
                entity.getName(),
                entity.getCategory(),
                entity.getCount()
        );
    }

    @Override
    public boolean deleteInventory(String id) throws SQLException, ClassNotFoundException {
        return inventoryDAO.delete(id);
    }

    @Override
    public List<InventoryDto> loadAllInventory() throws SQLException, ClassNotFoundException {
        List<Inventory> inventories = inventoryDAO.loadAll();
        List<InventoryDto> inventoryDtoList = new ArrayList<>();

        for (Inventory entity:inventories) {
            inventoryDtoList.add(new InventoryDto(
                    entity.getId(),
                    entity.getName(),
                    entity.getCategory(),
                    entity.getCount()
            ));
        }
        return inventoryDtoList;
    }
}
