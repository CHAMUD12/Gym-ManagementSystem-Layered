package lk.ijse.Musclehut.bo.Custom.impl;

import lk.ijse.Musclehut.bo.Custom.MemberBO;
import lk.ijse.Musclehut.dao.Custom.MemberDAO;
import lk.ijse.Musclehut.dao.DAOFactory;
import lk.ijse.Musclehut.dto.MemberDto;
import lk.ijse.Musclehut.entity.Member;

import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberBOImpl implements MemberBO {
    MemberDAO memberDAO = (MemberDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.MEMBER);
    @Override
    public List<MemberDto> getAllMembers() throws SQLException, ClassNotFoundException {
        List<Member> allMembers = memberDAO.getAllMembers();
        List<MemberDto> memberDtoList = new ArrayList<>();
        for (Member entity: allMembers) {
            memberDtoList.add(new MemberDto(
                    entity.getId(),
                    entity.getName(),
                    entity.getAddress(),
                    entity.getPhone(),
                    entity.getEmail()
            ));
        }
        return memberDtoList;
    }

    @Override
    public boolean saveMember(MemberDto dto) throws SQLException, ClassNotFoundException {
        Member entity = new Member(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getPhone(),
                dto.getEmail()
        );
        return memberDAO.save(entity);
    }

    @Override
    public boolean updateMember(MemberDto dto) throws SQLException, ClassNotFoundException {
        Member entity = new Member(
                dto.getId(),
                dto.getName(),
                dto.getAddress(),
                dto.getPhone(),
                dto.getEmail()
        );
        return memberDAO.update(entity);
    }

    @Override
    public MemberDto searchMember(String id) throws SQLException, ClassNotFoundException {
        Member entity = memberDAO.search(id);
        return new MemberDto(
                entity.getId(),
                entity.getName(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getEmail()
        );
    }

    @Override
    public boolean deleteMember(String id) throws SQLException, ClassNotFoundException {
        return memberDAO.delete(id);
    }
}
