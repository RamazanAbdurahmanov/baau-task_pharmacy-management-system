package az.baau.inventoryservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class CatalogDTO {
    private Long id;
    private String name;
    @JsonIgnore
    private List<ProductDTO> products;

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

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}
