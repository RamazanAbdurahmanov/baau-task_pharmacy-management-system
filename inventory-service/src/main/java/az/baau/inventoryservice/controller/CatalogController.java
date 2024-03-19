package az.baau.inventoryservice.controller;

import az.baau.inventoryservice.dto.CatalogDTO;
import az.baau.inventoryservice.dto.ProductDTO;
import az.baau.inventoryservice.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("catalogs")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;


    @PostMapping("/create")
    public ResponseEntity<CatalogDTO> addNewCatalog(@RequestBody CatalogDTO catalogDTO) {
        return new ResponseEntity<>(catalogService.addNewCatalog(catalogDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CatalogDTO>> getAllCatalogs() {
        return new ResponseEntity<>(catalogService.getAllCatalogs(), HttpStatus.OK);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<List<ProductDTO>> getAllProductsByCatalogId(@PathVariable Long id){

        return new ResponseEntity<>(catalogService.getAllProductsByCatalog(id),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatalogDTO> getOneCatalog(@PathVariable Long id) {
        return new ResponseEntity<>(catalogService.getCatalogById(id), HttpStatus.FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CatalogDTO> updateCatalogById(@PathVariable Long id, @RequestBody CatalogDTO updatedCatalogDTO) {
        return new ResponseEntity<>(catalogService.updateCatalogById(id, updatedCatalogDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCatalogById(@PathVariable Long id) {
        catalogService.deleteCatalogById(id);
        return new ResponseEntity<>("Successfully Deleted ", HttpStatus.OK);
    }
}
