package az.baau.inventoryservice.service.impl;

import az.baau.inventoryservice.dto.CatalogDTO;
import az.baau.inventoryservice.entity.Catalog;
import az.baau.inventoryservice.mapper.CatalogMapper;
import az.baau.inventoryservice.repository.CatalogRepository;
import az.baau.inventoryservice.service.CatalogService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CatalogServiceImpl implements CatalogService {
    private final CatalogRepository catalogRepository;

    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public CatalogDTO addNewCatalog(CatalogDTO catalogDTO) {
        Catalog newCatalog = CatalogMapper.INSTANCE.catalogDTOtoCatalog(catalogDTO);
        newCatalog = catalogRepository.save(newCatalog);
        return CatalogMapper.INSTANCE.catalogToCatalogDTO(newCatalog);
    }

    @Override
    public List<CatalogDTO> getAllCatalogs() {
        List<Catalog> catalogs = catalogRepository.findAll();
        List<CatalogDTO> catalogDTOS = new ArrayList<>();
        for (Catalog newCatalog : catalogs) {
            catalogDTOS.add(CatalogMapper.INSTANCE.catalogToCatalogDTO(newCatalog));
        }
        return catalogDTOS;
    }

    @Override
    public CatalogDTO getCatalogById(Long id) {
        Optional<Catalog> catalogs = catalogRepository.findById(id);
        if (catalogs.isPresent()) {
            Catalog foundCatalog = catalogs.get();
            return CatalogMapper.INSTANCE.catalogToCatalogDTO(foundCatalog);
        }
        return null;
    }

    @Override
    public CatalogDTO updateCatalogById(Long id, CatalogDTO catalogDTO) {
        Optional<Catalog> optionalCatalog = catalogRepository.findById(id);
        if (optionalCatalog.isPresent()) {
            Catalog updatedCatalog = optionalCatalog.get();
            updatedCatalog.setName(catalogDTO.getName());
            updatedCatalog = catalogRepository.save(updatedCatalog);
            return CatalogMapper.INSTANCE.catalogToCatalogDTO(updatedCatalog);
        }
        return null;
    }

    @Override
    public void deleteCatalogById(Long id) {
        catalogRepository.deleteById(id);

    }
}
