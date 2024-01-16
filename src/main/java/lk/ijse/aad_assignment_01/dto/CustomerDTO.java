package lk.ijse.aad_assignment_01.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO {
    private String cus_id;
    private String name;
    private String nic;
    private String address;
}
