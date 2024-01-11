package lk.ijse.Musclehut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Inventory {
    private String id;
    private String name;
    private String category;
    private String count;
}
