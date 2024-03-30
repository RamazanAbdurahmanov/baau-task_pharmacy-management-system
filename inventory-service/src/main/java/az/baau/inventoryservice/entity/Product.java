package az.baau.inventoryservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Dermanlar")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    @NotEmpty(message="Boş qoymaq olmaz")
    @Size(min=2, message="Minimum 2 simvol yazila biler")
    @Size(max=30, message="maksimum 30 simvol yazila biler")
    private String name;
    @Size(max=30, message="maksimum 30 simvol yazila biler")
    private String description;
    @Min(value=0,message="Minimum 0 qiymet vermek olar")
    @Max(value=100000,message="Maksimum 1000000 qiymet vermek olar")
    @NotNull(message="boş qoymaq olmaz!")
    private double price;
    @Min(value=1,message="Product sayı minimum 1 ola bilər")
    @Max(value=1000000,message="Product sayı maksimum 1000000 ola bilər")
    private int quantity;
    private LocalDateTime registerDate;
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "catalog_id")
    @JsonIgnore
    private Catalog catalog;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    @JsonIgnore
    private Brand brand;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }
}
