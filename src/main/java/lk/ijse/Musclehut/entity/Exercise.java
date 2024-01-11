package lk.ijse.Musclehut.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Exercise {
    private String code;
    private String description;
    private double Price;
    private int countOfMonth;
}
