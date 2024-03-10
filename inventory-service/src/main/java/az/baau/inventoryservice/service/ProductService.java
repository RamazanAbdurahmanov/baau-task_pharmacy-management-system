package az.baau.inventoryservice.service;

import az.baau.inventoryservice.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    ProductDTO addNewProduct(ProductDTO productDTO);

    List<ProductDTO> getAllProducts();

    ProductDTO getProductById(Long id);

    ProductDTO updateProductById(Long id,ProductDTO productDTO);

    void deleteProductById(Long id);

}
