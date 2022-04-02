package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.offer.BestOfferDto;
import softuni.exam.models.dto.offer.OfferImportDto;
import softuni.exam.models.dto.offer.OfferListDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
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
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final Path OFFERS_JSON_PATH = Path.of("src", "main", "resources", "files", "xml", "offers.xml");


    private final OfferRepository offerRepository;
    private final AgentRepository agentRepository;
    private final ApartmentRepository apartmentRepository;
    private final XmlParser xmlParser;
    private final ModelMapper mapper;
    private final ValidationUtil validation;

    public OfferServiceImpl(OfferRepository offerRepository, AgentRepository agentRepository, ApartmentRepository apartmentRepository, XmlParser xmlParser, @Qualifier("date") ModelMapper mapper, ValidationUtil validation) {
        this.offerRepository = offerRepository;
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;
        this.xmlParser = xmlParser;
        this.mapper = mapper;
        this.validation = validation;
    }

    @Override
    public boolean areImported() {
        return offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(OFFERS_JSON_PATH);
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        OfferListDto offerListDto = xmlParser.fromFile(OFFERS_JSON_PATH.toString(), OfferListDto.class);

        List<String > output = new ArrayList<>();
        for (OfferImportDto offerDto : offerListDto.getOffers()) {
            Optional<Agent> agent = agentRepository.findByFirstName(offerDto.getAgent().getName());
            Optional<Apartment> apartment = apartmentRepository.findById(offerDto.getApartment().getId());
            if (validation.isValid(offerDto) && agent.isPresent() && apartment.isPresent()) {
                Offer offer = mapper.map(offerDto, Offer.class);
                offer.setAgent(agent.get());
                offer.setApartment(apartment.get());
                offerRepository.save(offer);
                output.add(String.format("Successfully imported offer %.2f", offer.getPrice()));
            } else {
                output.add("Invalid offer");
            }
        }
        return String.join("\n", output);
    }

    @Override
    public String exportOffers() {
        List<BestOfferDto> bestOffers = offerRepository.findBestOffers();
        return bestOffers.stream().map(BestOfferDto::toString).collect(Collectors.joining("\n"));
    }
}
