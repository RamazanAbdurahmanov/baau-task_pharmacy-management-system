package az.baau.inventoryservice.service.impl;

import az.baau.inventoryservice.dto.BrandDTO;
import az.baau.inventoryservice.entity.Brand;
import az.baau.inventoryservice.mapper.BrandMapper;
import az.baau.inventoryservice.repository.BrandRepository;
import az.baau.inventoryservice.service.BrandService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public BrandDTO addNewBrand(BrandDTO brandDTO) {
        Brand newBrand = BrandMapper.INSTANCE.brandDTOToBrand(brandDTO);
        newBrand = brandRepository.save(newBrand);

        return BrandMapper.INSTANCE.brandToBrandDTO(newBrand);
    }

    @Override
    public List<BrandDTO> getAllBrands() {
        List<Brand> brands = brandRepository.findAll();
        List<BrandDTO> brandDTOS = new ArrayList<>();
        for (Brand brand : brands) {
            brandDTOS.add(BrandMapper.INSTANCE.brandToBrandDTO(brand));
        }
        return brandDTOS;
    }

    @Override
    public BrandDTO getBrandById(Long id) {
        Optional<Brand> brand = brandRepository.findById(id);
        return brand.map(BrandMapper.INSTANCE::brandToBrandDTO).orElse(null);
    }

    @Override
    public BrandDTO updateBrandById(Long id, BrandDTO brandDTO) {
        Optional<Brand> existingBrand = brandRepository.findById(id);
        if (existingBrand.isPresent()) {
            Brand brand = existingBrand.get();
            brand.setName(brandDTO.getName());
            brand = brandRepository.save(brand);
            return BrandMapper.INSTANCE.brandToBrandDTO(brand);
        }
        return null;
    }

    @Override
    public void deleteBrandById(Long id) {
        brandRepository.deleteById(id);

    }
}
