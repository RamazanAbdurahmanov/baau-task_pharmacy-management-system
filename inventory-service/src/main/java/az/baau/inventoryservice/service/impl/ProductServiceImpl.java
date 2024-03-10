package az.baau.inventoryservice.service.impl;

import az.baau.inventoryservice.dto.ProductDTO;
import az.baau.inventoryservice.entity.Product;
import az.baau.inventoryservice.mapper.ProductMapper;
import az.baau.inventoryservice.repository.ProductRepository;
import az.baau.inventoryservice.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO addNewProduct(ProductDTO productDTO) {
        Product newProduct = ProductMapper.INSTANCE.productDTOtoProduct(productDTO);
        newProduct = productRepository.save(newProduct);
        return ProductMapper.INSTANCE.productToProductDTO(newProduct);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        products.forEach(product -> productDTOS.add(ProductMapper.INSTANCE.productToProductDTO(product)));
        return productDTOS;
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product foundProduct = optionalProduct.get();
            return ProductMapper.INSTANCE.productToProductDTO(foundProduct);
        }
        return null;
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
            updatedProduct.setUpdateDate(productDTO.getUpdateDate());
            productRepository.save(updatedProduct);
            return ProductMapper.INSTANCE.productToProductDTO(updatedProduct);
        }
        return null;

    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);

    }
}
