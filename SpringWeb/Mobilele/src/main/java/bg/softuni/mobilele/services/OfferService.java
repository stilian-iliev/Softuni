package bg.softuni.mobilele.services;

import bg.softuni.mobilele.models.Model;
import bg.softuni.mobilele.models.Offer;
import bg.softuni.mobilele.models.User;
import bg.softuni.mobilele.models.dtos.AddOfferDto;
import bg.softuni.mobilele.models.dtos.AllOfferDto;
import bg.softuni.mobilele.models.dtos.OfferDetailsDto;
import bg.softuni.mobilele.models.enums.Role;
import bg.softuni.mobilele.repositories.ModelRepository;
import bg.softuni.mobilele.repositories.OfferRepository;
import bg.softuni.mobilele.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OfferService {
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final ModelRepository modelRepository;
    private final ModelMapper mapper;

    public OfferService(OfferRepository offerRepository, UserRepository userRepository, ModelRepository modelRepository, ModelMapper mapper) {
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.modelRepository = modelRepository;
        this.mapper = mapper;
    }


    public void add(AddOfferDto addOfferDto, UserDetails userDetails) {
        Offer offer = mapper.map(addOfferDto, Offer.class);

        Model model = modelRepository.findByName(addOfferDto.getModel()).orElseThrow();

        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow();

        offer.setModel(model);
        offer.setSeller(user);

        offerRepository.save(offer);
    }

    public boolean isOwner(UserDetails userDetails, Long offerId) {
        if (userDetails == null) return  false;

        boolean isOwner = offerRepository.
                findById(offerId).
                filter(o -> o.getSeller().getUsername().equals(userDetails.getUsername())).
                isPresent();

        if (isOwner) {
            return true;
        }

        return userRepository.
                findByUsername(userDetails.getUsername()).
                filter(u -> u.getRole().stream().anyMatch(r -> r.getRole().equals(Role.ADMIN))).
                isPresent();
    }

    public List<AllOfferDto> findAllOfferDtos() {
        return offerRepository.findAll().stream().map(AllOfferDto::new).collect(Collectors.toList());
    }

    public OfferDetailsDto findOfferDetailsDto(long id) {
        Offer offer = offerRepository.findById(id).orElseThrow();
        return new OfferDetailsDto(offer);
    }


    public Offer findOfferById(long id) {
        return offerRepository.findById(id).orElseThrow();
    }

    public void updateOffer(long id, AddOfferDto addOfferDto) {
        Offer offer = offerRepository.findById(id).orElseThrow();

        offer.setEngine(addOfferDto.getEngine());
        offer.setDescription(addOfferDto.getDescription());
        offer.setImageUrl(addOfferDto.getImageUrl());
        offer.setMileage(addOfferDto.getMileage());
        offer.setPrice(addOfferDto.getPrice());
        offer.setTransmission(addOfferDto.getTransmission());
        offer.setYear(addOfferDto.getYear());

        Model model = modelRepository.findByName(addOfferDto.getModel()).orElseThrow();
        offer.setModel(model);

        offer.setModified(LocalDateTime.now());
        offerRepository.save(offer);
    }

    public void deleteOffer(long id) {
        offerRepository.deleteById(id);
    }
}
