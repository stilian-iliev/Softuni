package exam.service.impl;

import com.google.gson.Gson;
import exam.model.laptop.Laptop;
import exam.model.laptop.LaptopImportDto;
import exam.model.laptop.WarrantyType;
import exam.model.shop.Shop;
import exam.repository.LaptopRepository;
import exam.repository.ShopRepository;
import exam.service.LaptopService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LaptopServiceImpl implements LaptopService {
    private final Path LAPTOPS_JSON_PATH = Path.of("src", "main", "resources", "files", "json", "laptops.json");

    private final LaptopRepository laptopRepository;
    private final ShopRepository shopRepository;

    private final Gson gson;
    private final ModelMapper mapper;

    @Autowired
    public LaptopServiceImpl(LaptopRepository laptopRepository, ShopRepository shopRepository) {
        this.laptopRepository = laptopRepository;
        this.shopRepository = shopRepository;
        gson = new Gson();
        mapper = new ModelMapper();
        mapper.addConverter(new Converter<String, WarrantyType>() {
            @Override
            public WarrantyType convert(MappingContext<String, WarrantyType> mappingContext) {
                return WarrantyType.valueOf(mappingContext.getSource());
            }
        });
    }

    @Override
    public boolean areImported() {
        return laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(LAPTOPS_JSON_PATH);
    }

    @Override
    public String importLaptops() throws IOException {
        LaptopImportDto[] laptopImportDtos = gson.fromJson(new FileReader(LAPTOPS_JSON_PATH.toString()), LaptopImportDto[].class);
        List<String> output = new ArrayList<>();
        for (LaptopImportDto laptopDto : laptopImportDtos) {
            if (laptopDto.valid() && laptopRepository.findByMacAddress(laptopDto.getMacAddress()) == null){
                Laptop laptop = mapper.map(laptopDto, Laptop.class);
                Shop shop = shopRepository.findByName(laptop.getShop().getName());
                laptop.setShop(shop);
                laptopRepository.save(laptop);
                output.add(String.format("Successfully imported Laptop %s - %.2f - %d - %d", laptop.getMacAddress(), laptop.getCpuSpeed(), laptop.getRam(), laptop.getStorage()));
            } else {
                output.add("Invalid Laptop");
            }
        }

        return String.join("\n", output);
    }

    @Override
    public String exportBestLaptops() {
        List<Laptop> bestLaptops = laptopRepository.findBestLaptops();
        return bestLaptops.stream().map(Laptop::toString).collect(Collectors.joining("\n\n"));
    }
}
