package az.baau.inventoryservice.controller;

import az.baau.inventoryservice.dto.ProductDTO;
import az.baau.inventoryservice.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;



    @PostMapping
    public ResponseEntity<ProductDTO> addNewProduct(@Valid @RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.addNewProduct(productDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getALlProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ProductDTO>>getOneProduct(@PathVariable(name = "id") Long id) {
        ProductDTO productDTO = productService.getProductById(id);
        //Burada Hateos istifade eledim . bu bir like sorgu atdiqda bagli olan diger metod linklerini de teklif kimi geri dondurur
        EntityModel<ProductDTO> model=EntityModel.of(productDTO);
        WebMvcLinkBuilder linkToProducts=linkTo(methodOn(this.getClass()).getALlProducts());
        model.add(linkToProducts.withRel("all-products"));
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProductById(@PathVariable(name = "id") Long id,@Valid @RequestBody ProductDTO updatedProduct) {
        return new ResponseEntity<>(productService.updateProductById(id, updatedProduct), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
        return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);

    }


}
