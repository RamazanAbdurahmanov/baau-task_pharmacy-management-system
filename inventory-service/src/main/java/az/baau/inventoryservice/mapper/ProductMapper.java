package az.baau.inventoryservice.mapper;

import az.baau.inventoryservice.dto.ProductDTO;
import az.baau.inventoryservice.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mappings({
            @Mapping(source = "catalog.id", target = "catalogId"),
            @Mapping(source = "brand.id", target = "brandId")
    })
    ProductDTO productToProductDTO(Product product);

    @Mappings({
            @Mapping(target = "catalog.id", source = "catalogId"),
            @Mapping(target = "brand.id", source = "brandId"),
            @Mapping(target = "registerDate", ignore = true),
            @Mapping(target = "updateDate", ignore = true)
    })
    Product productDTOtoProduct(ProductDTO productDTO);


}
