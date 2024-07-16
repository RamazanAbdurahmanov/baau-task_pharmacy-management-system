package az.baau.inventoryservice.controller;

import az.baau.inventoryservice.dto.BrandDTO;
import az.baau.inventoryservice.dto.ProductDTO;
import az.baau.inventoryservice.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<BrandDTO> addNewBrand(@RequestBody BrandDTO brandDTO) {
        return new ResponseEntity<>(brandService.addNewBrand(brandDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BrandDTO>> getAllBrands() {
        return new ResponseEntity<>(brandService.getAllBrands(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<BrandDTO> getOneBrand(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(brandService.getBrandById(id), HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BrandDTO> updateBrandById(@PathVariable Long id, @RequestBody BrandDTO updatedBrandDto) {
        return new ResponseEntity<>(brandService.updateBrandById(id, updatedBrandDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBrandById(@PathVariable Long id) {
        brandService.deleteBrandById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }


}

