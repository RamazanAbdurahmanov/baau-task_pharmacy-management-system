package az.baau.inventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private LocalDateTime registerDate;
    private LocalDateTime updateDate;
    private Long catalogId;
    private Long brandId;
}
