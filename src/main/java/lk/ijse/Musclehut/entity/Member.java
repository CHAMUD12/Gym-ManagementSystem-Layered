package lk.ijse.Musclehut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Member {
    private String id;
    private String name;
    private String address;
    private String phone;
    private String email;
}
