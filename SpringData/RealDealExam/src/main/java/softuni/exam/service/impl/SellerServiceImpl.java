package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.Seller;
import softuni.exam.models.dtos.seller.SellerImportDto;
import softuni.exam.models.dtos.seller.SellerListImportDto;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {
    private final Path SELLERS_XML_PATH = Path.of("src", "main", "resources", "files", "xml", "sellers.xml");

    private final SellerRepository sellerRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validator;
    private final ModelMapper mapper;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository, XmlParser xmlParser, ValidationUtil validator, ModelMapper mapper) {
        this.sellerRepository = sellerRepository;
        this.xmlParser = xmlParser;
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(SELLERS_XML_PATH);
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        SellerListImportDto sellerListImportDto = xmlParser.fromFile(SELLERS_XML_PATH.toString(), SellerListImportDto.class);

        List<String > output = new ArrayList<>();
        for (SellerImportDto sellerDto : sellerListImportDto.getSellers()) {
            boolean exists = sellerRepository.findByEmail(sellerDto.getEmail()).isPresent();
            if (!exists && validator.isValid(sellerDto)) {
                Seller seller = mapper.map(sellerDto, Seller.class);
                sellerRepository.save(seller);
                output.add(String.format("Successfully import seller %s - %s", seller.getLastName(), seller.getEmail()));
            } else {
                output.add("Invalid seller");
            }
        }
        return String.join("\n", output);
    }
}
