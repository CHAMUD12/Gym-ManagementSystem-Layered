package lk.ijse.Musclehut.entity;

import lk.ijse.Musclehut.view.tdm.CartTm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class PayShedule {
    private String sheduleId;
    private String memId;
    private LocalDate date;
    private List<CartTm> tmList = new ArrayList<>();
}
