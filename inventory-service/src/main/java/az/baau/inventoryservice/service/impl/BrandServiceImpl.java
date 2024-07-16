package az.baau.inventoryservice.service.impl;

import az.baau.inventoryservice.dto.BrandDTO;
import az.baau.inventoryservice.dto.ProductDTO;
import az.baau.inventoryservice.entity.Brand;
import az.baau.inventoryservice.entity.Product;
import az.baau.inventoryservice.exception.BrandNotFoundException;
import az.baau.inventoryservice.mapper.BrandMapper;
import az.baau.inventoryservice.mapper.ProductMapper;
import az.baau.inventoryservice.repository.BrandRepository;
import az.baau.inventoryservice.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
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
        if (brands.isEmpty() == false) {
            List<BrandDTO> brandDTOS = new ArrayList<>();
            for (Brand brand : brands) {
                brandDTOS.add(BrandMapper.INSTANCE.brandToBrandDTO(brand));
            }
            return brandDTOS;
        }
        throw new BrandNotFoundException("Not found any brand");

    }

    @Override
    public BrandDTO getBrandById(Long id) {
        Optional<Brand> brand = brandRepository.findById(id);
        if (brand.isPresent()) {
            return BrandMapper.INSTANCE.brandToBrandDTO(brand.get());
        } else {
            throw new BrandNotFoundException("id : " + id);
        }

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
        throw new BrandNotFoundException("Id : " + id);
    }



    @Override
    public void deleteBrandById(Long id) {
        Optional<Brand> deletedBrand = brandRepository.findById(id);
        if (deletedBrand.isPresent()) {
            brandRepository.deleteById(id);

        } else {
            throw new BrandNotFoundException("Id : " + id);
        }
    }
}
