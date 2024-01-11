package lk.ijse.Musclehut.dao.Custom.impl;

import lk.ijse.Musclehut.dao.Custom.MemberDAO;
import lk.ijse.Musclehut.dao.SQLUtil;
import lk.ijse.Musclehut.db.DbConnection;
import lk.ijse.Musclehut.dto.MemberDto;
import lk.ijse.Musclehut.entity.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl implements MemberDAO {
    @Override
    public boolean save(Member entity) throws SQLException, ClassNotFoundException {
       return SQLUtil.execute( "INSERT INTO member VALUES(?, ?, ?, ?, ?)",
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getEmail());

    }

    @Override
    public boolean update(Member entity) throws SQLException, ClassNotFoundException {
       return SQLUtil.execute("UPDATE member SET name = ?, address = ?, phone = ?, email = ? WHERE m_id = ?",
                entity.getName(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getEmail(),
                entity.getId());

    }

    @Override
    public Member search(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = SQLUtil.execute( "SELECT * FROM member WHERE m_id = ?",id);

        Member entity = null;

        if(resultSet.next()) {
            String m_id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String phone = resultSet.getString(4);
            String email = resultSet.getString(5);

            entity = new Member(m_id, name, address, phone, email);
        }

        return entity;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM member WHERE m_id = ?",id);
    }

    @Override
    public List<Member> loadAll() throws SQLException, ClassNotFoundException {
       ResultSet resultSet = SQLUtil.execute("SELECT * FROM member");

        List<Member> memList = new ArrayList<>();

        while (resultSet.next()) {
            memList.add(new Member(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            ));
        }
        return memList;    }

    @Override
    public List<Member> getAllMembers() throws SQLException, ClassNotFoundException {
       ResultSet resultSet = SQLUtil.execute("SELECT * FROM member");

        List<Member> entityList = new ArrayList<>();

        while (resultSet.next()) {
            String m_id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            String phone = resultSet.getString(4);
            String email = resultSet.getString(5);

            var entity = new Member(m_id, name, address, phone, email);
            entityList.add(entity);
        }
        return entityList;    }

    @Override
    public String totalMemberCount() throws SQLException, ClassNotFoundException {
       ResultSet resultSet = SQLUtil.execute("SELECT COUNT(*) AS MemberCount FROM member");

        if (resultSet.next()) {
            return resultSet.getString(1);
        }
        return null;
    }
}
