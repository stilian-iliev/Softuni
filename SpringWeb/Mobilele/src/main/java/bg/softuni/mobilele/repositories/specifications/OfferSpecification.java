package bg.softuni.mobilele.repositories.specifications;

import bg.softuni.mobilele.models.Offer;
import bg.softuni.mobilele.models.dtos.SearchOfferDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class OfferSpecification implements Specification<Offer> {
    private final SearchOfferDto searchOfferDTO;

    public OfferSpecification(SearchOfferDto searchOfferDTO) {
        this.searchOfferDTO = searchOfferDTO;
    }

    @Override
    public Predicate toPredicate(Root<Offer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate p = criteriaBuilder.conjunction();

        if (searchOfferDTO.getModel() != null && !searchOfferDTO.getModel().isEmpty()) {
            p.getExpressions().add(
                    criteriaBuilder.and(criteriaBuilder.equal(root.join("model").get("name"), searchOfferDTO.getModel()))
            );
        }

        if (searchOfferDTO.getMinPrice() != null) {
            p.getExpressions().add(
                    criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), searchOfferDTO.getMinPrice()))
            );
        }

        if (searchOfferDTO.getMaxPrice() != null) {
            p.getExpressions().add(
                    criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(root.get("price"), searchOfferDTO.getMaxPrice()))
            );
        }

        return p;
    }
}
