package exam.service.impl;

import exam.model.shop.Shop;
import exam.model.shop.ShopImportDto;
import exam.model.shop.ShopListImportDto;
import exam.model.town.Town;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.ShopService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    private static final Path SHOPS_XML_PATH = Path.of("src", "main", "resources", "files", "xml", "shops.xml");
    private final ShopRepository shopRepository;
    private final TownRepository townRepository;

    private final ModelMapper mapper;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, TownRepository townRepository) {
        this.shopRepository = shopRepository;
        this.townRepository = townRepository;
        mapper = new ModelMapper();
    }

    @Override
    public boolean areImported() {
        return shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(SHOPS_XML_PATH);
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(ShopListImportDto.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ShopListImportDto shopsListDto = (ShopListImportDto) unmarshaller.unmarshal(new File(SHOPS_XML_PATH.toString()));

        List<String> output = new ArrayList<>();
        for (ShopImportDto shopDto : shopsListDto.getShops()) {
            if (shopDto.validate()) {
                if (shopRepository.findByName(shopDto.getName()) != null) {
                    output.add("Duplicate shop");
                } else {
                    Shop shop = mapper.map(shopDto, Shop.class);
                    Town town = townRepository.findByName(shop.getTown().getName());
                    shop.setTown(town);
                    shopRepository.save(shop);
                    output.add(String.format("Successfully imported Shop %s - %s", shop.getName(), shop.getIncome()));
                }
            } else {
                output.add("Invalid shop");
            }
        }
        return String.join("\n", output);
    }
}
