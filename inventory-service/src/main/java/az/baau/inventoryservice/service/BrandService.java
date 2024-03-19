package az.baau.inventoryservice.service;

import az.baau.inventoryservice.dto.BrandDTO;
import az.baau.inventoryservice.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BrandService {
    BrandDTO addNewBrand(BrandDTO brandDTO);

    List<BrandDTO> getAllBrands();

    BrandDTO getBrandById(Long id);

    BrandDTO updateBrandById(Long id,BrandDTO brandDTO);
    List<ProductDTO> getAllProductsByBrandId(Long brandId);

    void deleteBrandById(Long id);


}
