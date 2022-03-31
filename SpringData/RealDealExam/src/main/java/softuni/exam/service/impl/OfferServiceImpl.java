package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import softuni.exam.models.Car;
import softuni.exam.models.Offer;
import softuni.exam.models.Seller;
import softuni.exam.models.dtos.offer.OfferImportDto;
import softuni.exam.models.dtos.offer.OfferListImportDto;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {
    private final Path OFFER_XML_PATH = Path.of("src", "main", "resources", "files", "xml", "offers.xml");

    private final OfferRepository offerRepository;
    private final CarRepository carRepository;
    private final SellerRepository sellerRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validator;
    private final ModelMapper mapper;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository, CarRepository carRepository, SellerRepository sellerRepository, XmlParser xmlParser, ValidationUtil validator, @Qualifier("dateTime") ModelMapper mapper) {
        this.offerRepository = offerRepository;
        this.carRepository = carRepository;
        this.sellerRepository = sellerRepository;
        this.xmlParser = xmlParser;
        this.validator = validator;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(OFFER_XML_PATH);
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        OfferListImportDto offerListImportDto = xmlParser.fromFile(OFFER_XML_PATH.toString(), OfferListImportDto.class);

        List<String> output = new ArrayList<>();
        for (OfferImportDto offerDto : offerListImportDto.getOffers()) {
            if (validator.isValid(offerDto)) {
                Offer offer = mapper.map(offerDto, Offer.class);
                Optional<Car> car = carRepository.findById(offerDto.getCar().getId());
                Optional<Seller> seller = sellerRepository.findById(offerDto.getSeller().getId());
                if (offerRepository.findByDescriptionAndAddedOn(offer.getDescription(), offer.getAddedOn()).isPresent() || car.isEmpty() || seller.isEmpty()) {
                    output.add("Invalid offer");
                    break;
                }
                offer.setCar(car.get());
                offer.setSeller(seller.get());
                offerRepository.save(offer);
                output.add(String.format("Successfully import offer %s - %s", offer.getAddedOn(), offer.isHasGoldStatus()));
            } else {
                output.add("Invalid offer");
            }
        }
        return String.join("\n", output);
    }
}
