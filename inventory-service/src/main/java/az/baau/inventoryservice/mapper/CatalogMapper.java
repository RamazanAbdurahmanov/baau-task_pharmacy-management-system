package az.baau.inventoryservice.mapper;

import az.baau.inventoryservice.dto.CatalogDTO;
import az.baau.inventoryservice.entity.Catalog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CatalogMapper {
    CatalogMapper INSTANCE= Mappers.getMapper(CatalogMapper.class);
    CatalogDTO catalogToCatalogDTO(Catalog catalog);
    Catalog catalogDTOtoCatalog(CatalogDTO catalogDTO);

}
