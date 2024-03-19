package az.baau.inventoryservice.service;

import az.baau.inventoryservice.dto.CatalogDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CatalogService {
    CatalogDTO addNewCatalog(CatalogDTO catalogDTO);

    List<CatalogDTO> getAllCatalogs();

    CatalogDTO getCatalogById(Long id);

    CatalogDTO updateCatalogById(Long id,CatalogDTO catalogDTO);

    void deleteCatalogById(Long id);
}
