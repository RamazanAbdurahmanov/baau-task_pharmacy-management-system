package az.baau.inventoryservice.mapper;

import az.baau.inventoryservice.dto.BrandDTO;
import az.baau.inventoryservice.entity.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BrandMapper {
    BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

    BrandDTO brandToBrandDTO(Brand brand);

    Brand brandDTOToBrand(BrandDTO brandDTO);


}
