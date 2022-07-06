package bg.softuni.mobilele.services;

import bg.softuni.mobilele.models.Model;
import bg.softuni.mobilele.models.Offer;
import bg.softuni.mobilele.models.User;
import bg.softuni.mobilele.models.dtos.AddOfferDto;
import bg.softuni.mobilele.repositories.ModelRepository;
import bg.softuni.mobilele.repositories.OfferRepository;
import bg.softuni.mobilele.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
}
