package az.baau.inventoryservice.service;

import az.baau.inventoryservice.dto.CatalogDTO;
import az.baau.inventoryservice.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CatalogService {
    CatalogDTO addNewCatalog(CatalogDTO catalogDTO);

    List<CatalogDTO> getAllCatalogs();

    CatalogDTO getCatalogById(Long id);

    CatalogDTO updateCatalogById(Long id,CatalogDTO catalogDTO);
    List<ProductDTO> getAllProductsByCatalog(Long catalogId);

    void deleteCatalogById(Long id);
}
