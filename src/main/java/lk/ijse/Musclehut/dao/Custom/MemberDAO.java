package lk.ijse.Musclehut.dao.Custom;

import lk.ijse.Musclehut.dao.CrudDAO;
import lk.ijse.Musclehut.dao.SuperDAO;
import lk.ijse.Musclehut.dto.MemberDto;
import lk.ijse.Musclehut.entity.Member;

import java.sql.SQLException;
import java.util.List;

public interface MemberDAO extends CrudDAO <Member> {
    List<Member> getAllMembers() throws SQLException, ClassNotFoundException;
    String totalMemberCount() throws SQLException, ClassNotFoundException;
}

