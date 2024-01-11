package lk.ijse.Musclehut.bo.Custom;

import lk.ijse.Musclehut.bo.SuperBO;
import lk.ijse.Musclehut.dto.MemberDto;
import lk.ijse.Musclehut.entity.Member;

import java.sql.SQLException;
import java.util.List;

public interface MemberBO extends SuperBO {
    List<MemberDto> getAllMembers() throws SQLException, ClassNotFoundException;
    boolean saveMember(final MemberDto dto) throws SQLException, ClassNotFoundException;
    boolean updateMember(final MemberDto dto) throws SQLException, ClassNotFoundException;
    MemberDto searchMember(String id) throws SQLException, ClassNotFoundException;
    boolean deleteMember(String id) throws SQLException, ClassNotFoundException;
}
