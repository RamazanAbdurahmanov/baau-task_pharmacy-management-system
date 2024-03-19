package az.baau.inventoryservice.controller;

import az.baau.inventoryservice.dto.ProductDTO;
import az.baau.inventoryservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;



    @PostMapping("/create")
    public ResponseEntity<ProductDTO> addNewProduct(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.addNewProduct(productDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getALlProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getOneProduct(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDTO> updateProductById(@PathVariable(name = "id") Long id, @RequestBody ProductDTO updatedProduct) {
        return new ResponseEntity<>(productService.updateProductById(id, updatedProduct), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
        return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);

    }


}
