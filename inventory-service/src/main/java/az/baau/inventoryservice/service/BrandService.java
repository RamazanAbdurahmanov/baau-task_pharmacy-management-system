package az.baau.inventoryservice.service;

import az.baau.inventoryservice.dto.BrandDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {
    BrandDTO addNewBrand(BrandDTO brandDTO);

    List<BrandDTO> getAllBrands();

    BrandDTO getBrandById(Long id);

    BrandDTO updateBrandById(Long id);

    void deleteBrandById(Long id);


}
