package az.baau.inventoryservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "Dermanlar")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    private String description;
    private double price;
    private int quantity;
    private LocalDateTime registerDate;
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "catalog_id", nullable = false)
    private Catalog catalog;
    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;
}
