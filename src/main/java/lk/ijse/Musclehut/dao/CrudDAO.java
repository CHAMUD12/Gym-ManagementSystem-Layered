package lk.ijse.Musclehut.dao;

import lk.ijse.Musclehut.dto.MemberDto;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO <T> extends SuperDAO {
    boolean save(final T entity) throws SQLException, ClassNotFoundException;
    boolean update(final T entity) throws SQLException, ClassNotFoundException;
    T search(String id) throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;
    List<T> loadAll() throws SQLException, ClassNotFoundException;
}
