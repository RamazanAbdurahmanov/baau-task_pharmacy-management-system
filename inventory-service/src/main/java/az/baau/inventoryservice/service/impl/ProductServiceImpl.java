package az.baau.inventoryservice.service.impl;

import az.baau.inventoryservice.dto.ProductDTO;
import az.baau.inventoryservice.entity.Product;
import az.baau.inventoryservice.exception.ProductNotFoundException;
import az.baau.inventoryservice.mapper.ProductMapper;
import az.baau.inventoryservice.repository.ProductRepository;
import az.baau.inventoryservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final LocalDateTime localDateTime = LocalDateTime.now();

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO addNewProduct(ProductDTO productDTO) {
        Product newProduct = ProductMapper.INSTANCE.productDTOtoProduct(productDTO);
        newProduct.setRegisterDate(localDateTime);
        newProduct = productRepository.save(newProduct);
        return ProductMapper.INSTANCE.productToProductDTO(newProduct);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty() == false) {
            List<ProductDTO> productDTOS = new ArrayList<>();
            products.forEach(product -> productDTOS.add(ProductMapper.INSTANCE.productToProductDTO(product)));
            return productDTOS;
        }
        throw new ProductNotFoundException("Not Found Any Product");
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product foundProduct = optionalProduct.get();
            return ProductMapper.INSTANCE.productToProductDTO(foundProduct);
        }
        throw new ProductNotFoundException("Id : " + id);
    }

    @Override
    public ProductDTO updateProductById(Long id, ProductDTO productDTO) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product updatedProduct = optionalProduct.get();
            updatedProduct.setName(productDTO.getName());
            updatedProduct.setPrice(productDTO.getPrice());
            updatedProduct.setDescription(productDTO.getDescription());
            updatedProduct.setQuantity(productDTO.getQuantity());
            updatedProduct.setUpdateDate(localDateTime);
            productRepository.save(updatedProduct);
            return ProductMapper.INSTANCE.productToProductDTO(updatedProduct);
        }
        throw new ProductNotFoundException("Id : " + id);

    }

    @Override
    public void deleteProductById(Long id) {
        Optional<Product> deletedProduct = productRepository.findById(id);
        if (deletedProduct.isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new ProductNotFoundException("Id : " + id);

        }
    }
}