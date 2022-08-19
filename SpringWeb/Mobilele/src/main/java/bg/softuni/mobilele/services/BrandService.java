package bg.softuni.mobilele.services;

import bg.softuni.mobilele.models.Brand;
import bg.softuni.mobilele.models.dtos.BrandDto;
import bg.softuni.mobilele.repositories.BrandRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {
    private BrandRepository brandRepository;

    private ModelMapper mapper;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
        this.mapper = new ModelMapper();
    }

    public List<BrandDto> findAllBrandsDtos() {
        return brandRepository.findAll().stream()
                .map(e -> mapper.map(e, BrandDto.class))
                .collect(Collectors.toList());
    }

    public List<Brand> findAllBrands() {
        return brandRepository.findAll();
    }
}
