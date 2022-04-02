package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.dto.offer.BestOfferDto;
import softuni.exam.models.entity.Offer;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Query("select new softuni.exam.models.dto.offer.BestOfferDto(ag.firstName, ag.lastName, o.id, ap.area, t.townName, o.price) from Offer o join o.agent ag join o.apartment ap join ap.town t where ap.apartmentType = 'three_rooms' order by ap.area desc, o.price")
    List<BestOfferDto> findBestOffers();
}
